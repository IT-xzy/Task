'use strict';
angular.module('admin')
    .controller('UserCtr', function ($state, adminService, $rootScope,commonUtil) {
        var vm = this;
        vm.params = $state.params;
        vm.params.registerStart = vm.params.registerStart ? parseInt(vm.params.registerStart) : '';
        vm.params.registerEnd = vm.params.registerEnd ? parseInt(vm.params.registerEnd) : '';
        adminService.usrList(vm.params).then(function (res) {
            if (res.data.code === 0) {
                vm.usrList = res.data.data.userList;
                vm.productInfo = res.data.data.productInfo;
                vm.mediumList = res.data.data.mediumList;
                angular.forEach(vm.usrList, function (user) {
                    var belongs = vm.productInfo[user.id];
                    if (belongs) {
                        user.belongStr = vm.productInfo[user.id].join("、");
                    }
                    angular.forEach(vm.mediumList,function (medium) {
                        if(user.source==medium.id){
                            user.mediumName=medium.name;
                        }
                    })
                });
                vm.total = res.data.total;
                //计算总页数
                vm.totalPage = Math.ceil(res.data.total / res.data.size);
            } else {
                $rootScope.alert(res.data.message)
            }
        });
        //获取媒介来源和媒介链接
        adminService.mediumList({size:1000000}).then(function (res) {
            if (res.data.code === 0) {
                vm.mediumListSearch = res.data.data;
                //要考虑传很大的size把所有列表请求到
                vm.getLinkList = function (mid,par) {
                    if(mid){
                        adminService.mediumLinkS(mid,{size:100000}).then(function (res) {
                            if (res.data.code == 0) {
                                vm.mediumLink = res.data.data;
                            }
                        });
                    }else{
                        vm.mediumLink=''
                    }

                };
                //没有change事件就用URL里的参数
                if ($state.params.source) {
                    vm.getLinkList($state.params.source,{size:100000})
                }
            } else {
                $rootScope.alert(res.data.message)
            }
        });
        //获取分单客户
        function productList(params) {
            adminService.productList(params).then(function (res) {
                if (res.data.code === 0) {
                    vm.productList = res.data.data;
                } else {
                    $rootScope.alert(res.data.message)
                }
            });
        }

        productList({type:1,size:100000});

        //导出用户列表
        vm.output=function(){
            var ids = [];
            if (vm.params.ids){
                ids = vm.params.ids.join("&ids=")
            }
            delete vm.params.ids;
            var url = "/admin/u/user/list?output=1&"+(ids.length>0?'ids='+ids:''+'&'+$.param(vm.params));
            var $form = $('<form method="post"></form>');
            $form.attr('action', url);
            $(document.body).append($form);
            $form.submit();
        };

        //搜索
        vm.search = function () {
            // 给日期参数加上时间戳
            commonUtil.querySearchParams(vm.params);
            $state.go($state.current, vm.params, {
                reload: true
            });
        };
        //重置
        vm.clear = function () {
            angular.forEach(vm.params, function (item, index, array) {
                array[index] = "";
            });
            vm.params.page = 1;
            $state.go($state.current, vm.params, {
                reload: true
            });
        };
    });