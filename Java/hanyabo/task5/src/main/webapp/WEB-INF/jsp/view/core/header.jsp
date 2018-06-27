<%@ page import="com.task.util.JwtUtil" %>
<%@ page import="com.task.entity.UserToken" %><%--
  Created by IntelliJ IDEA.
  User: zhimowen
  Date: 2018-05-14
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
    #headerDis {
        border:1px solid #e7e7e7;
        color:black;
        /*text-align:center;*/
        padding:5px;

        background-color:#f8f8f8;
    }

    #tips {
        font-weight:bold;
        font-size:40px;
        color:#ff9955;
    }

    #login {
        font-weight:bold;
        font-size:30px;
        color:#0000ff;
        float: right;
    }

    #loginOut {
        font-weight:bold;
        font-size:30px;
        color:#0000ff;
        float: right;
    }



</style>


<div id="headerDis">
    <span id="tips">技能树</span>

<c:choose>

    <c:when test="${sessionScope.user != null }">
    <%--<c:when test= <%name!=null%> >--%>
        <%--如果--%>
        <%--<p>${sessionScope.user.username}登录了</p>--%>
        <%--<p>${sessionScope.user.password}</p>--%>
        <a id="loginOut" href="/user/outLogin">${sessionScope.user.username},注销</a>
    </c:when>

    <c:otherwise>
        <%--否则--%>
        <a id="login" href="/user/login">登录</a>
    </c:otherwise>

</c:choose>


</div>
