angular.module("myApp")
    .controller("listCrtl",function ($scope, $http, $stateParams, $state, $uibModal, $document, types, status, line) {
    // 初始化页面
    $scope.params = $stateParams;
    $scope.startAt = Number($scope.params.startAt) || undefined;  // 假如没有选择日期时点击搜索会上传undefined
    $scope.endAt = Number($scope.params.endAt) || undefined;
    $scope.size = $scope.params.size || 10;
    $scope.page = $scope.params.page || 1;
    $scope.typeNum = $scope.params.type;  // 刷新后能保存类型状态
    $scope.statusNum = $scope.params.status;

    // get请求
    $http({
        method: "GET",
        url: "/carrots-admin-ajax/a/article/search",
        params: $scope.params,
        responseType: "json"
    }).then(function (res) {
        if (res.data.code == 0) {
            console.log(res);
            $scope.articleList = res.data.data.articleList;  // 保存返回的列表数据
            $scope.totalItems = res.data.data.total;  // 保存返回的列表总个数
            $scope.currentPage = res.data.data.page;   // 保存返回的当前页数
            $scope.items = res.data.data.size;  // 设置分页插件的每页显示的数量等于返回显示的数量
            $scope.showPages = res.data.data.size; // 设置默认每页显示的数量等于返回的显示数据
        } else {
            alert("请求失败!");
        }
    })

   /* 日期选择器插件 */
    // 点击弹出日期选择器
    $scope.startDatPopup = function () {
        $scope.startDatOpen = true;
    };
    $scope.endDatPopup = function () {
        $scope.endDatOpen = true;
        $scope.endAt = undefined; // 初始化日期避免点击搜索后结束日期会每次少1毫秒
    };

    /* 搜索模块 */
    // 类型
    $scope.types = types; // 从constant中取出数据保存

    // 状态
    $scope.status = status;

    // 清空按钮
    $scope.clear = function () {
        $scope.startAt = undefined;
        $scope.endAt = undefined;
        $scope.typeNum = "";
        $scope.stautsNum = "";
        $state.go("home.article_list", {
            page: 1,
            startAt: $scope.startAt,
            endAt: $scope.endAt,
            type: $scope.typeNum,
            status: $scope.stautsNum,
        }, {
            reload: true
        });
    }

    // 新增
    $scope.add = function () {
        $state.go("home.article_detail",{
            id : ""
        })
    }

    // 搜索按钮
    $scope.search = function () {
        if (typeof $scope.startAt == "object") {  // 第一次进入列表页面获取到的时间为Mon Mar 05 2018 00:00:00 GMT+0800这种格式，则需要解析为时间戳
            $scope.startAt = $scope.startAt.getTime();
        }
        if (typeof $scope.endAt == "object") {
            $scope.endAt = $scope.endAt.getTime() + 86399999;  // 结束日期需要加上1天减1毫秒
        }
        $state.go("home.article_list", {
            startAt: $scope.startAt,
            endAt: $scope.endAt,
            type: $scope.typeNum,
            status: $scope.statusNum,
            page: 1
        }, {
            reload: true
        });
    }

    /* 分页模块 */
    // 改变页码加载数据
    $scope.pageChanged = function () {
        $state.go("home.article_list", {
            page: $scope.currentPage,
        }, {
            reload: true
        });
    }

    // 页码跳转
    $scope.submit = function () {
        $scope.currentPage = $scope.toPages;
        $state.go("home.article_list", {
            page: $scope.currentPage,
            size: $scope.showPages
        }, {
            reload: true
        });
    }

    /* 上下线模块 */
    $scope.line = line;

    // 上下线按钮
    $scope.upDown = function (size, parentSelector) {
        $scope.status = this.list.status;  // 保存当前点击项的状态
        $scope.id = this.list.id;

        //创建modal
        var parentElem = parentSelector ?
            angular.element($document[0].querySelector('.list' + parentSelector)) : undefined;
        var modalInstance = $uibModal.open({ // 使用$uibModal.open方法返回一个modal实例modalInstance
            ariaLabelledBy: 'modal-title', // 指定模态框的标题的编号，值为一个不带#的ID（string）
            ariaDescribedBy: 'modal-body', // 指定模态框的内容的编号，值为一个不带#的ID（string）
            templateUrl: 'modalContent.html', // 代表modal内容的路径(string)
            controller: 'modalCtrl', // 声明modal的控制器
            size: size, //  modal的可选后缀（string），控制modal的大小，如modal-sm
            appendTo: parentElem, //将modal插入的位置（angular.element),默认为body
            resolve: { // 这是一个入参,这个很重要,它可以把主控制器中的参数传到模态框控制器中
                param: function () {
                    return $scope.status;
                }
            }
        });
        modalInstance.result.then(function () {  // 从模态框点击确认后返回值的函数
            $http({
                method: "PUT",
                url: "/carrots-admin-ajax/a/u/article/status",
                params: {
                    id: $scope.id,
                    status: $scope.status == 1 ? 2 : 1
                }
            }).then(function (res) {
                if (res.data.code == 0) {
                    $state.reload("home.article_list"); // 请求成功后刷新当前页面
                    if ($scope.status == 1) {
                        alert("上线成功")
                    } else {
                        alert("下线成功")
                    }
                } else {
                    alert(res.data.message)
                }
            });
        },function () {
            // console.log("cancel");  // 点击取消后返回的函数
        });
    };

    // 编辑
    $scope.edit = function () {
        $state.go("home.article_detail",{
            id : this.list.id
        })
    }

    // 删除
    $scope.delete = function (size, parentSelector) {
        $scope.id = this.list.id;
        //创建modal
        var parentElem = parentSelector ?
            angular.element($document[0].querySelector('.list' + parentSelector)) : undefined;
        var modalInstance = $uibModal.open({ // 使用$uibModal.open方法返回一个modal实例modalInstance
            ariaLabelledBy: 'modal-title', // 指定模态框的标题的编号，值为一个不带#的ID（string）
            ariaDescribedBy: 'modal-body', // 指定模态框的内容的编号，值为一个不带#的ID（string）
            templateUrl: 'modalContent.html', // 代表modal内容的路径(string)
            controller: 'modalCtrl', // 声明modal的控制器
            size: size, //  modal的可选后缀（string），控制modal的大小，如modal-sm
            appendTo: parentElem, //将modal插入的位置（angular.element),默认为body
            resolve: { // 这是一个入参,这个很重要,它可以把主控制器中的参数传到模态框控制器中
                param: function () {
                    return "delete"
                }
            }
        });
        modalInstance.result.then(function () {  // 从模态框点击确认后返回值的函数
            $http({
                method: "DELETE",
                url: "/carrots-admin-ajax/a/u/article/" + $scope.id,
            }).then(function (res) {
                if (res.data.code == 0) {
                    $state.reload("home.article_list");  // 成功后刷新当前页面
                } else {
                    alert(res.data.message)
                }
            });
        },function () {
            // console.log("cancel");  // 点击取消后返回的函数
        });
    }
})

// 模态框控制器
app.controller("modalCtrl", function ($scope, $uibModalInstance, param) {
    if (param == "delete") {
        $scope.modalValue2 = "是否确认删除";
    } else if (param == 1) {
        $scope.modalValue = "上线后该图片将在轮播banner中展示。";
        $scope.modalValue2 = "是否执行上线操作？";
    } else {
        $scope.modalValue = "下线后该图片将不展示站轮播banner中。";
        $scope.modalValue2 = "是否执行下线操作？";
    }
    $scope.ok = function () {
        $uibModalInstance.close("ok");
    };
    $scope.cancel = function () {
        $uibModalInstance.dismiss('cancel');
    };
})