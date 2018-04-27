angular.module("myApp")
    .controller("detailCtrl",function ($scope, $http, $stateParams, $state, types, industry) {
    $scope.types = types; // 从constant中取出数据保存到变量
    $scope.industry = industry;
    //编辑页面
    if ($stateParams.id) {
        $http({
            method: "GET",
            url: "/carrots-admin-ajax/a/article/" + $stateParams.id,
        }).then(function (res) {
            console.log(res);
            $scope.title = res.data.data.article.title;
            $scope.typeNum = res.data.data.article.type;
            $scope.industryNum = res.data.data.article.industry;
            $scope.content = res.data.data.article.content;
            $scope.url = res.data.data.article.url;
            $scope.imageSrc = res.data.data.article.img;
            $scope.createAt = res.data.data.article.createAt;
        }, function (res) {
            alert(res.data.message);
        });
    }

    // 立即上线
    $scope.upLine = function () {
        console.log("上线");
        console.log($scope.industryNum);
        if ($stateParams.id) { // 当前为编辑状态
            $http({
                method: "PUT",
                url: "/carrots-admin-ajax/a/u/article/" + $stateParams.id,
                params: {
                    title: $scope.title,
                    type: $scope.typeNum,
                    industry: $scope.industryNum,
                    status: 2, // 上线
                    img: $scope.imageSrc,
                    content: $scope.content,
                    url: $scope.url,
                    createAt: $scope.createAt,  // 必须添加这个参数不然修改的数据不会成功
                }
            }).then(function (res) {
                if (res.data.code ==0) {
                    alert("上传成功");
                    $state.go("home.article_list", {
                        reload: true
                    })
                }
            },function(){
                alert("上线失败")
            })
        } else {
            $http({  // 当前为新增状态
                method: "POST",
                url: "/carrots-admin-ajax/a/u/article",
                params: {
                    title: $scope.title,
                    type: $scope.typeNum,
                    status: 2,
                    industry: $scope.industryNum,
                    img: $scope.imageSrc,
                    content: $scope.content,
                    url: $scope.url
                }
            }).then(function (res) {
                if (res.data.code ==0) {
                    alert("上传成功");
                    $state.go("home.article_list", {
                        reload: true
                    })
                }
            },function(){
                alert("上线失败")
            })
        }
    }
    // 存为草稿
    $scope.save = function () {
        if ($stateParams.id) {  // 当前为编辑状态
            $http({
                method: "PUT",
                url: "/carrots-admin-ajax/a/u/article/" + $stateParams.id,
                params: {
                    title: $scope.title,
                    type: $scope.typeNum,
                    industry: $scope.industryNum,
                    status: 1,
                    img: $scope.imageSrc,
                    content: $scope.content,
                    url: $scope.url,
                    createAt: $scope.createAt,  // 必须添加这个参数不然修改的数据不会成功
                }
            }).then(function (res) {
                if (res.data.code ==0) {
                    alert("存为草稿成功");
                    $state.go("home.article_list", {
                        reload: true
                    })
                }
            },function(){
                alert("存为草稿失败")
            })
        } else {
            $http({  // 当前为新增状态
                method: "POST",
                url: "/carrots-admin-ajax/a/u/article",
                params: {
                    title: $scope.title,
                    type: $scope.typeNum,
                    status: 1,
                    industry: $scope.industryNum,
                    img: $scope.imageSrc,
                    content: $scope.content,
                    url: $scope.url
                }
            }).then(function (res) {
                if (res.data.code ==0) {
                    alert("存为草稿成功");
                    $state.go("home.article_list", {
                        reload: true
                    })
                }
            },function(){
                alert("存为草稿失败")
            })
        }
    }
})
