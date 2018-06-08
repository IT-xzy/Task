var app = angular.module('myApp', ['ui.router', 'ui.bootstrap', 'ng.ueditor']);
app.config(function ($urlRouterProvider, $stateProvider) {
    $urlRouterProvider.when('', '/login');
    $stateProvider
        .state('login', {
            // 当angularjs发现浏览器地址栏里面的地址是login，那么它就会去调用login.html这个模版
            url: '/login',
            templateUrl: 'login.html'
        })
        .state('home', {
            url: '/home',
            templateUrl: 'home.html'
        })
        .state('home.list', {
            url: "/list?title&author&type&status&page&size&startAt&endAt&total&id",
            templateUrl: 'list.html'
        })
        .state('home.detail', {
            url: '/detail/?id',
            templateUrl: 'detail.html'
        })
});