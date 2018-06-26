angular.module('app').config(['$stateProvider', '$urlRouterProvider', '$locationProvider', '$ocLazyLoadProvider',
    function ($stateProvider, $urlRouterProvider, $locationProvider, $ocLazyLoadProvider) {
        var _lazyLoad = function (loaded) {
            return function ($ocLazyLoad) {
                return $ocLazyLoad.load(loaded, {serie: true});
            };
        };
        $locationProvider.hashPrefix("");
        $urlRouterProvider.when("", "/login");
        $stateProvider
        //后台登陆页
            .state("login", {
                url: "/login",
                templateUrl: 'login.html',
                controller: 'loginCtrl',
                resolve: {
                    loadMyFile: _lazyLoad([
                        "login.js"
                    ])
                }
            })
            .state("list", {
                url: "/list",
                templateUrl: 'list.html',
                controller: 'listCtrl',
                resolve: {
                    loadMyFile: _lazyLoad([
                        "list.js"
                    ])
                }
            })
    }
]);