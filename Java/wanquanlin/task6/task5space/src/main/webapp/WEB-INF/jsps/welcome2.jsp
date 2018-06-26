<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2 align="center"><a href="${pageContext.request.contextPath}/welcome"> 点击跳转</a></h2>

</body>
</html>
<html>
<head>
    <script language=javascript>
        function out(obj){
            var i = obj ;
            if(i==0)
                document.location.href="/welcome";
            document.body.innerHTML = i;
            i--;
            setTimeout("out("+i+")",1000);
        }
    </script>
</head>
<body onload="out(5)">
</body>
</html>

