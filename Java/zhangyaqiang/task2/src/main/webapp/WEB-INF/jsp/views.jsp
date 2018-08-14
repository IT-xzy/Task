<%--
  Created by IntelliJ IDEA.
  User: zyq
  Date: 2018/6/10
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page  isELIgnored = "false" contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript" src="/jquery.min.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${empty page.list}">
    数据库中没有学员信息，请添加。
</c:if>
<div align="center">
    <form action="/Students" method="get">
        通过姓名和学号模糊条件查询：
        姓名<input type="text" name="name" id="form0Name">
        学号<input type="text" name="number" id="form0Number">
        <input type="hidden" name="currPage" value="1">
        <button type="submit" onclick="form1()">查询</button>
    </form>
    <c:if test="${!empty page.list}">
        <table align='center' border='1' cellspacing='0'>
            <tr>
                <th align="left" colspan="11">查询到的数据如下（分页查询）:</th>
                <th colspan="2" rowspan="2">操作</th>
            </tr>
            <tr>
                <th>ID</th>
                <th>姓名</th>
                <th>qq</th>
                <th>专业</th>
                <th>毕业院校</th>
                <th>学号</th>
                <th>日报连接</th>
                <th>师兄姓名</th>
                <th>从哪里得知修真院</th>
                <th>创建时间</th>
                <th>更新时间</th>
            </tr>
            <hr>
            <c:forEach items="${page.list}" var="student">
                <tr>
                    <td>${student.id }</td>
                    <td>${student.name }</td>
                    <td>${student.qq }</td>
                    <td>${student.profession }</td>
                    <td>${student.university}</td>
                    <td>${student.number}</td>
                    <td>${student.daily}</td>
                    <td>${student.senior}</td>
                    <td>${student.from}</td>
                    <td>
                        <jsp:useBean id="timestamp5" class="java.util.Date"/>
                        <jsp:setProperty name="timestamp5" property="time" value="${student.createTime}"/>
                        <fmt:formatDate value="${timestamp5}" pattern="yyyy年MM月dd日 HH:mm:ss"/>
                    </td>
                    <td>
                        <jsp:useBean id="timestamp6" class="java.util.Date"/>
                        <jsp:setProperty name="timestamp6" property="time" value="${student.updateTime}"/>
                        <fmt:formatDate value="${timestamp6}" pattern="yyyy年MM月dd日 HH:mm:ss"/>
                    </td>
                    <td><a href="#" id="${student.id}">编辑</a></td>
                    <form action="/student/${student.id}" method="get" class="${student.id}">
                        <input type="hidden" name="currPage" value="${page.currPage}">
                        <script>document.getElementById("${student.id}").onclick=function (){
                            document.getElementsByClassName("${student.id}")[0].submit();}
                        </script>
                    </form>
                    <td>
                        <a href="/student/${student.id}" class="delete">
                            删除
                        </a>
                    </td>
                </tr>
            </c:forEach>

            <tr>
                <th colspan="13">
                    第${page.currPage}页 共${page.totalPage}页
                    <c:if test="${page.currPage!=1}">
                        <a href="/studentS?currPage=1">首页</a>
                        <a href="/studentS?currPage=${page.currPage-1}">上一页</a>
                    </c:if>
                    <c:if test="${page.currPage!=page.totalPage}">
                        <a href="/studentS?currPage=${page.currPage+1}">下一页</a>
                        <a href="/studentS?currPage=${page.totalPage}">末页</a>
                    </c:if>
                </th>
            </tr>
        </table>
    </c:if>
    <h2>添加学员信息</h2>
    <span style="font-size:24px;color:red;">${msg}</span>
    <form action="/student" method="post">
        <input type="text" name="name" placeholder="请输入姓名"><br>
        <input type="text" name="qq" placeholder="请输入qq"><br>
        <input type="text" name="profession" placeholder="请输入专业"><br>
        <input type="text" name="university" placeholder="请输入学校"><br>
        <input type="text" name="number" placeholder="请输入学号"><br>
        <input type="text" name="daily" placeholder="请输入日报连接"><br>
        <input type="text" name="senior" placeholder="请输入师兄姓名"><br>
        <input type="text" name="from" placeholder="请输入从哪里得知修真院"><br>
        <input type="hidden" name="currPage" value="${page.currPage}">
        <button type="submit">提交(插入)</button>
    </form>
</div>
<h2><a href="/index.jsp">返回主页</a></h2>
<form id="delete" action="" method="post">
    <input type="hidden" name="_method" value="DELETE">
    <input type="hidden" name="currPage" value="${page.currPage}">
</form>
</body>
<script>
    $(function () {
        $(".delete").click(function (){
            $("#delete").attr("action",$(this).attr("href")).submit();
            return false;
        })
    })

    function form1(){
        var form = document.getElementsByTagName("form")[0];
        var value1 = document.getElementById("form0Name").value;
        var value2 = document.getElementById("form0Number").value;
        var action1="";
        if (value1==""){
            action1=action1+"/"+"a  a";
            if (value2==""){
                action1=action1+"/"+"-1";
            }else {
                action1=action1+"/"+value2;
            }
        }else {
            action1=action1+"/"+value1;
            if (value2=="") {
                action1=action1+"/"+"-1";
            }else {
                action1=action1+"/"+value2;
            }
        }
        form.action=form.action+action1;
    }
</script>
</body>
</html>