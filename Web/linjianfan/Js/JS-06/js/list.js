app.controller('listCtrl', function ($scope, $http, $state, $stateParams, types, status, industry) {
    var theTwoName = sessionStorage.getItem('name');
    if (theTwoName){
        // 初始化页面数据
        $scope.params = $stateParams;
        // console.log($scope.params.startAt);
        // console.log(typeof $scope.params.startAt);
        $scope.listDateStart = Number($scope.params.startAt) || undefined;
        // console.log(typeof $scope.listDateStart);
        $scope.listDateEnd = Number($scope.params.endAt) || undefined;
        $scope.listTheType = $scope.params.type;
        $scope.listTheStatus = $scope.params.status;


        // 取出constant里面的types、status、industry
        $scope.types = types;
        $scope.status = status;
        $scope.industry = industry;


        // 请求后台数据
        $http({
            method: 'GET',
            url: '/carrots-admin-ajax/a/article/search',
            params: $scope.params
        }).then (function (response) {
            if (response.data.code == 0){
                $scope.articleList = response.data.data.articleList;
                $scope.totalItems = response.data.data.total;
                $scope.currentPage = $scope.params.page || 1;
                $scope.currentSize = $scope.params.size || 10;
            }else {
                alert('请求失败');
            }
        });


        // 日期插件
        // $scope.format = "yyyy/MM/dd";
        // $scope.altInputFormats = ['yyyy/MM/dd'];
        $scope.popup1 = {
            opened: false
        };
        $scope.popup2 = {
            opened: false
        };
        $scope.open1 = function () {
            $scope.popup1.opened = true;
        };
        $scope.open2 = function () {
            $scope.popup2.opened = true;
        };


        // 分页插件选择第几页
        $scope.listPickPage = function () {
            $state.go('home.list', {
                page: $scope.currentPage,
            }, {
                reload: true
            });
        };


        // 确认显示多少条数据以及跳转到第几页
        $scope.listToShow = function () {
            $state.go('home.list', {
                size: $scope.currentSize,
                page: $scope.listPagePicker,
            }, {
                reload: true
            });
        };


        // 清除按钮
        $scope.listClear = function () {
            $state.go('home.list', {
                type: undefined,
                status: undefined,
                startAt: undefined,
                endAt: undefined
            }, {
                reload: true
            })
        };


        // 搜索按钮
        $scope.listSearch = function () {
            // 判断当前开始日期是什么数据类型
            if ($scope.listDateStart == undefined){
                $scope.listDateStart = undefined;
            }else if (typeof $scope.listDateStart == "object"){
                $scope.listDateStart = Date.parse($scope.listDateStart);
            }else if (typeof $scope.listDateStart == "number"){
                $scope.listDateStart = $scope.listDateStart;
            }

            // 判断当前结束日期是什么数据类型
            if ($scope.listDateEnd == undefined){
                $scope.listDateEnd = undefined;
            }else if (typeof $scope.listDateEnd == "object"){
                $scope.listDateEnd = Date.parse($scope.listDateEnd);
                // 将数字转化为字符串
                $scope.yz = $scope.listDateEnd.toString();

                // 判断这个时间戳的倒数第4位是否等于0
                // 因为这里转换的是毫秒形式的时间戳，所以在进行对比的时候，当天的23:59:59用毫秒数表示末尾也是0
                // 所以要根据秒形式的时间戳来进行比较，也就是毫秒形式的倒数第4为数，看是否等于0
                // 若为0，则这个时间戳是0点，若不为0，则这个时间戳是23点的时间戳
                if (($scope.yz)[($scope.yz).length-4] === '0'){
                    $scope.listDateEnd = $scope.listDateEnd + 86399999;
                }else {
                    $scope.listDateEnd = $scope.listDateEnd;
                }
            }else if (typeof $scope.listDateEnd == "number"){
                $scope.listDateEnd = $scope.listDateEnd;
            }
            // 向后台发起请求
            $state.go('home.list', {
                type: $scope.listTheType,
                status: $scope.listTheStatus,
                startAt: $scope.listDateStart,
                endAt: $scope.listDateEnd
            }, {
                reload: true
            });
        };


        // 新增按钮
        $scope.listToDetail = function(){
            $state.go('home.detail', {
                // id: undefined
            })
        };


        // 上下线按钮状态判定
        $scope.listUpDown = function () {
            $scope.listTheStatus = this.list.status;
            console.log($scope.listTheStatus);

            if ($scope.listTheStatus == 1){
                // 将当前id赋值给一个变量
                $scope.listTheId = this.list.id;

                // 将status参数设置为要更改的状态
                $scope.listTheStatus = 2;

                // 运用bootbox模态框
                bootbox.confirm({
                    title: "操作提示",
                    message: "上线后该图片将在banner中展示，是否执行上线操作",
                    buttons: {
                        cancel: {
                            label: '取消',
                        },
                        confirm: {
                            label: '确定',
                        }
                    },
                    callback: function (result) {
                        if (result == true){
                            $http({
                                method: 'PUT',
                                url: '/carrots-admin-ajax/a/u/article/status',
                                params: {
                                    id: $scope.listTheId,
                                    status: $scope.listTheStatus
                                }
                            }).then (function (response) {
                                if (response.data.code == 0) {
                                    // 成功后刷新当前页面
                                    $state.reload("home.list");
                                    // 成功后弹出提示框
                                    bootbox.alert({
                                        title: '提示',
                                        message: "上线成功!",
                                        size: 'small',
                                        backdrop: true
                                    });
                                } else {
                                    alert(response.data.message)
                                }
                            })
                        }
                    }
                });
            }else if ($scope.listTheStatus == 2){
                // 将当前id赋值给一个变量
                $scope.listTheId = this.list.id;

                // 将status参数设置为要更改的状态
                $scope.listTheStatus = 1;

                // 运用bootbox模态框
                bootbox.confirm({
                    title: "操作提示",
                    message: "下线后该图片将不展示在轮播banner中，是否执行下线操作",
                    buttons: {
                        cancel: {
                            label: '<i class="fa fa-times"></i> 取消'
                        },
                        confirm: {
                            label: '<i class="fa fa-check"></i> 确定'
                        }
                    },
                    callback: function (result) {
                        if (result == true){
                            $http({
                                method: 'PUT',
                                url: '/carrots-admin-ajax/a/u/article/status',
                                params: {
                                    id: $scope.listTheId,
                                    status: $scope.listTheStatus
                                }
                            }).then (function (response) {
                                if (response.data.code == 0) {
                                    // 成功后刷新当前页面
                                    $state.reload("home.list");
                                    // 成功后弹出提示框
                                    bootbox.alert({
                                        title: '提示',
                                        message: "下线成功!",
                                        size: 'small',
                                        backdrop: true
                                    });
                                } else {
                                    alert(response.data.message)
                                }
                            })
                        }
                    }
                });
            }
        };


        // 编辑按钮
        $scope.listEdit = function () {
            $state.go('home.detail', {
                id: this.list.id
            })
        };


        // 删除按钮
        $scope.listDelete = function () {
            // 将当前id赋值给一个变量
            $scope.listTheId = this.list.id;

            // 运用bootbox模态框
            bootbox.confirm({
                title: "提示",
                message: "是否确认删除",
                buttons: {
                    cancel: {
                        label: '<i class="fa fa-times"></i> 取消'
                    },
                    confirm: {
                        label: '<i class="fa fa-check"></i> 确定'
                    }
                },
                callback: function (result) {
                    if (result == true){
                        $http({
                            method: 'DELETE',
                            url: '/carrots-admin-ajax/a/u/article/' + $scope.listTheId
                        }).then (function (response) {
                            if (response.data.code == 0) {
                                // 成功后刷新当前页面
                                $state.reload("home.list");
                                console.log(response);
                            } else {
                                alert(response.data.message)
                            }
                        })
                    }
                }
            });
        };
    }else {
        $state.go('login');
    }
});