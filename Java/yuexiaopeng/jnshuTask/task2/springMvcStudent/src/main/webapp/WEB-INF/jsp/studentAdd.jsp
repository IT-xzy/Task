<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Edit Student</title>
</head>
<div style="text-align:center">
            请输入需要增加的数据，点击增加按钮
</div>
<body>
<br>
        <div>
            <form action="adding" method="post" >
                <%--将这个表单的post方法改为隐藏的put方法，变为rest风格--%>
                <%--<input type="hidden" name="_method" value="put">--%>
                <table align='center'>
                    <tr>
                        <td>id:</td>
                        <td><input type="text" name="id" value=""><br/></td>
                    </tr>
                    <tr>
                    <td>name:</td>
                    <td><input type="text" name="name" value=""><br/></td>
                    </tr>
                    <tr>
                    <td>createAt:</td>
                    <td><input type="text" name="createAt" value=""><br/></td>
                    </tr>
                    <tr>
                    <td>updateAt:</td>
                    <td><input type="text" name="updateAt" value=""><br/></td>
                    </tr>
                    <tr>
                    <td>qq:</td>
                    <td><input type="text" name="qq" value=""><br/></td>
                    </tr>
                    <tr>
                    <td>studyType:</td>
                    <td><input type="text" name="studyType" value=""><br/></td>
                    </tr>
                    <tr>
                    <td>joinTime:</td>
                    <td><input type="text" name="joinTime" value=""><br/></td>
                    </tr>
                    <tr>
                        <td>university:</td>
                        <td><input type="text" name="university" value=""><br/></td>
                    </tr>
                    <tr>
                        <td>studyId:</td>
                        <td><input type="text" name="studyId" value=""><br/></td>
                    </tr>
                    <tr>
                        <td>dailyLink:</td>
                        <td><input type="text" name="dailyLink" value=""><br/></td>
                    </tr>
                    <tr>
                    <td>slogen:</td>
                    <td><input type="text" name="slogen" value=""><br/></td>
                    </tr>
                    <tr>
                        <td>master:</td>
                        <td><input type="text" name="master" value=""><br/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="点击增加"></td>
                    </tr>
                </table>
            </form>
        </div>
    </table>
    <br>
    <br>

    </body>
</html>




