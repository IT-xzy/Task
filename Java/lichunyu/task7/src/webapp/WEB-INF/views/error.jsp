<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isErrorPage="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%String path= request.getContextPath();

    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <style type="text/css">
        body
        {
            background:#cccccc url(/images/email.png) no-repeat fixed center;
            background-size: 100%;
        }
    </style>
    <title>error page</title>
    <script type="text/javascript">
        $(function(){
            $("#center-div").center(true);
        })
    </script>
</head>

<body style="margin: 40px;padding: 0;">
<div id="center-div">
    <table style="height: 100%; width: 100%; text-align: center;">
        <tr>
            <td style="color: #f0ffff; font-family: Tahoma, '宋体'; font-size: 50px; text-align: center;">
                <%= exception.getMessage()%>
                <p style="line-height: 12px; color: #666666; font-family: Tahoma, '宋体'; font-size: 30px; text-align: center;">
                    <a  href="javascript:history.go(-1); " >返回</a>
                </p>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
