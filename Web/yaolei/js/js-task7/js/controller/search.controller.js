angular.module('myApp').controller('search', function ($scope,$http,$state) {
    $scope.dat1 = new Date();
    $scope.dat2 = new Date();
    $scope.format = "";
    $scope.altInputFormats = ['yyyy/M!/d!'];

    $scope.popup1 = {
        opened: false
    };
    $scope.popup2 = {
        opened: false
    };
    $scope.open1 = function () {
        $scope.popup1.opened = true;
    };
    $scope.open2 = function () {
        $scope.popup2.opened = true;
    };
    $scope.clear = function () {
        $state.go("houtai.js6-2",{page:1})
    }
});