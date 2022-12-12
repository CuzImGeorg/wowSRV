package UserMgr;

import Yep.Start;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import java.util.List;

public class UserManager {

    public void createUser() {

    }

    public User loadUer(String usr, String pwd) {
       Session session = Start.getHibernateUtil().getSessionFactory().getCurrentSession();
       session.beginTransaction();
       SQLQuery s = session.createSQLQuery("SELECT * FROM reg_user WHERE usernmae like '"  + usr + "' and password like '" + pwd + "'" );
       List list =  s.list();
       if(list.size() == 0) {
           return null;
       }
       User user = (User) list.get(0);
       session.getTransaction().commit();
       return user;
    }



}
