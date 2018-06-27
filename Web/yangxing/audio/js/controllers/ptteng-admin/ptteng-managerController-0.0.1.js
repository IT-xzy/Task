'use strict';
angular.module('admin')
    .controller('ManagerCtrl', ['$state', '$scope', '$rootScope', 'commonUtil', 'managerService','roleService',ManagerCtrl]);
        function ManagerCtrl($state, $scope, $rootScope, commonUtil, managerService,roleService) {
        var vm = $scope.vm = {};
        $scope.rid_role={};
        vm.roleList=[];
        //var roleParam={size:65535};

        function getRoleList(rids) {
            roleService.batchGetRole(rids).then(function (res) {

                angular.forEach(res.data.data.roleList, function (data, index, array) {
                    $scope.rid_role[data.id] = data;
                });

                angular.forEach(vm.list, function (data, index, array) {
                    data.role = $scope.rid_role[data.roleID];
                });

            });
        }


        function getManagerList() {
            managerService.getManagerList().then(function (res) {
                if (res.data.code == 0) {
                    var managerTotal= res.data.data.total;
                    managerService.batchGetManager(res.data.data.ids).then(function (res) {
                        if (res.data.code == 0) {
                            vm.list = res.data.data.managerList;
                            vm.totalPage = Math.ceil(managerTotal / $state.params.size||10);
                            var rids = [];
                            angular.forEach(res.data.data.managerList, function (data) {
                            rids.push(data.roleID);

                            });
                                getRoleList(rids);
                        } else {
                            commonUtil.showErrMsg(res);
                        }
                    });

                } else {
                    commonUtil.showErrMsg(res);

                }
            });
        }

        getManagerList();


        vm.delete = function(id) {

            $rootScope.confirm("您确定要删除吗？", function() {
                managerService.deleteManager(id).then(function(res) {

                    commonUtil.showReturnMsg(res,"field.manager");
                });
            });

        };

        roleService.getRoleList(/*roleParam*/).then(function (res) {
            if (res.data.code == 0) {

                roleService.batchGetRole(res.data.data.rids).then(function (res) {
                    if (res.data.code == 0) {
                        vm.roleList= res.data.data.roleList;
                        vm.roleList.push({id:-1,name:"全部角色"});
                    } else {
                        commonUtil.showErrMsg(res);
                    }
                });
            } else {
                commonUtil.showErrMsg(res);
                }
            console.log("res"+res.data.data)
        });

        // search
        vm.rid = {};
        vm.search = function(){
            if(vm.rid<0){
                getManagerList();

            }else{
                searchManager(vm.rid);
            }

        };


        // init
        function searchManager(param) {

            roleService.getRoleManager(param).then(function (res) {
                if (res.data.code == 0) {

                    managerService.batchGetManager(res.data.data.ids).then(function (res) {
                        if (res.data.code == 0) {

                            vm.list= res.data.data.managerList;

                            getRoleList([param]);


                        } else {
                            commonUtil.showErrMsg(res);
                        }
                    })
                } else {
                    commonUtil.showErrMsg(res);
                }
            });
        }
    }