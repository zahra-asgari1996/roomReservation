import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
            RequestDispatcher rd=request.getRequestDispatcher("nationalCode.html");
            rd.forward(request,response);


        }else if(req.equalsIgnoreCase("cancel")){
            RequestDispatcher rd=request.getRequestDispatcher("reserveCode.html");
            rd.forward(request,response);


        }else {
            RequestDispatcher rd=request.getRequestDispatcher("reserveCode.html");
            rd.forward(request,response);

        }

    }
}
