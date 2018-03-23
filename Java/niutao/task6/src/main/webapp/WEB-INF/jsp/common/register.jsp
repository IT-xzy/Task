<%--
  Created by IntelliJ IDEA.
  User: Blue
  Date: 2018/1/21
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <form action="/register" method="post">
        <table>
            <tr><td>手机号</td><td>测试阶段，验证码找13538039322要</td></tr>
            <tr><td>验证码</td><td><input id="code" type="text" name="phoneNum" onkeyup="check1()"/></td><td><button id="getcode" type="button" onclick="check2()">获取验证码</button></td><td><span id="codeResult"></span></td></tr>
            <tr><td>用户名</td><td><input id="name" type="text" name="userName" onkeyup="check()"/></td><td><span id="checkResult"></span></td></tr>
            <tr><td>密码</td><td><input type="password" name="passWord"></td></tr>
            <tr><td colspan="2"><input  type="submit" value="注册" ></td></tr>
        </table>
    </form>
</body>
<script>
    var xmlhttp;
    var url = null;
    function check(){
        var name = document.getElementById("name").value;
        url = "/existsname?name="+name;
        xmlhttp =new XMLHttpRequest();
        xmlhttp.onreadystatechange=checkResult; //响应函数
        xmlhttp.open("GET",url,true);   //设置访问的页面
        xmlhttp.send(null);  //执行访问
    }
    function checkResult(){
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
            document.getElementById('checkResult').innerHTML=xmlhttp.responseText;
    }


    //验证码后台验证
    function check1(){
        var code = document.getElementById("code").value;
        url ="/verifycode?facecode="+code;
        xmlhttp =new XMLHttpRequest();
        xmlhttp.onreadystatechange=checkResult1; //响应函数
        xmlhttp.open("GET",url,true);   //设置访问的页面
        xmlhttp.send(null);  //执行访问
    }
    function checkResult1() {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
            document.getElementById("codeResult").innerHTML = xmlhttp.responseText;
    }

    //获取验证码
    function check2(){
        url ="/getcode"
        xmlhttp =new XMLHttpRequest();
        //xmlhttp.onreadystatechange=checkResult1; //响应函数
        xmlhttp.open("GET",url,true);   //设置访问的页面
        xmlhttp.send(null);  //执行访问
    }


</script>
</html>
