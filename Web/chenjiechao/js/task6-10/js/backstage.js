var myApp = angular.module("myApp", ['ui.router', 'ngMessages', 'ngAnimate', 'ngSanitize', 'ui.bootstrap', 'ngFileUpload', 'textAngular']);
//这里叫做App模块，这将告诉HTML页面这是一个AngularJS作用的页面，并把ui-router注入AngularJS主模块，它的内容由AngularJS引擎来解释。

myApp.config(function ($stateProvider, $urlRouterProvider, $provide) {
    //这一行声明了把 $stateProvider 和 $urlRouteProvider 路由引擎作为函数参数传入，这样我们就可以为这个应用程序配置路由了.
    $urlRouterProvider.when("", "/signin");
    //如果没有路由引擎能匹配当前的导航状态，默认将路径路由至 PageTab.html, 那它就像switch case语句中的default选项.就是一个默认的视图选项
    $stateProvider
        //这一行定义了会在main.html页面第一个显示出来的状态（就是进入页面先加载的html），作为页面被加载好以后第一个被使用的路由.
        .state("signin", {
            url: "/signin",
            templateUrl: "signin.html",
            controller: "signin"
        })
        .state("PageTab", {
            url: "/PageTab", //#+标识符，这里就是url地址栏上面的标识符，通过标识符，进入不同的html页面
            templateUrl: "PageTab.html", //这里是html的路径，这是跟标识符相对应的html页面
            authencitate: true
        })
        .state("PageTab.Page1", { //引号里面代表Page1是PageTab的子页面，用.隔开
            url: "/Page1?page&size&total&type&status&startAt&endAt&id",
            templateUrl: "Page1.html"

        })
        .state("PageTab.Page2", { //需要跳转页面的时候，就是用这双引号里面的地址
            url: "/Page2?id", //传输id数据至新增页面
            templateUrl: "Page2.html"
        })
        .state("PageTab.Page3", {
            url: "/Page3",
            templateUrl: "Page3.html"
        });
    //富文本配置----------
    $provide.decorator('taOptions', ['$delegate', function (taOptions) {
        taOptions.toolbar = [
            ['h1', 'h2', 'h3', 'p', 'pre', 'quote', 'justifyLeft', 'justifyCenter', 'justifyRight', 'justifyFull'],
            ['bold', 'italics', 'underline', 'ul', 'ol', 'redo', 'undo', 'clear', 'html', 'insertLink'],
        ];
        return taOptions;
    }]);


});

myApp.provider('check', function () {
    var logstatus = 'false';
    var f = function (status) {
        if (status != 0) {
            logstatus = status;
        }
        return logstatus;
    };
    this.$get = function () {
        return f;
    }
})

//退出按钮事件
myApp.controller('logout', function ($http, $scope) {
    $scope.clickOut = function () { //点击注销登录状态
        $http({
            method: 'post',
            url: '/carrots-admin-ajax/a/logout',
        }).then(function () {
            console.log(1);
        })


    }
})







