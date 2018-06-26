
//article列表控制器
angular.module('App')
.controller('artCtrl', function (
    $scope,
    $http,
    $state,
    $stateParams,
    myConstantType,
    myConstantStatus,
    ArticleManagementService
) {

    $scope.param = {};

    $scope.typeData = myConstantType;

    $scope.statusData = myConstantStatus;

    //日期插件
    //格式化日期
    $scope.formatStart = 'yyyy/MM/dd';
    $scope.formatEnd = 'yyyy/MM/dd';
    //手动输入日期的格式
    $scope.altInputFormats = ['yyyy/M!/d!'];

    //设置可选日期范围
    $scope.dateOptions = {
        maxDate: new Date()
    };
    $scope.popupStart = {
        opened: false
    };
    $scope.openStart = function () {
        $scope.popupStart.opened = true;
    };
    $scope.popupEnd = {
        opened: false
    };
    $scope.openEnd = function () {
        $scope.popupEnd.opened = true;
    };

    //分页
    $scope.maxSize = 5;
    $scope.bigTotalItems = $scope.total;
    $scope.param.page = 1;

    //get article列表
    //日期
    if($stateParams.startAt){
        $scope.param.startAt = $stateParams.startAt;
    }
    if($stateParams.endAt){
        $scope.param.endAt = $stateParams.endAt;
    }
    //type
    if($stateParams.type){
        $scope.param.type = parseInt($stateParams.type);
    }
    //status
    if($stateParams.status){
        $scope.param.status = parseInt($stateParams.status);
    }
    //页数
    if($stateParams.page){
        $scope.param.page = $stateParams.page;
    }

    ArticleManagementService.getArticleList($scope.param)
        .then(function (response) {
            if(response.data.code===0){

                //article列表
                $scope.lists = response.data.data.articleList;
                $scope.total = response.data.data.total;

                //跳页后渲染日期
                if($stateParams.startAt){
                    var date1 = new Date(parseInt($stateParams.startAt));
                    Y1 = date1.getFullYear() + '/';
                    M1 = (date1.getMonth()+1 < 10 ? '0'+(date1.getMonth()+1) : date1.getMonth()+1) + '/';
                    D1 = date1.getDate();
                    $scope.param.startAt = new Date(date1);
                    // $('#testDate1').datepicker('setDate', new Date(Y1+M1+D1));
                }
                if($stateParams.endAt){
                    var date2 = new Date(parseInt($stateParams.endAt)-86399999);
                    Y2 = date2.getFullYear() + '/';
                    M2 = (date2.getMonth()+1 < 10 ? '0'+(date2.getMonth()+1) : date2.getMonth()+1) + '/';
                    D2 = date2.getDate();
                    $scope.param.endAt = new Date(date2);
                    // $('#testDateEnd').datepicker('setDate', new Date(Y2+M2+D2));
                }
                //翻页
                $scope.page = function() {
                    $state.go('list.article', {page: $scope.param.page});
                };
            }
        });

    //搜索
    $scope.search = function () {
        if($scope.param.startAt){
            $scope.param.startAt = $scope.param.startAt.valueOf();
        }
        if($scope.param.endAt){
            $scope.param.endAt = $scope.param.endAt.valueOf()+86399999;
        }
        if($scope.param.endAt-$scope.param.startAt>=0||$scope.param.endAt==null||$scope.param.startAt==null){
            $scope.param.page = 1;
            $state.go('list.article', $scope.param);
        }else {
            bootbox.alert('截至时间必须大于或等于开始时间!');
            $scope.param.startAt='';
            $scope.param.endAt = '';
        }
    };
    //清空
    $scope.clear = function () {
        angular.forEach($scope.param, function (data,index,array) {
            array[index] = '';
        });
        $state.go('list.article', $scope.params = $scope.param)
    };

    //新增页面
    $scope.add = function () {
        $state.go('list.add');
    };
    //上线下线
    $scope.afk = function (id, status) {
        id = this.lis.id;
        status = this.lis.status;
        if(status === 1){
            bootbox.confirm("上线后该图片将在轮播banner中展示,是否执行上线操作?", function (result) {
                if(result){
                    ArticleManagementService.changeArticleStatus(id, 2)
                        .then(function (response) {
                            if(response.data.code === 0){
                                bootbox.alert("上线成功!");
                                $state.reload('list.article');
                            }else {
                                bootbox.alert(response.data.message);
                            }
                        })
                }else {
                    return
                }
            })
        }else {
            if(status === 2){
                bootbox.confirm("下线后该图片将不再展示在轮播banner中,是否执行下线操作?", function (result) {
                    if(result){
                        ArticleManagementService.changeArticleStatus(id, 1)
                            .then(function (response) {
                                if(response.data.code === 0){
                                    bootbox.alert("下线成功!");
                                    $state.reload('list.article');
                                }else {
                                    bootbox.alert(response.data.message);
                                }
                            })
                    }else {
                        return
                    }
                })
            }
        }
    };
    //编辑
    $scope.compile = function (id) {
        id = this.lis.id;
        $state.go('list.add', {id: id});
    };
    //删除
    $scope.delete = function (id) {
        id = this.lis.id;
        bootbox.confirm("确定删除?", function (result) {
            if(result){
                ArticleManagementService.delArticle(id)
                    .then(function successCallback() {
                        $state.reload('list.article');
                    })
            }
        });
    };
});

