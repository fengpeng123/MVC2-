import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import static java.lang.Class.forName;

@WebServlet(urlPatterns ="/LoginServlet" )
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html; charset=GB2312");
//        request.setCharacterEncoding("GB2312");
        PrintWriter out = response.getWriter(); //获得输出流
        //从请求对象中获得指定参数的值
        String strName = request.getParameter("txtName");
        String strPwd = request.getParameter("txtPwd");
        out.println("您好！" + strName + " "+strPwd + "<br>");

        Connection conn = null;   Statement stmt;   ResultSet rs;
        PreparedStatement pstmt;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=student", "sa", "123456");
            String sql="select * from Students where stuName=? and stuPwd=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,strName);
            pstmt.setString(2,strPwd);
            rs=pstmt.executeQuery();
            if(rs.next())
            {

                out.println("您好！" + strName + " "+strPwd + "<br>");
                System.out.println("用户名："+strName);
                System.out.println("密码："+strPwd);
                Cookie cooUserName=new Cookie("username",strName);
                cooUserName.setMaxAge(60*60*24*30);
                response.addCookie(cooUserName);

                Cookie cooPwd=new Cookie("pwd",strPwd);
                cooPwd.setMaxAge(60*60*24*30);
                response.addCookie(cooPwd);

                HttpSession session=request.getSession(true);
                session.setAttribute("username",strName);

                String path =request.getContextPath();
                String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
                String page =basePath+"/page/index.html";
                System.out.println(basePath);
                response.sendRedirect(page);
            }
            else
            {
                out.println("错误的用户名和密码");
            }
            rs.close(); pstmt.close();	conn.close();
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }





    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
