//登陆请求
app.controller('loginPage',function ($scope,$http,$state,$stateParams) {
    $scope.login=function () {
        $http({
            method: 'POST',
            url: '/carrots-admin-ajax/a/login',
            params: {
                name:$scope.username,
                pwd: $scope.password
            }
        }).
        then(function successCallback(response) {
            if(response.data.code===0){
                $scope.loginMsg="登陆成功";
                $state.go('frameState')
            }else{
                $scope.loginMsg=response.data.message;
            }
            console.log(response);
            console.log($stateParams);
        });
    }
});
// app.controller('frameCtrl',function () {
//
// });


