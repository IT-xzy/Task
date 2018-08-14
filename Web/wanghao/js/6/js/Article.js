angular.module("myApp")
    .controller("articleController", function ($rootScope, $scope, articleConstant, deg, $state, $stateParams,WW) {
        //    console.log($stateParams)
        
        var abc = function () {
            ww = 555
            $scope.$apply()
        }()
        console.log(WW)
        console.log($scope.WW)
        $scope.pagecount = {
            page: null,
            allpage: null
        }
        $scope.request = {};
        $scope.headtitle = articleConstant.headtitle; //载入列表名称
        $scope.typeItem = articleConstant.typeItem; //载入type列表
        $scope.statusItem = articleConstant.statusItem; //载入status；列表
        if ($stateParams.size) { //设置默认页数；
            $scope.size = $stateParams.size
        } else {
            $scope.size = 10;
        }
        if ($stateParams.status) { //设定默认显示status
            $scope.request.status = ~~$stateParams.status;
        } else {
            $scope.request.status = undefined;
        }
        if ($stateParams.type) { //设置默认显示的type
            $scope.request.type = ~~$stateParams.type;
        } else {
            $scope.request.type = undefined;
        }
        $scope.page = undefined;
        $scope.refer = function () { //请求搜索
            let datestart = $scope.start; //开始时间戳
            if (datestart) {
                datestart = datestart.getTime();
            } else {
                datestart = null;
            }
            let dateend = $scope.end; //结束时间戳
            if (dateend) {
                dateend = dateend.getTime();
                if (dateend == datestart) { //如果起始时间和结束时间一样;
                    dateend = dateend + 86399999;
                }
            } else {
                dateend = null;
            }
            //传输参数
            $scope.request.startAt = datestart;
            $scope.request.endAt = dateend;
            deg.seachArticle($scope.request, $stateParams.page, $scope.size).then(function success(resp) { //读取请求
                if (resp.data.code == 0) {
                    // console.log(resp);
                    $scope.mainmassge = resp.data.data.articleList;
                    $scope.size = resp.data.data.size;
                    $scope.total = resp.data.data.total;
                    $scope.pagecount = {
                        page: ~~$stateParams.page,
                        allpage: Math.ceil($scope.total / $scope.size),
                    }
                }
            });
            // 分页函数
        };
        $scope.refer();
      
        $scope.del = function () { //清楚函数
            $scope.start = undefined;
            $scope.end = undefined;
            $scope.request.type = undefined;
            $scope.request.status = undefined;
        };
        $scope.changeStatus = function (id, status) { //上线下线请求
            deg.articleStatus(id, status).then(
                function (resp) {
                    if (resp.data.code == 0) {
                        $scope.refer();
                        $rootScope.pop = false
                    }
                }
            );
        };
        $scope.delId = function (id) { //删除函数
            deg.deleteArticle(id).then(function (resp) {
                if (resp.data.code == 0) {
                    $rootScope.pop = false;
                    $scope.refer();
                }
            });
        };
        $scope.skip = function (page, size) {
            if (page) {
                if (page != ~~$stateParams.page||page==1) {
                    $state.go('u.article', {
                        page: page,
                        size: size,
                        status: $scope.request.status,
                        type: $scope.request.type
                    })
                }
            }
        } 

        $scope.isa = function (num) { //页面变色
            if (num == ~~$stateParams.page) {
                return true;
            } else {
                return false;
            }
        }

    });