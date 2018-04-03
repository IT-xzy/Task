<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@include file="footer.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div style="width:500px;margin:0px auto;text-align:center">
    <div style="text-align:center;margin-top:40px">
        <form method="POST" action="/task2/student/${student.id}">
            学生名称： <input name="name" value="${student.name}" type="text"> <br><br>
            学生qq: <input name="qq" value="${student.qq}" type="text"> <br><br>
            学习类型：<input name="job" value="${student.job}" type="text"> <br><br>
            毕业学校：<input name="school" value="${student.school}" type="text"> <br><br>
            日报链接：<input name="url" value="${student.url}" type="text"> <br><br>
            <input type="submit" onclick = 'return confirm("确认要更新吗？");' value="更新信息">
        </form>

    </div>
</div>
