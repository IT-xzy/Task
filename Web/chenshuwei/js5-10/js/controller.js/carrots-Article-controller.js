angular.module("myApp")
    .controller('ArticleList', ['$scope','$http','type','status','$state','$stateParams','$filter','myBannerService',function ($scope, $http,type,status,$state,$stateParams,$filter,myBannerService) {
        //初始显示页面
        //刷新后取出参数给现有的数据赋值
        var arti=this;
      arti.startDate=$filter('date')($stateParams.startAt,'yyyy/MM/dd');//开始时间
      arti.endDate=$filter('date')($stateParams.endAt,'yyyy/MM/dd');//结束时间
      arti.selectStatus=$stateParams.status;//下拉菜单状态
      arti.selectType=$stateParams.type;//下拉菜单类型
        console.log(Date.parse('2018/02/02'));
        console.log(Date.parse('2018-02-02'));
        console.log(new Date())
      // arti.items=$stateParams.size;//每页显示条数
        myBannerService.getBannerList($stateParams).then(function (res) {
            var date=res.headers().date
            console.log(date);
            if(res.data.code===0){
                //从接口获取数据，然后ng-repeat出来
                arti.articleList = res.data.data.articleList;
                arti.items = arti.size;
                arti.bigTotalItems = res.data.data.total;///总条数赋给分页
                arti.currentPage=$stateParams.page;//当前页数重新赋值，只能在回调函数里，在外面会被请求回来的数据覆盖
            }
            else {
                bootbox.alert('请求失败'+res.status)
            }
        });

    // $http({
    //     method: 'GET',
    //     url: '/carrots-admin-ajax/a/article/search',
    //     params:$stateParams,
    //     headers: {'Content-type': 'application/json'}
    // }).then(function (response) {
    //     if(response.status===200&&response.data.code===0) {
    //         //从接口获取数据，然后ng-repeat出来
    //         arti.articleList = response.data.data.articleList;
    //         arti.items = arti.size;
    //         arti.bigTotalItems = response.data.data.total;///总条数赋给分页
    //         arti.currentPage=$stateParams.page;//当前页数重新赋值，只能在回调函数里，在外面会被请求回来的数据覆盖
    //
    //     }
    // }).catch(function (response) {
    //     bootbox.alert('请求失败')
    // });
    arti.status = status;
    arti.types=type;

    // arti.seach = function () {
    //     $state.go('carrots.Artical-list',
    //         {
    //         type: arti.selectType,
    //         status:arti.selectStatus,
    //         startAt: (arti.startDate)?Date.parse(arti.startDate):undefined,
    //         endAt: (arti.endDate)?Date.parse(arti.endDate)+86399999:undefined,
    //             page:1,
    //         },
    //         {reload: true}
    //         )};
        //搜索点击事件
    arti.seach=seach;
    function seach() {
        $state.go('carrots.Artical-list',
            {
                type: arti.selectType,
                status:arti.selectStatus,
                startAt: (arti.startDate)?Date.parse(arti.startDate):undefined,
                endAt: (arti.endDate)?Date.parse(arti.endDate)+86399999:undefined,
                page:1,
            },
            {reload: true}
        )
    }
        //清除点击事件
    arti.cleanSeach=cleanSeach;
    function cleanSeach() {
        $state.go('carrots.Artical-list',
            {
                type: undefined,
                status:undefined,
                startAt: undefined,
                endAt: undefined,
                page:1,
                size:10
            },
            {reload: true}
        )
    }

        //上下线功能
        arti.changeStatu=function (statu) {
            //判断当前状态是1还是2
            arti.alterStatu=(statu.status===1)?2:1;
            arti.getId=statu.id;
            bootbox.confirm({
                size:'small',
                title:'提示',
                message:(statu.status===1)?'是否执行上线操作？':'是否执行下线操作？',
                callback:function (result) {
                    if(result===true){
                        $http({
                            method: 'PUT',
                            url: '/carrots-admin-ajax/a/u/article/status',
                            params:{id:arti.getId,status:arti.alterStatu},
                            headers: {'Content-type': 'application/json'}
                        }).then(function (response) {
                            if(response.data.code===0){
                            $state.go('carrots.Artical-list',
                                {
                                },
                                {reload: true}
                            );
                            if(statu.status===1) {
                                bootbox.alert('上线成功')
                            }
                            else {
                                bootbox.alert('下线成功')
                            }
                            }
                        }).catch(function (response) {
                            bootbox.alert('请求失败'+response.statu)
                        })
                    }
                }
            })
        };
        arti.deleteItem=function (item) {
            arti.getId=item.id;
            bootbox.confirm({
                size:'small',
                title:'提示',
                message:'是否确认删除',
                callback:function (result) {
                    if(result===true){
                        myBannerService.delBannerItem(arti.getId).then(function (res) {
                            if(res.data.code===0){
                                $state.go('carrots.Artical-list',
                                    {},
                                    {reload: true}
                                );
                                bootbox.alert('删除成功')
                            }
                            else {
                                bootbox.alert(response.status)
                            }
                        });
                    }
                }
            })

        };
        //分页最多显示5页，其余隐藏
    arti.maxSize = 5;
    arti.bigCurrentPage = 1;
        //当model值改变时，把改变的值传给把值传递给$statePramas
    arti.pageChange=function () {
        $state.go('carrots.Artical-list',
            {
                page:arti.currentPage,
                size:arti.items
            },
            {reload: true}
        )
    };
        //改变输入框的每页显示条数，跳到第几页时，把值传递给$statePramas
    arti.changeDefault=function () {
        $state.go('carrots.Artical-list',
            {
                page:arti.page,
                size:arti.size
            },
            {reload: true}
        )
    };
    //点击编辑把id传给编辑页
    arti.edit=function (id) {
        $state.go('carrots.Artical-detail',{id:id})
    }
        arti.size = $stateParams.size;
        arti.page = $stateParams.page;
}]);

