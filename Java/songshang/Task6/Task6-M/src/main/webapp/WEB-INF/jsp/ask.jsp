<%--
  Created by IntelliJ IDEA.
  User: Dong
  Date: 2018/2/5
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
<html>
<head>
    <title>注册页面</title>
    <script>
        var xmlhttp;

        // function loadXMLDoc() {
        //     var cellphone = document.getElementById("cellphone")
        //     console.log(cellphone.value)
        //     //     var url = "WEB-INF/views/regist.jsp?cellphone=" + cellphone;
        //     //     xmlhttp = new XMLHttpRequest();
        //     //     xmlhttp.onreadystatechange = checkResult;
        //     //     xmlhttp.open("GET", url, true);
        //     //     xmlhttp.send(null);
        //     // }
        //     $.ajax({
        //         methods:'GET',
        //         url:'WEB-INF/views/regist.jsp',
        //         params:{cellphone:cellphone.value},
        //         success:function (result) {
        //             console.log(result)
        //         }
        //     })
        // }
        function submit() {
//            var cellphone = document.getElementById("cellphone");
            $.ajax({
                methods: 'GET',
                url: '/as',
//              data: {cellphone: cellphone.value},
                success: function (result) {
//                    var jsonData = JSON.parse(result);
                    alert(result.id + result.name + result.type);//将后台返回结果alert一下
//                    var str = JSON.stringify(result);
                }
            })
        }


        // function checkResult() {
        //     if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
        //         document.getElementById("checkResult").innerHTML = xmlhttp.responseText;
        //         }
    </script>
</head>
<body>
用户注册
<form action="${pageContext.request.contextPath }/registered/u" method="post">
    <br>账号<input type="text" name="accoucom.spring.json.onent">
    <br>密码<input type="text" name="password">
    <br>手机<input type="text" id="cellphone" name="cellphone">
    <%--<span id="checkResult"></span>--%>
    <br>邮箱<input type="text" name="email">
    <input type="submit" name="注册">
</form>
<br>
<button onclick="submit()">发送验证码</button>
</body>
</html>
