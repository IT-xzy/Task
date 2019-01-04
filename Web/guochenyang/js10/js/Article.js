// 列表页

//  接口
//  http://new.wiki.jnshu.com/pages/viewpage.action?pageId=1180246
myApp.controller("articleListCtrl", function ($scope, $http, $state, $stateParams) {
    // console.log('state',$state.params)
    // console.log('stateParams',$stateParams)
    // 进入页面获取列表
    $http({
        method: "GET",
        url: "/carrots-admin-ajax/a/article/search",
        params: $stateParams
    }).then(function successCallback(response) {
        // console.log("测试：", )
        $scope.articleList = response.data.data.articleList;
        $scope.paging = response.data.data;
        // console.log($scope.paging)
        // console.log("请求列表成功：", $scope.articleList)
    }, function errorCallback(response) {
        console.log("请求列表失败：", response)
    })


    //上下线点击事件
    $scope.statusbutton = function (id) {
        var id = this.list.id;
        var s
        var m
        if (this.list.status == 1) {
            s = 2;
            m = "是否进行下线操作？"
        } else {
            s = 1;
            m = "是否进行上线操作？"
        }
        bootbox.confirm({
            message: m,
            buttons: {
                confirm: {
                    label: 'Yes',
                    className: 'btn-success'
                },
                cancel: {
                    label: 'No',
                    className: 'btn-danger'
                }
            },
            callback: function () {
                $http({
                    method: 'PUT',
                    url: '/carrots-admin-ajax/a/u/article/status',
                    params: {
                        id: id,
                        status: s
                    }
                }).then(function () {
                    $state.reload()
                })
            }
        });
    }
    //删除
    $scope.deletebutton = function () {
        var id = this.list.id;
        bootbox.confirm({
            message: "确定删除此条消息？",
            buttons: {
                confirm: {
                    label: 'Yes',
                    className: 'btn-success'
                },
                cancel: {
                    label: 'No',
                    className: 'btn-danger'
                }
            },
            callback: function () {
                $http({
                    method: 'delete',
                    url: '/carrots-admin-ajax/a/u/article/' + id,
                }).then(function () {
                    $state.reload()
                })
            }
        });
    }

        //上下线点击事件
    $scope.changeStatus = function (id,status) {
        var a;
        var b;

        if (status == 2) {
            a = 1;
            b = "是否进行下线操作？"
        } else {
            a = 2;
            b = "是否进行上线操作？"
        }
        bootbox.confirm({
            message: b,
            buttons: {
                confirm: {
                    label: 'Yes',
                    className: 'btn-warning'
                },
                cancel: {
                    label: 'No',
                    className: 'btn-danger'
                }
            },
            callback: function () {
                $http({
                    method: 'PUT',
                    url: '/carrots-admin-ajax/a/u/article/status',
                    params: {
                        id: id,
                        status: a
                    }
                }).then(function () {
                    $state.reload()
                })
            }
        });
    }
    //删除
    $scope.delete = function (id) {

        bootbox.confirm({
            message: "确定删除此条消息？",
            buttons: {
                confirm: {
                    label: 'Yes',
                    className: 'btn-danger'
                },
                cancel: {
                    label: 'No',
                    className: 'btn-warning'
                }
            },
            callback: function () {
                $http({
                    method: 'delete',
                    url: '/carrots-admin-ajax/a/u/article/' + id,
                }).then(function () {
                    $state.reload()
                })
            }
        });
    }



        //日历组件
        $scope.today = function () {
            $scope.dt = new Date();
        };

        $scope.clear = function () {
            $scope.dt1 = null;
            $scope.dt2 = null;
        };
        $scope.inlineOptions = {
            customClass: getDayClass,
            minDate: new Date(),
            showWeeks: true
        };
        $scope.$watch("dt1", function (designate, ddd) {
            $scope.dateOptions2.minDate = designate;
        })
        $scope.$watch("dt2", function (designate, ddd) {
            $scope.dateOptions1.maxDate = designate;
        })

        $scope.dateOptions1 = {
            dateDisabled: disabled,
            formatYear: 'yy',
            minDate: $scope.dt1,
            startingDay: 1
        };
        $scope.dateOptions2 = {
            dateDisabled: disabled,
            formatYear: 'yy',
            maxDate: $scope.dt2,
            startingDay: 1
        };

        // Disable weekend selection
        function disabled(data) {
            var date = data.date,
                mode = data.mode;
            // return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
        }

        $scope.toggleMin = function () {
            $scope.inlineOptions.minDate = $scope.inlineOptions.minDate ? null : new Date();
            $scope.dateOptions1.minDate = $scope.inlineOptions.minDate;
        };

        $scope.toggleMin();

        $scope.open1 = function () {
            $scope.popup1.opened = true;
        };

        $scope.open2 = function () {
            $scope.popup2.opened = true;
        };

        $scope.setDate = function (year, month, day) {
            $scope.dt1 = new Date(year, month, day);
            $scope.dt2 = new Date(year, month, day);
            console.log($scope.dt1)
        };
        $scope.popup1 = {
            opened: false
        };

        $scope.popup2 = {
            opened: false
        };

        var tomorrow = new Date();
        tomorrow.setDate(tomorrow.getDate() + 1);
        var afterTomorrow = new Date();
        afterTomorrow.setDate(tomorrow.getDate() + 1);
        $scope.events = [
            {
                date: tomorrow,
                status: 'full'
            },
            {
                date: afterTomorrow,
                status: 'partially'
            }
        ];

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
        //搜索下拉菜单
        //类型
        $scope.typeselect = [
            { id: null, name: "全部" },
            { id: 0, name: "首页banner" },
            { id: 1, name: "找职位banner" },
            { id: 2, name: "找精英banner" },
            { id: 3, name: "行业大图" }
        ]
        $scope.type = $scope.typeselect[0].id;
        //状态
        $scope.statusselect = [
            { id: null, name: "全部" },
            { id: 1, name: "上线" },
            { id: 2, name: "草稿" }
        ]
        $scope.status = $scope.statusselect[0].id;
        //日期状态保存
        if ($stateParams.startAt) {
            $scope.dt1 = parseInt($stateParams.startAt)
        }
        if ($stateParams.endAt) {
            $scope.dt2 = parseInt($stateParams.endAt)
        }
        //类型状态保存
        if($stateParams.type) {
            $scope.type = parseInt($stateParams.type)
        }
        //状态状态保存
        if($stateParams.status) {
            $scope.status = parseInt($stateParams.status)
        }
        //搜索及分页请求
        $http({
            method: 'get',
            url: '/carrots-admin-ajax/a/article/search',
            params: {
                page: $stateParams.page,
                size: $stateParams.size,
                title: $stateParams.title,
                author: $stateParams.author,
                type: $stateParams.type,
                status: $stateParams.status,
                startAt: $stateParams.startAt,
                endAt: $stateParams.endAt
            }

        }).then(function (res) {
            console.log(res);
            //总数据
            $scope.listes = res.data.data.articleList;
            //搜索相关
            $scope.title = $stateParams.title;
            $scope.author = $stateParams.author;
            //分页相关
            $scope.bigCurrentPage = $stateParams.page;
            $scope.page = $stateParams.page;
            $scope.size = res.data.data.size;
            $scope.size1 = res.data.data.size;
            $scope.bigTotalItems = res.data.data.total;
            $scope.maxSize = 5;

        }, function (res) {
            alert('没有')
        })
        //分页
        $scope.pageChanged = function () {
            //console.log($scope.bigCurrentPage)
            $state.go("organ.Article", {
                page: $scope.bigCurrentPage
            }, {
                reload: true
            })
        };
        //跳转和显示
        $scope.inputChanged = function () {
            $state.go("organ.Article", {
                page: $scope.page,
                size: $scope.size1
            }, {
                reload: true
            })
        }
        //搜索
        $scope.searchbutton = function () {
            var date1,time1,date2,time2
            //时间转换
            if ($scope.dt1) {
                date1 = new Date($scope.dt1)
                time1 = date1.valueOf()
            }
            if ($scope.dt2) {
                date2 = new Date($scope.dt2)
                if(time1 == date2.valueOf()){
                    time2 = date1.valueOf() + 86399000
                }else if(date2.valueOf() - time1 <= 86400000){
                    time2 = date2.valueOf() + 86399000
                }else{
                    time2 = date2.valueOf()
                }
            }
            //传参
            $state.go("organ.Article", {
                title: $scope.title,
                author: $scope.author,
                type: $scope.type,
                status: $scope.status,
                startAt: time1,
                endAt: time2,
                page: 1
            }, {
                reload: true
            })
        }
        //清空搜索
        $scope.emptybutton = function () {

            $state.go("organ.Article", {
                title: "",
                author: "",
                type: "",
                status: "",
                startAt: "",
                endAt: "",
                page: 1
            }, {
                reload: true
            })
        }
    });





