app.controller('detailCtrl', function ($scope, $state, $stateParams, $http, types, industry) {

    var theThreeName = sessionStorage.getItem('name');
    if (theThreeName){
        // 取出constant里面的types、status
        $scope.types = types;
        $scope.industry = industry;

        // 初始化页面数据
        $state.params = $stateParams;
        $scope.detailTheOptions = undefined;
        $scope.detailTheSecondOptions = undefined;


        // 请求单个id的data
        if ($state.params.id){
            $http({
                method: 'GET',
                url: '/carrots-admin-ajax/a/article/' + $state.params.id
            }).then(function (response) {
                if (response.data.code == 0){
                    console.log(response);
                    $scope.detailTheTitle = response.data.data.article.title;
                    $scope.detailTheOptions = response.data.data.article.type;
                    $scope.detailTheSecondOptions = response.data.data.article.industry;
                    $scope.detailTheContent = response.data.data.article.content;
                    $scope.detailTheLink = response.data.data.article.url;
                    $scope.detailTheCreateAt = response.data.data.article.createAt;
                    $scope.detailImgUrl = response.data.data.article.img;
                    // 将小图预览框隐藏
                    $scope.detailSmallPic = true;
                    // 将大图预览框显示
                    $scope.detailBigPic = true;
                }else {
                    console.log('请求失败');
                }
            });
        }
////////////////////////////////////////////////////////


        // 立即上线
        $scope.detailToUp = function () {
            if ($state.params.id){
                $http({
                    method: 'PUT'   ,
                    url: '/carrots-admin-ajax/a/u/article/' + $state.params.id,
                    params: {
                        title: $scope.detailTheTitle,
                        type: $scope.detailTheOptions,
                        industry: $scope.detailTheSecondOptions,
                        status: 2,
                        img: $scope.detailImgUrl,
                        content: $scope.detailTheContent,
                        url: $scope.detailTheLink,
                        createAt: $scope.detailTheCreateAt
                    }
                }).then(function (response) {
                    if (response.data.code == 0){
                        $state.go('home.list');
                        bootbox.alert({
                            title:'提示',
                            message: "新增成功",
                            backdrop: true
                        });
                        reload: true;
                    }else {
                        bootbox.alert({
                            title:'提示',
                            message: "新增失败",
                            backdrop: true
                        });
                    }
                })
            }else {
                $http({
                    method: 'POST',
                    url: '/carrots-admin-ajax/a/u/article',
                    params: {
                        title: $scope.detailTheTitle,
                        type: $scope.detailTheOptions,
                        industry: $scope.detailTheSecondOptions,
                        status: 2,
                        img: $scope.detailImgUrl,
                        content: $scope.detailTheContent,
                        url: $scope.detailTheLink,
                    }
                }).then(function (response) {
                    if (response.data.code == 0){
                        $state.go('home.list');
                        bootbox.alert({
                            title:'提示',
                            message: "新增成功",
                            backdrop: true
                        });
                        reload: true;
                    }else {
                        bootbox.alert({
                            title:'提示',
                            message: "新增失败",
                            backdrop: true
                        });
                    }
                })
            }
        };

        // 存为草稿
        $scope.detailSave = function () {
            if ($state.params.id){
                $http({
                    method: 'PUT',
                    url: '/carrots-admin-ajax/a/u/article/' + $state.params.id,
                    params: {
                        title: $scope.detailTheTitle,
                        type: $scope.detailTheOptions,
                        industry: $scope.detailTheSecondOptions,
                        status: 1,
                        img: $scope.detailImgUrl,
                        content: $scope.detailTheContent,
                        url: $scope.detailTheLink,
                        createAt: $scope.detailTheCreateAt
                    }
                }).then(function (response) {
                    if (response.data.code == 0){
                        $state.go('home.list');
                        bootbox.alert({
                            title:'提示',
                            message: "新增成功",
                            backdrop: true
                        });
                        reload: true;
                    }else {
                        bootbox.alert({
                            title:'提示',
                            message: "新增失败",
                            backdrop: true
                        });
                    }
                })
            }else {
                $http({
                    method: 'POST',
                    url: '/carrots-admin-ajax/a/u/article',
                    params: {
                        title: $scope.detailTheTitle,
                        type: $scope.detailTheOptions,
                        industry: $scope.detailTheSecondOptions,
                        status: 1,
                        img: $scope.detailImgUrl,
                        content: $scope.detailTheContent,
                        url: $scope.detailTheLink,
                    }
                }).then(function (response) {
                    if (response.data.code == 0){
                        $state.go('home.list');
                        bootbox.alert({
                            title:'提示',
                            message: "新增成功",
                            backdrop: true
                        });
                        reload: true;
                    }else {
                        bootbox.alert({
                            title:'提示',
                            message: "新增失败",
                            backdrop: true
                        });
                    }
                })
            }
        };
        // 取消
        $scope.detailCancel = function () {
            $state.go('home.list');
        };
    }else {
        $state.go('login');
    }
});