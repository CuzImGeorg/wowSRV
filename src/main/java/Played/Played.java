package Played;

import Charackter.Character;
import Yep.User;

public class Played {
    private int id, games;
    private User userId;
    private Character charId;


    public Played(int id, int games, User userId, Character charId) {
        this.id = id;
        this.games = games;
        this.userId = userId;
        this.charId = charId;
    }

    public Played(int games, User userId, Character charId) {
        this.games = games;
        this.userId = userId;
        this.charId = charId;
    }

    public Played() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Character getCharId() {
        return charId;
    }

    public void setCharId(Character charId) {
        this.charId = charId;
    }

    @Override
    public String toString() {
        return "Played{" +
                "id=" + id +
                ", games=" + games +
                ", userNmae=" + userId.getUsername() +
                ", charId=" + charId.getName() +
                '}';
    }
}
