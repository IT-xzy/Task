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


<style>

    #manageBody {
        /*display: inline-block;*/
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
                <td>id</td><td>分院</td><td>等级</td><td>课程</td>
                <td>名字</td><td>QQ</td><td>学习方向</td><td>入学时间</td>
                <td>毕业院校</td><td>学号</td><td>日报链接</td><td>立愿</td>
                <td>师兄</td><td>来源</td><td>创建时间</td><td>更新时间</td>
                <%--<td>删除</td>--%>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${students}" var="student" varStatus="st">
                    <tr>
                        <th>${student.id}</th>
                        <th>${student.location}</th>
                        <th>${student.level}</th>
                        <th>${student.lesson}</th>
                        <th>${student.name}</th>
                        <th>${student.qq}</th>
                        <th>${student.job}</th>
                        <th>${student.startTime}</th>
                        <th>${student.university}</th>
                        <th>${student.number}</th>
                        <th>${student.link}</th>
                        <th>${student.target}</th>
                        <th>${student.brother}</th>
                        <th>${student.source}</th>
                        <th>${student.createAt}</th>
                        <th>${student.updateAt}</th>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

