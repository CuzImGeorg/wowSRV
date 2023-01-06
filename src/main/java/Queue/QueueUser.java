package Queue;

import Character.Charakter;
import Yep.User;

import java.io.Serial;
import java.io.Serializable;

public class QueueUser implements Serializable {
    private User user;
    private Charakter charakter;
    private int team;
    @Serial
    private static final long serialVersionUID = 6529685098267757690L;

    public QueueUser(User user, Charakter charakter, int team) {
        this.user = user;
        this.charakter = charakter;
        this.team = team;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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