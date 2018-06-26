<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查询</title>

</head>
<body>
<form id="itemForm" action="${pageContext.request.contextPath }/stu/student/object" method="get">
    查询学生：
    <table width="100%" border=1>
        <tr>
            <td>综合查询</td>
            <td><input type="text" name="object" /></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="综合查询" />
            </td>
        </tr>
    </table>
</form>
</body>

</html>