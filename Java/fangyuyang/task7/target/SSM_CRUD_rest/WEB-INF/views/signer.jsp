
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body>
<style type="text/css">
    a {
        text-decoration: none;
        color: #fff;
        font-size: 14px;
    }
    h3 {
        width: 600px;
        height: 400px;
        margin: 100px auto;
        text-align: center;
        line-height: 38px;
        background: #d4de17;
        border-radius: 4px;
    }
</style>


    <!-- 表格  -->
    <div class="row">
        <div class="col-md-12">
            <table border="1" cellpadding="10" cellspacing="0">
                <form action="" method="POST" >

                    <tr>

                        <th>QQ</th>
                        <th>姓名</th>
                        <th>修真类型</th>
                        <th>邮箱</th>
                        <th>毕业院校</th>
                        <th>手机号码</th>
                        <th>立愿</th>
                        <th>审核师兄</th>
                        <th>了解从何知</th>
                    </tr>
                        <tr>

                            <td>${signer.qq}</td>
                            <td>${signer.name}</td>
                            <td>${signer.course}</td>
                            <td>${signer.email}</td>
                            <td>${signer.school}</td>
                            <td>${signer.mobile}</td>
                            <td>${signer.target}</td>
                            <td>${signer.oldBrother}</td>
                            <td>${signer.fromWhere}</td>

                        </tr>
                </form>

            </table>
        </div>
    </div>
<form action="${pageContext.request.contextPath}/doEmail" method="post">
    <input type="submit" value="获取验证码">
</form>
<form action="${pageContext.request.contextPath}/mailCheck" >
    输入邮箱验证码：<input type="text" name="mailValidate"><br>
    <input type="submit" value="确认">
</form>
<h4>头像<img  width="400" height="300" src= "${signer.picture}"/></h4>
</body>
