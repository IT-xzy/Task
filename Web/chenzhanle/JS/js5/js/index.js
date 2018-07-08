/* js 登陆 */

var account = document.getElementById('account'),
  password = document.getElementById('password'),
  msg = document.getElementById('msg'),
  btnlogin = document.getElementById('btnlogin'),
  regA = /[a-z]{5,}$/,
  regP = /\d{6,}$/;

// 验证账号密码
btnlogin.onclick = function () {
  btnlogin.disabled = false;
  var accountValue = account.value,
    pwdValue = password.value;
  if (accountValue == '' || !regA.test(accountValue)) {
    msg.textContent = '账户请输入5位以上小写字母';
    account.focus();
  } else if (pwdValue == '' || !regP.test(pwdValue)) {
    msg.textContent = '密码请输入6位以上数字';
    password.focus();
  } else {
    btnlogin.disabled = true;
    msg.textContent = '';
    var data = 'name=' + accountValue + '&pwd=' + pwdValue;
    submitData(data);
  }
};

function submitData(data) {
  var xhr = new XMLHttpRequest,
    intervalID;

  clearInterval(intervalID);
  xhr.onreadystatechange = function () {
    if (xhr.readyState == 4) {
      if ((xhr.status >= 200 && xhr.status < 300) || xhr.status == 304) {
        btnlogin.disabled = false;
        var reData = JSON.parse(xhr.responseText),
          reStatus = reData.code;

        msg.textContent = reData.message;
        switch (reStatus) {
          case 0:
            break;
          case -5003:
            account.value = "";
            password.value = "";
            account.focus();
            break;
          case -5004:
            password.value = "";
            password.focus();
        }

        intervalID = setInterval(
          function () {
            msg.textContent = '';
          }, 2000
        );
      } else {
        btnlogin.disabled = false;
        alert('Response was unsuccessful:' + xhr.status);
      }
    }
  };

  xhr.open("POST", "/carrots-admin-ajax/a/login", true);
  xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
  xhr.send(data);
}

/* jQuery 登陆 */

// var regA = /[a-z]{5,}$/,
//   regP = /\d{6,}$/;

// $('#btnlogin').click(function () {
//   $('#btnlogin').disabled = false;
//   if ($('#account').val() == '' || !regA.test($('#account').val())) {
//     $('#msg').text('账户请输入5位以上小写字母');
//     $('#account').focus();
//   } else if ($('#password').val() == '' || !regP.test($('#password').val())) {
//     $('#msg').text('密码请输入6位以上数字');
//     $('#password').focus();
//   } else {
//     $('#btnlogin').disabled = true;
//     $('#msg').text('');
//     submitData();
//   }
// })

// function submitData() {
//   var intervalID;
//   clearInterval(intervalID);

//   var request = $.ajax({
//     url: "/carrots-admin-ajax/a/login",
//     method: "POST",
//     data: {
//       name: $('#account').val(),
//       pwd: $('#password').val()
//     },
//     dataType: "json"
//   });
//   request.always(function () {
//     if (request.readyState == 4) {
//       if (request.status == 200) {
//         $('#btnlogin').disabled = false;
//         console.log(request.status + '\n' + request.responseJSON);
//         var jqData = request.responseJSON;
//         $('#msg').text(jqData.message);
//         switch (jqData.code) {
//           case 0:
//             break;
//           case -5003:
//             $('#account').val('');
//             $('#password').val('');
//             $('#account').focus();
//             break;
//           case -5004:
//             $('#password').val('');
//             $('#password').focus();
//         }
//         intervalID = setInterval(function () {
//           msg.textContent = '';
//         }, 3000);
//       } else {
//         $('#btnlogin').disabled = false;
//         alert('Response was unsuccessful:' + request.status);
//       }
//     }
//   });
// }