<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html charset=UTF-8">
    <title>添加学生信息</title>
    <%--统一样式--%>
    <style>
        .a { color: red;  }
        label {display:inline-block; width: 10em; margin-right: 1em; text-align: right; }
    </style>
<body>
<div>
    <form:form modelAttribute="student"  action="${pageContext.request.contextPath}/student" method="post">
        <input type="hidden" name="createAt" value="<%=System.currentTimeMillis()%>">
        <input type="hidden" name="updateAt" value="<%=System.currentTimeMillis()%>">
        <label>姓名：</label><input type="text" name="name" placeholder="姓名长度为2-15"/>
        <br/>
        <label>QQ：</label><input type="text" name="qq" />
        <br/>
        <label>修真类型：</label><input type="text" name="profession"/>
        <br/>
        <label>入学时间：</label><input type="date"  name="startTime"/>
        <br/>
        <label>毕业院校：</label><input type="text" name="graduatedFrom"/>
        <br/>
        <label>学号：</label><input type="text" name="onlineId" min="1" max="9999" placeholder="学号范围必须在1-9999"/>
        <br/>
        <label>日报连接：</label><input type="url" name="dailyLink"/>
        <br/>
        <label>立愿：</label><input type="text" name="wish"/>
        <br>
        <label>辅导师兄：</label><input type="text" name="counselor"/>
        <br/>
        <label>哪里知道修真院：</label><input type="text" name="way"/>
        <br/>
        <label></label><input type="submit" name="ok" value="保存"/><input type="reset" name="r" value="清空">
    </form:form>
</div>

   <%-- <table>
        <tr>
            <td>姓名：</td>
            <td><form:input path="name"/></td>
            <td><form:errors path="name" cssStyle="color: red"/></td>
        </tr>
        <tr>
            <td>QQ：</td>
            <td><form:input path="qq"/></td>
            <td><form:errors path="qq" cssClass="a"/></td>
        </tr>
        <tr>
            <td>修真类型：</td>
            <td><input type="text" name="profession"></td>
        </tr>
        <tr>
            <td>入学时间：</td>
            <td><input type="date"  name="startTime"></td>
        </tr>
        <tr>
            <td>毕业院校：</td>
            <td><input type="text" name="graduatedFrom"></td>
        </tr>
        <tr>
            <td>学号：</td>
            <td><input type="text" name="onlineId" min="1" max="2000"></td>
            <td><form:errors path="onlineId" cssClass="a"/></td>
        </tr>
        <tr>
            <td>日报链接：</td>
            <td><input type="url" name="dailyLink"></td>
        </tr>
        <tr>
            <td>立愿：</td>
            <td><input type="text" name="wish"></td>
        </tr>
        <tr>
            <td>辅导师兄：</td>
            <td><input type="text" name="counselor"></td>
        </tr>
        <tr>
            <td>从哪里知道修真院：</td>
            <td><input type="text" name="way"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" name="ok" value="保存"><input type="reset" name="r" value="清空"></td>
        </tr>
    </table>--%>
</body>
</html>
