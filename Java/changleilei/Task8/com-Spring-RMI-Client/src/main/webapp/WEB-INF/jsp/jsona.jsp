<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
    <title>JSON example</title>
    <script language="javascript">

        var object1 = {"language": "Java", "author": "herbert schildt"};
        document.write("<h1>JSON with JavaScript example</h1>");
        document.write("<br>");
        document.write("<h3>Language = " + object1.language + "</h3>");
        document.write("<h3>Author = " + object1.author + "</h3>");

        var object2 = {"language": "C++", "author": "E-Balagurusamy"};
        document.write("<br>");
        document.write("<h3>Language = " + object2.language + "</h3>");
        document.write("<h3>Author = " + object2.author + "</h3>");

        document.write("<hr />");
        document.write(object2.language + " programming language can be studied " +
            "from book written by " + object2.author);
        document.write("<hr />");
    </script>
    <h2>在 JavaScript 中创建 JSON 对象</h2>

    <p>
        Name: <span id="jname" ></span><br />
        Age: <span id="jage"></span><br />
        Address: <span id="jstreet"></span><br />
        Phone: <span id="jphone"></span><br />
    </p>

    <script type="text/javascript">
        var JSONObject= {
            "name":"Bill Gates",
            "street":"Fifth Avenue New York 666",
            "age":56,
            "phone":"555 1234567"};
        document.getElementById("jname").innerHTML=JSONObject.name
        document.getElementById("jage").innerHTML=JSONObject.age
        document.getElementById("jstreet").innerHTML=JSONObject.street
        document.getElementById("jphone").innerHTML=JSONObject.phone
    </script>
</head>
<body>
</body>
</html>
