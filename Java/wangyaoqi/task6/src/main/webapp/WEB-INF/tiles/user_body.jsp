<%--
  Created by IntelliJ IDEA.
  User: John
  Date: 2018/7/12
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" import="javax."%>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="javax.servlet.http.Cookie"%>
<%
//    session.setAttribute("userName","password");
%>
<style>
    #login {
        width: 350px;
        margin: 30px auto;
        padding: 20px;
        border: 1px solid #66635e;
    }
    #login div   {
        margin: 10px auto;
    }
    #login label {
        width: 100px;
        height: 30px;
        text-align: right;
    }
    #login input {
        border: 1px solid #000000;
    }
    #login button {
        width: 200px;
        height: 30px;
        border: 1px solid #000000;
    }
</style>
<div id="login">
    <form method="post" action="/user">
        <div class="user">
            <label>用户名：</label>
            <input type="text" name="userName" value="">
        </div>
        <div class="pwd">
            <label>密码：</label>
            <input type="text" name="password" value="">
        </div>
         <button type="submit">登录</button>
    </form>
</div>
