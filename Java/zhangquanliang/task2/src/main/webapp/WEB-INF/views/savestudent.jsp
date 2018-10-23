<%--
  Created by IntelliJ IDEA.
  User: suger
  Date: 2018/10/3
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html charset=UTF-8">
    <title>添加学生信息</title>
    <%--统一样式--%>
    <style>
        .a {
            color: red;
        }
    </style>
<body>


<c:if (day==1) |（day==7)今天周末</c:if>
<form:form modelAttribute="student" action="${pageContext.request.contextPath}/student" method="post">
    <input type="hidden" name="createAt" value="<%=System.currentTimeMillis()%>">
    <input type="hidden" name="updateAt" value="<%=System.currentTimeMillis()%>">
    <table>
        <tr>
            <td>姓名：</td>
            <td><form:input path="name"/></td>
            <td><form:errors path="name" cssStyle="color: red"/></td>
        </tr>
        <tr>
            <td>QQ：</td>
            <td><form:input path="qq"/></td>
            <td><form:errors path="qq" cssClass="a"/></td>
        </tr>
        <tr>
            <td>修真类型：</td>
            <td><input type="text" name="profession"></td>
        </tr>
        <tr>
            <td>入学时间：</td>
            <td><input type="date"  name="startTime"></td>
        </tr>
        <tr>
            <td>毕业院校：</td>
            <td><input type="text" name="graduatedFrom"></td>
        </tr>
        <tr>
            <td>学号：</td>
            <td><input type="text" name="onlineId" min="1" max="2000"></td>
            <td><form:errors path="onlineId" cssClass="a"/></td>
        </tr>
        <tr>
            <td>日报链接：</td>
            <td><input type="url" name="dailyLink"></td>
        </tr>
        <tr>
            <td>立愿：</td>
            <td><input type="text" name="wish"></td>
        </tr>
        <tr>
            <td>辅导师兄：</td>
            <td><input type="text" name="counselor"></td>
        </tr>
        <tr>
            <td>从哪里知道修真院：</td>
            <td><input type="text" name="way"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" name="ok" value="保存"><input type="reset" name="r" value="清空"></td>
        </tr>
    </table>
</form:form>
</body>
