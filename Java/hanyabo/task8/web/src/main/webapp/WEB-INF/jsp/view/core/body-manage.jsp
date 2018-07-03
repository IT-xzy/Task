<%--
  Created by IntelliJ IDEA.
  User: zhimowen
  Date: 2018-05-23
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="/tags" prefix="date"%>

<style>

    #manageBody {
        text-align: center;
        height: 720px;
        border:1px solid #e7e7e7;

        margin-left: 102px;
    }

    #selectDiv {
        border:1px solid #e7e7e7;
        text-align: center;
        height: 220px;
    }

    #displayDiv {
        border:1px solid #e7e7e7;

        text-align: center;
        height: 500px;
    }

</style>


<div id="manageBody">

    <div id="selectDiv">
        </br>
        查询学生信息

        <form method="get" action="/student">
            用户id：<input name="id" type="text"></br></br>
            姓名：<input name="name" type="text"></br></br>
            学号：<input name="number" type="text"></br></br>
            <input type="submit" value="查询">
        </form>

    </div>

    <div id="displayDiv">

        </br>
        <table align='center' border='1' cellspacing='0'>
            <thead>
            <tr>
                <th>id</th><th>分院</th><th>等级</th><th>课程</th>
                <th>名字</th><th>QQ</th><th>学习方向</th><th>入学时间</th>
                <th>毕业院校</th><th>学号</th><th>日报链接</th><th>立愿</th>
                <th>师兄</th><th>来源</th><th>创建时间</th><th>更新时间</th>
                <%--<td>删除</td>--%>
            </tr>
            </thead>
            <tbody>
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
                        <td><date:date value ="${student.createAt}"/></td>
                        <td><date:date value ="${student.updateAt}"/></td>
                            <%--<td><a href="student/${student.id}">编辑</a></td>--%>
                            <%--<td><a class="delete" href="student/${student.id}">删除</a></td>--%>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br>
        <c:if test="${studentPage!=null}">
            <div id="page" style="text-align:center">
                <a href="?start=0">首  页</a>
                <a href="?start=${studentPage.previous}">上一页</a>
                <a href="?start=${studentPage.next}">下一页</a>
                <a href="?start=${studentPage.last}">末  页</a>
            </div>
        </c:if>
    </div>
</div>

