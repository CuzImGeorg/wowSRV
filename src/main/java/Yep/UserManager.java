package Yep;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import java.util.List;

public class UserManager {

    public void createUser() {

    }

    public User loadUer(String usr, String pwd) {
       Session session = Start.getHibernateUtil().getSessionFactory().getCurrentSession();
       session.beginTransaction();
       SQLQuery s = session.createSQLQuery("SELECT id, username, password, level, xp, lastlogon, createdate, description, status  FROM reg_user WHERE username like '"  + usr + "' and password like '" + pwd + "'" );
        List<Object[]> rows = s.list();

       if(rows.size() == 0) {
           return null;
       }

       User user = new User();
       Object[] row = rows.get(0);
       user.setId(Integer.parseInt( row[0].toString()));
       user.setUsername(row[1].toString());
       user.setLevel(Integer.parseInt(row[3].toString()));
       user.setXp(Integer.parseInt(row[4].toString()));
       if(row[5] != null) {
           user.setLastlogon(row[5].toString());
       }
        if(row[6] != null) {
            user.setCreatedate(row[6].toString());

        }
        if(row[7] != null) {
            user.setDescription(row[7].toString());
        }
        if(row[8] != null) {
            user.setStatus(row[8].toString());
        }
//       User user = (User) list.get(0);
       session.getTransaction().commit();
       return user;
    }



}
