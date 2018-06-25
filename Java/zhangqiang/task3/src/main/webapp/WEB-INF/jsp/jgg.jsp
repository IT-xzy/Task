<%--<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" import="java.util.*"  %>--%>
<%--&lt;%&ndash;核心标签 支持 c:&ndash;%&gt;--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--&lt;%&ndash;json标签 支持<json:object>&ndash;%&gt;--%>
<%--<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>--%>
<%--&lt;%&ndash;page 支持EL表达式 ${name}&ndash;%&gt;--%>
<%--<%@ page isELIgnored="false" %>--%>
<html>
<head>
    <title>Title</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/vue"></script>
    <script src="/js/layer/layer.js"></script>
    <style>
        *{ margin: 0; padding: 0;}
        .main{
            width: 70%;
            max-width: 800px;
            height: auto;
            background: #009f95;
            padding-bottom: 90%;
            float: left;
        }
        .main .lbox{
            width: 31%;
            padding-bottom: 26%;
            border:1px solid #FD482C;
            background-color: #eeeeee ;
            border-radius: 3%;
            float: left;
            margin: 1%;
            text-align: center;
        }
    </style>
</head>
<script>
    <%--var st = "";--%>

    <%--$(function(){--%>
        <%--var st;--%>
        <%--alert("a");--%>
        <%--for(var i=0;i<9;i++){--%>
            <%--st+="<div class='lbox'>5</div>"--%>
        <%--}--%>
        <%--alert(st);--%>
        <%--var divadd = document.getElementByID('controller').innerHTML;--%>
        <%--divadd = st;--%>
        <%--$("#controller").html(st);--%>
    <%--});--%>

    window.onload=function(){
        var st="";
        <%--alert("2"+st);--%>
        for(var i=0;i<9;i++){
            st+="<div class='lbox'>5</div>";
        }
        var divadd = document.getElementById("controller");
        divadd.innerHTML = st;
        <%--$("#controller").html(st);--%>
        <%--alert(st);--%>
         <%--document.write--%>
    }

</script>
<body>

    <div class="main" id="controller">
        <%--<script>--%>
           <%--var box = document.getElementById("controller");--%>

           <%--for(var i=0;i<9;i++){--%>
             <%--box.innerHTML ="<div class='lbox'>5</div>";--%>
           <%--}--%>
        <%--</script>--%>


    </div>

</body>
</html>
