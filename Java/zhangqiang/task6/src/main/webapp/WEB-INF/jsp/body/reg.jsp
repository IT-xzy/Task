<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">--%>
<%--<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
<%@ page isELIgnored="false" %>
<%--核心标签 支持 c:--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<div>--%>
<%--加密后的name：${namea}<br>--%>
<%--加密后的pwd：${pwda}--%>
<%--</div>--%>
<main>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6" style="text-align: center">
                <div class="col-md-6" style="padding:100px">
                    <img src="http://jns.img.bucket.ks3-cn-beijing.ksyun.com/skill/skill_html/images/login-ad_03.png">
                </div>
            </div>
            <div class="col-md-6">
                <div class="col-md-6" style="margin:200px auto">
                    <div>${message}
                    </div>
                    <form class="form-inline login-form" action="/u/reg" method="post">
                        <input type="hidden" name="_method" value="POST">
                        <div class="tel-user user-summary">
                            <i></i><input class="form-control" name="name" type="text" placeholder="请输入用户名">
                        </div><br>
                        <div class="pwd-user user-summary">
                            <i></i><input class="form-control" name="pwd" type="password" placeholder="请输入登录密码" >
                        </div><br>
                        <div class="btn-area">
                            <button type="submit" class="btn btn-orange" >注册</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</main>