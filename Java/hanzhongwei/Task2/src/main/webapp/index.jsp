<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    //    pageContext.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE htm >
<html>
<head>
    <title>首页</title>
    <style type="text/css">
        body {
            background-color: darkorange;
        }

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
<h3>欢迎来到葡糖藤仙界</h3>
<h3>这里是修正学院</h3>
<h3>
    <a href="http://47.93.52.227/hzw/student">进入学员管理页</a>

    <%--<a href="${path }/hzw/student">进入学员管理页</a>--%>
</h3>
<h3><a href="http://47.93.52.227/hzw/listStudent1">进入学员管理页(普通)</a></h3>
<h3><a href="http://47.93.52.227/hzw/student1">进入学员管理页(不mav)</a></h3>

</body>
</html>
