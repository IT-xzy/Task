<%--
  Created by IntelliJ IDEA.
  User: GhostSugar
  Date: 2018/7/4
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <title>XMLHttpRequest</title>
</head>
<style>
    .res{
        width: 300px;
        height:300px;
    }
</style>
<script type="text/javascript">
    function loadXMLDoc()
    {
        var xmlhttp;
        if (window.XMLHttpRequest)
        {
            //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
            xmlhttp=new XMLHttpRequest();
        }
        else
        {
            // IE6, IE5 浏览器执行代码
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }


        //method：请求的类型,url：请求地址,async：是否异步 可以不写，默认异步
        xmlhttp.open("GET","http://localhost:8080/ajax",true);
        xmlhttp.setRequestHeader('name','==========setRequestHeader!============');

        //将请求发送到服务器  send()是get send(string)必须是post send(null)
        xmlhttp.send();

        // 每当 readyState 属性改变时，就会调用该函数，也就是说请求后的请求状态发生改变，就会调用onreadystatechange函数
        xmlhttp.onreadystatechange=function()
        {
            //请求返回 请求状态 回应状态
            if (xmlhttp.readyState==4 && xmlhttp.status==200)
            {
                //alert("响应成功");
                document.getElementById("responsetxt").innerHTML=xmlhttp.responseText;
//
//                xmlDoc=xmlhttp.responseXML;
//                txt="";
//                x=xmlDoc.getElementsByTagName("ARTIST");
//                for (i=0;i<x.length;i++)
//                {
//                    txt=txt + x[i].childNodes[0].nodeValue + "<br />";
//                }
//                document.getElementById("responsexml").innerHTML=txt;

            }
        }

    }
</script>
<body>
<div class="res">
<div id="responsetxt"><h2>responsetxt</h2></div>
</div>
<button type="button" onclick="loadXMLDoc()">获取响应</button>


</body>
</html>