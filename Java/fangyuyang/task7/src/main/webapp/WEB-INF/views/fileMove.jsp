<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2018/5/30
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body>
<body>

<div style="width:640px;background-color:#333;margin:0 auto;">

    <div style="width:50%;height:500px;background-color:#e5ffca;float:left;">
        <div style="width:100%;text-align:center">
        <table border="1" cellpadding="10" cellspacing="0">

<form>
    <tr>
        <th>七牛图片</th>
    </tr>
 <c:forEach items="${qiniu}" var="picture">
    <tr>
        <th>${picture}</th>
    </tr>

    </c:forEach>
</form>
        </table>
            <form action="${pageContext.request.contextPath}/moveToAli" method="post">
                <input type="submit" value="文件迁移">
            </form>
        </div>
    </div>

    <div style="width:50%;height:500px;background-color:#f9d1ff;float:left;">
        <div style="width:100%;text-align:center">
        <table border="1" cellpadding="10" cellspacing="0">
            <form>
                <tr>
                    <th>百度图片</th>
                </tr>
                <c:forEach items="${ali}" var="picture">
                    <tr>
                        <th>${picture}</th>
                    </tr>

                </c:forEach>
            </form>
        </table>
            <form action="${pageContext.request.contextPath}/moveToQiniu" method="post">
                <input type="submit" value="文件迁移">
            </form>
        </div>
    </div>

    <div style="clear:both;"></div>

</div>

</body>
</body>

