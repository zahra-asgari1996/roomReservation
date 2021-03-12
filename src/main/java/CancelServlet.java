import Service.RoomReservationDao;
import Service.UserDao;
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

@WebServlet(name = "ChangeCancelServlet")
public class CancelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession(false);
        if (session!=null) {
            String n = (String) session.getAttribute("user");
            UserDao userDao=new UserDao();
            User user= userDao.findContactById(Integer.valueOf(n));
            out.print("welcome" +" "+ user.getName());
            int code=Integer.parseInt(request.getParameter("reserveCode"));
            RoomReservationDao roomReservationDao=new RoomReservationDao();
            roomReservationDao.cancelReserve(code);
            out.println("Canceled successfully");

        }else {
            out.println("You Should Login First");
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
            rd.include(request,response);
        }

        out.println("<br><br><a href= 'logout'>Log out</a>");



    }
}
