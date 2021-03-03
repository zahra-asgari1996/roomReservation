import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter(filterName = "ChangeReserveCodeFilter")
public class ChangeReserveCodeFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        int reserveCode=Integer.parseInt(req.getParameter("reserveCode"));
        Pattern pattern = Pattern.compile("[0-9]{5}");
        Matcher matcher = pattern.matcher(String.valueOf(reserveCode));
        if (matcher.matches()){
            chain.doFilter(req, resp);
        }else{
            out.println("Invalid Reserve Code");
            RequestDispatcher rd= req.getRequestDispatcher("ChangeForm.html");
            rd.include(req,resp);
        }

    }



    public void init(FilterConfig config) throws ServletException {

    }

}
