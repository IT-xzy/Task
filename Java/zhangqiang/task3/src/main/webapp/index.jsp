<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" import="java.util.*"  %>
<%--核心标签 支持 c:--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--json标签 支持<json:object>--%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%--page 支持EL表达式 ${name}--%>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>首页</title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" >

    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/vue"></script>
    <script src="/js/layer/layer.js"></script>

    <style>
        *{
            margin: 0;
            padding:0;
        }
        .from{
            display: inline;
        }
    </style>
</head>
<body>
<div style="padding: 0px 50px;">
    <h2>Hello World!</h2>
    <div style="float: right;margin:8px 0;">

    <form action="/urg/user/reg" class="from">
        <%--<a href="${pageContext.request.contextPath}/urg/user/reg" >注册</a>--%>
        <button type="submit"  class="btn btn-primary" value="注册">注册</button>
    </form>
    </div>
</div>

<c:if test="${!empty message}">
    ${message}
</c:if>

<%--<div class="row clearfix">--%>
    <%--<div class="col-md-12 column " style="text-align: center">--%>
        <%--<h2>index</h2>--%>
    <%--</div>--%>
<%--</div>--%>

<div style="text-align: center">
    <div class="headRest" style="height: 100px; width: 850px ;text-align: center;margin:auto;">
        <form class="navbar-form navbar-left"  role="search"  id="restSelFrom" method="post">
            <div class="form-group">
                <input type="hidden" name="_method" value="POST">
                <input type="text" class="form-control" name="name" id="name"  />
            </div>
            <button type="button" class="btn btn-default" form="restSelFrom" id="select" onclick="sel()" >查询(name)</button>

        </form>

        <form class="navbar-form navbar-left" role="search" action="/urg/user/list" role="search" id="pagefrom" >
            <%--<div class="form-group">--%>
                <%--&lt;%&ndash;<input type="hidden" name="_method" value="GET"/>&ndash;%&gt;--%>
                <%--<input type="text" class="form-control" name="nowpage" id="nowpage"  placeholder="第几页，默认1"/>--%>
                <%--<input type="text" class="form-control" name="pagesize" id="pagesize" placeholder="每页记录数，默认5条" />--%>
            <%--</div>--%>
            <button type="submit" class="btn btn-default" form="pagefrom"  >列表页</button>
        </form>
        <form class="navbar-form navbar-left" role="search" action="/urg/user/json" role="search" id="jsonfrom" >
            <div class="form-group">
                <%--<input type="hidden" name="_method" value="POST">--%>
                <input type="text" class="form-control" name="jsonname" id="jsonname"  />
            </div>
            <button class="btn btn-default" type="submit" form="jsonfrom" >json查询</button>
        </form>

        <form  class="navbar-form navbar-left" role="search" action="/urg/login" method="post" >
            <input type="hidden" value="POST">
            <input type="text"class="form-control" name="name" placeholder="Name"/>
            <input type="password"class="form-control" name="pwd"  placeholder="Password"/>
            <button type="submit"  class="btn btn-default">Login</button>
        </form>


    </div>
</div>
<script>
        function sel(){
            var forma = $("#restSelFrom");
            var name = $("#name").val();
            if(name!=""){
                document.getElementById("restSelFrom").action = "/urg/user/"+name;
                <%--alert(document.getElementById("restSelFrom").action);--%>
               document.getElementById("restSelFrom").submit();
            }else{
                layer.tips('不能填空哦', '#name', {
                    tips: [1, '#3595CC'],
                    time: 4000
                });
            }

        }
    </script>
</body>
</html>
