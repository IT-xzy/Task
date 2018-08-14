<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Edit Student</title>
</head>
<div style="text-align:center">
    请输入需要修改的数据，点击修改按钮
</div>
<body>
<script type="text/javascript" src="js/jquery.min.js"></script>


<div style="text-align:center">
    <h1>学生数据如下</h1>
</div>
<br>
<div>
    <table align='center' border='1' cellspacing='0'>
        <tr>
            <td width="80">id</td>
            <td width="80">createAt</td>
            <td width="80">updateAt</td>
            <td width="80">name</td>
            <td width="80">qq</td>
            <td width="80">studyType</td>
            <td width="80">studyId</td>
            <td width="80">joinTime</td>
            <td width="80">university</td>
            <td width="80">dailyLink</td>
            <td width="80">slogen</td>
            <td width="80">master</td>

        </tr>
        <%--不是集合，直接用el表达式即可--%>
        <%--<c:forEach items="${student1}" var="st">--%>
            <tr>
                <td>${student1.id}</td>
                <td>${student1.createAt}</td>
                <td>${student1.updateAt}</td>
                <td>${student1.name}</td>
                <td>${student1.qq}</td>
                <td>${student1.studyType}</td>
                <td>${student1.studyId}</td>
                <td>${student1.joinTime}</td>
                <td>${student1.university}</td>
                <td>${student1.dailyLink}</td>
                <td>${student1.slogen}</td>
                <td>${student1.master}</td>
            </tr>
        <%--</c:forEach>--%>

    </table>
    <br>
    <br>
    <%--点击修改slogen--%>
    <form action="../student/${student1.studyId}" method="post" >
        <table align='center'>
            <tr>
                <td>studyId:</td>
                <td>${student1.studyId}</td>
            </tr>
            <tr>
                <td>dailyLink:</td>
                <td><input type="text" name="dailyLink" value="${student1.dailyLink}"><br/></td>
            </tr>
            <tr>
                <td>slogen:</td>
                <td><input type="text" name="slogen" value="${student1.slogen}"><br/></td>
            </tr>
            <tr>
                <td>master:</td>
                <td><input type="text" name="master" value="${student1.master}"><br/></td>
            </tr>
            <%--<tr>--%>
                <%--<td>master:</td>--%>
                <%--<td><input type="text" name="master" value=""><br/></td>--%>
            <%--</tr>--%>

            <tr>
                <td><input type="submit" value="点击修改"></td>
            </tr>
        </table>
    </form>
</div>
    <br><br>

    </body>
</html>




