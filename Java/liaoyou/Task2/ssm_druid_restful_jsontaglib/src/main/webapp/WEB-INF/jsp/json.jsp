<%--使用@taglib指令添加json的标签库json-taglib--%>
<%@taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${students}" var="student" varStatus="st">
    <json:object>
        <json:property name="id" value="${student.id}"/>
        <json:property name="name" value="${student.name}"/>
        <json:property name="qq" value="${student.qq}"/>
        <json:property name="profession" value="${student.profession}"/>
        <json:property name="school" value="${student.school}"/>
        <json:property name="create_time" value="${student.create_time}"/>
        <json:property name="update_time" value="${student.update_time}"/>
    </json:object>
</c:forEach>




