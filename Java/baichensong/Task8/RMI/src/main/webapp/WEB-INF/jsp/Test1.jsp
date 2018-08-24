<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="/tags" prefix="date"%>

<!--加入内门的信息显示-->
<body>
<table align="center" border="1" cellspacing="0">

        <img src="http://pb2qkinxf.bkt.clouddn.com/${student.img}"/>
    <tr size="4">
        <td width="300" align="center"><strong>姓名</strong></td>
        <td width="400" alian="center">${student.name}</td>
        <td width="300" align="center"><button type="button"><a href="${pageContext.request.contextPath}/u/goPassword">修改密码</a></button></td>
    </tr>
    <tr>
        <td align="center"><strong>职业</strong></td>
        <td alian="center">${student.zhiye}</td>
        <td align="center"></td>
    </tr>
    <tr>
        <td align="center"><strong>开始时间</strong></td>
        <td alian="center"><date:date value ="${student.startTime} "/></td>
        <td align="center"></td>
    </tr>
    <tr>
        <td align="center"><strong>结业时间</strong></td>
        <td alian="center"><date:date value ="${student.endTime} "/></td>
    </tr>
    <tr>
        <td align="center"><strong>学号</strong></td>
        <td alian="center">${student.studentID}</td>
        <td align="center"></td>
    </tr>
    <tr>
        <td align="center"><strong>在学状态</strong></td>
        <td alian="center">${student.introduction}</td>
        <td align="center"></td>
    </tr>
    <tr>
        <td align="center"><strong>手机号码</strong></td>
        <td alian="center">${student.phone}</td>
        <td align="center"><button type="button"><a href="${pageContext.request.contextPath}/u/a/boundtelephone">绑定修改手机</a></button></td>
    </tr>
    <tr>
        <td align="center"><strong>邮箱</strong></td>
        <td alian="center">${student.email}</td>
        <td align="center"><button type="button"><a href="${pageContext.request.contextPath}/u/a/boundemail">绑定邮箱</a></button></td>
        <td></td>
    </tr>
</table>
</body>