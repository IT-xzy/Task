app.directive('myPic', function ($http) {
    return{
        restrict: 'EA',
        templateUrl: 'picture.html',
        replace: true,
        link: function (scope) {
            // 获得图片的描述信息
            scope.getValue = function (ele) {
                scope.$apply(function () {
                    // 将取得的图片描述信息赋值给files
                    scope.files = ele.files[0];

                    // 图片名称
                    scope.theName = (ele.files[0].name);

                    // 图片原始大小，单位是B
                    scope.theOldSize = (ele.files[0].size);

                    // 图片展示大小，单位是MB，保留小数点后两位
                    scope.theSize = ((scope.theOldSize/1024/1024).toFixed(2) + 'MB');

                    // 将ng-show的条件设置为true可以使得列表行出现
                    scope.detailDataShow = true;
                });


                // 上传按钮
                scope.detailUpDown = function () {
                    // 创建一个FileReader实例
                    scope.fileReader = new FileReader();

                    // 将要上传的参数以键值对的形式存入formData
                    // 将要上传的参数以键值对的形式存入formData
                    var formData = new FormData();
                    formData.append('file', scope.files);

                    // 判断选择的图片大小是否小于5M
                    if (scope.theOldSize < 5242880){
                        $http({
                            method: 'POST',
                            url: '/carrots-admin-ajax/a/u/img/task',
                            data: formData,
                            headers: {
                                // 一个不知道为啥要设置undefined才有效的设置
                                'Content-Type': undefined
                            },
                        }).then(function (response) {
                            if (response.data.code == 0){
                                // 进度条样式转换
                                scope.detailOldProgress = true;
                                scope.detailNewProgress = true;

                                // 进度条的进度
                                scope.val = 100;

                                // 图片上传成功显示成功
                                scope.detailTips = true;

                                // 将上传按钮禁用
                                scope.detailUp = true;

                                // 将url赋值给预览图的src
                                scope.detailImgUrl = response.data.data.url;
                            }else {
                                alert('上传失败')
                            }
                        });
                    }else {
                        alert('请上传小于5MB的文件');
                    }

                    // 将小图预览框隐藏
                    scope.detailSmallPic = true;

                    // 将大图预览框显示
                    scope.detailBigPic = true;
                };


                // 删除按钮
                scope.detailDelete = function () {
                    // 中断读取
                    scope.fileReader.abort();

                    // 删除预览图
                    scope.detailImgUrl = '';

                    // 防止删除一个文件后不能再次上传同一个文件的问题,同时重置上传按钮
                    $('#detailFile').val('');
                    scope.detailUp = false;

                    // 图片上传成功显示成功
                    scope.detailTips = false;

                    // 将ng-show的条件设置为false可以使得列表行隐藏
                    scope.detailDataShow = false;

                    // 将小图预览框显示
                    scope.detailSmallPic = false;

                    // 将大图预览框隐藏
                    scope.detailBigPic = false;

                    // 进度条样式转换
                    scope.detailOldProgress = false;
                    scope.detailNewProgress = false;
                };
            };
        }
    }
});