package Controller;

import Entity.News;
import Service.NewService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "NewsMainServlet",urlPatterns ="/NewsMainServlet" )
public class NewsMainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        NewService newService=new NewService();
        try{
            List<News> lstNews=newService.QueryNews();
            request.setAttribute("lstNews",lstNews);
            request.getRequestDispatcher("NewsMain.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
