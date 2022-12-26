package Lobby;

import Character.Character;
import Yep.ConnectedUser;
import Yep.Instruction;
import Yep.SenderObject;

import java.io.IOException;
import java.util.ArrayList;

public class LobbyUser {
    private ConnectedUser user;
    private Character character;
    private int team;

    public  LobbyUser(ConnectedUser user) {
        this.user = user;
    }


    public ConnectedUser getUser() {
        return user;
    }

    public void setUser(ConnectedUser user) {
        this.user = user;
    }

    public void waitForCham(ArrayList<LobbyUser> users) {
        Thread t = new Thread(()->{
            character = user.getCIfSetOrWait();
            for (LobbyUser lu: users  ) {
                SenderObject s = new SenderObject(Instruction.GETCHARS);
                s.setUser(user.getUser());
                s.setCharacter(character);
                try {
                    lu.getUser().getObjectOutputStream().writeObject(s);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t.start();
    }

    public Character getCharackter() {
        return character;
    }

    public void setCharackter(Character character) {
        this.character = character;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }
}
