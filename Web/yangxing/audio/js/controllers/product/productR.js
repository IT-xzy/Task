'use strict';
angular.module('admin')
    .controller('ProductCtrR', function ($scope, $state, adminService, $rootScope, $timeout, $filter) {
        var vm = this;
        vm.params = $state.params;
        vm.params.type = 2;
        vm.params.size = 1000000;
        var mediumId = vm.params.mediumId ? vm.params.mediumId * 1 : vm.params.mediumId;
        var linkId = vm.params.linkId ? vm.params.linkId * 1 : vm.params.linkId;
        var from = vm.params.from;


        function productList(params) {
            adminService.productList(params).then(function (res) {
                if (res.data.code === 0) {
                    vm.productList = res.data.data;
                } else {
                    $rootScope.alert(res.data.message)
                }
            });
        }

        productList(vm.params);

        //排序
        //排序插件的配置
        vm.sortableOptions = {
            stop: function (e, ui) {
                $timeout(function () {
                    vm.resArr = [];
                    for (var y = 0; y < vm.productList.length; y++) {
                        vm.resArr.push(vm.productList[y].id);
                    }
                })
            },
            disabled: true
        };

        //变为能排序状态
        vm.sort = function () {
            productList(vm.params);
            vm.sortableOptions.disabled = false;
        };
        vm.sortC = function () {
            $state.go("field.productCustomer", vm.params, {
                reload: true
            });
        };
        //排序要的参数
        var sortType = 1;
        if (from == "medium") {
            sortType = 2
        } else if (from == "link") {
            sortType = 3
        } else {
            sortType = 1;
        }
        var sortPar = {
            type: sortType,
            productType: 2,//写死的
            mediumId: mediumId,
            linkId: linkId
        };

        //保存排序
        vm.sortSave = function () {
            $rootScope.confirm("确认保存排序？", function () {
                vm.sortableOptions.disabled = true;
                vm.stageArr = []; //用来装排序后的id
                //把排序后的id装进数组
                angular.forEach(vm.productList, function (value, key) {
                    vm.stageArr.push(value.id)
                }, vm.stageArr);

                //排序请求
                sortPar.ids = vm.stageArr;
                adminService.productSort(sortPar).then(function (res) {
                    if (res.data.code === 0) {
                        $state.go('field.productRecommend', vm.params, {reload: true});
                        $rootScope.alert("排序成功");
                    } else {
                        $state.go($state.current, {reload: true});
                        $rootScope.alert(res.data.message);
                    }
                }).catch(function (reason) {
                    $rootScope.alert("请求错误");
                });

            });
        };

        //取消排序
        vm.sortCancel = function () {
            $rootScope.confirm("确定取消排序？", function () {
                $state.go($state.current, vm.params, {
                    reload: true
                });
                vm.sortableOptions.disabled = true;
            });
        };
        //排序
        //产品上下架
        vm.updateProStatus = function (li) {
            var newData = angular.copy(li);
            if (newData.status == 0) {
                newData.status = 1
            } else {
                newData.status = 0
            }
            var proStatus = {
                0: '下架',
                1: '上架'
            };
            //发送请求
            var str = $filter('statusFilter')(li.status == 0 ? 1 : 0, 'proStatus');
            $rootScope.confirm('确认' + str + '？', function () {
                adminService.updateProStatus(li.id, newData.status).then(function (res) {
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
        };
        //搜索
        vm.search = function () {
            vm.params.page = 1;
            $state.go($state.current, vm.params, {
                reload: true
            });
        };
        //重置
        vm.clear = function () {
            vm.params.name = '';
            vm.params.status = '';
            vm.params.size = 1000000;
            $state.go($state.current, vm.params, {
                reload: true
            });
        };


    });