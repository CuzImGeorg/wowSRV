package Queue;

import Yep.ConnectedUser;
import Yep.Start;


import java.util.ArrayList;

public class Queue {

    private ArrayList<ConnectedUser> users;


    public Queue() {
        users = new ArrayList<>();
        checkForPlayers();
    }


    public void joinQueue(ConnectedUser user) {
        users.add(user);
        System.out.println(user.getUser().getUsername());
    }

    public void checkForPlayers() {
        Thread t = new Thread(()-> {
            while(true) {
                if(users.size() >= 6) {
                    System.out.println("try start");
                    ArrayList<ConnectedUser> cuser = new ArrayList<>();
                    for (int i = 0; i < 6; i++) {
                        cuser.add(users.get(i));
                    }
                    for (ConnectedUser cu: cuser ) {
                        users.remove(cu);
                    }

                    System.out.println("Lobby started");
                    Start.getLobbyMgr().createLobby(cuser);

                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t.start();
    }
}
