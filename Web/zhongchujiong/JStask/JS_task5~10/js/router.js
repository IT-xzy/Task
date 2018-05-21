angular.module('zcjApp',['ui.router','ngAnimate', 'ngSanitize', 'ui.bootstrap','angularFileUpload','oc.lazyLoad'])
    .config(['$stateProvider','$urlRouterProvider',function ($stateProvider,$urlRouterProvider) {
    $urlRouterProvider.when("","/login");
    $urlRouterProvider.when("/backstage","backstage/welcomeMyApp");
    $stateProvider
      .state("login",{
        url:"/login",
        templateUrl:"login.html"
      })
      .state('backstage',{
        url:'/backstage',
        templateUrl:'backstage.html',
        controller: 'backstageCtrl',
        resolve: {
          loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
            return $ocLazyLoad.load(['../js/backstage.js'])
          }]
        }
      })
      .state('backstage.welcome',{
        url:'/welcomeMyApp',
        templateUrl:'welcome.html'
      })
      .state('backstage.ArticleList',{
        url:'/Article-list/:size/:page?type&status&startAt&endAt',
        templateUrl:'Article-list.html',
        controller: 'ArticleCtrl',
      resolve: {
          loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
            return $ocLazyLoad.load('../js/ArticleCtrl.js')
          }]
        }
      })
      .state('backstage.articleRedact', {
        url: '/Article-list/Article-redact?id',
        templateUrl: 'Article-redact.html',
        controller: 'ArticleEditor',
        resolve: {
          loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
            return $ocLazyLoad.load(['../js/ArticleEditor.js',
              '../js/basic/wangEditor.js'
            ])
          }]
        }
      })
      .state('backstage.Company',{
        url:'/Company',
        templateUrl:'listOne.html'
      })
      .state('backstage.Position',{
        url:'/Position',
        templateUrl:'listTwo.html'
      })
  }]);