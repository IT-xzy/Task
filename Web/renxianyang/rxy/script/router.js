app.config(function ($stateProvider, $urlRouterProvider) {
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
                    return $ocLazyLoad.load('script/controller/article/articleListCtrl.js')
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
                    return $ocLazyLoad.load('script/controller/article/editArticleCtrl.js')
                }],
            }
        })
})