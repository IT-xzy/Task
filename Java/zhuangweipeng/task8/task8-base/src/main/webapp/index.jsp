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
<h3>
    <a href="${path }/allPaper">点击进入管理页面</a>
</h3>
<h3>
    <%--查询所有json--%>
    <form action="/json">
        <p>
            <%--<label>根据ID查询返回Json：</label> <input type="text"  name ="paperId" >--%>
            <label>查询所有记录返回Json：</label>
            <button type="submit">查询</button>
        </p>
    </form>
</h3>
<h3>
    <%--根据ID查询数据--%>
    <form action="/queryOne" method="get">
        <%--<form action="FIND">--%>
        查询用户:id=<input type="text" name="id" value="">
        <%--<p id="buttons">--%>
        <input id="submit" type="submit" value="查询">
        </p>
    </form>
</h3>
<h3>
    <%--根据ID查询json--%>
    <form action="/json/one">
        <p>
            <label>根据ID查询记录返回Json：</label>
            <input type="text" name="paperId">
            <input id="submit1" type="submit" value="查询">
        </p>
    </form>
</h3>
</body>
</html>