<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%--核心标签 支持 c:--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--json标签 支持<json:object>--%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%--page 支持EL表达式 ${name}--%>
<%@ page isELIgnored="false" %>
<%--<link rel="stylesheet" href="${pageContext.request.contextPath}/stat/css/bootstrap.min.css">--%>
<%--<script src="${pageContext.request.contextPath}/stat/css/bootstrap.min.js"></script>--%>
<script src="${pageContext.request.contextPath}/stat/css/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/stat/js/layer/layer.js"></script>
<%--<script type="text/javascript">--%>
    <%--var clock = '';--%>
    <%--var nums = 60;--%>
    <%--var btn;--%>
    <%--function sendSMS(thisBtn)--%>
    <%--{--%>
        <%--btn = thisBtn;--%>
        <%--btn.disabled = true; //将按钮置为不可点击--%>
        <%--btn.value = nums+'秒后可重新获取';--%>
        <%--clock = setInterval(doLoop, 1000); //一秒执行一次--%>

    <%--}--%>
    <%--function doLoop()--%>
    <%--{--%>
        <%--nums--;--%>
        <%--if(nums > 0){--%>
            <%--btn.value = nums+'秒后可重新获取';--%>
        <%--}else{--%>
            <%--clearInterval(clock); //清除js定时器--%>
            <%--btn.disabled = false;--%>
            <%--btn.value = '点击发送验证码';--%>
            <%--nums = 10; //重置时间--%>
        <%--}--%>
    <%--}--%>
<%--</script>--%>

<script>
//    $("#getsms").click(function(){
//        alert(1);
//        getCode();
//        var get_code=$("#getsms");
//        time(get_code);
//    })
    function sendSMS(own){
        getCode();
        var get_code=$("#getsms");

    }

    // 获取手机验证码
    function getCode(){
        var mobile = $("#phone").val();
        var get_code_url="/u/smsCode";
        $.ajax({
            type: "Get",
            /*返回类型*/
            contentType: "application/json;charset=utf-8",
            url: get_code_url,
            data: {"mobile":mobile},
            /*返回类型*/
//            dataType: "json",
            complete: function () { },
            success: function (result) {
                alert(result.message);
                if(result.status==2){
                    $("#getsmsBack").attr("value","点击发送");
                    $("#getsmsBack").removeAttr("disabled");
                }
                //console.debug(result);
                if (result.status==1){

                    time($("#getsms"));
                }

            },
            error: function (result) {
                alert(result);
            }
        });
    }
    //验证码倒计时
    var wait=60;//时间
    function time(o,p) {//o为按钮的对象，p为可选，这里是60秒过后，提示文字的改变
        if (wait == 0) {
            o.removeAttr("disabled");
            o.val("获取验证码");//改变按钮中value的值
            p.html("如果您在1分钟内没有收到验证码，请检查您填写的手机号码是否正确或重新发送");
            wait = 60;
        } else {
            o.attr("disabled", true);//倒计时过程中禁止点击按钮
            o.val("倒数" + wait + "秒");//改变按钮中value的值
            wait--;
            setTimeout(function() {
                    time(o,p);//循环调用
                },1000)
        }
    }

//    前端js验证验证码
    function verify(own){
//        alert(own.value);
        if(own.value==""){

        }else {
            var smsCode = '<%= session.getAttribute("smsCode")%>';
//            alert(smsCode);
            if(smsCode==own.value){
                $("#getsms").hide();
                own.disabled=true;
                $("#getsmsBack").css("display","inline-block");
                $("#getsmsBack").attr("value","验证成功");
                $("#isok").attr("value","true");
                $("#phone").attr("disabled","disabled");
            }else {
                alert("验证码输入错误！");
                $("#phone").removeAttr("disabled");
            }
        }
    }

//function verify(own){
////        alert(own.value);
//    if(own.value==""){
//    }else {
//        var get_code_url="/u/smsisok";
//        $.ajax({
//            type: "Get",
//            /*返回类型*/
//            contentType: "application/json;charset=utf-8",
//            url: get_code_url,
//            data: {"smsIsCode":own.value},
//            /*返回类型*/
//            dataType: "json",
//            complete: function () { },
//            success: function (result) {
//                if(result.status==2){
//                    alert("验证码输入错误！");
//                    $("#phone").removeAttr("disabled");
//                }
//                //console.debug(result);
//                if (result.status==1){
//                    $("#getsms").hide();
//                    own.disabled=true;
//                    $("#getsmsBack").css("display","inline-block");
//                    $("#getsmsBack").attr("value","验证成功");
//                    $("#isok").attr("value","true");
//                    $("#phone").attr("disabled","disabled");
//                }
//
//            },
//            error: function (result) {
//                alert(result);
//            }
//        });
//
//    }
//}

function sendMail(own){
    getMilCode();
}

