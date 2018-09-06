<%--<jsp:useBean id="BackendNotification" scope="request" type="java.lang.String"/>--%>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/2
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page import="java.sql.*" language="java" contentType="text/html;charset=utf-8"--%>
<%--pageEncoding="utf-8"%>--%>


}
<%@page import="java.net.URLDecoder" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%--<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>注册页面</title>
    <%--<script src="http://code.jquery.com/jquery-1.4.1.min.js"></script>--%>
    <%--<script src="http://code.jquery.com/jquery-1.4.1.js"></script>--%>
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <%--<script src="//captcha.luosimao.com/static/js/api.js"></script>--%>
    <script type="text/javascript" language="javascript">

        //首先要通过前台jquery ajax请求后台，并把这个参数传递到后台
        function sendSMS() {

            var phone_number = document.getElementById("phone_number").value;
            var email = document.getElementById("email").value;
            var name = document.getElementById("name").value;
            var password = document.getElementById("password").value;

            if (phone_number == '') {
                alert(" 请输入正确的电话号码！");
                return;
            }
            if (email == '') {
                alert(" 请输入正确的邮箱地址！");
                return;
            }
            if (name == '') {
                alert(" 请输入正确的用户名！");
                return;
            }
            if (password == '') {
                alert(" 请输入密码！");
                return;
            }

            $.ajax({
                url: "/register/verifyBySMS", //与此页面沟通
                type: "POST", //以post方式与后台沟通
                data: {
                    phone_number: phone_number,
                    email: email,
                    name: name
                }, //发给的数据
                // dataType:'JSON',//返回的值以 JSON方式 解释
                /*async: true,
                cache: true,*/
                success: function (data) {//如果调用成功

                    alert(data);
                },
                error: function (data) {
                    // //请求失败后执行的动作
                    alert(data);
                }
            })
        }

        function sendEmail() {
            var phone_number = document.getElementById("phone_number").value;
            var email = document.getElementById("email").value;
            var name = document.getElementById("name").value;
            var password = document.getElementById("password").value;

            if (phone_number == '') {
                alert(" 请输入正确的电话号码！");
                return;
            }
            if (email == '') {
                alert(" 请输入正确的邮箱地址！");
                return;
            }
            if (name == '') {
                alert(" 请输入正确的用户名！");
                return;
            }
            if (password == '') {
                alert(" 请输入密码！");
                return;
            }


            $.ajax({
                url: '/register/verifyByEmail', //与此页面沟通
                type: 'POST', //以post方式与后台沟通
                data: {
                    phone_number: phone_number,
                    email: email,
                    name: name
                }, //发给的数据
                // dataType:'json',//返回的值以 JSON方式 解释
                // async: false,
                // cache: false,

                success: function (data) {//如果调用成功
                    // console.log(res);
                    // alert(JSON.stringify (date));
                    // alert(JSON.stringify (res.responseText));
                    // alert(res);
                    // alert(obj[0].title); alert(obj[1].title);
                    // console.log(data);
                    // var jsonData = JSON.parse(data);
                    // alert(jsonData);
                    // myObj = JSON.parse(this.responseText);
                    // document.getElementById("demo").innerHTML = myObj.name;
                    alert(data);

                },
                error: function (data) {
                    //请求失败后执行的动作
                    //     alert(JSON.stringify(res.responseText));
                    // alert(res);
                    // alert(obj[0].title); alert(obj[1].title);
                    // console.log();
                    alert(data);
                }
            })
        }

        /*js代码：页面首次加载时，显示规定时间段的数据*/
        var data1 = [];
        var deviceName = $("body").attr("id");
        var startDate = $("#startDate").val("2000-01-01 00:00:00");
        var endDate = $("#endDate").val("2018-01-01 00:00:00");
        $.ajax({
            url: "/avvii/chart/getHistorySingleData",
            type: "post",
            data: {
                "deviceName": deviceName,
                "startDate": "2000-01-01 00:00:00",
                "endDate": "2018-01-01 00:00:00"
            },
            success: function (data) {
                alert(data);//---->弹出[object Object],[object Object],
                // [object Object][object Object],[object Object],[object Object]
                // ……后台传过来几条singleHistoryData对象就打印几个json对象：[object Object]
                for (var i = 0; i < data.length; i++) {
                    var name = data[i]['time'];
                    var state = data[i]['state'];
                    var ball = data[i]['ball'];
                    var xd = data[i]['xd'];
                    var yd = data[i]['yd'];
                    var zd = data[i]['zd'];
                    var xf = data[i]['xf'];
                    var yf = data[i]['yf'];
                    var zf = data[i]['zf'];
                    data1[i] = {name: name, state: state, ball: ball,
                        xd: xd, yd: yd, zd: zd, xf: xf, yf: yf, zf: zf};
                }
                if (data.length != 10) {
                    for (var j = 0; j < (10 - ((data.length) % 10)); j++) {
                        //补全最后一页的空白行，使表格的长度保持不变
                        data1[j + data.length] = {
                            name: " ",
                            state: "",
                            ball: "",
                            xd: "",
                            yd: "",
                            zd: "",
                            xf: "",
                            yf: "",
                            zf: ""
                        };
                    }
                }
                var userOptions = {
                    "id": "kingTable",
                    //必须 表格id
                    "head": ["时间", "运行状态", "球头状态", "X向位置/mm",
                        "Y向位置/mm", "Z向位置/mm", "X向承载力/Kg",
                        "Y向承载力/Kg", "Z向承载力/Kg"],  //必须 thead表头
                    "body": data1,
                    //必须 tbody 后台返回的数据展示
                    "foot": true,
                    // true/false  是否显示tfoot --- 默认false
                    "displayNum": 10,
                    //必须   默认 10  每页显示行数
                    "groupDataNum": 6,
                    //可选    默认 10  组数
                    sort: false,
                    // 点击表头是否排序 true/false  --- 默认false
                    search: false,
                    // 默认为false 没有搜索
                    lang: {
                        gopageButtonSearchText: "搜索"
                    }
                }
                var cs = new KingTable(null, userOptions);
            }
        });


    </script>
