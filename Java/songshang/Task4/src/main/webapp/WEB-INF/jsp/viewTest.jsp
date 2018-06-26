<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>测试Long转化为指定类型的时间</title>
</head>
<body>

    <h1 align="center">标签转化测试</h1>
    <br><br><br><br><br><br><br>


    <form style="align-content: center" method="post" action="testTag">
        请输入一个Long类型的值：<br>
        <input value="" type="text" name="value" placeholder="没参数校验，别瞎输！！"><br>
        请输入你想要到类型。目前仅仅支持"yyyy-MM-dd HH:mm:ss"、"yyyy-MM-dd EE"、"yyyy-MM-dd"和"yy-MM-dd HH:mm:ss"！<br>
        <input value="" type="text" name="pattern" placeholder="只支持上述四种类型，别瞎输！！"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
