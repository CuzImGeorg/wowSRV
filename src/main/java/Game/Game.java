package Game;

import Charackter.AbillityExec;
import Lobby.LobbyUser;

import java.util.ArrayList;

public class Game {

    private AbillityExec abillityecex;
    private ArrayList<LobbyUser> users;

    public Game ( ArrayList<LobbyUser> users) {
        this.users = users;
        abillityecex = new AbillityExec(users);
    }


    public void start() {
        for (LobbyUser u : users) {
            u.getUser().setAbillity(abillityecex);
        }


    }


}
