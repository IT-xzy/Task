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

    .signIn {
        font-weight:bold;
        font-size:30px;
        color:#0000ff;
        float: right;
    }

    .signOut {
        font-weight:bold;
        font-size:30px;
        color:#0000ff;
        float: right;
    }

    #myImg {
        position: fixed;
        top: 15px;
        /*right: 220px;*/
        right: 20%;
    }
</style>

<%--<script type="text/javascript" src="https://code.jquery.com/jquery-3.0.0.min.js"></script>--%>
<script type="text/javascript" src="/js/jquery-3.0.0.min.js"></script>

<script type="text/javascript">
    $(function(){
        $(".signOut").click(function(){
            var href = $(this).attr("href");
            $("#deleteForm").attr("action",href).submit();
            return false;
        })
    });
</script>

<form action="" method="post" id="deleteForm" >
    <input type="hidden" name="_method" value="DELETE">
</form>


<div id="headerDis">
    <span id="tips">技能树·京东云</span>

    <c:choose>
        <c:when test="${sessionScope.user != null }">
            <%--头像显示 50*50--%>
            <%--<img id="myImg" height="50" width="50" src="http://www.zhimowen.top/tmall/img/productDetail/10150.jpg">--%>

            <a href="/img/data">
            <img id="myImg" height="50" width="50" src="http://www.zhimowen.top/head/${sessionScope.user.username}.jpg" onerror="this.src='http://www.zhimowen.top/head/default.jpg'"/>
            </a>

            <a class="signOut" href="/user/session">${sessionScope.user.username},注销</a>
        </c:when>
        <c:otherwise>

            <a class="signIn" href="/user/phone">/注册</a>
            <a class="signIn" href="/user/session">登录/</a>
        </c:otherwise>
    </c:choose>

</div>
