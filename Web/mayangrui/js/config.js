var myApp = angular.module('myApp', ['ui.router','ngAnimate', 'ngSanitize', 'ui.bootstrap']);
myApp.config(function ($stateProvider, $urlRouterProvider) {
    // 需要加载的文件
    $urlRouterProvider.otherwise('login');
    $stateProvider
        .state('article',
            {
                url: '/home',
                templateUrl: 'task6main.html',
                controller: 'list'
            }
        )
        .state('image',
            {
                url: '/helloa',
                templateUrl: 'tasl6-image.html'
            })
        .state('login',
            {
                url: '/login',
                templateUrl: 'login.html'
            }
        )
        .state('home',
            {
                url: '/home?page/:startAt/:endAt/:type/:status',
                templateUrl: 'article.html',
                controller: 'list'
            })
});
myApp.controller("list", function ($scope,$http,$state,$stateParams) {
    $scope.search =function () {
        $http({
            method:'GET',
            url: "/carrots-admin-ajax/a/article/search",
            params:$scope.data
        }).then(function (data) {
            $scope.articleList = data.data.data.articleList;
        })
    };
    $scope.search();
    $scope.clear =function () {
        $http({
            method:'GET',
            url: "/carrots-admin-ajax/a/article/search"
        }).then(function (data) {
            $scope.articleList = data.data.data.articleList;
            console.log($scope.articleList);
        })
    };
    $scope.sure =function ($event) {
        $http({
            method:'GET',
            url: "/carrots-admin-ajax/a/article/search",
            params:{'page':$event.target.value}
        }).then(function (data) {
            $scope.articleList = data.data.data.articleList;
            console.log($scope.articleList);
        })
    };
});