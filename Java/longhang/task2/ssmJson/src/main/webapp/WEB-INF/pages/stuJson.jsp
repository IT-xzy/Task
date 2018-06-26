<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
<json:array name="students" var="student" items="${students}">
<json:object>
    <json:property name="id" value="${student.id}"/>
    <json:property name="name" value="${student.name}"/>
    <json:property name="qq" value="${student.qq}"/>
    <json:property name="wish" value="${student.wish}"/>
    <json:property name="major" value="${student.major}"/>
    <json:property name="create_at" value="${student.create_at}"/>
    <json:property name="update_at" value="${student.update_at}"/>
    <json:property name="dairylink" value="${student.dairylink}"/>
</json:object>
</json:array>
</json:object>