'use strict'

//创建一个app，注入模块+++
var app = angular.module('myApp', ['ui.router', 'ui.bootstrap', 'ngAnimate']);
//路由跳转+++
app.config(["$stateProvider", "$urlRouterProvider", function($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.when('', 'login');
    $urlRouterProvider.when('/', '/login');

    $stateProvider
    .state("login", {//登陆页+++
        url: '/login',
        templateUrl: 'views/login.html'
    })
    .state("backstage", {//后台页+++
        url: '/backstage',
        templateUrl: 'views/backstage.html'
    })
    .state("backstage.list", {//Article列表页+++
        url: '/article/list',
        templateUrl: 'views/article-list.html'
    })
}]);