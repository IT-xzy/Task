<%--
  Created by IntelliJ IDEA.
  User: thinkpad
  Date: 2018/4/15
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>进入异时空了</title>
</head>
<body>
<br/><br/><br/><br/><br/><br/>
<p align="center" size="6"><font color="red" ><strong>输入信息有误，请确认姓名是否重复，战斗力等是否在范围内</strong></font> </p>
<br/><br/><br/>
<div align="center">
    <form  action="${pageContext.request.contextPath}/task2/list" style="display: inline" method="get">
        <input type="submit" value="返回主页">
    </form>
</div><br/><br/><br/>
<div align="center"><img src="../../image/1.jpg"/></div>
<jsp:include page="footer.jsp" >
    <jsp:param  name="year" value="2018" />
</jsp:include>

</body>
</html>
