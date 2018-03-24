app.directive('treeMenu', function () {
    //侧边栏
    return {
        restrict: 'A',
        link: function (scope, element) {
            var outer = element.find('.outer');
            var title = element.find('.title');
            var inner = element.find('.inner');
            var innerA = inner.find('a');
            //style
            element.css({'text-indent': '20px', 'font-size': '17px'});
            title.css({'padding-top': '15px'})
            innerA.css({'color': '#fff', 'line-height': '40px', 'display': 'block'});
            title.addClass('POSrel');
            title.append('<span class="glyphicon glyphicon-resize-small POSabs  icon" style="right: 10%;top: 50%"></span>');
            var titleIcon = element.find('.title .icon');
            inner.hide();
            outer.click(function (event) {
                var _this = $(this);
                var _inner = _this.find('.inner').eq(0);
                var _titleIcon = _this.find('.title .icon').eq(0);//小图标
                var _innerClass = _inner.attr('class');
                if (_innerClass.indexOf("displayStatus") < 0) {
                    //全部隐藏
                    inner.hide();
                    inner.removeClass('displayStatus');
                    outer.css({
                        'background-color': 'transparent',
                        'color': '#000'
                    });
                    titleIcon.removeClass("glyphicon-resize-small glyphicon-resize-full");
                    titleIcon.addClass('glyphicon-resize-small');//默认
                    //自身
                    _inner.show();
                    _inner.addClass('displayStatus');
                    _this.css({
                        'background-color': '#dedede',
                        'color': 'red'
                    });
                    _titleIcon.removeClass('glyphicon-resize-small');
                    _titleIcon.addClass('glyphicon-resize-full');
                }
            });
            innerA.click(function () {
                innerA.css('color', '#fff');
                $(this).css('color', '#b128b8');
                sessionStorage.historyForMenu = JSON.stringify({
                    parent: $(this).parents('.outer').index(),
                    child: $(this).index()
                })
            })
            //加载menu点击记录
            ~function () {
                if (sessionStorage.historyForMenu) {
                    var historyForMenu = JSON.parse(sessionStorage.historyForMenu);
                } else {
                    return;
                }
                console.log('%c侧边栏与路由已同步', 'color:red');
                $('.outer').eq(historyForMenu.parent).trigger('click').find('a').eq(historyForMenu.child).css('color', '#b128b8');
            }();
        }
    }
}).directive('numberWidthAuto', function () {
    return {
        restrict: 'A',
        link: function (scope, element, property) {
            var self = element[0];
            self.oninput = function () {
                self.style.width = self.value.length * 7 + 20 + 'px';
            }
        }
    }
}).directive('editorTool', function () {
    return {
        restrict: "EA",
        require: '?ngModel',
        link: function (scope, element, propetry, ngModel) {
            var self = element[0];
            var editor = new window.wangEditor(self);
            //配置菜单
            editor.customConfig.menus = [
                // 'head', // 标题
                // 'bold', // 粗体
                // 'italic', // 斜体
                // 'underline', // 下划线
                'foreColor', // 文字颜色
                'backColor', // 背景颜色
                // 'link', // 插入链接
                // 'list', // 列表
                // 'justify', // 对齐方式
                'image', // 插入图片
                'table', // 表格
                'video', // 插入视频
                'code', // 插入代码
            ];
            editor.customConfig.zIndex = 0;
            //设置默认数据
            if (ngModel) {
                //覆盖默认 $render方法,因为这个方法是 以modelValue值更新,viewValue,所以需要自定义.
                ngModel.$render = function () {
                    //取ng-model的数据
                    editor.txt.html(ngModel.$viewValue || '')
                };
            } else {
                return;
            }
            //内容变化回调函数
            editor.customConfig.onchange = function () {
                //angular 更新视图值
                ngModel.$setViewValue(editor.txt.html())
            }
            //创建富文本
            editor.create();
            //设置一个默认200的高度，
            element.find('.w-e-text-container').css('height', '200px');
        }
    }
}).directive('hjLoad', function () {
    //load事件 指令，只能接受函数
    return {
        restrict: 'A',
        scope: {
            loadedCallback: "&hjLoad"
        },
        link: function (scope, element, property) {
            // element.load()，jQuery的方式无效
            element[0].onload = function () {
                //脏检查
                scope.$apply(function () {
                    scope.loadedCallback();
                })
            };
        }
    }
}).directive('imgFileUpload', function ($httpTools, ajaxAds, $interval) {
    //只需要指定上传完成后 输出的 img url ngModel
    return {
        restrict: 'E',
        scope: {
            imgSrc: '=imgSrc',
            //提供输出一个状态，是不是正则上传中
            isLoading: '=isLoading',
        },
        templateUrl: "./views/imgFileUploadTemplate.html",
        link: function (scope, element, property) {
            scope.img = scope.imgSrc;
            var cancel$Watch = scope.$watch('imgSrc', function (New) {
                if (New) {
                    scope.img = New;
                    cancel$Watch();
                }
            })
            scope.files = [];
            scope.panel = {
                infoPanel: false,
                status: '未上传',
                uploadBtn: false,
                cancelBtn: true,
            };
            scope.progress = {
                timer: undefined,
                max: 0,
                value: 0,
                animate: function () {
                    var i = 0;
                    var total = Math.ceil(scope.files[0].size / 1000);
                    scope.progress.max = total;
                    scope.progress.timer = $interval(function () {
                        if (!scope.isLoading) {
                            var a = $interval.cancel(scope.progress.timer);
                            return;
                        }
                        scope.progress.value = i;
                        i = i + 0.56;
                    }, 1)
                }
            };
            scope.setFiles = function (event) {
                var files = [].slice.apply(event.target.files);
                scope.progress.value = 0;
                if (scope.cancelUpload) {
                    scope.cancelUpload();
                }
                scope.panel.status = '未上传';
                //生成 本地img url
                var fileReader = new FileReader();
                fileReader.readAsDataURL(files[0]);
                fileReader.onload = function () {
                    //本地解析url，完成 把文件数组、文件src传出去
                    scope.img = fileReader.result;
                    scope.files = files;
                    scope.panel.infoPanel = true;
                    scope.$apply();
                }
            }

            scope.startUpload = function () {
                var file = this.files[0];
                if (file.size / 1024 / 1024 > 1) {
                    alert('文件太大了1');
                    return;
                }
                //按钮、进度条什么的 状态
                scope.panel.status = '正在上传';
                scope.panel.uploadBtn = true;
                scope.panel.cancelBtn = false;
                scope.isLoading = true;
                scope.progress.animate();
                //发送请求
                var promise = $httpTools.uploadImg(ajaxAds.article.imgUpload, file);
                //开始没有定义取消方法，，因为去的$http 的返回结果之后 才可以
                scope.cancelUpload = function () {
                    promise.abort();
                    //按钮、进度条什么的
                    scope.progress.value = 0;
                    scope.panel.uploadBtn = false;
                    scope.panel.cancelBtn = true;
                    scope.isLoading = false;

                }
                promise.then(function (res) {
                    scope.imgSrc = res.data.data.url;
                    //按钮、进度条什么的 状态
                    scope.progress.value = scope.progress.max;
                    scope.panel.status = '上传成功';
                    scope.panel.uploadBtn = false;
                    scope.panel.cancelBtn = true;
                    scope.isLoading = false;
                }, function () {
                    //如果不是，终止了$http 请求。
                })
            };
            scope.cancelUpload = undefined;
        }
    }
})

