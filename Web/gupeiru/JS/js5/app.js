var myApp = angular.module('myApp', ["ui.router"]);
myApp.config(['$stateProvider', '$urlRouterProvider',function ($stateProvider, $urlRouterProvider) {
    // $locationProvider.hashPrefix('');
    $urlRouterProvider.otherwise("/login");
    $stateProvider
        .state("login", {
            url: "/login",
            templateUrl: "tpls/login.html",
            controller: "loginController"
        })
        .state("list", {
            url: "/list",
            templateUrl: "tpls/list.html",
            controller: "listController"
        })
        .state("list.welcome", {
            url: "/welcome",
            templateUrl: "tpls/welcome.html"
        })
        .state("list.option1",{
            url:"/option1?title&type&img&content&url&id",
            templateUrl:"tpls/option1.html",
            controller:"option1Controller"
        })
        .state("list.option2",{
            url:"/option2?page&id",
            templateUrl:"tpls/option2.html",
            controller:"option2Controller"
        })
}]);