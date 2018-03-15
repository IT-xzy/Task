<%--<html>--%>
<%--<link href="https://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.css" rel="stylesheet">--%>
<%--<body>--%>
<%--<h2>Hello World!</h2>--%>
<%--<form action="${pageContext.request.contextPath }/loginPage" method="get">--%>
    <%--<br><br>--%>
    <%--<input type="submit" class="btn btn-danger" value="登陆">--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE html >
<html>
<head>
    <title>首页</title>
    <style type="text/css">
        a {
            text-decoration: none;
            color: #fff;
            font-size: 14px;
        }

        h3 {
            width: 180px;
            height: 38px;
            margin: 100px auto;
            text-align: center;
            line-height: 38px;
            background: #5BC0DE;
            border-radius: 4px;
        }
    </style>
</head>
<body>
<h3>
    <a href="${pageContext.request.contextPath }/talent">欢迎来到基佬分院</a>
</h3>
</body>
</html>