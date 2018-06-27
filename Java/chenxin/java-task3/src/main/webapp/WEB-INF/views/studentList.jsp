<%@page pageEncoding="UTF-8" contentType="text/html; charset=utf-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" >
<html>
<head>
    <META http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>主页</title>
</head>
<body>
<hr>
<form action="/test/student/${student.name}" method="get">
     姓名：<input type="text" name="name" value="">
    <input type="submit" name="确认"></br>
</form>
<a href="/test/newOne">添加学生</a>
<c:if test="${empty requestScope.pagemsg}">
    没有
</c:if>
<c:if test="${!empty requestScope.pagemsg}">
    <table border="1" cellpadding="0" cellspacing="0" class="table">
        <thead>
        <tr>
            <td>id</td>
            <td>姓名</td>
            <td>qq</td>
            <td>修真类型</td>
            <td>预计入学时间</td>
            <td>毕业院校</td>
            <td>线上学号</td>
            <td>日报连接</td>
            <td>立愿</td>
            <td>辅导师兄</td>
            <td>从何处了解到的修真院</td>
            <td>创建时间</td>
            <td>更新时间</td>
            <td>编辑</td>
            <td>删除</td>
        </tr>
        </thead>
        <c:forEach items="${requestScope.pagemsg.lists}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.qq}</td>
            <td>${student.goal}</td>
            <td>${student.registration_date}</td>
            <td>${student.graduated_from}</td>
            <td>${student.number}</td>
            <td>${student.daily_link}</td>
            <td>${student.pledge}</td>
            <td>${student.senior}</td>
            <td>${student.know_from}</td>
            <td>${student.created_at}</td>
            <td>${student.updated_at}</td>
            <td><form action="/test/student/${student.id}" method="get">
                <input type="submit" value="编辑">
            </form>
            </td>
            <td><form action="/test/student/${student.id}" method="post">
                <input type="hidden" value="delete" name="_method">
                <input type="submit" value="删除">
            </form>
            </td>
        </tr>
        </c:forEach>
    </table>
</c:if>
<table border="0" cellspacing="0" cellpadding="0" width="900px">
    <tr>
        <td class="td2">
            <span>第${requestScope.pagemsg.currPage}/${requestScope.pagemsg.totalPage}页</span>&nbsp;&nbsp;
            <span>总记录数：${requestScope.pagemsg.totalCount}&nbsp;&nbsp;每页显示：${requestScope.pagemsg.pageSize}</span>&nbsp;&nbsp;
        <c:if test="${requestScope.pagemsg.currPage !=1}">
            <a href="${pageContext.request.contextPath}/test/students?currentPage=1">首页</a>&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/test/students?currentPage=${requestScope.pagemsg.currPage-1}">上一页</a>&nbsp;&nbsp;
        </c:if>

        <c:if test="${requestScope.pagemsg.currPage !=requestScope.pagemsg.totalPage}">
            <a href="${pageContext.request.contextPath}/test/students?currentPage=${requestScope.pagemsg.currPage+1}">下一页</a>&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/test/students?currentPage=${requestScope.pagemsg.totalPage}">尾页</a>&nbsp;&nbsp;
        </c:if>
        </td>
    </tr>
</table>
</body>
</html>