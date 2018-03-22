<%--
  Created by IntelliJ IDEA.
  User: dwk
  Date: 2018/3/10
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学员报名</title>
</head>
<body>
    <h1 align="center">学员报名</h1>
    <br>
    <br>

    <form method="post" action="${pageContext.request.contextPath}/s/students">
        <table align="center" border="1" width="60%">
            <tr>
                <th align="center" colspan="2">修真院学员注册</th>
            </tr>
            <tr>
                <td>姓名</td> <%--name属性与实体类属性相对应，只有设置了 name 属性的表单元素才能在提交表单时传递它们的值。--%>
                <td><input id="name" name="stuName" value="" type="text" placeholder="请输入姓名"></td>
            </tr>
            <tr>
                <td>QQ</td>
                <td><input id="QQ" name="QQ" value="" type="text" placeholder="请输入QQ账号"></td>
            </tr>
            <tr>
                <td>修真类型</td>
                <td><input id="lessonType" name="lessonType" value="" type="text" placeholder="1代表web，2代表java"></td>
            </tr>
            <tr>
                <td>预计入学时间</td>
                <td><input id="admissionTime" name="admissionTime" type="datetime" placeholder="2018-03-09"></td>
            </tr>
            <tr>
                <td>毕业院校</td>
                <td><input id="graduatedSchool" name="graduatedSchool" value="" type="text" placeholder="请输入你的毕业院校"></td>
            </tr>
            <tr>
                <td>线上学号</td>
                <td><input id="stuNumber" name="stuNumber" value="" type="text" placeholder="请输入你的线上学号"></td>
            </tr>
            <tr>
                <td>日报链接</td>
                <td><input id="diaryLink" name="diaryLink" value="" type="text" placeholder="请贴上你的日报链接"></td>
            </tr>
            <tr>
                <td>入学立愿</td>
                <td><input id="wish" name="wish" value="" type="text" placeholder="立下自己的学习誓言吧！"></td>
            </tr>
            <tr>
                <td>辅导师兄</td>
                <td><input id="brotherId" name="brotherId" value="" type="text" placeholder="输入你的辅导师兄的ID"></td>
            </tr>
            <tr>
                <td>你是从何处了解到修真院？</td>
                <td><input id="heardFrom" name="heardFrom" value="" type="text" placeholder="你是从何处了解到修真院？"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button>提   交</button></a>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
