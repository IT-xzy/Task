<%--
  Created by IntelliJ IDEA.
  User: zhimowen
  Date: 2018-04-20
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
    <json:property name="id" value="${student1.id}"/>
    <json:property name="location" value="${student1.location}"/>
    <json:property name="level" value="${student1.level}"/>
    <json:property name="lesson" value="${student1.lesson}"/>

    <json:property name="name" value="${student1.name}"/>
    <json:property name="qq" value="${student1.qq}"/>
    <json:property name="job" value="${student1.job}"/>
    <json:property name="startTime" value="${student1.startTime}"/>

    <json:property name="university" value="${student1.university}"/>
    <json:property name="number" value="${student1.number}"/>
    <json:property name="link" value="${student1.link}"/>
    <json:property name="target" value="${student1.target}"/>

    <json:property name="brother" value="${student1.brother}"/>
    <json:property name="source" value="${student1.source}"/>
    <json:property name="createAt" value="${student1.createAt}"/>
    <json:property name="updateAt" value="${student1.updateAt}"/>
</json:object>


<div style="width:500px;margin:0px auto;text-align:center">
    <div style="text-align:center;margin-top:40px">
        <form method="post" action="../student/${student1.id}">
            <%--id     ： <input name="id" value="${student1.id}" type="text"> <br><br>--%>
            分院    ： <input id="in1" name="location" value="${student1.location}" type="text"> <br><br>
            等级    ： <input name="level" value="${student1.level}" type="text"> <br><br>
            课程    ： <input name="lesson" value="${student1.lesson}" type="text"> <br><br>
            名字    ： <input name="name" value="${student1.name}" type="text"> <br><br>
            QQ      ： <input name="qq" value="${student1.qq}" type="text"> <br><br>
            学习方向 ： <input name="job" value="${student1.job}" type="text"> <br><br>
            入学时间 ： <input name="startTime" value="${student1.startTime}" type="text"> <br><br>
            毕业院校 ： <input name="university" value="${student1.university}" type="text"> <br><br>
            学号     ： <input name="number" value="${student1.number}" type="text"> <br><br>
            日报链接 ： <input name="link" value="${student1.link}" type="text"> <br><br>
            立愿     ： <input name="target" value="${student1.target}" type="text"> <br><br>
            师兄     ： <input name="brother" value="${student1.brother}" type="text"> <br><br>
            来源     ： <input name="source" value="${student1.source}" type="text"> <br><br>
            创建时间  ： <input name="createAt" value="${student1.createAt}" type="text"> <br><br>
            更新时间  ： <input name="updateAt" value="${student1.updateAt}" type="text"> <br><br>
            <input type="submit" value="修改学生信息">
        </form>
    </div>
</div>