<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/7
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--核心标签 支持 c:--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--json标签 支持<json:object>--%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%--page 支持EL表达式 ${name}--%>
<%@ page isELIgnored="false" %>
<script src="${pageContext.request.contextPath}/stat/css/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/stat/js/upload/webuploader.js"></script>
<script src="${pageContext.request.contextPath}/stat/js/upload/jquery.sortable.js"></script>
<script src="${pageContext.request.contextPath}/stat/js/upload/upload.js"></script>

    <style>
        .updfrom div{
            margin-bottom: 5px;
        }
        .updStudentBody{
            margin-top: 30px;
            margin-bottom: 50px;
        }
    </style>

<div class="register-container container updStudentBody">
    <div class="row">
        <div class="register">
            <c:if test="${!empty requestScope.studentInfo}">
                <form action="/u/student" name="updStu" class="updfrom" id="updfrom" method="post">

                    <div class="col-md-12 backhome"  >
                        <a href="/home" class="btn btn-default">返回主页</a>&nbsp;<a href="/u/list" class="btn btn-default">去列表页</a>${message}
                    </div>

                    <h2 style="text-align: center;"><span class="red"><strong>修改数据</strong></span></h2>
                    <input type="hidden" name="_method" value="PUT"/>
                    <div class="col-md-12"  >
                        <label for="id" class="col-md-2 from-label">id</label>
                        <div class="col-md-10">
                            <input type="text" class="form-control" value="${requestScope.studentInfo.id}" disabled="disabled">
                            <input type="hidden" class=" " id="id" name="id" value="${requestScope.studentInfo.id}">
                        </div>
                    </div>
                    <div class="col-md-12">

                        <label for="stuPhoto" class="col-md-2 from-label">头像</label>

                        <div class="col-md-10">
                            <div id="stuPhoto" class=""  >
                                <%--<input type="hidden" value="${fileUrl}" name="stuPhoto">--%>
                                <input type="hidden" value="${requestScope.studentInfo.stuPhoto}" name="stuPhoto">
                                <img src="${requestScope.studentInfo.stuPhoto}"  class="img-rounded" style="width: 100px;margin-right: 20px;" >
                                <a type="button" class="btn btn-default" href="/u/photo/${requestScope.studentInfo.id}">上传头像</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <label for="stuName" class="col-md-2 from-label">姓名</label>
                        <div class="col-md-10">
                            <input type="text" id="stuName" class="form-control" name="stuName" value="${requestScope.studentInfo.stuName}" >
                        </div>
                    </div>
                    <div class="col-md-12">
                        <label for="sex" class="col-md-2 from-label">性别</label>
                        <div class="col-md-10">
                            <div class="radio">
                                <label>
                                    <input type="radio" name="sex" id="sex0" value="0" <c:if test="${requestScope.studentInfo.sex == 0}"> checked </c:if> > 女
                                </label>
                            </div>
                            <div class="radio">
                                <label>
                                    <input type="radio" name="sex" id="sex1" value="1" <c:if test="${requestScope.studentInfo.sex == 1}"> checked </c:if>>男
                                </label>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-12">
                        <label for="age" class="col-md-2 from-label">年龄</label>
                        <div class="col-md-10">
                            <input type="text" id="age" class="form-control" name="age"  value="${requestScope.studentInfo.age}">
                        </div>
                    </div>
                    <div class="col-md-12">
                        <label for="school" class="col-md-2 from-label">院校</label>
                        <div class="col-md-10">
                            <input type="text" id="school" class="form-control" name="school" value="${requestScope.studentInfo.school}">
                        </div>
                    </div>
                    <div class="col-md-12">
                        <label for="office" class="col-md-2 from-label">立愿</label>
                        <div class="col-md-10">
                            <input type="text" id="office" class="form-control" name="office" value="${requestScope.studentInfo.office}">
                        </div>
                    </div>
                    <div class="col-md-12">
                        <label for="recommend" class="col-md-2 from-label">介绍</label>
                        <div class="col-md-10">
                            <input type="text" id="recommend" class="form-control" name="recommend" value="${requestScope.studentInfo.recommend}">
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="col-md-10">
                            <input type="hidden" id="pro_id" class="form-control" name="pro_id" value="1">
                        </div>
                    </div>
                    <div class="col-md-12 buttondiv" style="text-align: center">
                        <button type="submit" class="btn btn-success" id="submitstudentInfo"> 提交修改 </button>
                    </div>
                </form>
            </c:if>
        </div>
    </div>
</div>
