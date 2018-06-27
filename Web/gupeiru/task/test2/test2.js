var app = angular.module("color", ["ngRoute", "Module.test2", "Module.test2-1", "Module.test2-2"]);

app.config(function ($routeProvider) {
    $routeProvider.otherwise('/');
});