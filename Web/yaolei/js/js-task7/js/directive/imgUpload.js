angular.module('imgUploadDirective', [])
    .directive('imgUpload', ['$http', '$interval', '$q', function ($http, $interval, $q) {
        //只允许上传一张图片
        return {
            templateUrl: 'js/directive/fileUploadForMissionManage.html',
            restrict: 'EA',
            scope: {
                //最终输出的src
                exportSrc: '=imgSrc',
                ajaxAds: '=ajaxAds',
                //上传文件的时候，输出一个状态 loading ，比如想实现图片上传时不能进行保存操作，可以通过它在外部禁用保存按钮，
            },
            link: function (scope, element, property) {
                //是否在上传阶段，
                scope.isLoading = false;
                scope.loadInfo = undefined;

                //制造一个错误
                function makeError(info) {
                    throw new Error(info)
                }
                //选择文件按钮,因为ng-change无效
                var $changeFileBtn = element.find('.upBtn input[type=file]').eq(0);
                //文件~
                scope.file = '';
                //img src ,因为双向绑定,所以间接更改

                    scope.src = scope.exportSrc;


                ~function () {
                    var cancel = scope.$watch('exportSrc', function (newV) {
                        if (newV) {
                            scope.src = newV;
                            cancel();
                        }
                    })

                }();
                /*  btnTitle,按钮文字,不需要绑定策略*/
                property.btnTitle && (scope.btnTitle = property.btnTitle);
                //本地读取file
                var readFile = new FileReader();
                //选择文件后，调用
                $changeFileBtn.change(function () {
                    //非jQuery
                        scope.file = this.files[0];
                        scope.progress.value = 0;
                        scope.loadInfo = '未上传';
                        readFile.readAsDataURL(scope.file);
                        readFile.onload = function () {
                            scope.src = readFile.result;
                            //这里不触发 脏检查,我想让他和文件信息一起出来
                            scope.$apply();
                        }
                });
                //进度条方法
                scope.progress = {
                    timer: undefined,
                    max: 0,
                    value: 0,
                    animate: function () {
                        var i = 0;
                        var total = Math.ceil(scope.file.size / 1000);
                        scope.progress.max = total;
                        scope.progress.timer = $interval(function () {
                            scope.progress.value = i;
                            i = i + 0.51;
                        }, 1)
                    }
                };
                scope.ways = {
                    upFile: function () {
                        //判断文件大小
                        if (scope.file.size > 1024 * 1024) {
                            alert('文件太大了，重新选一个吧!');
                            return;
                        }
                        //然后加载。。。。进度条
                        scope.progress.animate();
                        //更新状态
                        scope.isLoading = true;
                        scope.loadInfo = '正在上传';
                        //发送请求
                        var ajaxPromise = this.ajaxFn();
                        //默认不设置取消按钮的方法，只有发送了一个请求之后
                        this.cancelUp = function () {
                            ajaxPromise.abort();
                        };
                        //处理promise
                        ajaxPromise.then(function (res) {
                            console.log(res.data.data);
                            if (res.data.code === 0) {
                                scope.progress.value = scope.progress.max;
                                $interval.cancel(scope.progress.timer);
                                scope.exportSrc = res.data.data.url;
                                scope.isLoading = false;
                                scope.loadInfo = '上传成功';
                            }
                        }, function (res) {
                            $interval.cancel(scope.progress.timer);
                            scope.progress.value = 0;
                            scope.isLoading = false;
                            //使用$q.defer()中止$http请求  会算ajax请求失败 ，所以需要判断 xhrStatus
                            if (res.xhrStatus === 'abort') {
                                alert('文件:' + scope.file.name + '\n已取消上传');
                                scope.loadInfo = '取消上传';
                            } else {
                                scope.loadInfo = '上传失败';
                                alert(res.data);
                            }
                        })
                    },
                    cancelUp: undefined,
                    ajaxFn: function () {
                        var defer = $q.defer();
                        var data = new FormData();
                        data.append('file', scope.file);
                        var ajaxPromise = $http({
                            method: 'post',
                            url: scope.ajaxAds || makeError('ajaxAds is Falsy'),
                            // transformRequest: function (a) {return a;},
                            headers: {
                                'content-type': undefined
                            },
                            data: data,
                            //唯一终止 $http请求的办法
                            timeout: defer.promise
                        });
                        //原生JavaScript ajax有个 abort方法,这里添加上
                        ajaxPromise.abort = function () {
                            defer.resolve();
                        }
                        return ajaxPromise;
                    },
                }

            }
        }

    }])