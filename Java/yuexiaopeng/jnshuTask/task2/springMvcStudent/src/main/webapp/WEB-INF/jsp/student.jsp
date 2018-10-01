<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript" src="jquery/jquery.min.js"></script>
<script type="text/javascript">
    /*将post method 改变为delete*/
    $(function(){
        $(".delete").click(function(){
            var href=$(this).attr("href");
            $("#formdelete").attr("action",href).submit();
            return false;
        });
    });
</script>
<form id="formdelete" action="" method="POST" >
    <input type="hidden" name="_method" value="DELETE">
</form>

<div style="text-align:center">
    <h1>所有学生数据如下</h1>
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
            <td width="80">编辑</td>
            <td width="80">删除</td>
        </tr>
        <c:forEach items="${student}" var="stu" varStatus="student">
            <tr>
                <td>${stu.id}</td>
                <td>${stu.createAt}</td>
                <td>${stu.updateAt}</td>
                <td>${stu.name}</td>
                <td>${stu.qq}</td>
                <td>${stu.studyType}</td>
                <td>${stu.studyId}</td>
                <td>${stu.joinTime}</td>
                <td>${stu.university}</td>
                <td>${stu.dailyLink}</td>
                <td>${stu.slogen}</td>
                <td>${stu.master}</td>
                <td><a href="student/${stu.studyId}">编辑</a></td>
                <td><a class="delete" href="student/${stu.studyId}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <div style="text-align:center">
        <a href="?start=0">首  页</a>
        <a href="?start=${page.start-page.count}">上一页</a>
        <a href="?start=${page.start+page.count}">下一页</a>
        <a href="?start=${page.last}">末  页</a>
    </div>
    <br><br>
    <div style="text-align:center">
    <td><a  href="student/add">增加</a></td>
    </div>
<%--<div style="text-align:center">--%>
    <%--<json:object>--%>
        <%--<json:array name="category" var="c" items="${cs}">--%>
            <%--<json:object>--%>
                <%--<json:property name="id" value="${c.id}"/>--%>
                <%--<json:property name="name" value="${c.name}"/>--%>
            <%--</json:object>--%>
            <%--<br>--%>
        <%--</json:array>--%>
    <%--</json:object>--%>
<%--</div>--%>

