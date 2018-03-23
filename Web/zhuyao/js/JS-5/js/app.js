// var myApp = angular.module("myApp", ['ui.router']);
// myApp.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
//     $urlRouterProvider.when("","/task6");
//     $stateProvider
//         .state("task6",{
//             url:"/task6",
//             templateUrl:"task6.html"
//         })
//         .state("task6.backstage",{
//             url:"/backstage",
//             templateUrl:"backstage.html"
//         })
//         .state("task6.article",{
//             url:"/article",
//             templateUrl:"article.html"
//         })
//         .state("task6.article-cont",{
//             url:"/article-cont",
//             templateUrl:"article-cont.html"
//         });
// }]);

//声明AngularJS模块，并把ui-router传入AngularJS主模块
var app = angular.module('myApp', ['ui.router']);

app.config(function($stateProvider, $urlRouterProvider){
    $urlRouterProvider.otherwise('/');
    $stateProvider
        .state('backstage',{
            url: '/',
            views: {
                "top": {
                    templateUrl: "backstage.html"
                }
                // "center": {
                //     templateUrl: "article.html"
                // },
                // "footer": {
                //     templateUrl: "article-cont.html"
                // }
            }
        })
        .state('article', {
            url: '/',
            views: {
                // "top": {
                //     templateUrl: "backstage.html"
                // },
                "center": {
                    templateUrl: "article.html"
                }
                // "footer": {
                //     templateUrl: "article-cont.html"
                // }
            }
        })
        .state('article-cont', {
            url: '/article-cont',
            views: {
                // "top": {
                //     templateUrl: "backstage.html"
                // },
                // "center": {
                //     templateUrl: "article.html"
                // },
                "footer": {
                    templateUrl: "article-cont.html"
                }
            }
        })
});
