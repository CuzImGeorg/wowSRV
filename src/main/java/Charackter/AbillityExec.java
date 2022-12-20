package Charackter;

import Lobby.LobbyUser;
import Yep.ConnectedUser;
import Yep.SenderObject;
import Yep.User;

import javax.persistence.Lob;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AbillityExec implements Serializable {

    private ArrayList<LobbyUser> users;
    private Random r;

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
                        u.getCharackter().setHp(u.getCharackter().getHp() + (int) ((u.getCharackter().getMaxHp() -u.getCharackter().getHp())*0.02));

//                        for(LobbyUser u : users) {
//                            if(u.getUser().getUser().getId() == so.getUser().getId()) {
//                                u.getCharackter().setHp(u.getCharackter().getHp() + (int) ((u.getCharackter().getMaxHp() -u.getCharackter().getHp())*0.02));
//                                break;
//                            }
//                        }
                    }
                    case  1 -> {
                        int shield = (int) (so.getCharacter().getHp() * 0.1);
                        LobbyUser  u = getUser(so);
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
                            Character c = lu.getCharackter();
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

                    }
                    case  4-> {

                    }

                }
            }
            case 4 -> {
                switch (ab) {
                    case 0 -> {
                        //passive is in ability
                    }
                    case  1 -> {
                        Character character = getUser(so).getCharackter();
                        makeDMG(so,false,character.getAd());
                        if(r.nextInt(10) == 0) {
                            makeDMG(so,false,character.getAd());
                        }

                    }
                    case  2 -> {
                        Character character = getUser(so).getCharackter();
                        if(r.nextInt(4) == 0) {
                            makeDMG(so,false, (int) (character.getAd() * 1.1) *2);
                        }else {
                            makeDMG(so,false, (int) (character.getAd() * 1.1));
                        }
                        if(r.nextInt(10) == 0) {
                            if(r.nextInt(4) == 0) {
                                makeDMG(so,false, (int) (character.getAd() * 1.1) *2);
                            }else {
                                makeDMG(so,false, (int) (character.getAd() * 1.1));
                            }
                        }

                    }
                    case  3 -> {
                        Character character = getUser(so).getCharackter();
                        character.setAd((int) (character.getAd() + character.getAd()*0.30));
                        if(r.nextInt(10) == 0) {
                            character.setAd((int) (character.getAd() + character.getAd()*0.30));
                        }
                    }
                    case  4-> {
                        Character character = getUser(so).getCharackter();
                        Thread t = new Thread(()-> {
                            for (int i = 0; i < 8; i++) {
                                makeDMG(so,false,character.getAd());
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
    public void makeDMGIgnoreSchield(SenderObject so, boolean aoe, int dmg) {
        int team = 0;
        if(aoe) {
            for(LobbyUser u : users) {
                if(u.getTeam() != team) {
                    if(u.getCharackter().getHp() > 0) {
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
                            u.getCharackter().setHp(u.getCharackter().getHp() - dmg);

                        }else {
                            for (LobbyUser lu : users) {
                                if (lu.getTeam() == team) {

                                }else {
                                    if(lu.getCharackter().getKlasse().equalsIgnoreCase("dps")) {
                                        if(lu.getCharackter().getHp() > 0) {
                                            u.getCharackter().setHp(u.getCharackter().getHp() - dmg);

                                        }else {
                                            for (LobbyUser lou : users) {
                                                if (lou.getTeam() == team) {

                                                }else {
                                                    if(lou.getCharackter().getKlasse().equalsIgnoreCase("sup")) {
                                                        if(lou.getCharackter().getHp() > 0) {

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

    public void addschield(SenderObject so, boolean all, int shied) {
        if(all) {
            LobbyUser u = getUser(so);
            for (LobbyUser lu : users) {
                if(lu.getTeam() == u.getTeam()) {
                    if(u.getCharackter().getHp() > 0) {
                       //TODO
                    }

                }
            }
        }
    }
}
