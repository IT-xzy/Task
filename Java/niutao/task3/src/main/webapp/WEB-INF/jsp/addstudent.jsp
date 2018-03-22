<%--
  Created by IntelliJ IDEA.
  User: Blue
  Date: 2018/1/10
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学员</title>
</head>
<body>
<form action="/student" method="post">
    <table>
        <tr>
            <td><label>名字</label></td>
            <td><input type="text"  name="name"></td>
        </tr>
        <tr>
            <td><label>QQ</label></td>
            <td><input type="text"  name="qq"></td>
        </tr>
        <tr>
            <td><label>班级ID</label></td>
            <td><input type="text"  name="class_id"/></td>
        </tr>
        <tr>
            <td><label>毕业学校</label></td>
            <td><input type="text"  name="graduate_school"/></td>
        </tr>
        <tr>
            <td><label>学号</label></td>
            <td><input type="text"  name="oline_number"/></td>
        </tr>
        <tr>
            <td><label>日报链接</label></td>
            <td><input type="text"  name="link"/></td>
        </tr>
        <tr>
            <td><label>誓言</label></td>
            <td><input type="text"  name="wish"/></td>
        </tr>
        <tr>
            <td><label>师兄</label></td>
            <td><input type="text"  name="brother_id"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="增加" /></td>
        </tr>
    </table>
</form>

</body>
</html>
