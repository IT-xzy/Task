<%--
  Created by IntelliJ IDEA.
  User: leon
  Date: 5/11
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="js/jQuery.js"></script>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/demo" enctype="multipart/form-data" method="POST">
    <label>
        <img id="img" width="200px" height="200px">
        <input type="file" name="file" id="file"/>
        <%--<button>上传</button>--%>
        <input type="submit" name="" id="input" >

    </label>

</form>



</body>
</html>
