myApp.controller("page",function ($scope,$http,$state,$stateParams,FileUploader,type,industries,articleState){
    $scope.type = types;
    $scope.industries =industries;


    if ($stateParams.id){
        $http({
            method: "GET",
            url: "/carrost-admin-ajax/a/article"+$stateParams.id
        }).then(function (response){
            if (response.data.code ===0){
                $scope.article =response.data.data.article;
                $scope.article.industry = String($scope.article.industry);
                $scope.CompleteModel.text = $scope.article.content;
                $scope.responseUrl = $scope.article.img;

            }else {
                alert(response.data.message)
            }
        });
    }

    $scope.immediately = function (status) {
        $scope.article.industry = ($scope.article.type ===3) ? $scope.article.industry:"";
        $scope.article.content= $scope.CompleteModel.text;
        $scope.article.img=$scope.responseUrl;
        $scope.article.status =status;
        if ($stateParams.id){
            $http({
                method: "PUT",
                url :  "/carrots-admin-ajax/a/u/article/" +$stateParams.id,
                params:$scope.article,
                header:{"Content-Type": "application/x-www-form-urlencoded"}
            }).then(function (response) {
                if (response.data.code===0){
                    if(status === articleState["online"]){
                        alert("编辑成功，已成功上下")
                    }else {
                        alert("编辑成功，已存为草稿")
                    }
                    $scope.go("home.page1",{},{reload:true});
                }else {
                    alert(response.data.message);
                }
            });
        }else {
            $http({
                method:"POST",
                url:"/carrots-admin-ajax/a/u/article",
                params : $scope.article,
                header : {"Content-Type": "application/x-www-form-urlencoded"}
            }).then(function (response) {
                if (response.data.code === 0){
                    if(status === articleState["online"]){
                        alert("上线成功");
                    }else {
                        alert("已存为草稿")
                    }
                    $state.go("home,pame1",{},{reload:true});
                }else {
                    alert(response.data.message);
                }
            });
        }
    };
    $scope.canceled = function () {
        $state.go("home.page1",{},{reload:true});
    };


    var uploader = $scope.uploader = new FileUploader ({
        method:"POST",
        url :'/carrots-admin-ajax/a/u/img/task',
        queueLimit: 1
    }) ;

    $scope.cleaerItems =function () {
        uploader.claerQueue();
    };

    uploader.onSuccessItem = function (fileItem,response) {
        $scope.responseUrl = response.data.url;
    };
    $scope.responseResponseUrl = function () {
        $scope.responseUrl = null;
    };
    $scope.config ={};
    $scope.CopleteModel={
        text: ''
    };
    $scope.condition = true;

    if( $stateParams.id){
        $scope.newArticle = "编辑article"
    } else {
        $scope.newArticle = "新增article"
    }


});