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

    public  void saveNewReserve(RoomReservation room){
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        session.save(room);
        session.getTransaction().commit();
        session.close();
    }

    public void updateReserve(RoomReservation room,int reserveCode){
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
}


//    public void addNewReserve(RoomReservation reserve) {
//        try {
//            DbConnection dbConnection = new DbConnection();
//            Class.forName(DbConnection.getJdbcDriver());
//            Connection connection = DriverManager.getConnection(DbConnection.getDbUrl(), DbConnection.getUSER(), DbConnection.getPASS());
//            Statement stm = connection.createStatement();
//            String query = "insert into roomreservation(name,lastName,nationalCode,startDate,endDate,capacity,roomNumber)values(?,?,?,?,?,?,?)";
//            String q = "select roomNumber from roomreservation";
//            PreparedStatement statement = connection.prepareStatement(query);
//            ResultSet resultSet = stm.executeQuery(q);
//            int roomNumber = 1;
//            while (resultSet.next()) {
//                roomNumber = resultSet.getInt("roomNumber");
//                roomNumber++;
//            }
//            statement.setString(1, reserve.getName());
//            statement.setString(2, reserve.getLastName());
//            statement.setInt(3, reserve.getNationalCode());
//            statement.setDate(4, (Date) reserve.getStartDate());
//            statement.setDate(5, (Date) reserve.getEndDate());
//            statement.setInt(6, reserve.getCapacity());
//            statement.setInt(7, roomNumber);
//            statement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public int returnReserveCode() {
//
//        List<Integer> code=new ArrayList<>();
//        try {
//            DbConnection dbConnection = new DbConnection();
//            Class.forName(DbConnection.getJdbcDriver());
//            Connection connection = DriverManager.getConnection(DbConnection.getDbUrl(), DbConnection.getUSER(), DbConnection.getPASS());
//            Statement stm = connection.createStatement();
//            String q = "select reserveCode from roomreservation";
//            ResultSet resultSet = stm.executeQuery(q);
//            while (resultSet.next()) {
//                 code.add(resultSet.getInt("reserveCode"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return code.get(code.size()-1);
//
//    }
//
//    public List<RoomReservation> showInformation(int nationalCode){
//        List <RoomReservation> information=new ArrayList<>();
//
//        try {
//            DbConnection dbConnection = new DbConnection();
//            Class.forName(DbConnection.getJdbcDriver());
//            Connection connection = DriverManager.getConnection(DbConnection.getDbUrl(), DbConnection.getUSER(), DbConnection.getPASS());
//            Statement stm = connection.createStatement();
//            String q = "select * from roomreservation where roomreservation.nationalCode="+nationalCode;
//            ResultSet resultSet = stm.executeQuery(q);
//            while (resultSet.next()) {
//                String name=resultSet.getString("name");
//                String lastName=resultSet.getString("lastName");
//                int nationalId=resultSet.getInt("nationalCode");
//                Date startDate=resultSet.getDate("startDate");
//                Date endDate=resultSet.getDate("endDate");
//                //int reserveCode=resultSet.getInt("reserveCode");
//                //int roomNumber=resultSet.getInt("roomNumber");
//                int capacity=resultSet.getInt("capacity");
//                RoomReservation room=new RoomReservation(name,lastName,nationalId,capacity,startDate,endDate);
//                information.add(room);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return information;
//
//    }
//    public void cancelReserve(int reserveCode){
//        try {
//            DbConnection dbConnection = new DbConnection();
//            Class.forName(DbConnection.getJdbcDriver());
//            Connection connection = DriverManager.getConnection(DbConnection.getDbUrl(), DbConnection.getUSER(), DbConnection.getPASS());
//            Statement stm = connection.createStatement();
//            String q = "DELETE FROM roomreservation WHERE roomreservation.reserveCode="+reserveCode;
//            stm.executeUpdate(q);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//    public void changeReserve(int reserveCode, RoomReservation reserve){
//        try {
//            DbConnection dbConnection = new DbConnection();
//            Class.forName(DbConnection.getJdbcDriver());
//            Connection connection = DriverManager.getConnection(DbConnection.getDbUrl(), DbConnection.getUSER(), DbConnection.getPASS());
//            String query = "UPDATE roomreservation SET name=?,lastName=?,nationalCode=?,startDate=?,endDate=?,capacity=? WHERE reserveCode="+reserveCode;
//            PreparedStatement statement = connection.prepareStatement(query);
//            statement.setString(1, reserve.getName());
//            statement.setString(2, reserve.getLastName());
//            statement.setInt(3, reserve.getNationalCode());
//            statement.setDate(4, (Date) reserve.getStartDate());
//            statement.setDate(5, (Date) reserve.getEndDate());
//            statement.setInt(6, reserve.getCapacity());
//            statement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

