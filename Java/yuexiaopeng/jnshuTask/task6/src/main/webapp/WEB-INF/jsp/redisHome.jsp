<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div style="text-align:center">
    <h1>redis的******所有学生数据如下</h1>
</div>
<br>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
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
        <c:forEach items="${student}" var="stu" >
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
                <td><a href="${pageContext.request.contextPath}/redis/${stu.studyId}">编辑</a></td>
                <td><a class="delete" href="${pageContext.request.contextPath}/redis/${stu.studyId}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<div style="text-align:center">

    <a href="${pageContext.request.contextPath}/redis/all/?pageNum=${pageHome}">首页</a>
    <a href="${pageContext.request.contextPath}/redis/all/?pageNum=${pageLast}">上一页</a>
    <a href="${pageContext.request.contextPath}/redis/all/?pageNum=${pageNext}">下一页</a>
    <a href="${pageContext.request.contextPath}/redis/all/?pageNum=${pageFinal}">末  页</a>

</div>
<div style="text-align:center">
    <a  href="${pageContext.request.contextPath}/redis/insert">增加</a>
</div>
<br>
<div style="text-align:center">
    <a  href="${pageContext.request.contextPath}/">返回首页</a>
</div>
<br><br>
<div style="text-align:center">
    <a  href="${pageContext.request.contextPath}/redis/cre">从数据库拉取数据</a>
</div>
<br><br>
<div style="text-align:center">
    <a  href="${pageContext.request.contextPath}/redis/mysql">向数据库存入数据</a>
</div>

