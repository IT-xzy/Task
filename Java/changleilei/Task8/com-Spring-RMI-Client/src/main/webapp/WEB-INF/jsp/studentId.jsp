<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
页面一  ${check}
<span class="upperframe"><span></span></span>
<div class="roundframe" id="trad">
    <dl>
        <dt>用户序号:</dt>
        <dd><input type="text" name="id" value="${student.id}" size="40" readonly="readonly"/></dd>
        <dt>用户姓名:</dt>
        <dd><input type="text" name="name" value="${student.name}" size="40" readonly="readonly"/>
        </dd>
        <dt>用户性别:</dt>
        <dd><input type="text" name="sex" value="${student.sex}" size="40" readonly="readonly"/></dd>
        <dt></dt>
        <dd><a href="/students">所有列表</a>&nbsp;</dd>
    </dl>
    <hr/>
    <dl>
        <dd></dd>
    </dl>
</div>
<span class="lowerframe"><span></span></span>
</body>
</html>
