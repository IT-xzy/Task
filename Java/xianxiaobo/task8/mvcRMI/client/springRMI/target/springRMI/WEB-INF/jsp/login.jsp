<%--
  Created by IntelliJ IDEA.
  User: xianxiaobo
  Date: 2018/11/16
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="padding: 100px 100px 10px;">
    <div class="panel  panel-primary">
        <div class="panel-heading">
            这是来自于web2的页面
        </div>
        <div class="panel-body">
            <div class="table-responsive">
                <form>
                    <div class="form-group">
                        <label for="username">用户名/手机号/邮箱登录</label>
                        <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名/手机号/邮箱">
                    </div>
                    <div class="form-group">
                        <label for="password">密码</label>
                        <input type="text" class="form-control" id="password" name="password" placeholder="请输入密码">
                    </div>
                    <div class="form-group">
                        <button type="button" class="btn btn-primary" onClick="postLogin()">登录</button>
                    </div>
                    <div class="form-group">
                        <a href="register" class="btn btn-link" style="color:#337ab7;">没有账号？去注册</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script>
    function postLogin(){
        $.ajax({
            url:"login",
            type:"post",
            data:JSON.stringify($('form').serializeObject()),
            contentType:"application/json",
            success:function(res){
                alert(res);
                res = JSON.parse(res);
                console.log(res);
                if(res.code===200&&res.message==="success"){
                    window.location.href="u/home";
                }
            },
            error:function(res){
                alert("请求失败");
            }
        })
    }

    /**
     * 自动将form表单封装成json对象
     */
    $.fn.serializeObject = function() {
        var o = {};
        var a = this.serializeArray();
        $.each(a, function() {
            if (o[this.name]) {
                if (!o[this.name].push) {
                    o[this.name] = [ o[this.name] ];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    };
</script>