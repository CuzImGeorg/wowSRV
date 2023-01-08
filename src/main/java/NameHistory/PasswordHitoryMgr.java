package NameHistory;

import Yep.Start;
import Yep.User;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PasswordHitoryMgr {

    public static ArrayList<PasswordHistory> load(int userid) {
        ArrayList<PasswordHistory> arrayList = new ArrayList<PasswordHistory>();
        Session s = Start.getHibernateUtil().getSessionFactory().getCurrentSession();
//        SQLQuery query = s.createSQLQuery("SELECT charid, games WHERE userid = " + userid);
//        List<Object[]> list = query.list();
        s.beginTransaction();
        SQLQuery query = s.createSQLQuery("SELECT id FROM passwordhistory WHERE userid = " + userid);
        List list = query.list();
        ArrayList<Integer> ids = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            ids.add(Integer.valueOf(list.get(i).toString()));
        }
        s.getTransaction().commit();

        ids.forEach((id) -> {
            Session session = Start.getHibernateUtil().getSessionFactory().getCurrentSession();
            session.beginTransaction();
            arrayList.add((PasswordHistory) session.load(PasswordHistory.class, id) );
            session.getTransaction().commit();
        });
        return arrayList;
    }

    public static PasswordHistory getDefautValues(int userid) {
        Session s = Start.getHibernateUtil().getSessionFactory().getCurrentSession();
        s.beginTransaction();
        User u = (User) s.load(User.class, userid);
        s.getTransaction().commit();
        return new PasswordHistory(0 , u,  LocalDateTime.now().toString(),u.getPassword());

    }
}
