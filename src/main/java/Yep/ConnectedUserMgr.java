package Yep;

import java.util.ArrayList;

public class ConnectedUserMgr {
    private ArrayList<ConnectedUser> connectedUsers = new ArrayList<>();


    public ArrayList<ConnectedUser> getConnectedUsers() {
        return connectedUsers;
    }
    public void addUser(ConnectedUser c) {
        connectedUsers.add(c);
    }
}
