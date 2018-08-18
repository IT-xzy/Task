<%--
  Created by IntelliJ IDEA.
  User: CH0918
  Date: 2018/7/19
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<title>Registration</title>
<head></head>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <script>
        //验证输入是否符合要求
        function volidate() {
            if(document.getElementById("name").value == ""){
                window.alert("姓名不能为空")
                document.getElementById("name").focus();
                return false;
            }else if(document.getElementById("password").value == ""){
                window.alert("密码不能为空")
                document.getElementById("password").focus();
                return false;
            }
            return true;
        }
        //发送验证码
        function sendCode(obj){
            var phone = document.getElementById("phone");
            var value = phone.value.trim();
            if(value && value.length == 11){
                //alert(value)
                $.ajax({
                    cache : false,
                    url : "${pageContext.request.contextPath}/registration/code",
                    data : {"phone" : value}
                });
                // 1分钟内禁止点击
                for (var i = 1; i <= 60; i++) {
                    // 1秒后显示
                    window.setTimeout("updateTime(" + (60 - i) + ")", i * 1000);
                }
            }else{
                alert("请输入正确的手机号码");
                phone.focus();

            }
        }
        function updateTime(i){
            // setTimeout传多个参数到function有点麻烦，只能重新获取对象
            var obj = document.getElementById("validationCode");
            if(i > 0){
                obj.innerHTML  = "距离下次获取还有" + i + "秒";
                obj.disabled = true;
            }else{
                obj.innerHTML = "获取验证码";
                obj.disabled = false;
            }
        }
        function checkTime(){
            var sendCodeTime = <%=(Long)session.getAttribute("sendTime")%>;
            if(sendCodeTime){
                var nowTime = new Date().getTime();
                var flag = Math.floor((nowTime - sendCodeTime)/1000);
                if(flag < 60){
                    var end = 60 - flag;
                    // 进页面马上开始，选i为0
                    for (var i = 0; i <= end; i++) {
                        window.setTimeout("updateTime(" + (end - i) + ")", i * 1000);
                    }
                }
            }
        }

        function doValidation(){
            if(validateFormValidateor.form()){
                $("#validateForm").ajaxSubmit({
                    success:function(data){
                        if(data == "success") {
                            alert("验证成功");
                        }else{
                            alert("验证失败");
                        }
                    }
                });
            }
        }
        $().ready(function(){
            validateFormValidateor = $("#validateForm").validate({
                rules:{
                    phone:{
                        required:true,
                        number:true,
                        minlength:11
                    },
                    code:"required"
                },
                messages:{
                    phone:{
                        required: "请输入手机号码",
                        number: "只能输入数字",
                        minlength: "手机号码为11位"
                    }
                }
            });
        });
    </script>

<body>
    <form id="validateForm" method="post" action="${pageContext.request.contextPath}/registration" onsubmit="return volidate()" >
        姓名：<input type="text" id="name" name="name" placeholder="姓名"
                  style="width:190px;height: 26px;margin-left: 39px;"><br>
        密码：<input type="password" id="password" name="password" placeholder="密码"
                  style="width:190px;height: 26px;margin-left: 39px;"><br>
        邮箱：<input type="password" id="mail" name="mail" placeholder="邮箱"
                  style="width:190px;height: 26px;margin-left: 39px;"><br>
        手机号码: <input type="text" id="phone" name="phone" placeholder="请输入手机号码"
                    style="width:190px;height: 26px;margin-left: 39px;">
        <button id="validationCode" type="button" onclick="sendCode(this);" title="获取验证码">获取验证码</button><br>
        验证码: <input type="text" id="inputCode" name="inputCode" placeholder="请输入验证码"
                     style="width:190px;height: 26px;margin-left: 39px;"><br>
        <input type="submit" value="注册">
    </form>
</body>

</html>

