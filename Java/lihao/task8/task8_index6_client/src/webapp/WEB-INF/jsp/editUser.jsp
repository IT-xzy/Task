<%--
  Created by IntelliJ IDEA.
  User: lihoo
  Date: 2018/8/6
  Time: 23:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ include file="../includes/includes.jsp" %>



<main>
    <div style="width: 500px; margin:0 auto; text-align: center;">
        <div style="text-align: center; margin-top: 40px;">
            <form method="post" action="../u/userList/${stu.id}">
                <input type="hidden" name="_method" value="PUT">

                学生姓名：     <input type="text" name="username" value="${stu.username}"><br><br>
                学生QQ:       <input type="number" name="qq_num" value="${stu.qqNum}"><br><br>
                学生职业类型：  <input type="text" name="study_type" value="${stu.studyType}"><br><br>
                预计入学时间：  <input type="number" name="study_time" value="${stu.studyTime}"><br><br>
                毕业院校：     <input type="text" name="school" value="${stu.school}"><br><br>
                线上学号：     <input type="text" name="study_id" value="${stu.studyId}"><br><br>
                日报链接：     <input type="text" name="daily_link" value="${stu.dailyLink}"><br><br>
                立愿：        <input type="text" name="promise" value="${stu.promise}"><br><br>
                辅导师兄：     <input type="text" name="teach_bro" value="${stu.teachBro}"><br><br>
                何处了解修真院：<input type="text" name="know_us_from" value="${stu.knowUsFrom}"><br><br>
                创建时间：     <input type="number" name="create_at" value="${stu.createAt}"><br><br>
                最后更新时间：  <input type="number" name="update_at" value="${stu.updateAt}"><br><br>

                <input type="submit" value="修改学生信息**911">
            </form>
        </div>
    </div>
</main>