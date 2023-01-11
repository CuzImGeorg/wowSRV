 package Character;

import Lobby.LobbyUser;
import Yep.SenderObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class AbillityExec implements Serializable {

    private ArrayList<LobbyUser> users;
    private final Random r;

    public AbillityExec(ArrayList<LobbyUser> users) {
        this.users = users;
        r = new Random();
    }

    public void execAbility(SenderObject so) {
        int ab = so.getAb();

        switch (getUser(so).getCharackter().getId()) {
            case 1 -> {
                switch (ab) {
                    case 0 -> {
                        LobbyUser u = getUser(so);
                        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
                        ses.scheduleAtFixedRate(() -> {
                            if(u.getCharackter().getHp() > 0) {
                                u.getCharackter().setHp(u.getCharackter().getHp() + (int) ((u.getCharackter().getMaxHp() -u.getCharackter().getHp())*0.02));
                                if(u.getCharackter().getHp() > u.getCharackter().getMaxHp()) u.getCharackter().setHp(u.getCharackter().getMaxHp());
                            }else {

                            }
                        }, 1, 1, TimeUnit.SECONDS);

                    }
                    case  1 -> {
                        LobbyUser u = getUser(so);
                        Charakter c = u.getCharackter();
                        int shield = (int) (c.getHp() * 0.1);

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
                    }
                    case  2 -> {
                        AtomicInteger count = new AtomicInteger();
                        AtomicInteger ap = new AtomicInteger();
                        LobbyUser u = getUser(so);
                        ap.set(u.getCharackter().getAp());
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
                        LobbyUser u = getUser(so);
                        int ad = u.getCharackter().getAp();
                        makeDMG(so, false, 120 + ad);
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
                        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
                        ses.scheduleAtFixedRate(()-> {
                            LobbyUser lu = getUser(so);
                            lu.getCharackter().setAp(lu.getCharackter().getAp() + 1);
                            lu.getCharackter().setAd(lu.getCharackter().getAd() + 5);
                        },5, 5, TimeUnit.SECONDS);

                    }
                    case  1 -> {
                        LobbyUser lu = getUser(so);
                        makeDMG(so, true, 10 + lu.getCharackter().getAp());
                    }
                    case  2 -> {
                        LobbyUser lu = getUser(so);
                        makeDMG(so, false, (int) (120 + lu.getCharackter().getAd()*0.4));
                        lu.getCharackter().setHp( lu.getCharackter().getHp() + (int) (((120 + lu.getCharackter().getAd())*0.4) * 0.1));
                    }
                    case  3 -> {
                        LobbyUser lu = getUser(so);
                        int shield = lu.getCharackter().getAp()*40 + 100;
                        lu.getCharackter().setShield(shield);
                        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
                        ses.schedule(()-> {
                            Charakter c = lu.getCharackter();
                            if(c.getShield() > 0) {
                                if(c.getShield() - shield < 0) {
                                    c.setShield(0);
                                }else {
                                    c.setShield(c.getShield()-shield);
                                }

                            }
                        },3, TimeUnit.SECONDS);

                    }
                    case  4-> {
                        LobbyUser lu = getUser(so);
                        int heath = (int) (lu.getCharackter().getMaxHp() * 0.2);
                        lu.getCharackter().setMaxHp(lu.getCharackter().getMaxHp() + heath);
                        lu.getCharackter().setHp(lu.getCharackter().getHp() + heath);
                        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
                        ses.schedule(()-> {
                            if(lu.getCharackter().getHp() > lu.getCharackter().getMaxHp() - heath) {
                                lu.getCharackter().setMaxHp(lu.getCharackter().getHp() - heath);
                                lu.getCharackter().setHp(lu.getCharackter().getMaxHp());
                            }else {
                                lu.getCharackter().setMaxHp(lu.getCharackter().getHp() - heath);
                            }
                        },10,TimeUnit.SECONDS);
                    }

                }
            }
            case 3 -> {
                switch (ab) {
                    case 0 -> {
                        LobbyUser u = getUser(so);
                        ScheduledExecutorService ses =  Executors.newScheduledThreadPool(1);
                        ses.scheduleAtFixedRate(()-> {
                            u.getCharackter().setShield(u.getCharackter().getShield()+(100+20*u.getCharackter().getAp()));
                        },10,10, TimeUnit.SECONDS);
                    }
                    case  1 -> {
                        LobbyUser u = getUser(so);
                        makeDMG(so,true, (int) (40+u.getCharackter().getMaxHp()*0.01));
                    }
                    case  2 -> {
                        LobbyUser u = getUser(so);
                        makeDMG(so, false, (int) (120+u.getCharackter().getAd()*0.4));
                    }
                    case  3 -> {
                        LobbyUser u = getUser(so);
                        int heal = 50 + 20 * u.getCharackter().getAp();
                        if(u.getCharackter().getHp() + heal > u.getCharackter().getMaxHp()) {
                            u.getCharackter().setHp(u.getCharackter().getMaxHp());
                        }else {
                            u.getCharackter().setHp(u.getCharackter().getHp() + heal);
                        }
                    }
                    case  4-> {
                        LobbyUser u = getUser(so);
                        int shield = 1200 + 100*u.getCharackter().getAp();
                        u.getCharackter().setShield(u.getCharackter().getShield() + shield);
                        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
                        ses.schedule(()-> {
                            if(u.getCharackter().getShield() - shield < 0) {
                                u.getCharackter().setShield(0);
                            }else {
                                u.getCharackter().setShield(u.getCharackter().getShield() - shield);
                            }
                        },10, TimeUnit.SECONDS);


                    }

                }
            }
            case 4 -> {
                switch (ab) {
                    case 0 -> {
                        //passive is in ability
                    }
                    case  1 -> {
                        Charakter charakter = getUser(so).getCharackter();
                        makeDMG(so,false, charakter.getAd());
                        if(r.nextInt(10) == 0) {
                            makeDMG(so,false, charakter.getAd());
                        }

                    }
                    case  2 -> {
                        Charakter charakter = getUser(so).getCharackter();
                        if(r.nextInt(4) == 0) {
                            makeDMG(so,false, (int) (charakter.getAd() * 1.1) *2);
                        }else {
                            makeDMG(so,false, (int) (charakter.getAd() * 1.1));
                        }
                        if(r.nextInt(10) == 0) {
                            if(r.nextInt(4) == 0) {
                                makeDMG(so,false, (int) (charakter.getAd() * 1.1) *2);
                            }else {
                                makeDMG(so,false, (int) (charakter.getAd() * 1.1));
                            }
                        }

                    }
                    case  3 -> {
                        Charakter charakter = getUser(so).getCharackter();
                        charakter.setAd((int) (charakter.getAd() + charakter.getAd()*0.30));
                        if(r.nextInt(10) == 0) {
                            charakter.setAd((int) (charakter.getAd() + charakter.getAd()*0.30));
                        }
                    }
                    case  4-> {
                        Charakter charakter = getUser(so).getCharackter();
                        Thread t = new Thread(()-> {
                            for (int i = 0; i < 8; i++) {
                                makeDMG(so,false, charakter.getAd());
                                try {
                                    Thread.sleep(250);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        });

                        t.start();

                    }

                }
            }
            case 5 -> {
                switch (ab) {
                    case 0 -> {
                        //includes in Abilitys
                    }
                    case  1 -> {
                        LobbyUser lu = getUser(so);
                        makeDMG(so,false, lu.getCharackter().getAd());
                        if(r.nextInt(3) == 0) {
                            makeDMG(so,false, (int) (40 + lu.getCharackter().getAd() * 0.5));

                        }
                    }
                    case  2 -> {
                        LobbyUser lu = getUser(so);
                        makeDMGIgnoreSchield(so, false, 50 + (int) (lu.getCharackter().getAp() * 0.75));
                        if(r.nextInt(3) == 0) {
                            makeDMG(so,false, (int) (40 + lu.getCharackter().getAd() * 0.5));

                        }
                    }
                    case  3 -> {
                        LobbyUser lu = getUser(so);
                        makeDMG(so,false, 50 + lu.getCharackter().getAd() * 2);

                        if(r.nextInt(3) == 0) {
                            makeDMG(so,false, (int) (40 + lu.getCharackter().getAd() * 0.5));

                        }
                    }
                    case  4-> {
                        LobbyUser lu = getUser(so);
                        int ad = lu.getCharackter().getAd();
                        lu.getCharackter().setAd(lu.getCharackter().getAd() + ad);
                        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
                        ses.schedule(()-> {
                            lu.getCharackter().setAd(lu.getCharackter().getAd() - ad);
                        }, 10, TimeUnit.SECONDS);

                    }

                }
            }
            case 6 -> {
                switch (ab) {
                    case 0 -> {

                    }
                    case  1 -> {
                        LobbyUser lu = getUser(so);
                        makeDMG(so,false, lu.getCharackter().getAd());
                        if(r.nextInt(10) == 0) {
                            lu.getCharackter().setAd(lu.getCharackter().getAd() + 2);
                        }

                    }
                    case  2 -> {
                        LobbyUser lu = getUser(so);
                        makeDMG(so,false, lu.getCharackter().getAd());
                        makeDMG(so,true, (int) (lu.getCharackter().getAd() * 0.2));
                        if(r.nextInt(10) == 0) {
                            lu.getCharackter().setAd(lu.getCharackter().getAd() + 2);
                        }

                    }
                    case  3 -> {
                        LobbyUser lu = getUser(so);
                        if(r.nextInt(10) == 0) {
                            lu.getCharackter().setAd(lu.getCharackter().getAd() + 2);
                        }
                        AtomicInteger count = new AtomicInteger(0);
                        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
                        ses.scheduleAtFixedRate(() -> {
                            if(count.get() < 5) {
                                makeDMG(so, false, (int) (lu.getCharackter().getAd() * 0.6));
                                count.getAndIncrement();
                            }else {
                                ses.shutdownNow();
                            }

                        }, 500, 500, TimeUnit.MILLISECONDS);
                    }
                    case  4-> {
                        LobbyUser lu = getUser(so);
                        lu.getCharackter().setAd(lu.getCharackter().getAd() + 5 );
                    }

                }
            }
            case 7 -> {
                switch (ab) {
                    case 0 -> {
                        LobbyUser lu = getUser(so);
                        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
                        ses.scheduleAtFixedRate(()-> {
                            lu.getCharackter().setAp(lu.getCharackter().getAp() + 1);
                        }, 5, 5, TimeUnit.MINUTES);

                    }
                    case  1 -> {
                        int ap = getUser(so).getCharackter().getAp();
                        heal(so, false, 100 + 5*ap );
                    }
                    case  2 -> {
                        LobbyUser lu = getUser(so);
                        int ad = lu.getCharackter().getAp() * 2 + 10;
                        users.forEach((user) -> {
                            if(user.getTeam() == lu.getTeam() && user.getUser().getUser().getId() != lu.getUser().getUser().getId()) {
                                user.getCharackter().setAd(user.getCharackter().getAd() + ad);
                            }
                        });

                        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
                        ses.schedule(() -> {
                            users.forEach((user) -> {
                                if(user.getTeam() == lu.getTeam() && user.getUser().getUser().getId() != lu.getUser().getUser().getId()) {
                                    user.getCharackter().setAd(user.getCharackter().getAd() - ad);
                                }
                            });
                        }, 5, TimeUnit.SECONDS );

                    }
                    case  3 -> {
                        LobbyUser u = getUser(so);
                        makeDMG(so, false, 10 + u.getCharackter().getAp());
                    }
                    case  4-> {
                        LobbyUser u = getUser(so);
                        heal(so, true, 500 );
                        users.forEach((user) -> {
                            user.getCharackter().setAd(user.getCharackter().getAd() + 50);
                        });

                        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
                        ses.schedule(() -> {
                            users.forEach((user) -> {
                                user.getCharackter().setAd(user.getCharackter().getAd() - 50);
                            });
                        }, 8, TimeUnit.SECONDS);
                    }

                }
            }
            case 8 -> {
                switch (ab) {
                    case 0 -> {
                        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
                        ses.scheduleAtFixedRate(()-> {
                            heal(so, true, 10);
                        }, 10, 10, TimeUnit.SECONDS);
                    }
                    case  1 -> {
                        int ap = getUser(so).getCharackter().getAp();
                        heal(so, false, 100 + 5*ap );
                    }
                    case  2 -> {
                        LobbyUser u = getUser(so);
                        addschield(so, true, 150 + 40 * u.getCharackter().getAp(), 2);
                    }
                    case  3 -> {
                        LobbyUser u = getUser(so);
                        users.forEach((user) -> {
                            if(user.getTeam() != u.getTeam() ) {
                                user.getCharackter().setShield(0);
                            }
                        });
                    }
                    case  4-> {
                        int ap = 10 * getUser(so).getCharackter().getAp();
                        heal(so, true, 300 + ap );
                    }

                }
            }
            case 9 -> {
                switch (ab) {
                    case 0 -> {
                        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
                        ses.scheduleAtFixedRate(()-> {
                            heal(so, true, 10);
                        }, 10, 10, TimeUnit.SECONDS);
                    }
                    case  1 -> {
                        int ap = getUser(so).getCharackter().getAp();
                        heal(so, false, 100 + 5*ap );
                    }
                    case  2 -> {
                        int ap = getUser(so).getCharackter().getAp();
                        heal(so, false, 60 + 4 * ap );
                        heal(so, true, 20 + 3 * ap);
                    }
                    case  3 -> {
                        makeDMG(so, true, 60);
                    }
                    case  4-> {
                        addschield(so, true, 10000 , 5);
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

    public LobbyUser getUser(int id) {
        for (LobbyUser lu : users) {
            if(lu.getUser().getUser().getId() == id) {
                return lu;
            }
        }
        return null;
    }

    public void makeDMG_old(SenderObject so, boolean aoe, int dmg) {
        int team = getUser(so).getTeam();
        if(aoe) {
            for(LobbyUser u : users) {
                if(u.getTeam() != team) {
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

                    }
                }
            }

        }else {
            int c = 0;
            for(LobbyUser u : users) {
                if(u.getTeam() == team) {
                } else {
                    c++;
                    if(u.getCharackter().getKlasse().equalsIgnoreCase("tank")) {
                        c=0;
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
                            break;
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
                                            break;
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
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }else if(c == 3) {
                        c = 0;
                        for (LobbyUser lu : users) {
                            if (lu.getTeam() == team) {

                            }else {
                                c++;
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
                                        break;
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
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }else if(c==3) {
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
                                                    break;
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
    public void makeDMGIgnoreSchield(SenderObject so, boolean aoe, int dmg) {
        int team = getUser(so).getTeam();
        if(aoe) {
            for(LobbyUser u : users) {
                if(u.getTeam() != team) {
                    if(u.getCharackter().getHp() > 0) {
                        u.getCharackter().setHp(u.getCharackter().getHp() - dmg);
                    }
                }
            }

        }else {

            int c = 0;
            for(LobbyUser u : users) {
                if(u.getTeam() == team) {
                } else {
                    c++;
                    if(u.getCharackter().getKlasse().equalsIgnoreCase("tank")) {
                        c=0;
                        if(u.getCharackter().getHp() > 0) {
                            u.getCharackter().setHp(u.getCharackter().getHp() - dmg);
                            break;
                        }else {
                            for (LobbyUser lu : users) {
                                if (lu.getTeam() == team) {

                                }else {
                                    if(lu.getCharackter().getKlasse().equalsIgnoreCase("dps")) {
                                        if(lu.getCharackter().getHp() > 0) {
                                            u.getCharackter().setHp(u.getCharackter().getHp() - dmg);
                                            break;
                                        }else {
                                            for (LobbyUser lou : users) {
                                                if (lou.getTeam() == team) {

                                                }else {
                                                    if(lou.getCharackter().getKlasse().equalsIgnoreCase("sup")) {
                                                        if(lou.getCharackter().getHp() > 0) {

                                                            u.getCharackter().setHp(u.getCharackter().getHp() - dmg);
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }else if(c == 3) {
                        c = 0;
                        for (LobbyUser lu : users) {
                            c++;
                            if (lu.getTeam() == team) {

                            }else {
                                if(lu.getCharackter().getKlasse().equalsIgnoreCase("dps")) {
                                    if(lu.getCharackter().getHp() > 0) {
                                        u.getCharackter().setHp(u.getCharackter().getHp() - dmg);
                                        break;
                                    }else {
                                        for (LobbyUser lou : users) {
                                            if (lou.getTeam() == team) {

                                            }else {
                                                if(lou.getCharackter().getKlasse().equalsIgnoreCase("sup")) {
                                                    if(lou.getCharackter().getHp() > 0) {
                                                        u.getCharackter().setHp(u.getCharackter().getHp() - dmg);
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }else if (c == 3) {
                                    for (LobbyUser lou : users) {
                                        if (lou.getTeam() == team) {

                                        }else {
                                            if(lou.getCharackter().getKlasse().equalsIgnoreCase("sup")) {
                                                if(lou.getCharackter().getHp() > 0) {

                                                    u.getCharackter().setHp(u.getCharackter().getHp() - dmg);
                                                    break;
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

    public void makeDMG(SenderObject so, boolean aoe, int dmg){
        LobbyUser user = getUser(so);
        ArrayList<LobbyUser> enemys = new ArrayList<>();
        HashMap<LobbyUser, String> userChampHashMap = new HashMap<>();
        users.forEach((u) -> {
            if(u.getTeam() != user.getTeam()) enemys.add(u);
        });
        enemys.forEach((e) -> {
            userChampHashMap.put(e, e.getCharackter().getKlasse());
        });

        if(aoe) {
            enemys.forEach((user1) -> {
                if(user1.getCharackter().getHp() > 0) {
                    if(user1.getCharackter().getShield() > 0) {
                        if(user1.getCharackter().getShield() - dmg < 0) {
                            int _tmp = dmg - user1.getCharackter().getShield();
                            user1.getCharackter().setHp(user1.getCharackter().getHp() - _tmp );
                            user1.getCharackter().setShield(0);
                        }else {
                            user1.getCharackter().setShield(user1.getCharackter().getShield() - dmg);
                        }
                    }else {
                        user1.getCharackter().setHp(user1.getCharackter().getHp() - dmg);
                    }

                }
            });


        }
        else {
            AtomicBoolean fuckuniggas = new AtomicBoolean(false);
            userChampHashMap.forEach((k ,v) -> {
                if(v.equalsIgnoreCase("TANK")) {
                    if(k.getCharackter().getHp() > 0) {
                        if(k.getCharackter().getShield() > 0) {
                            if(k.getCharackter().getShield() - dmg < 0) {
                                int _tmp = dmg - k.getCharackter().getShield();
                                k.getCharackter().setHp(k.getCharackter().getHp() - _tmp );
                                k.getCharackter().setShield(0);
                            }else {
                                k.getCharackter().setShield(k.getCharackter().getShield() - dmg);
                            }

                        }else {
                            k.getCharackter().setHp(k.getCharackter().getHp() - dmg);
                        }
                        System.out.println("DMG: " + dmg +  "->" + k.getCharackter().getName());
                        fuckuniggas.set(true);
                        return;
                    }
                    System.out.println("klassnotworkingexeptiop:"  + v);

                }
            });
            if(fuckuniggas.get()) return;
            userChampHashMap.forEach((k ,v) -> {
                if(v.equalsIgnoreCase("dps")) {
                    if(k.getCharackter().getHp() > 0) {
                        if(k.getCharackter().getShield() > 0) {
                            if(k.getCharackter().getShield() - dmg < 0) {
                                int _tmp = dmg - k.getCharackter().getShield();
                                k.getCharackter().setHp(k.getCharackter().getHp() - _tmp );
                                k.getCharackter().setShield(0);
                            }else {
                                k.getCharackter().setShield(k.getCharackter().getShield() - dmg);
                            }

                        }else {
                            k.getCharackter().setHp(k.getCharackter().getHp() - dmg);
                        }

                        fuckuniggas.set(true);
                        return;
                    }
                }
            });
            if(fuckuniggas.get()) return;

            userChampHashMap.forEach((k ,v) -> {
                if(v.equalsIgnoreCase("sup")) {
                    if(k.getCharackter().getHp() > 0) {
                        if(k.getCharackter().getShield() > 0) {
                            if(k.getCharackter().getShield() - dmg < 0) {
                                int _tmp = dmg - k.getCharackter().getShield();
                                k.getCharackter().setHp(k.getCharackter().getHp() - _tmp );
                                k.getCharackter().setShield(0);
                            }else {
                                k.getCharackter().setShield(k.getCharackter().getShield() - dmg);
                            }

                        }else {
                            k.getCharackter().setHp(k.getCharackter().getHp() - dmg);
                        }


                        return;
                    }
                }
            });



        }


    }



    public ArrayList<LobbyUser> getUsers() {
        return users;
    }

    public void heal(SenderObject so, boolean all, int heath) {
        LobbyUser lu = getUser(so);
        if(all) {
            for (LobbyUser u : users) {
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
        }else {
            for (LobbyUser u : users) {
                if(lu.getTeam() == u.getTeam()) {
                    if(u.getCharackter().getKlasse().equalsIgnoreCase("TANK")) {
                        if(u.getCharackter().getHp() > 0) {
                            if( u.getCharackter().getHp() + heath > u.getCharackter().getMaxHp()) {
                                u.getCharackter().setHp(u.getCharackter().getMaxHp());
                            }else {
                                u.getCharackter().setHp(u.getCharackter().getHp() + heath);
                            }
                            break;
                        }else {
                            for (LobbyUser u1 : users) {
                                if(lu.getTeam() == u1.getTeam()) {
                                    if(u1.getCharackter().getKlasse().equalsIgnoreCase("DPS")) {
                                        if(u1.getCharackter().getHp() > 0) {
                                            if( u1.getCharackter().getHp() + heath > u1.getCharackter().getMaxHp()) {
                                                u1.getCharackter().setHp(u1.getCharackter().getMaxHp());
                                            }else {
                                                u1.getCharackter().setHp(u1.getCharackter().getHp() + heath);
                                            }
                                            break;
                                        }else {
                                            for (LobbyUser u2 : users) {
                                                if(lu.getTeam() == u2.getTeam()) {
                                                    if(u2.getCharackter().getKlasse().equalsIgnoreCase("SUP")) {
                                                        if(u2.getCharackter().getHp() > 0) {
                                                            if( u2.getCharackter().getHp() + heath > u2.getCharackter().getMaxHp()) {
                                                                u2.getCharackter().setHp(u2.getCharackter().getMaxHp());
                                                            }else {
                                                                u2.getCharackter().setHp(u2.getCharackter().getHp() + heath);
                                                            }
                                                            break;
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

    public void addschield(SenderObject so, boolean all, int shied, int duration) {
        if(all) {
            LobbyUser u = getUser(so);
            for (LobbyUser lu : users) {
                if(lu.getTeam() == u.getTeam()) {
                    if(u.getCharackter().getHp() > 0) {
                       u.getCharackter().setShield(u.getCharackter().getShield() + shied);
                       ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
                       ses.schedule(() -> {
                           if(u.getCharackter().getShield() > shied) {
                               u.getCharackter().setShield(u.getCharackter().getShield() - shied);
                           }else {
                               u.getCharackter().setShield(0);
                           }
                       }, duration, TimeUnit.SECONDS );
                    }

                }
            }
        }
    }
}
