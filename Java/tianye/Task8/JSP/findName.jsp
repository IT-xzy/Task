<%--
  Created by IntelliJ IDEA.
  User: 田野
  Date: 2018/8/7
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>查询</title>
</head>
<body>
<table cellpadding="0" cellspacing="0" border="1"
       style=" border-collapse: collapse;min-height: 300px;width: 1800px;text-align: center;">

    <tr>
        <td colspan="19" align="left">
            <form action="/findName" method="get">
                学号: <input name="userName">
                <input type="submit" value="查询"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>账号名</td>
        <td>密码</td>
        <td>姓名</td>
        <td>电话号码</td>
        <td>邮件</td>
        <td>相片</td>
        <td>性别</td>
        <td>QQ</td>
        <td>类型</td>
        <td>学校</td>
        <td>日报链接</td>
        <td>立愿</td>
        <td>师兄</td>
        <td>创建时间</td>
        <td>更新时间</td>
        <td>创建人</td>
        <td>修改人</td>
        <td>修改</td>
        <td>删除</td>
    </tr>
    <c:forEach items="${user}" var="li" varStatus="i">
        <tr>
            <td>${li.userId}</td>
            <td>${li.userPassword}</td>
            <td>${li.userName}</td>
            <td>${li.userTel}</td>
            <td>${li.userMail}</td>
            <td>${li.userPhoto}</td>
            <td>${li.userSex}</td>
            <td>${li.userQq}</td>
            <td>${li.userType}</td>
            <td>${li.userSchool}</td>
            <td>${li.userDailyLink}</td>
            <td>${li.userWords}</td>
            <td>${li.userBrother}</td>
            <td>${li.create_at}</td>
            <td>${li.update_at}</td>
            <td>${li.create_by}</td>
            <td>${li.update_by}</td>
            <td><a href="${path}user/userId/${li.userId}/profile"
                   class="btn btn-info btn-sm">
                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                修改</a>
            </td>
            <td><a type="button" href="${path}/delete?userId=${li.userId}" class="btn btn-danger btn-sm">
                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                删除</a>
            </td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
