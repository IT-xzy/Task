app.directive("upLoad",function ($http) {
    return {
        restrict: "EA",
        replace: true,
        templateUrl: "../pages/upLoad.html",
        link: function (scope,element,attr) {
            scope.isShow = false;  // 默认隐藏上传信息，当点击选择文件后显示
            scope.fileReader = new FileReader();  // 创建一个FileReader实例
            scope.fileReader.onprogress = function (ev) {  // 读取中会触发这个事件
                scope.progress = Math.round(ev.lengthComputable ? ev.loaded * 100 / ev.total : 0);  // 进度条,已读取大小除以图片大小
            }
            // 选择文件按钮
            scope.fileChanged = function (ele) {
                scope.$apply(function () {
                    scope.files = ele.files[0]; // 保存要上传的图片信息到files
                    scope.input = ele;  // 保存input:file这个DOM节点
                    scope.fileName = scope.files.name;  // 图片名字
                    scope.fileSize = scope.files.size;  // 图片大小
                    scope.isShow = true;
                })
            }
            // 上传图片
            scope.upload = function () {
                var formData = new FormData();  // 创建FormData的实例，用来存放要上传的参数
                scope.fileReader.readAsDataURL(scope.files); // FileReader的方法，把图片转成base64
                formData.append("file",scope.files); // 要上传的参数以键值对的形式存入到formData
                if (scope.fileSize <= 5242880) { // 限制上传大于5MB的文件
                    $http({
                        method: "POST",
                        url: "/carrots-admin-ajax/a/u/img/task",
                        data: formData,
                        headers: {'Content-Type': undefined},
                    }).then(function (res) {
                        if (res.data.code == 0) {
                            scope.okIcon = true;
                            scope.imageSrc = res.data.data.url;
                        } else {
                            alert("上传失败");
                        }
                    },function (reason) {
                        scope.removeIcon = true; //  上传失败显示X
                    })
                } else {
                    alert("不能上传大于5MB的文件");
                }
            }
            // 删除按钮
            scope.delete = function () {
                scope.fileReader.abort(); // 中断读取
                scope.removeIcon = false;
                scope.isShow = false;
                scope.okIcon = false;
                scope.progress = 0;
                scope.imageSrc = undefined;
                angular.element("#preview").attr("src","");  // 删除预览图
                scope.input.value = ""; // 防止删除一个文件后不能再次上传同一个文件的问题
            }
        }
    }
})