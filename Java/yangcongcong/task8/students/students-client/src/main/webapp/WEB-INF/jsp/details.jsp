<%--
  Created by IntelliJ IDEA.
  User: Y
  Date: 18/5/13
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="referrer" content="never">
</head>
<body>
<div style="text-align: center">
    <div class="icon-people">
        <img src="${imagePath}"/>
        <%--<img src="https://yangcongcong007.oss-cn-shenzhen.aliyuncs.com/${u.picture}"/>--%>
    </div>
    <br>
    <table align='center' border='1' cellspacing='0'>
        <tr>id：</tr>
        <tr>${u.id}</tr>
        <br>
        <tr>name：</tr>
        <tr>${u.name}</tr>
        <br>
        <tr>number：</tr>
        <tr>${u.number}</tr>
        <br>
        <tr>qq：</tr>
        <tr>${u.qq}</tr>
        <br>
        <tr>type：</tr>
        <tr>${u.type}</tr>
        <br>
        <tr>university：</tr>
        <tr>${u.university}</tr>
        <br>
        <tr>time：</tr>
        <tr>${u.time}</tr>
        <br>
        <tr>daily_link：</tr>
        <tr>${u.daily_link}</tr>
        <br>
        <tr>pledge：</tr>
        <tr>${u.pledge}</tr>
        <br>
        <tr>senior：</tr>
        <tr>${u.senior}</tr>
        <br>
        <tr>locality：</tr>
        <tr>${u.locality}</tr>
        <br>
        <tr>cellphone：</tr>
        <tr>${u.cellphone}</tr>
        <br>
        <tr>email：</tr>
        <tr>${u.email}</tr>
        <br>
        <tr>picture：</tr>
        <tr>${u.picture}</tr>
        <br>
        <tr>create_at：</tr>
        <tr>${u.create_at}</tr>
        <br>
        <tr>update_at：</tr>
        <tr>${u.update_at}</tr>
        <br>

    </table>

    <form action="/u/users" method="get">
        <input type="submit" value="返回"/>
    </form>
</div>

</body>
</html>
