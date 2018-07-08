myApp.controller("list", function ($scope, $http, $state, $stateParams, $filter, $timeout) {

    // 时间选择器
    $scope.inlineOptions = {
        // customClass: getDayClass,
        minDate: new Date(),
        showWeeks: true
    };

    $scope.dateOptions = {
        dateDisabled: disabled,
        formatYear: 'yy',
        maxDate: new Date(2020, 5, 22),
        minDate: new Date(),
        startingDay: 1
    };

    // 取消禁用周末  Disable weekend selection
    function disabled(data) {
        var date = data.date,
            mode = data.mode;
        return (mode === 'day' && false);
    }

    $scope.toggleMin = function () {
        $scope.inlineOptions.minDate = $scope.inlineOptions.minDate ? null : new Date();
        $scope.dateOptions.minDate = $scope.inlineOptions.minDate;
    };

    $scope.toggleMin();

    $scope.open1 = function () {
        $scope.popup1.opened = true;
    };

    $scope.open2 = function () {
        $scope.popup2.opened = true;
    };

    $scope.popup1 = {
        opened: false
    };

    $scope.popup2 = {
        opened: false
    };

    function getDayClass(data) {
        var date = data.date,
            mode = data.mode;
        if (mode === 'day') {
            var dayToCheck = new Date(date).setHours(0, 0, 0, 0);

            for (var i = 0; i < $scope.events.length; i++) {
                var currentDay = new Date($scope.events[i].date).setHours(0, 0, 0, 0);

                if (dayToCheck === currentDay) {
                    return $scope.events[i].status;
                }
            }
        }
        return '';
    }

    // 类型
    $scope.types = [{
        id: null,
        typename: '请选择'
    }, {
        id: 0,
        typename: '首页banner'
    }, {
        id: 1,
        typename: '找职位banner'
    }, {
        id: 2,
        typename: '找精英banner'
    }, {
        id: 3,
        typename: '行业大图'
    }];


    // 状态
    $scope.statuses = [{
        id: null,
        statusname: '全部'
    }, {
        id: 1,
        statusname: '草稿'
    }, {
        id: 2,
        statusname: '上线'
    }]


    // 列表渲染
    $http({
        method: 'get',
        url: '/carrots-admin-ajax/a/article/search',
        // 注意这里 参数传递 get 
        params: {
            status: $stateParams.status,
            type: $stateParams.type,
            startAt: $stateParams.startAt,
            endAt: $stateParams.endAt,
            page: $stateParams.page,
            size: $stateParams.size,
        }
    }).then(function (result) {
        console.log(result.data.data);
        $scope.articleList = result.data.data.articleList;
        console.log($scope.articleList);
        //总数
        $scope.bigTotalItems = result.data.data.total;
        // 注意这里，当前页替换成参数页面
        $scope.currentPage = $stateParams.page;
        console.log("当前页面$scope.currentPage：" + $scope.currentPage);
        // 传参数this
        console.log($stateParams);
        $scope.perpage = result.data.data.size;
        $scope.pagesize = result.data.data.size;

        // 这个就是状态保存
        $scope.type = $scope.types[0].id;
        $scope.status = $scope.statuses[0].id;


        if ($stateParams.status) {
            $scope.status = parseInt($stateParams.status);
            // console.log(typeof $scope.status);
        }
        if ($stateParams.startAt) {
            // $scope.dt1 = $stateParams.startAt;
            $scope.dt1 = parseInt($stateParams.startAt);
            // console.log(typeof $stateParams.startAt);
            // console.log($scope.dt1);
            console.log($stateParams.startAt);
        }
        if ($stateParams.endAt) {
            $scope.dt2 = parseInt($stateParams.endAt);
        }

        console.log($scope.articleList);
        console.log($scope.articleList.length);
        sessionStorage.setItem('list', JSON.stringify($scope.articleList));
    })

    //  拖动排序
    $scope.cannotSort = false;

    $scope.data = JSON.parse(sessionStorage.getItem('list'));
    console.log(JSON.parse(sessionStorage.getItem('list')));

    $scope.sortableOptions = {
        // 数据有变化
        update: function (e, ui) {
            console.log("update");
            console.log($scope.data);
            //需要使用延时方法，否则会输出原始数据的顺序，可能是BUG？
            $timeout(function () {
                var resArr = [];
                for (var i = 0; i < $scope.data.length; i++) {
                    resArr.push($scope.data[i].id);
                }
                console.log(resArr);
            })
        },

        // 完成拖拽动作
        stop: function (e, ui) {
            //do nothing
        }
    }

    // 搜索
    $scope.search = function () {
        // var date = new Date($scope.createAt); 
        //传入一个时间格式，如果不传入就是获取现在的时间了，这样做不兼容火狐。 可以这样做
        var time_dt1, time_dt2;
        if ($scope.dt1) {
            var date1 = new Date($scope.dt1);
            time_dt1 = date1.valueOf();
            console.log("第一个时间" + time_dt1);
        }
        if ($scope.dt2) {
            var date2 = new Date($scope.dt2);
            // 想判断第二天如果没填怎么传
            if (time_dt1 !== date2.valueOf()) {
                time_dt2 = date2.valueOf();
            } else {
                time_dt2 = date1.valueOf() + 86399000;
            }
            console.log(time_dt2);
        }

        $state.go("backstage.list", {
            status: $scope.status,
            type: $scope.type,
            startAt: time_dt1,
            endAt: time_dt2
        }, {
            reload: true,
        })
    }

    // 清空
    $scope.clear = function () {
        $state.go("backstage.list", {
            status: null,
            type: null,
            startAt: null,
            endAt: null
        }, {
            reload: true
        })
    };

    // 上下线状态显示
    $scope.btnStatus = function () {
        if (this.item.status === 1) {
            return "上线";
        } else {
            return "下线";
        }
    }

    // 上下线状态改变
    $scope.onoff = function (id) {
        var id = this.item.id;
        // 草稿改变
        if (this.item.status === 1) {
            bootbox.confirm({
                title: "操作提示",
                message: "<h3 style='text-align: center'>将会上线，是否执行</h3>",
                buttons: {
                    confirm: {
                        label: '确认',
                        className: 'btn-success'
                    },
                    cancel: {
                        label: '取消',
                        className: 'btn-danger'
                    }
                },
                callback: function (result) {
                    if (result) {
                        // console.log('This was logged in the callback: ' + result);
                        $http({
                            method: 'put',
                            url: '/carrots-admin-ajax/a/u/article/status',
                            params: {
                                id: id,
                                status: 2
                            }
                        }).then(function () {
                            $state.go($state.current, {}, {
                                reload: true
                            })
                        })
                    }
                }
            });
        }

        // 上线改变 
        else {
            bootbox.confirm({
                title: "操作提示",
                message: "<h3 style='text-align: center'>转为草稿，是否执行</h3>",
                closeButton: false,
                buttons: {
                    confirm: {
                        label: '确认',
                        className: 'btn-success'
                    },
                    cancel: {
                        label: '取消',
                        className: 'btn-danger'
                    }
                },
                callback: function (result) {
                    if (result) {
                        $http({
                            method: 'put',
                            url: '/carrots-admin-ajax/a/u/article/status',
                            params: {
                                id: id,
                                status: 1
                            }
                        }).then(function () {
                            $state.go($state.current, {}, {
                                reload: true
                            })
                        })
                    }
                }
            })
        }
    }

    // 编辑，通过id
    $scope.update = function (id) {
        var id = this.item.id;

        $state.go("backstage.add", {
            id: id
        });
    }

    // 删除，同上
    $scope.delete = function (id) {
        var id = this.item.id;
        bootbox.confirm({
            title: "操作提示",
            message: "<h3 style='text-align: center'>删除文档，是否执行</h3>",
            closeButton: false,
            buttons: {
                confirm: {
                    label: '确认',
                    className: 'btn-success'
                },
                cancel: {
                    label: '取消',
                    className: 'btn-danger'
                }
            },
            callback: function (result) {
                if (result) {
                    $http({
                        method: 'delete',
                        url: '/carrots-admin-ajax/a/u/article/' + id,
                        // 请求参数这样写
                    }).then(function () {
                        $state.go($state.current, {}, {
                            reload: true
                        })
                    })
                }
            }
        })
    }

    // 自定义出现几个页码
    $scope.maxSize = 3;
    // 分页
    $scope.page = function () {
        $state.go("backstage.list", {
            page: $scope.currentPage,
            size: $scope.pagesize
        }, {
            reload: true
        })
    }

    // 确定跳转某页和每页几条
    $scope.confirm = function () {
        console.log($scope.gotopage);
        console.log($scope.pagesize);
        $state.go("backstage.list", {
            page: $scope.gotopage,
            size: $scope.pagesize
        }, {
            reload: true
        })
    }
})