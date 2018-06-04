﻿
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登陆界面</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link rel="stylesheet" type="text/css" href="/css/jquery.ui.all.css">
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery.cookie.js"></script>
    <script type="text/javascript">
        var count = 60;//声明全局变量
        $(function(){
            var starttime = $.cookie("registertime");//取上次点击按钮发送验证码的时间
            if(starttime){//判断是否在该浏览器点击过该按钮
                var curtime = new Date().format("yyyyMMddhhmmss");//得到当前时间
                var timegaps = timecha(curtime,starttime);//得到上次点击按钮和这次加载页面的时间差（秒）
                if(timegaps<60){
                    count=60-timegaps;//改变count初始值
                    buttclick();//调用按钮点击事件函数
                }
            }
        });

        //按钮点击事件
        function buttclick(){
            var phoneNum = document.getElementById("phone");
            console.log(phoneNum)
            if(count == 60){//只有计数等于60时才会调用ajax
                $.ajax({
                    url:'/verifyPhoneCode',
                    type:'GET',//get
                    async:true,//false是否异步
                    data:{phoneNum: phoneNum.value},//json格式对象
                    timeout:5000,//设置超时时间
                    dataType:'json',//返回的数据格式类型json/xml/html/script/jsonp/text
                    beforeSend:function(xhr){
                        console.log(xhr)
                        console.log('发送前')
                    },
                    success:function(data,textStatus,jqXHR){
                        $.cookie("registertime",new Date().format("yyyyMMddhhmmss"));//把请求成功的时间设置为上次请求的时间
                        console.log(textStatus);//在前端控制台打印请求的状态
                        console.log(data);//在控制台打印当前的数据
                    },
                    error:function(xhr,textStatus){
                        console.log(textStatus);//在前端控制台打印请求的状态
                    },
                    complete:function(){
                        console.log('结束')
                    }
                });
            }

            var obj=$("#butt");//设置按钮上面的字
            if(count==0){
                obj.attr("disabled",false);
                obj.html("免费获取验证码");
                count=60;
                return;
            }else{
                obj.attr("disabled", true);
                obj.html("重新发送(" + count +"s"+ ")");
                count--;
            }

            setTimeout(function(){buttclick()},1000)//仔细一看 这还是js版递归，每一秒钟调用自己一次
        }

        //计算出时间差的秒数
        function timecha(objO,objT){
            var str1=objO.substr(0,10);
            var str2=objT.substr(0,10);
            if(str1!=str2){
                return 70;
            }else{
                var str3=objO.substr(10,2);
                var str4=objT.substr(10,2);
                var str5=objO.substr(12,2);
                var str6=objT.substr(12,2);
                var str7=parseInt(str3)*60+parseInt(str5);
                var str8=parseInt(str4)*60+parseInt(str6);
                return str7-str8;
            }
        }
        //提供一个得到当前系统时间的字符串
        Date.prototype.format = function (fmt) { //author: meizz
            var o = {
                "M+": this.getMonth() + 1, //月份
                "d+": this.getDate(), //日
                "h+": this.getHours(), //小时
                "m+": this.getMinutes(), //分
                "s+": this.getSeconds(), //秒
                "q+": Math.floor((this.getMonth() + 3) / 3), //季度
                "S": this.getMilliseconds() //毫秒
            };
            if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
            for (var k in o)
                if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" +                o[k]).length)));
            return fmt;
        }

    </script>




    <%--<script >--%>
        <%--var phoneNum = document.getElementById("phone");--%>
        <%--console.log(phoneNum)--%>
        <%--$.ajax({--%>
            <%--methods: 'GET',--%>
            <%--url: '/verifyPhoneCode',--%>
            <%--data: {phoneNum: phoneNum.value},--%>
            <%--success: function (result) {--%>
                <%--console.log(result)--%>
            <%--}--%>
        <%--});--%>
    <%--</script>--%>
</head>


<body class="login">

<div class="login_m">
    <div class="login_logo"><h1>手机验证界面</h1></div>
${返回通知}
    <div class="login_boder">
        <div class="login_padding">
            <form action="/register/phone" method="post">
                <h1>用户名：</h1>  <input type="text" name="account" class="txt_input txt_input2"/><br>
                <h1> 密 码：</h1> <input type="password" name="password" class="txt_input txt_input2"/><br>
                <h1>手机号：</h1>  <input id="phone" type="text" name="phone" class="txt_input txt_input2"/><br>
                <h1>短信验证码：</h1>  <input type="text" name="code" class="txt_input txt_input2"/><br>
                <div class="rem_sub">
                    <input type="submit"  class="sub_button"  value="注册"  />
                </div>
            </form>

            <%--<button onclick="sendSms()" value="发送手机验证码" >发送手机验证码</button>--%>
            <button id="butt" onclick="buttclick()" type="button">免费获取验证码</button>

            <br>
        </div>
        <!--login_padding  Sign up end-->
    </div><!--login_boder end-->
</div><!--login_m end-->
<br> <br>


