angular.module("myApp")
    .controller("mainCtrl", function ($rootScope,$scope,$state) {
        $rootScope.state=$state;
        // console.log($rootScope.state)
});