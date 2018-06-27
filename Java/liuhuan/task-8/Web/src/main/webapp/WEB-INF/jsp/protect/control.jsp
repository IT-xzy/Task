<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2018/4/28
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- 解决 JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS --%>
<%@ page isErrorPage="true" %>

<%-- 添加一个自定义tags, 将long类型的时间转为固定格式输出 --%>
<%@ taglib uri="/tags" prefix="date" %>

<body>
<%-- 登陆模块 --%>
<c:if test="${cookie.username.value!=null }">
    当前用户:<%!String username = "not user"; %>
    <%
        Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("username")) {
                username = cookies[i].getValue();
                break;
            }
        }
    %>
    <%=URLDecoder.decode(username) %>

    |<a href="${pageContext.request.contextPath }/logout">退出</a> | <a href="${pageContext.request.contextPath }/">返回首页</a>
    <hr>
</c:if>

<%-- 错误信息 --%>
<c:if test="${allErrors!=null}">
    <c:forEach items="${allErrors}" var="error">
        <font color="red">${error.defaultMessage}</font><br/>
    </c:forEach>
</c:if>
<%-- 查询模块 --%>
<form action="${pageContext.request.contextPath}/admin/students" method="GET">
    <fieldset>
        <legend>查询条件</legend>
        <table width="100%"
               style="table-layout:fixed;word-break:break-all;background:#f2f2f2">
            <tr id="name">
                <td>id</td>
                <td>用户名称</td>
                <td>邮箱</td>
                <td>邮箱激活状态</td>
                <td>手机号码</td>
                <td>QQ</td>
                <td>修真类型</td>
                <td>入学时间</td>
                <td>毕业院校</td>
                <td>线上id</td>
                <td>日报连接</td>
                <td>立愿</td>
                <td>优秀学员</td>
                <td>辅导师兄</td>
                <td>是否工作</td>
                <td>头像地址</td>
                <td>个人头衔</td>
                <td>创建时间</td>
                <td>更新时间</td>
                <td>创建人</td>
                <td>更新人</td>
                <td>操作</td>
            </tr>
            <tr>
                <td><input name="studentCustom.id" type="number"
                           value="${findUserCustom.id}"/>
                </td>
                <td><input name="studentCustom.stuName"
                           value="${findUserCustom.stuName}"></td>
                <td><input name="studentCustom.stuMail"
                           value="${findUserCustom.stuMail}"></td>
                <td><input name="studentCustom.stuMailState"
                           value="${findUserCustom.stuMailState}"></td>
                <td><input name="studentCustom.stuTelephone"
                           value="${findUserCustom.stuTelephone}"></td>
                <td><input name="studentCustom.stuQq" type="number"
                           value="${findUserCustom.stuQq}">
                </td>
                <td><input name="studentCustom.stuProfession"
                           value="${findUserCustom.stuProfession}"></td>

                <%-- findstudentCustom.join_date 为0时,不加value, 后端可以加判断,为空时返回空字符串 --%>
                <%--<c:choose>
                    <c:when test="${findstudentCustom.join_date != 0}">
                        <td><input name="studentCustom.join_date" value='<date:date value="${findstudentCustom.join_date}"/>'></td>
                    </c:when>
                    <c:otherwise>
                        <td><input name="studentCustom.join_date"></td>
                    </c:otherwise>
                </c:choose>--%>
                <td><input name="studentCustom.join_date"
                           value='<date:date value="${findUserCustom.join_date}"/>'>
                </td>
                <td><input name="studentCustom.stuSchool"
                           value="${findUserCustom.stuSchool}"></td>
                <td><input name="studentCustom.online_id"
                           value="${findUserCustom.online_id}"></td>
                <td><input name="studentCustom.daily_url"
                           value="${findUserCustom.daily_url}"></td>
                <td><input name="studentCustom.declaration"
                           value="${findUserCustom.declaration}"></td>
                <td><input name="studentCustom.isSuper"
                           value="${findUserCustom.isSuper}"></td>
                <td><input name="studentCustom.counselor"
                           value="${findUserCustom.counselor}"></td>
                <td><input name="studentCustom.isWork"
                           value="${findUserCustom.isWork}"></td>
                <td><input name="studentCustom.headurl"
                           value="${findUserCustom.headurl}"></td>
                <td><input name="studentCustom.stuTitle"
                           value="${findUserCustom.stuTitle}"></td>
                <td><input name="studentCustom.create_time"
                           value='<date:date value="${findUserCustom.create_time}"/>'>
                </td>
                <td><input name="studentCustom.update_time"
                           value='<date:date value="${findUserCustom.update_time}"/>'>
                </td>
                <td><input name="studentCustom.create_by"
                           value="${findUserCustom.create_by}"></td>
                <td><input name="studentCustom.update_by"
                           value="${findUserCustom.update_by}"></td>

                <td><input type="submit" value="查询"/></td>
            </tr>
        </table>
    </fieldset>
</form>

