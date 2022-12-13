package Yep;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Sockathandler {
    private ServerSocket serverSocket;
    private Socket clientSocket;

    private int  port = 6969;
    public void start() {

        Thread t = new Thread(()-> {
            try {
                serverSocket = new ServerSocket(port);
                System.out.println("Opend Server Socket");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            while (true) {
                try {
                    clientSocket = serverSocket.accept();
                    System.out.println("new Client Connect " + clientSocket.getInetAddress().getHostAddress());
                    Start.getConnectedUserMgr().addUser(new ConnectedUser(clientSocket));
                    for(ConnectedUser u : Start.getConnectedUserMgr().getConnectedUsers()) {
                        System.out.println(u.getSocket().getInetAddress().getHostAddress());
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        t.start();


    }
}
