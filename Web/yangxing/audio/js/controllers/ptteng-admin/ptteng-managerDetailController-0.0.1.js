'use strict';
angular.module('admin')
    .controller('ManagerDetailCtrl', ['$state', '$scope', '$rootScope', 'commonUtil', 'managerService', 'roleService', '$window',ManagerDetailCtrl]);
function ManagerDetailCtrl($state, $scope, $rootScope, commonUtil, managerService, roleService,$window) {
    var vm = $scope.vm = {};
    vm.id = $state.params.id;
    vm.name = $state.params.name;

    var roleParam = { size: 65535 };

    $scope.roleList = {};

    managerService.getManager(vm.id).then(function (res) {
        vm.data = res.data.data.manager;
    });

    roleService.getRoleList(roleParam).then(function (res) {
        if (res.data.code == 0) {

            roleService.batchGetRole(res.data.data.ids).then(function (res) {

                if (res.data.code == 0) {
                    vm.roleList = res.data.data.roleList;


                } else {
                    commonUtil.showErrMsg(res);
                }
            });
        } else {
            commonUtil.showErrMsg(res);
        }

    });
    //下拉条
    roleService.getRoleList(/*roleParam*/).then(function (res) {
        if (res.data.code == 0) {

            roleService.batchGetRole(res.data.data.rids).then(function (res) {
                if (res.data.code == 0) {
                    vm.roleList = res.data.data.roleList;
                } else {
                    commonUtil.showErrMsg(res);
                }
            });
        } else {
            commonUtil.showErrMsg(res);
        }
        console.log("res" + res.data.data)
    });
    //下拉条结束


    vm.saveOrUpdate = function () {

        managerService.saveOrUpdateManager($state.params.id, $scope.vm.data, "field.manager");

    }
    //返回之前的页面：优惠卡券查看管理员详情之用
    vm.cancelCard = function () {
        $window.history.back();
    };

}