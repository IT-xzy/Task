<%--
  Created by IntelliJ IDEA.
  User: 指缝de阳光
  Date: 2018/5/21
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>主页</title>
</head>
<body>
    <div style="width:1000px;margin:0px auto;text-align:center">
        <%--通过forEach标签，遍历StudentController传递过来的集合数据--%>
        <table align='center' border='1' cellspacing='0'>
            <tr>
                <td>ID</td>
                <td>姓名</td>
                <td>QQ</td>
                <td>修真类型</td>
                <td>入学时间</td>
                <td>毕业院校</td>
                <td>线上学号</td>
                <td>日报链接</td>
                <td>立愿</td>
                <td>辅导师兄</td>
                <td>从何处了解</td>
                <td>创建时间</td>
                <td>更新时间</td>
                <td>编辑</td>
                <td>删除</td>
            </tr>
            <c:forEach items="${student}" var="s" varStatus="st">
                <tr>
                    <td>${s.sId}</td>
                    <td>${s.sName}</td>
                    <td>${s.QQ}</td>
                    <td>${s.sType}</td>
                    <td>${s.sTime}</td>
                    <td>${s.sSchool}</td>
                    <td>${s.sNumber}</td>
                    <td>${s.sDaily}</td>
                    <td>${s.sWish}</td>
                    <td>${s.sCoach}</td>
                    <td>${s.sWhence}</td>
                    <td>${s.create_at}</td>
                    <td>${s.update_at}</td>
                    <td><a href="student/insert/${s.sId}">编辑</a></td>
                    <td>
                        <form action="student/${s.sId}" method="post">
                            <input type="hidden" name="_method" value="DELETE">
                            <input type="submit" value="删除" onclick = 'return confirm("确认要删除吗？");'>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <div style="text-align:center">
            <a href="?start=0">首 页</a>
            <c:if test="${page.start-page.count>=0}">
                <a href="?start=${page.start-page.count}">上一页</a>
            </c:if>
            <c:if test="${page.start-page.count<0}">
                <a href="javascript:void(0)">上一页</a>
            </c:if>

            <c:if test="${page.start+page.count<=page.last}">
                <a href="?start=${page.start+page.count}">下一页</a>
            </c:if>
            <c:if test="${page.start+page.count>page.last}">
                <a href="javascript:void(0)">下一页</a>
            </c:if>
            <a href="?start=${page.last}">末页</a>
        </div>

        <div style="text-align:center;margin-top:40px">
            <form method="post" action="student">
                <input type="hidden" name="_method" value="PUT">
                学员资料：<br><br>
                姓&nbsp;&nbsp;名：<input name="sName" value="" type="text"> <br><br>
                Q&nbsp;&nbsp;Q：<input name="QQ" value="" type="text"> <br><br>
                修真类型：<input name="sType" value="" type="text"> <br><br>
                入学时间：<input name="sTime" value="" type="text"> <br><br>
                毕业院校：<input name="sSchool" value="" type="text"> <br><br>
                线上学号：<input name="sNumber" value="" type="text"> <br><br>
                日报链接：<input name="sDaily" value="" type="text"> <br><br>
                立&nbsp;&nbsp;愿：<input name="sWish" value="" type="text"> <br><br>
                辅导师兄：<input name="sCoach" value="" type="text"> <br><br>
                何处了解：<input name="sWhence" value="" type="text"> <br><br>
                <input type="submit" value="增加学员">
            </form>
        </div>
    </div>

</body>
</html>
