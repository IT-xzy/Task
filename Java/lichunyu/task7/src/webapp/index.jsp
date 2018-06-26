<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>


<html>
<head>
    <style type="text/css">
        body{
            margin:0;
            background:#cccccc url(/images/email.png) no-repeat fixed center;
            font-family: 'PT Sans', Helvetica, Arial, sans-serif;
            background-size: 100%;
            text-align: center;
            color: #f0ffff;
        }
        /*登录按钮*/
        button{
            width: 200px;
            height: 50px;
            margin-top: 100px;
            margin-bottom: 25px;
            background: #1E90FF;
            border-radius: 10px;
            border:none;
            font-size: 20px;
            font-weight: 700;
            color: #fff;
        }
        button:hover {
            background: #79A84B;
            outline: 0;
        }

    </style>
</head>
<body style="text-align:center">
<form action="/home" >
    <div>
        <button onclick="">跳转到主页</button>
    </div>
</form>

</body>
</html>
