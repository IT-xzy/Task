// let app = angular.module('app', ['ngRoute']);
// app.config(function ($routeProvider) {
//   $routeProvider
//     .when('/corpList', {
//       templateUrl: './view/corpList.html'
//     })
//     .when('/', {
//       template: '<h1>Welcome!</h1>'
//     })
//     .when('/jobList', {
//       templateUrl: './view/jobList.html'
//     })
//     .when('/articleList', {
//       templateUrl: './view/articleList.html'
//     })
//     .when('/none',{
//       template:'<h1>暂未开放！</h1>'
//     })
//     .when("/test",{
//       templateUrl: './view/test.html'
//     })
//     .when("/articleDetails",{
//       templateUrl: './view/articleDetails.html'
//     })
//     .otherwise({
//       redirectTo: '/none'
//     })
// });
let app = angular.module("app", ['ui.router', 'oc.lazyLoad']);
app.config(function ($stateProvider, $urlRouterProvider) {
  $stateProvider.state({
      name: 'corpList',
      url: '/corpList',
      templateUrl: './view/corpList.html',
      resolve: {
        deps: ['$ocLazyLoad',
          function ($ocLazyLoad) {
            return $ocLazyLoad.load('./controller/corpController.js')
          }
        ]
      }
    })
    .state({
      name: 'jobList',
      url: '/jobList',
      templateUrl: './view/jobList.html',
      resolve: {
        deps: ['$ocLazyLoad',
          function ($ocLazyLoad) {
            return $ocLazyLoad.load('./controller/jobController.js')
          }
        ]
      }
    })
    .state({
      name: 'articleList',
      url: '/articleList',
      templateUrl: './view/articleList.html',
      resolve: {
        deps: ['$ocLazyLoad',
          function ($ocLazyLoad) {
            return $ocLazyLoad.load('./controller/articleController.js')
          }
        ]
      }
    })
    .state({
      name: 'articleDetails',
      url: '/articleDetails',
      templateUrl: './view/articleDetails.html',
      resolve: {
        deps: ['$ocLazyLoad',
          function ($ocLazyLoad) {
            return $ocLazyLoad.load('./controller/newArticle.js')
          }
        ]
      }
      // controller: 'articleContrl'
    })
    .state({
      name: 'welcome',
      url: '',
      template: '<h1>Welcome!</h1>'
    })
    .state({
      name: 'editArticle',
      url: '/editArticle?id=',
      // params:{id:null},
      templateUrl: './view/editArticle.html',
      controller: 'editArticleCtrl',
      resolve: {
        deps: ['$ocLazyLoad',
          function ($ocLazyLoad) {
            return $ocLazyLoad.load('./controller/editArticleCtrl.js')
          }
        ]
      }
    })

});
app.controller('appCtrl', function ($ocLazyLoad) {
  // $ocLazyLoad.load('./controller/corpController.js');
  // $ocLazyLoad.load('./controller/articleController.js');
})