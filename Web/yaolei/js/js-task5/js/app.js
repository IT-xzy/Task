var myApp = angular.module("myApp",['ui.router']);
myApp.config(function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.when("", "login");

    $stateProvider
        .state("login",{
            url:"/login",
            templateUrl: "js5.html"
        })
        .state("js6-1", {
            url:"/js6-1",
            templateUrl: "houtai.html"
        })
        .state("js6-1.js6-2", {
            url:"/js6-2",
            templateUrl: "js6-2.html"
        })
        .state("js6-1.js6-2.js6-3", {
            url:"/js6-3",
            templateUrl: "js6-3.html"
        });
});

