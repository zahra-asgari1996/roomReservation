

import Service.RoomReservationDao;
import Service.UserDao;
import model.RoomReservation;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;


@WebServlet(name = "reservation")
public class reservationServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        String name=request.getParameter("firstName");
//        String lastName=request.getParameter("lastName");
//        int nationalCode=Integer.valueOf(request.getParameter("nationalCode"));
//        java.sql.Date startDate= java.sql.Date.valueOf(request.getParameter("startDate"));
//        java.sql.Date endDate= Date.valueOf(request.getParameter("endDate"));
//        int capacity=Integer.valueOf(request.getParameter("capacity"));
//
//        RoomReservation reserve=new RoomReservation(name,lastName,nationalCode,capacity,startDate,endDate);
//        RoomReservationDao roomReservationDao=new RoomReservationDao();
//        roomReservationDao.addNewReserve(reserve);
//        out.println("You Reserved Room Successfully");
//        out.println();
//        out.println("Your Reservation Code Is: ");
//        out.println();
//        out.println(roomReservationDao.returnReserveCode());

        response.setContentType("text/html");
        //String name=request.getParameter("firstName");
        //String lastName=request.getParameter("lastName");
        //int nationalCode=Integer.valueOf(request.getParameter("nationalCode"));
        java.sql.Date startDate= java.sql.Date.valueOf(request.getParameter("startDate"));
        java.sql.Date endDate= Date.valueOf(request.getParameter("endDate"));
        int capacity=Integer.valueOf(request.getParameter("capacity"));
       // int reserveCode=Integer.parseInt(request.getParameter("reserveCode"));
//        RoomReservation room=new RoomReservation(name,lastName,nationalCode,capacity,startDate,endDate);
//        RoomReservationDao roomReservationDao=new RoomReservationDao();
//        roomReservationDao.changeReserve(reserveCode,room);

        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession(false);
        if (session!=null) {
            String n = (String) session.getAttribute("user");
            UserDao userDao=new UserDao();
            User user= userDao.findContactById(Integer.valueOf(n));
            out.print("welcome" +" "+ user.getName());
            RoomReservation room=new RoomReservation(user,capacity,startDate,endDate);
            RoomReservationDao roomReservationDao=new RoomReservationDao();
            roomReservationDao.saveNewReserve(room);
        }else {
            out.println("You Should Login First");
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
            rd.include(request,response);
        }
        out.println("<br><br><a href= 'logout'>Log out</a>");
    }
}
