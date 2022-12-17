package Charackter;

import Yep.Start;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CharakterMgr {

    private ArrayList<Character> characters;


    public CharakterMgr() {
        characters = new ArrayList<>();
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
            characters.add((Character) s.load(Character.class, i+1));

        }

        s.getTransaction().commit();
        //TODO fic img mport
        for(Character c : characters) {
            try {
                c.setImg(ImageIO.read(getClass().getResource("c/" + c.getId() + ".png")));
            } catch (Exception ignore) {

            }
        }

    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }
}
