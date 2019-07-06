<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/27
  Time: 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update</title>
</head>
<body>
<form action="/user/update" name="user">
      <input type="hidden" value="${find.id}" name="id"><br/>
    姓名<input type="text" name="name" value="${find.name}"><br/>
    修真类型<input type="text" name="type" value="${find.type}"><br/>
    入学时间<input type="text" name="admissionTime" value="${find.admissionTime}"><br/>
    毕业学校<input type="text" name="graduatedSchool" value="${find.graduatedSchool}"><br/>
    日报链接<input type="text" name="daliyLink" value="${find.daliyLink}"><br/>
    立愿<input type="text" name="volunte" value="${find.volunte}"><br/>
    师兄<input type="text" name="brother" value="${find.brother}"><br/>
    途径<input type="text" name="source" value="${find.source}"><br/>
    创建时间<input type="text" name="createAt" value="${find.createAt}"><br/>
    修改时间<input type="text" name="updateAt" value="${find.updateAt}"><br/>
    <input type="submit" value="修改">
</form>

</body>
</html>
