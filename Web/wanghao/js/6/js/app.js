angular.module("myApp", ["ui.router", "oc.lazyLoad"]) //加载路由模块和懒加载模块
    .config(function ($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise("/login"); //默认加载页面
        /* 通过$stateProvider的state()函数来进行路由定义 */
        $stateProvider
            .state('login', { //路由跳转
                url: '/login', //路由地址
                views: { //视窗
                    "": {
                        templateUrl: 'views/login.html',
                        controller: 'loginController',
                    }
                },
                resolve: { //懒加载
                    loadMyCtrl: (function ($ocLazyLoad) {
                        return $ocLazyLoad.load(["css/enter.css", "js/login.js"]);
                    })
                }
            })
            .state("backstage", {
                url: '/backstage', //路由地址
                views: {
                    "": {
                        templateUrl: "views/backstage.html",
                        controller: 'backstageController',
                    }
                },
                resolve: {
                    loadMyCtrl: (function ($ocLazyLoad) {
                        return $ocLazyLoad.load(["css/bootstrap.min.css","css/backstage.css", "js/min/jquery.min.js", "js/min/bootstrap.min.js","js/backstage.js"]);
                    })
                }
            });
    });