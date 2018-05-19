<%--
  Created by IntelliJ IDEA.
  User: LL
  Date: 2018/4/14
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="/tags" prefix="date"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
<div class="container  hidden-xs">
    <div class="row header-top" >
        <p class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
            客服电话:010-594-78634
            <a id="box1" class="box" style="cursor:pointer; " href="/login" >登录</a>
            <a  id="box2" class="box" style="cursor:pointer; " href="/register" >注册</a>
            <a id="box3" class="box" style="cursor:pointer; " href="/loginout">
                登出
            </a>
            <a  id="box4" class="box" style="cursor:pointer; " href="/loginout">
                user
            </a>
        </p>


        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 text-right">
            <div>
                <a href="#" target="_blank"> <img alt=""  src="<%=request.getContextPath()%>/image/微信.png"></a>
                <a href="#" target="_blank"><img alt=""  src="<%=request.getContextPath()%>/image/qq.png"></a>
                <a href="#" target="_blank"> <img alt=""  src="<%=request.getContextPath()%>/image/sina.png"></a>
            </div>
        </div>
    </div>
</div>
<!--导航栏-->
<nav class=" navbar navbar-default" role="navigation">
    <div class="container-fluid backgroundcolor-green">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle " data-toggle="collapse" data-target="#navbar-menu">
                <span class="sr-only">切换导航</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="#" class="navbar-brand nav-title "></a>
        </div>
        <div class="collapse navbar-collapse " id="navbar-menu">
            <ul class="nav navbar-nav navbar-right ">
                <li class="lide"><a href="/home">当前系统时间：<date:date/></a><div class="kongbai"></div> </li>
                <li class="lide"><a href="/home">首页</a><div class="kongbai"></div> </li>
                <li class="lide"><a href="/job">职业</a><div class="kongbai"></div> </li>
                <li class="lide"><a href="/u/company">推荐</a><div class="kongbai"></div> </li>
            </ul>
        </div>
    </div>
</nav>
<script type="text/javascript">
    function getCookie(a) {
        var strCookie = document.cookie;
        var arrCookie = strCookie.split("; ");
        for(var i = 0; i < arrCookie.length; i++){
            var arr = arrCookie[i].split("=");
            if(a == arr[0]){
                return arr[1];
            }
        }
        return "";
    }
    console.log(getCookie('Token'));
    function checkcookie(cookieName) {
        var token = getCookie('Token');
        if(token!=null && token!=""){
            return true
        }
        else return false;
    }
    var a  = document.getElementsByClassName('box');
    if (checkcookie('Token'))
    {a[0].style.display = "none";
        a[1].style.display = "none";
    }
    else
    {a[2].style.display = "none";
        a[3].style.display = "none";
    }
</script>
</body>
</html>
