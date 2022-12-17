package Charackter;

import Yep.Start;
import org.hibernate.Session;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CharakterMgr {

    private ArrayList<Character> characters;


    public CharakterMgr() {
        Session s = Start.getHibernateUtil().getSessionFactory().getCurrentSession();
        s.beginTransaction();
        List<Objects[]> o = s.createSQLQuery("SELECT count(id) FROM character ").list();
        s.getTransaction().commit();
        int max = Integer.parseInt(o.get(0).toString());
        s.beginTransaction();
        for(int i = 0; i < max; i++) {
            characters.add((Character) s.load(Character.class, i));

        }
        s.getTransaction().commit();
        for(Character c : characters) {
            try {
                c.setImg(ImageIO.read(getClass().getResource("c/" + c.getId() + ".png")));
            } catch (IOException e) {

            }
        }

    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }
}
