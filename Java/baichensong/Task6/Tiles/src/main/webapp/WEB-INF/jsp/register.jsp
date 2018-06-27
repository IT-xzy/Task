<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>报名内门</title>
    <style type="text/css">
        body{background:#ff5c00;}
        #div1{height:600px;width:800px;border:1px red solid;margin:20px auto;}
        #div1 h2 {color: white;}
        #left{height:500px;width: 350px;color:white;border: 1px blue solid;position:absolute;margin-left: 25px;}
        #right{height:500px;width: 350px;border: 1px blue solid;margin-left: 425px;}
        #left p{ margin:50px 75px;border: 1px orangered solid; text-align:center;}
        #right input { margin:50px 75px; border: 1px orangered solid;}
    </style>
</head>

<body>

<div id="div1">
    <h2 align="center">请输报名信息</h2>
    <div id="left">

        <p>真实姓名</p>
        <p>手机号码</p>
        <p>邮箱地址</p>

    </div>
    <div id="right">
        <form action="/u/dojoin" method="post" method="post">
        <input type="text" name="name"/>
        <input type="text" name="phone">
        <input type="text" name="email">
        <input type="submit" name="tijiao">
            <select style="background-color:LavenderBlush" name="profession">
                <option value="java">java</option>
                <option value="web">web</option>
                <option value="ios">ios</option>
                <option value="android">android</option>
                <option value="pm">pm</option>
                <option value="qa">qa</option>
                <option value="ui">ui</option>
                <option value="python">python</option>
                <option value="css">css</option>
                <option value="js">js</option>
            </select>
        </form>
    </div>
</div>


<form action="${pageContext.request.contextPath}/u/dojoin" method="post" align="center">
    <table align="center"  width="600">
        <tr>
            <td align="right"><font color="red">*</font><strong>真实姓名:</strong></td>
            <td align="left"><input type="text" name="name" style="background-color:LavenderBlush"></td>
            <td>请务必输入真实姓名</td>
        </tr>
        <tr>
            
            <td align="right"><font color="red">*</font><strong>修行职业:</strong></td>
            <td align="left" size="10">
                <select style="background-color:LavenderBlush" name="profession">
                    <option value="java">java</option>
                    <option value="web">web</option>
                    <option value="ios">ios</option>
                    <option value="android">android</option>
                    <option value="pm">pm</option>
                    <option value="qa">qa</option>
                    <option value="ui">ui</option>
                    <option value="python">python</option>
                    <option value="css">css</option>
                    <option value="js">js</option>
                </select>
            </td>
            <td><button type="button"><a href="${pageContext.request.contextPath}/u/profession">了解职业详情</a></button></td>
        </tr>
    </table>
    <div align="center"><input type="submit" value="确认加入" ></div>
</form>
</body>
</html>>
<%--.button1 {--%>
<%--color: rgba(255,255,255,1);--%>
<%---webkit-transition: all 0.5s;--%>
<%---moz-transition: all 0.5s;--%>
<%---o-transition: all 0.5s;--%>
<%--transition: all 0.5s;--%>
<%--position: relative;--%>
<%--border: 1px solid rgba(255,255,255,0.5);--%>
<%--}--%>
<%--.button1 a{--%>
<%--color: rgba(51,51,51,1);--%>
<%--text-decoration: none;--%>
<%--display: block;--%>
<%--}--%>
<%--.button1:hover {--%>
<%--background-color: rgba(255,255,255,0.2);--%>
<%---webkit-border-radius: 25px;--%>
<%---moz-border-radius: 25px;--%>
<%--border-radius: 25px;--%>
<%--}--%>