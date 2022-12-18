package Charackter;

import Lobby.LobbyUser;
import Yep.SenderObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AbillityExec implements Serializable {

    private ArrayList<LobbyUser> users;

    public AbillityExec(ArrayList<LobbyUser> users) {
        this.users = users;
    }

    public void execAbility(SenderObject so) {
        int ab = so.getAb();
        switch (so.getCharacter().getId()) {
            case 1 -> {
                switch (ab) {
                    case 0 -> {
                        for(LobbyUser u : users) {
                            if(u.getUser().getUser().getId() == so.getUser().getId()) {
                                u.getCharackter().setHp(u.getCharackter().getHp() + (int) ((u.getCharackter().getMaxHp() -u.getCharackter().getHp())*0.02));
                                break;
                            }
                        }
                    }
                    case  1 -> {
                        int shield = (int) (so.getCharacter().getHp() * 0.1);
                        for(LobbyUser  u : users) {
                            if(u.getUser().getUser().getId() == so.getUser().getId()) {
                                Character c = u.getCharackter();
                                c.setShield(shield);
                                ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
                                ses.schedule(()-> {
                                    if(c.getShield() > 0) {
                                        if(c.getShield() - shield < 0) {
                                            c.setShield(0);
                                        }else {
                                            c.setShield(c.getShield()-shield);
                                        }

                                    }
                                },2500, TimeUnit.MILLISECONDS);
                                break;
                            }
                        }
                    }
                    case  2 -> {
                        AtomicInteger count = new AtomicInteger();
                        AtomicInteger ap = new AtomicInteger();
                        for (LobbyUser lu : users) {
                            if(lu.getUser().getUser().getId() == so.getUser().getId()) {
                                ap.set(lu.getCharackter().getAp());
                                break;
                            }
                        }
                        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
                        ses.scheduleAtFixedRate(()-> {
                            if( count.get() == 5 ) ses.shutdown();
                            else {
                                makeDMG(so,false, 20 + (ap.get() * 5));
                            }
                            count.getAndIncrement();
                        },0,1,TimeUnit.SECONDS);
                    }
                    case  3 -> {
                        AtomicInteger ad = new AtomicInteger();
                        for (LobbyUser lu : users) {
                            if(lu.getUser().getUser().getId() == so.getUser().getId()) {
                                ad.set(lu.getCharackter().getAp());
                                break;
                            }
                        }
                        makeDMG(so, false, 120 + ad.get());
                    }
                    case  4-> {
                        int ad, ap;
                        LobbyUser lu = getUser(so);
                        ad = (int) (lu.getCharackter().getHp() * 0.05);
                        ap = (int) (lu.getCharackter().getHp() * 0.01) / 2 ;

                        lu.getCharackter().setAp(lu.getCharackter().getAp() + ap);
                        lu.getCharackter().setAd(lu.getCharackter().getAd() + ad);

                        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
                        ses.schedule(()-> {
                            lu.getCharackter().setAp(lu.getCharackter().getAp() - ap);
                            lu.getCharackter().setAd(lu.getCharackter().getAd() - ad);
                        }, 10, TimeUnit.SECONDS);


                    }
                }
            }
            case 2 -> {
                switch (ab) {
                    case 0 -> {
                        LobbyUser lu = getUser(so);
                        lu.getCharackter().setAp(lu.getCharackter().getAp() + 1);
                        lu.getCharackter().setAd(lu.getCharackter().getAd() + 5);
                    }
                    case  1 -> {
                        LobbyUser lu = getUser(so);
                        makeDMG(so, true, 40 + lu.getCharackter().getAp());
                    }
                    case  2 -> {
                        LobbyUser lu = getUser(so);
                        makeDMG(so, false, 120 + lu.getCharackter().getAd());
                        lu.getCharackter().setHp( lu.getCharackter().getHp() + (int) ((120 + lu.getCharackter().getAd()) * 0.1));
                    }
                    case  3 -> {

                    }
                    case  4-> {

                    }

                }
            }
            case 3 -> {

                switch (ab) {
                    case 0 -> {

                    }
                    case  1 -> {

                    }
                    case  2 -> {

                    }
                    case  3 -> {

                    }
                    case  4-> {

                    }

                }
            }
            case 4 -> {
                switch (ab) {
                    case 0 -> {

                    }
                    case  1 -> {

                    }
                    case  2 -> {

                    }
                    case  3 -> {

                    }
                    case  4-> {

                    }

                }
            }
            case 5 -> {
                switch (ab) {
                    case 0 -> {

                    }
                    case  1 -> {

                    }
                    case  2 -> {

                    }
                    case  3 -> {

                    }
                    case  4-> {

                    }

                }
            }
            case 6 -> {
                switch (ab) {
                    case 0 -> {

                    }
                    case  1 -> {

                    }
                    case  2 -> {

                    }
                    case  3 -> {

                    }
                    case  4-> {

                    }

                }
            }
            case 7 -> {
                switch (ab) {
                    case 0 -> {

                    }
                    case  1 -> {
                        int ap = getUser(so).getCharackter().getAp();
                        heal(so, true, 100 + 5*ap );
                    }
                    case  2 -> {

                    }
                    case  3 -> {

                    }
                    case  4-> {

                    }

                }
            }
            case 8 -> {
                switch (ab) {
                    case 0 -> {

                    }
                    case  1 -> {

                    }
                    case  2 -> {

                    }
                    case  3 -> {

                    }
                    case  4-> {

                    }

                }
            }
            case 9 -> {
                switch (ab) {
                    case 0 -> {

                    }
                    case  1 -> {

                    }
                    case  2 -> {

                    }
                    case  3 -> {

                    }
                    case  4-> {

                    }

                }
            }

            default -> {

            }
        }


    }

    public LobbyUser getUser(SenderObject so) {
        for (LobbyUser lu : users) {
            if(lu.getUser().getUser().getId() == so.getUser().getId()) {
                return lu;
            }
        }
        return null;
    }

    public void makeDMG(SenderObject so, boolean aoe, int dmg) {
        int team = 0;
        if(aoe) {
            for(LobbyUser u : users) {
                if(u.getTeam() != team) {
                    if (u.getCharackter().getHp() > 0) {
                        u.getCharackter().setHp(u.getCharackter().getHp() - dmg);
                    }
                }
            }

        }else {

            for (LobbyUser u : users) {
                if(u.getUser().getUser().getId() == so.getUser().getId()) {
                    team = u.getTeam();
                }
            }

            for(LobbyUser u : users) {
                if(u.getTeam() == team) {
                } else {
                    if(u.getCharackter().getKlasse().equalsIgnoreCase("tank")) {
                        if(u.getCharackter().getHp() > 0) {
                            if(u.getCharackter().getShield() > 0) {
                                if(u.getCharackter().getShield() - dmg < 0) {
                                    int _tmp = dmg - u.getCharackter().getShield();
                                    u.getCharackter().setHp(u.getCharackter().getHp() - _tmp );
                                    u.getCharackter().setShield(0);
                                }else {
                                    u.getCharackter().setShield(u.getCharackter().getShield() - dmg);
                                }
                            }else {
                                u.getCharackter().setHp(u.getCharackter().getHp() - dmg);
                            }

                        }else {
                            for (LobbyUser lu : users) {
                                if (lu.getTeam() == team) {

                                }else {
                                    if(lu.getCharackter().getKlasse().equalsIgnoreCase("dps")) {
                                        if(lu.getCharackter().getHp() > 0) {
                                            if(u.getCharackter().getShield() > 0) {
                                                if(u.getCharackter().getShield() - dmg < 0) {
                                                    int _tmp = dmg - u.getCharackter().getShield();
                                                    u.getCharackter().setHp(u.getCharackter().getHp() - _tmp );
                                                    u.getCharackter().setShield(0);
                                                }else {
                                                    u.getCharackter().setShield(u.getCharackter().getShield() - dmg);
                                                }
                                            }else {
                                                u.getCharackter().setHp(u.getCharackter().getHp() - dmg);
                                            }
                                        }else {
                                            for (LobbyUser lou : users) {
                                                if (lou.getTeam() == team) {

                                                }else {
                                                    if(lou.getCharackter().getKlasse().equalsIgnoreCase("sup")) {
                                                        if(lou.getCharackter().getHp() > 0) {
                                                            if(u.getCharackter().getShield() > 0) {
                                                                if(u.getCharackter().getShield() - dmg < 0) {
                                                                    int _tmp = dmg - u.getCharackter().getShield();
                                                                    u.getCharackter().setHp(u.getCharackter().getHp() - _tmp );
                                                                    u.getCharackter().setShield(0);
                                                                }else {
                                                                    u.getCharackter().setShield(u.getCharackter().getShield() - dmg);
                                                                }
                                                            }else {
                                                                u.getCharackter().setHp(u.getCharackter().getHp() - dmg);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void heal(SenderObject so, boolean all, int heath) {
        if(all) {
            LobbyUser u = getUser(so);
            for (LobbyUser lu : users) {
                if(lu.getTeam() == u.getTeam()) {
                    if(u.getCharackter().getHp() > 0) {
                        if( u.getCharackter().getHp() + heath > u.getCharackter().getMaxHp()) {
                            u.getCharackter().setHp(u.getCharackter().getMaxHp());
                        }else {
                            u.getCharackter().setHp(u.getCharackter().getHp() + heath);
                        }
                    }

                }
            }
        }
    }
}
