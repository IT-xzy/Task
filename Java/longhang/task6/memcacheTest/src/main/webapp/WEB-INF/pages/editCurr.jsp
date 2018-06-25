<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>编辑课程</title>
</head>
<body>
<h1>课程信息</h1>

<form action="${pageContext.request.contextPath}/jnshu" method="post">
    <input type="hidden" name="_method" value="PUT"/><br>
    id：<input type="text" name="id" value="${curriculum.id}"/><br>
    图片：<input type="text" name="picture" value="${curriculum.picture}"/><br>
    课程名：<input type="text" name="name" value="${curriculum.name}" /><br>
    介绍：<input type="text" name="introduce" value="${curriculum.introduce}"/><br>
    门槛：<input type="text" name="threshold" value="${curriculum.threshold}" /><br>
    难度：<input type="text" name="difficulty" value="${curriculum.difficulty}" /><br>
    周期：<input type="text" name="cycle" value="${curriculum.cycle}"/><br>
    需求：<input type="text" name="demand" value="${curriculum.demand}"/><br>
    工资1：<input type="text" name="wages1" value="${curriculum.wages1}"/><br>
    工资2：<input type="text" name="wages2" value="${curriculum.wages2}"/><br>
    工资3：<input type="text" name="wages3" value="${curriculum.wages3}"/><br>
    提示：<input type="text" name="prompt" value="${curriculum.prompt}"/><br>
    在学人数：<input type="text" name="onnum" value="${curriculum.onnum}"/><br>
    <input  type="submit"  value="更改">
</form>
</body>

</html>