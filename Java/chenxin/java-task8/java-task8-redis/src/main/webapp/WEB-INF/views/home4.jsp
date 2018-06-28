<%@page contentType="text/html;charset=utf-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib prefix="date" uri="test/dateTest" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <div class="body">
            <c:if test="${empty signedUser}">
                <div align="center">
                    <p>
                        当前还没有报名课程。<br>
                        快去<a href="/u/signin">报名</a> 吧，选择一个职业，加入修真院，找个师兄，带你入门。
                    </p>
                </div>
            </c:if>
            <c:if test="${!empty signedUser.course}">
                <div align="center">
                        ${signedUser.name}的个人主页<br>
                        <%--${signedUser.username}<br>--%>
                            <br>
                    所学课程：${signedUser.course}
                </div>
                <div align="left">
                    <img src="${signedUser.image}">
                    <form:form action="/u/uploadImage" method="post" enctype="multipart/form-data">
                        <input type="file" name="pic" id="pic">
                        <input type="submit" value="确认">
                    </form:form>
                </div>
            </c:if>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>