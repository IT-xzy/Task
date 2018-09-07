<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
  <table>
    <tr>
      <th>用户名</th>
      <th>email地址</th>
      <th>手机</th>
      <th>头像</th>
    </tr>
    <tr>
      <td><input type="text" name="user" value="${userinfo.user}"></td>
      <td><input type="text" name="email" value="${userinfo.email}"></td>
      <td><input type="text" name="phone" value="${userinfo.phone}"></td>
      <td><input type="text" name="image" value="${userinfo.image}"></td>
    </tr>
  </table>
</body>
</html>