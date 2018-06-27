angular.module('app')
    .controller("loginCtrl", ["$scope", "$state",
        function ($scope, $state, $http ) {

            $scope.login =function () {
               alert(1)
            }
        }]);