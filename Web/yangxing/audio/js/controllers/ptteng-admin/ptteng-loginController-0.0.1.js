'use strict';
angular.module('admin')
    .controller('LoginCtrl',['$scope', 'loginService', 'managerService','$state', '$timeout', '$cookies',LoginCtrl]);
        function LoginCtrl($scope, loginService, managerService,$state, $timeout, $cookies) {
        var vm = $scope.vm = {};
        vm.name = "";
        vm.pwd = "";
        $scope.submit = function() {
            loginService.login({name: vm.name, pwd: vm.pwd}).then(function(res) {
                if (res.data.code == 0) {
                    $cookies.login = "true";
                    $state.go("field.home");
                    managerService.saveSelfDetail(res.data.data);
                } else {
                    vm.errorTip = res.data.message;
                    $timeout(function() {
                        vm.errorTip = "";
                    }, 3000);
                }
            });
        };
    }