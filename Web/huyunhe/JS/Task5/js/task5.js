$(".login").click(function (e) {
  // 使用jQuery发起ajax异步请求
  $.ajax({
    type: "POST",
    url: "/carrots-admin-ajax/a/login",
    data: {
      name: $("[type='text']").val(),
      pwd: $("[type='password']").val()
    },
    success: function (response) {
      response = response.trim();
      var status = JSON.parse(response);
      console.log(status);
      if (status.code != 0) {
        $(".prompt").css("color", "red");
        $(".prompt").html(status.message);
      } else if (status.code == 0) {
        $(".prompt").css("color", "green");
        $(".prompt").html(status.message);
        location.href = "http://localhost/JS/Task6AngularJS/index.html";
      }
    }
  });

  //使用JavaScript发送ajax异步请求
//   var xhr = new XMLHttpRequest();
//   xhr.onreadystatechange = function () {
//     if (xhr.readyState === 4) {
//       if (xhr.status === 200) {
//         var status = JSON.parse(xhr.responseText);
//         console.log(status);

//         if (status.code != 0) {
//           $(".prompt").css("color", "red");
//           $(".prompt").html(status.message);
//         } else if (status.code == 0) {
//           $(".prompt").css("color", "green");
//           $(".prompt").html(status.message);
//           location.href = "http://dev.admin.carrots.ptteng.com";
//         }
//       }
//     }
//   };
//   var formData = new FormData();
//   formData.append("name",$("[type='text']").val());
//   formData.append("pwd",$("[type='password']").val());
//   console.log(formData);
//   xhr.open("POST","/carrots-admin-ajax/a/login",true);
//   xhr.send(formData);
});

angular.module('app',['ngMessages']).controller('myCtrl',MainCtrl);

function MainCtrl() {

}