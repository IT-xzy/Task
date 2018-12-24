<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    label {display:inline-block; width: 10em; margin-right: 1em; text-align: right; }
</style>

<form action="${pageContext.request.contextPath}/u/student" method="post">
    <!-- 将POST请求转化为PUT请求 -->
    <input type="hidden" name="_method" value="PUT"/>
    <input type="hidden" name="id" value="${s.id}"/>
    <input type="hidden" name="createAt" value="${s.createAt}">
    <input type="hidden" name="updateAt" value="<%=System.currentTimeMillis()%>"/>

    <label>用户名：</label><input type="text" name="name" value="${s.name}" required=""/>
    <br/>

    <label>职位：</label><input type="text" name="position" value="${s.position}" required=""/>
    <br/>
    <label>职业：</label><input type="text" name="profession" value="${s.profession}" required=""/>
    <br/>
    <label>简介：</label><input type="text" name="intro" value="${s.intro}" required=""/>
    <br/>
    <label></label><input type="submit" name="ok" value="确认修改" required=""/>

</form>