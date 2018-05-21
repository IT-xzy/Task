<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
    <tr>
        <td>name:${study.name}</td>
        <p>user_id:${study.userId}</p>
        <p>study_type:${study.studyType}</p>
        <p>qq:${study.qq}</p>
        <p>entry_data:${study.entryData}</p>
        <p>graduated:${study.graduated}</p>
        <p>url:${study.url}</p>
        <p>wish:${study.wish}</p>
        <p>know_from:${study.knowFrom}</p>
    </tr>
</body>
</html>