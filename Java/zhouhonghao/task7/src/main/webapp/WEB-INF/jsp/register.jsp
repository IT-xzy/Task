<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/24
  Time: 8:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<%@page isELIgnored="false" %>
<%@page import="java.util.Date" %>
<html>
<head>
    <title>register</title>
</head>
<body>
<main>
    <%--判断是否为文本框内容为空--%>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#sign").blur(function () {
                $.ajax({
                    url:"/check",
                    async:false,
                    contentType: "application/x-www-form-urlencoded; charset=utf-8",
                    data:{
                        "phoneOrEmail1":$("#sign").val()
                    },
                    success: function(data)
                    {
                    }
                });
            })
        })
    </script>
        <script type="text/javascript">
       window.onload=function () {
           document.getElementById("register").disabled=true;
           document.getElementById("code").onblur = function()
           {
               if(this.value=="")
               {
                   alert("验证码不能为空!")
                   return false;
               }
           }
       }
    </script>
        <script type="text/javascript">
            $(document).ready(function(){
                $("#btnSendCode").click(function () {
                    document.getElementById("code").disabled = false;
                    $.ajax({
                        url:"/send",
                        type:"post",
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
            $("#sign").blur(function(){
                var val=$("#sign").val();
                    if (val.indexOf("@") > 0) {
                        //获取email控件对象
                        var reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
                        //正则表达式
                        if (!reg.test(val)) {
                            $("#sign").val("");
                            $("#label").text("邮箱格式错误，请重新输入！");
                            document.getElementById("btnSendCode").disabled = true;
                            return false;
                        } else {
                            $("#label").text("*");
                            document.getElementById("btnSendCode").disabled = false;
                        }
                    } else {
                        var reg = /^[1][3,4,5,7,8][0-9]{9}$/;
                        //正则表达式
                        if (!reg.test(val)) {
                            $("#label").text("不是正确的手机号");
                            $("#sign").val("");
                            document.getElementById("btnSendCode").disabled = true;
                            return false;
                        } else {
                            $("#label").text("*");
                            document.getElementById("btnSendCode").disabled = false;
                        }
                    }
            });
        })
    </script>
    <%--密码格式要求--%>
    <script type="text/javascript">
        $(function () {
            $("#pwd1").blur(function () {
                if($("#pwd").value==""||this.value=="")
                {
                    document.getElementById("register").disabled=true;
                }else
                {
                    document.getElementById("register").disabled=false;
                }
                var str1=$("#pwd1").val();
                if($("pwd").val()!="") {
                    if (str1 != $("#pwd").val()) {
                        $("#label2").text("两次密码不一致！");
                        $("#pwd1").val("");
                    } else {
                        $("#label2").text("*");
                    }
                    return false;
                }else{
                    alert("密码不能为空");
                    return false;
                }
            })
            $("#pwd").blur(function () {
                var str = $("#pwd").val();
                var regUpper = /[A-Z]/;
                var regLower = /[a-z]/;
                var regStr = /[0-9]/;
                var complex = 0;
                if($("#pwd").val()!="") {
                    if (str.length < 8) {
                        $("#label1").text("必须包含大小写字母，数字,长度至少8位");
                        $("#pwd").val("");
                        return false;
                    } else {
                        $("#label1").text("*");
                        if (regLower.test(str)) {
                            ++complex;
                        } else {
                            $("#label1").text("必须包含小写字母");
                            $("#pwd").val("");
                            return false;
                        }
                        if (regUpper.test(str)) {
                            ++complex;
                        } else {
                            $("#label1").text("必须包含大写字母");
                            $("#pwd").val("");
                            return false;
                        }
                        if (regStr.test(str)) {
                            ++complex;
                        } else {
                            $("#label1").text("必须包含数字");
                            $("#pwd").val("");
                            return false;
                        }
                    }
                }
            })
        })
    </script>
    <form action="/register" method="post" >
        账号: <input  type="text" name="phone" id="sign"   value="手机号/邮箱"
    <%-- 光标选中 如果是默认字符串 不显示内容 --%>
                    onfocus="if (this.value == '手机号/邮箱') {this.value = '';}"
    <%-- 失去焦点 value为空 显示内容 --%>
                    onblur="if (this.value == '') {this.value = '手机号/邮箱';}">
        <label id="label" style="color: red" >*</label>
        <br/>
        <br/>
        密 码: <input type="password" id="pwd" name="password"><label id="label1" style="color: red" >*</label><br/><br/>
        确认密码: <input type="password" id="pwd1" name="password1"><label id="label2" style="color: red" >*</label><br/><br/>
        验证码: <input type="text" name="number" id="code" disabled>
        <input type="button" name="send" id="btnSendCode" value="点击发送验证码" onclick="sendMessage()" disabled>
        <input name="create_at"  type="hidden" value=<%=new Date().getTime()%>> <br><br>
        <input type="submit" value="注册" id="register"  disabled>
    </form>
</main>
</body>
</html>