<%-- 添加模块 --%>
<form name="usersFrom" action="${pageContext.request.contextPath}/admin/student/"
      method="post">
    <fieldset>
        <legend>添加用户</legend>
        <table width="100%"
               style="table-layout:fixed;word-break:break-all;background:#f2f2f2">
            <tr id="name2">
                <td>用户名称</td>
                <td>个人头衔</td>
                <td>邮箱</td>
                <td>手机号码</td>
                <td>QQ</td>
                <td>修真类型</td>
                <td>入学时间</td>
                <td>毕业院校</td>
                <td>线上id</td>
                <td>日报连接</td>
                <td>立愿</td>
                <td>优秀学员</td>
                <td>辅导师兄</td>
                <td>是否工作</td>
                <td>头像地址</td>
                <td>操作</td>
            </tr>
            <tr>
                <td><input name="stuName" value="${studentCustom.stuName}"></td>

                <td><input name="stuTitle" value="${studentCustom.stuTitle}">
                </td>
                <td><input name="stuMail" value="${studentCustom.stuMail}">
                </td>
                <td><input name="stuTelephone" type="number" value="${studentCustom.stuTelephone}">
                </td>
                <td><input name="stuQq" type="number" value="${studentCustom.stuQq}">
                </td>
                <td><input name="stuProfession" value="${studentCustom.stuProfession}">
                </td>
                <td><input name="join_date" value="<date:date value ="${studentCustom.join_date}"/>">
                </td>
                <td><input name="stuSchool" value="${studentCustom.stuSchool}"></td>
                <td><input name="online_id" value="${studentCustom.online_id}">
                </td>
                <td><input name="daily_url" value="${studentCustom.daily_url}">
                </td>
                <td><input name="declaration" value="${studentCustom.declaration}">
                </td>
                <td><input name="isSuper" value="${studentCustom.isSuper}">
                </td>
                <td><input name="counselor" value="${studentCustom.counselor}">
                </td>
                <td><input name="isWork" value="${studentCustom.isWork}">
                </td>
                <td><input name="headurl" value="${studentCustom.headurl}">
                </td>
                <td><input type="submit" value="添加"/></td>
            </tr>
        </table>
    </fieldset>
</form>

<%-- 显示模块 --%>
<fieldset>
    <legend>用户列表</legend>
    <table width="100%" border=1>
        <tr>
            <td>头像</td>
            <td>id</td>
            <td>用户名称</td>
            <td>邮箱</td>
            <td>邮箱状态</td>
            <td>手机号码</td>
            <td>QQ</td>
            <td>修真类型</td>
            <td>入学时间</td>
            <td>毕业院校</td>
            <td>线上id</td>
            <td>日报连接</td>
            <td>立愿</td>
            <td>优秀学员</td>
            <td>辅导师兄</td>
            <td>是否工作</td>
            <td>头像地址</td>
            <td>个人头衔</td>
            <td>创建时间</td>
            <td>更新时间</td>
            <td>创建人</td>
            <td>更新人</td>
            <td>操作</td>
        </tr>
        <%-- 调用modelAndView传过来的map,再找其中id为userList的--%>
        <c:forEach items="${userCustomList}" var="studentCustom">
            <tr>
                <td><img src="${studentCustom.headurl}-icon" width="50" height="50" onerror="this.src='${pageContext.request.contextPath }/static/images/687.png'"></td>
                <td>${studentCustom.id}</td>
                <td>${studentCustom.stuName }</td>
                <td>${studentCustom.stuMail }</td>
                <td>${studentCustom.stuMailState}</td>
                <td>${studentCustom.stuTelephone }</td>
                <td>${studentCustom.stuQq }</td>
                <td>${studentCustom.stuProfession }</td>
                <td><date:date value="${studentCustom.join_date} "/></td>
                <td>${studentCustom.stuSchool}</td>
                <td>${studentCustom.online_id }</td>
                <td>${studentCustom.daily_url }</td>
                <td>${studentCustom.declaration}</td>
                <td>${studentCustom.isSuper}</td>
                <td>${studentCustom.counselor}</td>
                <td>${studentCustom.isWork}</td>
                <td>${studentCustom.headurl}</td>
                <td>${studentCustom.stuTitle}</td>
                <td><date:date value="${studentCustom.create_time} "/></td>
                <td><date:date value="${studentCustom.update_time} "/></td>
                <td>${studentCustom.create_by}</td>
                <td>${studentCustom.update_by}</td>
                <td>
                    <a href="${pageContext.request.contextPath }/admin/student/${studentCustom.id}">修改</a>
                    <a href="" onclick="sendBtn(${studentCustom.id})">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</fieldset>
</body>
<script type="text/javascript">
    /* 根据返回值弹出不同信息 */
    function sendBtn(id) {
        var url = '${pageContext.request.contextPath }/admin/student/' + id;
        /*得到href的值*/
        $.ajax({
            url: url, /*url也可以是json之类的文件等等*/
            type: 'DELETE', /*DELETE、POST */
            success: function (result) {
                //判断result结果
                if (result) {
                    alert("id: " + id + "删除成功,即将返回列表页");
                    window.location.reload();
                } else {
                    alert("id: " + id + " 删除失败");
                }
            }
        });
    }
</script>
