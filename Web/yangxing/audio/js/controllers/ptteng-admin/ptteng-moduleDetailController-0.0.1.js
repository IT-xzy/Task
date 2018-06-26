'use strict';
angular.module('admin')
    .controller('ModuleDetailCtrl',['$state','$scope', '$rootScope','commonUtil','moduleService',ModuleDetailCtrl]);
        function ModuleDetailCtrl($state,$scope, $rootScope,commonUtil,moduleService) {
        var vm = $scope.vm = {};
        vm.id = $state.params.id;

        if (vm.id) {
            moduleService.getModule(vm.id).then(function(res) {
                if (res.data.code == 0) {
                    vm.data = res.data.data.module;
                }else{
                    commonUtil.showErrMsg(res);
                }
            });
        }



        vm.saveOrUpdate = function () {

            moduleService.saveOrUpdateModule($state.params.id,$scope.vm.data,"field.module");


        }

    }