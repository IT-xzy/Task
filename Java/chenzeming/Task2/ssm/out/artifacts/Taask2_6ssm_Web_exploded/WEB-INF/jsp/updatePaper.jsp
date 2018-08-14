<%--
  Created by IntelliJ IDEA.
  User: LUCKY 铭
  Date: 2018/7/12
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>测试</title>
</head>

<body>
<form action="/qwe">
    <fieldset>
    <h1>查询结果</h1>
        姓名 ：<input type="text"  name="name" value="${user.userName}"><br/>
        年龄 ：<input type="text"  name="age" value="${user.age}"><br/>
        体重 ：<input type="text"  name="weight" value="${user.weight}"><br/>
        create_at: <input type="text"  name="create_at" value="${user.createAt}"><br/>
        update_at ：<input type="text"  name="update_at" value="${user.updateAt}"><br/>

    <input  id="submit" type="submit" value="提交">
    </fieldset>
</form>
</body>
</html>
