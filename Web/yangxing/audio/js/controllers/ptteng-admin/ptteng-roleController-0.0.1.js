'use strict';
angular.module('admin')
    .controller('RoleCtrl', ['$state', '$scope', '$rootScope', 'commonUtil', 'roleService',RoleCtrl]);
        function RoleCtrl($state, $scope, $rootScope, commonUtil, roleService) {

        var vm = $scope.vm = {};
        vm.id = $state.params.ids;
        roleService.getRoleList().then(function (res) {
            if (res.data.code == 0) {
                vm.totalPage=Math.ceil(res.data.data.total/res.data.data.size);
                roleService.batchGetRole(res.data.data.rids).then(function (res) {
                    if (res.data.code == 0) {
                        vm.list = res.data.data.roleList;
                    } else {
                        commonUtil.showErrMsg(res);
                    }
                    // console.log(res.data)
                });

            } else {
                commonUtil.showErrMsg(res);
            }
        });
        vm.delete = function (id) {

            $rootScope.confirm("您确定要删除吗？", function () {
                roleService.deleteRole(id).then(function (res) {

                    commonUtil.showReturnMsg(res, "field.role");

                });
            });

        };
    }
