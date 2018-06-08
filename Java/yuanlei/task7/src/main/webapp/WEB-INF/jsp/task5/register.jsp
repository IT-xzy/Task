<%--
  Created by IntelliJ IDEA.
  User: LL
  Date: 2018/4/21
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>注册</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.0.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#getCode").removeAttr("disabled");

            //发送手机验证码
            $("#getCode").click(function(){
                $.ajax({
                    url:"/servlet/SendCodeServlet",
                    data:{
                        "mobile_phone":$("#mobile_phone").val()
                    },
                    type:"post",
                   //执行同步操作
                    async:false,
                    dataType:"json",
                    success : function(data){
                        if(data.result=="success"){
                            alert("验证码发送成功,收到后请输入验证码");
                            time(this);
                        }else {
                            alert("验证码发送失败");
                           }
                        },
                        error:function(){
                        alert("error");
                        }
                    });
                });
            //发送邮箱验证码
            $("#getEcode").removeAttr("disabled");
            $("#getEcode").click(function(){
                var j = document.getElementById("mailbox").value;
                console.log(j);
                $.ajax({
                    contentType:'application/x-www-form-urlencoded',
                    url:"/servlet/SendCloud",
                    data: {"email":j},
                    type:"POST",
                    //执行同步操作
                    async:false,
                    dataType:"json",
                    success : function(data){
                        if(data.result=="success"){
                            alert("邮箱验证码发送成功,收到后请输入验证码");
                            time2(this);
                        }else {
                            alert("验证码发送失败");
                        }
                    },
                    error:function(){
                        alert("error");
                    }
                });
            });


            $("#BtnOK").click(function(){
                //获取id为form1的表单对象
                var form = document.getElementById("form1");
                //通过FormData将文件对象转成二进制数据
                var fd = new FormData(form);
                $.ajax({
                    contentType:false,
                    url:"/photo",
                    data:fd,
                    type:"POST",
                    processData:false,
                    //执行同步操作
                    async:false,
                    dataType:"json",
                    success : function(data){
                        if(data.resultCode==200){
                            alert("图片上传成功");
                        }
                    },
                    error:function(){
                        alert("error");
                    }
                });
            });
            $("#ButtonUser").click(function(){
                $.ajax({
                    url:"/register",
                    data:
                        $("#User").serialize()
                    ,
                    type:"POST",
                    processData:false,
                    //执行同步操作
                    async:false,
                    dataType:"json",
                    success:function(data){
                        if (data.result==0){
                            alert("注册成功");
                            window.location.href="/home";
                        }
                        if(data.result==1) {
                            alert("手机或邮箱验证码错误");
                        }
                        if(data.result==2){
                            alert("用户名已存在,请更换用户名")
                        }
                    },


                });
            });
        });
        //验证码倒计时
        var wait = 60;
        function time(obj) {
            if(wait==0) {
                $("#getCode").removeAttr("disabled");
                $("#getCode").val("获取验证码");
                wait = 60;
            }else {
                $("#getCode").attr("disabled","true");
                $("#getCode").val(wait+"秒后重试");
                wait--;
                setTimeout(function() {     //倒计时方法
                    time(obj);
                },1000);    //间隔为1s
            }
        }
        var wait1=60;
        function time2(obj) {
            if(wait1==0) {
                $("#getEcode").removeAttr("disabled");
                $("#getEcode").val("获取验证码");
                wait1 = 60;
            }else {
                $("#getEcode").attr("disabled","true");
                $("#getEcode").val(wait1+"秒后重试");
                wait1--;
                setTimeout(function() {     //倒计时方法
                    time2(obj);
                },1000);    //间隔为1s
            }
        }

    </script>
</head>
<body>
<h3 align="center">注册界面</h3>
<%--表单标签中设置enctype="multipart/form-data"来确保匿名上载文件的正确编码。--%>
<%--是设置表单的MIME编码。默认情况，这个编码格式是application/x-www-form-urlencoded，不能用于文件上传；--%>
<%--只有使用了multipart/form-data，才能完整的传递文件数据，进行下面的操作。--%>
<form id="form1" method="post" action="" >
    <table align="center">
    <tr>
        <td >上传头像：</td>
        <td><input id="file" type="file" name="file"  ></td>
        <td><input type="button" id="BtnOK" value="确认上传"></td>
    </tr>
    </table>
</form>
<form action="" method="post" name="User" id="User">

    <table align="center">
        <tr>
        <td>账号:</td>
        <td><input type="text" name="name"></td>
        <td>${ERR_name}</td>
    </tr>
    <tr>
        <td>密码:</td>
        <td><input type="text" name="password"></td>
        <td>${ERR_password}</td>
    </tr>
    <tr>
        <td>手机号码:</td>
        <td><input type="text" name="mobile_phone"  id ="mobile_phone" ></td>
        <td><input id="getCode" type="button" value="获取验证码"></td>
        <td>${ERR_mobile_phone}</td>
    </tr>
        <tr>
            <td>验证码:</td>
            <td><input type="text" name="code" class="txtinput" id="code" placeholder="请输短信验证码"/></td>
        </tr>
        <tr>
            <td>邮箱:</td>
            <td><input type="text" name="mailbox" id="mailbox"></td>
            <td><input id="getEcode" type="button" value="获取验证码"></td>
        </tr>
        <tr>
            <td>验证码:</td>
            <td><input type="text" name="e_code" class="txtinput" id="e_code" placeholder="请输邮箱验证码"/></td>
        </tr>

    <tr>
        <td><input type="reset" value="重置"></td>
        <td><input type="button" id="ButtonUser" value="登陆"></td>
        <td><a href="/home">返回主界面</a></td>
    </tr>
</table>
</form>
</body>
</html>
