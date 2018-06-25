<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
</head>
<body>
<h1>添加课程</h1>
<form action="${pageContext.request.contextPath}/jnshu"  method="post">
    图片：<input type="text" name="picture"><br>
    课程名：<input type="text" name="name"><br>
    介绍：<input type="text" name="introduce"><br>
    门槛：<input type="text" name="threshold"><br>
    难度：<input type="text" name="difficulty"><br>
    周期：<input type="text" name="cycle"><br>
    需求：<input type="text" name="demand"><br>
    工资1：<input type="text" name="wages1"><br>
    工资2：<input type="text" name="wages2"><br>
    工资3：<input type="text" name="wages3"><br>
    提示：<input type="text" name="prompt"><br>
    在学人数：<input type="text" name="onnum"><br>
    <p id="buttons">
        <input  type="submit"  value="添加">
    </p>
</form>

</body>
</html>