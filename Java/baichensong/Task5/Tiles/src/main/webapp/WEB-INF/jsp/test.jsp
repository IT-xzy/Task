<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="/tags" prefix="date"%>

<table align="center" border="1px" cellspacing="0">
    <caption class="ca">当前显示查询数据</caption>

    <tr>
        <td>id</td>
        <td>name</td>
        <td>introduction</td>
        <td>companyCount</td>
        <td>URL</td>
        <td>title</td>
        <td>xiangqing</td>
        <td>creare_at</td>
        <td>update_at</td>
    </tr>

    <!--查询的遍历-->
    <c:forEach items="${bb}" var="b">
    <tr>
        <td>${b.id}</td>
        <td>${b.name}</td>
        <td>${b.introduction}</td>
        <td>${b.companyCount}</td>
        <td>${b.URL}</td>
        <td>${b.title}</td>
        <td>${b.xiangqing}</td>
        <td><date:date value ="${b.create_at}"/></td>
        <td><date:date value ="${b.update_at}"/></td>
    </tr>
    </c:forEach>
</table>

<div>
    <form action="${pageContext.request.contextPath}/tijiao" method="POST">
        <%--<input type="hidden" name="yicang" value="PUT">--%>
        <input type="text" name="name"/>
        <input type="text" name="introduction"/>
        <input type="text" name="companyCount"/>
        <input type="text" name="URL"/>
        <input type="text" name="title"/>
        <input type="text" name="xiangqing"/>
        <input type="text" name="create_at">
        <input type="text" name="update_at"/>
        <input type="submit" name="提交">
    </form>
</div>
