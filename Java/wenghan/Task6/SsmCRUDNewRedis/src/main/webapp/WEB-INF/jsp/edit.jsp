<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/9
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<div style="width:500px;margin:0 auto;text-align:center">


    <div style="text-align:center;margin-top:40px">

        <form method="post" action="${pageContext.request.contextPath}/User">
            姓名： <input name="name" value="${object.name}" type="text"> <br>
            QQ：<input name="qq" value="${object.qq}" type="text">
            <input type="hidden" value="${object.id}" name="id">
            <input type="hidden" name="_method" value="PUT">
            <input type="submit" value="更新">
        </form>
    </div>
</div>
