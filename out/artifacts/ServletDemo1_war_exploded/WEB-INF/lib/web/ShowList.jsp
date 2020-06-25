<%--
  Created by IntelliJ IDEA.
  User: 冯鹏
  Date: 2020/6/8
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="Iframe.css" />
    <link rel="stylesheet" href="bootstrap.min.css" type="text/css" media="screen" />
</head>

<body>
<%--<span class="cp_title">新闻管理</span>--%>
<div class="news_sent">
    <a href="NewsMainServlet" >新闻主页</a>
</div>
<div class="add_cp">
    <a href="AddNewsServlet">+添加新闻</a>
</div>
<div class="table_con">
    <table style="table-layout: fixed;">
        <tr class="tb_title">
            <td width="10%">ID</td>
            <td width="30%">标题</td>
            <td width="13%">内容</td>
            <td width="12%">作者</td>
            <td width="15%">时间</td>
            <td width="20%">操作</td>
        </tr>
        <c:forEach var="news" items="${lstNews}" >
            <tr>
                <td width="10%">${news.newsID}</td>
                <td width="30%" style="white-space: nowrap;overflow: hidden;text-overflow: ellipsis" >${news.title} </td>
                <td width="13%" style="white-space: nowrap;overflow: hidden;text-overflow: ellipsis">${news.newsContent}</td>
                <td width="12%">${news.author}</td>
                <td width="15%">${news.newsDate}</td>
                <td width="20%">
                    <a href="EditNewsServlet?newid=${news.newsID}" class="del_btn">编辑</a>
                    <a href="ShowNewsServlet?newid=${news.newsID}" class="del_btn">查看</a>
                    <a href="DeleteNewsServlet?newid=${news.newsID}" class="del_btn">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
<style>
    .news_sent{
        font-size: medium;
        color:white;
        height: 30px;
        width: 100px;
        background-color:deepskyblue;
        margin-top: 5px;
        margin-left: 5px;
    }
</style>
</html>
