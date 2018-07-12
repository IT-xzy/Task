angular.module('myApp')
    .controller('listCtrl', function ($scope, $state, $stateParams, articleConstant, userService) {

        // 把类型数据模型赋予变量
        $scope.select = articleConstant;

        console.log('开始时间' + $stateParams.starAt)
        console.log('结束时间' + $stateParams.endAt);
        console.log('类型' + $stateParams.type);
        console.log('状态' + $stateParams.status);
        console.log('页数' + $stateParams.page);

        //初始化 读取路由参数  如果路由没有类型和状态信息  重置为默认值
        $scope.load = function () {
            if ($stateParams.type == undefined) {
                $scope.checkType = $scope.select.type[0];
            } else {
                var num1 = (parseInt($stateParams.type) + 1);
                $scope.checkType = $scope.select.type[num1];
            }
            if ($stateParams.status == undefined) {
                $scope.checkStatus = $scope.select.status[0];
            } else {
                var num2 = parseInt($stateParams.status);
                $scope.checkStatus = $scope.select.status[num2];
            }
            //路由接收的字符串参数转为数字转成日期对象 开始时间
            if ($stateParams.starAt != undefined) {
                let date1 = parseInt($stateParams.starAt);
                date1 = new Date(date1);
                $scope.starAt = date1;
                console.log('搜索开始时间' + $scope.starAt)
            }
            //路由接收的字符串参数转为数字转成日期对象 结束时间
            if ($stateParams.endAt != undefined) {
                let date2 = parseInt($stateParams.endAt);
                date2 = new Date(date2);
                $scope.endAt = date2;
                console.log('搜索结束时间' + $scope.endAt);
            }
        }()

        // 获得列表请求
        $scope.getList = function () {
            //从路由获得全部参数
            var params = {
                starAt: $stateParams.starAt, //起始时间
                endAt: $stateParams.endAt, //结束时间
                type: $scope.checkType.num, //数据类型
                status: $scope.checkStatus.num, //状态
                page: $scope.curr,
                size: $scope.listSize
            }
            userService.searchArticle(params)
                .then(function (res) {
                    console.log('get列表数据')
                    console.log(res.data);
                    $scope.listData = res.data.data;
                    $scope.all = Math.ceil(res.data.data.total / res.data.data.size);
                    $scope.listSize = res.data.data.size
                    changeRange();
                })
        }
        $scope.getList();

        // 上线下线
        $scope.changeStatus = function () {
            if (this.item.status == 1) {
                var sure = confirm("确定要上线此项？")
                var num = 2;
            } else if (this.item.status == 2) {
                var sure = confirm("确定要下线此项？")
                var num = 1;
            }
            if (sure) {
                var params = {
                    id: this.item.id,
                    status: num
                }
                userService.articleStatus(params)
                    .then(function successCallback(res) {
                        console.log(res);
                        $scope.getList();
                    })
            }
        }

        //跳转编辑页
        $scope.compile = function () {
            console.log(this.item.id)
            $state.go('admin.add', {
                id: this.item.id
            })
        }

        // 删除article
        $scope.delete = function () {
            var sure = confirm("确定要删除此项吗？")
            if (sure) {
                userService.deleteArticle(this.item.id)
                    .then(function successCallback(res) {
                        $scope.getList();
                    })
            }
        }



        // 搜索点击函数
        $scope.search = function () {
            if ($scope.starAt != undefined) {
                var startTime = getDate($scope.starAt);
            }
            if ($scope.endAt != undefined) {
                var endTime = getDate($scope.endAt);
            }
            $state.go('admin.list', {
                starAt: startTime,
                endAt: endTime,
                type: $scope.checkType.num,
                status: $scope.checkStatus.num,
                page: 1
            });
            //时间格式转换
            function getDate(time) {
                time = JSON.stringify(time);
                time = time.replace(/T/g, '/');
                time = new Date(time).getTime();
                return time;
            }
        }

        // 点清空重置搜索数据
        $scope.restList = function () {
            $state.go('admin.list', {
                starAt: null,
                endAt: null,
                type: null,
                status: null,
                page: 1
            })
        }


        //分页逻辑
        //curr当前页数  all总页数 count要显示的页数范围  from页数范围开始  to页数范围结束  range显示的页数范围数组
        $scope.curr = 1;
        $scope.count = 5;
        //改变页数显示范围
        // 触发页数更新
        function changeRange() {

            function getRange(curr, all, count) {
                var arr = [];
                //计算显示的页数
                curr = parseInt(curr);
                all = parseInt(all);
                count = parseInt(count);
                var from = curr - parseInt(count / 2);
                var to = curr + parseInt(count / 2) + (count % 2) - 1;
                //显示的页数容处理
                if (from <= 0) {
                    from = 1;
                    to = from + count - 1;
                    if (to > all) {
                        to = all;
                    }
                }
                if (to > all) {
                    to = all;
                    from = to - count + 1;
                    if (from <= 0) {
                        from = 1;
                    }
                }
                for (var i = from; i <= to; i++) {
                    arr.push(i);
                }
                $scope.range = arr;
            }
            getRange($scope.curr, $scope.all, $scope.count);
        }

        //直接点击页数功能
        $scope.clickPage = function () {
            $scope.curr = this.item;
            changeRange();
            $scope.getList();
        }

        // 分页按钮功能
        $scope.changePage = function (type) {
            switch (type) {
                case '-1': //上一页
                    if ($scope.curr > 1) {
                        --$scope.curr;
                        $scope.getList();
                    }
                    break;
                case '+1': //下一页
                    if ($scope.curr < ($scope.all)) {
                        ++$scope.curr
                        $scope.getList();
                    }
                    break;
                case 'first':
                    $scope.curr = 1;
                    changeRange()
                    $scope.getList()
                    break;
                case 'end':
                    $scope.curr = $scope.all;
                    changeRange()
                    $scope.getList()
                    break;
            }
        }
        //跳转页数功能
        $scope.jump = function () {
            if ($scope.jumpPage <= $scope.all && $scope.jumpPage >= 1) {
                $scope.curr = $scope.jumpPage;
            }
            changeRange();
            $scope.getList();
        }

    })