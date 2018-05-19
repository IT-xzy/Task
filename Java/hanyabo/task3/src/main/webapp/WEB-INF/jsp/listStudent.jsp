<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%--
    delete方法必须注意的三点
    1.引用的js文件必须正确
    2.函数内部的变量名必须正确
    3.隐藏于必须位于正确的位置
--%>

<%--1.引用的js文件必须正确--%>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.0.0.min.js"></script>

<script type="text/javascript">
    /*将post method 改变为delete*/
    $(function() {
        $(".delete").click(function(){
            var href = $(this).attr("href");
            //2.formdelete不对 应该是form
            $("form").attr("action",href).submit();
            return false;
        })
    });
</script>

<head>
    <style>
        #header {
            background-color:black;
            color:white;
            text-align:center;
            padding:5px;
        }

        #nav {
            line-height:30px;
            background-color:#eeeeee;
            height:720px;
            width:1200px;
            float:left;
            padding:5px;
        }


        #section {
            width:300px;
            height:720px;
            float:left;
            padding:5px;
        }

        #footer {
            background-color:black;
            color:white;
            clear:both;
            text-align:center;
            padding:5px;
        }
    </style>
</head>


<body>

<div id="header">
    <h1>Student Manage System jetty</h1>
</div>

<div id="nav">
    <table width="1200" align='left' border='1' cellspacing='0'>
        <tr>
            <td>id</td><td>分院</td><td>等级</td><td>课程</td>
            <td>名字</td><td>QQ</td><td>学习方向</td><td>入学时间</td>
            <td>毕业院校</td><td>学号</td><td>日报链接</td><td>立愿</td>
            <td>师兄</td><td>来源</td><td>创建时间</td><td>更新时间</td>
            <td>编辑</td><td>删除</td>
        </tr>
        <c:forEach items="${students}" var="student" varStatus="st">
            <tr>
                <td>${student.id}</td>
                <td>${student.location}</td>
                <td>${student.level}</td>
                <td>${student.lesson}</td>
                <td>${student.name}</td>
                <td>${student.qq}</td>
                <td>${student.job}</td>
                <td>${student.startTime}</td>
                <td>${student.university}</td>
                <td>${student.number}</td>
                <td>${student.link}</td>
                <td>${student.target}</td>
                <td>${student.brother}</td>
                <td>${student.source}</td>
                <td>${student.createAt}</td>
                <td>${student.updateAt}</td>
                <td><a href="student/${student.id}">编辑</a></td>
                <td><a class="delete" href="student/${student.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <div style="text-align:center">
        <a href="?start=0">首  页</a>
        <a href="?start=${studentpage.previous}">上一页</a>
        <a href="?start=${studentpage.next}">下一页</a>
        <a href="?start=${studentpage.last}">末  页</a>
    </div>
</div>

<div id="section">
    <%--<div style="text-align:center;margin-top:40px">--%>
        <form method="post" action="student">
            <input type="hidden" name="_method" value="PUT">
            分院 :<input name="location" value="1" type="text"> <br><br>
            等级 :<input name="level" value="2" type="text"> <br><br>
            课程 :<input name="lesson" value="3" type="text"> <br><br>
            名字 :<input name="name" value="夏雨雪" type="text"> <br><br>
            QQ :<input name="qq" value="321321321" type="text"> <br><br>
            学习方向:<input name="job" value="Java" type="text"> <br><br>
            入学时间:<input name="startTime" value="123456789" type="text"> <br><br>
            毕业院校:<input name="university" value="五道口大学" type="text"> <br><br>
            学号:<input name="number" value="22222" type="text"> <br><br>
            日报链接:<input name="link" value="http://www.baidu.com" type="text"> <br><br>
            立愿:<input name="target" value="一屋不扫，何以扫天下" type="text"> <br><br>
            辅导师兄:<input name="brother" value="东方木" type="text"> <br><br>
            来源:<input name="source" value="知乎" type="text"> <br><br>
            创建时间:<input name="createAt" value="987654321" type="text"> <br><br>
            更新时间:<input name="updateAt" value="9876543210" type="text"> <br><br>
            <input type="submit" value="增加学生">
        </form>
    <%--</div>--%>
</div>

<div id="footer">
    Copyright ? jnshu.com
</div>

</body>


<%--3.隐藏域 必须位于正确的位置--%>
<form id="formdelete" action="" method="POST" >
    <input type="hidden" name="_method" value="DELETE">
</form>

