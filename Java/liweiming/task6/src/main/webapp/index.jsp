<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户管理</title>
    <link rel="stylesheet" href="static/css/mine.css">
</head>
<body>

<script src="http://leaverou.github.com/prefixfree/prefixfree.min.js"></script>

<div id="nav">
    <ul class="nav-menu clearfix unstyled">
        <li>
            <a href="${pageContext.request.contextPath}/home" class="three-d">
                进入主页
                <span class="three-d-box"><span class="front">进入主页</span><span class="back">进入主页</span></span>
            </a>
        </li>

        <li>
            <a href="${pageContext.request.contextPath}/viewLogin" class="three-d">
                学员登录
                <span class="three-d-box"><span class="front">学员登录</span><span class="back">学员登录</span></span>
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/registers" class="three-d">
                学员注册
                <span class="three-d-box"><span class="front">学员注册</span><span class="back">学员注册</span></span>
            </a>
        </li>


    </ul>
</div>
</body>
</html>

