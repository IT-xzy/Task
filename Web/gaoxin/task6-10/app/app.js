let app = angular.module('myApp', ['ui.router','oc.lazyLoad','ngAnimate', 'ngSanitize', 'ui.bootstrap','angularFileUpload']);
app.config(function($stateProvider, $locationProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('login');
    $stateProvider
        .state("login", {
            url: '/login',
            controller:'loginCtrl',
            templateUrl: 'view1/login.html',
            resolve : {
                loadMyCtrl : ['$ocLazyLoad',function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        // name: 'myApp',//模块的名字，单个模块可以省略
                        files: ['js/controller/loginCtrl.js']
                    })
                }]
            }
        })
        .state("backstage", {
            url: '/backstage',
            controller:'backstageCtrl',
            templateUrl: 'view2/backstage.html',
            resolve : {
                loadMyCtrl : ['$ocLazyLoad',function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        files: ['js/controller/backstageCtrl.js','js/directive/gg-sidebar/gg-sidebar.js','css/backstage.css']
                    })
                }]
            }
        })
        .state("backstage.list", {
            url: '/article/list?:page,startAt,endAt,type,status',
            controller:'listCtrl as vm',
            templateUrl: 'view2/article-list.html',
            resolve : {
                loadMyCtrl : ['$ocLazyLoad',function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        files: ['js/controller/listCtrl.js','js/factory/Filter.js']
                    })
                }]
            }
        })
        .state("backstage.details", {
            url: '/article/details/?:id',
            // params: {'id': null},
            templateUrl: 'view2/article-details.html',
            controller:"addCtrl as vm",
            resolve : {
                loadMyCtrl : ['$ocLazyLoad',function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        files: ['js/controller/addCtrl.js','components/version/wangEditor.min.js']
                    })
                }]
            }
        });
});

