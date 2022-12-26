package NameHistory;

import Played.Played;
import Stats.Stats;
import Yep.Start;
import Yep.User;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NameHistorMgr {

    public static ArrayList<NameHistory> load(int userid) {
        ArrayList<NameHistory> arrayList = new ArrayList<NameHistory>();
        Session s = Start.getHibernateUtil().getSessionFactory().getCurrentSession();
//        SQLQuery query = s.createSQLQuery("SELECT charid, games WHERE userid = " + userid);
//        List<Object[]> list = query.list();
        s.beginTransaction();
        SQLQuery query = s.createSQLQuery("SELECT id FROM usernamehistory WHERE userid = " + userid);
        List list = query.list();
        ArrayList<Integer> ids = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            ids.add(Integer.valueOf(list.get(i).toString()));
        }
        s.getTransaction().commit();
        ids.forEach((id) -> {
            Session session = Start.getHibernateUtil().getSessionFactory().getCurrentSession();
            session.beginTransaction();
            arrayList.add((NameHistory) session.load(NameHistory.class, id) );
            session.getTransaction().commit();
        });
        return arrayList;
    }

    public static NameHistory getDefautValues(int userid) {
        Session s = Start.getHibernateUtil().getSessionFactory().getCurrentSession();
        s.beginTransaction();
        User u = (User) s.load(User.class, userid);
        s.getTransaction().commit();
        return new NameHistory(0 , u,  LocalDateTime.now().toString(),u.getUsername());

    }


}
