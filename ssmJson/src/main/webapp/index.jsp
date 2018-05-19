<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%--<%--%>
    <%--pageContext.setAttribute("path", request.getContextPath());--%>
<%--%>--%>
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
    <a type="button"  href="${pageContext.request.contextPath}/studentInfo" class="btn btn-info btn-sm">
        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
        进入用户管理页</a>
</h3>
</body>
</html>