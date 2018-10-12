<%--
  Created by IntelliJ IDEA.
  User: lihoo
  Date: 2018/8/22
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false" %>

<%@ include file="../includes/includes.jsp" %>

<div class="login-bgc">
    <div class="container">
        <div class="row log-main">
            <form action="join" method="post">
                <div class="log-table col-xs-9 col-sm-6 col-md-4 col-lg-4">
                    <h2 style="color: #eea236">****登录失败****</h2>
                    <div class="content1"><h4>看看是不是账号和密码哪一个填错了？</h4></div>
                    <div>
                        <a style="font-size: x-large" href="${pageContext.request.contextPath}/login">重新登录</a>
                    </div>
                    <div id="alert3"></div>
                    <div id="alert4"></div>
                </div>
            </form>
        </div>
    </div>
</div>