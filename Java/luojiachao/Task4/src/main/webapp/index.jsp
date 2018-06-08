<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>hello</title>
</head>
<body style="background-image:url(/images/Alujpg.jpg);background-size: 1440px">


<div style="text-align:center">
    hhh springmvc
</div>
<div style="text-align:center">
    <form  action="/home" class="form-horizontal" role="form" method="get">
        <table align='center' border='1' cellspacing='0'>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button onClick="return fun()" >登入表单</button>
                </div>
            </div>
        </table>
    </form>
    <form  action="/test" class="form-horizontal" role="form" method="get">
        <table align='center' border='1' cellspacing='0'>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button onClick="return fun()" >登入表单test</button>
                </div>
            </div>
        </table>
    </form>

    <form  action="/test1" class="form-horizontal" role="form" method="get">
        <table align='center' border='1' cellspacing='0'>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button onClick="return fun()" >登入表单test1</button>
                </div>
            </div>
        </table>
    </form>
    <form  action="/test2" class="form-horizontal" role="form" method="get">
        <table align='center' border='1' cellspacing='0'>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button onClick="return fun()" >登入表单test2</button>
                </div>
            </div>
        </table>
    </form>
    <form  action="/test3" class="form-horizontal" role="form" method="get">
        <table align='center' border='1' cellspacing='0'>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button onClick="return fun()" >登入表单test3</button>
                </div>
            </div>
        </table>
    </form>
</div>

<%--<meta http-equiv="refresh" content="3;url=students">--%>

</body>

</html>