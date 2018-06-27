<%--
  Created by IntelliJ IDEA.
  User: zhimowen
  Date: 2018-06-06
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<script type="text/javascript" src="https://code.jquery.com/jquery-3.0.0.min.js"></script>--%>
<script type="text/javascript" src="/js/jquery-3.0.0.min.js"></script>

<script type="text/javascript">
    $(function(){
        $(".update").click(function(){
            var href = $(this).attr("href");
            $("#updateForm").attr("action",href).submit();
            return false;
        })
    });

    $(function(){
        $(".add").click(function(){
            var href = $(this).attr("href");
            $("#addForm").attr("action",href).submit();
            return false;
        })
    });

    $(function(){
        $(".delete").click(function(){
            var href = $(this).attr("href");
            $("#deleteForm").attr("action",href).submit();
            return false;
        })
    });

</script>

<form action="" method="post" id="updateForm">
    <input type="hidden" name="_method" value="PUT">
</form>

<form action="" method="post" id="addForm">
</form>

<form action="" method="post" id="deleteForm">
    <input type="hidden" name="_method" value="DELETE">
</form>

<html>
<head>
    <title>funList</title>
</head>

<body>
    <div style="width:100%;text-align:center">

        </br></br>
        <a href="/fun/user">GetUser</a>
        </br></br>
        <a class="update" href="/fun/user">UpdateUser</a>
        </br></br>
        <a class="add" href="/fun/user">AddUser</a>
        </br></br>
        <a class="delete" href="/fun/user">Delete</a>

        </br></br>
        <p>${manage}:${req}</p>
    </div>
</body>
</html>
