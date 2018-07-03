angular.module("myApp", ["ui.router", "oc.lazyLoad", 'ui.bootstrap'])

    .config(function ($stateProvider, $urlRouterProvider, $controllerProvider, $httpProvider) {

        var _lazyLoad = function (loaded) {
            return function ($ocLazyLoad) {
                return $ocLazyLoad.load(loaded, {
                    serie: true
                });
            };
        };

        $urlRouterProvider.otherwise("/"); //默认转向登录页
        $stateProvider
            .state("login", {
                url: "/",
                templateUrl: '../views/login.html',
                controller: 'loginCtrl', //登录页控制器loginCtrl
                resolve: { //懒加载文件
                    loadMyFile: _lazyLoad(['css/login.css', 'js/controller/login.js'])
                }
            })
            .state("admin", {
                url: "/admin",
                templateUrl: '../views/admin.html',
                controller: 'adminCtrl', //登录页控制器loginCtrl
                resolve: { //懒加载文件
                    loadMyFile: _lazyLoad(['css/admin.css', 'js/controller/admin.js'])
                }
            })

            .state("admin.list", {
                params: {
                    starAt: null,
                    endAt: null,
                    type: null,
                    status: null,
                    page: null
                },
                url: '/list:starAt/:endAt/:type/:status/:page',
                templateUrl: '../views/list.html',
                controller: 'listCtrl',
                resolve: {
                    loadMyFile: _lazyLoad(['css/list.css', 'js/controller/list.js'])
                }
            })
            .state("admin.add", {
                params: {
                    id: null
                },
                url: "/add:id",
                templateUrl: '../views/add.html',
                controller: 'addCtrl', //登录页控制器loginCtrl
                resolve: { //懒加载文件
                    loadMyFile: _lazyLoad(['css/add.css', 'js/controller/add.js'])
                }
            })

            // 拦截器
            $httpProvider.interceptors.push(function ($rootScope, $q) {
                return {
                    request: function (config) {
                        return config;
                    },
                    responseError: function (rejection) {
                        return $q.reject(rejection);
                    },
                    response: function (response) {
                        //cookie失效
                        if (response.data.code == -2) {
                            $rootScope.selfData = undefined;
                            if (localStorage.login == 'true') {
                                //更改用户登录状态
                                localStorage.login = 'false';
                            } else {
                                return
                            }
                        } else {
                            return response;
                        }
                    }
                }
            });
    })
    //请求头和param
    .config(function httpConfig($httpProvider) {
        // Use x-www-form-urlencoded Content-Type
        // $httpProvider.defaults.headers.common['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
        // $httpProvider.defaults.headers.patch['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
        $httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
        $httpProvider.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
        
        // set up global transformRequest function
        $httpProvider.defaults.transformRequest = function (data) {
            if (data === undefined) {
                return data;
            }
            return $.param(data);
        }
    })