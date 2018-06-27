var routerApp = angular.module('routerApp', ['ui.router']);

// routerApp.run(function($rootScope, $state, $stateParams) {
//     $rootScope.$state = $state;
//     $rootScope.$stateParams = $stateParams;
// });

routerApp.config(function($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/index');
    $stateProvider
        .state('index', {//模板的参数
            url: '/index',//url的参数
            templateUrl: 'test.html',//模板的位置
            controller: 'MyController'
        })
        .state('result', {
            url: '/result/:id/:number/:pwd',//需要传的参数的键名
            templateUrl: 'result.html',
            controller: 'resultCtrl'
        });
});