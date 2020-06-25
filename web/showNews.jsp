<%--
  Created by IntelliJ IDEA.
  User: 冯鹏
  Date: 2020/6/25
  Time: 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!--头部-->
<header>
    <div class="logo">
        <a href="http://localhost:8080/login_war_exploded/login.html">管理员登录</a>
        <div class="logo_search">
            <div class="search_txt">
                <input type="text" placeholder="请输入关键字搜索">
                <div class="search_img"></div>
            </div>
        </div>
    </div>
    <ul>
        <li>网站首页</li><li>学院概况</li><li>本科生教育</li><li>研究生教育</li><li>科学研究</li>
        <li>学生工作</li><li>招生工作</li><li>实验中心</li><li>党建之窗</li><li>抗击疫情</li>
    </ul>
    <img src="img/colonavirus.jpg">
</header>
<main>
    <div class="main_right">
        <div class="title" name="title">${news.title}</div>
        <div class="newscontent" name="newscontent">${news.newsContent}</div>
        <div class="author" name="author">作者：${news.author}</div>
        <div class="writedate" name="writedate">更新时间：${news.newsDate}</div>
    </div>
</main>
<!--底部-->
<footer>
    <div class="swpu">Copyright© 2018 All Rights Reserved. 西南石油大学计算机科学学院</div>
</footer>
</body>
<style>
    header ul{
        width: 970px;
        height: 35px;
        list-style-type: none;
        margin: 0;
        padding: 0;
        overflow: hidden;
        background-color: #0c89ff;
    }
    header li{
        width: 97px;
        float: left;
        text-align: center;
        line-height: 35px;
    }
    header img{
        width: 970px;
        height: 225px;
        background-color: #2a6496;
    }
    .title{
        width: 740px;
        text-align: center;
        font-size: 22px;
        font-weight: bold;
        margin-top: 20px;
    }
    .newscontent{
        text-indent: 2em;
        width: 800px;
        margin: 40px 20px;
        font-size: x-small;
    }
    .author{
        width: 740px;
        text-align:right;
    }
    .writedate{
        float: right;
        margin-top: 40px;
    }

    /*底部*/
    footer{
        width: 100%;
        height: 80px;
        background-color: #2a6496;
    }
    .swpu{
        width: 400px;
        height: 80px;
        margin: 0 auto;
        line-height: 80px;
        font-size: 13px;
        color: white;
    }
</style>
</html>
