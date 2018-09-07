<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
    <%--列表部分--%>
    <json:array name="items" items="${categoryListJ}" var="item">
        <json:object>
            <json:property name="id" value="${item.id}"/>
            <json:property name="name" value="${item.name}"/>
        </json:object>
    </json:array>
</json:object>

