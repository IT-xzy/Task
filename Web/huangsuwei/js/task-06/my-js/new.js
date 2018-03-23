myApp.controller("page1",function ($scope,$http,$stateParams,$state,filter,types,states,articleState){
    $scope.params=$state.params;
    $scope.states=states;
    $scope.types=types;
    $scope.startAt=$scope.params.startAt;
    $scope.endAt=$scope.params.endAt;
    $scope.params.startAt=($scope.startAt) ? (Date.parse($scope.startAt)-(8*60*1000-1)):"";
    $scope.params.endAt=($scope.endAt) ? (Date.parse($scope.endAt)-(8*60*1000-1)):"";
    $http({
        method:"GET",
        url: '/carrots-admin-ajax/a/article/search',
        params:$scope.params
    }).then(function (response){
        if(response.data.code===0){
            $scope.articleList=response.data.data.articleList;
            //返回数据
            $scope.articleList.status="";
            $scope.total = response.data.data.total;
            $scope.bigTotalItem = $scope.total;
            console.log(response.data.data.total);
        }else {
            alert(response.data.message)
        }
    });



    $scope.clearSearch=function (startAt,endAt,type,status) {
        $state.go("home.page1", {
            startAt: startAt,
            endAt: endAt,
            type: type,
            status: status
        },{reload:true});
        //需要修改
    };



    $scope.statuses =function (id,parameterStatus) {
        var Status = (parameterStatus === articleState["offLine"])? articleState["onLine"]:articleState["offLine"];
        var putAway,soldOut;
        if(Status === articleState["onLine"]){
            putAway = "确定要下线吗";
            soldOut = "下线成功";
        }else if(Status === articleState["onLine"]){
            putAway = "确定要上线吗";
            soldOut = "上线成功";
        }
        if(confirm(putAway)){
            $http({
                method:"PUT",
                url:'/carrots-admin-ajax/a/u/article/status',
                params:{
                    id:id,
                    status: Status
                }
            }).then(function (response) {
                if(response.data.code===0) {
                    alert(soldOut);
                    $state.go('home.page1',{},{reload:true});
                }else {
                    alert(response.data.message)
                }
            })
        }
    };
    $scope.compile=function (id) {
        $state.go('home.page2',{id:id},{reload:true});
    };


    $scope.delete=function (id) {
        if(confirm("确定删除吗")){
            $http({
                method:"DELETE",
                url:"/carrots-admin-ajax/a/u/article/"+id
            }).then(function (response) {
               if(response.data.code ===0){
                   $state.go('home.page',{},{reload:true});
                   alert("删除成功");
               }else {
                   alert(response.date.message)
               }
            });
        }
    };


    $scope.maxSize = 3 ;
    $scope.bigTotalItem = 10000;
    $scope.bigCurrentPage = ($stateParams.page) ? $stateParams.page : 1;
    $scope.size=($stateParams.size) ? $stateParams.size: 10;
    $scope.item = ($stateParams.size) ?$stateParams.size: 10;
    $scope.pageChanged =function (page) {
        $state.go("home.page1", {
            page: page,
            size: $scope.size
        },{reload:true});

    };
});

