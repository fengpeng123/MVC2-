package Controller;

import Entity.News;
import Service.NewService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns= "/SaveNewsServlet")
public class SaveNewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        News news=new News();
        news.setNewsID(Integer.valueOf(request.getParameter("newid")));
        news.setTitle(request.getParameter("title"));
        news.setAuthor(request.getParameter("author"));
        String newsDate=request.getParameter("writedate");
        SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date sDate = null;
        try {
            java.util.Date jDate = sDateFormat.parse(newsDate);
            sDate = new java.sql.Date(jDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        news.setNewsDate(sDate);
        news.setNewsContent(request.getParameter("newcontent"));
        NewService service=new NewService();
        service.UpdateNews(news);
        request.getRequestDispatcher("ShowNewsListServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
