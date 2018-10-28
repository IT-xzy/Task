<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: suger
  Date: 2018/10/3
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html charset=UTF-8">
    <title>修改学生信息</title>
    <style>
        label {display:inline-block; width: 10em; margin-right: 1em; text-align: right; }
    </style>

</head>
<body>
<form action="${pageContext.request.contextPath}/student" method="post">
    <!-- 将POST请求转化为PUT请求 -->
    <input type="hidden" name="_method" value="PUT"/>
    <input type="hidden" name="id" value="${s.id}"/>
    <input type="hidden" name="startTime" value="${s.startTime}"/>
    <input type="hidden" name="createAt" value="${s.createAt}">
    <input type="hidden" name="updateAt" value="<%=System.currentTimeMillis()%>"/>

   <%--
     required 属性 要求必填或者必选，是html5的新特性·
     oninvalid="this.setCustomValidity('请输入姓名')" ------在字段无效时显示自定义消息
    oninput="setCustomValidity('')"---------------------- 删除经过验证的字段上的invalidate消息--%>

    <label>姓名：</label><input type="text" name="name" value="${s.name}" required=""
                             oninvalid="this.setCustomValidity('姓名不能为空')" oninput="setCustomValidity('')"/>
    <br/>
    <label>QQ：</label><input type="text" name="qq" value="${s.qq}" required="" maxlength="15"
                             oninvalid="this.setCustomValidity('qq不能为空')" oninput="setCustomValidity('')"/>
    <br/>
    <label>修真类型：</label><input type="text" name="profession" value="${s.profession}" required=""
                               oninvalid="this.setCustomValidity('修正类型不能为空')" oninput="setCustomValidity('')"/>
    <br/>
    <label>毕业院校：</label><input type="text" name="graduatedFrom" value="${s.graduatedFrom}" required=""
                               oninvalid="this.setCustomValidity('毕业院校不能为空')" oninput="setCustomValidity('')"/>
    <br/>
    <label>学号：</label><input type="number" name="onlineId" value="${s.onlineId}" min="1" max="2147483647"  required=""/>
    <br/>
    <label>日报连接：</label><input type="test" name="dailyLink" value="${s.dailyLink}" required=""
                               oninvalid="this.setCustomValidity('日报链接不能为空')" oninput="setCustomValidity('')"/>
    <br/>
    <label>立愿：</label><input type="text" name="wish" value="${s.wish}" required=""
                             oninvalid="this.setCustomValidity('立愿不能为空')" oninput="setCustomValidity('')"/>
    <br>
    <label>辅导师兄：</label><input type="text" name="counselor" value="${s.counselor}" required=""
                               oninvalid="this.setCustomValidity('辅导师兄不能为空')" oninput="setCustomValidity('')"/>
    <br/>
    <label>从哪里知道修真院：</label><input type="text" name="way" value="${s.way}" required=""
                                   oninvalid="this.setCustomValidity('了解途径不能为空')" oninput="setCustomValidity('')"/>
    <br/>
    <label></label><input type="submit" name="ok" value="确认修改"/>

</form>
</body>
</html>
