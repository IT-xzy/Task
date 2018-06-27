'use strict';
angular.module('admin')
    .controller('productStaCtr',function ($state, $rootScope, adminService, commonUtil) {
        var vm = this;
        vm.params = $state.params;
        vm.params.startTime = vm.params.startTime ? parseInt(vm.params.startTime) : '';
        vm.params.endTime = vm.params.endTime ? parseInt(vm.params.endTime) : '';

        adminService.productStatistics(vm.params).then(function (res) {
            if (res.data.code === 0) {
                vm.list = res.data.data;
                vm.data = res.data;
                //计算总页数
                vm.totalPage = Math.ceil(res.data.total / res.data.size);
            } else {
                $rootScope.alert(res.data.message)
            }
        })
        adminService.productStatistics({size:1000000}).then(function (res) {  //要考虑传很大的size把所有列表请求到
            if (res.data.code === 0) {
                vm.productNameList = res.data.data; // 渲染下拉出菜单数据
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
        vm.goUser = function (item) {
            $state.go("field.user",{
                productId: item.productId,
                startTime: commonUtil.setStartDate(item.createAt), //当前项时间的0点0分0秒
                endTime: commonUtil.setEndDate(item.createAt) //当前项时间的23点59分59秒
            },{reload:true})
        }
    })