<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false" %>

<%@ include file="../includes/includes.jsp" %>

<%--<div class="login-bgc">--%>
    <%--<div class="container">--%>
        <%--<div class="row log-main">--%>

            <form action="login" method="post" style="text-align: center;">
                <%--<div class="log-table col-xs-9 col-sm-6 col-md-4 col-lg-4">--%>
                    <h4>请输入账号密码登录</h4>
                    <div class="content1">账号：
                        <input id="username" class="write-user" type="text" name="username" placeholder="user">
                    </div>
                    <div class="content1">密码：
                        <input id="pwd" class="write-code" type="password" name="pwd" placeholder="code">
                    </div>
                    <div id="alert1"></div>
                    <button class="btn login-btn" id="submit">登录</button>
                    <div>$</div>
                    <%--<div>--%>
                        <%--&lt;%&ndash;<button class="btn login-btn">&ndash;%&gt;--%>
                            <%--&lt;%&ndash;<a href="${pageContext.request.contextPath}/" style="color: #ffffff;">返回神奈川</a>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;</button>&ndash;%&gt;--%>
                    <%--</div>--%>
                <%--</div>--%>

            </form>

        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>
