package Yep;

import Character.AbillityExec;
import Character.Charakter;
import Lobby.Lobby;
import Lobby.LobbyUser;
import NameHistory.NameHistorMgr;
import NameHistory.NameHistory;
import Played.Played;
import Played.PlayedMrg;
import Queue.QueueUser;
import Stats.StatsMgr;
import Stats.Stats;
import org.hibernate.Session;
import Character.SettingsMgr;
import Character.Settings;
import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static Yep.Instruction.*;

public class ConnectedUser {
    private User user;
    private Socket socket;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private Lobby lobby;


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

                    session = Start.getHibernateUtil().getSessionFactory().getCurrentSession();
                    Settings settings = SettingsMgr.getDefautValues(u.getId());
                    session.beginTransaction();
                    session.save(settings);
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
                    s.setUser(user);
                    objectOutputStream.writeObject(s);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                SenderObject so = new SenderObject( REQUESTUSER);
                so.setQueueUser1(new QueueUser(user, Start.getCharakterMgr().getCharacters().get(0), 1));

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
            case DC -> {
                Start.getConnectedUserMgr().getConnectedUsers().remove(this);
            }
            case SELCHAR -> {
                SenderObject so = new SenderObject(SELCHAR);
                Charakter charakter = Start.getCharakterMgr().getCharacters().get(senderObject.getC());
                for (LobbyUser l : lobby.getUsers()) {
                    if(l.getCharackter() != null) {
                        if(l.getTeam() == getUser(user.getId()).getTeam() && l.getCharackter().getId() == charakter.getId()) {
                            so.setCode(4);

                            break;
                        }
                    }

                }
                if(so.getCode() != 4) {
                    c = new Charakter();
                    c.setId(charakter.getId());
                    c.setHp(charakter.getMaxHp());
                    c.setMaxHp(charakter.getMaxHp());
                    c.setAd(charakter.getAd());
                    c.setAp(charakter.getAp());
                    c.setShield(0);
                    c.setCdr(0);
                    c.setName(charakter.getName());
                    c.setKlasse(charakter.getKlasse());
                    c.setA(charakter.getA());
                    System.out.println(user.getUsername() + " " + c.getName());
                }
                try {
                    System.out.println("Hardstuck");
                    getObjectOutputStream().writeUnshared(so);
                    System.out.println("Not Hardstuck");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
            case RDMCHAR -> {
                Random rdm = new Random();
                int r = rdm.nextInt(9)+1;
                ArrayList<Integer> notaviableIds = new ArrayList<>();
                lobby.getUsers().forEach((u) -> {
                    if(u.getCharackter() != null) {
                        notaviableIds.add(u.getCharackter().getId());
                    }
                } );
                while (notaviableIds.contains(r)) {
                    r = rdm.nextInt(9)+1;
                }
                Charakter charakter = Start.getCharakterMgr().getCharacters().get(r-1);
                c = new Charakter();
                c.setId(charakter.getId());
                c.setHp(charakter.getMaxHp());
                c.setMaxHp(charakter.getMaxHp());
                c.setAd(charakter.getAd());
                c.setAp(charakter.getAp());
                c.setShield(0);
                c.setCdr(0);
                c.setName(charakter.getName());
                c.setKlasse(charakter.getKlasse());
                c.setA(charakter.getA());

                SenderObject so = new SenderObject(RDMCHAR);
                so.setCharacter(c);
                try {
                    objectOutputStream.writeUnshared(so);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

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
            }case CHANGENAME -> {
                Session s = Start.getHibernateUtil().getSessionFactory().getCurrentSession();
                s.beginTransaction();
                List l = s.createQuery(" SELECT max(changed)  FROM NameHistory WHERE userid = " + user.getId()).list();
                s.getTransaction().commit();
                NameHistory nh = new NameHistory(Integer.parseInt(l.get(0).toString()) +1, user, LocalDateTime.now().toString(), senderObject.getNewUsername());
                s = Start.getHibernateUtil().getSessionFactory().getCurrentSession();
                s.beginTransaction();
                s.save(nh);
                s.getTransaction().commit();
                user.setUsername(senderObject.getNewUsername());
                s = Start.getHibernateUtil().getSessionFactory().getCurrentSession();
                s.beginTransaction();
                s.update(user);
                s.getTransaction().commit();
            }
            case REQNAMEHISTORY -> {
                SenderObject s = new SenderObject(Instruction.REQNAMEHISTORY);
                ArrayList<NameHistory> names = NameHistorMgr.load(user.getId());
                s.setNameHistory(names);
                try {
                    objectOutputStream.writeObject(s);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            case REQGAMEUSER -> {
                System.out.println("User Requested");
                SenderObject so = new SenderObject(Instruction.REQUESTUSER);
                ArrayList<QueueUser> qu = new ArrayList<>();
                for (LobbyUser u : lobby.getUsers()) {
                    qu.add(new QueueUser(u.getUser().getUser(), u.getCharackter(), u.getTeam()));
                }
                try {
                    qu.forEach((wqewqe) -> System.out.println(wqewqe.getCharackter().getName()));
                } catch (NullPointerException ignore) {

                }
                so.setQueueUsers(qu);
                try {
                    getObjectOutputStream().writeUnshared(so);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } case GETSETTINGS -> {
                SenderObject so = new SenderObject(Instruction.GETSETTINGS);
                so.setSettings(SettingsMgr.load(user.getId()));
                try {
                    objectOutputStream.writeObject(so);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

            default -> {
                return;
            }
        }
    }
    private Charakter c;
    public Charakter getCIfSetOrWait() {

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

    public LobbyUser getUser(int id) {
        for (LobbyUser lu : lobby.getUsers()) {
            if(lu.getUser().getUser().getId() == id) {
                return lu;
            }
        }
        return null;
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

    public void setLobby(Lobby lobby) {
        this.lobby = lobby;
    }
}
