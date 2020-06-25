package DAL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.xml.transform.Result;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


public class SqlHelper {
    private static String  driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String dbURL="jdbc:sqlserver://localhost:1433; DatabaseName=student";
    private static String userName="sa";
    private static String userPwd="123456";
    private static Connection getCoonection()
    {
        try
        {
            Class.forName(driverName);
            Connection conn = DriverManager.getConnection(dbURL,userName,userPwd);
            return conn;
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.print("-----------连接失败");

        }
        return null;
    }
    //select
    public static ResultSet executeQuery(String SQL)
    {
        try{
            Connection conn=getCoonection();
            System.out.println("---------连接数据库成功");
            Statement stmt =conn.createStatement();
            ResultSet rs=stmt.executeQuery(SQL);
            return rs;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.print("---------查询失败");
        }
        return null;
    }
    public  static  boolean executeUpdate(String SQL)
    {
        try
        {
            Connection conn=getCoonection();
            System.out.println("连接数据库成功");

            Statement stmt=conn.createStatement();
            int result=stmt.executeUpdate(SQL);
            if(result>0)
                return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("------更新失败");
        }
        return  false;
    }


}
