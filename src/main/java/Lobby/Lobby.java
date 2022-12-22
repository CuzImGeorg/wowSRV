package Lobby;

import Game.Game;
import Queue.QueueUser;
import Yep.Instruction;
import Yep.SenderObject;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.ArrayList;

public class Lobby {
    private int id;
    private ArrayList<LobbyUser> users;

    public Lobby(int id, ArrayList<LobbyUser> users) {
        this.id = id;
        this.users = users;
        start();
    }

    public void start() {
        for (int i = 0; i < 3; i++) {
            users.get(i).setTeam(0);
        }
        for (int i = 0; i < 3; i++) {
            users.get(i+3).setTeam(1);
        }
        SenderObject s = new SenderObject(Instruction.JOINQUEUE);
        ArrayList<QueueUser> queueUsers = new ArrayList<>();
        for ( LobbyUser u : users) {
            queueUsers.add(new QueueUser(u.getUser().getUser(), null, u.getTeam()));
            s.setQueueUsers(queueUsers);
        }

        for ( LobbyUser u : users) {
            try {
                System.out.println("Sendetto " + u.getUser().getUser().getUsername() );
                u.getUser().getObjectOutputStream().writeObject(s);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        for (LobbyUser lu: users) {
            lu.waitForCham(users);
        }

        while (true) {
            if(checkForSel()) {
                //TODO gamestart
                Game g = new Game(users);
                g.start();


                break;
            };

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private boolean checkForSel() {
        for(LobbyUser lu : users) {
            if(lu.getCharackter() == null) {
                return false;
            }

        }
        return true;
    }

}
