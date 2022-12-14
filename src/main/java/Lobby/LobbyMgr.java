package Lobby;

import Game.Game;
import Yep.ConnectedUser;

import java.util.ArrayList;

public class LobbyMgr {

    private ArrayList<Lobby> lobbies;


    public LobbyMgr() {
        lobbies = new ArrayList<>();
    }

    public void createLobby(ArrayList<ConnectedUser> users) {
        ArrayList<LobbyUser> lobbyUsers = new ArrayList<>();
        for (ConnectedUser u : users) {
            lobbyUsers.add(new LobbyUser(u));
        }
        Lobby l = new Lobby(lobbies.size()+1, lobbyUsers);
        lobbies.add(l);
        Thread t = new Thread(l::start);
        t.start();
    }

}
