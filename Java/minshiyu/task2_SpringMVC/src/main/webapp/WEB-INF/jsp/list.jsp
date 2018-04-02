<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>学员列表</title>
</head>
<body>
<table border="1" cellpadding="10" cellspacing="0" class="table1">
    <tr>
        <th>
            根据姓名查找
            <form action="${pageContext.request.contextPath}/student/name" method="get">
                <label>
                    <input type="text" name="name" value="">
                    <input type="submit" name="提交">
                </label>
            </form>
        </th>
    </tr>
    <tr>
        <th>
            根据学号查找
            <form action="${pageContext.request.contextPath}/student/number" method="get">
                <label>
                    <input type="text" name="number" value="">
                    <input type="submit" name="提交">
                </label>
            </form>
        </th>
    </tr>
</table>
<c:if test="${empty requestScope.student}">
    没有任何用户信息！
</c:if>
<c:if test="${!empty requestScope.student}">
    <form method="GET" action="${pageContext.request.contextPath}/student/newone">
        学员列表：<input type="submit" value="新增学员信息"/></form>
        <table border="1" cellpadding="10" cellspacing="0" class="table1">
            <tr>
                <th>学员ID</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>QQ</th>
                <th>修真类型</th>
                <th>加入时间</th>
                <th>学校</th>
                <th>线上学号</th>
                <th>日报链接</th>
                <th>立愿</th>
                <th>辅导师兄</th>
                <th>修改信息</th>
                <th>删除信息</th>
            </tr>
            <c:forEach items="${requestScope.student.lists}" var="student" >
                <tr>
                    <th>${student.id}</th>
                    <th>${student.name}</th>
                    <th>${student.gender}</th>
                    <th>${student.age}</th>
                    <th>${student.qq}</th>
                    <th>${student.occupation}</th>
                    <th>${student.joinDate}</th>
                    <th>${student.school}</th>
                    <th>${student.number}</th>
                    <th>${student.dailyUrl}</th>
                    <th>${student.declaration}</th>
                    <th>${student.consoler}</th>
                    <th>
                        <form action="${pageContext.request.contextPath}/student/${student.id}" method="GET">
                            <input type="submit" value="修改">
                                  </form>
                    </th>
                    <th>
                        <form action="${pageContext.request.contextPath}/student/${student.id}" method="POST">
                            <input type="hidden" value="DELETE" name="_method"/>
                            <input type="submit" value="删除">
                        </form>
                    </th>
                </tr>
            </c:forEach>
        </table>

<table border="0" cellspacing="0" cellpadding="0" width="900px">
    <tr>
        <td class="td2">
            <span>第${requestScope.student.currPage}/ ${requestScope.student.totalPage}页</span>&nbsp;&nbsp;
            <span>总记录数：${requestScope.student.totalCount }&nbsp;&nbsp;每页显示:${requestScope.student.pageSize}</span>&nbsp;&nbsp;
            <span>
       <c:if test="${requestScope.student.currPage != 1}">
           <a href="${pageContext.request.contextPath }/student/list?currentPage=1">[首页]</a>&nbsp;&nbsp;
           <a href="${pageContext.request.contextPath }/student/list?currentPage=${requestScope.student.currPage-1}">[上一页]</a>&nbsp;&nbsp;
       </c:if>

       <c:if test="${requestScope.student.currPage != requestScope.student.totalPage}">
           <a href="${pageContext.request.contextPath }/student/list?currentPage=${requestScope.student.currPage+1}">[下一页]</a>&nbsp;&nbsp;
           <a href="${pageContext.request.contextPath }/student/list?currentPage=${requestScope.student.totalPage}">[尾页]</a>&nbsp;&nbsp;
       </c:if>
   </span>
        </td>
    </tr>
</table>
</c:if>
</body>

</html>