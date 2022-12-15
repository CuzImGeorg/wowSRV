package Yep;

import Lobby.LobbyUser;

import java.io.Serializable;
import java.util.ArrayList;

public class SenderObject  implements Serializable {
    private Instruction instruction;
    private User user;
    private int code;
    private ArrayList<LobbyUser> lobbyUsers;

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

    public ArrayList<LobbyUser> getLobbyUsers() {
        return lobbyUsers;
    }

    public void setLobbyUsers(ArrayList<LobbyUser> lobbyUsers) {
        this.lobbyUsers = lobbyUsers;
    }
}
