package Queue;

import Charackter.Charackter;
import Yep.User;

public class QueueUser {
    private User user;
    private Charackter charackter;
    private int team;

    public QueueUser(User user, Charackter charackter, int team) {
        this.user = user;
        this.charackter = charackter;
        this.team = team;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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
