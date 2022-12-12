import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Sockathandler {
    private ServerSocket serverSocket;
    private Socket clientSocket;

    private int  port = 6969;
    public void start() {

        try {
            serverSocket = new ServerSocket(port);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (true) {
            try {
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
