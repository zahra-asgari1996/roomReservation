import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

@WebServlet(name = "reservation")
public class reservationServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int reserveNumber=50000;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name=request.getParameter("firstName");
        String lastName=request.getParameter("lastName");
        int nationalCode=Integer.valueOf(request.getParameter("nationalCode"));
        Date startDate= Date.valueOf(request.getParameter("startDate"));
        Date endDate= Date.valueOf(request.getParameter("endDate"));
        int capacity=Integer.valueOf(request.getParameter("capacity"));
        RoomReservation reserve=new RoomReservation(name,lastName,nationalCode,capacity,startDate,endDate,reserveNumber++);
        RoomReservationDao roomReservationDao=new RoomReservationDao();
        roomReservationDao.addNewReserve(reserve);

    }
}
