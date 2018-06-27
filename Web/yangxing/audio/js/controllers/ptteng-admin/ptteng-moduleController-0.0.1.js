'use strict';
angular.module('admin')
    .controller('ModuleCtrl', ['$state','$filter', '$scope', '$rootScope', 'commonUtil', 'moduleService', 'roleService',ModuleCtrl]);
        function ModuleCtrl($state,$filter, $scope, $rootScope, commonUtil, moduleService, roleService) {
        var vm = $scope.vm = {};
        vm.params = {
            size: 10000,
            page: 1
        };
        moduleService.getModuleList(vm.params).then(function (res) {
            if (res.data.code == 0) {
                vm.next = res.data.data.next;
                vm.totalPage  = Math.ceil(res.data.data.total / $state.params.size);
                moduleService.batchGetModule(res.data.data.ids).then(function(res){
                  vm.list = res.data.data.moduleList;
                  //按level排序
                  vm.list = $filter("orderBy")(vm.list, "-(level||0)");
                  //按照page和size放入数组
                  vm.list = vm.list.slice($state.params.size*($state.params.page-1),$state.params.size*$state.params.page);
                })
            } else {
                commonUtil.showErrMsg(res);
            }
        });

        vm.delete = function (id) {
            $rootScope.confirm("您确定要删除吗？", function () {
                moduleService.deleteModule(id).then(function (res) {
                    commonUtil.showReturnMsg(res, "field.module");
                });
            });
        };
    }