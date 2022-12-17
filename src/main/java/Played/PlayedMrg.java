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
        SQLQuery query = s.createSQLQuery("SELECT charid, games WHERE userid = " + userid);
        List<Object[]> list = query.list();

        for (Object[] o : list) {
            Played p = new Played(userid, Integer.parseInt(o[0].toString()), Integer.parseInt(o[0].toString()));
            arrayList.add(p);
        }

        return arrayList;
    }

    public static ArrayList<Played> getDefautValues(int userid) {
        ArrayList<Played> arrayList = new ArrayList<Played>();
        arrayList.add(new Played(userid, 1 , 0));
        arrayList.add(new Played(userid, 2 , 0));
        arrayList.add(new Played(userid, 3 , 0));
        arrayList.add(new Played(userid, 4 , 0));
        arrayList.add(new Played(userid, 5 , 0));
        arrayList.add(new Played(userid, 6 , 0));
        arrayList.add(new Played(userid, 7 , 0));
        arrayList.add(new Played(userid, 8 , 0));
        arrayList.add(new Played(userid, 9 , 0));
        return arrayList;
    }

}
