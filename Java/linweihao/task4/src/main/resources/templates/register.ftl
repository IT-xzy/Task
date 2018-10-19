<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>注册账号</title>
  <script src="/js/jquery.min.js"></script>
  <script>
    function sendemailCode(obj) {
      var emailaddress = document.getElementById("email");
      var value = emailaddress.value.trim();
      //alert(value)
      $.ajax({
        cache: false,
        url: "/emailcode",
        data: {"emailaddress": value},
        success: function (result) {
          alert(result);
        }
      });
    }
    function sendphoneCode() {
      var phone = document.getElementById("phone");
      var value = phone.value.trim();
      //alert(value)
      $.ajax({
        cache: false,
        url: "/phonecode",
        data: {"phone": value},
        success:function (result) {
          alert(result);
        }
      });
    }
  </script>
</head>
<body>
<h1>账号注册</h1>
<form action="/registercheck" method="post" enctype="multipart/form-data">
  用户：<input type="text" name="user" ><br/>
  密码：<input type="password" name="password"><br/>
  邮箱：<input type="text" name="email" id="email">
  <br/>
  <button id="validemailCode" type="button" onclick="sendemailCode();" title="获取验证码">获取邮箱验证码</button>
  <br/>
  手机：<input type="text" name="phone" id="phone"><br/>
  <button id="validphoneCode" type="button" onclick="sendphoneCode();" title="获取验证码">获取手机验证码</button>
  <br/>
  输入验证码：<input type="text" name="vaidcode"><br/>
  <p>上传图片: <input type="file" name="fileName"/></p>
  <button type="submit">注册</button>
</form>
</body>
</html>