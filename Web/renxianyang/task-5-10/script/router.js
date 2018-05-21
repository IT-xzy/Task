app.config(['$stateProvider', '$urlRouterProvider', '$locationProvider',
    function ($stateProvider, $urlRouterProvider, $locationProvider) {
        // $locationProvider.html5Mode(true).hashPrefix('');
        // $urlRouterProvider.when('/', '/login');
        $locationProvider.hashPrefix('');
        $urlRouterProvider.when('', 'login');
        $stateProvider
            .state('login', {
                url: '/login',
                views: {
                    'views': {
                        templateUrl: 'views/login.html',
                        controller: 'loginCtrl',
                        controllerAs: 'vm',
                    }
                },
                resolve: {
                    lazyInstance: ['$ocLazyLoad', function ($ocLazyLoad) {
                        //故意这样写的~只有这一个
                        var result = $ocLazyLoad.load({files: ['script/controller/loginCtrl.js']});
                        result.then(function () {
                        }, function () {
                        })
                        return result;
                    }],
                },
            })
            .state('dashboard', {
                url: '/dashboard',
                views: {
                    'views': {
                        templateUrl: 'views/dashboard.html',
                        controller: 'dashboardCtrl',
                        controllerAs: 'vm',
                    }
                },
                resolve: {
                    lazyInstance: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load('script/controller/dashboardCtrl.js')
                    }],
                }
            })
            .state('dashboard.articleList', {
                url: '/articleList',
                views: {
                    'dashboardViews': {
                        templateUrl: 'views/article/articleList.html',
                        controller: 'articleListCtrl',
                        controllerAs: 'vm',
                    }
                },
                resolve: {
                    lazyInstance: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load({files: ['script/controller/article/articleListCtrl.js', 'script/constant/articleCount.js']})
                    }],
                }
            })
            .state('dashboard.editArticle', {
                url: '/editArticle',
                views: {
                    'dashboardViews': {
                        templateUrl: 'views/article/editArticle.html',
                        controller: 'editArticleCtrl',
                        controllerAs: 'vm',
                    }
                },
                params: {
                    id: '',
                },
                resolve: {
                    lazyInstance: ['$ocLazyLoad', function ($ocLazyLoad) {
                        //也用到了articleCount，防止单独刷新页面报错
                        return $ocLazyLoad.load({files: ['script/controller/article/editArticleCtrl.js', 'script/constant/articleCount.js']})
                    }],
                }
            })
            .state('dashboard.professionList', {
                url: '/professionList',
                views: {
                    'dashboardViews': {
                        templateUrl: 'views/profession/professionList.html',
                        controller: 'professionListCtrl',
                        controllerAs: 'vm',
                    }
                },
                resolve: {
                    lazyInstance: ['$ocLazyLoad', function ($ocLazyLoad) {
                        return $ocLazyLoad.load({files: ['script/controller/profession/professionListCtrl.js', 'script/constant/professionCount.js']})
                    }],
                }
            })
            .state('dashboard.editProfession', {
                url: '/editProfession',
                views: {
                    'dashboardViews': {
                        templateUrl: 'views/profession/editProfession.html',
                        controller: 'editProfessionCtrl',
                        controllerAs: 'vm',
                    }
                },
                params: {
                    id: null,
                    status: null
                },
                resolve: {
                    lazyInstance: ['$ocLazyLoad', function ($ocLazyLoad) {
                        //也用到了professionCount，防止单独刷新页面报错
                        return $ocLazyLoad.load({files: ['script/controller/profession/editProfessionCtrl.js', 'script/constant/professionCount.js']})
                    }],
                }
            })
    }])