package Game;

import Charackter.Abillity;
import Lobby.LobbyUser;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Game {

    private Abillity abillityecex;
    private ArrayList<LobbyUser> users;

    public Game () {
        abillityecex = new Abillity(users);
    }


    public void start() {
        for (LobbyUser u : users) {
            u.getUser().setAbillity(abillityecex);
        }


    }


}
