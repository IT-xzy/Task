
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<title>首页</title>
<style type="text/css">
    a {
        text-decoration: none;
        color: #fff;
        font-size: 14px;
    }
    h3 {
        width: 180px;
        height: 100px;
        margin: 100px auto;
        text-align: center;
        line-height: 38px;
        background: #76de34;
        border-radius: 4px;
    }
</style>
</head>
<body>
<h3>
    <p> 登陆成功</p>
    <p> </p>
    <form action="${pageContext.request.contextPath}" >
        <input type="submit" value="返回首页">
    </form>
</h3>
</body>
</html>