package Game;

import Character.AbillityExec;
import Lobby.LobbyUser;
import Played.Played;
import Stats.Stats;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import Stats.StatsMgr;
import Yep.SenderObject;
import Yep.Start;
import Character.Fightlog;
import org.hibernate.PessimisticLockException;
import org.hibernate.Session;

import static Yep.Instruction.GAMEFINISCHED;

public class Game {

    private AbillityExec abillityecex;
    private ArrayList<LobbyUser> users;
    private boolean gameWon = false;
    private int sec, min;

    public Game ( ArrayList<LobbyUser> users) {
        this.users = users;
        abillityecex = new AbillityExec(users);
    }


    public void start() {
        for (LobbyUser u : users) {
            u.getUser().setAbillity(abillityecex);
        }
        updateGameTime();
        checkIfWon();

    }

    public void updateGameTime() {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        ses.scheduleAtFixedRate(()-> {
            if(gameWon) ses.shutdownNow();
            if(sec == 59) {
                min++;
                sec = 0;
            }else {
                sec++;
            }

        }, 1, 1, TimeUnit.SECONDS);

    }

    public void gameWon(int teamWon) {

        SenderObject so = new SenderObject(GAMEFINISCHED);
        users.forEach((u) -> {
            try {
                u.getUser().getObjectOutputStream().writeObject(so);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        HashMap<LobbyUser, Stats> userStats = new HashMap<LobbyUser, Stats>();
        for(LobbyUser u : users) {
            userStats.put(u, StatsMgr.load(u.getUser().getUser().getId()));
        }
        ArrayList<Played> toUpdate = new ArrayList<Played>();
        ArrayList<Fightlog> toUpdateF = new ArrayList<Fightlog>();
        userStats.forEach((user, stats)  -> {
            if(stats.getMinutesPlayed() + min > 59) {
                stats.setHoursPlayed(stats.getHoursPlayed() +1 );
                stats.setMinutesPlayed(min - (60 - stats.getMinutesPlayed()));
            }
            if(user.getCharackter().getHp() > 0) {
                stats.setDeaths(stats.getDeaths() + 1);
            }
            int killCounter = 0;
            for(LobbyUser lu : users) {
                if(lu.getTeam() != user.getTeam()) {
                    if(lu.getCharackter().getHp() == 0) {
                        killCounter++;
                    }
                }
            }
            stats.setKills(stats.getKills() + killCounter);


            for(Played p : stats.getPlayed()) {
                if(p.getCharId().getId() == user.getCharackter().getId()) {
                    p.setGames(p.getGames() +1 );
                    if(user.getTeam() == teamWon) p.setWins(p.getWins() +1);
                    toUpdate.add(p);
                }
            }


            //TODO figthlog
            ArrayList<LobbyUser> mates = new ArrayList<>();
            ArrayList<LobbyUser> enemys = new ArrayList<>();
            for (LobbyUser u :  users) {
                if(u.getUser().getUser().getId() != user.getUser().getUser().getId()) {
                    if(u.getTeam() == user.getTeam()) {
                        mates.add(u);
                    }else {
                        enemys.add(u);
                    }
                }
            }

            Fightlog f = new Fightlog((teamWon == user.getTeam()), (user.getCharackter().getHp() > 0), killCounter, (min + ":" + sec), LocalDateTime.now().toString(),
                                       user.getUser().getUser(), mates.get(0).getUser().getUser(), mates.get(1).getUser().getUser(),
                                       enemys.get(0).getUser().getUser() , enemys.get(1).getUser().getUser(), enemys.get(2).getUser().getUser(),
                                       user.getCharackter(), mates.get(0).getCharackter(), mates.get(1).getCharackter(),
                                       enemys.get(0).getCharackter() , enemys.get(1).getCharackter(), enemys.get(2).getCharackter()
            );
            toUpdateF.add(f);

        });

        Session s = Start.getHibernateUtil().getSessionFactory().getCurrentSession();
        try {
            s.beginTransaction();
            toUpdate.forEach(s::update);
            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
        }

        Session s2 = Start.getHibernateUtil().getSessionFactory().getCurrentSession();
        s2.beginTransaction();
        userStats.forEach((user, stats)  -> {
            s2.update(stats);
        });
        s2.getTransaction().commit();

        Session s3 = Start.getHibernateUtil().getSessionFactory().getCurrentSession();
        s3.beginTransaction();
        toUpdateF.forEach(s3::save);
        s3.getTransaction().commit();

    }

    public void checkIfWon() {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        ses.scheduleAtFixedRate(() -> {
            for (LobbyUser u : users) {
                if(u.getTeam() == 0) {
                    if(u.getCharackter().getHp() > 0) {
                        break;
                    }
                    gameWon = true;
                    gameWon(0);
                }

            }
            for (LobbyUser u : users) {
                if(u.getTeam() == 1) {
                    if(u.getCharackter().getHp() > 0) {
                        break;
                    }
                    gameWon = true;
                    gameWon(1);
                }

            }


        }, 20 , 3, TimeUnit.SECONDS);


    }


}
