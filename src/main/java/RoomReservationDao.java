import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class RoomReservationDao {

    public void addNewReserve(RoomReservation reserve){
        try {
            DbConnection dbConnection=new DbConnection();
            Class.forName(DbConnection.getJdbcDriver());
            Connection connection = DriverManager.getConnection(DbConnection.getDbUrl(),DbConnection.getUSER(),DbConnection.getPASS());
            //Statement statement = connection.createStatement();
            String query="insert into roomreservation(name,lastName,nationalCode,startDate,endDate,capacity,reserveCode)values(?,?,?,?,?,?,?)";
            PreparedStatement statement= connection.prepareStatement(query);
            statement.setString(1, reserve.getName());
            statement.setString(2, reserve.getLastName());
            statement.setInt(3,reserve.getNationalCode());
            statement.setDate(4,reserve.getStartDate());
            statement.setDate(5,reserve.getEndDate());
            statement.setInt(6,reserve.getCapacity());
            //int uniqueID = UUID.randomUUID().variant();
            statement.setInt(7,reserve.getReserveCode());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
