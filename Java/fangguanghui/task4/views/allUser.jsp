<%--
  Created by IntelliJ IDEA.
  User: FGH
  Date: 2018/6/3
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib prefix="date" uri="/tags" %>

<!DOCTYPE html>
<html>
<head>

    <title>用户列表</title>
</head>

<body>

<h4>用户查询</h4>

<form action="${pageContext.request.contextPath}/users/name" method="get" >
    <table width="100%" border="1"  >
        <tbody>
        <tr>
            <td>ID</td>
            <td>姓名</td>
            <td>修真类型</td>
            <td>入学时间</td>
            <td>毕业院校</td>
            <td>网上学号</td>
            <td>辅导师兄</td>
        </tr>
        <tr>
            <td><input  name="id" ></td>
            <td><input  name="username" ></td>
            <td><input  name="type"  ></td>
            <td><input  name="joinTime" ></td>
            <td><input  name="school"   ></td>
            <td><input  name="onlineId"  ></td>
            <td><input  name="counsellor" ></td>
        </tr>
    </table>
    <input type="submit" value="查询">
</form>
<br>

<table border="1" width="100%" >
    <tbody>
    <tr>
        <td>ID</td>
        <td>姓名</td>
        <td>QQ</td>
        <td>修真类型</td>
        <td>入学时间</td>
        <td>毕业院校</td>
        <td>网上学号</td>
        <td>日报</td>
        <td>宣言</td>
        <td>辅导师兄</td>
        <td>了解途径</td>
        <td>创建时间</td>
        <td>更新时间</td>
        <td>创建者</td>
        <td>更新者</td>
    </tr>

        <c:forEach items="${findUser}" var="findUser">
    <tr>
            <td>${findUser.id}</td>
            <td>${findUser.username}</td>
            <td>${findUser.QQ}</td>
            <td>${findUser.type}</td>
            <td><date:date value ="${findUser.joinTime}" /></td>
            <td>${findUser.school}</td>
            <td>${findUser.onlineId}</td>
            <td>${findUser.daily}</td>
            <td>${findUser.description}</td>
            <td>${findUser.counsellor}</td>
            <td>${findUser.way}</td>
            <td><date:date value ="${findUser.create_at} "/></td>
            <td><date:date value ="${findUser.update_at} "/></td>
            <td>${findUser.create_by}</td>
            <td>${findUser.update_by}</td>
        </c:forEach>
    </tr>
    </tbody>
</table>


<h2 align="center">用户列表</h2>
<table border="1" width="100%" >
    <tbody>
    <tr>
        <td>ID</td>
        <td>姓名</td>
        <td>QQ</td>
        <td>修真类型</td>
        <td>入学时间</td>
        <td>毕业院校</td>
        <td>网上学号</td>
        <td>日报</td>
        <td>宣言</td>
        <td>辅导师兄</td>
        <td>了解途径</td>
        <td>创建时间</td>
        <td>更新时间</td>
        <td>创建者</td>
        <td>更新者</td>
        <td>操作</td>
    </tr>
    <c:if test="${!empty userList }">
        <c:forEach items="${userList}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.QQ}</td>
            <td>${user.type}</td>
            <td><date:date value ="${user.joinTime}"/></td>
            <%--<td>${user.joinTime}</td>--%>
            <td>${user.school}</td>
            <td>${user.onlineId}</td>
            <td>${user.daily}</td>
            <td>${user.description}</td>
            <td>${user.counsellor}</td>
            <td>${user.way}</td>
            <td><date:date value ="${user.create_at}"/></td>
            <td><date:date value ="${user.update_at}"/></td>
            <td>${user.create_by}</td>
            <td>${user.update_by}</td>
            <td>
                <a href="${pageContext.request.contextPath}/users/user/${user.id}">编辑</a>
                <a href="" onclick="del(${user.id})">删除</a>
            </td>
        </tr>
    </c:forEach>
    </c:if>
    </tbody>
</table>
<h4 align="right"><a href="${pageContext.request.contextPath}/users/user/new">添加用户</a></h4>
</body>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
    function del(id) {
        if(confirm("确定删除？"))
            var url = '${pageContext.request.contextPath}/users/user/' + id;
        $.ajax({
            url: url, /*url也可以是json之类的文件等等*/
            type: 'DELETE', /*DELETE、POST */
            async: false,
            success:
                    function (result) {
                    //判断result结果
                    if (result) {
                        alert("id: " + id + "删除成功,即将返回列表页")
                        // 使浏览器刷新当前页面
                        window.location.reload();
                    } else {
                        alert("id: " + id + " 删除失败")
                }
            }
            // error: function(XMLHttpRequest, textStatus, errorThrown) {
            //     alert(XMLHttpRequest.status);
            //     alert(XMLHttpRequest.readyState);
            //     alert(textStatus);
            // }
        });

    }
</script>
</html>





