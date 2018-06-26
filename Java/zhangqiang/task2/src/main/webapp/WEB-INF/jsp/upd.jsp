<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/7
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改页</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%--<table>--%>
    <%--<thead>--%>
    <%--<tr>--%>

        <%--<th>ID</th>--%>
        <%--<th>姓名</th>--%>
        <%--<th>密码</th>--%>
        <%--<th>QQ</th>--%>
        <%--<th>邮箱</th>--%>
        <%--<th>地址</th>--%>
        <%--<th>电话</th>--%>
        <%--<th>操作</th>--%>
    <%--</tr>--%>
    <%--</thead>--%>
    <%--<c:if test="${!empty upduser}">--%>
        <%--<tr>--%>
            <%--<td>${upduser.id}</td>--%>
            <%--<td>${upduser.name}</td>--%>
            <%--<td>${upduser.pwd}</td>--%>
            <%--<td>${upduser.qq}</td>--%>
            <%--<td>${upduser.email}</td>--%>
            <%--<td>${upduser.address}</td>--%>
            <%--<td>${upduser.tell}</td>--%>
            <%--<td>--%>
                <%--<from action="/urg/user" method="post">--%>
                    <%--<innput type="hidden" name="_method" values="PUT"/>--%>
                    <%----%>
                <%--</from>--%>

            <%--</td>--%>
        <%--</tr>--%>
    <%--</c:if>--%>
<%--</table>--%>
<div class="backhome">
    <a href="/index.jsp" class="btn btn-default">返回主页</a>
</div>
<div>
    <form action="/urg/user/list"  class="from">
        <button type="submit"  class="btn btn-default">去列表页</button>
    </form>
</div>
<div class="register-container container">
    <div class="row">
        <div class="register">
            <c:if test="${!empty requestScope.upduser}">
                <form action="/urg/user" name="updStu" class="updfrom" id="updfrom" method="post">
                    <h5><span class="red"><strong>修改数据</strong></span></h5>
                    <input type="hidden" name="_method" value="PUT"/>
                    <div class="col-md-12"  >
                        <label for="id" class="col-md-4 from-label">id</label>
                        <input type="text" class="col-md-8" value="${requestScope.upduser.id}" disabled="disabled">
                        <input type="hidden" class="col-md-8" id="id" name="id" value="${requestScope.upduser.id}">
                    </div>
                    <div class="col-md-12">
                        <label for="name" class="col-md-4 from-label">账号</label>
                        <input type="text" id="name" class="col-md-8" name="name" value="${requestScope.upduser.name}" >
                    </div>
                    <div class="col-md-12">
                        <label for="pwd" class="col-md-4 from-label">密码</label>
                        <input type="text" id="pwd" class="col-md-8" name="pwd" value="${requestScope.upduser.pwd}">
                    </div>
                    <div class="col-md-12">
                        <label for="qq" class="col-md-4 from-label">type</label>
                        <input type="text" id="qq" class="col-md-8" name="qq" value="${requestScope.upduser.qq}">
                    </div>
                    <div class="col-md-12">
                        <label for="email" class="col-md-4 from-label">email</label>
                        <input type="text" id="email" class="col-md-8" name="email"  value="${requestScope.upduser.email}">
                    </div>
                    <div class="col-md-12">
                        <label for="address" class="col-md-4 from-label">address</label>
                        <input type="text" id="address" class="col-md-8" name="address" value="${requestScope.upduser.address}">
                    </div>
                    <div class="col-md-12">
                        <label for="tell" class="col-md-4 from-label">tell</label>
                        <input type="text" id="tell" class="col-md-8" name="tell" value="${requestScope.upduser.tell}">
                    </div>
                    <div class="col-md-12 buttondiv">
                        <button type="submit" class="btn btn-default" id="submitUpdUser"> 提交修改 </button>
                    </div>
                </form>
            </c:if>
        </div>
    </div>
</div>

</body>
</html>
