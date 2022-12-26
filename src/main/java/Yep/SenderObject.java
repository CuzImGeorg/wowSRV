package Yep;

import Character.Character;
import NameHistory.NameHistory;
import Queue.QueueUser;
import Stats.Stats;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class SenderObject  implements Serializable {
    private Instruction instruction;
    private User user;
    private int code;
    private ArrayList<QueueUser> queueUsers;
    private Character character;
    private ArrayList<Character> characters;
    private Stats  stats;
    private int c;
    private int ab;
    private String newUsername;
    private ArrayList<NameHistory> nameHistory;

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

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
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

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList<Character> characters) {
        this.characters = characters;
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
}
