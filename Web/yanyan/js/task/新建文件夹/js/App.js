var myApp = angular.module("myApp", ["ui.router", "oc.lazyLoad"]);

myApp.config(function ($stateProvider, $urlRouterProvider) {
    var lazyLoad = function (loaded) {
        return function ($ocLazyLoad) {
            return $ocLazyLoad.load(loaded, {serie: true});
        }
    };
    $urlRouterProvider.when("", "/login");
    $stateProvider
    // 登录页
        .state("login", {
            url: "/login",
            templateUrl: "html/login.html",
            resolve: {
                loadMyFile: lazyLoad([
                    "style/login.css",
                    "js/login.js"
                ])
            }
        })
        // 主页面
        .state("main", {
            url: "/main",
            templateUrl: "html/main.html",
            resolve: {
                loadMyFile: lazyLoad([
                    "style/main.css",
                    "js/filter.js",
                    "js/main.js"

                ])
            }
        })
        // article列表
        .state("main.article", {
            url: "/article?page/size/type/status/startAt/endAt",
            templateUrl: "html/article.html",
            resolve: {
                loadMyFile: lazyLoad([
                    "js/article.js"
                ])
            }
        })


        .state("main.company", {
            url: "/company",
            templateUrl: "html/company.html"
        })

        .state("main.job",{
            url: "/job",
            templateUrl: "html/job.html"
        })

        .state("main.articleDetail",{
            url:"/articleDetail?id",
            templateUrl:"html/articleDetail.html",
            resolve: {
                loadMyFile: lazyLoad([
                    "plug-in-js/angular-file-upload.min.js",
                    "js/articleDetail.js",
                    "plug-in-js/wangEditor.min.js"
                ])
            }
        })

});

