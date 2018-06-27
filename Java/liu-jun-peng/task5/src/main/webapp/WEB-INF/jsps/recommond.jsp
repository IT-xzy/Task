<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: caoyue
  Date: 2018/4/23
  Time: 下午6:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/recommend.css">
    <title>葡萄藤</title>
</head>
<body>
<div><img src="img/01.png" alt="" class="img-responsive"></div>
<main>
    <div class="container">
        <span style="margin-top:20px">首页&gt;<a href="">合作企业</a></span>
        <div class="left-list text-center">
            <strong>合作企业</strong>
            <ul>
                <li>
                    <a href="">阿里巴巴</a>
                </li>
                <li>
                    <a href="">土豆网</a>
                </li>
                <li>
                    <a href="">阿里巴巴</a>
                </li>
                <li>
                    <a href="">土豆网</a>
                </li>
                <li>
                    <a href="">阿里巴巴</a>
                </li>
                <li>
                    <a href="">土豆网</a>
                </li>
                <li>
                    <a href="">阿里巴巴</a>
                </li>
            </ul>
        </div>
        <div class="right-list text-center hidden-xs">
            <img src="img/title.png" alt="">
            <c:forEach items="${recsList}" var="item">
            <strong>帝国师</strong>
            <p>${item.name}</p>
            <p><strong>简介</strong><br></p>
            <blockquote>
                ${item.introduction}

</blockquote>
        </div>
    </div>
</main>
</c:forEach>
</body>
</html>
