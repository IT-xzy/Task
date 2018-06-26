<%--
  Created by IntelliJ IDEA.
  User: 田野
  Date: 2018/4/28
  Time: 7:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
</head>
<body>
<div style="text-align: center">
    <form action="/register" method="post">
        <input type="number" placeholder="请输入学号" name="s_id"><br/><br/>
        <input type="text" placeholder="请输入姓名" name="s_name"><br/><br/>
        <input type="number" placeholder="请输入qq" name="s_qq"><br/><br/>
        <input type="test" placeholder="请输入入学时间" name="s_time"><br/><br/>
        <input type="text" placeholder="请输入类型" name="s_type"><br/><br/>
        <input type="text" placeholder="请输入学校" name="s_school"><br/><br/>
        <input type="text" placeholder="请输入日报链接" name="s_link"><br/><br/>
        <input type="text" placeholder="请输入立愿" name="s_words"><br/><br/>
        <input type="text" placeholder="请输入师兄" name="s_brother"><br/><br/>
        <input type="text" placeholder="请输入哪里知道" name="s_know"><br/><br/>
        <input type="number" placeholder="请输入创建时间" name="create_at"><br/><br/>
        <input type="number" placeholder="请输入更新时间" name="update_at"><br/><br/>
        <button type="submit">添加</button>
    </form>
</div>

</body>
</html>
