myApp.controller("option1",function ($scope, $http, $state, $stateParams) {
    $scope.pageAt = Number($stateParams.page);
    console.log($scope.pageAt);
    $scope.infoParams={};
    $scope.infoParams.type = $stateParams.type;
    $scope.infoParams.status = $stateParams.status;
    $scope.infoParams.page = $stateParams.page;
    console.log($scope.pageAt);
    // $scope.inputNum.page = $stateParams.page;
    http();
    function http() {
        $http({
            method: "GET",
            url: '/carrots-admin-ajax/a/article/search',
            params: $scope.infoParams
        }).then(
            function successCallback(response) {
                console.log(response);
                $scope.article = response.data.data.articleList;
                console.log($scope.article);
                $scope.articleNum = Math.ceil(response.data.data.total / response.data.data.size);
                $scope.pageShow = ($scope.articleNum < 5) ? $scope.articleNum : 5;
                if($scope.articleNum>5){
                    if($scope.pageAt<3) {
                        $scope.pageGather = [];
                        for (var i = 1; i <= $scope.pageShow; i++) {
                            $scope.pageGather.push(i);
                        }
                    }else {if($scope.pageAt>($scope.articleNum-3)){
                        $scope.pageGather = [
                        $scope.articleNum-4,
                        $scope.articleNum-3,
                        $scope.articleNum-2,
                        $scope.articleNum-1,
                        $scope.articleNum
                    ]
                    }else {$scope.pageGather = [
                        $scope.pageAt-2,
                        $scope.pageAt-1,
                        $scope.pageAt,
                        $scope.pageAt+1,
                        $scope.pageAt+2
                    ];}}

                }else {
                    $scope.pageGather = [];
                    for (var q = 1; q <= $scope.pageShow; q++) {
                        $scope.pageGather.push(q);
                    }
                }
            },
            function errorCallback(response) {
                alert(response.message)
            }
        )
    }
    console.log($scope.pageAt);
    $scope.goPage =function (page)  {
        $state.go('list.option1', {
         page: page//传递参数到路由页面，保存在url里
    }, {reload: true});
    };
    $scope.lastPage=function(page){
        page--;
        $state.go('list.option1', {
            page: page//传递参数到路由页面，保存在url里
        }, {reload: true});
    };
    $scope.nextPage=function(page){
        page++;
        $state.go('list.option1', {
            page: page//传递参数到路由页面，保存在url里
        }, {reload: true});
    };
    $scope.hopPape=function ()  {
        if($scope.hopNum>$scope.articleNum){
            alert("最多只有"+$scope.articleNum+"页")
        }else {
            $state.go('list.option1', {
                page: $scope.hopNum//传递参数到路由页面，保存在url里
            }, {reload: true});
        }
    };
});