/**
 * Created by MACHENIKE on 2017/8/10.
 */
angular.module('myApp',['angularFileUpload','ng.ueditor','ngMessages'])
    .controller('articlesController',['$scope','FileUploader','$http','$stateParams','$state','types','industries',function ($scope,FileUploader,$http,$stateParams,$state,types,industries,$rootScope) {

        var vm = this;
        vm.params = $state.params;

        $scope.urlProving = "^(http|https|ftp)\://([a-zA-Z0-9\.\-]+(\:[a-zA-Z0-9\.&%\$\-]+)*@)*((25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])|localhost|([a-zA-Z0-9\-]+\.)*[a-zA-Z0-9\-]+\.(com|edu|gov|int|mil|net|org|biz|arpa|info|name|pro|aero|coop|museum|[a-zA-Z]{2}))(\:[0-9]+)*(/($|[a-zA-Z0-9\.\,\?\#\!\'\\\+&%\$#\=~_\-]+))*$";
        vm.params.id = $stateParams.id ? $stateParams.id :'';



        $scope.industries=industries;
        $scope.types=types;

        // 上传图片
        var uploader = $scope.uploader = new FileUploader({
            url: '/carrots-admin-ajax/a/u/img/task'
        });
        //上传图片回调函数
        uploader.onSuccessItem = function(FileItem, response) {
            $scope.statusText = "上传成功";
            vm.params.img = response.data.url;
            console.log(vm.params.img);
        };
        uploader.onErrorItem = function(FileItem, response) {
            $scope.statusText = response.data.message;
        };
        $scope.clearItems = function(){
            //重新选择文件时，清空队列，达到覆盖文件的效果
            uploader.clearQueue();
            vm.params.img = undefined;
            $scope.statusText = "";
        };


        // 编辑
        if (vm.params.id !== "") {
            //查询article  ID
            $http.get('/carrots-admin-ajax/a/article/'+vm.params.id).then(function (res) {
                vm.params = res.data.data.article;
                console.log(vm.params);
                console.log(vm.params.img)
            });
            //立即上线
            vm.publishArticle = function () {
                vm.params.status = 2;
                $http({
                    method: "PUT",
                    url: "/carrots-admin-ajax/a/u/article/"+vm.params.id,
                    params: vm.params,
                    header: {"Content-Type": "application/x-www-form-urlencoded;charset=UTF-8"}
                }) .then(function(res) {
                    if(res.data.code === 0) {
                        alert("编辑成功");
                        $state.go("main.article");
                    }
                    else {
                        $rootScope.alert(res.data.message);
                    }
                });
            };
            //存入草稿
            vm.saveArticle = function () {
                vm.params.status = 1;
                $http({
                    method: "PUT",
                    url: "/carrots-admin-ajax/a/u/article/"+vm.params.id,
                    params: vm.params,
                    header: {"Content-Type": "application/x-www-form-urlencoded;charset=UTF-8"}
                }) .then(function(res) {
                    if(res.data.code === 0) {
                        alert("编辑成功");
                        $state.go("main.article");
                    }
                    else {
                        $rootScope.alert(res.data.message);
                    }
                });
            };
        }
        // 新增
        else {
            //立即上线

            vm.publishArticle = function () {
                vm.params.status = 2;
                console.log($scope.articleImg);
                console.log(vm.params.img);
                console.log(vm.params);
                $http({
                    method: "POST",
                    url: "/carrots-admin-ajax/a/u/article",
                    params: vm.params,
                    headers: {"Content-Type": "application/x-www-form-urlencoded;charset=UTF-8"}
                }) .then(function(res) {
                    if(res.data.code === 0) {
                        alert("新增成功");
                        $state.go("main.article");
                    }
                    else {
                        $rootScope.alert(res.data.message);
                    }
                });

            };
            //存入草稿
            vm.saveArticle = function () {
                vm.params.status = 1;
                $http({
                    method: "POST",
                    url: "/carrots-admin-ajax/a/u/article",
                    params: vm.params,
                    headers: {"Content-Type": "application/x-www-form-urlencoded;charset=UTF-8"}
                }) .then(function(res) {
                    if(res.data.code === 0) {
                        alert("新增成功");
                        $state.go("main.article");
                    }
                    else {
                        $rootScope.alert(res.data.message);
                    }
                });
            };
        }
    }]);