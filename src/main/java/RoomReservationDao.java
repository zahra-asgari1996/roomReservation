import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class RoomReservationDao {


    public void addNewReserve(RoomReservation reserve) {
        try {
            DbConnection dbConnection = new DbConnection();
            Class.forName(DbConnection.getJdbcDriver());
            Connection connection = DriverManager.getConnection(DbConnection.getDbUrl(), DbConnection.getUSER(), DbConnection.getPASS());
            Statement stm = connection.createStatement();
            String query = "insert into roomreservation(name,lastName,nationalCode,startDate,endDate,capacity,roomNumber)values(?,?,?,?,?,?,?)";
            String q = "select roomNumber from roomreservation";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = stm.executeQuery(q);
            int roomNumber = 1;
            while (resultSet.next()) {
                roomNumber = resultSet.getInt("roomNumber");
                roomNumber++;
            }
            statement.setString(1, reserve.getName());
            statement.setString(2, reserve.getLastName());
            statement.setInt(3, reserve.getNationalCode());
            statement.setDate(4, reserve.getStartDate());
            statement.setDate(5, reserve.getEndDate());
            statement.setInt(6, reserve.getCapacity());
            statement.setInt(7, roomNumber);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int returnReserveCode() {

        List<Integer> code=new ArrayList<>();
        try {
            DbConnection dbConnection = new DbConnection();
            Class.forName(DbConnection.getJdbcDriver());
            Connection connection = DriverManager.getConnection(DbConnection.getDbUrl(), DbConnection.getUSER(), DbConnection.getPASS());
            Statement stm = connection.createStatement();
            String q = "select reserveCode from roomreservation";
            ResultSet resultSet = stm.executeQuery(q);
            while (resultSet.next()) {
                 code.add(resultSet.getInt("reserveCode"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return code.get(code.size()-1);

    }
}