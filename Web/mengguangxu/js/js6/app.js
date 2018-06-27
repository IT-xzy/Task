var myApp = angular.module("myApp",['ui.router','ui.bootstrap','ng.ueditor']);
myApp.config(function($stateProvider,$urlRouterProvider){

    $urlRouterProvider.when("", "/login");

    $stateProvider
        .state("login",{
            url:"/login",
            templateUrl: "html/login.html"
        })
        .state("backstage",{
            url:"/backstage",
            templateUrl: "html/backstage.html"
        })
        .state("backstage.list",{
            url:"/list?startAt&endAt&type&status&size&page&id",
            templateUrl: "html/list.html",

        })
        .state("backstage.article",{
            url:"/article?id",
            templateUrl: "html/article.html"
        })
});