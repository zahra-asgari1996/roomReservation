import Service.RoomReservationDao;
import Service.UserDao;
import model.User;
import org.hibernate.SessionFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "form")
public class formServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String req = request.getParameter("option");
        if(req.equalsIgnoreCase("reserve")){
            RequestDispatcher rd=request.getRequestDispatcher("form.html");
            rd.forward(request,response);
        }else if(req.equalsIgnoreCase("show")){
            HttpSession session=request.getSession(false);
            if (session!=null) {
                String  n = (String) session.getAttribute("user");
                UserDao userDao =new UserDao();
                User user= userDao.findContactById(Integer.valueOf(n));
                out.print("welcome" +" "+ user.getName() );
                RoomReservationDao reservationDao=new RoomReservationDao();
                out.println(reservationDao.showInformation(user.getNationalCode()).toString());
            }else {
                out.println("You Should Login First");
                RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
                rd.include(request,response);
            }
        }else if(req.equalsIgnoreCase("cancel")){
            RequestDispatcher rd=request.getRequestDispatcher("CancelForm.html");
            rd.forward(request,response);
        }else {
            RequestDispatcher rd=request.getRequestDispatcher("ChangeForm.html");
            rd.forward(request,response);
        }
        out.println("<br><br><a href= 'logout'>Log out</a>");

    }
}
