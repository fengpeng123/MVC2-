import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@WebServlet(urlPatterns ="/Getcookie" )
public class Getcookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie coo[]=request.getCookies();
        for(Cookie co :coo)
        {
            String userValue= URLDecoder.decode(co.getValue(),"utf-8");
            System.out.println(co.getName()+":"+userValue);
            response.getWriter().println(userValue);
        }
    }
}
