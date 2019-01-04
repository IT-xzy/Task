//声明一个angular模块，并把ui.router传入angular模块，并赋值给变量myApp方便调用
var myApp = angular.module('myApp', ['ui.bootstrap',"ui.router","angularFileUpload"]);

//声明把$stateProvider和$urlRouterProvider路由引擎作为函数参数传入，至此就可配置路由了
//$stateProvider 服务提供者，用来配置路由
//$urlRouterProvider 服务提供者，用来配置路由重定向

myApp.config(function($stateProvider,$urlRouterProvider){
    //如果没有路由引擎能匹配当前的导航状态，那它就会默认将路径路由至organ.html
    $urlRouterProvider.when("","/Login");
    //定义第一个显示出来的的状态，作为页面被加载好以后第一个被使用的路由
    $stateProvider
    .state("Login",{
        url: "/Login",
        templateUrl:"Login.html"
    })
    .state("organ", {
        url : "/organ",
        templateUrl:"organ.html"
    })
    .state("organ.text", {
        url : "/organtext",
        templateUrl:"text.html"
    })
    .state("organ.Article",{
        url:"/Article",
        templateUrl:"Article.html"
    })
    .state("organ.Added",{
        url:"/Added?id",
        templateUrl:"added.html"
    })
    .state("organ.without", {
        url : "/organwithout",
        templateUrl:"without.html"
    })
  })