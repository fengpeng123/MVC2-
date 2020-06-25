import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(urlPatterns ="/Setcookie")
public class Setcookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName= URLEncoder.encode("username","utf-8");
        String userPwd= URLEncoder.encode("pwd","utf-8");
        Cookie cooName=new Cookie("username",userName);
        Cookie cooPwd=new Cookie("pwd",userPwd);
        //cooName.setMaxAge(60*60*24*30);
        //cooPwd.setMaxAge(60*60*24*30);
        response.addCookie(cooName);
        response.addCookie(cooPwd);
    }
}
