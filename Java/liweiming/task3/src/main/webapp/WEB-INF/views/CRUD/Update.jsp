<%@ taglib uri="/tags" prefix="date"%>
<%--
  Created by IntelliJ IDEA.
  User: Yzzzt
  Date: 2018/5/25
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title></title>
</head>
<body>
<form action="${pageContext.request.contextPath}/rest/user/${itemsList.id}" method="POST">
    <table width="100%" border=1>
        <tr>
            <td>id</td>
            <td>名字</td>
            <td>QQ</td>
            <td>修真类型</td>
            <td>入学时间</td>
            <td>毕业学校</td>
            <td>学号</td>
            <td>日报链接</td>
            <td>立愿</td>
            <td>线上师兄</td>
            <td>创建时间</td>
            <td>更新时间</td>
            <td>操作</td>
        </tr>

        <tr>
            <td>${itemsList.id }</td>
            <td><input type="text" name="name" style="width: 50px;" value="${itemsList.name }"></td>
            <td><input type="text" name="qq" style="width: 70px;" value="${itemsList.qq }"></td>
            <td><input type="text" name="learning_type" style="width: 70px;" value="${itemsList.learning_type }"></td>
            <td><input type="text" name="entrance_time" style="width: 70px;" value="<date:date value ="${itemsList.entrance_time}"/>"></td>
            <td><input type="text" name="school"  style="width: 70px;" value="${itemsList.school }"></td>
            <td><input type="text" name="online_id"  style="width: 50px;" value="${itemsList.online_id}"/></td>
            <td><input type="text" name="daily_link" style="width: 70px;" value="${itemsList.daily_link }"></td>
            <td><input type="text" name="wish" style="width: 70px;" value="${itemsList.wish}"></td>
            <td><input type="text" name="tutor" style="width: 50px;" value="${itemsList.tutor}"></td>
            <td><input type="text" name="create_at" value="<date:date value ="${itemsList.create_at}"/>"/>
            <td><input type="text" name="update_at" value="<date:date value="${itemsList.update_at}"/> "></td>
            <td><input type="submit"></td>
        </tr>
    </table>
</form>
</body>
</html>