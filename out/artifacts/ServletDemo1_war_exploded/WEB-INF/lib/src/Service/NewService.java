package Service;

import Entity.News;
import DAL.SqlHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewService {
    public boolean AddNews(News news){
        String sql="insert into news values("+
                "'"+news.getNewsID()+"',"+
                "'"+news.getCategory()+"',"+
                "'"+news.getTitle()+"',"+
                "'"+news.getNewsContent()+"',"+
                "'"+news.getAuthor()+"',"+
                "'"+news.getNewsDate()+"')";
        System.out.println(sql);
        boolean result=SqlHelper.executeUpdate(sql);
        return  result;

    }
    public boolean DeleteNews(int newsID){
        String sql="delete from News where NewsID="+newsID;
        System.out.println(sql);
        boolean result=SqlHelper.executeUpdate(sql);
        return  result;
}
    public boolean UpdateNews(News news){
            String sql="update news set Category='"+
                    news.getCategory()+"',"+
                    "Title='"+news.getTitle()+"',"+
                    "NewsContent='"+news.getNewsContent()+"',"+
                    "Author='"+news.getAuthor()+"',"+
                    "NewsDate='"+news.getNewsDate()+
                    "'where NewsID="+news.getNewsID();

        System.out.println(sql);
        boolean result=SqlHelper.executeUpdate(sql);
        return  result;
    }
    public  List<News> QueryNews() throws SQLException {
        String sql="Select *from News";
        ResultSet rs;
        rs= SqlHelper.executeQuery(sql);
        List<News> lstNews=new ArrayList<News>();
        while(rs.next())
        {
            News news=new News();
            news.setNewsID(rs.getInt("NewsID"));
            news.setTitle(rs.getString("Title"));
            news.setNewsContent(rs.getString("NewsContent"));
            news.setCategory(rs.getString("Category"));
            news.setAuthor(rs.getString("Author"));
            news.setNewsDate(rs.getDate("NewsDate"));
            lstNews.add(news);
        }
        return lstNews;
    }
    public News GetNews(int newID) throws SQLException {
        String sql="Select *from News where NewsID="+newID;
        ResultSet rs;
        rs= SqlHelper.executeQuery(sql);
        News news = new News();
        if(rs.next())
        {
            news.setNewsID(rs.getInt("NewsID"));
            news.setTitle(rs.getString("Title"));
            news.setNewsContent(rs.getString("NewsContent"));
            news.setCategory(rs.getString("Category"));
            news.setAuthor(rs.getString("Author"));
            news.setNewsDate(rs.getDate("NewsDate"));
        }
        return news;
    }

}
