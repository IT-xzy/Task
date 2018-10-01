<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" import="java.util.*" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div style="width: 500px;margin:0px auto;text-align:center">
    <div style="text-align:center;margin-top:40px">
        <form method="post" action="../student/${student.id}">
            <input type="hidden" name="_method" value="PUT">
            姓名：<input type="text" name="name" value="${student.name}"> <br>
            QQ:<input type="text" name="qq" value="${student.qq}"> <br>
            职业：<input type="text" name="profession" value="${student.profession}"> <br>
            毕业学校：<input type="text" name="school" value="${student.school}"> <br>
            <input type="hidden" name="id" value="${student.id}"> <br>
            <input type="submit" value="提交信息">
        </form>
    </div>
</div>