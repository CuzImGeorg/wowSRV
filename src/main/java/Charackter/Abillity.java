package Charackter;

import Yep.SenderObject;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.Serializable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Abillity implements Serializable {


    public void execAbility(SenderObject so ,Character c, int ab) {
        switch (c.getId()) {
            case 1 -> {
                switch (ab) {
                    case 0 -> {
                        so.getCharacter().setHp(so.getCharacter().getHp() + (int) ((so.getCharacter().getMaxHp() -so.getCharacter().getHp())*0.02));
                    }
                    case  1 -> {
                        int schield = (int) (so.getCharacter().getHp() * 0.1);
                        so.getCharacter().setShield(schield);
                        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
                        ses.schedule(()-> {
                            if(so.getCharacter().getShield() > 0) {
                                if(so.getCharacter().getShield() - schield < 0) {
                                    so.getCharacter().setShield(0);
                                }else {
                                    so.getCharacter().setShield(so.getCharacter().getShield()-schield);
                                }

                            }
                        },2500, TimeUnit.MILLISECONDS);

                    }
                    case  2 -> {

                    }
                    case  3 -> {

                    }
                    case  4-> {

                    }

                }
            }
            case 2 -> {
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





}
