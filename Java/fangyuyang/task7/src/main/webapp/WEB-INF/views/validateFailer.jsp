<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<body>
<style type="text/css">
    a {
        text-decoration: none;
        color: #fff;
        font-size: 14px;
    }
    h3 {
        width: 300px;
        height: 100px;
        margin: 100px auto;
        text-align: center;
        line-height: 38px;
        background: #14ded8;
        border-radius: 4px;
    }
</style>


<h3>
    <p> 验证码输入错误</p>
    <p> </p>
    <form action="${pageContext.request.contextPath}/signFailer" >
        <input type="submit" value="返回注册页面">
    </form>
</h3>
</body>