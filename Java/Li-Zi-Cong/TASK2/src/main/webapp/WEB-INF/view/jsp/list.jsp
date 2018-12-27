<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2018/7/24
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set><!--创建一个字符串变量并保存字符串-->--%>
<%--<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<%--<%@ taglib prefix="taglib" uri="http://www.atg.com/taglibs/json" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <script>
        window.onload=function () {
            var a = ${flag};
            if (a == 1){
                alert('没有更上一页')
            }else if (a==2) {
                alert('已是最后一页')
            }
        }
    </script>

</head>
<body>
compiling..
<table align="center"	border="1" cellspacing="1" width="1500px" height="200px" style="font-size:20px">
    <tr style="background: green"><!-- th是表头 ,设置该标签的风格:背景颜色-->
        <th style="width: 130px ; height:100px ; font-size:30px ">姓名</th>
        <th style="width: 80px ; height:100px ; font-size:30px">QQ</th>
        <th style="width: 80px ; height:100px ; font-size:30px">修真类型</th>
        <th style="width: 80px ; height:100px ; font-size:25px">预计入学时间</th>
        <th style="width: 150px ; height:100px ; font-size:25px">毕业院校</th>
        <th style="width: 80px ; height:100px ; font-size:25px">学号</th>
        <th style="width: 80px ; height:100px ; font-size:25px">链接</th>
        <th style="width: 80px ; height:100px ; font-size:25px">立愿</th>
        <th style="width: 80px ; height:100px ; font-size:25px">师兄</th>
        <th style="width: 80px ; height:100px ; font-size:25px">从哪里了解到修真院</th>
        <th style="width: 80px ; height:100px ; font-size:25px">备注</th>
        <th style="width: 100px ; height:100px ; font-size:25px">操作</th>
        <th style="background: silver ;height:100px ;  font-size:25px">
            <form method="post" action="/student">
                <input type="submit" value="新增">
            </form>
        </th>
    </tr>
    <c:forEach items="${lists}" var="list" varStatus="vs"><!--c 调用自定义功能的标签,varStatus斑马线-->
    <tr	style="text-align: center ;"><%--background: ${vs.count%2==0?'gray':''} --%>
        <!-- 设置该标签的风格(排列:居中);背景颜色:三目运算,真赋值灰色,假什么也不给(vs.count默认从1开始，vs.index默认从0开始) -->
        <td>${list.studentName}</td>
        <td>${list.qq}</td>
        <td>${list.learnType}</td>
        <td>${list.joinTime}</td>
        <td>${list.school}</td>
        <td>${list.studentID}</td>
        <td>${list.link}</td>
        <td>${list.motto}</td>
        <td>${list.brother}</td>
        <td>${list.knowFrom}</td>
        <td style="background: gray;">${list.id}</td>
        <td>
            <form method="get" action="/student">
                <input type="hidden" name="id" value="${list.id}">
                <input type="submit" value="修改">
            </form>
            <form method="post" action="/student">
                <input type="hidden" name="_method" value="DELETE">
                <input type="hidden" name="id" value="${list.id}">
                <input type="submit" value="删除">
            </form>
        </td>
    </tr>
    </c:forEach>
</table>

<div style="display: flex;justify-content: center">
    <form method="post" action="/lastPage" style="margin: 10px">
        <input type="hidden" name="pageCount" value="${pageIndex}">
        <input type="submit" value="上一页">
    </form>

    <%--<table align="center">--%>
        <%--<th></th>--%>
        <%--<th></th>--%>
        <%--<th></th>--%>
        <%--<tr>--%>
            <%--<td><input type="button" value="${}"/></td>--%>
            <%--<td><input type="button" value="${}"></td>--%>
            <%--<td><input type="button" value="${}"></td>--%>
        <%--</tr>--%>
    <%--</table>--%>
    <%--<c:forEach items="${pageCount.get(0)}" var="index" varStatus="vs">--%>
    <%--<input type="button" value="${index}">--%>
    <%--<input type="button" value="2">--%>
    <%--<input type="button" value="3">--%>
    <form method="post" action="/nextPage" style="margin: 10px">
        <input type="hidden" name="pageCount" value="${pageIndex}">
        <input type="submit" value="下一页">
    </form>
</div>

</body>
</html>
