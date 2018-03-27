
myApp.controller("list",function ($scope,$state) {

    $scope.display=true;
    $scope.drop=function () {
        $scope.display = !$scope.display;
    };
    $scope.listson1=false;
    $scope.listfather1=function () {
        $scope.listson1=! $scope.listson1;
        $scope.listson2=false;
        $scope.listson3=false;
    };
    $scope.listson2=false;
    $scope.listfather2=function () {
        $scope.listson2=! $scope.listson2;
        $scope.listson1=false;
        $scope.listson3=false;
    };
    $scope.listson3=false;
    $scope.listfather3=function () {
        $scope.listson3=!$scope.listson3;
        $scope.listson1=false;
        $scope.listson2=false;
    };
    $scope.hopList=function () {
        $scope.colorAt1=true;
        $scope.colorAt2=false;
        $scope.listson1=true;
        $state.go('list.option1',{
            page:1,
            size:10
        },{reload: true})
    };
    $scope.hopWeb=function () {
        $scope.colorAt2=true;
        $scope.colorAt1=false;
        $scope.listson2=true;
        $state.go('list.welcome',
            {},{reload:true})
    }
    // $scope.params = $state.params;
    // $scope.state = state;
    // $scope.type = type;
    // $scope.startAt = $scope.params.startAt; //渲染时间
    // $scope.endAt = $scope.params.endAt;
    // $scope.params.startAt = ($scope.startAt) ? (Date.parse($scope.startAt) - (8 * 60 * 60 * 1000)) : "";
    // $scope.params.endAt = ($scope.endAt) ? (Date.parse($scope.endAt) + (16 * 60 * 60 * 1000 - 1)) : "";
    // $http({
    //     method: "GET",
    //     url: '/carrots-admin-ajax/a/article/search',
    //     params: $scope.params
    // }).then(function (response) {
    //     if (response.data.code === 0) {
    //         $scope.articleList = response.data.data.articleList;       // 返回的数据
    //         $scope.articleList.status = "";
    //         $scope.total = response.data.data.total;                      // 返回的数据用于分页插件
    //         $scope.bigTotalItems = $scope.total;                          //分页插件的总数
    //     } else {
    //         alert(response.data.message)
    //     }
    // });
});
