function pttengAdminRouteConfig($stateProvider, $urlRouterProvider, $ocLazyLoadProvider, $locationProvider) {
    var _lazyLoad = function (loaded) {
        return function ($ocLazyLoad) {
            return $ocLazyLoad.load(loaded, {serie: true});
        };
    };

    $ocLazyLoadProvider.config({
        debug: false,
        events: true
    });

    //更改url格式配置为html5，去掉#号;
    $locationProvider.html5Mode(true);
    $urlRouterProvider.otherwise("/field/home");

    $stateProvider
        .state('page_not_found', {
            url: '/404',
            templateUrl: '404.html',
            controller: 'NotFoundCtrl',
            resolve: {
                loadMyFile: _lazyLoad(['js/controllers/ptteng-admin/ptteng-notFoundController-0.0.1.js'])
            }
        })
        .state('login', {
            url: '/login',
            templateUrl: 'login.html',
            controller: 'LoginCtrl',
            resolve: {
                loadMyFile: _lazyLoad(['js/controllers/ptteng-admin/ptteng-loginController-0.0.1.js'])
            }
        })
        .state('field', {
            url: '/field',
            templateUrl: 'views/main.html',
            controller: 'MainCtrl',
            resolve: {
                loadMyFile: _lazyLoad(['js/directives/ptteng-user/ptteng-user-0.0.1.js',
                    'js/directives/ptteng-sidebar/ptteng-sidebar-0.0.1.js',
                    'js/controllers/ptteng-admin/ptteng-mainController-0.0.1.js',
                    'js/directives/ptteng-paging/pagination.js',
                    'js/directives/loading/loading.js',
                    'js/directives/loading/loading.css'
                ])
            }
        })
        .state('field.home', {
            url: '/home',
            templateUrl: 'views/home.html',
        })
        .state('field.productCustomer', {
            url: '/productCustomer?status&type&name&from&mediumId&linkId&page&size',
            templateUrl: 'views/product/productC.html',
            controller: 'ProductCtrC',
            controllerAs: 'vm',
            resolve: {
                loadMyFile: _lazyLoad([
                    'js/controllers/product/productC.js',
                    'vendor/angular-drag-and-drop-lists/angular-drag-and-drop-lists.min.js'
                ])
            }
        })
        .state('field.productRecommend', {
            url: '/productRecommend?status&type&name&from&mediumId&linkId&page&size',
            templateUrl: 'views/product/productR.html',
            controller: 'ProductCtrR',
            controllerAs: 'vm',
            resolve: {
                loadMyFile: _lazyLoad([
                    'js/controllers/product/productR.js',
                ])
            }
        })
        .state('field.productDetailC', {
            url: '/productDetailC?id',
            templateUrl: 'views/product/productDetailC.html',
            controller: 'productDetailC',
            controllerAs: 'vm',
            resolve: {
                loadMyFile: _lazyLoad([
                    'js/controllers/product/productDetailC.js',
                    'js/directives/uploader/uploader.css',
                    'js/directives/uploader/uploader.js',
                    'js/directives/numberic-input.js'
                ])
            }
        })
        .state('field.productDetailR', {
            url: '/productDetailR?id',
            templateUrl: 'views/product/productDetailR.html',
            controller: 'productDetailR',
            controllerAs: 'vm',
            resolve: {
                loadMyFile: _lazyLoad([
                    'js/controllers/product/productDetailR.js',
                    'js/directives/uploader/uploader.css',
                    'js/directives/uploader/uploader.js',
                    'js/directives/numberic-input.js'
                ])
            }
        })
        .state('field.user', {
            url: '/user?registerStart&registerEnd&mobile&estate&car&card&lifeInsurance&feeInsurance&livingTime&profession&source&linkId&sourceLink&isDone&productId&startTime&endTime&page&size&ids',
            templateUrl: 'views/user/userList.html',
            controller: 'UserCtr',
            controllerAs: 'vm',
            resolve: {
                loadMyFile: _lazyLoad([
                    'js/controllers/user/user.js',
                    'js/directives/numberic-input.js'
                ])
            }
        })
        // 媒介管理
        .state('field.medium', {
            url: '/medium?status&name&page&size',
            templateUrl: 'views/medium/medium.html',
            controller: 'MediumCtr',
            controllerAs: 'vm',
            resolve: {
                loadMyFile: _lazyLoad([
                    'js/controllers/medium/medium.js',
                ])
            }
        })
        // 媒介链接
        .state('field.link', {
            url: '/link?mediumId&link',
            templateUrl: 'views/medium/link.html',
            controller: 'linkCtr',
            controllerAs: 'vm',
            resolve: {
                loadMyFile: _lazyLoad([
                    'js/controllers/medium/link.js',
                ])
            }
        })
        // 分单统计
        .state('field.productSta', {
            url: '/productSta?startTime&endTime&page&size&productName',
            templateUrl: 'views/statistics/productSta.html',
            controller: 'productStaCtr',
            controllerAs: 'vm',
            resolve: {
                loadMyFile: _lazyLoad([
                    'js/controllers/statistics/productSta.js',
                ])
            }
        })
        // 媒介统计
        .state('field.mediumSta', {
            url: '/mediumSta?startTime&endTime&mediumName&linkId&page&size',
            templateUrl: 'views/statistics/mediumSta.html',
            controller: 'mediumStaCtr',
            controllerAs: 'vm',
            resolve: {
                loadMyFile: _lazyLoad([
                    'js/controllers/statistics/mediumSta.js',
                ])
            }
        })

        .state('field.banner', {
            url: '/banner?page&size',
            templateUrl: 'views/banner/banner.html',
            controller: 'bannerCtr',
            controllerAs: 'vm',
            resolve: {
                loadMyFile: _lazyLoad([
                    'js/controllers/banner/banner.js',
                ])
            }
        })
        .state('field.bannerDetail', {
            url: '/bannerDetail?id',
            templateUrl: 'views/banner/bannerDetail.html',
            controller: 'bannerDetailCtr',
            controllerAs: 'vm',
            resolve: {
                loadMyFile: _lazyLoad([
                    'js/controllers/banner/bannerDetail.js',
                    'js/directives/uploader/uploader.css',
                    'js/directives/uploader/uploader.js',
                ])
            }
        })
        //新建账户
        .state('field.manager', {
            url: '/manager',
            templateUrl: 'views/manager/manager.html',
            controller: 'managerCtr',
            controllerAs: 'vm',
            resolve: {
                loadMyFile: _lazyLoad([
                    'js/controllers/manager/manager.js',
                ])
            }
        })
        //修改密码
        .state('field.pwd', {
            url: '/pwd',
            templateUrl: 'views/manager/pwd.html',
            controller: 'pwdCtr',
            controllerAs: 'vm',
            resolve: {
                loadMyFile: _lazyLoad([
                    'js/controllers/manager/pwd.js',
                ])
            }
        })

}


