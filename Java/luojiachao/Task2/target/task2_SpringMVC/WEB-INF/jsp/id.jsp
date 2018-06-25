<%--
  Created by IntelliJ IDEA.
  User: luojiac
  Date: 2018/4/5
  Time: 下午9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>

<body style="background-image:url(/images/Alujpg.jpg);background-size: 1440px">
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<div style="text-align:center">
    hhh springmvc
</div>

<form  action="/students/${student.id}" class="form-horizontal" role="form" method="post">

    <table align='center' border='1' cellspacing='0'>

        <div class="form-group">
            <label for="id" class="col-sm-2 control-label">id</label>
            <div class="col-sm-2">
                <input type="text"  name="id" id="id" readonly unselectable="on"
                       VALUE="${student.id}">
            </div>
        </div>
    <div class="form-group">
        <label for="stu_name" class="col-sm-2 control-label">stu_name</label>
        <div class="col-sm-2">
            <input type="text" class="form-control" name="stu_name" id="stu_name"  VALUE="${student.stu_name}">
                   <%--placeholder="${student.stu_name}">--%>
        </div>
    </div>
    <div class="form-group">
        <label for="profession" class="col-sm-2 control-label">profession</label>
        <div class="col-sm-2">
            <input type="text" class="form-control" id="profession" name="profession"
                   VALUE="${student.profession}">
        </div>
    </div>
    <div class="form-group">
        <label for="join_date" class="col-sm-2 control-label">join_date</label>
        <div class="col-sm-2">
            <input type="text" class="form-control" id="join_date" name="join_date"
                   VALUE="${student.join_date}">
        </div>
    </div>
    <div class="form-group">
        <label for="online_id" class="col-sm-2 control-label">online_id</label>
        <div class="col-sm-2">
            <input type="text" class="form-control" id="online_id" name="online_id"
                   VALUE="${student.online_id}">
        </div>
    </div>
    <div class="form-group">
        <label for="brother" class="col-sm-2 control-label">brother</label>
        <div class="col-sm-2">
            <input type="text" class="form-control" id="brother" name="brother"
                   VALUE="${student.brother}">
        </div>
    </div>
    <div class="form-group">
        <label for="school" class="col-sm-2 control-label">school</label>
        <div class="col-sm-2">
            <input type="text" class="form-control" id="school" name="school"
                   VALUE="${student.school}">
        </div>
    </div>
    <div class="form-group">
        <label for="daily" class="col-sm-2 control-label">daily</label>
        <div class="col-sm-2">
            <input type="text" class="form-control" id="daily" name="daily"
                   VALUE="${student.daily}">
        </div>
    </div>
    <div class="form-group">
        <label for="wishing" class="col-sm-2 control-label">wishing</label>
        <div class="col-sm-2">
            <input type="text" class="form-control" id="wishing" name="wishing"
                   VALUE="${student.wishing}">
        </div>
    </div>
    <div class="form-group">
        <label for="qq" class="col-sm-2 control-label">qq</label>
        <div class="col-sm-2">
            <input type="text" class="form-control" id="qq" name="qq"
                   VALUE="${student.qq}">
        </div>
    </div>
    <div class="form-group">
        <label for="heard" class="col-sm-2 control-label">heard</label>
        <div class="col-sm-2">
            <input type="text" class="form-control" id="heard" name="heard"
                   VALUE="${student.heard}">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <input type="hidden" name="_method" value="PUT">
            <button onClick="return fun()" >更新</button>
            <script>
                function fun(){
                    alert("更新成功")
                }
            </script>
        </div>

    </div>
    </table>
</form>

<div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
<form  action="${pageContext.request.contextPath}/students" class="form-horizontal" role="form" method="get">

    <button type="submit" class="btn btn-default">返回首页</button>

</form>
    </div>
</div>

</body>
<jsp:include page="luojiac.jsp">
    <jsp:param  name="year" value="2018" />
</jsp:include>