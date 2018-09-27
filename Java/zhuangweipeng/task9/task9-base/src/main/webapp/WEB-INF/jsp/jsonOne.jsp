<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<json:object>--%>

    <json name="单条论文记录" var="paper" items="${paper}">
        <json:object>
            <json:property name="paperId" value="${paper.paperId}"/><br/>
            <json:property name="paperName" value="${paper.paperName}"/><br/>
            <json:property name="paperNum" value="${paper.paperNum}"/><br/>
            <json:property name="paperDetail" value="${paper.paperDetail}"/><br/>
        </json:object>
    </json>
<%--</json:object>--%>
