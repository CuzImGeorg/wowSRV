package Character;

import NameHistory.NameHistory;
import Stats.Stats;
import Yep.Start;
import Yep.User;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import Character.Settings;

import java.awt.event.KeyEvent;

import java.util.List;

public class SettingsMgr {


    public static Settings load(int userId) {
        Session s = Start.getHibernateUtil().getSessionFactory().getCurrentSession();
        s.beginTransaction();
        SQLQuery query = s.createSQLQuery("SELECT id FROM settings WHERE userid = " + userId);
        List list = query.list();
        int  id = Integer.parseInt(list.get(0).toString());
        s.getTransaction().commit();
        s = Start.getHibernateUtil().getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Settings settings = (Settings) s.load(Settings.class, id);
        s.getTransaction().commit();

        return settings;
    }

    public static Settings getDefautValues(int userid) {
        return new Settings(KeyEvent.VK_Q, KeyEvent.VK_W, KeyEvent.VK_E, KeyEvent.VK_R, userid);
    }
}
