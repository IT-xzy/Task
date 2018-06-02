<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/7
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="/js/layer/layer.js"></script>
    <script>
    function onupd(id){
        <%--windows.location.href="/urg/user/"+id;--%>

        var from = $("#itemUpdFrom");
        from.action = "/urg/user";
        from.submit();
        alert(from.action);
    }
    function del(id){
        <%--windows.location.href="/urg/user/"+id;--%>

        layer.msg('不允许删除！');
        <%--var from = $("#itemDelFrom");--%>
        <%--from.action = "/urg/user/"+id;--%>
        <%--from.submit();--%>
    }
</script>
    <style>
        .pagination{
            float: right;
        }
    </style>
</head>
<body>
<div class="backhome" >
    <a  class="btn btn-default"  href="/index.jsp">返回主页</a>
</div>
<div class="message">
    <c:if test="${!empty message}">
        ${message}
    </c:if>
</div>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-condensed">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>姓名</th>
                    <th>密码</th>
                    <th>QQ</th>
                    <th>邮箱</th>
                    <th>地址</th>
                    <th>电话</th>
                    <th>操作</th>
                </tr>
                </thead>
                <c:if test="${!empty requestScope.nowPages.pages}">
                    <c:forEach items="${requestScope.nowPages.pages}" var="item">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.name}</td>
                            <td>${item.pwd}</td>
                            <td>${item.qq}</td>
                            <td>${item.email}</td>
                            <td>${item.address}</td>
                            <td>${item.tell}</td>
                            <td>
                                <form  id="itemUpdFrom" action="/urg/user/${item.id}">
                                    <input type="hidden" name="id" value="${item.id}" >
                                    <button type="submit" id="itemUpdFb${item.id}"  class="btn btn-primary btn-sm"  >编辑</button>
                                </form>
                                <form id="itemDelFrom" method="post" >
                                    <input type="hidden" name="_method" value="delete">
                                    <input name="id" type="hidden" name="id" value="${item.id}" placeholder="${user.id}">
                                    <button type="button"  class="btn btn-danger btn-sm" onclick="del(id)" >删除</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                <%--<c:if test="${!empty user}">--%>
                    <%--<tr>--%>
                        <%--<td>${user.id}</td>--%>
                        <%--<td>${user.name}</td>--%>
                        <%--<td>${user.pwd}</td>--%>
                        <%--<td>${user.qq}</td>--%>
                        <%--<td>${user.email}</td>--%>
                        <%--<td>${user.address}</td>--%>
                        <%--<td>${user.tell}</td>--%>
                        <%--<td>--%>
                            <%--<input action="/urg/user" method="post">--%>
                                <%--<input type="hidden" name="_method" value="post"/>--%>
                                <%--<input name="id" type="hidden" name="id" value="${user.id}" placeholder="${user.id}"/>--%>
                                <%--<button type="button"class="btn btn-info btn-sm" onclick="onupd(id)">编辑</button>--%>
                            <%--</form>--%>
                            <%--<form action="/urg/user" method="post" >--%>
                                <%--<input type="hidden" name="_method" value="delete"/>--%>
                                <%--<input name="id" type="hidden" name="id" value="${user.id}" placeholder="${user.id}"/>--%>
                                <%--<button type="button"  class="btn btn-info btn-sm"  onclick="del(${user.id})">删除</button>--%>
                            <%--</form>--%>
                        <%--</td>--%>
                    <%--</tr>--%>
                <%--</c:if>--%>

                <tr>
                    <td colspan="9">
                        <ul class="pagination">

                            <li><a >第${requestScope.nowPages.currPage}/${requestScope.nowPages.totalPage}页</a>&nbsp;<a >总记录:${requestScope.nowPages.totalConut}条,每页显示${requestScope.nowPages.pageSize}条</a></li>
                            <li><a href="/user?nowpage=1">首页</a>
                                <c:if test="${requestScope.nowPages.currPage != 1}">
                                    <a href="/urg/user/list?nowpage=${requestScope.nowPages.currPage-1}">上一页</a>
                                </c:if>

                                <c:if test="${requestScope.nowPages.currPage != requestScope.nowPages.totalPage}">
                                    <a href="/urg/user/list?nowpage=${requestScope.nowPages.currPage+1}">下一页</a>
                                    <a href="/urg/user/list?nowpage=${requestScope.nowPages.totalPage}">尾页</a>
                                </c:if>

                            </li>
                        </ul>

                    </td>
                </tr>

            </table>

        </div>
    </div>
</div>


</body>

</html>
