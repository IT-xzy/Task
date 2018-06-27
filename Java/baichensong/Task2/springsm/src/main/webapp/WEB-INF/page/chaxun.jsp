<%--
  Created by IntelliJ IDEA.
  User: baich
  Date: 2018/5/5
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<html>
<head>
    <title>Title</title>
    <style type="text/css">
        #hezi{margin: 36px 90px;border: black 1px solid;background-color: #92e4ff
        }
        #hezi h3{text-align: center; }
        #hezi input{ border: red 1px solid;margin: 10px 5px;}
        .ca{ margin:5px auto;font-size: 25px }
        #chaxun a{color:mediumorchid;}
        .cha{color:red;}

    </style>

</head>
<body>

<!--显示数据库所有信息-->
<table align="center" border="1px" cellspacing="0">
    <caption class="ca">当前显示查询数据</caption>

    <tr>
        <td>id</td>
        <td>name</td>
        <td>qq</td>
        <td>kemu</td>
        <td>startTime</td>
        <td>school</td>
        <td>xuehao</td>
        <td>ribao</td>
        <td>xinyuan</td>
        <td>shixiong</td>
        <td>创建时间</td>
        <td>修改时间</td>
        <td>修改</td>
        <td>删除</td>
    </tr>

    <!--查询的遍历-->
    <c:forEach items="${by}" var ="b">
        <tr>
            <td>${b.id}</td>
            <td>${b.name}</td>
            <td>${b.qq}</td>
            <td>${b.kemu}</td>
            <td>${b.startTime}</td>
            <td>${b.school}</td>
            <td>${b.xuehao}</td>
            <td>${b.ribao}</td>
            <td>${b.xinyuan}</td>
            <td>${b.shixiong}</td>

            <td>
                <!--解决jsp 接受Timestamp 有时间差的时区问题-->
                <fmt:setTimeZone value="GMT+"/>

                <!-- sql.timestamp 和java timestamp  进行转接。jsp时间格式化-->
                <fmt:formatDate value="${b.created_at}" pattern="yyyy-MM-dd HH:mm:ss" />
            </td>
            <td>
                <fmt:setTimeZone value="GMT+"/>
                <fmt:formatDate value="${b.updated_at}"  pattern="yyyy-MM-dd HH:mm:ss" />
            </td>
            <td><a href="/chen?id=${b.id}">编辑</a></td>

            <td><a href="/song?id=${b.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>


<!--增加数据  使用的编辑器-->
<div id="hezi">
    <h3>添加数据</h3>
    <form action="${pageContext.request.contextPath }/bai/main" method="POST">
        <!-- POST的form, 通过隐藏的input传-->
        <input name="_method" type="hidden" value="put" />
        名字: <input type="text" name="name">
        QQ:<input type="text" name="qq" />
        科目:<input type="text" name="kemu"/>
        入学时间: <input type="text" name="startTime"/>
        学校: <input type="text" name="school"/>
        学号: <input type="text" name="xuehao"/>
        日报: <input type="text" name="ribao"/>
        心愿: <input type="text" name="xinyuan"/>
        师兄: <input type="text" name="shixiong">

        <input type="submit" value="提交" />
    </form>


    <!--按姓名或学号查询-->
    <div id="chaxun">
        <form action="${pageContext.request.contextPath}/find" method="post">
            </p>输入姓名查询</p><input type="text" name="name"/>
            <input type="submit" value="查询">
            <a href="/list">》》查看所有数据</a>
            <a href="/sumbit">》》用axja增加数据</a>

        </form>
    </div>
</div>



</body>
</html>