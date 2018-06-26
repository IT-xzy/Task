// 登陆
app.controller("loginCtrl", function ($scope, $state, serviceHTTP){
    // 登录拦截
    // $scope.$on('$locationChangeStart', function (event, next, current) {
    //     // alert("请先登录！");
    //     event.preventDefault();
    // });
  var vm = this;
  vm.login = function () {  
        var user = {
            name:vm.name,
            pwd:vm.password
        };
        serviceHTTP.loginHTTP(user).then(function successCallback(res) {
            // 请求成功执行代码
            console.log(res);
            if (res.data.code == 0) {
              sessionStorage.setItem("user", JSON.stringify(user));
              $state.go("backstage");
            } 
            else {
              alert("请输入正确的用户名和密码！");
            }
          }, function errorCallback(res) {
            // 请求失败执行代码
          });
    }
});


