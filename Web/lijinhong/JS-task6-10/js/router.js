// var myApp = angular.module("app", ["ui.router"]);
angular.module("app", ["ui.router","oc.lazyLoad"]).
config(function ($stateProvider, $urlRouterProvider) {
   $urlRouterProvider.when("", "/landing");
   $stateProvider
   .state("landing", {
    url: "/landing",
    templateUrl: "landing.html",
    controller:'myCtrl',
    resolve:{
        deps:["$ocLazyLoad",function($ocLazyLoad){
            return $ocLazyLoad.load("../js/landing.js");
        }]
    }

})
   .state("page", {
    url:"/page",
    templateUrl: "page.html"
})
   .state("page.list", {
    url:"/list?type&status&startAt&endAt&size&page",
    templateUrl: "list.html",
    controller:"listCtrl",
    resolve:{
        deps:["$ocLazyLoad",function($ocLazyLoad){
            return $ocLazyLoad.load([
                                    
                                     "../js/list.js",
                                     "../js/filter.js",
                                  

                                     ]);
        }]
    }

})
   .state("page.list.new", {
    url:"/new?id",
    templateUrl: "new.html",
    controller:"listCtrl",
    resolve:{
        deps:["$ocLazyLoad",function($ocLazyLoad){
            return $ocLazyLoad.load([
                                     "../js/upload.js",
                                     "../js/wangEditor.min.js"
                                     ]);
        }]
    }

})

});





