<%--
  Created by IntelliJ IDEA.
  User: xianxiaobo
  Date: 2018/11/9
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<json:object>
    <json:property name="code" value="${response.code}"/>
    <json:property name="message" value="${response.message}"/>
    <json:array name="data">
        <c:forEach var="item" items="${collectionList}" varStatus="now">
            <json:object>
                <json:property name="id" value="${item.id}"/>
                <json:property name="collection_name" value="${item.collection_name}"/>
                <json:property name="status" value="${item.status}"/>
                <json:property name="create_at" value="${item.create_at}"/>
                <json:property name="create_by" value="${item.create_by}"/>
                <json:property name="update_at" value="${item.update_at}"/>
                <json:property name="update_by" value="${item.update_by}"/>
                <json:array name="category_list">
                        <c:forEach var="subItem" items="${categoryDataList.get(now.index)}" varStatus="subNow">
                            <json:object>
                                <json:property name="id" value="${subItem.id}"/>
                                <json:property name="category_name" value="${subItem.category_name}"/>
                                <json:property name="collection_id" value="${subItem.collection_id}"/>
                                <json:property name="status" value="${subItem.status}"/>
                                <json:property name="create_at" value="${subItem.create_at}"/>
                                <json:property name="create_by" value="${subItem.create_by}"/>
                                <json:property name="update_at" value="${subItem.update_at}"/>
                                <json:property name="update_by" value="${subItem.update_by}"/>
                            </json:object>
                        </c:forEach>
                </json:array>

            </json:object>
        </c:forEach>
    </json:array>
</json:object>
