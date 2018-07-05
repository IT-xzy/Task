myApp.controller('listCtrl',function($http,$scope,$state, $stateParams, list,listStatus,down){  //自己命名的名字，必须要把它写在函数的参数中，否则无法调用
    //取出来要repeat的常量，储存起来
    $scope.list = list;//类型
    $scope.listStatus = listStatus;//状态


    $scope.params = $stateParams;
    console.log($scope.params);
    $scope.type = $scope.params.type;
    $scope.status = $scope.params.status;
    $scope.startAt = Number($scope.params.startAt) || undefined;
    $scope.endAt = Number($scope.params.endAt) || undefined;


    $http({
        method: 'get',
        url: '/carrots-admin-ajax/a/article/search',
        params: $scope.params,
        responseType: "json"
    }).then(function successCallback(listUrl){
        if(listUrl.data.code === 0){
            //获取的后台数据
            //ng-repeat渲染数据
            $scope.records = listUrl.data.data.articleList;
            $scope.totalItems = listUrl.data.data.total;//总条目数
            $scope.paramsSize1 = listUrl.data.data.size;//每页显示条目数
            $scope.currentPage = $scope.params.page;//实现页数数据和页面显示联动，让点击的页数等于后台返回的页数
            //总页数
            $scope.pageAll = Math.ceil( $scope.totalItems/$scope.paramsSize1);
            console.log($scope.pageAll);
        }else{
            alert('请求失败');
        }

    });


    /* 日期选择器插件 */
    // 点击弹出日期选择器
    $scope.startDatPopup = function () {
        $scope.startDatOpen = true;
    };
    $scope.endDatPopup = function () {
        $scope.endDatOpen = true;
        $scope.endAt = undefined; // 初始化日期避免点击搜索后结束日期会每次少1毫秒
    };






    //搜索按钮
    $scope.searching = function(){
        if (typeof $scope.startAt == "object") {  // 第一次进入列表页面获取到的时间为Mon Mar 05 2018 00:00:00 GMT+0800这种格式，则需要解析为时间戳
            $scope.startAt = $scope.startAt.getTime();
        }
        if (typeof $scope.endAt == "object") {
            $scope.endAt = $scope.endAt.getTime() + 86399999;  // 结束日期需要加上1天减1毫秒
        }
      $state.go('backstage.list',{
          // page: 1,
          type:$scope.type,
          status:$scope.status,
          startAt: $scope.startAt,
          endAt: $scope.endAt
      },{reload:true});
    };

    // 清除按钮
    $scope.clean = function(){
      $state.go('backstage.list',{
          page: 1,
          size: 10,
          type: '',
          status: '',
          startAt: '',
          endAt: ''
      },{reload:true});
    };

    //分页按钮
    $scope.listBt = function(){
        console.log($scope.currentPage);
        $state.go('backstage.list',{
            page: $scope.currentPage//当前点击的按钮
        },{reload:true});
    };



    //分页中的确定按钮
    $scope.confirm = function(){
        $scope.currentPage = $scope.toPage;
        $state.go('backstage.list',{
            page: $scope.currentPage,//去第几页
            size: $scope.paramsSize1//每页有多少条目
        },{reload:true});
    };


    // 删除
    $scope.delete = function(id){
        bootbox.confirm({
            title: "操作提示",
            message: "确定删除吗？",
            buttons: {
                confirm: {
                    label: '确认',
                    className: 'btn-success'
                },
                cancel: {
                    label: '取消',
                    className: 'btn-danger'
                }
            },callback: function(result){//回调函数，result是你点击的结果
                if(result === true){
                    console.log(id);
                    $http({
                        method: 'delete',
                        url: '/carrots-admin-ajax/a/u/article/' + id,
                        headers:{"Content-Type":"application/x-www-form-urlencoded"}
                    }).then(function successCallback(listUrl){
                        console.log(listUrl);
                        if(listUrl.data.code === 0){
                            $state.go('backstage.list',{
                                page: $scope.params.page,
                                size: $scope.params.size
                            },{reload:true});

                        }else{
                            alert(listUrl.data.message);
                        }
                    });
                }
            }
        });

    };

    //上、下线
    $scope.down = function(id,status){
        console.log(id);
        console.log(status);
        if(status === 1){
            $scope.condition = 2;
            bootbox.confirm({
                title: "操作提示",
                message: "<p class='text-center'>上线后该图片将展示站轮播banner中。</p></br><p class='text-center'>是否执行下上线操作？</p>",
                buttons: {
                    confirm: {
                        label: '确认',
                        className: 'btn-success'
                    },
                    cancel: {
                        label: '取消',
                        className: 'btn-danger'
                    }
                },callback: function(result){
                    console.log(1);
                    if(result === true){
                        $http({
                            method: 'put',
                            params: {id: id,status: $scope.condition},
                            url: '/carrots-admin-ajax/a/u/article/status',
                            headers:{"Content-Type":"application/x-www-form-urlencoded"}
                        }).then(function successCallback(listUrl){
                            if(listUrl.data.code === 0){
                                $state.go('backstage.list',{
                                    id: id
                                },{reload: true});
                            }else{
                                alert(listUrl.data.message);
                            }
                        });
                    }
                }
            })
        }else if(status === 2){
            $scope.condition = 1;
            bootbox.confirm({
                title: "操作提示",
                message: "<p class='text-center'>下线后该图片将不展示站轮播banner中。</p></br><p class='text-center'>是否执行下线操作？</p>",
                buttons: {
                    confirm: {
                        label: '确认',
                        className: 'btn-success'
                    },
                    cancel: {
                        label: '取消',
                        className: 'btn-danger'
                    }
                },callback: function(result){
                    if(result === true){
                        $http({
                            method: 'put',
                            params: {id: id,status: $scope.condition},
                            url: '/carrots-admin-ajax/a/u/article/status',
                            headers:{"Content-Type":"application/x-www-form-urlencoded"}
                        }).then(function successCallback(listUrl){
                            if(listUrl.data.code === 0){
                                $state.go('backstage.list',{
                                    id: id
                                },{reload: true});
                            }else{
                                alert(listUrl.data.message);
                            }
                        });
                    }
                }
            })
        }

    };

});
