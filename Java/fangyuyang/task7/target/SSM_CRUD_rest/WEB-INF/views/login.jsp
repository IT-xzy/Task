<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<body>


    <h1>用户登陆</h1>
    <form action="<%=basePath%>/dologin" method="post" name="loginFrom">
        <table>
            <tr>
                <td>用户名:</td>
                <td><input type="text" name="name" value="" /></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type="password" name="passwordString" value="" /></td>
            </tr>

            <tr>
                <td  colspan="2" align="center"><input type="submit" value="登陆" /></td>
            </tr>
        </table>
    </form>
</body>
