var myApp = angular.module('myApp', ['ui.router', 'ngAnimate', 'ngSanitize', 'ui.bootstrap', 'angularFileUpload', 'ngMessages']);

myApp.config(function ($stateProvider, $urlRouterProvider) {
    // 需要加载的文件
    $urlRouterProvider.otherwise('main');
    $stateProvider
        .state('article', {
                url: '/articleList1',
                templateUrl: 'article.html',
                controller: 'article'
            }
        )
        .state('image',
            {
                url: '/helloa/:id',
                templateUrl: 'tasl6-image.html',
                controller: 'image'
            })
        .state('login',
            {
                url: '/login',
                templateUrl: 'login.html'
            }
        )
        .state('home',
            {
                url: '/home/:page/:startAt/:endAt/:type/:status/:size',
                templateUrl: 'article.html',
                controller: 'article'
            })
});
//数据页面
myApp.controller('article', function ($rootScope, $scope, $http, $state, $stateParams, $log, request, demoservice) {
    $scope.date = "";
    $scope.todate = "";
    $scope.goedit = function () {
        var id = this.x.id;
        $state.go("image", {
            id: id
        }, {})
    };
    $scope.upload = function () {
        var status = this.x.status;
        var id = this.x.id;
        demoservice.get(id, status);
    };
    $scope.del = function () {
        var id = this.x.id;
        demoservice.del(id);
    };
    $scope.pop = {
        popup1: {
            opened: false
        },
        popup2: {
            opened: false
        },
        open2: function () {
            $scope.pop.popup2.opened = true;
        },
        open1: function () {
            $scope.pop.popup1.opened = true;
        }
    };
    $scope.params = $stateParams;
    $log.log($scope.params);
    console.log($stateParams);
    $scope.params.size = ($stateParams.size) ? $stateParams.size : 10;
    request.articleList($scope.params).then(
        function (data) {
            $scope.list = data.data.data.articleList;
            $scope.totalItems = data.data.data.total;
            $scope.params.size = ($stateParams.size) ? $stateParams.size : 10;
            $scope.currentPage = $stateParams.page;
            $scope.type = $stateParams.type;
            $scope.status = $stateParams.status;
            if (typeof($stateParams.startAt) != "undefined") {
                $scope.date = parseInt($stateParams.startAt);
            }
            if (typeof($stateParams.endAt) != "undefined") {
                $scope.todate = parseInt($stateParams.endAt);
            }
        }
    );
    $scope.search = function () {
        var date, dateend;
        if ($scope.date) {
            date = $scope.date.valueOf();
        }
        if ($scope.todate) {
            dateend = $scope.todate.valueOf();
        }
        $state.go("home", {
            size: $scope.params.size,
            page: $scope.currentPage,
            status: $scope.status,
            type: $scope.type,
            startAt: date,
            endAt: dateend
        }, {
            reload: true
        });
    };
});
myApp.controller('image', function ($rootScope, $scope, $http, $state, $log, $stateParams, FileUploader, request) {
    if ($stateParams.id) {
        $scope.articlename = "编辑article";
        var id = $stateParams.id;
        request.articleSingle(id).then(
            function (data) {
                $log.log(data);
                $scope.params = data.data.data.article;
                var content = $scope.params.content;
                $("#content").html(content);
                $scope.params.type = $scope.params.type.toString();
                $scope.imgreview = $scope.params.img;
            }
        );
        $scope.upload = function (status) {
            $scope.params.status = status;
            console.log(typeof(status));
            $scope.params.img = $scope.imgreview;
            $scope.params.content = editor1.txt.text();
            console.log($scope.params);
            request.articleEdit(id, $scope.params).then(
                function (data) {
                    bootbox.alert("新增成功");
                    $state.go('article');
                }
            )

        };
    } else {
        $scope.articlename = "新增article";
        $scope.upload = function (status) {
            $scope.params.status = status;
            $scope.params.img = $scope.imgreview;
            $scope.params.content = editor1.txt.text();
            request.articleNewadd($scope.params).then(
                function (data) {
                    bootbox.alert("新增成功");
                    $state.go('article');
                }
            )
        };
    }
    var uploader = $scope.uploader = new FileUploader({
        url: '/carrots-admin-ajax/a/u/img/task'
    });
    uploader.onSuccessItem = function (fileItem, rsp, status, headers) {
        console.info('onSuccessItem', fileItem, rsp, status, headers);
        $scope.imgreview = rsp.data.url;
    };
});

