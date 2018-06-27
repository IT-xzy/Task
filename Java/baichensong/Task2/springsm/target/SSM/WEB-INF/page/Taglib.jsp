<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>JSON Taglib</title>
</head>

<json:object>

<json:array name="json" var= "o" items="${json}">

    <json:object>
        <json:property name="id" value="${o.id}"/>
        <json:property name="name" value="${o.name}"/>
    </json:object>

    </json:array>

</json:object>

</html>