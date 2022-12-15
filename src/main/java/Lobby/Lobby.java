package Lobby;

import java.util.ArrayList;

public class Lobby {
    private int id;
    private ArrayList<LobbyUser> users;

    public Lobby(int id, ArrayList<LobbyUser> users) {
        this.id = id;
        this.users = users;
    }

    public void start() {
        for (int i = 0; i < 3; i++) {
            users.get(i).setTeam(0);
        }
        for (int i = 0; i < 3; i++) {
            users.get(i+3).setTeam(1);
        }
        for ( LobbyUser u : users) {

        }
    }

}
