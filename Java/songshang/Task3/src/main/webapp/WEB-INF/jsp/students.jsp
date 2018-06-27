<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学员信息首页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    IT修真树
                    <small>学员报名信息 - by ssm基础框架</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <ul class="nav nav-tabs">
                <li class="active"><a href="${pageContext.request.contextPath}/s/students">学员信息首页</a></li>
                <li><a href="${pageContext.request.contextPath}/s/register">学员报名</a></li>
                <li class="disabled"><a href="#">网站信息</a></li>
            </ul>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>学员列表</h1>
                <div class="searchDiv" align="right">
                    <form action="${pageContext.request.contextPath}/s/students/name" method="get">
                        根据学员姓名查找：<input name="name" type="text" value=""/><input type="submit" value="提交"/>
                    </form>
                </div>
            </div>
        </div>

    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>姓名</th>
                    <th>QQ</th>
                    <th>修真类型</th>
                    <th>毕业院校</th>
                    <th>线上学号</th>
                    <th>查看详情</th>
                    <th>删除学员</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${lists.list}" var="student">
                    <tr>
                        <td>${student.stuName}</td>
                        <td>${student.QQ}</td>
                        <td>${student.lessonType}</td>
                        <td>${student.graduatedSchool}</td>
                        <td>${student.stuNumber}</td>
                        <td>
                            <form action="${pageContext.request.contextPath}/s/students/${student.id}" method="GET">
                                <input type="submit" value="查看详情"></form>
                        </td>
                        <td>
                            <form action="${pageContext.request.contextPath}/s/students/${student.id}" method="post">
                                <input type="hidden" name="_method" value="DELETE">
                                <input type="submit" value="删除">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div align="right">
                <a href="${pageContext.request.contextPath}/s/students?currPage=${lists.currPage-1}">上一页</a>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/s/students?currPage=${lists.currPage+1}">下一页</a>
                &nbsp;&nbsp;&nbsp;&nbsp;
                第${lists.currPage}/${lists.totalPage}页
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <form action="${pageContext.request.contextPath}/s/students" method="get" style="margin:0px;display:inline;">
                    <input type="text" name="currPage" value="">
                    <input type="submit" value="跳转">
                </form>
            </div>
        </div>
    </div>
</div>

<div class="footer" margin:20px>
   <p></p>
    <p></p>
    <p></p>
    <p></p>
</div>
</body>
</html>
