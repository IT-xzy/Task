<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    label {display:inline-block; width: 10em; margin-right: 1em; text-align: right; }
</style>

<form action="${pageContext.request.contextPath}/u/user" method="post">
    <!-- 将POST请求转化为PUT请求 -->
    <input type="hidden" name="_method" value="PUT"/>
    <input type="hidden" name="id" value="${s.id}"/>
    <input type="hidden" name="createAt" value="${s.createAt}">
    <input type="hidden" name="updateAt" value="<%=System.currentTimeMillis()%>"/>

    <%--
      required 属性 要求必填或者必选，是html5的新特性·
      oninvalid="this.setCustomValidity('请输入姓名')" ------在字段无效时显示自定义消息
     oninput="setCustomValidity('')"---------------------- 删除经过验证的字段上的invalidate消息--%>

    <label>头像·：</label><input type="text" name="img" value="${s.img}"/>
    <br/>
    <label>用户名：</label><input type="text" name="name" value="${s.name}"/>
    <br/>
    <label>用户密码：</label><input type="text" name="pwd" value="${s.pwd}"/>
    <br/>
    <label>QQ：</label><input type="text" name="qq" value="${s.qq}"/>
    <br/>
    <label>邮箱：</label><input type="text" name="email" value="${s.email}"/>
    <br/>
    <label>年龄：</label><input type="text" name="age" value="${s.age}"/>
    <br/>
    <label>立愿：</label><input type="text" name="wish" value="${s.wish}"/>
    <br/>
    <label></label><input type="submit" name="ok" value="确认修改"/>

</form>