myApp.controller('list', function ($scope, $http, $state, $stateParams, $log) {

    //下面是日期控件
    $scope.clear = function () {
        $scope.dt1 = null;
    };

    $scope.inlineOptions = {

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

    // Disable weekend selection
    function disabled(data) {
        var date = data.date,
            mode = data.mode;
        return mode === 'day' && (date.getDay() === 7);
    }
    $scope.toggleMin = function () {
        $scope.inlineOptions.minDate = $scope.inlineOptions.minDate ? null : new Date();
        $scope.dateOptions.minDate = $scope.inlineOptions.minDate;
    };
    $scope.toggleMin();
    $scope.open1 = function () {
        $scope.popup1.opened = true;
    };

    $scope.setDate = function (year, month, day) {
        $scope.dt1 = new Date(year, month, day);
    };

    $scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
    $scope.format = $scope.formats[0];
    $scope.altInputFormats = ['M!/d!/yyyy'];
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
    $scope.events = [{
            date: tomorrow,
            status: 'full'
        },
        {
            date: afterTomorrow,
            status: 'partially'
        }
    ];



    //下拉列表
    $scope.state = [{
            value: '1',
            text: '草稿'
        },
        {
            value: '2',
            text: '上线'
        }
    ];

    $scope.type = [{
            value: '0',
            text: "首页banner"
        },
        {
            value: '1',
            text: "找职位banner"
        },
        {
            value: '2',
            text: "找精英banner"
        },
        {
            value: '3',
            text: "行业大图"
        }
    ];

    //获取列表渲染页面
    $http({
        method: 'get',
        url: '/carrots-admin-ajax/a/article/search',
        params: {
            page: $stateParams.page, //使用$stateParams获取传递的参数
            size: $stateParams.size,
            total: $stateParams.total,
            startAt: $stateParams.startAt,
            endAt: $stateParams.endAt,
            status: $stateParams.status,
            type: $stateParams.type,
            id: $stateParams.id,
        }
    }).then(function (d) {
        $scope.tablelists = d.data.data.articleList; //获取列表
        $scope.size = d.data.data.size; //每页的tr数量
        $scope.persize = d.data.data.size;
        $scope.total = d.data.data.total; //tr总数量
        $scope.currentPage = $stateParams.page; //使当前页等于获取的页数
        $scope.totalItems = $scope.total; //使tr总数量等于获取的服务端的tr总数量
        $scope.page = function () {
            $state.go("PageTab.Page1", { //state.go传参
                page: $scope.currentPage, //页数跳转至当前页
            })
        }


        //确定按钮的点击事件
        $scope.pagesure = function () {
            console.log($scope.pagenum);
            console.log($scope.gopage);
            if ($scope.pagenum == undefined && $scope.gopage !== undefined) {
                $state.go("PageTab.Page1", {
                    page: $scope.gopage, //输入去第几页之后，点击确定跳转
                    // createAt: $scope
                }, {
                    reload: true
                })
            }
            if ($scope.pagenum !== undefined && $scope.gopage == undefined) {
                $state.go("PageTab.Page1", {
                    size: $scope.pagenum, //输入每页显示多少条之后，点击确定改变
                    // createAt: $scope
                }, {
                    reload: true
                })
            }
            if ($scope.pagenum !== undefined && $scope.gopage !== undefined) {
                $state.go("PageTab.Page1", {
                    size: $scope.pagenum, //输入每页显示多少条之后，点击确定改变
                    page: $scope.gopage, //输入去第几页之后，点击确定跳转
                    // createAt: $scope
                }, {
                    reload: true
                })
            }
        };


        $scope.pagenum = $stateParams.size;
        $scope.dt1 = parseInt($stateParams.startAt); //获取字符串类型时间并改为数字类型
        $scope.dt2 = parseInt($stateParams.endAt);
        $scope.a = $stateParams.status; //保存下拉列表框状态，使点击搜索之后不变
        $scope.b = $stateParams.type;

        //搜索按钮
        $scope.search = function () {
            var time_dt1;
            var time_dt2;
            if ($scope.dt1) {
                var date1 = new Date($scope.dt1); //将数字类型转化为标准时间格式    
                time_dt1 = date1.valueOf(); //将标准时间格式转化为字符串类型
                console.log("第一个时间" + time_dt1);
            }
            if ($scope.dt2) {
                var date2 = new Date($scope.dt2);
                time_dt2 = date2.valueOf();
            }
            if (time_dt1 == time_dt2 && time_dt2 !== undefined) { //判断是否相等
                time_dt2 = time_dt2 + 86399999; //结束时间需要加上一天减一毫秒
            }
            $state.go("PageTab.Page1", { //传递参数获取符合要求数据返回再渲染页面
                type: $scope.b,
                status: $scope.a,
                startAt: time_dt1,
                endAt: time_dt2,
            }, {
                reload: true
            })
        }

        //清除按钮清除搜索选项
        $scope.clearS = function () {
            $state.go("PageTab.Page1", {
                type: undefined,
                status: undefined,
                startAt: undefined,
                endAt: undefined,
            })
        };

        //点击添加按钮，跳转页面
        $scope.addItem = function (page2) {
            $state.go("PageTab.Page2", {})
        };

        //编辑按钮点击事件
        $scope.edit = function () {
            console.log(this.$index); //当前点击按钮的索引号
            var editId = $scope.tablelists[this.$index].id //获取点击项目的ID
            console.log(editId);
            $state.go("PageTab.Page2", { //使用state.go传递参数
                id: editId
            })
        };

        //删除按钮点击事件
        $scope.delete = function () {
            var delC = confirm('删我你心不痛吗？');
            if (delC == true) { //弹出框点击确定后
                var delId = $scope.tablelists[this.$index].id; //获取ID
                $http({
                    method: 'delete',
                    url: '/carrots-admin-ajax/a/u/article/' + delId,
                }).then(function () {
                    $state.go($state.current, {}, {
                        reload: true
                    })
                })
            }
        }

        //改变上线状态
        $scope.on = function () {
            var onC = confirm('确认改变状态吗？');
            if (onC == true) {
                var onId = $scope.tablelists[this.$index].id; //获取点击的项目ID
                var onSta = $scope.tablelists[this.$index].status; //获取点击的项目此时状态
                if (onSta == 1) { //如果状态为草稿1
                    var onStatus = 2;
                } else {
                    var onStatus = 1;
                }
                console.log(onSta);
                console.log(onStatus);
                $http({
                    method: 'put',
                    url: '/carrots-admin-ajax/a/u/article/status',
                    params: {
                        id: onId,
                        status: onStatus

                    },
                    headers: {
                        'Content-Type': "application/x-www-form-urlencoded"
                    }
                }).then(function () {
                    $state.go($state.current, {}, {
                        reload: true
                    })
                })
            }
        }
    })
})