package Yep;

import Charackter.Character;
import Queue.QueueUser;

import java.io.Serializable;
import java.util.ArrayList;

public class SenderObject  implements Serializable {
    private Instruction instruction;
    private User user;
    private int code;
    private ArrayList<QueueUser> queueUsers;
    private Character character;


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
}
