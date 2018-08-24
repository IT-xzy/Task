<%--
  Created by IntelliJ IDEA.
  User: lihoo
  Date: 2018/8/6
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" import="java.util.*" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>用AJAX以JSON方式获取数据</title>
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript">
        /*将post method 改变为delete*/
        $(function(){
            $(".delete").click(function(){
                var href=$(this).attr("href");
                $("#form_delete").attr("action",href).submit();
                return false;
            })
        })
    </script>

</head>
<body style="font-size: small">
    <div style=" margin: 0 auto; text-align: center;">
        <table align='center' border='1' cellspacing='0' style="text-align: center">
        <tr>
            <td>id</td>
            <td>username</td>
            <td>qq_num</td>
            <td>study_type</td>
            <td>study_time</td>
            <td>school</td>
            <td>study_id</td>
            <td>daily_link</td>
            <td>promise</td>
            <td>teach_bro</td>
            <td>know_us_from</td>
            <td>create_at</td>
            <td>update_at</td>

            <td>*编辑*</td>
            <td>*删除*</td>
        </tr>
        <c:forEach items="${stu}" var="c" varStatus="st">
            <tr style="text-align: center">
                <td>${c.id}</td>
                <td>${c.username}</td>
                <td>${c.qq_num}</td>
                <td>${c.study_type}</td>
                <td>${c.study_time}</td>
                <td>${c.school}</td>
                <td>${c.study_id}</td>
                <td>${c.daily_link}</td>
                <td>${c.promise}</td>
                <td>${c.teach_bro}</td>
                <td>${c.know_us_from}</td>
                <td>${c.create_at}</td>
                <td>${c.update_at}</td>
                <td><a href="student/${c.id}">编辑</a></td>
                <td><a class="delete" href="student/${c.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
        <br><br>
        <div style="text-align: center;font-size: x-large">
            <a href="?start=0">首  页</a>
            <a href="?start=${page.start-page.count}">上一页</a>
            <a href="?start=${page.start+page.count}">下一页</a>
            <a href="?start=${page.last}">末  页</a>
        </div>

        <div style="text-align: center; margin-top: 40px">
        <form method="post" action="student">
            <input type="hidden" name="_method" value="PUT">

            学生姓名：     <input type="text" name="username" value="安度因"><br><br>
            学生QQ:       <input type="number" name="qq_num" value="112233"><br><br>
            学生职业类型：  <input type="text" name="study_type" value="java"><br><br>
            预计入学时间：  <input type="text" name="study_time" value="1533712935"><br><br>
            毕业院校：     <input type="text" name="school" value="艾泽拉斯大学"><br><br>
            线上学号：     <input type="text" name="study_id" value="java-4835"><br><br>
            日报链接：     <input type="text" name="daily_link" value="www.real_shit.com"><br><br>
            立愿：        <input type="text" name="promise" value="我再上四个我就是狗"><br><br>
            辅导师兄：     <input type="text" name="teach_bro" value="舞厅鸭Bill"><br><br>
            何处了解修真院：<input type="text" name="know_us_from" value="知乎"><br><br>
            创建时间：     <input type="text" name="create_at" value="1533713315"><br><br>
            最后更新时间：  <input type="text" name="update_at" value="1533714545"><br><br>

            <input type="submit" value="增加学生信息">
        </form>
    </div>

</div>

    <form id="form_delete" action="" method="POST">
        <input type="hidden" name="_method" value="DELETE">
    </form>

</body>
</html>



