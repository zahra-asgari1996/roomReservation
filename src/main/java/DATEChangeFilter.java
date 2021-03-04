import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

@WebFilter(filterName = "DATEChangeFilter")
public class DATEChangeFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        java.sql.Date startDate= java.sql.Date.valueOf(req.getParameter("startDate"));
        java.sql.Date endDate= Date.valueOf(req.getParameter("endDate"));
        if (endDate.after(startDate)){
            chain.doFilter(req, resp);
        }else{
            out.println("Invalid Date");
            RequestDispatcher rd= req.getRequestDispatcher("ChangeForm.html");
            rd.include(req,resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
