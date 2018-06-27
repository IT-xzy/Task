var app=angular.module("app",['ngRoute','ngSanitize']);
app.config(['$routeProvider',function($routeProvider){
    $routeProvider
    .when('/',{
        templateUrl:'login.html'
    })
    .when('/backstage',{
        templateUrl:'backstage.html'
    })
    .otherwise({resizeTo:'/'});
}]);
