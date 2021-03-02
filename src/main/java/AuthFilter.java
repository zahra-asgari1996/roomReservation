import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter(filterName = "AuthFilter")
public class AuthFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        int nationalCode=Integer.parseInt(req.getParameter("nationalCode"));
        Pattern pattern = Pattern.compile("[0-9]{10}");
        Matcher matcher = pattern.matcher(String.valueOf(nationalCode));
        if (matcher.matches()){
            int capacity=Integer.parseInt(req.getParameter("capacity"));
            pattern=Pattern.compile("[1,2,3,4]");
            matcher=pattern.matcher(String.valueOf(capacity));
            if (matcher.matches()){
                out.println("ok!!");
                chain.doFilter(req, resp);
            }else{
                RequestDispatcher rd= req.getRequestDispatcher("form.html");
                rd.forward(req,resp);
            }

        }else{
            RequestDispatcher rd= req.getRequestDispatcher("form.html");
            rd.forward(req,resp);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
