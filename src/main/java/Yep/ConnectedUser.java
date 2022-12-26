package Yep;

import Charackter.AbillityExec;
import Charackter.Character;
import NameHistory.NameHistorMgr;
import NameHistory.NameHistory;
import Played.Played;
import Played.PlayedMrg;
import Stats.StatsMgr;
import Stats.Stats;
import org.hibernate.Session;
import org.hibernate.cfg.UniqueConstraintHolder;
import org.hibernate.metamodel.source.binder.UniqueConstraintSource;

import javax.persistence.UniqueConstraint;
import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

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
            case CREATEUSER -> {
                Session session = Start.getHibernateUtil().getSessionFactory().getCurrentSession();
                try {


                    session.beginTransaction();
                    session.save(senderObject.getUser());
                    session.getTransaction().commit();
                    User u = Start.getUserManager().loadUer(senderObject.getUser().getUsername(), senderObject.getUser().getPassword());

                    Stats s = StatsMgr.getDefautValues(u.getId());
                    session = Start.getHibernateUtil().getSessionFactory().getCurrentSession();
                    session.beginTransaction();
                    session.save(s);
                    session.getTransaction().commit();
                    NameHistory n = NameHistorMgr.getDefautValues(u.getId());
                    session = Start.getHibernateUtil().getSessionFactory().getCurrentSession();
                    session.beginTransaction();
                    session.save(n);
                    session.getTransaction().commit();
                    ArrayList<Played> playeds =  PlayedMrg.getDefautValues(u.getId());
                    session = Start.getHibernateUtil().getSessionFactory().getCurrentSession();
                    session.beginTransaction();
                    for (Played p : playeds) {
                        session.save(p);
                    }
                    session.getTransaction().commit();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                    session.getTransaction().rollback();
                }




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
                    user.setPassword("hahanotapasswort");
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
            case GETALLCHARS -> {
                SenderObject s = new SenderObject(Instruction.REQUESTUSER);
                s.setCharacters(Start.getCharakterMgr().getCharacters());
                try {
                    objectOutputStream.writeObject(s);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            case SELCHAR -> {
                Character _tmp = new Character();
                Character character = Start.getCharakterMgr().getCharacters().get(senderObject.getC());
                c.setId(character.getId());
                c.setHp(character.getMaxHp());
                c.setMaxHp(character.getMaxHp());
                c.setAd(character.getAd());
                c.setAp(character.getAp());
                c.setShield(0);
                c.setCdr(0);
                c.setName(character.getName());
                c.setKlasse(character.getKlasse());

                c = _tmp;
            }
            case EXAB -> {
                if(abillityExec != null) {
                    senderObject.setUser(user);
                    abillityExec.execAbility(senderObject);
                }
            }
            case REQPSTATS -> {
                SenderObject s = new SenderObject(Instruction.REQPSTATS);
                s.setStats(StatsMgr.load(user.getId()));
                try {
                    objectOutputStream.writeObject(s);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            default -> {
                return;
            }
        }
    }
    private Character c;
    public Character getCIfSetOrWait() {

        while (true) {
            if(c != null) {
                return c;
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private AbillityExec abillityExec;

    public void setAbillity(AbillityExec abillityExec) {
        this.abillityExec = abillityExec;
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
