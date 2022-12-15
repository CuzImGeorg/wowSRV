package Lobby;

import java.util.ArrayList;

public class Lobby {
    private int id;
    private ArrayList<LobbyUser> users;

    public Lobby(int id, ArrayList<LobbyUser> users) {
        this.id = id;
        this.users = users;
    }

}
