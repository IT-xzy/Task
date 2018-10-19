<%--
  Created by IntelliJ IDEA.
  User: John
  Date: 2018/7/12
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>

<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript">
    function sendCaptcha() {
        var telephone =document.getElementById('telephone').value;
        // var code = document.getElementById('code');
        // code.disabled = 'disabled';
        // setTimeout(function () {
        //     code.disabled = '';
        // },500000)
        console.log("sendCaptcha: telephone = " + telephone);
        $.ajax({
            // url: '/user/code',""
            url: '/user/code/phone',
            type: 'post',
            data: {
                'telephone':telephone,
            },
            dataType: 'text',
            success: function (data) {
                console.log("sendCaptcha ==> success: data = " + (data));
                alert(data);
                // if (data) {
                //     countdown();
                //     b_code = false;
                // } else {
                //     alert("您发送的频率过快!");
                // }
            },
            error: function (data) {
                console.log("sendCaptcha ==> error: data = " + (data));
                // alert("验证码超时");
                // clearTimeout(t);
                // b_code = true;
                // var msg = "获取验证码";
                // $("#code").text(msg);
                // c = 60*5;
            }
        });

    }

    function sendEmail() {
        var email =document.getElementById('email').value;
        console.log("sendEmail: email = " + email);
        $.ajax({
            // url: '/user/code',""
            url: '/user/code/email',
            type: 'post',
            data: {
                'email':email,
            },
            dataType: 'text',
            success: function (data) {
                console.log("sendEmail ==> success: data = " + data);
                alert(data)
                // if (data) {
                //     countdown();
                //     b_code = false;
                // } else {
                //     alert("您发送的频率过快!");
                // }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                // 状态码
                console.log(XMLHttpRequest.status);
                // 状态
                console.log(XMLHttpRequest.readyState);
                // 错误信息
                console.log(textStatus);
                console.log(errorThrown);
            }
            // error: function (data) {
            //     console.log("sendEmail ==> error: data = " + eval(data));
            //     // alert("验证码超时");
            //     // clearTimeout(t);
            //     // b_code = true;
            //     // var msg = "获取验证码";
            //     // $("#code").text(msg);
            //     // c = 60*5;
            // }
        });
    }

    function isphone()
    {
        var telephone =document.getElementById('telephone').value;
        console.log("手机号码 = "+telephone)
        var partten = /^1[3,5,8]\d{9}$/;
        var fl=false;
        if(partten.test(telephone))
        {
            // alert('是手机号码');
            return true;
        }
        else
        {
            alert('请使用手机号码');
            return false;
        }
    }

    function isemail()
    {
        var email =document.getElementById('email').value;
        console.log("邮箱 = "+email)
        var partten = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/;
        var fl=false;
        if(partten.test(email))
        {
            // alert('邮箱');
            return true;
        }
        else
        {
            alert('邮箱格式不对');
            return false;
        }
    }

    // JS实现选项卡切换
    window.onload = function(){
        var myTab = document.getElementById("tab");    //整个div
        var myUl = myTab.getElementsByTagName("ul")[0];//一个节点
        var myLi = myUl.getElementsByTagName("li");    //数组
        var myDiv = myTab.getElementsByTagName("div"); //数组

        for(var i = 0; i<myLi.length;i++){
            myLi[i].index = i;
            myLi[i].onclick = function(){
                for(var j = 0; j < myLi.length; j++){
                    myLi[j].className="off";
                    myDiv[j].className = "hide";
                }
                this.className = "on";
                myDiv[this.index].className = "show";
            }
        }
    }
</script>
<style>

    /* CSS样式制作 */
    *{padding:0px; margin:0px;}
    a{ text-decoration:none; color:black;}
    a:hover{text-decoration:none; color:#336699;}
    #tab{width:270px; padding:5px;height:300px;margin:20px;}
    #tab ul{list-style:none; display:block;height:30px;line-height:30px;
        border-bottom:2px #C88 solid;}
    #tab ul li{background:#FFF;cursor:pointer;float:left;
        list-style:none; height:29px; line-height:29px;padding:0px 10px;
        margin:0px 10px; border:1px solid #BBB; border-bottom:2px solid #C88;}
    #tab ul li.on{border-top:2px solid gray; border-bottom:2px solid #FFF;}
    #tab div{height:150px;width:250px; line-height:24px;border-top:none;
        padding:1px; border:1px solid #336699;padding:10px;}
    .hide{display:none;}
</style>

<div>
    <%
        if(request.getAttribute("msg")!=null){
            out.println(request.getAttribute("msg"));
        }
    %>
</div>
<div id = "tab">
    <ul>
        <li class="off">手机登录</li>
        <li class="on">邮箱登录</li>
    </ul>
    <div id="firstPage" class="hide">
        <form method="post" action="/user/phone">
            <label>用户名：</label>
            <input type="text" name="userName" value=""><br>
            <label>密&nbsp;&nbsp;&nbsp;码：</label>
            <input type="password" name="password" value=""><br>
            <label>手&nbsp;&nbsp;&nbsp;机：</label>
            <input type="text" name="telephone" value="" onchange="isphone()" id="telephone">
            <button type="button" onclick="sendCaptcha()" id="code">获取验证码</button><br>
            <input type="text" name="code" placeholder="验证码" required="required"><br>
            <button type="submit">登录</button>
        </form>
    </div>
    <div id="secondPage" class="show">
        <form method="post" action="/user/email">
            <label>用户名：</label>
            <input type="text" name="userName" value=""><br>
            <label>密&nbsp;&nbsp;&nbsp;码：</label>
            <input type="password" name="password" value=""><br>
            <label>邮&nbsp;&nbsp;&nbsp;箱：</label>
            <input type="text" name="email" value="" onchange="isemail()" id="email">
            <button type="button" onclick="sendEmail()">获取验证码</button><br>
            <input type="text" name="code" placeholder="验证码" required="required"><br>
            <button type="submit">登录</button>
        </form>
    </div>
</div>
