package Yep;

import UserMgr.UserManager;

public class Start {

    private static ConnectedUserMgr connectedUserMgr;
    private static Sockathandler sockathandler;
    private static HibernateUtil hibernateUtil;
    private static UserManager userManager;

    public static void main(String[] args) {
        connectedUserMgr = new ConnectedUserMgr();
        hibernateUtil = new HibernateUtil();
        userManager = new UserManager();
        sockathandler = new Sockathandler();
        sockathandler.start();
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
}
