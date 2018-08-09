<%--
  Created by IntelliJ IDEA.
  User: 田野
  Date: 2018/7/24
  Time: 2:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改页面</title>
</head>
<body>
<div style="text-align: center">
    <form action="/form" name="form" method="post">
        <%--<input hidden="hidden" name="_method" value="post"/>--%>
        <input type="text" placeholder="请输入账号" name="userId" value="${update_user.userId}" readonly><br/><br/>
        <input type="text" placeholder="请输入姓名" name="userName" value="${update_user.userName}" readonly><br/><br/>
        <input type="text" placeholder="请输入密码" name="userPassword" value="${update_user.userPassword}" readonly><br/><br/>
        <input type="text" placeholder="请输入电话号码" name="userTel" value="${update_user.userTel}" readonly><br/><br/>
        <input type="text" placeholder="请输入邮箱" name="userMail" value="${update_user.userMail}" readonly><br/><br/>
        <input type="text" placeholder="请添加照片" name="userPhoto" value="${update_user.userPhoto}"><br/><br/>
        <input type="number" placeholder="请输入qq" name="userQq" value="${update_user.userQq}"><br/><br/>
        <input type="text" placeholder="请输入类型" name="userType" value="${update_user.userType}"><br/><br/>
        <input type="text" placeholder="请输入学校" name="userSchool" value="${update_user.userSchool}"><br/><br/>
        <input type="text" placeholder="请输入日报链接" name="userDailyLink" value="${update_user.userDailyLink}"><br/><br/>
        <input type="text" placeholder="请输入立愿" name="userWords" value="${update_user.userWords}"><br/><br/>
        <input type="text" placeholder="请输入师兄" name="userBrother" value="${update_user.userBrother}"><br/><br/>
        <input type="number" placeholder="请输入性别" name="userSex" value="${update_user.userSex}"><br/><br/>
        <input type="number" placeholder="请输入创建时间" name="create_at" value="${update_user.create_at}"><br/><br/>
        <input type="number" placeholder="请输入更新时间" name="update_at" value="${update_user.update_at}"><br/><br/>
        <input type="text" placeholder="请输入创建人" name="create_by" value="${update_user.create_by}"><br/><br/>
        <input type="text" placeholder="请输入修改人" name="update_by" value="${update_user.update_by}"><br/><br/>
        <button type="submit">更新</button>
    </form>
</div>
</body>
</html>
