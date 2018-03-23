//创建一个app，注入ui-router模块
var app = angular.module('myApp', ['ui.router'])
app.config(["$stateProvider", function($stateProvider) {
    $stateProvider
    .state("list", {
        url: '/list',
        templateUrl: './article-list.html'
    })
    .state("detail", {
        url: '/detail',
        templateUrl: './article-detail.html'
    })
}]);