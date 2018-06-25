<%@ taglib uri="/tags" prefix="date"%>
<date:date value ="${student.create_at}"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>编辑用户</title>
</head>
<body>
<h1>用户信息</h1>

    <form action="${pageContext.request.contextPath}/student" method="post" enctype="multipart/form-data">
        <input type="hidden" name="_method" value="PUT"/><br>
        <img src="${student.picture}" width=100px height=60px /><br>
        <input type="file" id="picture"  name="upPicture"><br>
        id：<input type="text" id="id"  name="id" value="${student.id}"/><br>
        姓名：<input type="text" name="name" value="${student.name}" /><br>
        QQ：<input type="text" name="qq" value="${student.qq}"/><br>
        愿言：<input type="text" name="wish" value="${student.wish}" /><br>
        修真类型：<input type="text" name="major" value="${student.major}" /><br>
        是否工作：<input type="text" name="goodwork" value="${student.goodwork}"/><br>
        是否结业：<input type="text" name="graduation" value="${student.graduation}"/><br>
        优秀学员：<input type="text" name="goodstu" value="${student.goodstu}"/><br>
        <input  type="submit"  value="更改">
</form>

</body>

</html>