var app = angular.module('myApp', ['ui.router', 'ui.bootstrap', 'angularFileUpload']);
app.controller('myCtrl',function ($http,$scope,$stateParams,FileUploader) {
    var uploader = $scope.uploader = new FileUploader({
        url: 'http://localhost//carrots-admin-ajax/a/u/img/task'
    });
    uploader.onSuccessItem = function (fileItem, response, status, headers) {
        console.info('onSuccessItem', fileItem, response, status, headers);
        $scope.img = response.data.url
    };
    //富文本编辑器
    var E = window.wangEditor;
    var editor = new E('#editor');
    // 或者 var editor = new E( document.getElementById('editor') )
    editor.create();
    // 获取ID发送http请求
    $scope.Id=$stateParams.id;
    $http({
        method:'get',
        url:'http://localhost//carrots-admin-ajax/a/article/'+$scope.Id
    }).then(function (getData) {
        $scope.title=getData.data.data.article.title;
        $scope.type=getData.data.data.article.type;
        $scope.type= $scope.type.toString();
        $scope.createAt=getData.data.data.article.createAt;
        $scope.content=getData.data.data.article.content;
        $scope.url=getData.data.data.article.url;
        $scope.img=getData.data.data.article.img;
    });
    $scope.edit=function (status) {
        $http({
            method:'put',
            url:'http://localhost//carrots-admin-ajax/a/u/article/'+$scope.Id,
            params:{
                title:$scope.title,
                status:status,
                img:$scope.img,
                content:$scope.content,
                url:$scope.url,
                industry:$scope.industry,
                createAt:$scope.createAt,
                type:$scope.type
            }
        })
    }
});