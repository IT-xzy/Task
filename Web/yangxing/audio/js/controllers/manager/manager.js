angular.module('admin')
    .controller('managerCtr',function ($scope, $state, adminService,$rootScope) {
        var vm = this;
        vm.addManager=function(){
            //先默认给个超级管理的角色
            vm.data.role=1;
            adminService.addManager(vm.data).then(function (res) {
                if(res.data.code===0){
                    $state.go('field.home',{},{reload:true})
                }else {
                    $rootScope.alert(res.data.message)
                }
            });
        };
        //取消
        vm.cancel=function () {
            history.back()
        };
    });