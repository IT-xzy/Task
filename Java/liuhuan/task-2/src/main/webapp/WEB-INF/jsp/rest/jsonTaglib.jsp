<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2018/4/30
  Time: 18:47
  To change this template use File | Settings | File Templates.
  json 格式输出 对象
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<html>
<json:object>
    <json:array name="users" var="user" items="${userCustomList}">
        <json:object>
            <json:property name="id" value="${user.id}"/>
            <json:property name="username" value="${user.username}"/>
            <%-- 为空会报错 --%>
            <%--<json:property name="qq" value="${user.qq"/>--%>
            <json:property name="profession" value="${user.profession}"/>
            <json:property name="join_date" value="${user.join_date}"/>
        </json:object>
    </json:array>
</json:object>

</body>
</html>
