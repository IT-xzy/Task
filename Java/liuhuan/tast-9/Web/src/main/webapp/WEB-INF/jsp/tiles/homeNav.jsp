<%@ page import="java.net.URLDecoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="title" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a href="#" class="navbar-brand">
                <img src="${pageContext.request.contextPath}/static/images/logo.png" alt="Brand" class="img-responsive">
            </a>
            <button data-target="#open-nav" data-toggle="collapse" class="navbar-toggle btn-primary collapsed" aria-expanded="false">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div id="open-nav" class="navbar-collapse collapse" aria-expanded="false" style="height: 1px;">
            <ul class="nav navbar-nav navbar-right text-center list-inline">
                <li><a href="${pageContext.request.contextPath}/">首页</a></li>
                <li><a href="${pageContext.request.contextPath}/profession">职业</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/students">后台管理</a></li>

                <%-- 登陆模块 --%>
                <c:choose>
                    <c:when test="${cookie.token.value!=null }">
                        <li>
                        <%!String username = "not user"; %>
                        <%
                            Cookie[] cookies = request.getCookies();
                            for (int i = 0; i < cookies.length; i++) {
                                if (cookies[i].getName().equals("username")) {
                                    username = cookies[i].getValue();
                                    break;
                                }
                            }
                        %>
                            <a href="${pageContext.request.contextPath }/admin/students"><%=URLDecoder.decode(username) %></a>
                        </li>
                        <li> <a href="${pageContext.request.contextPath }/logout">退出</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="${pageContext.request.contextPath}/login">登陆</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>