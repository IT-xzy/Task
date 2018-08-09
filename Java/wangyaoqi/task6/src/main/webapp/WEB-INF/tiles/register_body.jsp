<%--
  Created by IntelliJ IDEA.
  User: John
  Date: 2018/7/12
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <form method="post" action="/register">
        <input type="hidden" name="_method" value="PUT">
        <div class="user">
            <label>用户名：</label>
            <input  type="text" name="userName" value="">
        </div>
        <div class="pwd">
            <label>密码：</label>
            <input type="text" name="password" value="">
        </div>
        <button type="submit" >注册</button>
    </form>
</div>