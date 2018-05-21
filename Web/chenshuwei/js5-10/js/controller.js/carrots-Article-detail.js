angular.module("myApp")
    .controller('ArticleListDetail', ['$scope', 'type', 'industry', '$state', '$http', '$stateParams',
        function ($scope, type, industry, $state, $http, $stateParams) {
            //创建编辑器对象
            var E = window.wangEditor;
            var editor = new E('#editor');
            editor.customConfig.zIndex = 0;
            editor.create();
            $scope.screenWidth = window.innerWidth;

            //把常量type和industry的值赋给下拉菜单
            $scope.type = type;
            $scope.industry = industry;

            //点击取消跳转到列表页
            $scope.cancel = function () {
                $state.go('carrots.Artical-list', {
                    //列表页有两个参数，必须传个初始值过去
                    page: 1,
                    size: 10
                }, {relode: true})
            };
            //判断是从哪里点击进来的，如果参数是add则是新增页面，如果参数是其他则是编辑页面，参数在html页传递
            if ($stateParams.id === 'add') {
                //点击上线按钮获取所有输入框数据，发送给接口
                $scope.pageTitle = '新增Article'
                $scope.upLoadItem = function (statu) {
                    //通过参数判断是点击了哪个按钮，从而决定是状态是上线还是草稿
                    if (statu === 'down') {
                        $scope.statu = 1
                    }
                    else if (statu === 'up') {
                        $scope.statu = 2
                    }
                    $scope.data = {
                        title: $scope.title,
                        type: $scope.selectType,
                        status: $scope.statu,
                        img: $scope.imgSrc,
                        content: editor.txt.html(),
                        industry: $scope.selectIndustry,
                        url: $scope.jumpLink
                    };
                    bootbox.confirm({
                        size: 'small',
                        title: '提示',
                        message: (statu === 'up') ? '是否执行上线操作？' : '是否存为草稿？',
                        callback: function (result) {
                            if (result === true) {
                                $http({
                                    method: 'POST',
                                    url: '/carrots-admin-ajax/a/u/article',
                                    params: $scope.data,
                                    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                                }).then(function (response) {
                                    if (response.data.code === 0) {
                                        if (statu === 'up') {
                                            bootbox.alert("上线成功");
                                        } else {
                                            bootbox.alert("已存为草稿");
                                        }
                                    }
                                    $state.go('carrots.Artical-list', {
                                        page: 1,
                                        size: 10
                                    }, {reload: true})
                                }).catch(function (response) {
                                    bootbox.alert('请求失败,错误代码为：' + response.statu)
                                })
                            }
                        }
                    })
                }
            }
            else {
                $scope.pageTitle = '编辑Article'
                $scope.Article = null;
                $http({
                    method: 'GET',
                    url: '/carrots-admin-ajax/a/article/' + $stateParams.id,
                }).then(function (response) {
                    $scope.Article = response.data.data.article;
                    $scope.selectType = $scope.Article.type;
                    $scope.title = $scope.Article.title;
                    $scope.jumpLink = $scope.Article.url;
                    $scope.imgSrc = $scope.Article.img;
                    editor.txt.html($scope.Article.content);
                    $scope.selectIndustry = $scope.Article.industry;
                    $scope.id = $scope.Article.id;
                });
                $scope.upLoadItem = function (statu) {
                    //通过参数判断是点击了哪个按钮，从而决定是状态是上线还是草稿
                    if (statu === 'down') {
                        $scope.statu = 1
                    }
                    else if (statu === 'up') {
                        $scope.statu = 2
                    }
                    $scope.data = {
                        title: $scope.title,
                        type: $scope.selectType,
                        status: $scope.statu,
                        img: $scope.imgSrc,
                        content: editor.txt.html(),
                        industry: $scope.selectIndustry,
                        url: $scope.jumpLink,
                        createAt: $scope.Article.createAt,
                    };
                    bootbox.confirm({
                        size: 'small',
                        title: '提示',
                        message: (statu === 'up') ? '是否执行上线操作？' : '是否存为草稿？',
                        callback: function (result) {
                            if (result === true) {
                                $http({
                                    method: 'PUT',
                                    url: '/carrots-admin-ajax/a/u/article/' + $stateParams.id,
                                    params: $scope.data,

                                }).then(function (response) {
                                    if (response.data.code === 0) {
                                        if (statu === 'up') {
                                            bootbox.alert("上线成功");
                                        } else {
                                            bootbox.alert("已存为草稿");
                                        }
                                    }
                                    $state.go('carrots.Artical-list', {
                                        page: 1,
                                        size: 10
                                    }, {reload: true})
                                }).catch(function (response) {
                                    bootbox.alert('请求失败,错误代码为：' + response.statu)
                                })
                            }
                        }
                    })
                }
            }
        }]);
