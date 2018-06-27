'use strict';

angular.module('admin')
    .directive('sidebar', ['$location', function () {
        return {
            templateUrl: 'js/directives/ptteng-sidebar/ptteng-sidebar-0.0.1.html',
            restrict: 'E',
            replace: true,
            scope: {},
            controller: function ($scope, $filter, roleService, managerService, $rootScope, $state, moduleService, commonUtil, $http) {

                var self = managerService.getSelfDetail();
                if (self == undefined) {
                    $rootScope.alert("您还未登录", function () {
                        $state.go("login");
                    });

                    return false;
                } else {
                    $rootScope.uid = self.role.id;
                }
                // //请求模块
                // roleService.getRoleModule(self.role.id).then(function (res) {
                //     if (res.data.code == 0) {
                //         moduleService.batchGetModule(res.data.data.mids).then(function (res) {
                //             if (res.data.code == 0) {
                //                 $scope.sideList = commonUtil.buildTree(res.data.data.moduleList);
                //                 // 刷新时的高亮标识
                //                 markLightFromUrl();
                //             }
                //         })
                //     }
                // });

                $scope.sideList = [
                    {
                        "id": 100,
                        "icon": "",
                        "parentID": 0,
                        "name": "客户管理",
                        "menuID": "",
                        "url": "",
                        "nodes": [
                            {
                                "id": 101,
                                "icon": "",
                                "parentID": 100,
                                "name": "分单客户",
                                "menuID": "",
                                "url": "field.productCustomer({status:1,size:10000000})",
                            },
                            {
                                "id": 102,
                                "icon": "",
                                "parentID": 100,
                                "name": "推荐客户",
                                "menuID": "",
                                "url": "field.productRecommend({status:1,size:10000000})",
                            }
                        ]
                    },
                    {
                        "id": 200,
                        "icon": "",
                        "parentID": 0,
                        "name": "用户管理",
                        "menuID": "",
                        "url": "",
                        "nodes": [
                            {
                                "id": 201,
                                "icon": "",
                                "parentID": 200,
                                "name": "用户列表",
                                "menuID": "",
                                "url": "field.user",
                            }
                        ]
                    },
                    {
                        "id": 300,
                        "icon": "",
                        "parentID": 0,
                        "name": "媒介管理",
                        "menuID": "",
                        "url": "",
                        "nodes": [
                            {
                                "id": 301,
                                "icon": "",
                                "parentID": 300,
                                "name": "媒介列表",
                                "menuID": "",
                                "url": "field.medium({status:1})",
                            },
                        ]
                    },
                    {
                        "id": 400,
                        "icon": "",
                        "parentID": "",
                        "name": "统计管理",
                        "menuID": "",
                        "url": "",
                        "nodes": [
                            {
                                "id": 401,
                                "icon": "",
                                "parentID": 400,
                                "name": "分单统计",
                                "menuID": "",
                                "url": "field.productSta",
                            },
                            {
                                "id": 402,
                                "icon": "",
                                "parentID": 400,
                                "name": "媒介统计",
                                "menuID": "",
                                "url": "field.mediumSta",
                            }
                        ]
                    },
                    {
                        "id": 500,
                        "icon": "",
                        "parentID": "",
                        "name": "banner管理",
                        "menuID": "",
                        "url": "",
                        "nodes": [
                            {
                                "id": 501,
                                "icon": "",
                                "parentID": 500,
                                "name": "banner列表",
                                "menuID": "",
                                "url": "field.banner",
                            }
                        ]
                    },
                    {
                        "id": 600,
                        "icon": "",
                        "parentID": "",
                        "name": "账户管理",
                        "menuID": "",
                        "url": "",
                        "nodes": [
                            {
                                "id": 601,
                                "icon": "",
                                "parentID": 600,
                                "name": "新建账户",
                                "menuID": "",
                                "url": "field.manager",
                            },
                            {
                                "id": 602,
                                "icon": "",
                                "parentID": 600,
                                "name": "修改密码",
                                "menuID": "",
                                "url": "field.pwd",
                            }
                        ]
                    }
                ];

                markLightFromUrl();
                // $http.get('sidebar.json').then(function (res) {
                //     console.log(res);
                //     $scope.sideList=res.data.data.moduleList;
                //     console.log($scope.sideList);
                //     markLightFromUrl();
                // });

                $scope.getUrl = function (n) {
                    $scope.currentUrl = n.url;
                };

                //倒叙排列数组
                function compare(property) {
                    return function (a, b) {
                        var value1 = a[property];
                        var value2 = b[property];
                        return value2 - value1;
                    }
                }

                function markLightFromUrl() {
                    $scope.sideList.sort(compare('level'));
                    angular.forEach($scope.sideList, function (items, index) {
                        angular.forEach(items.nodes, function (item, i) {
                            var stateName = $state.current.name;//filed.daily
                            // 检查配置的url里是否有()
                            var itemParam = item.url.match(/\{[^\)]+\}/g);//{page:10}

                            // url去掉（）以及里面的内容
                            var cleanUrl = item.url.replace(/\([\s\S]*\)/g, "");


                            if (cleanUrl === stateName && !itemParam) { // 没有（）的，直接展开相应列，并高亮
                                // 展开项
                                $scope.collapseVar = index;
                                // 普通已选子菜单
                                item.selected = true;
                                return false;


                            } else if (cleanUrl === stateName && !!itemParam) { // 有（）的，展开相应列，进一步判断（）中的高亮
                                // 展开项
                                $scope.collapseVar = index;
                                // 特殊已选子菜单,需要通过参数来进行对比判断
                                specialRules(item, itemParam);
                                return false;
                            }
                            // else if(cleanUrl!==stateName){
                            //     console.log('侧边栏的URL不包含路由里的URL，那么用侧边栏里的某一项的下标作为展开项，所以要先存起来么？');
                            // }
                        })
                    })
                }

                function specialRules(item, itemParam) {
                    var itemParamString = itemParam[0].replace(/(['"])?([a-zA-Z0-9_]+)(['"])?:/g, '"$2": ');
                    var itemParamJSON = JSON.parse(itemParamString);
                    //特殊路由保持高亮
                    if (($state.current.name == 'field.productCustomer' || $state.current.name == 'field.productRecommend' || $state.current.name == 'field.medium') && itemParamJSON.status != undefined) {
                        // if ($state.params.status == itemParamJSON.status) {
                        //     item.selected = true;
                        //     return false;
                        // } else {
                        //
                        // }
                        item.selected = true;
                        return false;
                    }
                    else if ($state.current.name == 'field.server' && itemParamJSON.type != undefined) {
                        if ($state.params.type == itemParamJSON.type) {
                            item.selected = true;
                            return false;
                        }
                    }
                    else if ($state.current.name == 'field.userList') {
                        //用户管理
                        if ($state.params.branch == itemParamJSON.branch) {
                            item.selected = true;
                            return false;
                        } else {
                            if ($state.params.branch === "" && itemParamJSON.branch === undefined) {
                                item.selected = true;
                                return false;
                            }
                        }
                    }
                    else if ($state.current.name == 'field.contentsList' && itemParamJSON.type != undefined) {
                        if ($state.params.type == itemParamJSON.type) {
                            item.selected = true;
                            return false;
                        }
                    }

                }

                //ng-repeat的orderBy的函数
                $scope.orderIt = function (item) {
                    return -(item.level || 0);
                };
            }
        }
    }]);
