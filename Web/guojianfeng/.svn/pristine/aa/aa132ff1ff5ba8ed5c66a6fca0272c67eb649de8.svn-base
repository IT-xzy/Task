var App=angular.module("App",['ui.router','oc.lazyLoad']);
App.config(['$stateProvider','$urlRouterProvider', function ($stateProvider,$urlRouterProvider) {
    var lazy = function (loaded) {
        return function ($ocLazyLoad) {
            return $ocLazyLoad.load(loaded);
        }
    };//配置路由
    $urlRouterProvider.when("","/login");
    $stateProvider
        .state("login",{
            url:"/login",
            templateUrl:"views/login.html",
            resolve: {
                loadMyFile: lazy([
                    "css/login.css",
                    "js/login.js"
                ])
            }
        })
        .state("welcome",{
            url:"/welcome",
            templateUrl:"views/welcome.html",
            resolve: {
                loadMyFile: lazy([
                    "css/welcome.css",
                    "js/welcome.js"
                ])
            }
        })
        .state("welcome.position", {
            url: "/position",
            templateUrl: "views/position.html"
        })
        .state("welcome.articlelist", {
            url: "/articlelist",
            templateUrl: "views/articlelist.html"
        })
        .state("welcome.article", {
            url: "/article?page&size&type&status&startAt&endAt&id",
            templateUrl: "views/article.html",
            resolve: {
                loadMyFile: lazy([
                    "css/article.css",
                    "js/article.js",
                    "css/bootstrap-datetimepicker.min.css",
                    "js/bootstrap-datetimepicker.min.js"
                ])
            }
        })
        .state("welcome.addArticle",{
            url:"/addArticle?id",
            templateUrl:"views/addArticle.html",
            resolve: {
                loadMyFile: lazy([
                    "css/addArticle.css",
                    "js/addArticle.js"
                ])
            }
        })

}]);