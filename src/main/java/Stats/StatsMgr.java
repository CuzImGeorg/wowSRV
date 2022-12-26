package Stats;

import Yep.Start;
import Yep.User;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import java.util.List;

public class StatsMgr {

    public static Stats load(int userId) {
        Session s = Start.getHibernateUtil().getSessionFactory().getCurrentSession();
//        SQLQuery query = s.createSQLQuery("SELECT charid, games WHERE userid = " + userid);
//        List<Object[]> list = query.list();
        s.beginTransaction();
        SQLQuery query = s.createSQLQuery("SELECT id FROM stats WHERE userid = " + userId);
        List list = query.list();
        int  id = Integer.parseInt(list.get(0).toString());
        s.getTransaction().commit();
        s = Start.getHibernateUtil().getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Stats stats = (Stats) s.load(Stats.class, id);
        s.getTransaction().commit();

        return stats;
    }

    public static Stats getDefautValues(int userid) {
        Session s = Start.getHibernateUtil().getSessionFactory().getCurrentSession();
        s.beginTransaction();
        User u = (User) s.load(User.class, userid);
        s.getTransaction().commit();
        return new Stats(0, 0, 0, 0, u);

    }


}
