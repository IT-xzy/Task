<%--
  Created by IntelliJ IDEA.
  User: zyq
  Date: 2018/8/5
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page  isELIgnored = "false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script type="text/javascript" src="/jquery.min.js"></script>
<html>
<head>
    <title>通过姓名和学号模糊查询</title>
</head>
<body>
<c:if test="${empty page.list}">
    数据库中没有相关学员信息，请添加。
</c:if>
<div align="center">
<c:if test="${!empty page.list}">
    <table align='center' border='1' cellspacing='0'>
        <tr>
            <th align="left" colspan="11">查询到的数据如下（模糊查询）:</th>
            <th colspan="2" rowspan="2">操作</th>
        </tr>
        <tr>
            <th>ID</th>
            <th>姓名</th>
            <th>qq</th>
            <th>专业</th>
            <th>毕业院校</th>
            <th>学号</th>
            <th>日报连接</th>
            <th>师兄姓名</th>
            <th>从哪里得知修真院</th>
            <th>创建时间</th>
            <th>更新时间</th>
        </tr>
        <hr>
        <c:forEach items="${page.list}" var="student">
            <tr>
                <td>${student.id }</td>
                <td>${student.name }</td>
                <td>${student.qq }</td>
                <td>${student.profession }</td>
                <td>${student.university}</td>
                <td>${student.number}</td>
                <td>${student.daily}</td>
                <td>${student.senior}</td>
                <td>${student.from}</td>
                <td>
                    <jsp:useBean id="timestamp5" class="java.util.Date"/>
                    <jsp:setProperty name="timestamp5" property="time" value="${student.createTime}"/>
                    <fmt:formatDate value="${timestamp5}" pattern="yyyy年MM月dd日 HH:mm:ss"/>
                </td>
                <td>
                    <jsp:useBean id="timestamp6" class="java.util.Date"/>
                    <jsp:setProperty name="timestamp6" property="time" value="${student.updateTime}"/>
                    <fmt:formatDate value="${timestamp6}" pattern="yyyy年MM月dd日 HH:mm:ss"/>
                </td>
                <td><a href="#" id="${student.id}">编辑</a></td>
                <form action="/Student/${student.id}" method="get" class="${student.id}">
                    <input type="hidden" name="currPage" value="${page.currPage}">
                    <input type="hidden" name="name" value="${name}">
                    <input type="hidden" name="number" value="${number}">
                    <script>document.getElementById("${student.id}").onclick=function (){
                        document.getElementsByClassName("${student.id}")[0].submit();}
                    </script>
                </form>
                <td>
                    <a href="/Student/${student.id}" class="delete">
                        删除
                    </a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <th colspan="13">
                第${page.currPage}页 共${page.totalPage}页
                <c:if test="${page.currPage!=1}">
                    <a href="/Students/${name}/${number}?name=${name}&number=${number}&currPage=1">首页</a>
                    <a href="/Students/${name}/${number}?name=${name}&number=${number}&currPage=${page.currPage-1}">上一页</a>
                </c:if>
                <c:if test="${page.currPage!=page.totalPage}">
                    <a href="/Students/${name}/${number}?name=${name}&number=${number}&currPage=${page.currPage+1}">下一页</a>
                    <a href="/Students/${name}/${number}?name=${name}&number=${number}&currPage=${page.totalPage}">末页</a>
                </c:if>
            </th>
        </tr>
    </table>
</c:if>
<form id="delete" action="" method="post">
    <input type="hidden" name="_method" value="DELETE">
    <input type="hidden" name="currPage" value="${page.currPage}">
    <input type="hidden" name="name" value="${name}">
    <input type="hidden" name="number" value="${number}">
</form>
<h2><a href="/studentS?currPage=1">返回</a></h2>
</body>
<script>
    $(function () {
        $(".delete").click(function (){
            $("#delete").attr("action",$(this).attr("href")).submit();
            return false;
        })
    })
</script>
</html>
