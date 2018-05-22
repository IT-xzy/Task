<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isErrorPage="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%String path= request.getContextPath();

    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>error page</title>
    <script type="text/javascript">
        $(function(){
            $("#center-div").center(true);
        })
    </script>
</head>

<body style="margin: 40px;padding: 0;background-color: #f5f5f5;">
<div id="center-div">
    <table style="height: 100%; width: 1200px; text-align: center;">
        <tr>
            <td>
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
