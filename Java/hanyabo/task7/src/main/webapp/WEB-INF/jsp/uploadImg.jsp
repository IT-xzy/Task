<%--
  Created by IntelliJ IDEA.
  User: zhimowen
  Date: 2018-06-20
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
    function checkEmpty(id, name){
        var value = $("#"+id).val();
        if(value.length==0){
            alert(name+ "不能为空");
            $("#"+id)[0].focus();
            return false;
        }
        return true;
    }

    $(function(){
        $("#addForm").submit(function(){
            if(!checkEmpty("categoryPic","头像"))
                return false;
            return true;
        });
    });

</script>

<html>
<head>
    <title>上传头像</title>
</head>
<body>


<div class="panel panel-warning addDiv">
    <%--<div class="panel-heading">新增分类</div>--%>
    <div class="panel-body">
        <form method="post" id="addForm" action="/img/head" enctype="multipart/form-data">
            <table class="addTable">

                <tr>
                    <td>头像</td>
                    <td>
                        <%--<input id="categoryPic" type="file" name="importFile" />--%>
                        <input id="categoryPic" accept="image/*" type="file" name="image" />
                    </td>
                </tr>
                <tr class="submitTR">
                    <td colspan="2" align="center">
                        <button type="submit" class="btn btn-success">提 交</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>

</body>
</html>
