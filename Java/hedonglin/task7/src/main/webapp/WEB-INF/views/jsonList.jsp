<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dong
  Date: 2018/1/18
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<json:object escapeXml="false">
    <json:array name="学员信息">
        <c:forEach var="student" items="${studentList}">
            <json:object>
                <json:property name="id" value="${student.id}"/>
                <json:property name="创建时间" value="${student.createAt}"/>
                <json:property name="更新时间" value="${student.updateAt}"/>
                <json:property name="姓名" value="${student.name}"/>
                <json:property name="性别" value="${student.sex}"/>
                <json:property name="QQ" value="${student.qq}"/>
                <json:property name="主修" value="${student.major}"/>
                <json:property name="入学时间" value="${student.entryTime}"/>
                <json:property name="来自" value="${student.comeFrom}"/>
                <json:property name="手机号" value="${student.cellphone}"/>
                <json:property name="邮箱" value="${student.email}"/>
                <json:property name="头像" value="${student.headPortrait}"/>
            </json:object>
        </c:forEach>
    </json:array>
</json:object>