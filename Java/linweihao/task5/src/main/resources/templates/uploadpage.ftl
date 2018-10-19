<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>文件上传</title>
</head>
<#--<script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"/>-->
<script src="/js/jquery.min.js"></script>
<script>
  function sendCode(obj) {
    var emailaddress = document.getElementById("email");
    var value = emailaddress.value.trim();
      //alert(value)
      $.ajax({
        cache: false,
        url: "/emailcode",
        data: {"emailaddress": value},
        success:function (result) {
          alert(result);
        }
      });
  }
  function changeossGet(obj) {
    var changeoss = document.getElementById("changeoss");
    //alert(value)
    $.ajax({
      cache: false,
      url: "/changeoss",
      success:function (result) {
        if(result=="切换腾讯云oss成功"){
          alert(result);
          $('#changeoss').html("切换七牛云oss");
        }else {
          alert(result);
          $('#changeoss').html("切换腾讯云oss");
        }
      }
    });
  }
  $(function () {
    $('#btn').click(function () {
      var count = 3;
      var countdown = setInterval(CountDown, 1000);
      function CountDown() {
        $("#validCode").attr("disabled", true);
        $("#validCode").html("请等待" + count + " 秒再获取验证码!");
        if (count == 0) {
          $("#validCode").html("获取验证码").removeAttr("disabled");
          clearInterval(countdown);
        }
        count--;
      }
    })
  });
</script>
<body>
<form action="/upload" method="post" enctype="multipart/form-data">
  <p>选择文件: <input type="file" name="fileName"/></p><br>
  <button id="changeoss" type="button" onclick="changeossGet();" title="切换七牛云oss">切换七牛云oss</button>
  <p><input type="submit" value="提交"/></p>
</form>
<br>
<form action="/vaildCode" method="post">
  邮箱：<input type="text" name="email" id="email"><br/>
  验证码: <input type="text" id="inputCode" name="inputCode" placeholder="请输入验证码"><br>
  <button id="validCode" type="button" onclick="sendCode();" title="获取验证码">获取验证码</button>
  <p><input type="submit" value="提交"/></p>
</form>

</body>
</html>