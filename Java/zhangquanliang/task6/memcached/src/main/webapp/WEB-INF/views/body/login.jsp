<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
                        <h2>欢迎登录</h2>
                        <span style="color: red; font-size: x-small;"><i>${msg}</i></span><br>
                        <form class="form-inline login-form" action="/u/login" method="post">
                            <input type="hidden" name="_method" value="POST">

                            <div class="tel-user user-summary">
                                <i></i><input class="form-control" name="name" type="text" placeholder="请输入用户名">
                            </div><br>
                            <div class="pwd-user user-summary">
                                <i></i><input class="form-control" name="pwd" type="password" placeholder="请输入登录密码" >
                            </div><br>
                            <div >
                                <button class="btn btn-orange " type="submit">登录</button>&nbsp;&nbsp;&nbsp;&nbsp;
                                <a class="tn btn-orange"  href="${pageContext.request.contextPath}/u/reg">注册账号</a>
                            </div>
                        </form>
                    </div>
                </div>

            </div>
        </div>
    </div>
</main>