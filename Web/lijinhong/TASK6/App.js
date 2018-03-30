var myApp = angular.module("app", ["ui.router"]);
angular.module("app", ["ui.router"]).config(function ($stateProvider, $urlRouterProvider) {
   $urlRouterProvider.when("", "/landing");
    $stateProvider
        .state("landing", {//引号里面代表list是Page的子页面，用.隔开
            url: "/landing",//#+标识符，通过标识符，进入不同的html页面
            templateUrl: "landing.html"//这里是html的路径，这是跟标识符相对应的html页面
         
        })
        .state("page", {
            url:"/page",
            templateUrl: "page.html"
        })
          .state("page.list", {
            url:"/list?type&status&startAt=null&endAt&size&page",
            templateUrl: "list.html"
      
        })
          .state("page.list.new", {
            url:"/new?id",
            templateUrl: "new.html"

        })

});





                