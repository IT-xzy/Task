<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--json标签 支持<json:object>--%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/7
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>列表</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <style>
        .infodiv{
            margin-left:20px;
        }
    </style>
</head>
<body>
<div class="backhome">

</div>
<div class="">
    <form action="/urg/user/list"  class="from">
        <a  class="btn btn-default"  href="/index.jsp">返回主页</a>
        <button type="submit"  class="btn btn-default" >去列表页</button>
    </form>
</div>
<div class="info infodiv">
    <c:if test="${!empty info}">
        ${info}
    </c:if>
</div>
<div class="message infodiv">
<c:if test="${!empty message}">
    ${message}
</c:if>
</div>
<table class="table table-hover ">
    <thead>
    <tr>
        <th></th>
        <th>ID</th>
        <th>姓名</th>
        <th>密码</th>
        <th>QQ</th>
        <th>邮箱</th>
        <th>地址</th>
        <th>电话</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${!empty reguser}">
        <tr>
            <td>${info}</td>
            <td>${reguser.id}</td>
            <td>${reguser.name}</td>
            <td>${reguser.pwd}</td>
            <td>${reguser.qq}</td>
            <td>${reguser.email}</td>
            <td>${reguser.address}</td>
            <td>${reguser.tell}</td>
        </tr>
    </c:if>
    <c:if test="${!empty requestScope.users}">
        <c:forEach items="${requestScope.users}"  var="user">
        <tr>
            <td></td>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.pwd}</td>
            <td>${user.qq}</td>
            <td>${user.email}</td>
            <td>${user.address}</td>
            <td>${user.tell}</td>
        </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
<div>
    <div>
        <c:if test="${!empty usersJson}">
            <h6>json对象</h6>
            ${usersJson}
            <table>
                <thead>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${userJson.name}</td>
                        <td class="" id="namejson">
                            <script>
                                $().ready(var obj =${userJson};
                                $("#namejson").value(obj);)
                            </script>

                        </td>
                    </tr>
                </tbody>
            </table>

        </c:if>
    </div>
    <div>
        <c:if test="${!empty usersJsonStr}">
            <h6>json字符串</h6>
            ${usersJsonStr}
        </c:if>
    </div>
</div>
<div>
    <json:object>
        <json:property name="itemCount" value="${usersJson}"/>
    </json:object>
</div>
</body>
</html>
