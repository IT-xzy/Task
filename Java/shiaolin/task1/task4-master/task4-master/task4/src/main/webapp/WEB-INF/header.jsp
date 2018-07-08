<%@page   contentType="text/html;   charset=UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<div class="contact">
    <a class="contact-icon icon-03" href="#"></a>
    <a class="contact-icon icon-02" href="#"></a>
    <a class="contact-icon icon-01" href="#"></a>
    <p class="hotline">客服热线：010-594-78634</p>
    <a class="login" href="#">登录&nbsp;</a>
    <a class="logon" href="#">&nbsp;注册</a>
</div>
<div class="navbar-user">
    <div class="logo"></div>
    <a class="nav-user" href="${pageContext.request.contextPath}/">首页</a>
    <a class="nav-user" href="${pageContext.request.contextPath}/joblist">职业</a>
    <a class="nav-user" href="${pageContext.request.contextPath}/cooperate">推荐</a>
    <a class="nav-user" href="#">关于</a>
    <div class="dropdown">
        <button type="button" class="btn dropdown-toggle" id="dropdownMenu" data-toggle="dropdown">
            <img src="${pageContext.request.contextPath}images/icon_04.png" alt="菜单">
        </button>
        <ul class="dropdown-menu dropdown-menu-right" role="menu" aria-labelledby="dropdownMenu">
            <li role="presentation">
                <a role="menuitem" tabindex="-1" href="${pageContext.request.contextPath}/WEB-INF/tiles/index.jsp">首页</a>
            </li>
            <li role="presentation" class="divider"></li>
            <li role="presentation">
                <a role="menuitem" tabindex="-1" href="${pageContext.request.contextPath}/WEB-INF/tiles/cooperate_page.jsp">职业</a>
            </li>
            <li role="presentation" class="divider"></li>
            <li role="presentation">
                <a role="menuitem" tabindex="-1" href="${pageContext.request.contextPath}/WEB-INF/tiles/cooperate_page.jsp">推荐</a>
            </li>
            <li role="presentation" class="divider"></li>
            <li role="presentation">
                <a role="menuitem" tabindex="-1" href="#">关于</a>
            </li>
        </ul>
    </div>
</div>