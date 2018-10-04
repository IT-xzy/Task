<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" session="false" %>
<%@taglib uri="/WEB-INF/tld/dateTagSimple.tld" prefix="ds"%>

<html>
<head>
    <title>studentList</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/home.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/body_student.css">
</head>

<body>
<div class="container">
    <!--标题-->
    <div class="row">
        <div class="col1-md-12">
            <h1>学生列表</h1>
        </div>
    </div>

    <!--显示表格数据-->
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover">
                <tr>
                    <th>ID</th>
                    <th>头像</th>
                    <th>Name</th>
                    <th>create time</th>
                    <th>update time</th>
                    <th>操作</th>
                </tr>

                <c:forEach items="${pageInfo.list}" var="student">
                    <tr>
                        <th>${student.id}</th>
                        <th><img src="${student.image}" class="img_table"></th>
                        <th>${student.name}</th>
                        <th><ds:date_s value="${student.create_at}"/></th>
                        <th><ds:date_s value="${student.update_at}"/></th>
                        <th>
                            <a href="${pageContext.request.contextPath}/delete?studentID=${student.id}"><input type="button" value="删除" class="btn btn-danger"></a>
                        </th>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

    <!--显示分页信息-->
    <div class="row">
        <div class="col-md-6">
            当前第 ${pageInfo.pageNum} 页.总共 ${pageInfo.pages} 页.一共 ${pageInfo.total} 条记录
        </div>

        <!--点击分页-->
        <div class="col-md-6">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li><a href="${pageContext.request.contextPath}/u/studentByT?pageNumber=1">首页</a></li>
                    <!--
                        注：使用腾讯云 studentByT  使用七牛云 studentByQ
                    -->
                    <!--上一页-->
                    <li>
                        <c:if test="${pageInfo.hasPreviousPage}">
                            <a href="${pageContext.request.contextPath}/u/studentByT?pageNumber=${pageInfo.pageNum-1}" aria-label="Previous">
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
                            <li><a href="${pageContext.request.contextPath}/u/studentByT?pageNumber=${page_num}">${page_num}</a></li>
                        </c:if>
                    </c:forEach>

                    <!--下一页-->
                    <li>
                        <c:if test="${pageInfo.hasNextPage}">
                            <a href="${pageContext.request.contextPath}/u/studentByT?pageNumber=${pageInfo.pageNum+1}"
                               aria-label="Next">
                                <span aria-hidden="true">»</span>
                            </a>
                        </c:if>
                    </li>

                    <li><a href="${pageContext.request.contextPath}/u/studentByT?pageNumber=${pageInfo.pages}">尾页</a></li>
                </ul>
            </nav>
        </div>
    </div>
</div>
</body>
<!--jQuery(Bootstrap的JavaScript插件需要引入jQuery)-->
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<!--包括所以已编译的插件-->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</html>