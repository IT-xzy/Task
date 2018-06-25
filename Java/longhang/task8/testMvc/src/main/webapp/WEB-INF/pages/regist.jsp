<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/14
  Time: 0:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
<%--<script type="text/javascript" src="/js/jquery.min.js"></script>--%>
<%--<script type="text/javascript" src="/js/jquery.cookie.js"></script>--%>
<html>
<body>
<h1>添加用户</h1>
<form action="${pageContext.request.contextPath}/regist"  method="post">
    姓名：<input type="text" name="name"><br><br/>
    密码：<input type="password" name="password"/><br/><br/>
    手机号码：<input type="text" id="phone" name="phone"><br><br/>
    验证码：<input type="text" name="verification"/><br/><br/>
    <%--密码确认<input type="password" name="password1"/><br/><br/>--%>
    <p id="buttons" >
        <input  type="submit"  value="注册">
    </p>
</form>
<button id="butt" onclick="buttclick()" type="button">免费获取验证码</button>
<script >
    function buttclick(){
        var phoneNum = document.getElementById("phone");
        console.log(phoneNum)
        $.ajax({
            methods: 'GET',
            url: '/verifyPhone',
            data: {phoneNum: phoneNum.value},
            success: function (result) {
                console.log(result)
            }
        });}
</script>


    <%--<form action="${pageContext.request.contextPath}/verify"  method="post">--%>
        <%--手机号码：<input type="text" name="phone"><br>--%>
    <%--<p id="vbuttons" >--%>
        <%--<input  type="submit"  value="获取验证码">--%>
    <%--</p>--%>
<%--</form>--%>

</body>
</html>

