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
<form  action="/students" class="form-horizontal" role="form" method="post">
    <div class="form-group">
        <label for="stu_name" class="col-sm-2 control-label">stu_name</label>
        <div class="col-sm-2">
            <input type="text" class="form-control" name="stu_name" id="stu_name" value=""
                   placeholder="">
        </div>
    </div>
    <div class="form-group">
        <label for="profession" class="col-sm-2 control-label">profession</label>
        <div class="col-sm-2">
            <input type="text" class="form-control" id="profession" name="profession" value=""
                   placeholder="">
        </div>
    </div>
    <div class="form-group">
    <label for="join_date" class="col-sm-2 control-label">join_date</label>
    <div class="col-sm-2">
        <input type="text" class="form-control" id="join_date" name="join_date" value=""
               placeholder="">
    </div>
</div>
    <div class="form-group">
    <label for="online_id" class="col-sm-2 control-label">online_id</label>
    <div class="col-sm-2">
        <input type="text" class="form-control" id="online_id" name="online_id" value=""
               placeholder="">
    </div>
</div>
    <div class="form-group">
    <label for="brother" class="col-sm-2 control-label">brother</label>
    <div class="col-sm-2">
        <input type="text" class="form-control" id="brother" name="brother" value=""
               placeholder="">
    </div>
</div>
    <div class="form-group">
    <label for="school" class="col-sm-2 control-label">school</label>
    <div class="col-sm-2">
        <input type="text" class="form-control" id="school" name="school" value=""
               placeholder="">
    </div>
</div>
    <div class="form-group">
    <label for="daily" class="col-sm-2 control-label">daily</label>
    <div class="col-sm-2">
        <input type="text" class="form-control" id="daily" name="daily" value=""
               placeholder="">
    </div>
</div>
    <div class="form-group">
    <label for="wishing" class="col-sm-2 control-label">wishing</label>
    <div class="col-sm-2">
        <input type="text" class="form-control" id="wishing" name="wishing" value=""
               placeholder="">
    </div>
</div>
    <div class="form-group">
        <label for="qq" class="col-sm-2 control-label">qq</label>
        <div class="col-sm-2">
            <input type="text" class="form-control" id="qq" name="qq" value=""
                   placeholder="">
        </div>
    </div>
    <div class="form-group">
        <label for="heard" class="col-sm-2 control-label">heard</label>
        <div class="col-sm-2">
            <input type="text" class="form-control" id="heard" name="heard" value=""
                   placeholder="">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">提交</button>
        </div>
    </div>

</form>


    <%--stu_name：<input type="text" name="stu_name"   value=""><br />--%>
    <%--profession：<input type="text" name="profession" value=""><br />--%>
    <%--join_date：<input type="text" name="join_date"  value=""><br />--%>
    <%--online_id：<input type="text" name="online_id"  value=""><br />--%>
    <%--brother：<input type="text" name="brother"    value=""><br />--%>
    <%--school：<input type="text" name="school"     value=""><br />--%>
    <%--daily：<input type="text" name="daily"      value=""><br />--%>
    <%--wishing：<input type="text" name="wishing"    value=""><br />--%>
    <%--qq         ：<input type="text" name="qq"         value=""><br />--%>
    <%--heard      ：<input type="text" name="heard"      value=""><br />--%>
    <%--<input type="submit" value="增加用户">--%>

</body>