/**
 * Created by MACHENIKE on 2017/8/2.
 */
angular.module('myApp',['ui.router','oc.lazyLoad'])
.config(function ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.when('','/login');
    $stateProvider
        .state('login',{
            url:'/login',
            templateUrl:'HTML/login.html',
            resolve:{
                loadMyFile:["$ocLazyLoad",function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        "JS/login.js"
                    ])
                }]
            }
        })
        .state('main',{
            url:'/main',
            templateUrl:'HTML/main.html',
            resolve:{
                loadMyFile:["$ocLazyLoad",function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        "JS/AppJS/main.js",
                        "LESS/main.css"
                    ])
                }]
            }
        })
        .state('main.welcome',{
            url:'/welcome',
            templateUrl:'HTML/welcome.html'
        })
        .state('main.companylist',{
            url:'/companylist',
            templateUrl:'HTML/companylist.html'
        })
        .state('main.positionlist',{
            url:'/positionlist',
            templateUrl:'HTML/positionlist.html'
        })
        .state('main.article',{
            url:'/article?startAt&endAt&type&status&size&page',
            templateUrl:'HTML/article.html',
            controller:'articleController',
            controllerAs: 'vm',
            resolve: {
                loadMyFile: ["$ocLazyLoad", function($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        "LESS/article.css",
                        "LESS/pikaday.css",
                        "JS/AppJS/article.js",
                        "JS/AppJS/filter.js",
                        "JS/AppJS/pikaday.js"
                    ]);
                }]
            },
            params:{
                'startAt':'',
                'endAt':'',
                'type':'',
                'status':''
            }
        })
    .state('main.articles',{
        url:'/articles?id',
        templateUrl:'HTML/articles.html',
        controller:'articlesController',
        controllerAs: 'vm',
        resolve:{
            loadMyFile:["$ocLazyLoad",function($ocLazyLoad){
                return $ocLazyLoad.load([
                    "LESS/articles.css",
                    "JS/AppJS/articles.js",
                    "JS/AppJS/directives.js"
                ])
            }]
        }

    })
});

