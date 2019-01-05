<%--
  Created by IntelliJ IDEA.
  User: xianxiaobo
  Date: 2018/11/16
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="padding: 100px 100px 10px;">
    <div class="panel  panel-primary">
        <div class="panel-heading">
            用户登录
        </div>
        <div class="panel-body">
            <div class="table-responsive">
                <form action="login" method="post">
                    <div class="form-group">
                        <label for="username">用户名</label>
                        <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名">
                    </div>
                    <div class="form-group">
                        <label for="password">密码</label>
                        <input type="text" class="form-control" id="password" name="password" placeholder="请输入密码">
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">登录</button>
                    </div>
                    <div class="form-group">
                        <a href="register" class="btn btn-link" style="color:#337ab7;">没有账号？去注册</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
