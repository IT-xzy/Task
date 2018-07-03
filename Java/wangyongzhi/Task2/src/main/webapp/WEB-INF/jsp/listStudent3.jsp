<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>


<p style="color:#FF00FF ;font-size:32px;text-align: center;top: auto">修真院学生资料
</p>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!--第一步：借助于JQuery将超链接请求的方式从get改为post方式，引入jquery-->
<!--用jsp引入绝对路径方法引入jquery文件-->
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-1.8.3.min.js"></script>

<script type="text/javascript">
    $(function () {
        //为所有的class为delete的按钮点击动作添加行为函数
        $(".delete").click(function () {
            //获取class为delete的超链接的地址
            var href = $(this).attr("href");
            //为隐藏域的action赋值并提交,！！！！！！注意符号
            $("#formdelete").attr("action", href).submit();
            return false;
        })
    })
</script>

<!--第二步：创建含有隐藏域的表单请求-->
<form id="formdelete" action="" method="POST" >
    <!--这里的name必须是_method，value的值就是要转成的新的请求方式，如果
    没有SpringMVC的delete方式，可以忽略这一行，直接写一个空表单即可-->
    <input type="hidden" name="_method" value="DELETE">
</form>


<div style="width:1400px;margin:0px auto;text-align:center">
    <table border="1">
        <tr>
            <td style="width:5%">lineId</td>
            <td style="width:5%">name</td>
            <td style="width:8%">QQ</td>
            <td style="width:5%">type</td>
            <td style="width:10%">enrolmentTime</td>
            <td style="width:9%">graduate</td>
            <td style="width:10%">reportLink</td>
            <td style="width:10%">wish</td>
            <td style="width:9%">senior</td>
            <td style="width:7%">howKnow</td>
            <td style="width:8%">createAt</td>
            <td style="width:8%">updateAt</td>
            <td style="width:3%">更新</td>
            <td style="width:3%">删除</td>
        </tr>

        <c:forEach items="${studentList}" var="student" varStatus="st">
            <tr>
                <td>${student.lineId}</td>
                <td>${student.name}</td>
                <td>${student.QQ}</td>
                <td>${student.type}</td>
                <td>${student.enrolmentTime}</td>
                <td>${student.graduate}</td>
                <td>${student.reportLink}</td>
                <td>${student.wish}</td>
                <td>${student.senior}</td>
                <td>${student.howKnow}</td>
                <td>${student.createAt}</td>
                <td>${student.updateAt}</td>

                    <%--此处为了在controller中的student能接到参数，必须student的对象数据成员名--%>
                <td><a href="listStudent3/${student.lineId}">更新</a></td>

                <!--第三步：为超链接添加class属性，根据class改变其请求方式-->
                <td><a class="delete" href="listStudent3/${student.lineId}">删除</a></td>
            </tr>
        </c:forEach>
    </table>

    <table style="text-align:center">
        <a href="?start=0">首 页</a>
        <a href="?start=${page.start-page.count}">上一页</a>
        <a href="?start=${page.start+page.count}">下一页</a>
        <a href="?start=${page.last}">末 页</a>
    </table>

</div>

<div style="text-align:center;margin-top:40px">
    <form method="post" action="/listStudent3" accept-charset="UTF-8">

        <%--增加如下filed, 虽然这个form的method是post, 但是springmvc看到这个_method的值是put后，会把其修改为put.--%>
        <%--同理，delete也可以实现--%>
        <input type="hidden" name="_method" value="PUT">

        学生学号：<input name="lineId" value="${student.lineId}" type="text"> <br><br>
        学生名称： <input name="name" value="${student.name}" type="text"> <br><br>
        学生QQ: <input name="QQ" value="${student.QQ}" type="text"> <br><br>
        学习类型：<input name="type" value="${student.type}" type="text"> <br><br>
        毕业时间: <input name="enrolmentTime" value="${student.enrolmentTime}" type="text"> <br><br>
        毕业学校：<input name="graduate" value="${student.graduate}" type="text"> <br><br>
        日报链接：<input name="reportLink" value="${student.reportLink}" type="text"> <br><br>
        立誓: <input name="wish" value="${student.wish}" type="text"> <br><br>
        师兄: <input name="senior" value="${student.senior}" type="text"> <br><br>
        从何处得知: <input name="howKnow" value="${student.howKnow}" type="text"> <br><br>
        创建时间: <input name="createAt" value="${student.createAt}" type="text"> <br><br>
        更新时间: <input name="updateAt" value="${student.updateAt}" type="text"> <br><br>


        <input type="submit" value="增加学生" onclick='return confirm("确认要增加么?");'>
    </form>
</div>

<div style="text-align:center;margin-top:40px">
    <form method="post" action="/listStudent3/lineId" accept-charset="UTF-8">
        学生ID： <input name="id" value="lineId" type="text"> <br><br>
        <input type="submit" value="查询学生">
    </form>
</div>
</div>




<td><a href="student/jsontest" onclick='return confirm("真的要点进去么");'>点这里有惊喜</a></td>

<%@include file="footer.jsp" %>