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
                chain.doFilter(req, resp);
        }else{
            out.println("Invalid NationalCode:");
            RequestDispatcher rd= req.getRequestDispatcher("form.html");
            rd.forward(req,resp);
        }

    }
    public void init(FilterConfig config) throws ServletException {

    }

}
