<%--
  Created by IntelliJ IDEA.
  User: Blue
  Date: 2018/1/12
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新</title>
</head>
<body>
<form action="/updatestudent" method="post">
    <table>
        <tr>
            <td><label>ID</label></td>
            <td><input type="text"  name="id" value="${student.id}" /></td>
        </tr>

        <tr>
            <td><label>名字</label></td>
            <td><input type="text"  name="name" value="${student.name}"/></td>
        </tr>
        <tr>
            <td><label>QQ</label></td>
            <td><input type="text"  name="qq" value="${student.qq}"/></td>
        </tr>
        <tr>
            <td><label>班级ID</label></td>
            <td><input type="text"  name="class_id" value="${student.class_id}"/></td>
        </tr>
        <tr>
            <td><label>毕业学校</label></td>
            <td><input type="text"  name="graduate_school" value="${student.graduate_school}"/></td>
        </tr>
        <tr>
            <td><label>学号</label></td>
            <td><input type="text"  name="oline_number" value="${student.oline_number}"/></td>
        </tr>
        <tr>
            <td><label>日报链接</label></td>
            <td><input type="text"  name="link" value="${student.link}"/></td>
        </tr>
        <tr>
            <td><label>誓言</label></td>
            <td><input type="text"  name="wish" value="${student.wish}"/></td>
        </tr>
        <tr>
            <td><label>师兄</label></td>
            <td><input type="text"  name="brother_id" value="${student.brother_id}"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="更新" /></td>
        </tr>
    </table>
</form>

</body>
</html>