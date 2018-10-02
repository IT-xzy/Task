<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>hello</title>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <link rel="stylesheet" media="screen" href="views/css/css.css"/>
</head>
<html>
<body>
<form id="msform" method="post" action="/Register">
    <!-- progressbar -->
    <ul id="progressbar">
        <li class="active">Account Setup</li>
        <li>A little personal information about you.</li>
        <li>Some necessary verification</li>
    </ul>
    <!-- fieldsets -->
    <fieldset>
        <h2 class="fs-title">Create your account</h2>
        <h3 class="fs-subtitle">this is step 1</h3>

        <input type="text" name="account" placeholder="account" value="${UserAccount.account}"/>
        <input type="password" name="password" placeholder="password"/>
        <input type="password" name="" placeholder="confirm password one more plz~"/>

        <input type="button" name="next" class="next action-button" value="Next"/><br><br>
        <a href="/Login" name="next" class="next action-button" value="Next">Already Owned Account ? </a><br><br>
    </fieldset>


    <fieldset>
        <h2 class="fs-title">Social Profiles</h2>
        <h3 class="fs-subtitle">this will be shown to your friends.</h3>

        <input type="text" name="trueName" placeholder="your true name"/>
        <input type="text" name="nickName" placeholder="what you want other body call you"/>
        <input type="text" name="sex" placeholder="sex"/>

        <input type="button" name="previous" class="previous action-button" value="Previous"/>
        <input type="button" name="next" class="next action-button" value="Next"/>
    </fieldset>


    <fieldset>
        <h2 class="fs-title">Personal Details</h2>
        <h3 class="fs-subtitle">We will never sell it</h3>

        <input type="text" name="phone" placeholder="yep,i need your phone!"/>
        <%--<textarea name="address" placeholder="Address"></textarea>--%>
        <input type="text" name="phoneToken" placeholder="短信验证模块留空"/>

        <input type="button" name="previous" class="previous action-button" value="Previous"/>
        <input type="submit" name="submit" class="submit action-button" value="Submit"/>
        <input type="submit" value="Submit2">
    </fieldset>

</form>


<script src="/views/js/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="/views/js/jquery.easing.min.js" type="text/javascript"></script>
<script src="/views/js/jQuery.time.js" type="text/javascript"></script>
<br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br>
</body>
</html>