<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <script>

        function loadXMLDoc(){
            var xmlhttp;
            if (window.XMLHttpRequest)
            {
                // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
                xmlhttp=new XMLHttpRequest();
            }
            else
            {
                // IE6, IE5 浏览器执行代码
                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlhttp.onreadystatechange=function()
            {
                if (xmlhttp.readyState==4 && xmlhttp.status==200)
                {
                    document.getElementById("myDiv").innerHTML=xmlhttp.responseText;
                }
            }
            xmlhttp.open("GET","../other/ten.html",true);
            xmlhttp.send();
        }

        function email() {
            var email = 1;
            $.ajax({
                type: "post",
                url: '${pageContext.request.contextPath}/h',
                data: "addr=" + email,
                success: function (data) {
                    if (data == 1) {
                        alert("邮箱验证码发送成功");
                    } else if (data == 0) {
                        alert("邮箱验证码发送失败");
                    }
                }

            });
        }

        function sms() {
            var telNum = $('#telNum').val();
            $.ajax({
                type: "post",
                url: '${pageContext.request.contextPath}/code',
                data: "addr=" + telNum,
                success: function (data) {
                    if (data == 1) {
                        alert("短信验证码发送成功");
                    } else if (data == 0) {
                        alert("短信验证码发送失败");
                    }
                }
            });
        }

    </script>
</head>
<body>

<h2>AJAX</h2>
<button type="button" onclick="loadXMLDoc()">请求数据</button>
<div id="myDiv"></div>

<button type="button" onclick="email()">发送邮箱验证码</button>

</body>
</html>