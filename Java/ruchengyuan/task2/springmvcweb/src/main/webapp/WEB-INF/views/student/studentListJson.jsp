<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Index</title>
</head>

<body>
<table>
<c:forEach items="${study}" var="study" varStatus="st">
    <tr>
        <td>
            <p>name:${study.name}</p>
            <p>user_id:${study.userId}</p>
            <p>study_type:${study.studyType}</p>
            <p>qq:${study.qq}</p>
            <p>entry_data:${study.entryData}</p>
            <p>graduated:${study.graduated}</p>
            <p>url:${study.url}</p>
            <p>wish:${study.wish}</p>
            <p>know_from:${study.knowFrom}</p>
        </td>
    </tr>
</c:forEach>
</table>
</body>
</html>