app.controller("list", function ($scope, $http, $stateParams, $state) {
    console.log($stateParams);
    //登录验证
    if(!(sessionStorage.getItem("token"))) {
        $state.go('login');
    }
    //搜索框条件判断是否为undefined
    var setParseInt = function (params) {
        return (params === undefined) ? null : parseInt(params)
    };
    var setDate = function (date) {
        if (date === undefined) {
            return null;
        } else if (date !== null) {
            return date.valueOf()
        }
        return date ? date.valueOf() : null
    };
    var setEndDate = function (a) {
        return a ? a.valueOf() + 86399000 : null
    };

    //发送http请求，获得列表数据+++
    $http({
        method: 'get',
        params: {
            page: $stateParams.page,
            size: $stateParams.size,
            type: $stateParams.type,
            status: $stateParams.status,
            startAt: $stateParams.startAt,
            endAt: $stateParams.endAt
        },
        url: '/carrots-admin-ajax/a/article/search',
        headers: {'Content-Type': 'application/x-www-form-urlencoded'}
    }).then(function (resp) {
        $scope.datas = resp.data.data.articleList;  //列表数据
        $scope.totalItems = resp.data.data.total;   //列表数据总量
        $scope.perPage = resp.data.data.size;       //每页显示条数
        $scope.size = $stateParams.size;            //每页显示条数
        $scope.currentPage = $stateParams.page;     //当前页
        $scope.dt1 = setParseInt($stateParams.startAt);//开始时间
        if($stateParams.endAt){
            $scope.dt2 = setParseInt($stateParams.endAt) - 86399000
        } else {
            $scope.dt2 = null
        }
        //$scope.dt2 = setParseInt($stateParams.endAt);  //结束时间
        $scope.list = setParseInt($stateParams.type);//类型菜单
        $scope.statusList = setParseInt($stateParams.status);//上下线菜单
        console.log(resp.data.data);
    });

    //按选择条件搜索+++
    $scope.search = function () {
        // console.log(typeof $scope.dt2);
        $state.go('backstage.article', {
            type: $scope.list ,
            status: $scope.statusList,
            startAt: setDate($scope.dt1),
            endAt: setEndDate($scope.dt2)
        }, {reload: true});
    };

    //分页控件翻页传参+++
    $scope.pageChange = function () {
        $state.go('backstage.article', {
            page: $scope.currentPage
        }, {reload: true});
    };
    
    //限制条数输入框只能输入正整数
    $scope.changeSize = function () {
        $scope.size = $scope.size.replace(/[^0-9]/g, '');
        if (parseInt($scope.size) === 0) {
            $scope.size = 10;
        }
    };
    $scope.changePage = function () {
        $scope.page = $scope.page.replace(/[^0-9]/g, '');
    };
    
    //分页控件跳转确定传参+++
    $scope.determine = function () {
        $state.go('backstage.article', {
            page: $scope.page,
            size: $scope.size
        }, {reload: true});
    };

    //上下线操作+++
    $scope.offline = function (id, status) {
        //上下线操作提示框
        bootbox.confirm({
            title: "操作提示",
            message: status === 1 ? "是否执行上线操作？" : "是否执行下线操作？",
            closeButton: false,
            buttons: {
                confirm: {
                    label: '确定',
                    className: 'btn-success'
                },
                cancel: {
                    label: '取消',
                    className: 'btn-danger'
                }
            },
            //回调函数，发送http请求
            callback: function (result) {
                if (result) {
                    var changeStatus = function () {
                        status === 1 ? status = 2 : status = 1;
                        return status;
                    };
                    changeStatus();
                }
                $http({
                    method: 'put',
                    url: '/carrots-admin-ajax/a/u/article/status',
                    params: {
                        id: id,
                        status: status
                    },
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                }).then(function (resp) {
                    if (resp.data.code === 0) {
                        $state.reload('backstage.article');
                    }
                });
            }
        });
    };

    //删除列表某一项++++
    $scope.delete = function (id) {
        bootbox.confirm({
            title: "操作提示",
            message: "是否删除？",
            closeButton: false,
            buttons: {
                confirm: {
                    label: '确定',
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
                        headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                    }).then(function (resp) {
                        if (resp.data.code === 0) {
                            $state.reload('backstage.article');
                        }
                    });
                }
            }
        });
    };

    //日历控件+++
    $scope.dateOptions1 = {
        formatYear: 'yy',
        maxDate: new Date(),//可选取日期最大值
        startingDay: 1
    };
    $scope.dateOptions2= {
        formatYear: 'yy',
        maxDate: new Date(),//可选取日期最大值
        startingDay: 1
    };

    //修改日历日期显示样式
    $scope.format = "yyyy-MM-dd";
    $scope.altInputFormats = ['yyyy-M!-d!'];

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

    //类型和状态列表项
    $scope.lists = [
        {id: null, name: "全部"},
        {id: 0, name: "首页banner"},
        {id: 1, name: "找职位banner"},
        {id: 2, name: "找精英"},
        {id: 3, name: "行业大图"}
    ];
    $scope.items = [
        {id: null, name: "全部"},
        {id: 1, name: "草稿"},
        {id: 2, name: "上线"}
    ];

    //清空，回到初始状态
    $scope.clean = function () {
        $state.go('backstage.article', {
            page: 1,
            size: 10,
            type: null,
            status: null,
            startAt: null,
            endAt: null
        }, {reload: true})
    };
});
app.controller('quit', function ($scope, $http, $state) {
    //登录检测
    if(!(sessionStorage.getItem("token"))) {
        $state.go('login');
    }

    //退出登录
    $scope.quit = function () {
        $http({
            method: 'POST',
            url: '/carrots-admin-ajax/a/logout',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(function (resp) {
            console.log(resp);
            if(resp.data.code === 0){
                sessionStorage.clear('token');
                $state.go('login')
            }
        })
    }
});