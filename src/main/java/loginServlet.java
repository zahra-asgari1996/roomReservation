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

@WebServlet(name = "loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String userName = request.getParameter("user");
        String pass = request.getParameter("pass");
        if (userName==null) {
            HttpSession session = request.getSession(false);
            if (session != null) {
                out.println("welcome...");
                RequestDispatcher rd = request.getRequestDispatcher("/profile");
                rd.include(request, response);

            } else {
                out.println("Plz Inter Your Username And Pass");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.include(request, response);
            }

        } else {
            UserDao userDao=new UserDao();
            User user=userDao.findContactById(Integer.parseInt(userName));



            if (user.getNationalCode()==Integer.parseInt(userName)&&user.getPass()==Integer.parseInt(pass)) {
                HttpSession session = request.getSession(true);
                session.setAttribute("user", userName);
                session.setAttribute("pass", pass);
                out.println("hello" + " " + userName);

            } else {
                out.println("Sorry Invalid Username Or Pass");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.include(request, response);

            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
