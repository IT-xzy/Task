<%--
  Created by IntelliJ IDEA.
  User: lucifer
  Date: 2018/3/15
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table class="tablelist">
    <thead>
    <tr>
        <th width="100px;">编号</th>
        <th>影片类型</th>
        <th>影片名称</th>
        <th>发布人</th>
        <th>发布时间</th>
        <th>审核状态</th>
        <th>操作</th>
    </tr>
    </thead>

    <tbody>
    <s:iterator value="recordList" var="o" status="i">
        <tr>
            <td>${o.id}</td>
            <td>${o.name }</td>
            <td>${o.type}</td>
            <td>${o.updateMember.memberName }</td>
        </tr>
    </s:iterator>
    </tbody>

</table>
</body>
</html>
