<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json"%>
<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
</head>
<body>
<body>
<h2></h2>
<p>
    code: <span id="jcode"></span><br />
    messages: <span id="jmessage"></span><br />
</p>
<script>
    var JSONObject= {
        "code":"${code}",
        "message":"${message}",
        "date":{
            "id":"${student.id}",
            "name":"${student.name}"


        }

    };
    document.getElementById("jcode").innerHTML=JSONObject.code
    document.getElementById("jmessage").innerHTML=JSONObject.message

</script>

</body>
</body>
</html>

