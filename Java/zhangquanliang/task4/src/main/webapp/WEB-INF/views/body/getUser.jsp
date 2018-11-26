<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib uri="/tags" prefix="date"%>

<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.js"></script>

<script type="text/javascript">
    /*将post method 改变为delete*/
    $(function () {
        $(".delete").click(function () {
            var href = $(this).attr("href");
            $("#formdelete").attr("action", href).submit();
            return false;
        })
    });
</script>
<div width="95%" align="center">
    <form action="/u/user/" >
        <a href="/u/user">返回用户信息列表</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="text" name="name" placeholder="请输入姓名" >&nbsp;&nbsp;
        <input type="submit" value="根据姓名查询"><br>
    </form>
</div>

<form id="formdelete" action="${pageContext.request.contextPath}/u/user/" method="POST">
    <input type="hidden" name="_method" value="DELETE">
</form>

<div>
    <table border="1" cellpadding="0" width="95%" align="center">
        <tr>
            <th>用户Id</th>
            <th>头像</th>
            <th>用户名</th>
            <th>用户密码</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>电话</th>
            <th>性别</th>
            <th>年龄</th>
            <th>学校</th>
            <th>立愿</th>
            <th>宣言</th>
            <th>注册时间</th>
            <th>更新时间</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${users}" var="s">
            <tr>
                <td>${s.id}</td>
                <td>${s.img}</td>
                <td>${s.name}</td>
                <td>${s.pwd}</td>
                <td>${s.qq}</td>
                <td>${s.email}</td>
                <td>${s.tell}</td>
                <td>${s.sex}</td>
                <td>${s.age}</td>
                <td>${s.school}</td>
                <td>${s.wish}</td>
                <td>${s.sign}</td>
                <td><date:date value ="${s.createAt} "/></td>
                <td><date:date value ="${s.updateAt} "/></td>
                <td>
                    <a href="/u/user/${s.id}">编辑</a>
                    <a class="delete" href="/u/user/${s.id}">删除</a>
                </td>
            </tr>

        </c:forEach>
    </table>
</div>


