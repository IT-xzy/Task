<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
<html>

<head>
    <meta charset="utf-8">
    <title></title>
</head>

<body >
<form action="${pageContext.request.contextPath}/logins" method="post" >
    用户名：<input type="text" name="name"><br/><br/>
    密码：<input type="password" name="password" /><br/><br/>
    邮箱：<input type="text" id="email" name="email"><br><br/>
    验证码：<input type="text" name="verification1"/><br/><br/>
    <input type="submit"  value="登录">
</form>
<button id="butt" onclick="buttclick()" type="button">免费获取验证码</button>
<script >
    function buttclick(){
        var emailNum = document.getElementById("email");
        console.log(emailNum)
        $.ajax({
            methods: 'GET',
            url: '/verifyEmail',
            data: {emailNum: emailNum.value},
            success: function (result) {
                console.log(result)
            }
        });}
</script>
<td>
    <form action="${pageContext.request.contextPath}/toregist"  >
        <p id="editButton"><input  type="submit"  value="注册">
    </form>
</td>
</body>

</html>
