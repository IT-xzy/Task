<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学员报名信息详情</title>
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
                    IT修真树 <small>学员报名信息 - by ssm基础框架</small>
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
                <h1>学员详细信息</h1>
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
                    <th>报名时间</th>
                    <th>更新时间</th>
                    <th>入学时间</th>
                    <th>毕业院校</th>
                    <th>线上学号</th>
                    <th>日报链接</th>
                    <th>入学立愿</th>
                    <th>师兄学号</th>
                    <th>从何知晓</th>
                </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${stu.stuName}</td>
                        <td>${stu.QQ}</td>
                        <td>${stu.lessonType}</td>
                        <td>${stu.createTime}</td>
                        <td>${stu.updateTime}</td>
                        <td>${stu.admissionTime}</td>
                        <td>${stu.graduatedSchool}</td>
                        <td>${stu.stuNumber}</td>
                        <td>${stu.diaryLink}</td>
                        <td>${stu.wish}</td>
                        <td>${stu.brotherId}</td>
                        <td>${stu.heardFrom}</td>
                        <form action="${pageContext.request.contextPath}/s/update/${stu.id}" method="get">
                            <input type="submit" value="更新报名信息">
                        </form>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
