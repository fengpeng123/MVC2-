<%--
  Created by IntelliJ IDEA.
  User: 冯鹏
  Date: 2020/6/24
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="ueditor/ueditor.config.js"></script>
    <script type="text/javascript" src="ueditor/ueditor.all.js"></script>
    <script type="text/javascript" charset="utf-8" src="ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<body>
<form action="SaveAddNewsServlet" method="post" id="edit_news">
    <div class="newsID">
        新闻ID：<input type="text" name="newid"/>
    </div>
    <div class="newsTitle">
        新闻标题：<input type="text" name="title"/>
    </div>
    <div class="author">
        作者:<input type="text" name="author"/>
    </div>
    <div class="newsDate">
        时间：<input type="text" name="writedate"/>
    </div>
    <div>
        <textarea id="myEditor" name="newcontent" style="width: 800px; height: 400px; margin: 0 auto;"></textarea>
    </div>
    <div class="addNews">
        <input type="submit" value="添加保存"/>
    </div>

</form>
   <%--/*实例化编辑器*/--%>
    <script type="text/javascript">
         var ue = UE.getEditor("myEditor");
    </script>
</body>
    <style>
        form{
            background-color: #fff;
            height:1000px ;
            width: 100%;
            top: 220px;
        }
        .newsID input{
            width: 20px;
            margin-bottom: 20px;
        }
        .newsTitle input{
            width: 160px;
            margin-bottom: 20px;
        }
        .newsContent textarea{
            margin-bottom: 20px;
            vertical-align: top
        }
        .author input{
            width: 80px;
            margin-bottom: 20px;
        }
        .newsDate input{
            width: 80px;
            margin-bottom: 20px;
        }
        .addNews input{
            width: 80px;
            height: 60px;
            float: right;
            margin-right: 15px;
            font-size: 18px;
        }
    </style>
</html>
