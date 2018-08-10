<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" import="java.util.*" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript" src="js/jquery.min.js"></script>

<%--将delete的method由get变为post再变为DELETE，分2步--%>
<%--1--%>
<script type="text/javascript">
    $(function(){
        // 为所有的class为delete的按钮点击动作添加行为函数
        $(".delete").click(function(){
            // 获取class为delete的超链接地址
            var href=$(this).attr("href");
            // 为隐藏域的action赋值并提交
            $("#formdelete").attr("action",href).submit();
            return false;
        })
    })
</script>

<div style="width:500px;margin:0px auto;text-align:center">
    <table align="center" border="1" cellspacing="0">
        <tr>
            <td>id</td>
            <td>姓名</td>
            <td>qq</td>
            <td>职业</td>
            <td>毕业学校</td>
            <td>创建时间</td>
            <td>更新时间</td>
            <td>编辑</td>
            <td>删除</td>
        </tr>

        <c:forEach items="${students}" var="student" varStatus="st">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.qq}</td>
                <td>${student.profession}</td>
                <td>${student.school}</td>
                <td>${student.create_time}</td>
                <td>${student.update_time}</td>
                <td><a href="student/${student.id}">编辑</a></td>
                <td><a class="delete" href="student/${student.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>

    <div style="text-align:center">
        <a href="?start=0">首页</a>
        <a href="?start=${page.start-page.count}">上一页</a>
        <a href="?start=${page.start+page.count}">下一页</a>
        <a href="?start=${page.last}">末页</a>
    </div>

    <div style="text-align:center;margin-top:40px">
        <form action="/student" method="post">
            姓名：<input type="text" name="name" value=""/><br>
            QQ:<input type="text" name="qq" value=""/><br>
            职业：<input type="text" name="profession" value=""/><br>
            毕业院校：<input type="text" name="school" value=""/><br>
            <input type="submit" value="添加"/>
        </form>
    </div>

</div>

<%--2--%>
<form id="formdelete" action="" method="POST">
    <%--通过隐藏域将POST转换为DELETE--%>
    <input type="hidden" name="_method" value="DELETE">
</form>