// 获取邮箱验证码
function getMilCode(){
    var email = $("#email").val();
    var get_code_url="/u/emailCode";
    $.ajax({
        type: "Get",
        /*返回类型*/
        contentType: "application/json;charset=utf-8",
        url: get_code_url,
        data: {"email":email},
        /*返回类型*/
//            dataType: "json",
        complete: function () { },
        success: function (result) {
            alert("发送状态"+result.status+ "信息："+result.message);
            if(result.status==2){
                $("#getMail").attr("value","点击发送");
                $("#getMail").removeAttr("disabled");
            }
            //console.debug(result);
            if (result.status==1){
                time($("#getMail"));
            }

        },
        error: function (result) {
            alert(result);
        }
    });
}
</script>

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

                    <ul id="myTab" class="nav nav-tabs" role="tablist">
                        <li class="active"><a href="#bulletin" role="tab" data-toggle="tab">手机注册</a></li>
                        <li><a href="#rule" role="tab" data-toggle="tab">邮箱注册</a></li>
                    </ul>
                    <!-- 选项卡面板 -->
                    <div id="myTabContent" class="tab-content">
                        <div class="tab-pane fade in active" id="bulletin">

                            <form class="form-horizontal" action="/u/reg" method="POST" >
                                <fieldset>
                                    <div id="legend" class=""  style="margin-top: 10px;">
                                        <%--<legend class="">注册</legend>--%>
                                        <span style="color:red;">${message}</span>
                                    </div>

                                    <div class="control-group">
                                        <label class="control-label" for="name">用户名</label>
                                        <div class="controls">
                                            <input type="text" placeholder="必填" name="name" id="name" class="input-xlarge form-control">
                                            <%--<p class="help-block">必填，避免重名哦</p>--%>
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label" for="pwd">密码</label>
                                        <div class="controls">
                                            <input type="text" placeholder="必填" name="pwd" id="pwd" class="input-xlarge form-control">
                                            <%--<p class="help-block">请输入密码，随便</p>--%>
                                        </div>
                                    </div>
                                    <%--<div class="control-group">--%>
                                        <%--<label class="control-label" for="email">邮箱</label>--%>
                                        <%--<div class="controls">--%>
                                            <%--<input type="text" placeholder="email" name="email" id="email" class="input-xlarge form-control">--%>
                                            <%--&lt;%&ndash;<p class="help-block">你的邮箱地址</p>&ndash;%&gt;--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                    <div class="control-group">
                                        <label class="control-label" for="phone">手机</label>
                                        <div class="controls">
                                            <input type="text" placeholder="必填" name="phone" id="phone" class="input-xlarge form-control">
                                            <%--<p class="help-block">必填，请输入您的手机号</p>--%>
                                        </div>
                                    </div>

                                    <div class="control-group">
                                        <label class="control-label">验证码</label>
                                        <div class="controls">
                                            <div class="input-append">
                                                <%--onblur="verify(this);"--%>
                                                <input class="span2 form-control" placeholder="请输入收到的验证码" type="text" id="code_sms" name="code_sms"  style=" width: 50%; display: inline-block;">
                                                <%--<span class="glyphicon glyphicon-ok"></span>--%>
                                                <%--onclick="sendSMS(this);"--%>
                                                <input type="button" class="add-on btn btn-default" style="margin-top: -5px; width: 125px;" id="getsms" class="getsms" onclick="sendSMS(this);"  value="点击发送"></input>
                                                <input type="button" class="add-on btn btn-access" style="margin-top: -5px; width: 125px; display: none;" id="getsmsBack" class="getsmsBack" disabled="disabled" ></input>

                                            </div>
                                            <%--<p class="help-block">点击给你手机发个验证码</p>--%>
                                        </div>

                                    </div>

                                    <div class="control-group">
                                        <label class="control-label"></label>

                                        <!-- Button -->
                                        <div class="controls">
                                            <button class="btn btn-default" type="submit" >注册</button>
                                        </div>
                                    </div>

                                </fieldset>
                            </form>

                        </div>


                        <div class="tab-pane fade" id="rule">

                            <form class="form-horizontal" action="/u/reg" method="POST" >
                                <fieldset>
                                    <div id="" class="" style="margin-top: 10px;">
                                        <%--<legend class="">注册</legend>--%>
                                        <span>${message}</span>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label" for="name">用户名</label>
                                        <div class="controls">
                                            <input type="text" placeholder="必填" name="name" id="name2" class="input-xlarge form-control">
                                            <%--<p class="help-block">必填，避免重名哦</p>--%>
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label" for="pwd">密码</label>
                                        <div class="controls">
                                            <input type="text" placeholder="必填" name="pwd" id="pwd2" class="input-xlarge form-control">
                                            <%--<p class="help-block">请输入密码，随便</p>--%>
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label" for="email">邮箱</label>
                                        <div class="controls">
                                        <input type="text" placeholder="email" name="email" id="email" class="input-xlarge form-control">
                                        <%--<p class="help-block">你的邮箱地址</p>--%>
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label">验证码</label>
                                        <div class="controls">
                                            <div class="input-append">
                                                <%--onblur="verify(this);"--%>
                                                <input class="span2 form-control" placeholder="请输入收到的验证码" type="text" id="code_emil" name="code_emil" style=" width: 50%; display: inline-block;">
                                                <%--<span class="glyphicon glyphicon-ok"></span>--%>
                                                <%--onclick="sendSMS(this);"--%>
                                                <input type="button" class="add-on btn btn-default" style="margin-top: -5px; width: 125px;" id="getMail" class="getMail" onclick="sendMail(this);"  value="点击发送"></input>
                                                <input type="button" class="add-on btn btn-access" style="margin-top: -5px; width: 125px; display: none;" id="getMailBack" class="getMailBack" disabled="disabled" ></input>
                                                <input type="hidden" name="codeIsOk" id="isok" value="false" />
                                            </div>
                                            <%--<p class="help-block">点击给你手机发个验证码</p>--%>
                                        </div>

                                    </div>

                                    <div class="control-group">
                                        <label class="control-label"></label>

                                        <!-- Button -->
                                        <div class="controls">
                                            <button class="btn btn-default" type="submit">注册</button>
                                        </div>
                                    </div>

                                </fieldset>
                            </form>


                        </div>
                    </div>





                </div>
            </div>
        </div>
    </div>



</main>


