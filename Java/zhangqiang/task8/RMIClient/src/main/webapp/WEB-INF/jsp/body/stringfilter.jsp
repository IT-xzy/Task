<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/28
  Time: 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Filter</title>
    <style>
        .row{
            font: 20px 微软雅黑;
        }
    </style>
</head>
<body>
<div class="register-container container">
    <div class="row">
        <div class="register">
            <div class="col-md-12">
                <h2>过滤测试</h2>
                <p>过滤字符：cs 2b sb</p>
            </div>
        </div>
    </div>
</div>
<div class="register-container container">
    <div class="row">
        <div class="register">
            <form action="/a/stringfilter" method="post">
                <div class="col-md-12">
                    <input type="text" id="text" class="col-md-4" name="note" >&nbsp;<button type="submit" class="btn btn-default" > 提交测试 </button>
                </div>
                <div class="col-md-12 ">

                </div>
            </form>
        </div>
    </div>
</div>

<br/>
<div class="register-container container">
    <div class="row">
        <div class="register">
            <div class="col-md-12">
                <c:if test="${!empty requestScope.fst}" var="item">
                    过滤后的数据：<br/>
                    ${requestScope.fst}<br/>
                </c:if>
            </div>
        </div>
    </div>
</div>

</body>
</html>
