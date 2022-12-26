package Played;

import Character.Character;
import Stats.StatsMgr;
import Yep.Start;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class PlayedMrg {

    public static ArrayList<Played> load(int statsId) {
        ArrayList<Played> arrayList = new ArrayList<Played>();
        Session s = Start.getHibernateUtil().getSessionFactory().getCurrentSession();
//        SQLQuery query = s.createSQLQuery("SELECT charid, games WHERE userid = " + userid);
//        List<Object[]> list = query.list();
        s.beginTransaction();
        SQLQuery query = s.createSQLQuery("SELECT id FROM played WHERE statsid = " + statsId);
        List list = query.list();
        ArrayList<Integer> ids = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            ids.add(Integer.valueOf(list.get(i).toString()));
        }
        s.getTransaction().commit();
        ids.forEach((id) -> {
           Session session = Start.getHibernateUtil().getSessionFactory().getCurrentSession();
           session.beginTransaction();
           arrayList.add((Played) session.load(Played.class, id) );
           session.getTransaction().commit();
        });
        return arrayList;
    }

    public static ArrayList<Played> getDefautValues(int userid) {
        Session s = Start.getHibernateUtil().getSessionFactory().getCurrentSession();
        s.beginTransaction();
        int stats = StatsMgr.load(userid).getId();
        s.getTransaction().commit();
        s = Start.getHibernateUtil().getSessionFactory().getCurrentSession();
        s.beginTransaction();

        ArrayList<Played> arrayList = new ArrayList<Played>();
        arrayList.add(new Played(0, (Character) s.load(Character.class, 1), 0, stats));
        arrayList.add(new Played(0, (Character) s.load(Character.class, 2), 0, stats));
        arrayList.add(new Played(0, (Character) s.load(Character.class, 3), 0, stats));
        arrayList.add(new Played(0, (Character) s.load(Character.class, 4), 0, stats));
        arrayList.add(new Played(0, (Character) s.load(Character.class, 5), 0, stats));
//        arrayList.add(new Played(0, (Character) s.load(Character.class, 6), 0, stats));
//        arrayList.add(new Played(0, (Character) s.load(Character.class, 7), 0, stats));
//        arrayList.add(new Played(0, (Character) s.load(Character.class, 8), 0, stats));
//        arrayList.add(new Played(0, (Character) s.load(Character.class, 9), 0, stats));
        s.getTransaction().commit();
        return arrayList;
    }

}
