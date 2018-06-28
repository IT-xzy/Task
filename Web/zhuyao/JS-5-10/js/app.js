var app = angular.module('myApp', ['ui.router', 'ngMessages', 'ngAnimate', 'ngSanitize', 'ui.bootstrap', 'ngFileUpload', 'textAngular']);
app.controller('AccordionDemoCtrl', function ($scope) {
    $scope.oneAtATime = true;
    if(sessionStorage.getItem("a")){
        $scope.b = '1';
    }
    $scope.changeOpen = function () {
        sessionStorage.setItem('a', '1')
    }
});
//路由配置
app.config(function ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.when("", "/login");
    $stateProvider
        .state("login", {
            url: "/login",
            templateUrl: "login.html"
        })
        .state("backstage", {
            url: "/backstage",
            templateUrl: 'backstage.html'
        })
        .state("backstage.article", {
            url: "/article?page$size$type$status$startAt$endAt",
            templateUrl: "article.html"
        })
        .state("backstage.articleDetails", {
            url: "/articleDetails?id",
            templateUrl: "articleDetails.html"
        });
});




