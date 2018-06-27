<%@ page import="com.jnshu.pojo.Student" %>
<%@ page contentType="text/html;charset=UTF-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="/tags2"  prefix="date" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%--<json:object>--%>
    <%--<json:array name="studentList" var="" items="${studentList.lineItems}">--%>
        <%--<json:object>--%>
            <%--<json:property name="title" value="${item.title}"/>--%>
            <%--<json:property name="description" value="${item.description}"/>--%>
            <%--<json:property name="imageUrl" value="${item.imageUrl"/>--%>
            <%--<json:property name="price" value="${item.price}"/>--%>
            <%--<json:property name="qty" value="${item.qty}"/>--%>
        <%--</json:object>--%>
    <%--</json:array>--%>
<%--</json:object>--%>
<html>
<head>
    <title>学生表单</title>
    <script type="text/javascript" src="jquery-1.4.4.min.js"></script>
    <script type="text/javascript">
        function sendBtn(id) {
            var url = '/stus?id=' + id;/*得到href的值*/
            $.ajax({
                url:url,/*url也可以是json之类的文件等等*/
                type:'DELETE',/*DELETE、POST */
                success:function (result) {
                    //判断result结果
                    if(result){
                        alert("id: " + id + "删除成功,即将返回列表页")
                        window.location.reload();
                    }else{
                        alert("id: " + id + " 删除失败")
                    }
                }
            });
        }
    </script> 绑定a绑定方法
</head>
<body>
<fieldset>
<a href="<c:url value="/addStu"/>">添加</a>
</fieldset>
<%--${pageContext.request.contextPath}是绝对路径--%>
<form action="${pageContext.request.contextPath }/stu" method="get">
            <label for="name">姓名：</label>
                <input id="name" name="name">
            <input type="submit" value="查询"/>
</form>
<table width="100%" border=1>
    <thead>
    <tr>
        <td>ID</td>
        <td>用户名</td>
        <td>QQ</td>
        <td>入学时间</td>
        <td>学习类型</td>
        <td>学号</td>
        <td>立愿</td>
        <td>删除</td>
        <td>修改</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${studentList}" var="infos">
    <tr>
        <td> ${infos.id}</td>
        <td>${infos.name }</td>
        <td>${infos.qq}</td>
        <td><date:date value ="${infos.enrolment_time} "/></td>
        <td>${infos.learning_type}</td>
        <td>${infos.number}</td>
        <td>${infos.desire}</td>

        <td><a href="${pageContext.request.contextPath}" onclick="sendBtn(${infos.id})" >删除</a>
        </td>
        <td><a href="/editStu?id=${infos.id}">edit</a> </td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
