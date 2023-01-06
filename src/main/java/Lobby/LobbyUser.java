package Lobby;

import Character.Charakter;
import Yep.ConnectedUser;

import java.util.ArrayList;

public class LobbyUser {
    private ConnectedUser user;
    private Charakter charakter;
    private int team;

    public  LobbyUser(ConnectedUser user) {
        this.user = user;
    }


    public ConnectedUser getUser() {
        return user;
    }

    public void setUser(ConnectedUser user) {
        this.user = user;
    }

    public void waitForCham(ArrayList<LobbyUser> users) {
        Thread t = new Thread(()->{
            charakter = user.getCIfSetOrWait();
        });
        t.start();
    }

    public Charakter getCharackter() {
        return charakter;
    }

    public void setCharackter(Charakter charakter) {
        this.charakter = charakter;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }
}
