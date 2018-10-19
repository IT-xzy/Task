<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Edit Student</title>
</head>
<div style="text-align:center">
    请输入需要增加的数据及缓存，点击增加按钮
</div>
<body>
<br>
<div>
    <form action="${pageContext.request.contextPath}/memcached/ins" method="post" >
        <%--将这个表单的post方法改为隐藏的put方法，变为rest风格--%>
        <input type="hidden" name="_method" value="put">
        <table align='center'>
            <tr>
                <td>id:</td>
                <td><input type="text" name="id" value="66"><br/></td>
            </tr>
            <tr>
                <td>name:</td>
                <td><input type="text" name="name" value="sunny"><br/></td>
            </tr>
            <tr>
                <td>createAt:</td>
                <td><input type="text" name="createAt" value="2018"><br/></td>
            </tr>
            <tr>
                <td>updateAt:</td>
                <td><input type="text" name="updateAt" value="201805"><br/></td>
            </tr>
            <tr>
                <td>qq:</td>
                <td><input type="text" name="qq" value="1234567"><br/></td>
            </tr>
            <tr>
                <td>studyType:</td>
                <td><input type="text" name="studyType" value="java"><br/></td>
            </tr>
            <tr>
                <td>joinTime:</td>
                <td><input type="text" name="joinTime" value="201805"><br/></td>
            </tr>
            <tr>
                <td>university:</td>
                <td><input type="text" name="university" value="什么什么"><br/></td>
            </tr>
            <tr>
                <td>studyId:</td>
                <td><input type="text" name="studyId" value="java-001"><br/></td>
            </tr>
            <tr>
                <td>dailyLink:</td>
                <td><input type="text" name="dailyLink" value="www.google.com"><br/></td>
            </tr>
            <tr>
                <td>slogen:</td>
                <td><input type="text" name="slogen" value="victory"><br/></td>
            </tr>
            <tr>
                <td>master:</td>
                <td><input type="text" name="master" value="wukong"><br/></td>
            </tr>
            <tr>
                <td><input style="background-color: #ff5050;"
                           type="button" value="增加" onclick="submit()"></td>
            </tr>
        </table>
    </form>
</div>
</table>
<br>
<br>

</body>