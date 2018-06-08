<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>邮箱验证</title>

</head>
<body>
<h1 align="center">邮箱验证</h1>
<br>
<br>



    <table align="center" border="1" width="40%">
        <tr>
            <th align="center" colspan="2">修真院学员邮箱验证</th>
        </tr>
        <tr>
            <td>用户名</td>
            <td><input id="userName" name="userName" value="" type="text" placeholder="请输入用户名"></td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td><input id="email" name="email" value="" type="text" placeholder="请输入邮箱"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <button type="button" id="token">邮箱验证</button>
            </td>
        </tr>
    </table>
<br><br><br><br>
<div align="center">
    <a href="${pageContext.request.contextPath}/home">返回主页</a>
</div>

<script src="/js/jquery.min.js"></script>
<script>
    $(document).ready(function(){
        document.getElementById('token').addEventListener('click',function(){
            var email = $("#email").val();
            var userName = $("#userName").val();
            console.log(111);
            $.post("aliEmail",
                {
                    userName:userName,
                    email:email
                },
                function(status, data){

                });
        });
    });
</script>
</body>
</html>

