package NameHistory;

import Yep.User;

import java.io.Serial;
import java.io.Serializable;

public class NameHistory implements Serializable {
    private int id, changed;
    private User user;
    private String dateAndTime, username;

    public NameHistory(int id, int changed, User user, String dateAndTime, String username) {
        this.id = id;
        this.changed = changed;
        this.user = user;
        this.dateAndTime = dateAndTime;
        this.username = username;
    }

    public NameHistory(User user, String dateAndTime, String username) {
        this.user = user;
        this.dateAndTime = dateAndTime;
        this.username = username;
    }

    public NameHistory(int changed, User user, String dateAndTime, String username) {
        this.changed = changed;
        this.user = user;
        this.dateAndTime = dateAndTime;
        this.username = username;
    }

    @Serial
    private static final long serialVersionUID = 6529685098267757690L;
    public NameHistory() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChanged() {
        return changed;
    }

    public void setChanged(int changed) {
        this.changed = changed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
