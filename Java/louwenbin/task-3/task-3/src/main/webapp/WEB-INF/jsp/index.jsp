<%--
  Created by IntelliJ IDEA.
  User: leon
  Date: 4/17
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>报名贴</title>
</head>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    基于SSM框架的管理系统：简单实现增、删、改、查。
                </h1>
            </div>
        </div>
    </div>
</div>
<br><br>
<br><br>

<body>
<fieldset>
    <legend> 基于SSM框架的管理系统：简单实现增、删、改、查。</legend>
    <form action="/users" method="get">
        <input type="submit" value="列表">
    </form>
    <br>
    <form action="/user" method="get">
        ID ：<input type="text" name="id">
        <input type="submit" value="查询">
    </form>


    <form action="/json" method="get">
        ID ：<input type="text" name="id">
        <input type="submit" value="json">
        </a>
    </form>

</fieldset>
</body>
</html>
