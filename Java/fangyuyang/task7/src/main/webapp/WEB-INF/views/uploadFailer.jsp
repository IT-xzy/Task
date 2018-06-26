<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2018/5/29
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<style type="text/css">
    a {
        text-decoration: none;
        color: #fff;
        font-size: 14px;
    }
    h3 {
        width: 300px;
        height: 100px;
        margin: 100px auto;
        text-align: center;
        line-height: 38px;
        background: #14ded8;
        border-radius: 4px;
    }
</style>


<h3>
    <p>上传失败</p>
    <form action="" enctype="multipart/form-data" >
        <table>

            <tr>
                <td>请选择文件:</td>
                <td><input type="file" ></td>
            </tr>

        </table>
        <form action="${pageContext.request.contextPath}/uploadPicture" >
            <input type="submit" value="返回">
        </form>
    </form>

</h3>
</body>
</html>
