package Character;

import NameHistory.NameHistory;
import Yep.Start;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class FightlogMgr {


    public static ArrayList<Fightlog> load(int userid) {
        ArrayList<Fightlog> out = new ArrayList<>();
        Session s = Start.getHibernateUtil().getSessionFactory().getCurrentSession();
//        SQLQuery query = s.createSQLQuery("SELECT charid, games WHERE userid = " + userid);
//        List<Object[]> list = query.list();
        s.beginTransaction();
        SQLQuery query = s.createSQLQuery("SELECT id FROM fightlog WHERE userid = " + userid);
        List list = query.list();
        ArrayList<Integer> ids = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            ids.add(Integer.valueOf(list.get(i).toString()));
        }
        s.getTransaction().commit();

        ids.forEach((id) -> {
            Session session = Start.getHibernateUtil().getSessionFactory().getCurrentSession();
            session.beginTransaction();
            out.add((Fightlog) session.load(Fightlog.class, id) );
            session.getTransaction().commit();
        });

        return out;

    }

}
