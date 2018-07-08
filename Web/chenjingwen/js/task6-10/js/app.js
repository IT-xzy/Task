var app=angular.module("app",
    [
        'ui.router',
        'oc.lazyLoad',
        'ngAnimate',
        'ngSanitize',
        'ui.bootstrap',
        'angularFileUpload',
        'ngMessages'
    ]);
app.config(function($stateProvider,$urlRouterProvider){
    $urlRouterProvider.otherwise("login");
    $stateProvider
    .state("login",{
        url:"/login",//登录页
        templateUrl:"login.html",
        resolve:{
            load:['$ocLazyLoad',function($ocLazyLoad){
                return $ocLazyLoad.load(
                    {files:['../css/login.css',
                    '../js/controller/loginCtrl.js']}
                );
            }]
        }
    })
    .state("backstage",{
        url:"/backstage",//后台页
        templateUrl:"backstage.html",
        resolve:{
            load:['$ocLazyLoad',function($ocLazyLoad){
                return $ocLazyLoad.load(
                   {files:['../css/backstage.css',
                    '../js/controller/pageCtrl.js',
                ]}
                );
            }]
        }
    })
    .state("backstage.list",{
        url:"/list?:page,type,status,startAt,endAt",//列表页
        templateUrl:"list.html",
        resolve:{
            load:['$ocLazyLoad',function($ocLazyLoad){
                return $ocLazyLoad.load({
                    files:[
                        '../css/list.css',
                        '../js/controller/listCtrl.js',
                        '../js/filter/state.js',
                        '../js/filter/type.js',
                        '../js/filter/toggle.js'
                    ]
                });
            }]
        }
    })
    .state("backstage.detail",{
        url:"/detail/:id",//详情页
        templateUrl:"detail.html",
        resolve:{
            load:['$ocLazyLoad',function($ocLazyLoad){
                return $ocLazyLoad.load(
                    {files:['../css/detail.css',
                    '../js/controller/typeCtrl.js',
                    '../js/constant/constant.js'
                ]}
                );
            }]
        }
    });
});

app.config(httpConfig);
function httpConfig($httpProvider) {
    $httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
    $httpProvider.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
}
