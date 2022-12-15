package Yep;

import org.hibernate.Session;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class ConnectedUser {
    private User user;
    private Socket socket;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;

    public ConnectedUser(Socket s) {
        this.socket = s;
        start();
    }

    public void start() {
       Thread t = new Thread( ()-> {
           try {

               OutputStream outputStream = socket.getOutputStream();
               objectOutputStream = new ObjectOutputStream(outputStream);
               InputStream inputStream = socket.getInputStream();
               objectInputStream = new ObjectInputStream(socket.getInputStream());


           } catch (IOException e) {
               throw new RuntimeException(e);
           }
           while (true) {
               try {
                   SenderObject object = (SenderObject) objectInputStream.readObject();
                    handleClient(object);
               } catch (SocketException e) {
                   Start.getConnectedUserMgr().getConnectedUsers().remove(this);

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
        t.start();
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
                    SenderObject s = new SenderObject(Instruction.REQUESTUSER);
                    for(ConnectedUser cu : Start.getConnectedUserMgr().getConnectedUsers()) {
                        if(cu.getUser() != null) {
                            if(cu.getUser().getUsername().equals(senderObject.getUser().getUsername())) {
                                s.setCode(69);
                                objectOutputStream.writeObject(s);
                                return;
                            }
                        }

                    }
                    this.user = Start.getUserManager().loadUer(senderObject.getUser().getUsername(), senderObject.getUser().getPassword());
                    s.setUser(user);
                    objectOutputStream.writeObject(s);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            case UPDATEUSER -> {
                Session session = Start.getHibernateUtil().getSessionFactory().getCurrentSession();
                session.beginTransaction();
                session.update(senderObject.getUser());
                session.getTransaction().commit();
            }
            case JOINQUEUE -> {
                Start.getQueue().joinQueue(this);
            }
            default -> {
                return;
            }
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public ObjectInputStream getObjectInputStream() {
        return objectInputStream;
    }

    public void setObjectInputStream(ObjectInputStream objectInputStream) {
        this.objectInputStream = objectInputStream;
    }

    public ObjectOutputStream getObjectOutputStream() {
        return objectOutputStream;
    }

    public void setObjectOutputStream(ObjectOutputStream objectOutputStream) {
        this.objectOutputStream = objectOutputStream;
    }
}
