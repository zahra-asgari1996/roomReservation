import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

@WebServlet(name = "ChangeServlet")
public class ChangeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String name=request.getParameter("firstName");
        String lastName=request.getParameter("lastName");
        int nationalCode=Integer.valueOf(request.getParameter("nationalCode"));
        java.sql.Date startDate= java.sql.Date.valueOf(request.getParameter("startDate"));
        java.sql.Date endDate= Date.valueOf(request.getParameter("endDate"));
        int capacity=Integer.valueOf(request.getParameter("capacity"));
        int reserveCode=Integer.parseInt(request.getParameter("reserveCode"));
        RoomReservation room=new RoomReservation(name,lastName,nationalCode,capacity,startDate,endDate);
        RoomReservationDao roomReservationDao=new RoomReservationDao();
        roomReservationDao.changeReserve(reserveCode,room);

    }
}
