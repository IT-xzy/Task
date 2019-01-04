<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>
<a href="/home">返回首页</a>
<br><br>
<div align="center">
    <form action="/upload" method="post" enctype="multipart/form-data">
        <label>用户名：</label><input type="readonly" name="name" value="张小愿" readonly><br>
        <label>上传头像：</label><input type="file" name="file"><br>
        <input type="submit">
    </form>

</div>
</body>
</html>