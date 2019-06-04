<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>adduser</title>
</head>
<body>

<form action="/user/add" name="user">

    姓名<input type="text" name="name"><br/>
    修真类型<input type="text" name="type"><br/>
    入学时间<input type="text" name="admissionTime"><br/>
    毕业学校<input type="text" name="graduatedSchool"><br/>
    日报链接<input type="text" name="daliyLink" }><br/>
    立愿<input type="text" name="volunte"><br/>
    师兄<input type="text" name="brother"><br/>
    途径<input type="text" name="source"><br/>
    创建时间<input type="text" name="createAt"><br/>
    修改时间<input type="text" name="updateAt"><br/>
    <input type="submit" value="提交">
</form>

</body>
</html>
