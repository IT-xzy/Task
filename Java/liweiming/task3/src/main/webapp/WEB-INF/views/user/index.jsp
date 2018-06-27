<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018\5\31 0031
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<!DOCTYPE> 声明不是一个 HTML 标签；它是用来告知 Web 浏览器页面使用了哪种 HTML 版本。--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <%--<meta> 标签提供了 HTML 文档的元数据。元数据不会显示在客户端，但是会被浏览器解析。--%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户管理</title>

    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <!-- web路径：
    不以/开始的相对路径，找资源，以当前资源的路径为基准，经常容易出问题。
    以/开始的相对路径，找资源，以服务器的路径为标准(http://localhost:3306)；需要加上项目名
            http://localhost:3306/
     -->
        <%--type 属性规定脚本的 MIME 类型。type 属性标识 <script> 与 </script> 标签之间的内容。--%>
        <%--src 属性规定外部脚本文件的 URL。--%>
        <script src="https://cdn.bootcss.com/jquery/3.3.0/jquery.min.js"></script>
        <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>



<%--搭建显示页面--%>
<%--<div> 标签定义 HTML 文档中的一个分隔区块或者一个区域部分。
    <div>标签常用于组合块级元素，以便通过 CSS 来对这些元素进行格式化。--%>


<div class="container">
<%--标题--%>
    <div class="row">
        <div class="col-md-12">
        <h2>用户管理</h2>
        </div>
    </div>
<%--按钮--%>

    <div class="row">
        <div class="col-md-2 col-md-offset-10">
            <%--<button class="btn btn-primary" id="user_add_modal_btn">新增</button>--%>
                <a href="${APP_PATH}/user/add" class="add" >新增</a>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <h1>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</h1>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <table class="table table-condensed table-bordered table-hover">
                <tr><%--<tr> 标签定义 HTML 表格中的行。--%>
                    <%--<td> 标签定义 HTML 表格中的标准单元格。--%>
                    <th>编号</th>
                    <th>姓名</th>
                    <th>QQ</th>
                    <th>学习类型</th>
                    <th>入学时间</th>
                    <th>学校</th>
                    <th>学号</th>
                    <th>日报链接</th>
                    <th>愿望</th>
                    <th>在线师兄</th>
                    <th>创建时间</th>
                    <th>更新时间</th>
                    <th>操作</th>
                </tr>
    <%--<c:forEach>	基础迭代标签，接受多种集合类型--%>
                <c:forEach items="${pageInfo.list}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.qq}</td>
                        <td>${user.learning_type}</td>
                        <td>${user.entrance_time}</td>
                        <td>${user.school}</td>
                        <td>${user.online_id}</td>
                        <td>${user.daily_link}</td>
                        <td>${user.wish}</td>
                        <td>${user.tutor}</td>
                        <td>${user.create_at}</td>
                        <td>${user.update_at}</td>
                        <td>
                            <%--<button class="btn btn-primary btn-xs edit_btn">
                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                编辑
                            </button>--%>
                            <a href="edit/${user.id}" class="edit">编辑</a>
                            <%--<a href="del/${user.id}" class="del">删除</a>--%>
                            <button class="btn btn-danger btn-xs delete_btn" id="delete_btn">
                                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                删除
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <h1>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</h1>
        </div>
    </div>

    <!-- 显示分页信息 -->

    <div class="row">
    <!--分页文字信息  -->
        <div class="col-md-6">当前 ${pageInfo.pageNum}页,总${pageInfo.pages}
        页,总 ${pageInfo.total} 条记录
        </div>
    <!-- 分页条信息 -->
        <div class="col-md-6">
            <nav aria-label="Page navigation">
                <ul class="pagination"><%--<ul> 标签定义无序列表。将 <ul> 标签与 <li> 标签一起使用，创建无序列表。--%>
                    <li><a href="${APP_PATH}/user?pn=1">首页</a></li>
                <%--<a> 标签定义超链接，用于从一个页面链接到另一个页面。--%>
                <%--判断是否有上一页，有则显示--%>

                    <c:if test="${pageInfo.hasPreviousPage}">
                    <li><a href="${APP_PATH}/user?pn=${pageInfo.pageNum-1}"
                           aria-label="Previous"> <span aria-hidden="true"><<</span>
                    </a></li>
                    </c:if>
                                <%--page_Num取出要遍历的每页--%>
                    <c:forEach items="${pageInfo.navigatepageNums}" var="page_Num">
                    <%--如果等于当前页，则设置为 active--%>
                        <c:if test="${page_Num==pageInfo.pageNum}">
                        <li class="active"><a href="#">${page_Num}</a></li>
                        </c:if>
                                 <%--如果不是--%>
                        <c:if test="${page_Num!= pageInfo.pageNum }">
                        <li><a href="${APP_PATH}/user?pn=${page_Num}">${page_Num}</a></li>
                        </c:if>
                    </c:forEach>

                <%--判断是否有下一页，有则显示--%>

                    <c:if test="${pageInfo.hasNextPage}">
                        <li><a href="${APP_PATH}/user?pn=${pageInfo.pageNum+1}"
                           aria-label="Next"> <span aria-hidden="true">>></span></a>
                        </li>
                    </c:if>
                    <li><a href="${APP_PATH}/user?pn=${pageInfo.pages}">末页</a></li>
                </ul>
            </nav>
        </div>
    </div>
</div>


<script type="text/javascript">

</script>

</body>
</html>