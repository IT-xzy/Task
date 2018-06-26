var app = angular.module('myApp',['ngMessages']);
app.controller('myCtrl',function ($scope,$http) {
   $scope.name='';
   $scope.passworld='';
   $scope.send =function () {
       console.log($scope.name);
       console.log($scope.passworld);
   $http({
       method:'post',
       url:'http://localhost//carrots-admin-ajax/a/login',
       headers:{
           "Content-Type":"application/x-www-form-urlencoded;"
       },
       params:{
           name:$scope.name,
           pwd:$scope.passworld
       }
   }).then(function back(omg) {
       // console.log(response.data.code);
       console.log(omg.data.message);
       $scope.list=omg.data.message;
       if(omg.data.code===0){
           alert('登录成功');
           window.location.href='JS6-1.html'
       }
   },function error(response) {
       // console.log(response);
       //  alert('登录失败')
   });
   };
});

