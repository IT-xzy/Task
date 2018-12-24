<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-6" style="text-align: center">
            <div class="col-md-6" style="padding:100px">
                <img src="http://jns.img.bucket.ks3-cn-beijing.ksyun.com/skill/skill_html/images/login-ad_03.png">
            </div>
        </div>

        <div class="col-md-6">
            <div class="col-md-6" style="margin:200px auto">

                <form class="form-inline login-form" action="/u/reg" method="post">
                    <input type="hidden" name="_method" value="POST">
                    <h2>欢迎注册</h2>
                    <span style="color: red; font-size: x-small;"><i>${msg}</i></span><br>
                    <div class="tel-user user-summary">
                        <i>用户名：&nbsp;&nbsp;&nbsp;</i><input class="form-control" name="name" type="text" placeholder="请输入用户名">
                    </div><br>
                    <div class="pwd-user user-summary">
                        <i>密码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</i><input class="form-control" name="pwd" type="password" placeholder="请输入密码" >
                    </div><br>
                    <div align="center">
                        <i></i><button type="submit" class="btn btn-orange" >注册</button>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>