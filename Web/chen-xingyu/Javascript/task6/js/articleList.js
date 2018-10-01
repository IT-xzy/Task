app.controller('articleListCtrl',function ($scope,$http,$state,$stateParams,myStatus,myTypes) {
    $scope.Statuses=myStatus;
    $scope.Types=myTypes;
    $scope.params=$stateParams;
    console.log($stateParams);
    //首次载入文章列表页
    $http({
        method:'GET',
        url: '/carrots-admin-ajax/a/article/search',
        params: $stateParams
    }).then(function successCallBack(response) {
        console.log(response);
        console.log($stateParams);
        $scope.articleList = response.data.data.articleList;
        $scope.size= response.data.data.size;
        $scope.total = response.data.data.total;
        $scope.currentType=$scope.Types[0];
        $scope.currentStatus=$scope.Statuses[0];
    });
    $scope.currentPage=$stateParams.page;
    //日历样式
    $scope.format = "yyyy-MM-dd";
    $scope.altInputFormats = ['yyyy/M!/d!'];
    $scope.popup = {opened: false};
    $scope.popup1 = {opened: false};
    $scope.open = function () {
        $scope.popup.opened = true
    };
    $scope.open1 = function () {
        $scope.popup1.opened = true
    };
    //清除
    $scope.clear=function () {
        $state.go('frameState.articleList',
            {
                page: 1,
                size: undefined,
                endAt: undefined,
                startAt:undefined,
                type: undefined,
                status: undefined,
            });
    };
    //search搜索按钮
    $scope.search=function () {
        $scope.newStartAt=Date.parse($scope.date);//时间戳转换
        $scope.newEndAt=Date.parse($scope.date1)+86399999;//加一天减一毫秒，防止起始同一天无数据
        console.log($scope.newStartAt);
        console.log($scope.newEndAt);
        $state.go('frameState.articleList',
            {
                startAt: $scope.newStartAt||undefined,
                endAt: $scope.newEndAt||undefined,
                type: $scope.currentType.type,
                status: $scope.currentStatus.status,
                page: 1
            },{reload: true});
    };
    //新增article
    $scope.addList=function(){
        $state.go('frameState.addArticleList')
    };
    //delete article
    $scope.delete=function(id){
        bootbox.confirm({
            title: '操作提示',
            message: '<p class="text-center">确认删除吗？</p></br><p class="text-center">删除后无法找回</p>',
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
            callback: function(result){
                if(result===true){
                    $http({
                        method:'DELETE',
                        url: '/carrots-admin-ajax/a/u/article/'+id,
                        headers:{"Content-Type":"application/x-www-form-urlencoded"}
                    }).then(function successCallBack(res) {
                        console.log("delete"+res);
                        if(res.data.code===0){
                            $state.go('frameState.articleList',{
                                size: $scope.params.size,
                                page: $scope.params.page
                            },{reload: true})
                        }else{
                            alert(res.data.message);
                        }
                    })
                }
            }
        })
    };
    //编辑article
    $scope.editArticle=function(id){
        $state.go('frameState.addArticleList',{
            id : id //编辑Article添加id
        })
    };
    //上线 下线
    $scope.changeStatus=function (id,status) {
        if(status===1){
            $scope.upOrDown="上线";
            $scope.newStatus=2;
            bootbox.confirm({
                title: '操作提示',
                message: '<p class="text-center">上线后该图片将展示站轮播banner中。</p></br><p class="text-center">是否执行下上线操作？</p>',
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
                    if(result===true){
                        $http({
                            method: 'PUT',
                            url: '/carrots-admin-ajax/a/u/article/status',
                            params: {
                                status: $scope.newStatus,
                                id: id,
                            },
                            headers:{"Content-Type":"application/x-www-form-urlencoded"}
                        }).then(function successCallBack(res) {
                            if(res.data.code===0){
                                $state.go('frameState.articleList',{
                                    // page: $scope.params.page    //不知道作用，但不加不能自动刷新
                                },{reload: true})
                            } else {
                                alert(res.data.message);
                            }
                        })
                    }
                }
            });
        }else if(status===2){
            $scope.upOrDown="下线";
            $scope.newStatus=1;
            bootbox.confirm({
                title: '操作提示',
                message: '<p class="text-center">上线后该图片将展示站轮播banner中。</p></br><p class="text-center">是否执行下上线操作？</p>',
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
                    if(result===true){
                        $http({
                            method: 'PUT',
                            url: '/carrots-admin-ajax/a/u/article/status',
                            params: {
                                status: $scope.newStatus,
                                id: id,
                            },
                            headers:{"Content-Type":"application/x-www-form-urlencoded"}
                        }).then(function successCallBack(res) {
                            if(res.data.code===0){
                                $state.go('frameState.articleList',{
                                    page: $scope.params.page
                                },{reload: true})
                            } else {
                                alert(res.data.message);
                            }
                        })
                    }
                }
            });
        }
    };
    //点击页数
    $scope.pageChange=function () {
        $state.go('frameState.articleList', {page: $scope.currentPage},{reload: true});
        console.log($state.params);
    };
    //分页组件确定按钮
    $scope.getNewPage=function () {
        $scope.type=$scope.listType;
        $scope.status=$scope.listStatus;
        $state.go('frameState.articleList',
            {
                page: $scope.setPage,
                size: $scope.newSize,
            },{reload: true});
    };

});
