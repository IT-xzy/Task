<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<style>
    .cities {
        background-color: green;
        color: white;
        margin: 20px;
        padding: 20px;
    }
</style>
<head>
    <title>所有用户所有信息</title>
</head>
<body>
<div class="cities">
    <h3>
        <center><font color="#dc143c" size="10">所有用户所有信息</font></center>
    </h3>
</div>

<form action="/page" method="get">


    <div class="nav">
        <center><a href="/index">返回首页</a>
            <a href="/add">新增数据</a>
            <%-- 当前页码大于1 --%>
            <c:if test="${pageNo > 1}">
                <a href="/page?SHOW_ITEMS=${SHOW_ITEMS}&pageNo=1">首页</a>
                <a href="/page?SHOW_ITEMS=${SHOW_ITEMS}&pageNo=${pageNo - 1}">前一页</a>
            </c:if>
            <%-- 当前页码等于1 --%>
            <c:if test="${pageNo == 1}">
                首页
                前一页
            </c:if>
            <a style="color:red; text-decoration:none;"
               href="/page?SHOW_ITEMS=${SHOW_ITEMS}&pageNo=${pageNo}">【${pageNo}】</a>

            <%-- 当前页码小于总页码 --%>
            <c:if test="${pageNo lt totalPageNo}">
                <a href="/page?SHOW_ITEMS=${SHOW_ITEMS}&pageNo=${pageNo + 1}">下一页</a>
                <a href="/page?SHOW_ITEMS=${SHOW_ITEMS}&pageNo=${totalPageNo}">末页</a>
            </c:if>
            <%-- 当前页码等于总页码 --%>
            <c:if test="${pageNo == totalPageNo}">
                下一页
                末页
            </c:if></center>

    </div>
    <div class="choose">

        <center>每页 <input type="number" name="SHOW_ITEMS" style="width: 40px" value=${SHOW_ITEMS}>行 跳转到第 <input
                type="number" name="pageNo" style="width: 60px" value=${pageNo}>页
            <input type="submit" value="跳转"></center>
    </div>


</form>
<table width="80%" border="1" cellpadding="0" cellspacing="0" align="center">
    <tr>
        <td>
            <center>ID</center>
        </td>
        <td>
            <center>姓名</center>
        </td>
        <td>
            <center>QQ</center>
        </td>
        <td>
            <center>修真类型</center>
        </td>
        <td>
            <center>入学时间</center>
        </td>
        <td>
            <center>毕业学校</center>
        </td>
        <td>
            <center>线上学号</center>
        </td>
        <td>
            <center>日报链接</center>
        </td>
        <td>
            <center>立愿</center>
        </td>
        <td>
            <center>审核师兄</center>
        </td>
        <td>
            <center>了解途径</center>
        </td>
        <td>
            <center>操作</center>
        </td>
    </tr>
    <c:forEach var="list" items="${addLists}">
        <tr>
            <td>
                <center>${list.id}</center>
            </td>
            <td>
                <center>${list.name}</center>
            </td>
            <td>
                <center>${list.qq}</center>
            </td>
            <td>
                <center>${list.studyType}</center>
            </td>
            <td>
                <center>${list.enrollment}</center>
            </td>
            <td>
                <center>${list.graduateSchool}</center>
            </td>
            <td>
                <center>${list.studentNum}</center>
            </td>
            <td>
                <center>${list.dailyLink}</center>
            </td>
            <td>
                <center>${list.wish}</center>
            </td>
            <td>
                <center>${list.checkBro}</center>
            </td>
            <td>
                <center>${list.knowWay}</center>
            </td>
            <td>
                <center>
                    <form action="/student/del/id=${list.id}" method="post">
                        <input type="hidden" name="_method" value="DELETE"/>
                        <input type="submit" value="删除"></form>

                    <form action="/student/id=${list.id}" method="get">
                        <%--<input type="hidden" name="_method" value="PUT"/>--%>
                        <input type="submit" value="修改"></form>
                </center>
            </td>
        </tr>
    </c:forEach>
</table>

<center>一共有 ${countAll} 条记录&nbsp;&copy;&nbsp;
    一共有 ${totalPageNo} 页&nbsp;
</center>
</body>
</html>