package Queue;

import Yep.ConnectedUser;
import Yep.Start;


import java.util.ArrayList;

public class Queue {

    private ArrayList<ConnectedUser> users;


    public Queue() {

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
                    ArrayList<ConnectedUser> cuser = new ArrayList<>();
                    for (int i = 0; i < 6; i++) {
                        cuser.add(users.get(i));
                        users.remove(users.get(i));
                    }
                    Start.getLobbyMgr().createLobby(cuser);
                }
            }
        });

    }
}
