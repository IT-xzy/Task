'use strict';
angular.module('admin')
    .controller('linkCtr',function ($scope, $state, $rootScope, adminService) {
        var vm = this;
        vm.params = $state.params;
        adminService.mediumLink(vm.params).then(function (res) {
            if (res.data.code === 0) {
                vm.mediumLink = res.data.data;
            } else {
                $rootScope.alert(res.data.message)
            }
        })

        // 搜索
        vm.search = function () {
            $state.go($state.current, vm.params, {reload: true});
        }
        // 重置
        vm.clear = function () {
            vm.params.page = 1;
            vm.params.link = "";
            $state.go($state.current, vm.params, {reload: true});
        }
        // 新增
        vm.addLink = function () {
            adminService.addMediumLink(vm.params).then(function (res) {
                if (res.data.code === 0) {
                    $rootScope.alert("新增链接成功",function () {
                        $state.go($state.current,{},{reload:true})
                    })
                } else {
                    $rootScope.alert(res.data.message)
                }
            })
        }

        // 删除
        vm.delete = function (id) {
            vm.params.id = id;
            vm.content = "确认要删除该链接吗？删除不可撤销";
            $rootScope.confirm(vm.content, function(){
                adminService.removeMediumLink(vm.params.id).then(function (res) {
                    if (res.data.code === 0) {
                        $rootScope.alert("删除链接成功",function () {
                            $state.go($state.current,{},{reload:true})
                        })
                    } else {
                        $rootScope.alert(res.data.message)
                    }
                })
            },function () {
                // 点击取消执行的函数
            })
        }
        // 跳转排序
        vm.goSort=function (li) {
            $state.go("field.productCustomer",{linkId:li.id,from:'link'},{reload:true})
        }
    })