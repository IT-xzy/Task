<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/7
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<html>
<head>
    <title>selectAll</title>


</head>
<body>

<json:object>
    <json:array name="student" var="stu" items="${stuList}">
        <json:property name="id" value="${stu.id}"/>
        <json:property name="name" value="${stu.name}"/>
        <json:property name="qq" value="${stu.qq}"/>
        <json:property name="type" value="${stu.type}"/>
        <json:property name="time" value="${stu.time}"/>
        <json:property name="school" value="${stu.school}"/>
        <json:property name="onlineNumber" value="${stu.onlineNumber}"/>
        <json:property name="link" value="${stu.link}"/>
        <json:property name="wish" value="${stu.wish}"/>
        <json:property name="teacher" value="${stu.teacher}"/>
    </json:array>
</json:object>




    <c:if test="${empty requestScope.pageInfo.list}">
        no Student
    </c:if>
    <c:if test="${!empty requestScope.pageInfo.list}">
        <table border="1" cellpadding="10"cellspacing="0" >
            <tr>
                <td>id</td>
                <td>name</td>
                <td>qq</td>
                <td>type</td>
                <td>time</td>
                <td>school</td>
                <td>onlineNumber</td>
                <td>link</td>
                <td>wish</td>
                <td>teacher</td>
                <td>whereKonw</td>
                <td>createAt</td>
                <td>updateAt</td>
            </tr>
            <c:forEach items="${requestScope.pageInfo.list}" var="stu" varStatus="stuList">
                <tr>
                    <td>${stu.id}</td>
                    <td>${stu.name}</td>
                    <td>${stu.qq}</td>
                    <td>${stu.type}</td>
                    <td>${stu.time}</td>
                    <td>${stu.school}</td>
                    <td>${stu.onlineNumber}</td>
                    <td>${stu.link}</td>
                    <td>${stu.wish}</td>
                    <td>${stu.teacher}</td>
                    <td>${stu.whereKonw}</td>
                    <td>${stu.createAt}</td>
                    <td>${stu.updateAt}</td>
                    <td><a href="${pageContext.request.contextPath}/stu/${stu.id}">update</a> </td>
                    <td>
                        <form action="${pageContext.request.contextPath}/stu/${stu.id}" method="post">
                            <input type="hidden" name="_method" value="DELETE"/>
                            <input type="submit" value="delete"/>
                        </form>
                    </td>

                        <%--<td><a href="">delete</a> </td>--%>
                        <%--<td><a class="delete" href="stu/${stu.id }">Delete</a>--%>
                    <%--</td>--%>


                </tr>
            </c:forEach>
        </table>
    </c:if>
    <!--显示分页信息-->
    <div class="row">
        <!--文字信息-->
        <div class="col-md-6">
            当前第 ${pageInfo.pageNum} 页.总共 ${pageInfo.pages} 页.一共 ${pageInfo.total} 条记录
        </div>

        <!--点击分页-->
        <div class="col-md-6">
            <nav aria-label="Page navigation">
                <ul class="pagination">

                    <li><a href="${pageContext.request.contextPath}/stus?pn=1">首页</a></li>

                    <!--上一页-->
                    <li>
                        <c:if test="${pageInfo.hasPreviousPage}">
                            <a href="${pageContext.request.contextPath}/stus?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                                <span aria-hidden="true">«</span>
                            </a>
                        </c:if>
                    </li>

                    <!--循环遍历连续显示的页面，若是当前页就高亮显示，并且没有链接-->
                    <c:forEach items="${pageInfo.navigatepageNums}" var="page_num">
                        <c:if test="${page_num == pageInfo.pageNum}">
                            <li class="active"><a href="#">${page_num}</a></li>
                        </c:if>
                        <c:if test="${page_num != pageInfo.pageNum}">
                            <li><a href="${pageContext.request.contextPath}/stus?pn=${page_num}">${page_num}</a></li>
                        </c:if>
                    </c:forEach>

                    <!--下一页-->
                    <li>
                        <c:if test="${pageInfo.hasNextPage}">
                            <a href="${pageContext.request.contextPath}/stus?pn=${pageInfo.pageNum+1}"
                               aria-label="Next">
                                <span aria-hidden="true">»</span>
                            </a>
                        </c:if>
                    </li>

                    <li><a href="${pageContext.request.contextPath}/stus?pn=${pageInfo.pages}">尾页</a></li>
                </ul>
            </nav>
        </div>

    </div>




    <a href="${pageContext.request.contextPath}/stu" >input stu</a>



</body>
</html>
<%--<td><form action="/stu/{id}" method="post">--%>
    <%--<input type="submit" value="delete">--%>
    <%--<input type="hidden" value="${stu.id}" name="id">--%>
    <%--<input type="hidden" name="_method" value="delete">--%>
<%--</form> </td>--%>