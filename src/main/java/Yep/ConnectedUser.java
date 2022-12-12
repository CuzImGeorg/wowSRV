package Yep;

import UserMgr.User;
import org.hibernate.Session;

import java.io.*;
import java.net.Socket;

public class ConnectedUser {
    private User user;
    private Socket socket;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;

    public ConnectedUser(Socket s) {
        this.socket = s;
    }

    public void start() {
       Thread t = new Thread( ()-> {
           try {
               InputStream inputStream = socket.getInputStream();
               objectInputStream = new ObjectInputStream(inputStream);
               OutputStream outputStream = socket.getOutputStream();
               objectOutputStream = new ObjectOutputStream(outputStream);

           } catch (IOException e) {
               throw new RuntimeException(e);
           }
           while (true) {
               try {
                   SenderObject object = (SenderObject) objectInputStream.readObject();
                    handleClient(object);
               } catch (IOException | ClassNotFoundException e) {
                   throw new RuntimeException(e);
               }
               try {
                   Thread.sleep(40);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }

           }
       });

    }

    public void handleClient(SenderObject senderObject) {
        switch (senderObject.getInstruction()) {
            case CREATEUSER ->{
               Session session = Start.getHibernateUtil().getSessionFactory().getCurrentSession();
               session.beginTransaction();
               session.save(senderObject.getUser());
               session.getTransaction().commit();

            }
            case DELETEUSER -> {

            }
            case REQUESTUSER -> {
                try {
                    objectOutputStream.writeObject(Start.getUserManager().loadUer(senderObject.getUser().getUsername(), senderObject.getUser().getPassword()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            default -> {
                return;
            }
        }
    }

}
