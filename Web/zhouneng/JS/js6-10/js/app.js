// ng路由
// angular.module('myApp', ['ngRoute'])
// .config(function ($routeProvider) {
//     $routeProvider.
//     when('/login', {
//         templateUrl: 'html/login.html',
//         // controller: 'loginController'
//     }).
//     otherwise({
//         redirectTo: '/login'
//     });
// });




// ui路由
angular.module('myApp', ["ui.router", "oc.lazyLoad", "ngFileUpload"]) //加载ui路由模块和懒加载模块
    .config(function ($httpProvider) { //设置请求头数据类型
        // Set x-www-form-urlencoded Content-Type,设置请求content-type
        $httpProvider.defaults.headers.common['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
        $httpProvider.defaults.headers.patch['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
        $httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
        $httpProvider.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
        $httpProvider.defaults.transformRequest = function (data) {
            if (data === undefined) {
                return data;
            }
            return $.param(data);
        };
    })
    .config(function ($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/login'); //默认加载页面
        $stateProvider
            .state('login', { //路由跳转
                url: '/login', //定义路由的地址
                views: { //视窗，加载路由的html模块
                    '': {
                        templateUrl: 'html/login.html',
                    }
                },
                resolve: { //懒加载，加载html模块对应的css和js文件
                    myload: (function ($ocLazyLoad) {
                        return $ocLazyLoad.load(["css/login.css", "js/login.js"]);
                    })
                }
            })
            .state('home', { //路由跳转主页
                url: '/home?article&articles', //定义主页路由的地址
                views: { //视窗，加载路由主页的html模块
                    '': {
                        templateUrl: 'html/home.html',
                    }
                },
                resolve: { //懒加载，加载主页html模块对应的css和js文件
                    myload: (function ($ocLazyLoad) {
                        return $ocLazyLoad.load(["css/home.css", "js/home.js"]);
                    })
                }
            })
            .state('home.list', { //在主页路由跳转到list
                url: '/list?page&size&value&status&type&title&author&startAt&endAt', //定义主页list路由的地址和传参？后面是传参
                views: { //视窗，加载路由主页list的html模块
                    '': {
                        templateUrl: 'html/list.html',
                        controller: 'list', //过滤器
                        // params:{args:{}}
                    }
                },
                resolve: { //懒加载，加载主页list的html模块对应的css和js文件
                    myload: (function ($ocLazyLoad) {
                        return $ocLazyLoad.load(["css/list.css", "js/list.js"]);
                    })
                }
            })
            .state('home.add', { //路由跳转到新增
                url: '/add?skip&id', //定义新增路由的地址
                views: { //视窗，加载新增的html模块
                    '': {
                        templateUrl: "html/add.html",
                        controller: "add"
                    }
                },
                resolve: { //懒加载，加载新增的html模块对应的css和js文件
                    myload: (function ($ocLazyLoad) {
                        return $ocLazyLoad.load(["css/add.css", "js/add.js"]);
                    })
                }
            })
            .state('home.details', {
                url: '/details',
                views: {
                    '': {
                        templateUrl: "html/details.html"
                    }
                },
                resolve: {
                    myload: (function ($ocLazyLoad) {
                        return $ocLazyLoad.load([]);
                    })
                }
            })
    })
    .run(function ($rootScope, $state) { //路由拦截
        $rootScope.$on('$stateChangeSuccess', function (event, toState, toParams, fromState, fromParams) {
            // 获取登录和未登录状态
            let ifLoginTrue = JSON.parse(localStorage.getItem("ifLoginTrue"));
            console.log(ifLoginTrue)
            if (ifLoginTrue == "false" || ifLoginTrue == null) {//状态为未登录时
                // event.preventDefault(); // 取消默认跳转行为
                $state.go('login');//跳转到登录页
            }
        });
    })
    
// .run(function ($rootScope, $state) {
//      $rootScope.$on('$stateChangeSuccess', function (event, toState, toParams, fromState, fromParams) {
//         // if (toState.name == 'login') return; // 如果是进入登录界面则允许
//         // 如果用户不存在
//         let ifLoginTrue = JSON.parse(localStorage.getItem("ifLoginTrue"));
//         console.log(ifLoginTrue)
//         if (ifLoginTrue == "false") {
//             console.log("没有登录")
//             event.preventDefault(); // 取消默认跳转行为
//             $("#my-modal-loading").modal('open'); //开启加载中loading

//             $state.go("login", {
//                 // from: fromState.name,
//                 // w: 'notLogin'
//             }); //跳转到登录界面
//         }
//     });
// })