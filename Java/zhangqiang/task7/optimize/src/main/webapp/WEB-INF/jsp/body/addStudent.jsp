<%--
  Created by IntelliJ IDEA.
  User: GhostSugar
  Date: 2018/6/19
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--是否忽略EL表达式--%>
<%@ page isELIgnored="false" %>
<%--核心标签 支持 c:--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6" style="text-align: center">
                <div class="col-md-6" style="padding:100px">
                    <img src="http://jns.img.bucket.ks3-cn-beijing.ksyun.com/skill/skill_html/images/login-ad_03.png">
                </div>
            </div>
            <div class="col-md-6">
                <div class="col-md-6" style="margin:200px auto">
                    <div>${message}
                    </div>
                    <form class="form-inline login-form" action="/s/student" method="post">
                        <input type="hidden" name="_method" value="POST">
                        <div class="tel-user user-summary">
                            <i></i><input class="form-control" name="stuName" type="text" placeholder="请输入姓名">
                        </div><br>
                        <div class="pwd-user user-summary">
                            <i></i>
                            <label class="radio-inline">
                                <input type="radio" name="sex" id="optionsRadios3" value="1" checked> 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="sex" id="optionsRadios4"  value="0"> 女
                            </label>
                        </div><br>
                        <div class="btn-area">
                            <button type="submit" class="btn btn-orange" >添加学员</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</main>