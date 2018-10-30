<%--
  Created by IntelliJ IDEA.
  User: John
  Date: 2018/7/9
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>

<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript">
    $(function () {
        $(".del").click(function () {
            var href=$(this).attr("href");
            $("#formdel").attr("action",href).submit();
            return false;
        })
    })
</script>
<header class="header">
    <div class="header-content">
        <div class="header-content_center">
            <div class="header-left" >客服热线：010-594-78634
                <%--当前在线人数：<%=session.getAttribute("userNumber")%>--%>
            </div>
            阿里云
            <div class="header-right">
                <% String name= (String) session.getAttribute("name");
                    if(name!=null){%>
                <a class="del" href="/session" style="color:blue;float: right" >  注销</a>
                <%=request.getSession().getAttribute("name")%>
                <%}else{%>
                <a href="/register" style="color:blue;float: right" >注册</a>
                <a href="/user" style="color:blue;float: right" >登录</a><%}
            %>
            </div>
            <div class="header-right">
                <img class="img-header" src="../img/css8/header-1.png">
                <img class="img-header" src="../img/css8/header-2.png">
                <img class="img-header" src="../img/css8/header-3.png">
            </div>
        </div>
    </div>
    <div class="header-nav">
        <div class="header-nav_center">
            <img class="center_img" src="../img/css8/jnshu.png">
            <div class="nav">
                <a class="nav_a" href="/professions">关于</a>
                <a class="nav_a" href="/job">推荐</a>
                <a class="nav_a" href="/u/students">学生管理</a>
                <a class="nav_a" href="/">首页</a>
            </div>
            <div class="nav--small">
                <input class="nav-button" type="checkbox" id="nav--small_button">
                <div class="nav--small_right">
                    <label class="drop-down_button icon-menu" for="nav--small_button"></label>
                </div>
                <div class="drop-down">
                    <a class="drop_a" href="/">首页</a>
                    <a class="drop_a" href="#">就业</a>
                    <a class="drop_a" href="/">推荐</a>
                    <a class="drop_a" href="/job">关于</a>
                </div>
            </div>
        </div>
    </div>
</header>
<form id="formdel" action="" method="post">
    <input type="hidden" name="_method" value="delete">
</form>
