import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter(filterName = "capacityFilter")
public class capacityFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        int capacity=Integer.parseInt(req.getParameter("capacity"));
        PrintWriter out = resp.getWriter();
        Pattern pattern= Pattern.compile("[1,2,3,4]");
        Matcher matcher=pattern.matcher(String.valueOf(capacity));
        if (matcher.matches()){
            chain.doFilter(req, resp);
        }else{
            out.println("Invalid Capacity:");
            RequestDispatcher rd= req.getRequestDispatcher("form.html");
            rd.forward(req,resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
