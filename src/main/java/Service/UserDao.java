package Service;

import model.HibernateUtil;
import model.RoomReservation;
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

    public  void saveNewUser(User user){
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }



}
