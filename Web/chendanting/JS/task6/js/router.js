// //懒加载
app.config(["$provide", "$compileProvider", "$controllerProvider", "$filterProvider",
  function ($provide, $compileProvider, $controllerProvider, $filterProvider) {
    app.controller = $controllerProvider.register;
    app.directive = $compileProvider.directive;
    app.filter = $filterProvider.register;
    app.factory = $provide.factory;
    app.service = $provide.service;
    app.constant = $provide.constant;
}]);

app.config(["$stateProvider", "$urlRouterProvider","$ocLazyLoadProvider", 
  function ($stateProvider, $urlRouterProvider, $ocLazyLoadProvider){   // 配置路由 使用依赖注入的数组写法,避免压缩工具压缩代码造成错乱  
    $urlRouterProvider.when("", "/login");
    $stateProvider
      .state("login", {
        url: "/login",
        templateUrl: "login.html",
        controller: "loginCtrl as vm",
        // controllerAs: "vm",
        resolve: {
          loadMyFile: [
            "$ocLazyLoad",
            function($ocLazyLoad) {
              return $ocLazyLoad.load("./js/login.js");
            }
          ]
        }
      })
      .state("backstage", {
        url: "/backstage",
        templateUrl: "backstage.html",
        controller: "logoutCtrl as vm",
        // controllerAs: "vm",
        resolve: {
          loadMyFile: [
            "$ocLazyLoad",
            function($ocLazyLoad) {
              return $ocLazyLoad.load("./js/logout.js");
            }
          ]
        }
      })
      .state("backstage.list", {
        url: "/list?page&type&status&start&end",
        templateUrl: "list.html",
        controller: "listCtrl as vm",
        // controllerAs: "vm",
        resolve: {
          loadMyFile: [
            "$ocLazyLoad",
            function($ocLazyLoad) {
              return $ocLazyLoad.load(["./js/list.js", "./js/filter.js"]);
            }
          ]
        }
      })
      .state("backstage.write", {
        url: "/write?id",
        templateUrl: "write.html",
        controller: "writeCtrl as vm",
        // controller: "writeCtrl",
        // controllerAs: "vm",
        resolve: {
          loadMyFile: [
            "$ocLazyLoad",
            function($ocLazyLoad) {
              return $ocLazyLoad.load([
                "./js/write.js",
                "//unpkg.com/wangeditor@3.1.1/release/wangEditor.min.js"
              ]);
            }
          ]
        }
      })
        //   当未指定状态的时候，跳转到后台页面
        // $urlRouterProvider
        //     .otherwise("/backstage");
}]);

