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

@WebServlet(name = "ChangeServlet")
public class ChangeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        java.sql.Date startDate= java.sql.Date.valueOf(request.getParameter("startDate"));
        java.sql.Date endDate= Date.valueOf(request.getParameter("endDate"));
        int capacity=Integer.valueOf(request.getParameter("capacity"));
        //int reserveCode=Integer.parseInt(request.getParameter("reserveCode"));
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
            int code=Integer.parseInt(request.getParameter("reserveCode"));
            RoomReservation room=new RoomReservation(user,capacity,startDate,endDate);
            RoomReservationDao roomReservationDao=new RoomReservationDao();
            roomReservationDao.updateReserve(room,code);


        }else {
            out.println("You Should Login First");
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
            rd.include(request,response);
        }

        out.println("<br><br><a href= 'logout'>Log out</a>");

    }
}
