<%@ include file="../include/include.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="margin-left: 60rem">
    <img src="${usrPic}" alt="">
    <form action="/Tiles/u/upload" method="post" enctype="multipart/form-data">
        <input type="file" name="pic"><br>
        <input type="submit" value="上傳">
    </form>
</div>
<div>
    <h1 style="text-align: center">查找学生</h1>
    <div style="position: relative;margin: 0 auto;width: 30rem">
        <form action="/Tiles/u/student" method="get">
            姓名：<input type="text" name="name"><br>
            QQ：<input type="text" name="qq"><br>
            学号：<input type="text" name="onlineId"><br>
            id：<input type="text" name="id"><br>
            <input type="submit" value="提交">
        </form>
    </div>
    <div>
        <table border="1" align="center" style="width: 100%">
            <tr>
                <td>id</td>
                <td>姓名</td>
                <td>QQ</td>
                <td>修真类型</td>
                <td>入学时间</td>
                <td>毕业院校</td>
                <td>学号</td>
                <td>日报连接</td>
                <td>立愿</td>
                <td>师兄</td>
                <td>了解渠道</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${stuList}" var="stu">
                <tr>
                    <td>${stu.id}</td>
                    <td>${stu.name}</td>
                    <td>${stu.qq}</td>
                    <td>${stu.type}</td>
                    <td>${stu.timeOf}</td>
                    <td>${stu.gradeSchool}</td>
                    <td>${stu.onlineId}</td>
                    <td>${stu.link}</td>
                    <td>${stu.wish}</td>
                    <td>${stu.fellow}</td>
                    <td>${stu.understand}</td>
                    <td>
                        <form action="/Tiles/u/student/${stu.id}" method="post">
                            <input type="hidden" name="_method" value="delete">
                            <input type="submit" value="删除">
                        </form>
                        <form action="/Tiles/u/student/update/${stu.id}" method="post">
                            <input type="submit" value="更新">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a href="/Tiles/u/student/add">添加</a><br>
    </div>
</div>