package Service;

import model.HibernateUtil;
import model.RoomReservation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomReservationDao {
    private SessionFactory sessionFactory = HibernateUtil.sessionFactory;


    public List<RoomReservation> showInformation(int nationalCode) {
        Session session = sessionFactory.openSession();
        List<RoomReservation> list = session.createQuery("from RoomReservation r where r.user.id=: id")
                .setParameter("id", nationalCode)
                .list();
        session.close();
        return list;
    }

    public void cancelReserve(int reserveCode) {
        Session session = sessionFactory.openSession();
        Transaction txn = session.beginTransaction();
        Query query = session.createQuery(
                "DELETE RoomReservation as r" +
                        " WHERE r.reserveCode = :reserveCode"
        ).setParameter("reserveCode", reserveCode);
        query.executeUpdate();
        txn.commit();
        session.close();
    }

    public void saveNewReserve(RoomReservation room) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(room);
        session.getTransaction().commit();
        session.close();
    }

    public void updateReserve(RoomReservation room, int reserveCode) {
        Session session = sessionFactory.openSession();
        Transaction txn = session.beginTransaction();
        Query query = session.createQuery(
                "UPDATE RoomReservation as r" +
                        " SET r.capacity = :capacity, r.startDate = :startDate, r.endDate = :endDate" +
                        " WHERE r.reserveCode = :reserveCode"
        ).setParameter("capacity", room.getCapacity())
                .setParameter("startDate", room.getStartDate())
                .setParameter("endDate", room.getEndDate())
                .setParameter("reserveCode", reserveCode);
        query.executeUpdate();
        txn.commit();
        session.close();

    }

    public int returnReserveCode() {
        Session session = sessionFactory.openSession();
        Transaction txn = session.beginTransaction();
        org.hibernate.Query query = session.createQuery(" select max (r.id) from RoomReservation as r ");
        List<Integer> list = query.getResultList();
        txn.commit();
        session.close();
        if (!list.isEmpty()) {
            return list.get(0);
        }
        return -1;
    }
}



