<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE HTML>
<html>
<head>
    <title>首页</title>
    <style type="text/css">
        a {
            text-decoration: none;
            color: #050802;
            font-size: 18px;
        }

        h3 {
            width: 180px;
            height: 38px;
            margin: 100px auto;
            text-align: center;
            line-height: 38px;
            background: deepskyblue;
            border-radius: 4px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    基于SSM框架的管理系统：简单实现增、删、改、查。
                </h1>
            </div>
        </div>
    </div>
</div>
<br><br>
<h3>
    <a href="${path }/allPaper">点击进入管理页面</a>
    <br><br>
    <br><br>

    <form action="/json" >
        <p>
            <%--<label>根据ID查询返回Json：</label> <input type="text"  name ="paperId" >--%>
                <label>查询所有记录返回Json：</label>
            <button type="submit" >查询</button>
        </p>
    </form>
</h3>
</body>
</html>