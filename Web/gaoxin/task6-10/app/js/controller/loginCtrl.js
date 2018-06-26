 angular.module("myApp").controller("loginCtrl",function ($scope,$http, $state) {
    $scope.login = function() {
        $http({
            method: 'POST',
            url: '/carrots-admin-ajax/a/login',
            params:{name:$scope.account,pwd:$scope.password}
        })
            .then(function successCallback(back) {
                if (back.data.code === 0) {
                    $state.go('backstage');
                   sessionStorage.setItem('confirm','1')
                }
                else {
                    $scope.info=back.data.message;
                }
                console.log( back.data.message);
            }, function errorCallback(back) {

                console.log('connection error');
            });
    }
});

