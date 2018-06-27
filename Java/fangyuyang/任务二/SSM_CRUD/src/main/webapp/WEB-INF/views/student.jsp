<%--
  Created by IntelliJ IDEA.
  User: Dong
  Date: 2018/1/17
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<html>
<head>
    <title>用户列表</title>
    <base href="${pageContext.request.contextPath}">
</head>

<body>

<div class="container">
    <!-- 标题 -->
    <div class="row">
        <div class="col-md-12">
            <h1>用户管理</h1>
        </div>
    </div>
    <!-- 按钮 -->
    <div class="row">
        <div class="col-md-4 col-md-offset-8">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/student">新增</a>
        </div>
    </div>

    <!-- 表格  -->
    <div class="row">
        <div class="col-md-12">
            <table border="1" cellpadding="10" cellspacing="0">
            <form action="" method="POST" >

                <tr>
                    <th>id</th>
                    <th>QQ</th>
                    <th>姓名</th>
                    <th>修真类型</th>
                    <th>预计入学时间</th>
                    <th>开始学时间</th>
                    <th>毕业院校</th>
                    <th>线上学号</th>
                    <th>日报链接</th>
                    <th>立愿</th>
                    <th>审核师兄</th>
                    <th>了解从何知</th>
                </tr>
                <c:forEach items="${student}" var="student">
                    <tr>
                        <td>${student.id}</td>
                        <td>${student.qq}</td>
                        <td>${student.name}</td>
                        <td>${student.course}</td>
                        <td>${student.update_at}</td>
                        <td>${student.create_at}</td>
                        <td>${student.school}</td>
                        <td>${student.number}</td>
                        <td>${student.url}</td>
                        <td>${student.target}</td>
                        <td>${student.old_brother}</td>
                        <td>${student.from_where}</td>
                        <th>
                            <form action="${pageContext.request.contextPath}/student/${student.id}" method="post">
                                  <input type="hidden" name="_method" value="DELETE"/>
                                  <input type="submit" value="删除">
                            </form>
                        </th>
                        <th>
                            <form action="${pageContext.request.contextPath}/student/${student.id}" method="get">
                                <input type="submit" value="编辑">
                            </form>
                        </th>
                    </tr>
                </c:forEach>
            </form>
            </table>
        </div>
    </div>
    <hr style="height:1px;border:none;border-top:1px solid #ccc;" />
    <!-- 分页导航栏 -->

    <%--<!-- 分页信息 -->--%>
    <%--<div class="row">--%>
        <%--<!-- 分页文字信息，其中分页信息都封装在pageInfo中 -->--%>
        <%--<div class="col-md-6">--%>
            <%--当前第：${pageInfo.pageNum}页，总共：${pageInfo.pages}页，总共：${pageInfo.total}条记录--%>
        <%--</div>--%>

        <%--<!-- 分页条 -->--%>
        <%--<div class="col-md-6">--%>
            <%--<nav aria-label="Page navigation">--%>
                <%--<ul class="pagination">--%>
                    <%--<li><a href="${pageContext.request.contextPath}/students/?pn=1">首页</a></li>--%>
                    <%--<c:if test="${pageInfo.hasPreviousPage }">--%>
                        <%--<li>--%>
                            <%--<a href="${pageContext.request.contextPath}/students/?pn=${pageInfo.pageNum-1}" aria-label="Previous">--%>
                                <%--<span aria-hidden="true">&laquo;</span>--%>
                            <%--</a>--%>
                        <%--</li>--%>
                    <%--</c:if>--%>

                    <%--<c:forEach items="${pageInfo.navigatepageNums }" var="page_Num">--%>
                        <%--<c:if test="${page_Num == pageInfo.pageNum }">--%>
                            <%--<li class="active"><a href="#">${page_Num}</a></li>--%>
                        <%--</c:if>--%>
                        <%--<c:if test="${page_Num != pageInfo.pageNum }">--%>
                            <%--<li><a href="${pageContext.request.contextPath}/students?pn=${ page_Num}">${ page_Num}</a></li>--%>
                        <%--</c:if>--%>
                    <%--</c:forEach>--%>
                    <%--<c:if test="${pageInfo.hasNextPage }">--%>
                        <%--<li>--%>
                            <%--<a href="${pageContext.request.contextPath}/students?pn=${pageInfo.pageNum+1}" aria-label="Next">--%>
                                <%--<span aria-hidden="true">&raquo;</span>--%>
                            <%--</a>--%>
                        <%--</li>--%>
                    <%--</c:if>--%>
                    <%--<li><a href="${pageContext.request.contextPath}/students?pn=${pageInfo.pages}">末页</a></li>--%>
                <%--</ul>--%>
            <%--</nav>--%>
        </div>
    </div>
</div>

</body>
</html>