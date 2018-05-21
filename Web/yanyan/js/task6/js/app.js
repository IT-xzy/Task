var myApp = angular.module("myApp", ["ui.router"]);

myApp.config(function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.when("", "/PageTab");

    $stateProvider
        .state("login", {
            url: "/login",
            templateUrl: " html/login.html"
        })
        .state("PageTab", {
            url: "/PageTab",
            templateUrl: " html/PageTab.html"
        })
        .state("PageTab.bbb", {
            url:"/bbb",
            templateUrl: "html/bbb.html"
        })
    // .state("PageTab.Page2", {
    //     url:"/Page2",
    //     templateUrl: "Page2.html"
    // })
    // .state("PageTab.Page3", {
    //     url:"/Page3",
    //     templateUrl: "Page3.html"
    // });
});
