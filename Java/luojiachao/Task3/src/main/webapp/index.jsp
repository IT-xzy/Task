<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>hello</title>
</head>
<body style="background-image:url(/images/Alujpg.jpg);background-size: 1440px">


<div style="text-align:center">
    hhh springmvc
</div>
<div style="text-align:center">
    <form  action="/signin" class="form-horizontal" role="form" method="post">
        <table align='center' border='1' cellspacing='0'>

            <div class="form-group">
                <label for="username" class="col-sm-2 control-label">username</label>
                <div class="col-sm-2">
                    <input type="text"  class="form-control" name="username" id="username" value=""
                           placeholder="输入用户名">
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">password</label>
                <div class="col-sm-2">
                    <input type="password" class="form-control" name="password" id="password"  value=""
                           placeholder="输入密码">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button onClick="return fun()" >登入表单</button>
                </div>
            </div>
        <a href="http://${pageContext.request.contextPath}/registered">注册</a>
        </table>
    </form>
</div>
<%--<meta http-equiv="refresh" content="3;url=students">--%>
<jsp:include page="luojiac.jsp">
    <jsp:param  name="year" value="2018" />
</jsp:include>
</body>

</html>