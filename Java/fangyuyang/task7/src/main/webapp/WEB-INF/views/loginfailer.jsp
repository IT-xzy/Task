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
    <p> 登陆失败！用户或者密码错误</p>
    <p> </p>
    <form action="${pageContext.request.contextPath}" >
        <input type="submit" value="返回首页">
    </form>
</h3>
</body>
