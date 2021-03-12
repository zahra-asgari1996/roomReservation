import Service.UserDao;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SignupServlet")
public class SignupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String lastName=request.getParameter("lname");
        int nationalCode=Integer.valueOf(request.getParameter("nationalCode"));
        int pass=Integer.valueOf(request.getParameter("pass"));
        User user=new User(nationalCode,pass,name,lastName);
        UserDao userDao=new UserDao();
        userDao.saveNewUser(user);
        request.getRequestDispatcher("index.jsp").include(request,response);

    }
}
