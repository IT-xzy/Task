<%--
  Created by IntelliJ IDEA.
  User: Yzzzt
  Date: 2018/6/25
  Time: 20:33
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
    <style type="text/css">
        .login_bg
        {
            position:absolute;
            top: 0; width:100%; height:100%;
            right: 0;
            bottom: 0;
            left: 0;
            background-size: cover;
        }
    </style>
    <script type="text/javascript">
        $(function(){
            $("button").click(function(){
                if($("#signup_email").val()==""||$("#signup_password").val()==""||$("#signup_confirm_password").val()==""||$("#signup_username").val()=="")
                {
                    $.messager.alert('Waring!','email password and username mustn\'t be empty!');

                }
                else
                {
                    if($("#signup_password").val()!=$("#signup_confirm_password").val())
                    {
                        $.messager.alert('Waring','Your password is not same!');
                        $("#signup_password").val("");
                        $("#signup_confirm_password").val("");
                    }
                    else
                    {
                        $("#sign_form").submit();
                    }
                }
            });
        });
    </script>
</head>

<body>
<%-- 内容 --%>
<tiles:insertAttribute name="body"/>
</body>
