
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
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
            学号: <input name="s_id">
            <input type="button" value="查询" onclick="findBySId()"/>
            姓名：<input name="s_name">
            <input type="button" value="查询" onclick="findBySName()"/>
            <script type="text/javascript">
                function findBySId() {
                    var form = document.getElementById("find");
                    var s_id = document.getElementsByName("s_id")[0].value;
                    location.href = "student/s_id/" + s_id;
                }

                function findBySName() {
                    var form = document.getElementById("find");
                    var s_name = document.getElementsByName("s_name")[0].value;
                    location.href = "student/s_name/" + s_name;
                }

            </script>

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
    <c:forEach items="${students}" var="li" varStatus="i">
        <tr>
            <td>${li.s_id}</td>
            <td>${li.s_name}</td>
            <td>${li.s_qq}</td>
            <td>${li.s_time}</td>
            <td>${li.s_type}</td>
            <td>${li.s_school}</td>
            <td>${li.s_link}</td>
            <td>${li.s_words}</td>
            <td>${li.s_brother}</td>
            <td>${li.s_know}</td>
            <td>${li.create_at}</td>
            <td>${li.update_at}</td>
            <td><a href="${path}student/s_id/${li.s_id}/profile"
                   class="btn btn-info btn-sm">
                <span class="glyphicon glyphicon-pencil"></span>
                修改</a>
            </td>
            <td><a type="button" href="${path}/delete?s_id=${li.s_id}" class="btn btn-danger btn-sm">
                <span class="glyphicon glyphicon-trash"></span>
                删除</a>
            </td>

        </tr>
    </c:forEach>

    <script src="/js/jquery-1.9.1.min.js"></script>
    <script src="/js/form.js"></script>
</table>
</body>
</html>

