<%--
  Created by IntelliJ IDEA.
  User: xianxiaobo
  Date: 2018/10/25
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.0.1/css/bootstrap.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/1.8.2/jquery.js"></script>
</head>
<body>
<div style="padding: 100px 100px 10px;">
    <div class="panel  panel-primary">
        <div class="panel-heading">
            用户新增
        </div>
        <div class="panel-body">
            <div class="table-responsive">
                <form action="addUser" method="post">
                    <div class="form-group">
                        <label for="name">用户名</label>
                        <input type="text" class="form-control" id="name" name="name" placeholder="用户名">
                    </div>
                    <div class="form-group">
                        <label for="sex">性别</label>
                        <input type="text" class="form-control" id="sex" name="sex" placeholder="性别">
                    </div>
                    <div class="form-group">
                        <label for="phone">手机号</label>
                        <input type="text" class="form-control" id="phone" name="phone" placeholder="手机号">
                    </div>
                    <button type="submit" class="btn btn-primary">保存</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
