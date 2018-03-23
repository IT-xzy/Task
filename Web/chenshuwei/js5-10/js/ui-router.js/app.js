 angular.module("myApp", ['ui.router','ngAnimate', 'ngSanitize', 'ui.bootstrap','oc.lazyLoad'])
//路由跳转
.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
    var _oclazy=function (oclazy) {
        return['$ocLazyLoad',function ($ocLazyLoad) {
            return $ocLazyLoad.load([oclazy])
        }]
    }
    $urlRouterProvider.when("", "/logIn");
    $urlRouterProvider.when('/carrots', '/carrots/carrots-welcome');
    //登录页面
    $stateProvider.state("logIn", {
        url: "/logIn",
        templateUrl: "log-in.html",
        resolve:{
            loadMyCtrl:['$ocLazyLoad',function ($ocLazyLoad) {
                return $ocLazyLoad.load(["../js/controller.js/login-controller.js","../css/log-in.css"]);
            }]
        }//萝卜多后台页
    }).state("carrots", {
        url: "/carrots",
        templateUrl: "carrots.html",
        resolve:{
            loadMyCtrl:['$ocLazyLoad',function ($ocLazyLoad) {
                return $ocLazyLoad.load(["../js/controller.js/carrots-controller.js","../css/carrots.css"]);
            }]
        }//欢迎页面
    }).state("carrots.welcome", {
        url: "/carrots-welcome",
        templateUrl: "welcome.html"
        //列表页
    }).state("carrots.Artical-list", {
        url: '/Artical/{page}/{size}?type&status&startAt&endAt%id',
        templateUrl: "Artical-list.html",
        controller:'ArticleList as arti',
        resolve:{
            loadMyCtrl:['$ocLazyLoad',function ($ocLazyLoad) {
                return $ocLazyLoad.load(["../js/controller.js/carrots-Article-controller.js","../css/Article-list.css"]);
            }]
        }
        //新增页
    }).state("carrots.Artical-detail", {
        url: "/Artical-detail/{id}",
        templateUrl: "Artical-detail.html",
        controller:'ArticleListDetail',
        resolve:{
            loadMyCtrl:['$ocLazyLoad',function ($ocLazyLoad) {
                return $ocLazyLoad.load(["../js/controller.js/carrots-Article-detail.js","../css/Article-detail.css"]);
            }]
        }
        //公司列表页
    }).state("carrots.company-list", {
        url: "/company/list",
        templateUrl: "company-list.html"
        //公司职位页
    }).state("carrots.company-post",{
        url:"/company/post",
        templateUrl:"company-post.html"
    })
}]);





