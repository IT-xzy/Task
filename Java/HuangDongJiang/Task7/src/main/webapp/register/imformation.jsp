<%--
  Created by IntelliJ IDEA.
  User: CH0918
  Date: 2018/8/2
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>个人信息</title>
</head>
<body>
<form action="/imformation" method="post" enctype="multipart/form-data">
    <table border="1px" align="center"width="60%" height="70%"
           background="https://ch0918.oss-cn-shenzhen.aliyuncs.com/%E4%B8%80%E6%9C%9B%E6%97%A0%E9%99%85.jpg">
        <caption><h1>个人信息</h1></caption>
            <th>
             姓名:<input type="text" name = "name" id="name" value="${cookie.get('username').value}" /><br>
             上传照片:<input type="file" id="picture" name="picture" placeholder="请上传照片"/><br>
                <input type="submit" value="提交">
            </th>
        </tr><!--第1行结束-->
    </table>
</form>
<form action="/mail" method="post">
    邮箱验证：<input type="text" name="mail" id="mail" placeholder="请输入邮箱"><br>
    <input type="submit" value="发送邮件验证">
</form>
</body>
</html>

