'use strict';
angular.module('admin')
    .controller('bannerDetailCtr', function ($scope, $state, adminService, $rootScope) {
        var vm = this;
        vm.params = $state.params;
        var id = vm.params.id;
        if(id){
            adminService.bannerDetail(id).then(function (res) {
                if(res.data.code==0){
                    vm.banner=res.data.data
                }else {
                    $rootScope.alert(res.data.message)
                }
            })
        }

        vm.updateBanner = function () {
            var bannerCopy = angular.copy(vm.banner);
            if (id) {
                //编辑
                adminService.bannerEdit(id,bannerCopy).then(function (res) {
                    if(res.data.code==0){
                        $rootScope.confirm('编辑成功',function () {
                            $state.go('field.banner', {page: 1, size: 10}, {reload: true})
                        })
                    }else {
                        $rootScope.alert(res.data.message)
                    }
                })

            } else {
                var bannerCopy = angular.copy(vm.banner);
                //默认值
                bannerCopy.status = 1;
                //新增
                adminService.bannerAdd(bannerCopy).then(function (res) {
                    if (res.data.code == 0) {
                        $state.go('field.banner', {page: 1, size: 10}, {reload: true})
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