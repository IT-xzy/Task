<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Redis测试</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
</head>

<body>
    <p>
        测试添加Redis值：${member.id},${member.nickname}
    </p>
    <br>
    <br>
    --------------------------------------------------
    <p>
        测试添加Redis集合值：
        <c:forEach items="${memberList}" var="mem">
这是id ---------${mem.id}
            这是-------------${mem.nickname}
        </c:forEach>
    </p>
    <br>
    <br>
    --------------------------------------------------
    <p>
        测试查询Redis值：${message}
    </p>
    <br>
    <br>
    <p>
        测试删除Redis值：${message}
    </p>

<p>

    <%--<c:forEach items="${nihao} " var="d">--%>
        <%--读取缓存中的 HashMap   -----     id ---------%>
        <%--读取缓存中的 HashMap   -----     id -----${d.nickname}--%>
<%--</c:forEach>--%>
</p>
</body>
</html>