</head>

<center>
    <body>

    <div id="content">

        <h1 style="color:#9531ff">注册</h1>
        <%--<form id="indexform" name="indexForm" action="logincheck.jsp" method="post">--%>
        <%--<form id="login" name="login" action="tologin" method="post">--%>
        <form id="register1" name="register1" action="toregister" method="post">
            <table border="0">
                <tr>
                    <td>邮箱：</td>
                    <td>
                        <input type="text" id="email" name="email" value=""></td>
                </tr>

                <tr>
                    <td>手机：</td>
                    <td>
                        <input type="text" id="phone_number" name="phone_number"></td>
                </tr>
                <tr>
                    <td>账号：</td>
                    <td>
                        <input type="text" id="name" name="name"></td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td>
                        <input type="password" id="password" name="password">
                    </td>
                </tr>
                <tr>
                    <td> 验证码:</td>
                    <td><input type="text" name="reKey"/></td>
                </tr>

                <tr>
                    <td>提示：${BackendNotification}</td>

                </tr>

                <%--<div class="l-captcha" data-site-key="aab758dfe65d67a418589e950ea07b05"></div>--%>
            </table>

            <br>
            <%--<input type="submit" value="登录" style="color:#439bbc">--%>
            <input type="submit" value="注册" style="color:#67bc49">
            <input type="button" value="获取短信验证码" style="color:#67bc49" onclick="sendSMS()">
            <input type="button" value="获取邮箱验证码" style="color:#67bc49" onclick="sendEmail()">

        </form>
        <c:if test="${BackendNotification!=null}">
            <font color="red">${BackendNotification}</font>
        </c:if>

    </div>
    </body>

</center>

