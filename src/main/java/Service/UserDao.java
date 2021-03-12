package Service;

import model.HibernateUtil;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserDao {

    private SessionFactory sessionFactory= HibernateUtil.sessionFactory;


    public User findContactById(int id){
        Session session= sessionFactory.openSession();
        User user=session.get(User.class,id);
        session.close();
        return user;
    }

}
