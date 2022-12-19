package Yep;

import Charackter.CharakterMgr;
import Lobby.LobbyMgr;
import Queue.Queue;
import org.hibernate.Session;

public class Start {

    private static ConnectedUserMgr connectedUserMgr;
    private static Sockathandler sockathandler;
    private static HibernateUtil hibernateUtil;
    private static UserManager userManager;
    private static LobbyMgr lobbyMgr;
    private static Queue queue;
    private static CharakterMgr charakterMgr;

    public static void main(String[] args) {
        connectedUserMgr = new ConnectedUserMgr();
        lobbyMgr = new LobbyMgr();
        queue = new Queue();
        hibernateUtil = new HibernateUtil();
        charakterMgr = new CharakterMgr();
        Session s = hibernateUtil.getSessionFactory().getCurrentSession();
        charakterMgr = new CharakterMgr();
        userManager = new UserManager();
        sockathandler = new Sockathandler();
        sockathandler.start();
//        for (Character c : charakterMgr.getCharacters()) {
//            System.out.println(c.getName() + " " +  c.getId());
//            for (Ability a : c.getAbilitys()) {
//                System.out.println(a.getName() +" ->  " + a.getDescription());
//            }
//        }
    }

    public static ConnectedUserMgr getConnectedUserMgr() {
        return connectedUserMgr;
    }

    public static HibernateUtil getHibernateUtil() {
        return hibernateUtil;
    }

    public static Sockathandler getSockathandler() {
        return sockathandler;
    }

    public static UserManager getUserManager() {
        return userManager;
    }

    public static LobbyMgr getLobbyMgr() {
        return lobbyMgr;
    }

    public static Queue getQueue() {
        return queue;
    }

    public static CharakterMgr getCharakterMgr() {
        return charakterMgr;
    }


}
