<%--
  Created by IntelliJ IDEA.
  User: Yzzzt
  Date: 2018/6/25
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="title" uri="http://tiles.apache.org/tags-tiles" %>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Log in|Blog</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/css/component3.css" />
    <script type="text/javascript">

        $(function(){
            $("button").click(function(){
                if($("#signup_email").val()==""||$("#signup_password").val()=="")
                {
                    $.messager.alert('警告','账号和密码不能为空!');

                }
                else
                {
                    $("#sign_form").submit();
                }
            });
        });
    </script>
</head>

<body>
<%-- 内容 --%>
<tiles:insertAttribute name="body"/>
</body>