<%--
  Created by IntelliJ IDEA.
  User: caoyue
  Date: 2018/4/11
  Time: 下午3:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>列表页（显示搜索结果）</title>
</head>
<body>
<table width="60%" border="1" cellpadding="2" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>QQ</th>
        <th>onlineNumber</th>
        <th>enrollmentTime</th>
        <th>professionType</th>
        <th>dailyLink</th>
        <th>promise</th>
        <th>brotherName</th>
        <th>mail</th>
        <th>phone</th>
    </tr>
    <c:forEach items="${requestScope.pagesmg.lists}" var="student">
        <tr>
            <td>${student.ID }</td>
            <td>${student.name }</td>
            <td>${student.QQ}</td>
            <td>${student.onlineNumber}</td>
            <td>${student.enrollmentTime}</td>
            <td>${student.professionType}</td>
            <td>${student.dailyLink}</td>
            <td>${student.promise}</td>
            <td>${student.brotherName}</td>
            <td>${student.mail}</td>
            <td>${student.phone}</td>
            <td><form action="/user/newstudent" method="get">
                <input type="hidden" name="ID" value="${student.ID}">
                <input type="submit" value="更新">
            </form> </td>
            <td><form action="/user/student/${student.ID}" method="post">
                <input type="hidden" name="_method" value="DELETE">
                <input type="submit" value="删除">
            </form></td>
        </tr>
    </c:forEach>
</table>
<table  border="0" cellspacing="0" cellpadding="0"  width="900px" >
    <tr>
        <td class="td2">
            <span>第${requestScope.pagesmg.currentPage }/ ${requestScope.pagesmg.totalPage}页</span>&nbsp;&nbsp;
            <span>总记录数：${requestScope.pagesmg.totalCount }&nbsp;&nbsp;每页显示:${requestScope.pagesmg.pageSize}</span>&nbsp;&nbsp;
            <span>
       <c:if test="${requestScope.pagesmg.currentPage != 1}">
           <a href="${pageContext.request.contextPath }/user/nameList?currentPage=1&name=${name}">[首页]</a>&nbsp;&nbsp;
           <a href="${pageContext.request.contextPath }/user/nameList?currentPage=${requestScope.pagesmg.currentPage-1}&name=${name}">[上一页]</a>&nbsp;&nbsp;
       </c:if>

       <c:if test="${requestScope.pagesmg.currentPage != requestScope.pagesmg.totalPage}">
           <a href="${pageContext.request.contextPath }/user/nameList?currentPage=${requestScope.pagesmg.currentPage+1}&name=${name}">[下一页]</a>&nbsp;&nbsp;
           <a href="${pageContext.request.contextPath }/user/nameList?currentPage=${requestScope.pagesmg.totalPage}&name=${name}">[尾页]</a>&nbsp;&nbsp;
       </c:if>
          <a href="/index.jsp">返回主页</a>
   </span>
        </td>
    </tr>
</table>

</body>
</html>
