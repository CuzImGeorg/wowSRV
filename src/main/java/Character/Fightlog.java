package Character;

import Yep.User;

import java.io.Serial;
import java.io.Serializable;

public class Fightlog implements Serializable {
    private boolean won, survived;
    private int kills, id;
    private String gameDuration, dateAndTime;
    @Serial
    private static final long serialVersionUID = 6529685098267757690L;
    private User user, mate1, mate2, enemy1, enemy2, enemy3;
    private Charakter character,  matechar1, matechar2, enemychar1, enemychar2, enemychar3;

    public Fightlog(boolean won, boolean survived, int kills, String gameDuration, String dateAndTime, User user, User mate1, User mate2, User enemy1, User enemy2, User enemy3, Charakter charakter, Charakter matechar1, Charakter matechar2, Charakter enemychar1, Charakter enemychar2, Charakter enemychar3) {
        this.won = won;
        this.survived = survived;
        this.kills = kills;
        this.gameDuration = gameDuration;
        this.dateAndTime = dateAndTime;
        this.user = user;
        this.mate1 = mate1;
        this.mate2 = mate2;
        this.enemy1 = enemy1;
        this.enemy2 = enemy2;
        this.enemy3 = enemy3;
        this.character = charakter;
        this.matechar1 = matechar1;
        this.matechar2 = matechar2;
        this.enemychar1 = enemychar1;
        this.enemychar2 = enemychar2;
        this.enemychar3 = enemychar3;
    }

    public Fightlog() {

    }

    public boolean isWon() {
        return won;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public boolean isSurvived() {
        return survived;
    }

    public void setSurvived(boolean survived) {
        this.survived = survived;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGameDuration() {
        return gameDuration;
    }

    public void setGameDuration(String gameDuration) {
        this.gameDuration = gameDuration;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getMate1() {
        return mate1;
    }

    public void setMate1(User mate1) {
        this.mate1 = mate1;
    }

    public User getMate2() {
        return mate2;
    }

    public void setMate2(User mate2) {
        this.mate2 = mate2;
    }

    public User getEnemy1() {
        return enemy1;
    }

    public void setEnemy1(User enemy1) {
        this.enemy1 = enemy1;
    }

    public User getEnemy2() {
        return enemy2;
    }

    public void setEnemy2(User enemy2) {
        this.enemy2 = enemy2;
    }

    public User getEnemy3() {
        return enemy3;
    }

    public void setEnemy3(User enemy3) {
        this.enemy3 = enemy3;
    }

    public Charakter getCharacter() {
        return character;
    }

    public void setCharacter(Charakter charakter) {
        this.character = charakter;
    }

    public Charakter getMatechar1() {
        return matechar1;
    }

    public void setMatechar1(Charakter matechar1) {
        this.matechar1 = matechar1;
    }

    public Charakter getMatechar2() {
        return matechar2;
    }

    public void setMatechar2(Charakter matechar2) {
        this.matechar2 = matechar2;
    }

    public Charakter getEnemychar1() {
        return enemychar1;
    }

    public void setEnemychar1(Charakter enemychar1) {
        this.enemychar1 = enemychar1;
    }

    public Charakter getEnemychar2() {
        return enemychar2;
    }

    public void setEnemychar2(Charakter enemychar2) {
        this.enemychar2 = enemychar2;
    }

    public Charakter getEnemychar3() {
        return enemychar3;
    }

    public void setEnemychar3(Charakter enemychar3) {
        this.enemychar3 = enemychar3;
    }
}