!(function () {
    angular.module('admin', ['oc.lazyLoad', 'ui.router', 'ngCookies', 'mgcrea.ngStrap', 'angular-loading-bar', 'ngMessages', 'ngSanitize', 'ui.sortable'])
        .config(httpConfig)
        .config(pttengAdminRouteConfig)
        .config(loadingBar)

        .run(function ($rootScope, $templateCache, $modal, $cookies, $state, $location, adminService) {


            //默认分页参数
            $rootScope.$on('$stateChangeStart', function (event, toState, toParams, fromState, fromParams) {

                //默认分页参数
                if (toParams.page != undefined) {
                    toParams.page = toParams.page || 1;
                }
                if (toParams.size != undefined) {
                    toParams.size = toParams.size || 10;
                }
            });

            $rootScope.isLogin = function () {
                return !!$cookies.login;
            };


            $rootScope.$on('$stateChangeStart', function (event, toState, toParams, fromState, fromParams) {
            });

            $rootScope.$on('$stateChangeSuccess', function (event, toState, toParams, fromState, fromParams) {
                if (!$rootScope.isLogin() && $location.path() !== "/login") {
                    $state.go("login");
                    return false;
                }
                if ($rootScope.isLogin() && $location.path() === "/login") {
                    $state.go("field.home");
                    return false;
                }

            });

            $rootScope.$on('$viewContentLoading', function (event) {
                // console.log('视图开始加载');
            });
            $rootScope.$on('$viewContentLoaded', function (event) {
                // console.log('视图渲染完毕');
            });

            //alert confirm notify
            $rootScope.alert = function (content, okFn) {
                var modal = $modal({
                    html: true,
                    show: false,
                    templateUrl: 'views/template/ptteng-alert-0.0.1.html',
                    controller: function ($scope) {
                        $scope.content = content;
                        $scope.ok = function () {
                            typeof okFn == 'function' && okFn();
                            modal.$promise.then(modal.hide);
                        };
                    }
                });
                modal.$promise.then(modal.show);
            };
            $rootScope.confirm = function (content, okFn, cancelFn) {
                var modal = $modal({
                    html: true,
                    show: false,
                    templateUrl: 'views/template/ptteng-confirm-0.0.1.html',
                    controller: function ($scope) {
                        $scope.content = content;
                        $scope.ok = function () {
                            typeof okFn == 'function' && okFn();
                            modal.$promise.then(modal.hide);
                        };
                        $scope.cancel = function ($scope) {
                            typeof cancelFn == 'function' && cancelFn();
                            modal.$promise.then(modal.hide);
                        };
                    }
                });
                modal.$promise.then(modal.show);
            };

            $rootScope.prompt = function (title, content, okFn, cancelFn) {
                var modal = $modal({
                    html: true,
                    show: false,
                    templateUrl: 'views/template/prompt.html',
                    controller: function ($scope) {
                        $scope.title = title; // 设置模态框标题
                        $scope.content = content; // 设置模态框内容
                        $scope.isShow = false;
                        $scope.params = {};
                        $scope.ok = function () {
                            typeof okFn == 'function' && okFn($scope.content); // 把对话框输入的值作为参数传出来
                            modal.$promise.then(modal.hide);
                        };
                        $scope.cancel = function () {
                            typeof cancelFn == 'function' && cancelFn();
                            modal.$promise.then(modal.hide);
                        };
                        // 给输入框添加失去焦点事件
                        $scope.test = function () {
                            $scope.params.name = $scope.content;
                            adminService.testMedium($scope.params).then(function (res) {
                                if (res.data.code === 0) {
                                    $scope.isShow = false;
                                } else {
                                    $scope.isShow = true; // 媒介名称存在则显示错误信息
                                }
                            })
                        };
                    }
                });
                modal.$promise.then(modal.show);
            };

        })
    ;


    function httpConfig($httpProvider) {
        // Use x-www-form-urlencoded Content-Type
        $httpProvider.defaults.headers.common['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
        $httpProvider.defaults.headers.patch['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
        $httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
        $httpProvider.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';


        // set up global transformRequest function
        $httpProvider.defaults.transformRequest = function (data) {
            if (data === undefined) {
                return data;
            }
            return $.param(data);
        };

    }


    function loadingBar(cfpLoadingBarProvider) {
        cfpLoadingBarProvider.latencyThreshold = 200;
        cfpLoadingBarProvider.includeSpinner = false;
    }

})();
