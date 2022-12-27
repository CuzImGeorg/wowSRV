package Character;

import Yep.User;
import Character.Character;

public class Fightlog {
    private boolean won, survived;
    private int kills, id;
    private String gameDuration, dateAndTime;

    private User user, mate1, mate2, enemy1, enemy2, enemy3;
    private Character character,  matechar1, matechar2, enemychar1, enemychar2, enemychar3;

    public Fightlog(boolean won, boolean survived, int kills, String gameDuration, String dateAndTime, User user, User mate1, User mate2, User enemy1, User enemy2, User enemy3, Character character, Character matechar1, Character matechar2, Character enemychar1, Character enemychar2, Character enemychar3) {
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
        this.character = character;
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

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Character getMatechar1() {
        return matechar1;
    }

    public void setMatechar1(Character matechar1) {
        this.matechar1 = matechar1;
    }

    public Character getMatechar2() {
        return matechar2;
    }

    public void setMatechar2(Character matechar2) {
        this.matechar2 = matechar2;
    }

    public Character getEnemychar1() {
        return enemychar1;
    }

    public void setEnemychar1(Character enemychar1) {
        this.enemychar1 = enemychar1;
    }

    public Character getEnemychar2() {
        return enemychar2;
    }

    public void setEnemychar2(Character enemychar2) {
        this.enemychar2 = enemychar2;
    }

    public Character getEnemychar3() {
        return enemychar3;
    }

    public void setEnemychar3(Character enemychar3) {
        this.enemychar3 = enemychar3;
    }
}

