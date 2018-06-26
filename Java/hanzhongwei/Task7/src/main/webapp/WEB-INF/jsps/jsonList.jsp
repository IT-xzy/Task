<%--
  Created by IntelliJ IDEA.
  User: 指缝de阳光
  Date: 2018/5/22
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<json:object>
    <json:array name="students" var="s" items="${stu}">
        <json:object>
            <json:property name="ID" value="${s.sId}" />
            <json:property name="姓名" value="${s.sName}"/>
            <json:property name="QQ" value="${s.QQ}"/>
            <json:property name="修真类型" value="${s.sType}" />
            <json:property name="入学时间" value="${s.sTime}" />
            <json:property name="毕业院校" value="${s.sSchool}" />
            <json:property name="线上学号" value="${s.sNumber}" />
            <json:property name="日报链接" value="${s.sDaily}" />
            <json:property name="立愿" value="${s.sWish}" />
            <json:property name="辅导师兄" value="${s.sCoach}" />
            <json:property name="从何处了解" value="${s.sWhence}" />
            <json:property name="创建时间" value="${s.create_at}" />
            <json:property name="更新时间" value="${s.update_at}" />
        </json:object>
    </json:array>

</json:object>
