'use strict';
angular.module('admin')
    .controller('bannerCtr', function ($scope, $state, adminService, $rootScope,$filter) {
        var vm = this;
        vm.params = $state.params;
        //banner列表
        adminService.bannerList(vm.params).then(function (res) {
            if(res.data.code==0){
                vm.bannerList=res.data.data;
                //计算总页数
                vm.totalPage = Math.ceil(res.data.total / res.data.size);
            }else {
                $rootScope.alert(res.data.message)
            }
        });
        //banner上下架
        vm.updateBanStatus = function (li) {
            var newData = angular.copy(li);
            if (newData.status == 0) {
                newData.status = 1
            } else {
                newData.status = 0
            }
            var banStatus = {
                0: '下架',
                1: '上架'
            };

            //当banner只剩下一个上架时，如果再下架则给提示
            vm.num = 0;
            for (var i = 0; i < vm.bannerList.length; i++) {
                if(vm.bannerList[i].status === 1) {
                    vm.num++;
                }
            }

            //发送请求
            var str = $filter('statusFilter')(li.status == 0 ? 1 : 0, 'banStatus');
            if(newData.status === 1) { //点击的是上架按钮
                $rootScope.confirm('确认' + str + '？', function () {
                    adminService.updateBanStatus(li.id, newData.status).then(function (res) {
                        if (res.data.code == 0) {
                            $rootScope.alert(str + '成功', function () {
                                $state.go($state.current, vm.params, {
                                    reload: true
                                });
                            })
                        } else {
                            $rootScope.alert(res.data.message)
                        }
                    });
                });
            } else if(newData.status === 0) { //点击的是下架按钮
                if(vm.num === 1) {
                    $rootScope.alert("只剩一个banner，请上架其他banner后重试")
                } else {
                    $rootScope.confirm('确认' + str + '？', function () {
                        //还没有接口地址
                        adminService.updateBanStatus(li.id, newData.status).then(function (res) {
                            if (res.data.code == 0) {
                                $rootScope.alert(str + '成功', function () {
                                    $state.go($state.current, vm.params, {
                                        reload: true
                                    });
                                })
                            } else {
                                $rootScope.alert(res.data.message)
                            }
                        });
                    });
                }
            }
        };
        //删除banner
        vm.bannerDel=function (id) {
            $rootScope.confirm('确认要删除该banner吗 操作不可撤销！',function () {
                adminService.bannerDel(id).then(function (res) {
                    if(res.data.code==0){
                        $rootScope.alert('删除成功');
                        $state.go('field.banner', {page: 1, size: 10}, {reload: true});
                    }else {
                        $rootScope.alert(res.data.message)
                    }
                })
            })
        }
    });