angular.module('myApp', ['angularFileUpload', 'meta.umeditor', 'ngMessages'])
    .controller('addArticleController', ['$scope', '$state', '$http', 'type', 'industry', 'FileUploader',
        function ($scope, $state, $http, type, industry, FileUploader) {

            //this指向当前作用域
            var vm = this;
            vm.params = $state.params;

           //常量对象赋值
            $scope.industry = industry;
            $scope.type = type;


            //url正则判断
            $scope.urlProving = "^(http|https|ftp)\://([a-zA-Z0-9\.\-]+(\:[a-zA-Z0-9\.&%\$\-]+)*@)*" +
                "((25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\." +
                "(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\." +
                "(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\." +
                "(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])|localhost|([a-zA-Z0-9\-]+\.)*[a-zA-Z0-9\-]+\." +
                "(com|edu|gov|int|mil|net|org|biz|arpa|info|name|pro|aero|coop|museum|[a-zA-Z]{2}))(\:[0-9]+)*(/($|[a-zA-Z0-9\.\,\?\'\\\+&%\$#\=~_\-]+))*$";

            //编辑或新增后清空行业数据
            function emptyIndustry() {
                if (vm.params.type !==3){
                    vm.params.industry = "";
                }else {}
            }

            // 编辑
            if (vm.params.id ) {
                //查询article  ID
                console.log(vm.params.id);
                $http({
                    method: "GET",
                    url: '/carrots-admin-ajax/a/article/' + vm.params.id
                })
                    .then(function (res) {
                        vm.params = res.data.data.article;
                    });

                vm.online = function (nowStatus) {
                    //根据参数赋值上线或草稿
                    vm.params.status = nowStatus;
                    $scope.editConfirm = confirm("确认编辑？");
                    if ($scope.editConfirm === true) {
                        $http({
                            method: "PUT",
                            url: '/carrots-admin-ajax/a/u/article/' + vm.params.id,
                            params: vm.params,
                            header: {"Content-Type": "application/x-www-form-urlencoded;charset=UTF-8"}
                        }).then(function (res) {
                            if (res.data.code === 0 || res.data.code === 200) {
                                emptyIndustry();
                                alert("编辑成功");
                                $state.go("backStage.article");
                            }

                        });
                    }
                };
            }
            // 新增
            else {
                vm.online = function (nowStatus) {
                    console.log(vm.params.status);
                    //根据参数赋值上线或草稿
                    vm.params.status = nowStatus;
                    $scope.addConfirm = confirm("确认新增？");
                    if ($scope.addConfirm === true) {
                        $http({
                            method: "POST",
                            url: "/carrots-admin-ajax/a/u/article",
                            params: vm.params,
                            headers: {"Content-Type": "application/x-www-form-urlencoded;charset=UTF-8"}
                        }).then(function (res) {
                            if (res.data.code === 0 || res.data.code === 200) {
                                emptyIndustry();
                                alert("新增成功");
                                $state.go("backStage.article");
                            }

                        });
                    }
                };
            }


            // 上传图片
            var uploader = $scope.uploader = new FileUploader({
                url: '/carrots-admin-ajax/a/u/img/task'
            });

            uploader.onSuccessItem = function (FileItem, response) {
                $scope.statusText = "上传成功";
                vm.params.img = response.data.url;
                console.log(vm.params.img);
            };
            uploader.onErrorItem = function (FileItem, response) {
                $scope.statusText = response.data.message;
            };
            $scope.clearItems = function () {
                //清空图片
                uploader.clearQueue();
                vm.params.img = undefined;
                $scope.statusText = "";
            };

            //取消
                vm.canCell = function () {
                $scope.cancellConfirm = confirm("确认取消？");
                if ($scope.cancellConfirm === true) {
                    $state.go("backStage.article");
                }
            }



            //
            // $scope.uploadFiles = function (files, errFiles) {
            //     $scope.files = files;
            //     $scope.errFiles = errFiles;
            //     angular.forEach(files, function (file) {
            //         file.upload = Upload.upload({
            //             url: "/carrots-admin-ajax/a/u/img/task",
            //             params: {file: file}
            //         });
            //
            //         file.upload.then(function (response) {
            //             $timeout(function () {
            //                 file.result = response.params;
            //             });
            //         }, function (response) {
            //             if (response.status > 0)
            //                 $scope.errorMsg = response.status + ': ' + response.params;
            //         }, function (evt) {
            //             file.progress = Math.min(100, parseInt(100.0 *
            //                 evt.loaded / evt.total));
            //         });
            //     });
            // }

            // $scope.uploadImg = '';
            // //提交
            // $scope.submit = function () {
            //     $scope.upload($scope.file);
            // };
            // $scope.upload = function (file) {
            //     $scope.fileInfo = file;
            //     Upload.upload({
            //         //服务端接收
            //         url: 'Ashx/UploadFile.ashx',
            //         //上传的同时带的参数
            //         params: {'username': $scope.username},
            //         //上传的文件
            //         file: file
            //     }).progress(function (evt) {
            //         //进度条
            //         var progressPercentage = parseInt(100.0 * evt.loaded / evt.total);
            //         console.log('progess:' + progressPercentage + '%' + evt.config.file.name);
            //     }).success(function (data, status, headers, config) {
            //         //上传成功
            //         console.log('file ' + config.file.name + 'uploaded. Response: ' + data);
            //         $scope.uploadImg = data;
            //     }).error(function (data, status, headers, config) {
            //         //上传失败
            //         console.log('error status: ' + status);
            //     });
            // };


        }]);

