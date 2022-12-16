package Queue;

import Charackter.Character;
import Yep.User;

import java.io.Serializable;

public class QueueUser implements Serializable {
    private User user;
    private Character character;
    private int team;

    public QueueUser(User user, Character character, int team) {
        this.user = user;
        this.character = character;
        this.team = team;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Character getCharackter() {
        return character;
    }

    public void setCharackter(Character character) {
        this.character = character;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }
}
