package Played;

import Charackter.Character;
import Stats.Stats;
import Yep.User;

public class Played {
    private int id, games, wins, statsId;
    private Character charId;


    public Played(int id, int games, Character charId,int wins, int statsId) {
        this.id = id;
        this.games = games;
        this.charId = charId;
        this.statsId = statsId;
    }

    public Played(int games, Character charId, int wins, int statsId) {
        this.games = games;
        this.charId = charId;
        this.statsId = statsId;
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

    public Character getCharId() {
        return charId;
    }

    public void setCharId(Character charId) {
        this.charId = charId;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void incrementWins() {
        wins++;
    }

    public int getStatsId() {
        return statsId;
    }

    public void setStatsId(int statsId) {
        this.statsId = statsId;
    }

    @Override
    public String toString() {
        return "Played{" +
                "id=" + id +
                ", games=" + games +
                ", charId=" + charId.getName() +
                ", Wins=" + wins +
                '}';
    }
}
