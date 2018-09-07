<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>

<div align="center">
    ${InfoMessage}

        <h2 class='title'> ${userName},恭喜您成功注册本网站，请选择是否上传头像。</h2>
    <form action="/photoUpload"  method="post" enctype="multipart/form-data" >
        <input  type="file" name="file" >  <button type="submit">上传</button>
    </form>
    <form action="/">
        <button type="submit" >不上传，跳过</button>
    </form>

</div>
</body>
</html>