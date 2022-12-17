package Played;

public class Played {
    private int id, userid, charid, games;

    public Played(int id, int userid, int charid, int games) {
        this.id = id;
        this.userid = userid;
        this.charid = charid;
        this.games = games;
    }

    public Played(int userid, int charid, int games) {
        this.id = id;
        this.userid = userid;
        this.charid = charid;
        this.games = games;
    }

    public Played() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getCharid() {
        return charid;
    }

    public void setCharid(int charid) {
        this.charid = charid;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }
}
