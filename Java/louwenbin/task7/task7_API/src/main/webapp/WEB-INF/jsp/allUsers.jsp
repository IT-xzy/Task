<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>查询全部</title>
</head>

<body>
    <table border="1"  >

        <tr >
            <th>ID</th>
            <th>账号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>qq</th>
            <th>手机号</th>
            <th>邮箱</th>
            <th>照片</th>
            <th>修真类型</th>
            <th>入学时间</th>
            <th>线上学号</th>
            <th>日报链接</th>
            <th>立愿</th>
            <th>辅导师兄</th>
            <th>从何处了解</th>
            <th>创建时间</th>
            <th>更新时间</th>
        </tr>
        <c:forEach items="${allUsers}" var="user">

        <tr>

            <td>                    ${user.id}
                <form action="/user/${user.id}" method="post">
                    <input type="hidden" name="_method" value="DELETE"/>
                    <input type="submit" value="删除">
                </form>
            </td>
            <td>${user.account}</td>
            <td>${user.name}</td>
            <td>${user.sex}</td>
            <td>${user.qq}</td>
            <td>${user.phone}</td>
            <td>${user.email}</td>
            <td>
                <form action="/user/${user.id}" method="post">
                    <input type="submit" value="点击查看">
                </form>
            </td>
            <td>${user.type}</td>
            <td>${user.admission}</td>
            <td>${user.graduate}</td>
            <td>${user.link}</td>
            <td>${user.wish}</td>
            <td>${user.audit}</td>
            <td>${user.understand}</td>
            <td>${user.create_at}</td>
            <td>${user.update_at}</td>
        </tr>
    </c:forEach>
    </table>

<table border="3">
    <%--<th>--%>
        <%--<a href="/user/result">--%>
            <%--<input type="submit" value="增加">--%>
        <%--</a>--%>
    <%--</th>--%>
    <form action="/user" method="post">
        <input type="hidden" value="PUT" name="_method"/>
        <tr>
            <td>
                输入ID<input type="text" name="id">
            </td>
        </tr>
        <tr>
        <td>
        姓名<input type="text" name="name">
        </td>
        </tr>
        <tr>
            <td>
                性别<input type="text" name="sex">
            </td>
        </tr>
        <tr>
            <td>
                qq<input type="text" name="qq">
            </td>
        </tr>
        <tr>
            <td>
                修真类型<input type="text" name="type">
            </td>
        </tr>
        <tr>
            <td>
                入学时间<input type="text" name="admission"><br>
            </td>
        </tr>
        <tr>
            <td>
                线上学号<input type="text" name="graduate">
            </td>
        </tr>

        <tr>
            <td>
                日报链接<input type="text" name="link">
            </td>
        </tr>
        <tr>
            <td>
                立愿<input type="text" name="wish">
            </td>
        </tr>
        <tr>
            <td>
                辅导师兄<input type="text" name="audit">
            </td>
        </tr>
        <tr>
            <td>
                从何处了解<input type="text" name="understand">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="修改">
            </td>
        </tr>
    </form>
</table>
    ${返回通知}
</body>
</html>
