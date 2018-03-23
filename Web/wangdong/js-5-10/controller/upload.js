
angular.module('App')
.controller('AddCtr', function ($scope, FileUploader,$http,$state,$stateParams) {
    var uploader = $scope.uploader = new FileUploader();   //实例化一个FileUploader对象
    uploader.url = '/carrots-admin-ajax/a/u/img/task';     //以下是设置了两个必须的属性

//图片发送成功后获取图片的url
    uploader.onSuccessItem = function(data,fileItem) {
        $scope.imageSrc1 = fileItem.data.url;
    };
//这是获取id的方法
    $scope.id=$stateParams.id;
    console.log($scope.id);

// 空对象放置input框里的内容
    $scope.param={};

//新增列表
    if($scope.id==1){
        $scope.title="新增Artile";
// 立即上线
    $scope.pubArticle=function () {
        $scope.param.status= 2;
        $scope.param.img=$scope.imageSrc1;
        $scope.param.content= editor.txt.text();
        console.log($scope.param);
        $http({
            method  : 'post',
            url     : '/carrots-admin-ajax/a/u/article',
            params  :  $scope.param,
            headers : { 'Content-Type': 'application/x-www-form-urlencoded' }
        })
            .then(function(data) {
                if (data.status===200) {
                    $state.go('backstage.Article')
                } else {
                    alert( data.message);
                }
            });
    };

//存为草稿
    $scope.saveArticle=function () {
        $scope.param.status= 1;
        $scope.param.img=$scope.imageSrc1;
        console.log($scope.param);
        $http({
            method  : 'post',
            url     : '/carrots-admin-ajax/a/u/article',
            params  :  $scope.param,
            headers : { 'Content-Type': 'application/x-www-form-urlencoded' }
        })
            .then(function(data) {
                if (data.data.code===0) {
                    $state.go('backstage.Article')
                } else {
                    alert( data.message);
                }
            });

    };


//编辑列表
    }else{
        $scope.title="编辑Article";
        id=$scope.id;

        $http({
            method:'get',
            url:'/carrots-admin-ajax/a/article/'+id,
            params:$scope.param
        }).then(function(response){
            if(response.data.code===0){
                $scope.param=response.data.data.article;
                $scope.imageSrc1=$scope.param.img;
                editor.txt.html($scope.param.content);
                // $scope.param.content= editor.txt.text();
               console.log($scope.param.type)
            }

        },function(response){
            console.log(response);
        });

//立即上线
        $scope.pubArticle=function () {
            $scope.param.status= 2;
            $scope.param.img=$scope.imageSrc1;

            $http({
                method  : 'put',
                url     : '/carrots-admin-ajax/a/u/article/'+id,
                params  :  $scope.param,
                headers : { 'Content-Type': 'application/x-www-form-urlencoded' }
            })
                .then(function(data) {
                    if (data.status===200) {
                        $state.go('backstage.Article')
                    } else {
                        alert( data.message);
                    }
                });
        };

//存为草稿
        $scope.saveArticle=function () {
            $scope.param.status= 1;
            $scope.param.img=$scope.imageSrc1;

            $http({
                method  : 'put',
                url     : '/carrots-admin-ajax/a/u/article/'+id,
                params  :  $scope.param,
                headers : { 'Content-Type': 'application/x-www-form-urlencoded' }
            })
                .then(function(data) {
                    if (data.status===200) {
                        $state.go('backstage.Article')
                    } else {
                        alert( data.message);
                    }
                });
        };
    }

    $scope.cancle=function () {
        $state.go('backstage.Article')
    }
});



