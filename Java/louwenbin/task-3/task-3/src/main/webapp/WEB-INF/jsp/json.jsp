<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
    <json:property name="id" value=" ${sel.id},"/>
    <json:property name="名字" value="${sel.name},"/>
    <json:property name="性别" value="${sel.sex},"/>
    <json:property name="QQ" value="${sel.qq},"/>
    <json:property name="修真类型" value="${sel.type},"/>
    <json:property name="入学时间" value="${sel.admission},"/>
    <json:property name="毕业院校" value="${sel.graduate},"/>
    <json:property name="日报链接" value="${sel.link},"/>
    <json:property name="立愿" value="${sel.wish},"/>
    <json:property name="线上师兄" value="${sel.audit}"/>
    <json:property name="创建时间" value="${sel.create_at},"/>
    <json:property name="更新时间" value="${sel.update_at},"/>
</json:object>
