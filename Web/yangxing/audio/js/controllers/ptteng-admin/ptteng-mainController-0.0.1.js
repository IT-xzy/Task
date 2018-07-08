'use strict';
angular.module('admin')
    .controller('MainCtrl', ['$scope', '$rootScope', '$state',MainCtrl]);
        function MainCtrl($scope, $rootScope, $state) {
        // 是否登录检测，否则跳转到登录页
        if (!$rootScope.isLogin()) {
            $rootScope.alert("您还未登录", function() {
                $state.go("login");
            });
        }
        $scope.startcounter = 0;
        $scope.startSpin = function() {
            if (!$scope.spinneractive) {
                usSpinnerService.spin('spinner-1');
                $scope.startcounter++;
            }
        };

        $scope.stopSpin = function() {
            if ($scope.spinneractive) {
                usSpinnerService.stop('spinner-1');
            }
        };
        $scope.spinneractive = false;

        $rootScope.$on('us-spinner:spin', function(event, key) {
            $scope.spinneractive = true;
        });

        $rootScope.$on('us-spinner:stop', function(event, key) {
            $scope.spinneractive = false;
        });


    }