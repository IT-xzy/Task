angular.module('zcjApp').controller('backstageCtrl',['$scope','$state','$http',function ($scope,$state,$http) {
  //退出登录ajax
  $scope.logout = function () {
    $scope.goLogout = {
      method:'post',
      url:"/carrots-admin-ajax/a/logout",
      headers: {
        'Content-Type':'application/x-www-form-urlencoded'
      }
    };
    $http($scope.goLogout).then(function (value) {
      $state.go('login');
    });
  };
  //侧边栏箭头变化
  $scope.hideToggle = function () {
    if($scope.hideTwo){
      $scope.hideTwo = false;
    }
    $scope.hideOne = !$scope.hideOne;
  };
  //侧边栏箭头变化
  $scope.hiToggle = function () {
    if($scope.hideOne){
      $scope.hideOne = false;
    }
    $scope.hideTwo = !$scope.hideTwo;
  };
  $scope.state = $state;
  //侧边栏刷新保持状态
  if($state.includes('backstage.Company')||$state.includes('backstage.Position')){
    $scope.hideOne = true;
  }else if($state.includes('backstage.ArticleList')){
    $scope.hideTwo = true;
  }
}]);