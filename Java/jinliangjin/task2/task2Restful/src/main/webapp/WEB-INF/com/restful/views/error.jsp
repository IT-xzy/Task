<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<div style="text-align: center;">
    <h2>失败</h2>
</div>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>失败</title>
</head>
<c:if test="${empty requestScope.students}">
    没有查询到信息！
</c:if>
<c:if test="${!empty requestScope.students}">
    <form>
        错误如下：
        <table width="100%" border=1>
            <tr>
                <td>错误</td>
            </tr>
            <c:forEach items="${errors }" var="item">

                <tr>
                    <td>${item}</td>
                </tr>
            </c:forEach>
        </table>
    </form>
</c:if>
<div style="width:100%;height:100%;border:1px;text-align:center">
    <input type="button" name="Submit" onclick="javascript:history.back();" value="返回">
</div>

</body>
</html>