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
            ${item.defaultMessage}
        </c:forEach>
    </c:if>
    <c:if test="${!empty message}">
        ${message}
    </c:if>
    <br/><img src="${student.profilePhoto}" width="150" height="150"/>
    <form action="${pageContext.request.contextPath}/it/u/student" method="post" >
        <input type="hidden" name="_method" value="put">
        <input type="hidden" name="id" value="${student.id}">
        <input type="hidden" name="createAt" value="${student.createAt}">
        <input type="hidden" name="updateAt" value="${student.updateAt}">
        <br/>
        <br/>
        <table border="0">
            <tr>
                <td align="right">账号：</td>
                <td><input type="text" name="name" value="${student.name}"/></td>
            </tr>
            <tr>
                <td align="right">密码：</td>
                <td><input type="text" name="password" /></td>
            </tr>
            <tr>
                <td align="right">性别：</td>
                <td><input type="text" name="sex" value="${student.sex}" readonly/></td>
            </tr>
            <tr>
                <td align="right">电话：</td>
                <td><input type="text" name="tel" value="${student.tel}" readonly/></td>
            </tr>
            <tr>
                <td align="right">邮箱：</td>
                <td><input type="text" name="email" value="${student.email}" readonly/></td>
            </tr>
            <tr>
                <td align="center">QQ：</td>
                <td><input type="text" name="qq" value="${student.qq}" /></td>
            </tr>
            <tr>
                <td align="right">修真类型：</td>
                <td><input type="text" name="whatType" value="${student.whatType}"  /></td>
            </tr>
            <tr>
                <td align="right">预计入学时间：</td>
                <td><input type="text" name="joinTime" value="${student.joinTime}" /></td>
            </tr>
            <tr>
                <td align="center">毕业院校：</td>
                <td><input type="text" name="school" value="${student.school}" /></td>
            </tr>
            <tr>
                <td align="right">学号：</td>
                <td><input type="text" name="studentId" value="${student.studentId}" readonly /></td>
            </tr>
            <tr>
                <td align="right">日报链接：</td>
                <td><input type="text" name="link" value="${student.link}" /></td>
            </tr>
            <tr>
                <td align="center">愿望：</td>
                <td><input type="text" name="wishes" value="${student.wishes}" /></td>
            </tr>
            <tr>
                <td align="right">师兄：</td>
                <td><input type="text" name="tutorBro" value="${student.tutorBro}" /></td>
            </tr>
            <tr>
                <td align="right">从哪里知道修真院的：</td>
                <td><input type="text" name="knowFrom" value="${student.knowFrom}" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="保存修改" /></td>
            </tr>
        </table>
    </form>

    <br/>
    <a href="${pageContext.request.contextPath}/it/u/recommend">放弃修改</a>
    <br/><br/>
</div>
</body>
</html>