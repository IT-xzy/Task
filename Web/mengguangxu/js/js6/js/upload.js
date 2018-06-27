myApp.directive("upLoad", function($http){
    return{
        restrict: 'EA',
        templateUrl: 'html/upload.html',
        replace: true,
        link: function(scope){
            scope.fileReader = new FileReader();
            scope.fileChanged = function(respond){
                scope.$apply(function(){
                    scope.files = respond.files[0];
                    scope.input = respond;
                    scope.fileName = scope.files.name;
                    scope.fileSize = scope.files.size/1024/1024;
                    scope.progress=0;
                });
            };
            // 上传图片
            scope.upload = function(){
                var formData = new FormData();
                scope.fileReader.readAsDataURL(scope.files);
                formData.append("file",scope.files);
                if(scope.fileSize <= 5242880){
                    $http({
                        method: 'post',
                        url: '/carrots-admin-ajax/a/u/img/task',
                        data: formData,
                        headers:{"Content-Type":undefined},
                        uploadEventHandlers: {
                            progress: function(respond){
                                scope.progress = (respond.loaded/respond.total)*100;
                            }
                        }
                    }).then(function successCallback(respond){
                        scope.status = respond.data.message;
                        scope.src = respond.data.data.url;
                        scope.okIcon=true;
                    });
                }else{
                    alert('文件大于5MB');
                    scope.removeIcon=true;
                }
            };

            //删除图片
            scope.delete = function(){
                scope.src = undefined;
                scope.fileName = '';
                scope.progress = 0;
                scope.input.value = '';// 防止删除一个文件后不能再次上传同一个文件的问题
                scope.okIcon=false;
            };
        }
    }
});