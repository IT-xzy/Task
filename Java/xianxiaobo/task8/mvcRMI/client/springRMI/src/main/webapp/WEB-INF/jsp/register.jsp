<%--
  Created by IntelliJ IDEA.
  User: xianxiaobo
  Date: 2018/11/16
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div style="padding: 100px 100px 10px;">
    <div class="panel  panel-primary">
        <div class="panel-heading">
            用户注册
        </div>
        <div class="panel-body">
            <div class="table-responsive">
                <form action="register" method="post">
                    <div class="form-group" style="width:320px;">
                        <label for="username">用户名</label>
                        <input type="text" class="form-control" id="username" name="username" placeholder="字母和数字组成的4-16位字符，以字母开头">
                    </div>
                    <div class="form-group" style="width:320px;">
                        <label for="password">密码</label>
                        <input type="text" class="form-control" id="password" name="password" placeholder="字母和数字组成的6-20位字符">
                    </div>
                    <div class="form-group" style="width:320px;">
                        <label for="email">邮箱</label>
                        <input type="text" class="form-control" id="email" name="email" placeholder="请输入能收到邮件的邮箱，否则无法激活">
                    </div>
                    <div class="form-group" style="width:320px;">
                        <label for="phone">手机号</label>
                        <input type="text" class="form-control" id="phone" name="phone" placeholder="手机号">
                    </div>
                    <div class="form-group" id="vaptchaFatherContainer" style="width:320px;">
                        <%--<div id="vaptchaContainer" data-config='{"vid": "5bfca3effc650e1410f00f1f","type": "embed"}' style="width: 320px;height: 36px;"></div>--%>
                        <div id="vaptchaContainer" style="width: 320px;height: 36px;"></div>
                    </div>
                    <div class="form-group" style="width:320px;">
                        <label for="code">短信验证码</label>
                        <div class="row">
                            <div class="col-sm-8" style="padding-right: 0;">
                                <input type="text" class="form-control" id="code" name="code" placeholder="短信验证码">
                            </div>
                            <div class="col-sm-4">
                                <button type="button" class="btn btn-primary pull-right" onClick="getCode()">获取验证码</button>
                            </div>
                        </div>
                    </div>
                    <div class="form-group" style="width:320px;">
                        <button type="button" class="btn btn-primary" onClick="postRegister()">注册</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.vaptcha.com/v2.js"></script>
<script type="application/javascript">
    $(document).ready(function(){
        window.vaptcha({
            vid: '5bfca3effc650e1410f00f1f', // 验证单元id
            type: 'embed', // 显示类型 点击式
            container: '#vaptchaContainer' // 按钮容器，可为Element 或者 selector
        }).then(function (vaptchaObj) {
            window.vaptchaObj = vaptchaObj;
            console.log(vaptchaObj)
            vaptchaObj.renderTokenInput('#vaptchaFatherContainer');
            vaptchaObj.render()// 调用验证实例 vpObj 的 render 方法加载验证按钮
        })
    });
    function getCode(){
        if($("input[name*='phone']")[0].value==""){
            alert("请输入手机号");
            return
        };
        if($("input[name*='vaptcha_token']")[0].value==""){
            alert("请绘制验证码");
            return
        };

        $.ajax({
            url:"captcha",
            type:"get",
            data:$('form').serializeObject(),
            contentType:"application/json",
            success:function(res){
                alert(res);
                console.log(res);
                window.vaptchaObj.reset();
            },
            error:function(res){
                alert("请求失败");
                window.vaptchaObj.reset();
            }
        })
    }
    function postRegister(){
        $.ajax({
            url:"register",
            type:"post",
            data:JSON.stringify($('form').serializeObject()),
            contentType:"application/json",
            success:function(res){
                alert(res);
                res = JSON.parse(res);
                console.log(res);
                if(res.code===200&&res.message==="success"){
                    window.location.href="registerSuccess";
                }
            },
            error:function(res){
                alert("请求失败");
            }
        })
    }
    // window.vaptcha({
    //     //配置参数省略
    // }).then(function(vaptchaObj){
    //     vaptchaObj.listen('pass', function() {
    //         // 验证成功， 进行登录操作
    //         alert("pass");
    //         console.log(vaptchaObj);
    //     })
    //     vaptchaObj.render();//执行该方法, 生成验证码
    // })
    //发送表单ajax请求
    // $(':submit').on('click',function(){
    //     $.ajax({
    //         url:"register",
    //         type:"POST",
    //         data:JSON.stringify($('form').serializeObject()),
    //         contentType:"application/json",  //缺失会出现URL编码，无法转成json对象
    //         success:function(){
    //             alert("成功");
    //         }
    //     });
    // });
    //
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