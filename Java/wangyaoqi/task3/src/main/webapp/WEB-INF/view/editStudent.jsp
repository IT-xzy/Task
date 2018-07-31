<%--
  Created by IntelliJ IDEA.
  User: John
  Date: 2018/6/22
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div style="text-align:center;margin-top:40px">
    <form method="post" action="../student/{id}">
        <label style="width: 20px;text-align: right">ID：</label><input type="text" name="id" value="${student.id}"><br/>
        <label style="width: 20px;text-align: right">姓名：</label><input type="text" name="name" value="${student.name}"><br/>
        <label style="width: 20px;text-align: right">类型：</label><input type="text" name="type" value="${student.type}"><br/>
        <label style="width: 20px;text-align: right">学校：</label><input type="text" name="school" value="${student.school}"><br/>
        <label style="width: 20px;text-align: right">誓言：</label><input type="text" name="pledge" value="${student.pledge}"><br/>
        <label style="width: 20px;text-align: right">创建时间：</label><input type="text" name="createTime" value="${student.createTime}"><br/>
        <label style="width: 20px;text-align: right">更新时间：</label><input type="text" name="updateTime" value="${student.updateTime}"><br/>
        <label style="width: 20px;text-align: right">师兄ID：</label><input type="text" name="siblingId" value="${student.siblingId}"><br/>
        <label style="width: 20px;text-align: right">师兄：</label><input type="text" name="siblingName" value="${student.siblingName}"><br/>
        <input type="submit" value="修改">
    </form>
</div>