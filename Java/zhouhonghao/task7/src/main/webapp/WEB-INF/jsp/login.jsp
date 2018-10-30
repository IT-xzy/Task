<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/24
  Time: 8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<%@page isELIgnored="false" %>
<html>
<head>
    <title></title>
</head>
<body>

<mian>
    <script type="text/javascript">
        function checkLoginForm() {
            if ($("#phone").val() == "" || $("#pwd").val() == "") {
                alert("用户名或密码不能为空");
                return false;
            }
            <c:if test="${cookie['num'].value ge 3}">
            var cw=document.getElementById("code");
            if(cw.value==""){
                alert("验证码不能为空");
                return false;
            }
            </c:if>
        }
    </script>
    <%--ajax局部刷新和倒计时显示。--%>
    <script type="text/javascript">
    $(document).ready(function(){
        $("#btnSendCode").click(function () {
            $.ajax({
                url:"/send",
                async:false,
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                data:{
                    "phoneOrEmail":$("#sign").val()
                },
                success: function(data)
                {
                }
            });
        })
    })
        var InterValObj; //timer变量，控制时间
        var count = 60; //间隔函数，1秒执行
        var curCount;//当前剩余秒数

        function sendMessage() {
            $("#code").removeAttr("readonly");
            curCount = count;
            //设置button效果，开始计时
            $("#btnSendCode").attr("disabled", "true");
            $("#btnSendCode").val(curCount + "秒后可重新发送");
            InterValObj = window.setInterval(SetRemainTime, 1000); //启动计时器，1秒执行一次
            //请求后台发送验证码 TODO
        }

        //timer处理函数
        function SetRemainTime() {
            if (curCount == 0) {
                window.clearInterval(InterValObj);//停止计时器
                $("#btnSendCode").removeAttr("disabled");//启用按钮
                $("#btnSendCode").val("重新发送验证码");
            }
            else {
                curCount--;
                $("#btnSendCode").val(curCount + "秒后可重新发送");
            }
        }
    </script>
    <%--判断输入的是phone还是email--%>
    <script type="text/javascript">
        $(function () {
            $("#pwd").focus(function () {
                if($("#sign").val().length!=0){
                    document.getElementById("btnSendCode").disabled = false;
                }
            })
            $("#sign").blur(function(){
                var val=$("#sign").val();
                    if (val.indexOf("@") > 0) {
                        //获取email控件对象
                        var reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
                        //正则表达式
                        if (!reg.test(val)) {
                            $("#sign").val("");
                            $("#label").text("邮箱格式错误，请重新输入！");
                            document.getElementById("label").style.display = "block";
                            document.getElementById("btnSendCode").disabled = true;
                            return false;
                        } else {
                            document.getElementById("label").style.display = "none";
                            document.getElementById("btnSendCode").disabled = false;
                        }
                    } else {
                        var reg = /^[1][3,4,5,7,8][0-9]{9}$/;
                        //正则表达式
                        if (!reg.test(val)) {
                            $("#sign").val("");
                            $("#label").text("不是正确的11位手机号");
                            document.getElementById("label").style.display = "block";
                            document.getElementById("btnSendCode").disabled = true;
                            return false;
                        } else {
                            document.getElementById("label").style.display = "none";
                            document.getElementById("btnSendCode").disabled = false;
                        }
                    }
            });
        })
    </script>

    <%--页面显示--%>
    <form action="/login" method="post" onsubmit="checkLoginForm()">
<c:if test="${sessionScope.email ne null}">
    账号: <input  type="text" name="phone" id="sign" value="${sessionScope.email}">
    <label id="label" style="color: red; display: none" >*</label>
</c:if>
        <c:if test="${sessionScope.email eq null}">
       账号: <input  type="text" name="phone" id="sign"   value="手机号/邮箱"
        <%-- 光标选中 如果是默认字符串 不显示内容 --%>
               onfocus="if (this.value == '手机号/邮箱') {this.value = '';}"
        <%-- 失去焦点 value为空 显示内容 --%>
               onblur="if (this.value == '') {this.value = '手机号/邮箱';}">
            <label id="label" style="color: red;display: none" >*</label>
        </c:if>
        <br/>
        <br/>
       密 码: <input type="password" id="pwd" name="password"><br/><br/>
        <c:if test="${cookie['num'].value ge '3'}">
            <div >
                验证码: <input type="text" name="number" id="code" readonly>
                <input type="button" name="send" id="btnSendCode"  value="点击发送验证码" onclick="sendMessage()" disabled>
            </div>
            <br/><br/>
        </c:if>
        <input  type="submit" value="登录"><br/>
        <p><a href="#">忘记密码 ?</a></p>
    </form>
</mian>
</body>
</html>
