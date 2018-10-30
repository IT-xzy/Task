// list列表控制器
angular.module("myApp")
    .controller("list", function ($filter, $scope, articleConstant, $state, beg) {
        laydate.render({ //搜索开始时间插件
            elem: '#starttime',
            done: function (value) {
                $scope.starttime = value; //获取选择的开始时间
            }
        });
        laydate.render({ //搜索结束时间插件
            elem: '#endtime',
            done: function (value) {
                $scope.endtime = value; //获取选择的结束时间
            }
        });

        // 搜索后显示搜索的添加
        $scope.typeItem = articleConstant.typeItem; //类似列表
        $scope.statusItem = articleConstant.statusItem; //状态列表
        let params = $state.params; //获取传参数据
        console.log(params)
        $scope.selectedType = +$state.params.type; //类型
        if ($scope.selectedType != 0 && $scope.selectedType != 1 && $scope.selectedType != 2 && $scope.selectedType != 3) {
            $scope.selectedType = undefined; //默认类似的值为空
        }
        $scope.selectedStatus = +$state.params.status; //状态
        if ($scope.selectedStatus != 1 && $scope.selectedStatus != 2) {
            $scope.selectedStatus = undefined; //默认状态的值为空
        }
        $scope.title = $state.params.title; //标题
        $scope.user = $state.params.author; //创建者
        $scope.starttime = $filter("date")($state.params.startAt, "yyyy-MM-dd"); //开始时间
        $scope.endtime = $filter("date")($state.params.endAt, "yyyy-MM-dd"); //结束时间

        //显示当前所在页数
        if ($state.params.page == undefined) {
            $scope.now = "1";
        } else if ($state.params.page != undefined) {
            $scope.now = $state.params.page;
        }

        $scope.number = $state.params.value; //定义显示数据的页数，默认第一页

        let size = "10"; //定义展示数量的长度
        let page = $scope.number; //定义获取展示数据的页数

        // 定义请求方法
        $scope.list = function () {
            //调用list请求方法params为传参，then为请求成功后执行
            beg.getList(params).then(function (response) {
                console.log(response.data.data)
                $scope.name = response.data.data.articleList; //把获取的数剧循环出来
                console.log($scope.name)
                let x = response.data.data.total / 10; //定义总页数
                console.log(x);
                $scope.sum = Math.ceil(x);

                if ($scope.sum == "0") {
                    $scope.btn = false; //当没有数据时隐藏分页按钮
                } else if ($scope.sum != "0") {
                    $scope.btn = true; //当数据大于1页显示按钮
                }

                // 分页按钮
                switch ($scope.sum) { //当数据小于5页时隐藏按钮
                    case 1:
                        $scope.btn2 = true;
                        $scope.btn3 = true;
                        $scope.btn4 = true;
                        $scope.btn5 = true;
                        break;
                    case 2:
                        $scope.btn3 = true;
                        $scope.btn4 = true;
                        $scope.btn5 = true;
                        break;
                    case 3:
                        $scope.btn4 = true;
                        $scope.btn5 = true;
                        break;
                    case 4:
                        $scope.btn5 = true;
                        break;
                }

                if ($scope.now <= 4) { //当前页数小于等于4时显示默认按钮
                    $scope.value1 = 1;
                    $scope.value2 = 2;
                    $scope.value3 = 3;
                    $scope.value4 = 4;
                    $scope.value5 = 5;
                }

                if ($scope.now > 4) { //当前页数大于4时单前页数显示在中间按钮，左右两边显示前后页数
                    $scope.value1 = parseInt($scope.now) - 2;
                    $scope.value2 = parseInt($scope.now) - 1;
                    $scope.value3 = $scope.now;
                    $scope.value4 = parseInt($scope.now) + 1;
                    $scope.value5 = parseInt($scope.now) + 2;
                }

                // 当前页数为倒数第二页或最后一页时和默认按钮相反

                if ($scope.now > 5 && $scope.now == parseInt($scope.sum) - 1) {
                    $scope.value1 = parseInt($scope.sum) - 4;
                    $scope.value2 = parseInt($scope.sum) - 3;
                    $scope.value3 = parseInt($scope.sum) - 2;
                    $scope.value4 = parseInt($scope.sum) - 1;
                    $scope.value5 = $scope.sum;
                }

                if ($scope.now > 4 && $scope.now == $scope.sum) {
                    $scope.value1 = parseInt($scope.sum) - 4;
                    $scope.value2 = parseInt($scope.sum) - 3;
                    $scope.value3 = parseInt($scope.sum) - 2;
                    $scope.value4 = parseInt($scope.sum) - 1;
                    $scope.value5 = $scope.sum;
                }

                $scope.bg = { //定义单前页数按钮样式
                    "background": "#337ab7",
                    "color": "#ffffff",
                }

                if ($scope.now == 1) { //当前页数为第1页改变第1个按钮样式
                    $scope.bg1 = $scope.bg;
                }
                if ($scope.now == 2) { //当前页数为第2页改变第2个按钮样式
                    $scope.bg2 = $scope.bg;
                }
                if ($scope.now == 3) { //当前页数为第3页改变第3个按钮样式
                    $scope.bg3 = $scope.bg;
                }
                if ($scope.now == 4) { //当前页数为第4页改变第4个按钮样式
                    $scope.bg4 = $scope.bg;
                }
                if ($scope.now >= 5) { //单前页数大于等于5时，改变中间按钮样式
                    let a = $scope.now < parseInt($scope.sum) - 2
                    $scope.bg3 = $scope.bg;
                }
                if ($scope.now > 5 && $scope.now == parseInt($scope.sum) - 1) { //当前页数为倒数第二页改变第四个按钮样式
                    $scope.bg4 = $scope.bg;
                    $scope.bg3 = "";
                }
                if ($scope.now > 4 && $scope.now == $scope.sum) { //当前页数为最后一页改变最后一个按钮样式
                    $scope.bg5 = $scope.bg;
                    $scope.bg3 = "";
                }



                $scope.showForward = false; //定义上一页按钮默认为隐藏
                $scope.showBackwards = true; //定义下一页按钮默认为显示
                if ($scope.now > "1") { //当前页数大于第一页
                    $scope.showForward = true; //定义上一页为显示
                }
                if ($scope.now == $scope.sum) { //单前页数为最后一页
                    $scope.showForward = true; //定义上一页按钮为显示
                    $scope.showBackwards = false; //定义下一页按钮为隐藏
                }
            })
        }
        $scope.list() //调用自身函数，自执行一次

        // 点击显示页数确定按钮
        $scope.ok = function () {
            if ($scope.number > $scope.sum || $scope.number < 1) {
                confirm("跳转页数不能大于总页数或小于0")
            } else if ($scope.number <= $scope.sum) {
                $state.go($state.$current, { //传参
                    page: $scope.number,
                    size: 10,
                    value: $scope.number,
                }, {
                    reload: true //刷新单前页面
                })
            }
        }

        $scope.start = function () { //点击首页按钮
            $scope.number = "" //清除跳转输入框
            $state.go($state.$current, { //传参
                page: 1,
                size: 10,
                value: "",
            }, {
                reload: true //刷新单前页面
            })
        }

        $scope.end = function () { //点击尾页按钮
            $scope.number = "" //清除跳转输入框
            $state.go($state.$current, { //传参
                page: $scope.sum,
                size: 10,
                value: "",
            }, {
                reload: true //刷新单前页面
            })
        }

        $scope.query = function () { //搜索按钮

            let starttime = $scope.starttime; //起始时间
            if (starttime) {
                starttime = parseInt(new Date(starttime).getTime()); // 把字符串时间转为时间戳
            } else {
                starttime = undefined;
            }
            let endtime = $scope.endtime; //结束时间
            if (endtime) {
                endtime = parseInt(new Date(endtime).getTime()); // 把字符串时间转为时间戳
            } else {
                endtime = undefined
            }

            $state.go($state.$current, { //传参
                status: $scope.selectedStatus, //状态
                type: $scope.selectedType, //类型
                title: $scope.title, //标题
                author: $scope.user, //创建者
                startAt: starttime, //开始时间
                endAt: endtime, //结束时间
                page: 1
            }, {
                reload: true //刷新单前页面
            })
        }

        $scope.delete = function () { //点击删除按钮，清除所有条件
            $scope.title = "";
            $scope.user = "";
            $scope.selectedType = undefined;
            $scope.selectedStatus = undefined;
            $scope.starttime = "";
            $scope.endtime = "";
        }

        $scope.add = function () { //点击新增按钮
            $state.go('home.add', {
                skip: "add", //传参
            })
        }

        $scope.compile = function ($index) { //点击编辑按钮
            var id = $scope.name[$index].id; //获取编辑项id
            console.log(id);
            $state.go('home.add', {
                skip: "compile", //传参
                id: id,
            })
        }

        $scope.swop = function ($index) { //根据status状态渲染上下线按钮
            var status = $scope.name[$index].status; //获取每一项的status值
            if (status == "2") {
                return "下线"; //当值为2时，按钮为下线
            } else if (status == "1") {
                return "上线"; //当值为1时，按钮为上线
            }
        }

        $scope.putSwops = function () { //封装上线下线put请求和请求数据
            $scope.params = {} //创建请求参数
            $scope.params.id = $scope.id; //请求id
            $scope.params.status = $scope.status; //请求状态

            beg.putSwops($scope.params).then(function (response) { //调用put请求
                console.log(response)
                $state.reload(); //请求成功刷新当前页面
            })
        }

        $scope.swops = function ($index) { //点击上线下线按钮
            console.log($scope.swop($index))
            var id = $scope.name[$index].id; //获取修改项的id
            $scope.id = id; //把获取的id传递到请求参数
            console.log($scope.id)

            if ($scope.swop($index) == "下线") { //点击下线按钮
                $scope.status = 1; //状态为下线
                console.log($scope.status)
                $scope.putSwops(); //调用下线请求


            } else if ($scope.swop($index) == "上线") { //点击上线按钮
                $scope.status = 2; //状态为上线
                console.log($scope.status)
                $scope.putSwops(); //调用上线请求
            }
        }

        $scope.deleteList = function ($index) { //点击删除按钮
            if (confirm("删除后将下架从本地删除，确定要删除？")) { //提示框
                $scope.params = $scope.name[$index].id; //获取删除项的id
                console.log($scope.params)
                beg.deleteList($scope.params).then(function (response) { //调用删除请求
                    console.log(response)
                    $state.reload(); //删除成功刷新单前页面
                })
            } else {
                return //点击取消不进行任何操作
            }
        }


        $scope.data = function () { //封装按钮传参
            $state.go($state.$current, {
                page: page, //跳转页数
                size: 10,
            }, {
                reload: true //刷新单前页面
            })
        }

        $scope.skip1 = function () { //分页按钮
            page = $scope.value1; //获取按钮跳转的页数
            $scope.data(); //调用分页按钮传参
        }
        $scope.skip2 = function () {
            page = $scope.value2;
            console.log(page)
            $scope.data();
        }
        $scope.skip3 = function () {
            page = $scope.value3;
            console.log(page)
            $scope.data();
        }
        $scope.skip4 = function () {
            page = $scope.value4;
            console.log(page)
            $scope.data();
        }
        $scope.skip5 = function () {
            page = $scope.value5;
            console.log(page)
            $scope.data();
        }


        $scope.upDown = function () { //封装上一页下一页按钮传参
            $state.go($state.$current, {
                page: pega, //跳转页数
                size: 10,
            }, {
                reload: true //刷新单前页面
            })
        }

        $scope.forward = function () { //点击上一页按钮
            pega = parseInt($scope.now) - 1; //把单前页数转换为数字-1
            $scope.upDown(); //调用传参方法
        }

        $scope.backwards = function () { //点击下一页按钮
            pega = parseInt($scope.now) + 1; //把单前页数转换为数字+1
            $scope.upDown(); //调用传参方法
        }

    })