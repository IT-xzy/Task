<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<json:object>
    <json:array name="admins" var="admin" items="${admins}">
        <json:object>
            <json:property name="adminId" value="${admin.adminId}"/>
            <json:property name="adminCode" value="${admin.adminCode}"/>
            <json:property name="password" value="${admin.adminCode}"/>
            <json:property name="name" value="${admin.name}"/>
            <json:property name="telephone" value="${admin.telephone}"/>
            <json:property name="email" value="${admin.email}"/>
            <json:property name="enrolldate" value="${admin.enrolldate}"/>
        </json:object>
    </json:array>
</json:object>