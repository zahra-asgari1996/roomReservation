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
        HttpSession session = request.getSession(false);
        if (session != null) {
            if (userName == null || pass==null) {
                out.println("Plz Fill The User Name And Pass");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.include(request, response);

            } else {
                UserDao userDao = new UserDao();
                User user = userDao.findContactById(Integer.parseInt(userName));
                if (user.getNationalCode() == Integer.parseInt(userName) && user.getPass() == Integer.parseInt(pass)) {
                    session.setAttribute("user", userName);
                    session.setAttribute("pass", pass);
                    out.println("hello" + " " + user.getName() + " " + user.getLastName());
                    request.getRequestDispatcher("fourAction.html").include(request, response);

                } else {
                    out.println("Sorry Invalid Username Or Pass");
                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                    rd.include(request, response);

                }
            }
        }else{
            out.println("You should log in first");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.include(request, response);
        }

        out.println("<br><br><a href= 'logout'>Log out</a>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
