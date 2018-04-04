angular.module('zcjApp').controller('loginCtrl',['$scope','$http','$state',function ($scope,$http,$state){

  $scope.change = false;     //用户名表单验证变量

  //ajax登录
  $scope.loginduo = function () {
    $scope.data = {                     //发送出去的数据
      name: $scope.user,
      pwd: $scope.password
    };
    $scope.req = {
      method: 'POST',
      url: "/carrots-admin-ajax/a/login",
      params:$scope.data,
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded'
      }
    };
    $http($scope.req).then(function (response) {
      if (response.data.code == 0) {
        $state.go("backstage");
      }
      else {
        $scope.message = response.data.message;
      }
    });
  };
}]);