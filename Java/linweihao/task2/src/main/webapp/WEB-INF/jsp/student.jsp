<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/8/15
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
  <title>学生信息</title>
</head>
<body>
<table>
  <tr>
    <th>id</th>
    <th>姓名</th>
    <th>QQ</th>
    <th>学习类型</th>
    <th>学习时间</th>
    <th>毕业院校</th>
    <th>网上编号</th>
    <th>日报列表</th>
    <th>愿景</th>
    <th>帮助师兄</th>
    <th>得知渠道</th>
  </tr>
  <input type="hidden" name="_method" value="PUT"/>
  <tr>
    <td><input type="t" name="Uid" value="${member.id}"></td>
    <td><input type="text" name="name" value="${member.name}" ></td>
    <td><input type="text" name="qq" value="${member.qq}"></td>
    <td><input type="text" name="LearnType" value="${member.learnType}"></td>
    <td><input type="text" name="LearnTime" value="${member.timeToLearn}"></td>
    <td><input type="text" name="School" value="${member.graduatedSchool}"></td>
    <td><input type="text" name="onlineNum" value="${member.onlineNum}"></td>
    <td><input type="text" name="dariyList" value="${member.dariyList}"></td>
    <td><input type="text" name="wish" value="${member.wish}"></td>
    <td><input type="text" name="helper" value="${member.helperShixiong}"></td>
    <td><input type="text" name="waytokonw" value="${member.wayToKnow}"></td>
  </tr>
</table>
</body>
</html>
