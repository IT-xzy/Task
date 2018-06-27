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
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>


<!--显示数据库所有信息-->
<table align="center" border="1px" cellspacing="0">
    <caption class="ca">当前显示数据库所有数据</caption>
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
<!--遍历所有数据-->
<c:forEach items="${cs}" var ="c" varStatus="st">
    <tr>
    <td>${c.id}</td>
    <td>${c.name}</td>
    <td>${c.qq}</td>
    <td>${c.kemu}</td>
    <td>${c.startTime}</td>
    <td>${c.school}</td>
    <td>${c.xuehao}</td>
    <td>${c.ribao}</td>
    <td>${c.xinyuan}</td>
    <td>${c.shixiong}</td>

     <td>
<!-- setTimeZone 来设置时区 时间不准问题-->
         <fmt:setTimeZone value="GMT+"/>
<!--JSP用 fmt:formatDate   来格式化日期显示 -->
         <fmt:formatDate value="${c.created_at}" pattern="yyyy-MM-dd HH:mm:ss" type="both" />
     </td>
     <td>
         <fmt:setTimeZone value="GMT+"/>
         <fmt:formatDate value="${c.updated_at}"  pattern="yyyy-MM-dd HH:mm:ss" type="both"/>
     </td>
        <td><a href="/chen?id=${c.id}">编辑</a></td>
<!--js删除-->
        <td><a href="" class="cha" onclick="butt(${c.id})">删除</a></td>
    </tr>
</c:forEach>

</table>

<!--用ajax 来传递delete方法。。-->
<script>
    function butt(id){
        $.ajax({
            type:"DELETE",
            url:"/song?id="+id,
            success: function(){
                alert("删除成功");
            }

        });
    }

</script>




<!--加入分页显示 -->
<div style="text-align:center">
    <a href="?start=0">首  页</a>
<!--加入判断 当start小于4时 禁止向前翻页   以免产生错误-->
    <c:if test="${page.start > 4}">
        <a href="?start=${page.start-page.count}">上一页</a>
    </c:if>

    <a href="?start=${page.start+page.count}">下一页</a>
    <a href="?start=${page.last}">末  页</a>
</div>



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