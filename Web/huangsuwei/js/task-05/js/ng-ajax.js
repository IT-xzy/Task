app=angular.module("myApp",[]);
app.controller("login",function ($scope,$http) {
   $scope.inEnter=function () {
       $http({
           method:"POST",
           url:"/carrots-admin-ajax/a/login",
           params:$scope.params
       }).then(function successCallback(response){
           console.log(response);
           if (response.data.code===0){
           }else if (response.data.code!==0){
               alert(response.data.message)
           }
       });
   }
});

