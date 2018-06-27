'use strict';
angular.module('admin')
    .controller('mediumStaCtr',function ($state, $rootScope, adminService, commonUtil) {
        var vm = this;
        vm.params = $state.params;
        vm.params.startTime = vm.params.startTime ? parseInt(vm.params.startTime) : '';
        vm.params.endTime = vm.params.endTime ? parseInt(vm.params.endTime) : '';
        adminService.mediumStatistics(vm.params).then(function (res) {
            if (res.data.code === 0) {
                vm.list = res.data.data;
                vm.data = res.data;
                //计算总页数
                vm.totalPage = Math.ceil(res.data.total / res.data.size);
            } else {
                $rootScope.alert(res.data.message)
            }
        })
        adminService.mediumStatistics({size:1000000}).then(function (res) {  //要考虑传很大的size把所有列表请求到
            if (res.data.code === 0) {
                vm.mediumList = res.data.data;
            } else {
                $rootScope.alert(res.data.message)
            }
        })
        // 搜索
        vm.search = function () {
            // 给日期参数加上时间戳
            commonUtil.querySearchParams(vm.params);
            $state.go($state.current, vm.params, {reload: true});
        }
        // 重置
        vm.clear = function () {
            angular.forEach(vm.params, function (item, index, array) {
                array[index] = "";
            });
            vm.params.page = 1;
            $state.go($state.current, vm.params, {reload: true});
        }
        // 跳转对应的用户列表
        vm.goUser = function (item, status) {
            if (status === 'ids'){
                var ids = angular.fromJson(item)
                if (ids.length<=1) {
                    ids.push(0)
                }
                $state.go("field.user",{
                    ids:ids
                },{reload:true})
            }
            if (status === 'all'){
                item = angular.fromJson(item.newIds).concat(angular.fromJson(item.oldIds))
                if (item.length<=1) {
                    item.push(0)
                }
                $state.go("field.user",{
                    ids:item.length==0?[0]:item
                },{reload:true})
            }
        }
    })