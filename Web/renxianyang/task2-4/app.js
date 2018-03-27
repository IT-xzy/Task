var app = angular.module('app', ['ui.bootstrap', 'ui.router', 'oc.lazyLoad']);
app.controller('app', ['$rootScope', 'softHeader', function ($rootScope, softHeader) {
    $rootScope.softHeader = softHeader.home;
}])