<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>学员报名</title>
    <meta charset="utf-8" name="viewport" content="width=device-width"
          initial-scale=1 maximum-scale=1 minimum-scale=1 user-scalable=no>
    <script src="/view/jnshu/js/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="/view/jnshu/css/two.css">
    <link href="/view/jnshu/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="/view/jnshu/js/studentsignup.js"></script>
</head>
<body>

<div class="header-end"></div>
<!--main-->
<main>
    <!--main-top-->
    <div class="main-top">
        <p class="main-top-left">
            <a href="/a/home">首页< </a>>
        </p>
        <p class="main-top-right">学员报名</p>
    </div>
    <!--main-left-->
    <div class="main">
        <div class="main-left">
            <p>功能一览</p>
            <div class="main-left-link">
                <a href="#">模块一</a>
                <a href="#">模块二</a>
                <a href="#">模块三</a>
                <a href="#">模块四</a>
                <a href="#">模块五</a>
            </div>
        </div>
        <!--main-right-->
        <div class="right-fix">
            <div class="main-right-top">
                <div class="tudou-logo">
                    <form id="signup">
                        <div id="tip" color="red">请输入你的姓名</div><br/>
                        <input type="text" id="studentName" name="studentName" value=""/>
                        <input type="button" value="报名线下" id="signup_button"/>
                    </form>
                </div>
            </div>
            <div class="main-right-other">
            </div>
        </div>
    </div>
</main>
<!--footer-->


</body>
</html>
