<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String appPath = request.getContextPath(); %>
<html>
<head>
    <title>Paper列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    基于SSM框架的管理系统：简单实现增、删、改、查。
                </h1>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>论文列表 —— 显示所有论文</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 column">
            <a class="btn btn-primary" href="${path}/toAddPaper">新增</a>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>论文编号</th>
                    <th>论文名字</th>
                    <th>论文数量</th>
                    <th>论文详情</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>

                <%--分页查询--%>
               <c:forEach var="paper" items="${pagemsg.lists}" varStatus="status">

                <%--<c:forEach var="paper" items="${requestScope.get('list')}" varStatus="status">--%>
                    <tr>
                        <td>${paper.paperId}</td>
                        <td>${paper.paperName}</td>
                        <td>${paper.paperNum}</td>
                        <td>${paper.paperDetail}</td>
                        <td>

                            <a href="${path}/toUpdatePaper/${paper.paperId}">更改</a>

                            <%--<form action="<%=appPath%>/toUpdatePaper/${paper.paperId}" method="post">--%>
                                <%--&lt;%&ndash;<input type="hidden" name="_method" value="UPDATE"/>&ndash;%&gt;--%>
                                <%--<input type="submit" value="更改">--%>
                            <%--</form>--%>

                            <form action="<%=appPath%>/del/${paper.paperId}" method="post">
                                <input type="hidden" name="_method" value="DELETE"/>
                                <input type="submit" value="删除">
                            </form>
                            <%--<a href="<%=appPath%>/del/${paper.paperId}">删除</a>--%>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>

                <table border="0" cellspacing="0" cellpadding="0" width="900px">
                    <tr>
                        <td class="td2">
                            <span>第${requestScope.pagemsg.currPage }/ ${requestScope.pagemsg.totalPage}页</span>&nbsp;&nbsp;
                            <span>总记录数：${requestScope.pagemsg.totalCount }&nbsp;&nbsp;每页显示:${requestScope.pagemsg.pageSize}</span>&nbsp;&nbsp;
                            <span>
       <c:if test="${requestScope.pagemsg.currPage != 1}">
           <a href="${pageContext.request.contextPath }/allPaper?currentPage=1">[首页]</a>&nbsp;&nbsp;
           <a href="${pageContext.request.contextPath }/allPaper?currentPage=${requestScope.pagemsg.currPage-1}">[上一页]</a>&nbsp;&nbsp;
       </c:if>

       <c:if test="${requestScope.pagemsg.currPage != requestScope.pagemsg.totalPage}">
           <a href="${pageContext.request.contextPath }/allPaper?currentPage=${requestScope.pagemsg.currPage+1}">[下一页]</a>&nbsp;&nbsp;
           <a href="${pageContext.request.contextPath }/allPaper?currentPage=${requestScope.pagemsg.totalPage}">[尾页]</a>&nbsp;&nbsp;
       </c:if>
   </span>
                        </td>
                    </tr>
                </table>
                </td>
                </tr>
            </table>
            </table>
        </div>
    </div>
</div>