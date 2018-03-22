angular.module("myApp")
    .config(function ($stateProvider,$urlRouterProvider,$ocLazyLoadProvider,$locationProvider) {
        var _lazyLoad = function (loaded) {
            return function ($ocLazyLoad) {
                return $ocLazyLoad.load(loaded)
            }
        };
        $ocLazyLoadProvider.config({
            debug:false,
            events:true
        });
    $urlRouterProvider.otherwise("/login");
    $locationProvider.hashPrefix("");
    $stateProvider
        .state("login",{
            url:"/login",
            templateUrl: "js7-1.html",
            controller:'myCtrl',
            resolve:{
                loadMyFile:_lazyLoad([
                    'js/controller/login.controller.js',
                    'css/js7-1.css'
                ])
            }
        })
        .state("houtai", {
            url:"/houtai",
            templateUrl: "houtai.html",
            resolve:{
                loadMyFile:_lazyLoad([
                    'js/controller/mainLeft.controller.js',
                    'js/controller/nav.controller.js',
                    'css/js6.css'
                ])
            }
        })
        .state("houtai.js6-2", {
            params: {
                page: null, size: null, type: null, status: null, startAt: null, endAt: null
            },
            url: "/js6-2?size&page&type&status&startAt&endAt",
            templateUrl: "js6-2.html",
            resolve: {
                loadMyFile: _lazyLoad([
                    'js/controller/pageList.controller.js',
                    'js/directive/pagelist.js'

                ])
            }
        })
        .state("houtai.js6-2.js6-3", {
            params:{
                id:null,json:null
            },
            url:"/js6-3?id&json",
            templateUrl: "js6-3.html",
            resolve:{
                loadMyFile:_lazyLoad([
                    'wangEditor-2/dist/js/wangEditor.min.js',
                    'js/controller/img_upload.controller.js',
                    'wangEditor-2/dist/css/wangEditor.min.css',
                    'js/directive/fileUploadForMissionManage.html'

        ])
            }
        })
});