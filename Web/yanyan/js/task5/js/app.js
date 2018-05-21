
myApp.config(function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.when("", "/aaa");

    $stateProvider
        .state("aaa", {
            url: "../html/aaa",
            templateUrl: "aaa.html"
        })
        .state("aaa.bbb", {
            url:"../html/bbb",
            templateUrl: "bbb.html"
        })

});