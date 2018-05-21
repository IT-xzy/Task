<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<c:forEach items="${studentList }" var="obj">
    <table border="2">
        <tr>
            <td>序号：${obj.id}&nbsp;&nbsp;</td>
            <td>姓名：${obj.name}&nbsp;</td>
            <td>性别：${obj.sex}&nbsp;</td>
            <td>QQ：${obj.qq}&nbsp;</td>
            <td>院校：${obj.graduate}&nbsp;</td>
            <td>学号：${obj.number}&nbsp;</td>
            <td>个签：${obj.autograph}&nbsp;</td>
            <td>创建：${obj.createtime}&nbsp;</td>
            <td>更新：${obj.updatetime}&nbsp;</td>
            <td>
                <form action="${ctx}/student/${obj.id}" method="post">
                    <input type="hidden" name="_method" value="DELETE">
                    <input type="submit" value="删除">
                </form>
            </td>
            <td><a href="/student/modify">更新</a>&nbsp;</td>
            <td><a href="/student/register">新增</a>&nbsp;</td>
            <td><a href="/">首页</a><br/><br/></td>
            <td><a href="${ctx}/student/${obj.id}">详细信息</a><br/><br/></td>
        </tr>
    </table>
</c:forEach>
</body>
</html>
