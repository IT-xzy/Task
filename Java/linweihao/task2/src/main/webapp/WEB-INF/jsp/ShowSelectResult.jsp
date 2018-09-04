<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/7/26
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
  <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
  <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
  <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
  <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
  <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
<div class="panel-heading">查询结果</div>
  <table border="1" class="table">
  <c:forEach items="${List}" var="member">
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
      <th>执行操作</th>
    </tr>
    <tr>
      <td>${member.id}</td>
      <td>${member.name}</td>
      <td>${member.qq}</td>
      <td>${member.learnType}</td>
      <td>${member.timeToLearn}</td>
      <td>${member.graduatedSchool}</td>
      <td>${member.onlineNum}</td>
      <td>${member.dariyList}</td>
      <td>${member.wish}</td>
      <td>${member.helperShixiong}</td>
      <td>${member.wayToKnow}</td>
      <td>
        <form action="Delete/${member.id}" method="post">
          <input type="hidden" name="_method" value="DELETE"/>
          <button class="btn btn-danger" type="submit">删除</button>
        </form>
        <form action="EditStudent" method="post">
          <input name="Uid" type="hidden" value="${member.id}">
          <input name="name" type="hidden" value="${member.name}">
          <input name="qq" type="hidden" value="${member.qq}" >
          <input name="LearnType" type="hidden" value="${member.learnType}">
          <input name="LearnTime" type="hidden" value="${member.timeToLearn}">
          <input name="School" type="hidden" value="${member.graduatedSchool}">
          <input name="onlineNum" type="hidden" value="${member.onlineNum}">
          <input name="dariyList" type="hidden" value="${member.dariyList}">
          <input name="wish" type="hidden" value="${member.wish}">
          <input name="helper" type="hidden" value="${member.helperShixiong}">
          <input name="waytokonw" type="hidden" value="${member.wayToKnow}">
          <button class="btn btn-success" type="submit">编辑</button>
        </form>
      </td>
    </tr>
  </c:forEach>
  </table>
</body>
</html>
