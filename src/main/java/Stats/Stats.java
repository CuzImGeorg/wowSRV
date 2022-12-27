package Stats;

import Played.Played;
import Yep.User;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

public class Stats implements Serializable {

    private int id, hoursPlayed, minutesPlayed, kills, deaths;
    private User user;
    private Set<Played> played;

    public Stats(int id, int hoursPlayed, int minutesPlayed, int kills, int deaths, User userId) {
        this.id = id;
        this.hoursPlayed = hoursPlayed;
        this.minutesPlayed = minutesPlayed;
        this.kills = kills;
        this.deaths = deaths;
        this.user = userId;
    }

    @Serial
    private static final long serialVersionUID = 6529685098267757690L;
    public Stats() {

    }
    public Stats( int hoursPlayed, int minutesPlayed, int kills, int deaths, User userId) {
        this.hoursPlayed = hoursPlayed;
        this.minutesPlayed = minutesPlayed;
        this.kills = kills;
        this.deaths = deaths;
        this.user = userId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHoursPlayed() {
        return hoursPlayed;
    }

    public void setHoursPlayed(int hoursPlayed) {
        this.hoursPlayed = hoursPlayed;
    }

    public int getMinutesPlayed() {
        return minutesPlayed;
    }

    public void setMinutesPlayed(int minutesPlayed) {
        this.minutesPlayed = minutesPlayed;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Played> getPlayed() {
        return played;
    }


    public void setPlayed(Set<Played> played) {
        this.played = played;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "hoursPlayed=" + hoursPlayed +
                ", minutesPlayed=" + minutesPlayed +
                ", kills=" + kills +
                ", deaths=" + deaths +
                ", user=" + user.getUsername() +
                " Played: { " +
                '}';
    }

    public void printString () {
        System.out.println("Stats{" +
                "hoursPlayed=" + hoursPlayed +
                ", minutesPlayed=" + minutesPlayed +
                ", kills=" + kills +
                ", deaths=" + deaths +
                ", user=" + user.getUsername() +
                " Played: { "
                );
        for(Played p: played) {
            System.out.println("      " + p.toString());
        }
        System.out.println("      }");
        System.out.println("}");
    }
}
