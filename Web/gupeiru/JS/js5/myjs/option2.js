myApp.controller("option2", function ($scope,$http,$state,$stateParams,$filter,types,industries) {
    $scope.types = types;
    $scope.industries = industries;
    console.log($stateParams.id);
    if ($stateParams.id) {
        console.log(($stateParams.id));
        $http({
            method: "get",
            url: '/carrots-admin-ajax/a/article/' + $stateParams.id
        }).then(function (response) {
            console.log(response);
            $scope.article = response.data.data.article;
            $scope.title = $scope.article.title;
            $scope.typeAt = $scope.article.type;
            $scope.industrieAt = $scope.article.industry;
            $scope.logoUrl = $scope.article.img;
            editor.txt.html($scope.article.content);
            $scope.url = $scope.article.url;
        })
    }
    //------------------------------------------------上线&&存为草稿----------------------------------------------------
    $scope.upLoading =function(){
        $scope.article.title = $scope.title;
        $scope.article.type = $scope.typeAt;
        $scope.article.industry = $scope.industrieAt;
        $scope.article.img = $scope.logoUrl;
        $scope.article.content = editor.txt.html() ;
        $scope.article.url =  $scope.url ;
        $scope.article.statusAt = 2;
        $scope.hint = "上线成功";
        if($scope.title&&$scope.typeAt&&$scope.logoUrl&&$scope.article.content &&$scope.url ){
            if (confirm("确定上线?")){
                if ($stateParams.id){
                    http3($stateParams.id)
                }else {
                    http2();
                }
            }
        }else {
            alert("请补全信息")
        }

    };
    $scope.downLoading=function(){
        $scope.article.title = $scope.title;
        $scope.article.type = $scope.typeAt;
        $scope.article.industry = $scope.industrieAt;
        $scope.article.img = $scope.logoUrl;
        $scope.article.content=editor.txt.html();
        $scope.article.url =  $scope.url ;
        $scope.article.statusAt = 2;
        $scope.statusAt = 1;
        $scope.hint = "储存为草稿";
        if($scope.title&&$scope.typeAt&&$scope.logoUrl&&$scope.article.content &&$scope.url ){
            if (confirm("确定上线?")){
                if ($stateParams.id){
                    http3($stateParams.id)
                }else {
                    http2();
                }
            }
        }else {
            alert("请补全信息")
        }

    };
    //-----------------------------------------------AJAX&&跳转(新增页面)----------------------------------------------------
    function http2() {
        $scope.industrieAt=($scope.typeAt===3)? $scope.industrieAt: undefined;
        $http({
            method:"POST",
            url: "/carrots-admin-ajax/a/u/article ",
            params:$scope.article
        }).then(function successCallback(response) {
            console.log(response.code);
            alert($scope.hint);
            $state.go("list.option1", {
                page:1
            }, {
                reload: true
            });
        })
    }
    //-----------------------------------------------AJAX&&跳转(编辑页面)----------------------------------------------------
    function http3(id) {
        $scope.industrieAt=($scope.typeAt===3)? $scope.industrieAt: undefined;
        $http({
            method:"PUT",
            url: "/carrots-admin-ajax/a/u/article/"+id,
            header: { "Content-Type": "application/json" },
            params: $scope.article
        }).then(function successCallback(response) {
            console.log(response);
            alert($scope.hint);
            $state.go("list.option1", {
                page:1
            }, {
                reload: true
            });
        })
    }
    //------------------------------------------------取消--------------------------------------------------------
    $scope.cancleLoading = function () {
        if (confirm("确定取消新增？")){
            $state.go("list.option1", {},
                {
                reload: true
            });
        }

    };

});

