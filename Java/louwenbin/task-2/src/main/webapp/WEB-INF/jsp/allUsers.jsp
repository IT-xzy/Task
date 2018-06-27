<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>查询全部</title>
</head>
<body>
<c:forEach items="${allUsers}" var="user">
    <table border="3">
        <tr>
            <td>ID</td>
            <th>
                    ${user.id}
                <form action="/user/${user.id}" method="post">
                    <input type="hidden" name="_method" value="DELETE"/>
                    <input type="submit" value="删除">
                </form>
            </th>

        </tr>
        <tr>
            <td>姓名</td>
            <td>${user.name}</td>
        </tr>
        <tr>
            <td>性别</td>
            <td>${user.sex}</td>
        </tr>
        <tr>
            <td>qq</td>
            <td>${user.qq}</td>
        </tr>
        <tr>
            <td>修真类型</td>
            <td>${user.type}</td>
        </tr>
        <tr>
            <td>入学时间</td>
            <td>${user.admission}</td>
        </tr>
        <tr>
            <td>线上学号</td>
            <td>${user.graduate}</td>
        </tr>
        <tr>
            <td>日报链接</td>
            <td>${user.link}</td>
        </tr>
        <tr>
            <td>立愿</td>
            <td>${user.wish}</td>
        </tr>
        <tr>
            <td>辅导师兄</td>
            <td>${user.audit}</td>
        </tr>
        <tr>
            <td>从何处了解</td>
            <td>${user.understand}</td>
        </tr>
        <tr>
            <td>创建时间</td>
            <td>${user.create_at}</td>
        </tr>
        <tr>
            <td>更新时间</td>
            <td>${user.update_at}</td>
        </tr>
    </table>
</c:forEach>
<table border="3">
    <th>
        <a href="/user/result">
            <input type="submit" value="增加">
        </a>
    </th>
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

</body>
</html>
