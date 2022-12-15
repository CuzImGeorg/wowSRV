package Lobby;

import Charackter.Charackter;
import Yep.ConnectedUser;

public class LobbyUser {
    private ConnectedUser user;
    private Charackter charackter;
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

    public Charackter getCharackter() {
        return charackter;
    }

    public void setCharackter(Charackter charackter) {
        this.charackter = charackter;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }
}
