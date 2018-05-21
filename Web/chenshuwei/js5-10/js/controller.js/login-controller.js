angular
    .module("myApp")
    //登录页面
    .controller('myCtrl',['$scope','$http','$state', '$httpParamSerializer',function ($scope, $http, $state,$httpParamSerializer) {
        $scope.submit = function () {
            $http({
                method: 'POST',
                url: '/carrots-admin-ajax/a/login',
                data: $httpParamSerializer({name: $scope.account,pwd: $scope.password}),
                headers:{'Content-type':'application/x-www-form-urlencoded'}
            }).then(function (res) {
                console.log(res)
                if(res.data.code === 0){
                    $state.go("carrots",{},{reload:true});

                }
                else {
                    $scope.myText = res.data.message;
                }
            });

            //同步
        }
    }]);