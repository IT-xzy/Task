<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<json:object>
    <json:property name="id" value=" ${member.id}"/>
    <json:property name="姓名" value="${member.name}"/>
    <json:property name="QQ" value=" ${member.qq}"/>
    <json:property name="学习类型" value="${member.learnType}"/>
    <json:property name="学习时间" value="${member.timeToLearn}"/>
    <json:property name="毕业院校" value="${member.graduatedSchool}"/>
    <json:property name="线上编号" value="${member.onlineNum}"/>
    <json:property name="日报列表" value="${member.dariyList}"/>
    <json:property name="愿景" value="${member.wish}"/>
    <json:property name="帮助师兄" value="${member.helperShixiong}"/>
    <json:property name="得知渠道" value="${member.wayToKnow}"/>
</json:object>