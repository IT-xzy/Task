myApp.controller("option1",function ($scope, $http, $state, $stateParams,$filter, types,status,articleState) {
    $scope.infoParams={};
    $scope.pageAt = ($stateParams.page)?Number($stateParams.page): 1;//判定当前页数没有的默认为1
    $scope.types = types;
    $scope.status = status;//给需要渲染的对象赋值
    //jia
    $scope.statusAt= $scope.infoParams.status;
    $scope.typeAt=$scope.infoParams.type;

    http();
    function http() {
        $http({
            method: "GET",
            url: '/carrots-admin-ajax/a/article/search',
            params: $scope.infoParams
        }).then(
            function successCallback(response) {
                $scope.article = response.data.data.articleList;
                $scope.articleNum = Math.ceil(response.data.data.total / response.data.data.size);
                $scope.pageShow = ($scope.articleNum < 5) ? $scope.articleNum : 5;
                if($scope.articleNum>5){
                    if($scope.pageAt<3) {
                        $scope.pageGather = [];
                        for (var i = 1; i <= $scope.pageShow; i++) {
                            $scope.pageGather.push(i);
                        }
                    }else {
                        if ($scope.pageAt > ($scope.articleNum - 3)) {
                            $scope.pageGather = [
                                $scope.articleNum - 4,
                                $scope.articleNum - 3,
                                $scope.articleNum - 2,
                                $scope.articleNum - 1,
                                $scope.articleNum
                            ]
                        } else {
                            $scope.pageGather[0] = $scope.pageAt - 2;
                            $scope.pageGather[1] = $scope.pageAt - 1;
                            $scope.pageGather[2] = $scope.pageAt;
                            $scope.pageGather[3] = ($scope.pageAt + 1);
                            $scope.pageGather[4] = $scope.pageAt + 2;
                        }
                    }
                } else {
                    $scope.pageGather = [];
                    for (var q = 1; q <= $scope.pageShow; q++) {
                        $scope.pageGather.push(q);
                    }
                }
            },
            function errorCallback(response) {
                alert(response.message);
            }
        )
    }
    $scope.statuses=function (id,parameterStatus) {
        console.log(parameterStatus);
        console.log(articleState["offLine"]);
        var Status = (parameterStatus===articleState["offLine"])?articleState["onLine"]:articleState["offLine"];
        console.log(Status);
        var putAway,soldOut;
        if(Status===articleState["offLine"]) {
            putAway = "确定下线？";
            soldOut = "下线成功";
        }else if(Status===articleState["onLine"]) {
            putAway="确定上线？";
            soldOut="上线成功";
        }
        if(confirm(putAway)){
            $http({
                method: "PUT",
                url: '/carrots-admin-ajax/a/u/article/status',
                params: {
                    id: id,
                    status: Status
                }
            }).then(
                function successCallback(response){
                    console.log(response);
                    alert(soldOut);
                    http();
                })
        }
    };
    $scope.expurgate= function (id) {
        $http({
            method: "delete",
            url: '/carrots-admin-ajax/a/u/article/'+id
        }).then(
            function (response) {
                if (response.code=== 0) {
                    http()
                }
            }
        );
        http();
    };
    $scope.empty = function () {
        $scope.infoParams.type = undefined;
        $scope.infoParams.status= undefined;
        $scope.startAt = undefined;
        $scope.endAt = undefined;
        http()
    };
    $scope.search = function (typeAt,statusAt ,start,end) {
        $scope.infoParams.page= 1;
        if(typeAt){
            $scope.infoParams.type=typeAt;
        }
        if(statusAt){
            $scope.infoParams.status= statusAt;
        }
        if(start){
            $scope.infoParams.startAt= Date.parse(start);
        }
        if (end){
            $scope.infoParams.entAt= Date.parse(end);
        }
        $scope.pageAt= $scope.infoParams.page;
        http()
    };

    console.log($scope.pageAt);
    $scope.goPage =function (page)  {
        $scope.infoParams.page=page;
        $scope.pageAt = page;
        http();
    };
    $scope.lastPage=function(page){
        page--;
        $scope.infoParams.page=page;
        $scope.pageAt = page;
        http();
    };
    $scope.nextPage=function(page){
        page++;
        $scope.infoParams.page=page;
        $scope.pageAt = page;
        http();
    };
    $scope.hopPape=function ()  {
        if($scope.hopNum>$scope.articleNum||$scope.hopNum<1){
            alert("超出页数范围")
        }else {
            $scope.infoParams.page=$scope.hopNum;
            $scope.pageAt = Number($scope.hopNum);
            http();
        }
    };
    $scope.newAdd = function (id) {
        $state.go("list.option2",{
            id:id
        },{reload:true})
    };

});