<%--<%@ taglib uri="/tags" prefix="date"%>--%>
<%--<date:date value ="${item.createdTime} "/>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>


<html>
<body>
<h1>添加用户</h1>
<form action="${pageContext.request.contextPath}/student" method="post" enctype="multipart/form-data">
    姓名：<input type="text" name="name"><br>
    qq：<input type="text" name="qq"><br>
    愿言：<input type="text" name="wish"><br>
    修真类型：<input type="text" name="major"><br>
    图片预览：<input type="file" name="upPicture"><br>
    满意工作：<input type="text"  name="goodwork"><br>
    是否结业：<input type="text" name="graduation"><br>
    优秀学员：<input type="text" name="goodstu"><br>
    邮箱：<input type="text" name="email"><br>
    电话：<input type="text" name="phone"><br>
    <p id="buttons">
        <input  type="submit" tabindex="5" value="添加">
    </p>
</form>
</body>
</html>