<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">--%>
<%--<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>

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
                    <div><h2>信息：${requestScope.message}</h2>
                </div>
                <form class="form-inline login-form" action="/u/login" method="post">
                    <input type="hidden" name="_method" value="POST">
                    <div class="tel-user user-summary">
                        <i></i><input class="form-control" name="name" type="text" placeholder="请输入用户名">
                     </div><br>
                    <div class="pwd-user user-summary">
                        <i></i><input class="form-control" name="pwd" type="password" placeholder="请输入登录密码" >
                     </div><br>
                    <div class="btn-area">
                        <button type="submit" class="btn btn-info" >登录</button>
                        <a type="button" class="btn btn-default" href="/u/reg" >去注册</a>
                    </div>
                </form>
                </div>
            </div>
            </div>
        </div>
    </div>
</main>