<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>JSON Taglib 标签</title>
</head>




<json:object>
 <!-- name="json" 为数组名称。 遍历 json。 -->
<json:array name="json" var= "o" items="${json}">

    <json:object>
        <json:property name="id" value="${o.id}"/>
        <json:property name="name" value="${o.name}"/>
    </json:object>

    </json:array>

</json:object>


</html>