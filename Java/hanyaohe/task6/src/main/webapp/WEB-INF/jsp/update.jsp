<%--
  Created by IntelliJ IDEA.
  User: x1c
  Date: 2018/7/5
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
<html>
<head>
    <title>修改页面</title>
    <script>
        var xmlhttp;


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



    </script>
</head>
<body>
用户修改
<form action="${pageContext.request.contextPath }/student/${student.id}" method="post">
    <input type="hidden" name="_method" value="PUT"/>
    <br>姓名<input type="text" name="name" value="${student.name}"/>
    <br>QQ<input type="text" name="qq" value="${student.qq}"/>
    <br>类型<input type="text" name="type" value="${student.type}"/>
    <br>入学时间<input type="text" name="enrolmentTime" value="${student.enrolmenttime}"/>
    <br>毕业于<input type="text" name="graduated" value="${student.graduated}"/>
    <br>数字<input type="text" name="number" value="${student.number}"/>
    <br>日报<input type="text" name="daily" value="${student.daily}"/>
    <br>立志<input type="text" name="ambition" value="${student.ambition}"/>

    <input type="submit" value="更改">
</form>
</body>
</html>