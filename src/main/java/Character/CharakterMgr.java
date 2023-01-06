package Character;

import Yep.Start;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CharakterMgr {

    private ArrayList<Charakter> charakters;


    public CharakterMgr() {
        charakters = new ArrayList<>();
        Session s = Start.getHibernateUtil().getSessionFactory().getCurrentSession();
        s.beginTransaction();
        SQLQuery sqlQuery = s.createSQLQuery("SELECT count(id) FROM character ");
        List o = sqlQuery.list();
        System.out.println(o.size());

        s.getTransaction().commit();
        int max = Integer.parseInt(o.get(0).toString());
        System.out.println(max);
        s = Start.getHibernateUtil().getSessionFactory().getCurrentSession();
        s.beginTransaction();
        for(int i = 0; i < max; i++) {
             Charakter c = (Charakter) s.load(Charakter.class, i+1);
             Set<Ability> a = c.getAbilitys();
             ArrayList<Ability> arrayList = new ArrayList<Ability>(a);
             c.setA(arrayList);
             charakters.add(c);
        }

        s.getTransaction().commit();
    }

    public ArrayList<Charakter> getCharacters() {
        return charakters;
    }
}
