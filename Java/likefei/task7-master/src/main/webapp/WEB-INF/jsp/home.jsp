<%--
  Created by IntelliJ IDEA.
  User: TF
  Date: 2018/5/3
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body >
<!--微信电话-->
<!--电话微信-->
<!--顶部-->
<div class="dianhuaweixin">
    <span>
             <a id="box1" class="box" style="cursor:pointer; " href="http://120.131.8.132/loginselect">
                登陆
            </a>
             <a id="box2" class="box" style="cursor:pointer; " href="http://120.131.8.132/registerselect">
                 注册
            </a>
             <a id="box3" class="box" style="cursor:pointer; " href="http://120.131.8.132/loginout">
                 登出
            </a>
            <a  id="box4" class="box" style="cursor:pointer;" href="">
                 ${user.name}
            </a>
            <a href="http://120.131.8.132/u/test" >这是一个rememberMe测试页面</a>
            <a href="http://120.131.8.132/a" >这是一个权限测试页面、rememberme不可以访问</a>
    </span>
</div>
<script type="text/javascript">
    console.log(${user.id});
    document.getElementById("box4").href="/u?id="+"${user.id}";
    function getCookie(cookieName) {
        var strCookie = document.cookie;
        var arrCookie = strCookie.split("; ");
        for(var i = 0; i < arrCookie.length; i++){
            var arr = arrCookie[i].split("=");
            if(cookieName == arr[0]){
                return arr[1];
            }
        }
        return "";
    }
    function checkcookie(cookieName) {
        var rememberMe = getCookie(cookieName);
        if(rememberMe!=null && rememberMe!=""){
            return true
        }
        else return false;
    }
    var a  = document.getElementsByClassName('box');
    if (checkcookie('rememberMe'))
    {a[0].style.display = "none";
        a[1].style.display = "none";
    }
    else
    {a[2].style.display = "none";
        a[3].style.display = "none";
    }
</script>
</body>