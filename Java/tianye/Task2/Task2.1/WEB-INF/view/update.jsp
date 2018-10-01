<%--
  Created by IntelliJ IDEA.
  User: 田野
  Date: 2018/5/20
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新学生信息</title>
</head>
<body>
<div style="text-align: center">
    <form action="/form" method="post">
        <input hidden="hidden" name="_method" value="put">
        <input type="number" placeholder="请输入学号" name="s_id" value="${update_stu.s_id}" hidden="hidden"><br/><br/>
        <input type="text" placeholder="请输入姓名" name="s_name" value="${update_stu.s_name}"><br/><br/>
        <input type="number" placeholder="请输入qq" name="s_qq" value="${update_stu.s_qq}"><br/><br/>
        <input type="test" placeholder="请输入入学时间" name="s_time" value="${update_stu.s_time}"><br/><br/>
        <input type="text" placeholder="请输入类型" name="s_type" value="${update_stu.s_type}"><br/><br/>
        <input type="text" placeholder="请输入学校" name="s_school" value="${update_stu.s_school}"><br/><br/>
        <input type="text" placeholder="请输入日报链接" name="s_link" value="${update_stu.s_link}"><br/><br/>
        <input type="text" placeholder="请输入立愿" name="s_words" value="${update_stu.s_words}"><br/><br/>
        <input type="text" placeholder="请输入师兄" name="s_brother" value="${update_stu.s_brother}"><br/><br/>
        <input type="text" placeholder="请输入哪里知道" name="s_know" value="${update_stu.s_know}"><br/><br/>
        <input type="number" placeholder="请输入创建时间" name="create_at" value="${update_stu.create_at}"><br/><br/>
        <input type="number" placeholder="请输入更新时间" name="update_at" value="${update_stu.update_at}"><br/><br/>
        <button type="submit">更新</button>
    </form>

</div>
</body>
</html>
