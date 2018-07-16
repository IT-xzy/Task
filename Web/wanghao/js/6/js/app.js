angular.module("myApp", ["ui.router", "oc.lazyLoad"]) //加载路由模块和懒加载模块
    .config(function ($stateProvider, $urlRouterProvider,$locationProvider) {
        $locationProvider.html5Mode(false);
        $locationProvider.hashPrefix("a");
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
            .state("u", {
                url: '/u', //路由地址
                views: {
                    "": {
                        templateUrl: "views/backstage.html",
                        controller: 'backstageController',
                    }
                },
                resolve: {
                    loadMyCtrl: (function ($ocLazyLoad) {
                        return $ocLazyLoad.load(["css/backstage.css", "js/backstage.js"]);
                    })
                }
            })
            .state("u.article", {
                url: '/article?page&size&status&type', //路由地址
                views: {
                    "mian": {
                        templateUrl: "views/Article.html",
                        controller: 'articleController',
                    }
                },
                resolve: {
                    loadMyCtrl: (function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['css/Article.css',"js/Article.js"]);
                    })
                },
            })
            .state("u.addArticle", {
                url: '/addArticle', //路由地址
                views: {
                    "": {
                        templateUrl: "/views/addArticle.html",
                        controller: 'addArticleController',
                    }
                },
                resolve: {
                    loadMyCtrl: (function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['css/addArticle.css','js/addArticle.js']);
                    })
                },
            })
            .state("u.redactArticle", {
                url: '/redactArticle?id', //路由地址
                views: {
                    "mian": {
                        templateUrl: "/views/addArticle.html",
                        controller: 'redactArticleController',
                    }
                },
                resolve: {
                    loadMyCtrl: (function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['css/addArticle.css','js/redactArticle.js']);
                    })
                },
            })
            .state("ww", {
                url: '/ww', //路由地址
                views: {
                    "": {
                        templateUrl: "demo/dome.html",
                        controller: 'ww',
                    }
                },
                resolve: {
                    loadMyCtrl: (function ($ocLazyLoad) {
                        return $ocLazyLoad.load(['demo/12.js']);
                    })
                },
            });
    })