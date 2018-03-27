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
            element.css({'text-indent': '15px'});
            title.css('line-height', '35px');
            innerA.css('color', '#000');
            outer.click(function (event) {
                var _this = $(this);
                var _inner = _this.find('.inner').eq(0);
                var _title = _this.find('.title').eq(0);
                var _innerClass = _inner.attr('class');
                if (_innerClass.indexOf("displayStatus") < 0) {
                    //全部隐藏
                    inner.hide();
                    inner.removeClass('displayStatus');
                    title.css({
                        'background-color': 'transparent',
                        'color': '#000'
                    });
                    //自身
                    _inner.show();
                    _inner.addClass('displayStatus');
                    _title.css({
                        'background-color': 'red',
                        'color': '#fff'
                    });
                }
            });
            innerA.click(function () {
                innerA.css('color', '#000');
                $(this).css('color', 'red');
                sessionStorage.historyForMenu = JSON.stringify({
                    parent: $(this).parents('.outer').index(),
                    this: $(this).index()
                })
            })
            //加载menu点击记录
            ~function () {
                if (sessionStorage.historyForMenu) {
                    var historyForMenu = JSON.parse(sessionStorage.historyForMenu);
                } else {
                    return;
                }
                console.log('侧边栏与路由已同步');
                $('.outer').eq(historyForMenu.parent).trigger('click').find('a').eq(historyForMenu.this).trigger('click');
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
            //初始化数据
            if (ngModel) {
                ngModel.$render = function () {
                    editor.txt.html(ngModel.$viewValue || '')
                };
            } else {
                return;
            }
            //内容编辑过后同步数据
            editor.customConfig.onchange = function () {
                ngModel.$setViewValue(editor.txt.html())
            }
            editor.create();
        }
    }
}).directive('createDragScope', function () {
    return {
        restrict: "EA",
        scope: {},
        link: function (scope, element, propetry) {
            //ddsort.js 必须引入在angualr directive 启动之前
            element.DDSort({
                target: propetry.dragTarget,//通过dragTarget属性，获取什么元素是可以拖动的元素
                //常用样式配置接口，在propetry里。
                floatStyle: {
                    // 'transform':'scale(1.1)',
                    "display": "flex",
                    "justify-content": "space-between",
                    "background": propetry.background,
                    "height": propetry.height,

                }
            });
        }
    }
})