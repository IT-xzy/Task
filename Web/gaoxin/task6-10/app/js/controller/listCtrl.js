angular.module("myApp").controller('listCtrl', function($scope, $state,$http,$stateParams,picktype,pickstatus,ArticleService) {
    let vm =this;
    $scope.picktype=picktype;
    $scope.pickstatus=pickstatus;
    $scope.currentPage =$stateParams.page;
    vm.searchParams={};//请求参数
    vm.searchParams.page=$stateParams.page;
    vm.searchParams.startAt= parseInt($stateParams.startAt)||null;
    vm.searchParams.endAt=  parseInt($stateParams.endAt)+86399999||null; //防止日期转换成NAN
    vm.searchParams.type=$stateParams.type;
    vm.searchParams.status= $stateParams.status;
    //get请求渲染页面
    ArticleService.getArticleList(vm.searchParams).then(function (res) {
        if (res.data.code === 0) {
            $scope.totalItems =  res.data.data.total;//总条数
            $scope.lists = res.data.data.articleList;
        } else {
           bootbox.alert(res.data.message);
        }
    });
    $scope.details= function() {
        $state.go ('backstage.details');
    };
    //search,搜索之后根据URL参数渲染时间插件和输入框
    $scope.dateStart = new Date( parseInt($stateParams.startAt));//转化成整数
    $scope.dateEnd = new Date( parseInt($stateParams.endAt));
    $scope.searchType = $stateParams.type? parseInt($stateParams.type):undefined;
    $scope.searchStatus = $stateParams.status?parseInt($stateParams.status):undefined;
    //返回stateParams对象
    vm.stateParams =( page,startAt,endAt,type,status)=>{
        return{page, startAt, endAt, type, status}
    } ;
    //清除按钮
    $scope.clear= function() {
        if(!$stateParams.startAt &&!$stateParams.endAt &&!$stateParams.type && !$stateParams.status){
            $state.reload();
        }
        else {
            $state.go('backstage.list',
                vm.stateParams()//全部undefined
            );
        }
    };
    //搜索按钮
    $scope.search=function (dateStart,dateEnd) {
        vm.switchTime= time => time>0? new Date(time).getTime():null;//如果不是invalid值，返回时间戳
        $state.go('backstage.list',
            vm.stateParams('',vm.switchTime(dateStart),vm.switchTime(dateEnd),$scope.searchType,$scope.searchStatus)
        );
    };
    //删除按钮
    $scope.delete=function (id) {
        bootbox.confirm({
            title:"操作提示",
            message: "确认删除?",
            buttons: {
                confirm: {label: '确认', className: 'btn-success'},
                cancel: {label: '取消', className: 'btn-danger'}
            },
            callback: function (result) {
                if (result) {
                    ArticleService.delArticle(id).then(function (res) {
                        if (res.data.code === 0) {
                            $state.reload();
                            bootbox.alert('删除成功')
                        } else {
                           bootbox.alert(res.data.message);
                        }
                    });
                }
            }
        });
    };
    //上线下线按钮
    $scope.change_status=function (id,status) {
        if (status===1){
            bootbox.confirm({
                title:"操作提示",
                message: "<p class='text-center' style='color: silver'>上线后该图片将在轮播banner中展示。</p>" +
                "<p class='text-center'>是否执行上线操作?</p>",
                buttons: {
                    confirm: {label: '确认', className: 'btn-success'},
                    cancel: {label: '取消', className: 'btn-danger'}
                },
                callback: function (result) {
                    if (result === true) {
                        ArticleService.changeArticleStatus(id, 2).then(function (res) {
                            if (res.data.code === 0) {
                                $state.reload();
                                bootbox.alert('上线成功')
                            } else {
                                bootbox.alert(res.data.message);
                            }
                        });
                    }
                }
            });
        }
        if (status===2){
            bootbox.confirm({
                title:"操作提示",
                message: "<p class='text-center' style='color: silver'>下线后该图片将不展示站轮播banner中。</p>" +
                "<p class='text-center'>是否执行下线操作?</p>",
                buttons: {
                    confirm: {label: '确认', className: 'btn-success'},
                    cancel: {label: '取消', className: 'btn-danger'}
                },
                callback: function (result) {
                    if (result === true) {
                        ArticleService.changeArticleStatus(id, 1).then(function (res) {
                            if (res.data.code === 0) {
                                $state.reload();
                                bootbox.alert('下线成功')
                            } else {
                                bootbox.alert(res.data.message);
                            }
                        });
                    }
                }
            });
        }
    };
    //编辑按钮
    $scope.edit=function (id) {
        $state.go('backstage.details',{"id":id});
    };
    //翻页
    $scope.change =function () {
        $state.go('backstage.list',
            {"page": $scope.currentPage,}
        );
    };
//时间插件配置
    $scope.startOpen = function() {
        $scope.startPopup = true;
    };
    $scope.endOpen = function() {
        $scope.endPopup = true;
    };
    $scope.startDateOptions = {
        maxDate:new Date(),
    };
    $scope.endDateOptions = {
        maxDate:new Date()
    };
    //时间限制
    $scope.dateChange=function(){
        $scope.startDateOptions.maxDate = $scope.dateEnd||new Date();
        $scope.endDateOptions.minDate = $scope.dateStart||'';
    };
});
