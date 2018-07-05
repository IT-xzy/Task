<%--
  Created by IntelliJ IDEA.
  User: lichu
  Date: 2018-6-12
  Time: 8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        table{
            margin:0;
            background:#cccccc url(/images/man.png) no-repeat fixed center;
            font-family: 'PT Sans', Helvetica, Arial, sans-serif;
            background-size: 100%;
            text-align: center;
            color:  #0000ff ;
        }
    </style>

    <title>上传图片</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/u/photo" enctype="multipart/form-data">
    <table align="center" border="1" width="40%">
        <tr>
            <th align="center" colspan="2">学员头像上传</th>
        </tr>
        <tr>
            <td>选择图片</td>
            <td><input  type="file" name="file" id="file"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <button type="submit">提   交</button>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
