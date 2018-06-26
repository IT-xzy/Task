<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 田野
  Date: 2018/5/20
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>表格</title>
</head>
<body>

<table cellpadding="0" cellspacing="0" border="1"
       style=" border-collapse: collapse;min-height: 300px;width: 1800px;text-align: center;">
    <tr>
        <td colspan="14" align="left">
            <a href="register">添加</a>
        </td>
    </tr>
    <tr>
        <td colspan="14" align="left">
            <form action="/find" method="get">
                学号: <input name="s_id">
                <input type="submit" value="查询"/>
            </form>
        </td>
    </tr>
    <tr>
        <td>学号</td>
        <td>姓名</td>
        <td>QQ</td>
        <td>入学时间</td>
        <td>类型</td>
        <td>学校</td>
        <td>日报链接</td>
        <td>立愿</td>
        <td>师兄</td>
        <td>从哪知道</td>
        <td>创建时间</td>
        <td>更新时间</td>
        <td>修改</td>
        <td>删除</td>
    </tr>

    <tr>
        <td>${students.s_id}</td>
        <td>${students.s_name}</td>
        <td>${students.s_qq}</td>
        <td>${students.s_time}</td>
        <td>${students.s_type}</td>
        <td>${students.s_school}</td>
        <td>${students.s_link}</td>
        <td>${students.s_words}</td>
        <td>${students.s_brother}</td>
        <td>${students.s_know}</td>
        <td>${students.create_at}</td>
        <td>${students.update_at}</td>
        <td><a type="button" href="${path}update?id=${students.s_id}" class="btn btn-info btn-sm">
            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
            修改</a>
        </td>
        <td><a type="button" href="${path}/delete?s_id=${students.s_id}" class="btn btn-danger btn-sm">
            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
            删除</a>
        </td>
    </tr>

</table>
</body>


