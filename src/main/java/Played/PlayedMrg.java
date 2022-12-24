package Played;

import Yep.Start;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class PlayedMrg {

    public static ArrayList<Played> laod(int userid) {
        ArrayList<Played> arrayList = new ArrayList<Played>();
        Session s = Start.getHibernateUtil().getSessionFactory().getCurrentSession();
//        SQLQuery query = s.createSQLQuery("SELECT charid, games WHERE userid = " + userid);
//        List<Object[]> list = query.list();
        s.beginTransaction();
        SQLQuery query = s.createSQLQuery("SELECT id FROM played WHERE userid = " + userid);
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

//    public static ArrayList<Played> getDefautValues(int userid) {
//        ArrayList<Played> arrayList = new ArrayList<Played>();
//        arrayList.add(new Played(userid, 1 , 0));
//        arrayList.add(new Played(userid, 2 , 0));
//        arrayList.add(new Played(userid, 3 , 0));
//        arrayList.add(new Played(userid, 4 , 0));
//        arrayList.add(new Played(userid, 5 , 0));
//        arrayList.add(new Played(userid, 6 , 0));
//        arrayList.add(new Played(userid, 7 , 0));
//        arrayList.add(new Played(userid, 8 , 0));
//        arrayList.add(new Played(userid, 9 , 0));
//        return arrayList;
//    }

}
