package Yep;

import Character.Charakter;
import NameHistory.NameHistory;
import Queue.QueueUser;
import Stats.Stats;
import Character.Settings;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class SenderObject  implements Serializable {
    private Instruction instruction;
    private User user;
    private int code;
    private ArrayList<QueueUser> queueUsers;
    private Charakter charakter;
    private ArrayList<Charakter> characters;
    private Stats  stats;
    private int c;
    private int ab;
    private String newUsername;
    private ArrayList<NameHistory> nameHistory;
    private int teamWon;
    private Settings settings;
    private QueueUser queueUser1;
    private QueueUser queueUser2;
    private QueueUser queueUser3;
    private QueueUser queueUser4;
    private QueueUser queueUser5;
    private QueueUser queueUser6;

    @Serial
    private static final long serialVersionUID = 6529685098267757690L;

    public Instruction getInstruction() {
        return instruction;
    }


    public SenderObject(Instruction instruction) {
        this.instruction = instruction;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ArrayList<QueueUser> getQueueUsers() {
        return queueUsers;
    }

    public void setQueueUsers(ArrayList<QueueUser> queueUsers) {
        this.queueUsers = queueUsers;
    }

    public Charakter getCharacter() {
        return charakter;
    }

    public void setCharacter(Charakter charakter) {
        this.charakter = charakter;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getAb() {
        return ab;
    }

    public void setAb(int ab) {
        this.ab = ab;
    }

    public ArrayList<Charakter> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList<Charakter> charakters) {
        this.characters = charakters;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }


    public String getNewUsername() {
        return newUsername;
    }

    public void setNewUsername(String newUsername) {
        this.newUsername = newUsername;
    }

    public ArrayList<NameHistory> getNameHistory() {
        return nameHistory;
    }

    public void setNameHistory(ArrayList<NameHistory> nameHistory) {
        this.nameHistory = nameHistory;
    }

    public int getTeamWon() {
        return teamWon;
    }

    public void setTeamWon(int teamWon) {
        this.teamWon = teamWon;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public QueueUser getQueueUser1() {
        return queueUser1;
    }

    public void setQueueUser1(QueueUser queueUser1) {
        this.queueUser1 = queueUser1;
    }

    public QueueUser getQueueUser2() {
        return queueUser2;
    }

    public void setQueueUser2(QueueUser queueUser2) {
        this.queueUser2 = queueUser2;
    }

    public QueueUser getQueueUser3() {
        return queueUser3;
    }

    public void setQueueUser3(QueueUser queueUser3) {
        this.queueUser3 = queueUser3;
    }

    public QueueUser getQueueUser4() {
        return queueUser4;
    }

    public void setQueueUser4(QueueUser queueUser4) {
        this.queueUser4 = queueUser4;
    }

    public QueueUser getQueueUser5() {
        return queueUser5;
    }

    public void setQueueUser5(QueueUser queueUser5) {
        this.queueUser5 = queueUser5;
    }

    public QueueUser getQueueUser6() {
        return queueUser6;
    }

    public void setQueueUser6(QueueUser queueUser6) {
        this.queueUser6 = queueUser6;
    }
}
