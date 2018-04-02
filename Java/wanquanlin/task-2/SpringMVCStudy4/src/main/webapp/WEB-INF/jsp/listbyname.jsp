<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <title>Insert title here</title>
</head>
<body >
<center>查询结果</center>
<br>



<c:if test="${!empty requestScope.pagemsg2}">
    <table border="1" cellpadding="10" cellspacing="0" class="table1" align="center">
        <thead>
        <tr>
            <td>ID</td>
            <td>NAME</td>
            <td>QQ</td>
            <td>onlineID</td>
            <td>time_of_enrollment</td>
            <td>graduate_institutions</td>
            <td>report_link</td>
            <td>hearfrom</td>
            <td> </td>
            <td></td>
        </tr>
        </thead>
        <c:forEach items="${requestScope.pagemsg2.lists}" var="student">
            <tr>
                <td>${student.ID }</td>
                <td>${student.name }</td>
                <td>${student.QQ}</td>
                <td>${student.onlineID}</td>
                <td>${student.time_of_enrollment}</td>
                <td>${student.graduate_institutions}</td>
                <td>${student.report_link}</td>
                <td>${student.hearfrom}</td>
                <td><form action="${pageContext.request.contextPath}/user/student/${student.ID}" method="post">
                    <input type="submit" value="更新">
                </form> </td>
                <td><form action="${pageContext.request.contextPath}/user/student/${student.ID}" method="post">
                    <input type="hidden" name="_method" value="DELETE">
                    <input type="submit" value="删除">
                </form></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<table  border="0" cellspacing="0" cellpadding="0"  width="900px">
    <tr>
        <td class="td2">
            <span>第${requestScope.pagemsg2.currPage }/ ${requestScope.pagemsg2.totalPage}页</span>&nbsp;&nbsp;
            <span>总记录数：${requestScope.pagemsg2.totalCount }&nbsp;&nbsp;每页显示:${requestScope.pagemsg2.pageSize}</span>&nbsp;&nbsp;
            <span>
       <c:if test="${requestScope.pagemsg2.currPage != 1}">
           <a href="${pageContext.request.contextPath }/user/student/dynamic ?currentPage=1&name=${name}">[首页]</a>&nbsp;&nbsp;
           <a href="${pageContext.request.contextPath }/user/student/dynamic ?currentPage=${requestScope.pagemsg2.currPage-1}&name=${name}">[上一页]</a>&nbsp;&nbsp;
       </c:if>

       <c:if test="${requestScope.pagemsg2.currPage != requestScope.pagemsg2.totalPage}">
           <a href="${pageContext.request.contextPath }/user/student/dynamic ?currentPage=${requestScope.pagemsg2.currPage+1}&name=${name}">[下一页]</a>&nbsp;&nbsp;
           <a href="${pageContext.request.contextPath }/user/student/dynamic ?currentPage=${requestScope.pagemsg2.totalPage}&name=${name}">[尾页]</a>&nbsp;&nbsp;
       </c:if>
           <a href="/index.jsp">返回主页</a>
   </span>

        </td>
    </tr>
</table>

</div>
</body>
</html>