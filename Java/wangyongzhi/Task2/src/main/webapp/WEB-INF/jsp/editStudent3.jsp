<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<div style="width:1400px;margin:0px auto;text-align:center">
    <div style="text-align:center;margin-top:40px">
        <form method="POST" action="/listStudent3/${student.lineId}">
            学生学号：<input name="lineId" value="${student.lineId}" type="text"> <br><br>
            学生名称： <input name="name" value="${student.name}" type="text"> <br><br>
            学生QQ: <input name="QQ" value="${student.QQ}" type="text"> <br><br>
            学习类型：<input name="type" value="${student.type}" type="text"> <br><br>
            毕业时间: <input name="enrolmentTime" value="${student.enrolmentTime}" type="text"> <br><br>
            毕业学校：<input name="graduate" value="${student.graduate}" type="text"> <br><br>
            日报链接：<input name="reportLink" value="${student.reportLink}" type="text"> <br><br>
            立誓: <input name="wish" value="${student.wish}" type="text"> <br><br>
            师兄: <input name="senior" value="${student.senior}" type="text"> <br><br>
            从何处得知: <input name="howKnow" value="${student.howKnow}" type="text"> <br><br>
            创建时间: <input name="createAt" value="${student.createAt}" type="text"> <br><br>
            更新时间: <input name="updateAt" value="${student.updateAt}" type="text"> <br><br>
            <input type="submit" onclick='return confirm("确认要更新吗？");' value="更新信息">
        </form>

    </div>
</div>

<%@include file="footer.jsp" %>
