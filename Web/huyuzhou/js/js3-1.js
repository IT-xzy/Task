  // $("#submit").click(function(){
//   var aaa=$("#user").val();
//   var bbb=$("#word").val();
//   var xhr = new XMLHttpRequest();
//
//   // 指定通信过程中状态改变时的回调函数
//   xhr.onreadystatechange = function(){
//     // 通信成功时，状态值为4
//     if (xhr.readyState === 4){
//       if (xhr.status === 200){
//         console.log(xhr.responseText);
//         var data=xhr.responseText;
//         var jsondata=JSON.parse(data)
//         if (jsondata.code===0) {
//           location.href="js3-2.html"
//         }else{
//             $(".message").text(jsondata.message)
//         }
//       } else {
//         console.error(xhr.statusText);
//       }
//     }
//   };
//
//   xhr.onerror = function (e) {
//     console.error(xhr.statusText);
//   };
//   // open方式用于指定HTTP动词、请求的网址、是否异步
//     xhr.open('POST', 'http://localhost//carrots-admin-ajax/a/login?name='+aaa+'&pwd='+bbb, true);
//   // 发送HTTP请求
//   xhr.send();
// })



var app = angular.module("myApp", ["ngMessages"]);



app.controller("myCtrl", function($scope,$http,$log) {
  $scope.user={};
  $scope.login = function()
  {
      $log.info("点击了按钮");
  }



  $scope.subMit=function(){
      console.log($scope.user)
      $http({
        method:"POST",
        url:'http://localhost:5000//carrots-admin-ajax/a/login?name='+$scope.user.name+'&pwd='+$scope.user.password
      }).then(function success(response){
        console.log(response);
        if (response.data.code===0) {
          location.href="js3-2.html"
        }else{
          $(".message").text(response.data.message)
        }
      },function err(response){
        console.log(response)
        alert("false")
      });
  }
});
// name=aaa&pwd=bbb
