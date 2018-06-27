angular.module('myApp')
    .controller('articleList', function ($scope, $http) {

        //搜索
        $scope.search = function () {
            $http({
                method: 'GET',
                url: '/carrots-admin-ajax/a/article/search',
                params: {
                    type: $scope.type,
                    status: $scope.status
                }
            }).then(function (res) {
                console.log(res);
                $scope.data = res.data.data.articleList;

            })
        };


        //清空
        $scope.clear = function () {
            $http({
                method: 'GET',
                url: '/carrots-admin-ajax/a/article/search',
                params: {
                    type: '',
                    status: ''
                }
            }).then(function (res) {
                console.log(res);
                $scope.data = res.data.data.articleList;
            })
        };

        //页面加载渲染
        $scope.clear();

        //弹窗下架
        $scope.under = function () {
            bootbox.alert({

                title: "你确定要下架吗?",
                buttons: {
                    ok: {
                        label: '确认',
                        className: ''
                    }
                },
                message: '下线后该图片将不展示站轮播banner中。\n' +
                '\n' +
                '是否执行下线操作？',
                callback: function () {
                    bootbox.alert('关闭');
                }
            })
        };

        //弹窗删除
        $scope.cut = function () {
            bootbox.alert({

                title: '',
                buttons: {
                    ok: {
                        label: '确认',
                        className: ''
                    }
                },
                message: '是否确认要删除？',
                callback: function () {
                    bootbox.alert('关闭');
                }
            })
        }


    });

angular.module('myApp')
    .controller('PagCtrl', function ($scope) {
    $scope.maxSize = 5;
    $scope.totalItems = 175;
    $scope.currentPage = 1;
});






