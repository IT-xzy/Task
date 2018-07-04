<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <link rel="stylesheet" href="/task8/css/body.css">
    <title>葡萄藤</title>
</head>
<body>

<div align="center">
    <br/>
    <br/>
    <c:if test="${errors != null && errors.size() >0}">
        <c:forEach items="${errors}" var="item">
            ${item.defaultMessage}<br/>
        </c:forEach>
    </c:if>
    <c:if test="${!empty message}">
        <br/>${message}
    </c:if>
    <form action="${pageContext.request.contextPath}/it/register/result" method="post" >
        <br/>
        <br/>
        <table border="0">
            <tr>
                <td align="right">账号：</td>
                <td><input type="text" name="name" /></td>
            </tr>
            <tr>
                <td align="right">密码：</td>
                <td><input type="text" name="password" /></td>
            </tr>
            <tr>
                <td align="right">性别：</td>
                <td><input type="radio" name="sex" value="男" checked/>男
                    <input type="radio" name="sex" value="女"/>女</td>
            </tr>
            <tr>
                <td align="center">QQ：</td>
                <td><input type="text" name="qq" /></td>
            </tr>
            <tr>
                <td align="right">修真类型：</td>
                <td><input type="text" name="whatType" /></td>
            </tr>
            <tr>
                <td align="right">预计入学时间：</td>
                <td><input type="text" name="joinTime" /></td>
            </tr>
            <tr>
                <td align="center">毕业院校：</td>
                <td><input type="text" name="school" /></td>
            </tr>
            <tr>
                <td align="right">学号：</td>
                <td><input type="text" name="studentId" /></td>
            </tr>
            <tr>
                <td align="right">日报链接：</td>
                <td><input type="text" name="link" /></td>
            </tr>
            <tr>
                <td align="center">愿望：</td>
                <td><input type="text" name="wishes" /></td>
            </tr>
            <tr>
                <td align="right">师兄：</td>
                <td><input type="text" name="tutorBro" /></td>
            </tr>
            <tr>
                <td align="right">从哪里知道修真院的：</td>
                <td><input type="text" name="knowFrom" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="注册" /></td>
            </tr>
        </table>
    </form>

    <br/>
    <a href="${pageContext.request.contextPath}/it/login">返回登录</a>
    <br/><br/>
</div>
</body>
</html>