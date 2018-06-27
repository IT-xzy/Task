<%--
  Created by IntelliJ IDEA.
  User: 指缝de阳光
  Date: 2018/5/24
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<json:object>
    <json:array name="profession" var="pr" items="${profession}">
        <json:object>
            <json:property name="proId" value="${pr.proId}" />
            <json:property name="proName" value="${pr.proName}"/>
            <json:property name="proIntroduction" value="${pr.proIntroduction}"/>
            <json:property name="proThreshold" value="${pr.proThreshold}" />
            <json:property name="proDifficulty" value="${pr.proDifficulty}" />
            <json:property name="proCompany" value="${pr.proCompany}" />
            <json:property name="proSalary1" value="${pr.proSalary1}" />
            <json:property name="proSalary2" value="${pr.proSalary2}" />
            <json:property name="proSalary3" value="${pr.proSalary3}" />
            <json:property name="proPrompt" value="${pr.proPrompt}" />
            <json:property name="create_at" value="${pr.create_at}" />
            <json:property name="update_at" value="${pr.update_at}" />
        </json:object>
    </json:array>
</json:object>
