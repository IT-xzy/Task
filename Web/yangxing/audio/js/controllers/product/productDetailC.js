'use strict';
angular.module('admin')
    .controller('productDetailC', function ($scope, $state, adminService, $rootScope) {
        var vm = this;
        vm.params = $state.params;
        var id = vm.params.id;
        if(id){
            adminService.productDetail(id).then(function (res) {
                if(res.data.code==0){
                    vm.product=res.data.data
                }else {
                    $rootScope.alert(res.data.message)
                }
            })
        }

        vm.updateProduct = function () {
            var productCopy = angular.copy(vm.product);
            if (id) {
                //编辑
                adminService.productEdit(id,productCopy).then(function (res) {
                    if(res.data.code==0){
                        $rootScope.confirm('编辑成功',function () {
                            $state.go('field.productCustomer', {status: 1, size: 10000000}, {reload: true})
                        })
                    }else {
                        $rootScope.alert(res.data.message)
                    }
                })

            } else {
                var productCopy = angular.copy(vm.product);
                //默认值
                productCopy.type = 1;
                productCopy.status = 0;
                productCopy.sort = 1;
                //新增
                adminService.productAdd(productCopy).then(function (res) {
                    if (res.data.code == 0) {
                        $state.go('field.productCustomer', {status: 1, size: 10000000}, {reload: true})
                    } else {
                        $rootScope.alert(res.data.message)
                    }
                })

            }
        };
        //取消
        vm.cancel=function () {
            history.back()
        };
    });