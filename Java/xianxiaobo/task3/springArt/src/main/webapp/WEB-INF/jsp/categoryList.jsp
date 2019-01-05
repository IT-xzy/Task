<%--
  Created by IntelliJ IDEA.
  User: xianxiaobo
  Date: 2018/11/7
  Time: 2:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<json:object>
    <json:property name="code" value="${response.code}"/>
    <json:property name="message" value="${response.message}"/>
    <json:property name="total" value="${response.total}"/>
    <json:array name="data">
        <c:forEach var="item" items="${categoryList}" varStatus="now">
            <json:object>
                <json:property name="id" value="${item.id}"/>
                <json:property name="category_name" value="${item.category_name}"/>
                <json:property name="collection_id" value="${item.collection_id}"/>
                <json:property name="status" value="${item.status}"/>
                <json:property name="create_at" value="${item.create_at}"/>
                <json:property name="create_by" value="${item.create_by}"/>
                <json:property name="update_at" value="${item.update_at}"/>
                <json:property name="update_by" value="${item.update_by}"/>
                <json:property name="update_name" value="${usernameList.get(now.index)}"/>
                <json:property name="collection_name" value="${collectionNameList.get(now.index)}"/>
            </json:object>
        </c:forEach>
    </json:array>
</json:object>