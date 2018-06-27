<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="false" %>
<html>
<head>
    <title>更新报名信息</title>
</head>
<body>
<h1 align="center">更新报名信息</h1>
<br>
<br>

<form method="post" action="${pageContext.request.contextPath}/s/students/${student.id}">
    <table align="center" border="1" width="60%">
        <tr>
            <th align="center" colspan="2">修真院学员注册</th>
        </tr>
        <tr>
            <td>姓名</td> <%--name属性与实体类属性相对应，只有设置了 name 属性的表单元素才能在提交表单时传递它们的值。--%>
            <td><input id="name" name="stuName" value="${student.stuName}" type="text"></td>
        </tr>
        <tr>
            <td>QQ</td>
            <td><input id="QQ" name="QQ" value="${student.QQ}" type="text"></td>
        </tr>
        <tr>
            <td>修真类型</td>
            <td><input id="lessonType" name="lessonType" value="${student.lessonType}" type="text"></td>
        </tr>
        <tr>
            <td>预计入学时间</td>
            <td><input id="admissionTime" name="admissionTime" type="datetime" value="${student.admissionTime}"></td>
        </tr>
        <tr>
            <td>毕业院校</td>
            <td><input id="graduatedSchool" name="graduatedSchool" value="${student.graduatedSchool}" type="text"></td>
        </tr>
        <tr>
            <td>线上学号</td>
            <td><input id="stuNumber" name="stuNumber" value="${student.stuNumber}" type="text"></td>
        </tr>
        <tr>
            <td>日报链接</td>
            <td><input id="diaryLink" name="diaryLink" value="${student.diaryLink}" type="text"></td>
        </tr>
        <tr>
            <td>入学立愿</td>
            <td><input id="wish" name="wish" value="${student.wish}" type="text"></td>
        </tr>
        <tr>
            <td>辅导师兄</td>
            <td><input id="brotherId" name="brotherId" value="${student.brotherId}" type="text"></td>
        </tr>
        <tr>
            <td>你是从何处了解到修真院？</td>
            <td><input id="heardFrom" name="heardFrom" value="${student.heardFrom}" type="text"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
               <input type="hidden" name="_method" value="PUT">
                <input type="submit" value="确认更新">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
