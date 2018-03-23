angular.module("myApp", ["ui.router", "oc.lazyLoad"])
    .config(['$stateProvider', '$urlRouterProvider',function ($stateProvider, $urlRouterProvider) {


        //在路径没有匹配的路由的时候，跳转到一个默认的路径：/login
        $urlRouterProvider.when("", "/login");

        $stateProvider
            .state("login", {
                url: "/login",
                templateUrl: " html/login.html",
                controller: "login",
                resolve: {
                    loadMyFile: ["$ocLazyLoad", function ($ocLazyLoad) {
                        return $ocLazyLoad.load([
                            "css/login.css",
                            "js/login.js"
                        ])
                    }]
                }
            })
            .state("backStage", {
                url: "/backStage",
                templateUrl: " html/backStage.html",
                controller: "backStageController",
                resolve: {
                    loadMyFile: ["$ocLazyLoad", function ($ocLazyLoad) {
                        return $ocLazyLoad.load([
                            "css/backStage.css",
                            "js/backStage.js"
                        ])
                    }]
                }
            })

            .state("backStage.companyList", {
                url: "/companyList",
                templateUrl: " html/companyList.html"
            })

            .state("backStage.positionList", {
                url: "/positionList",
                templateUrl: " html/positionList.html"
            })

            .state("backStage.article", {
                url: "/article?startAt&endAt&type&status&size&page",
                templateUrl: "html/article.html",
                controller: "articleController",
                resolve: {
                    loadMyFile: ["$ocLazyLoad", function ($ocLazyLoad) {
                        return $ocLazyLoad.load([
                            "css/article.css",
                            "css/pikaday.css",
                            "js/article.js",
                            "js/global/pikaday.js",
                            "js/filters.js",
                            "js/constant.js"
                        ])
                    }]
                }
            })
            .state("backStage.addArticle", {
                url: "/addArticle?id",
                templateUrl: "html/addArticle.html",
                controller: "addArticleController",
                controllerAs: 'vn',
                resolve: {
                    loadMyFile: ["$ocLazyLoad", function ($ocLazyLoad) {
                        return $ocLazyLoad.load([
                            "css/addArticle.css",
                            "js/addArticle.js",
                            "js/filters.js",
                            "js/constant.js"
                        ])
                    }]
                }

            });

    }]);

