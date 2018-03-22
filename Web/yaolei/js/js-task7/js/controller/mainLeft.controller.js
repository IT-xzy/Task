angular.module('myApp').controller('mainLeft',(function ($scope,$http) {
    $scope.logOut = function () {
        $http({
            method: 'post',
            url: '/carrots-admin-ajax/a/logout'
        }).then(function successCallback(data){
            console.log(data)
        })
    }
}));