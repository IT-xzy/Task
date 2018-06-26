<%--
  Created by IntelliJ IDEA.
  User: 指缝de阳光
  Date: 2018/5/21
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div style="width:500px;margin:0px auto;text-align:center">


    <div style="text-align:center;margin-top:40px">

        <form method="post" action="/student/${s.sId}">
            <input type="hidden" name="_method" value="POST">
            学员资料： <br><br>
            姓&nbsp;&nbsp;名：<input name="sName" value="${s.sName}" type="text"> <br><br>
            Q&nbsp;&nbsp;Q：<input name="QQ" value="${s.QQ}" type="text"> <br><br>
            修真类型：<input name="sType" value="${s.sType}" type="text"> <br><br>
            入学时间：<input name="sTime" value="${s.sTime}" type="text"> <br><br>
            毕业院校：<input name="sSchool" value="${s.sSchool}" type="text"> <br><br>
            线上学号：<input name="sNumber" value="${s.sNumber}" type="text"> <br><br>
            日报链接：<input name="sDaily" value="${s.sDaily}" type="text"> <br><br>
            立&nbsp;&nbsp;愿：<input name="sWish" value="${s.sWish}" type="text"> <br><br>
            辅导师兄：<input name="sCoach" value="${s.sCoach}" type="text"> <br><br>
            何处了解：<input name="sWhence" value="${s.sWhence}" type="text"> <br><br>
            <input name="update_at" value="${s.update_at}" type="hidden"> <br><br>
            <input type="hidden" value="${s.sId}" name="sId">
            <input type="submit" value="更新学员信息">
        </form>

    </div>
</div>

