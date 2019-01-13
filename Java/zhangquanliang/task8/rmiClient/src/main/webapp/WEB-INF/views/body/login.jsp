<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.js"></script>
<main>
    <div class="container-fluid">
        <div class="row">

            <div class="rowwwwww" style="width:100%; margin: 50px;">
                <div class="col-md-6" style="text-align: center">
                    <div class="col-md-6" style="padding:100px">
                        <img src="http://jns.img.bucket.ks3-cn-beijing.ksyun.com/skill/skill_html/images/login-ad_03.png">
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="col-md-6" style="margin:200px auto">

                        <form class="form-inline login-form" action="/login" method="post">
                            <span style="color: red; font-size: x-small;"><i>${message}</i></span><br>
                            <div class="user-summary">
                                <i></i><input class="form-control" name="name" type="text" id="sign" placeholder="用户名/手机号/邮箱" required>
                            </div><br>
                            <div class="user-summary">
                                <i></i><input class="form-control" name="pwd" type="password" id="pwd" placeholder="请输入登录密码" required>
                            </div><br>
                            <div >
                                <button class="btn btn-lg " type="submit">登录</button>&nbsp;&nbsp;&nbsp;&nbsp;
                                <a class="tn btn-orange"  href="${pageContext.request.contextPath}/reg">注册账号</a>
                            </div>
                        </form>
                    </div>
                </div>

            </div>
        </div>
    </div>
</main>