angular.module('App')
    .config(function ($stateProvider, $urlRouterProvider, $locationProvider, $ocLazyLoadProvider) {
        //封装懒加载
        var _lazyLoad = function (loaded) {
            return function ($ocLazyLoad) {
                return $ocLazyLoad.load(loaded, {serie: true})
            }
        };

        $ocLazyLoadProvider.config({
            debug: false,
            events: true
        });
        //默认打开页面
        $urlRouterProvider.otherwise('/login');
        //配置路由页面
        $stateProvider
        //登录页面
            .state('login', {
                url: '/login',
                controller: 'logCtrl',
                templateUrl: 'html/login.html',
                resolve: {
                    loadMyFile: _lazyLoad([
                        'css/login.css',
                        'controller/login.js'
                    ])
                }
            })
            //后台页面
            .state('list', {
                url: '/list',
                controller: 'listCtrl',
                templateUrl: 'html/list.html',
                resolve: {
                    loadMyFile: _lazyLoad([
                        'component/menu/htmleaf-demo.css',
                        'component/menu/nav.css',
                        'component/menu/iconfont.css',
                        'css/list.css',
                        'controller/list.js'
                    ])
                }
            })
            //后台欢迎页面
            .state('list.welcome', {
                url: '/welcome',
                templateUrl: 'html/welcome.html',
                resolve: {
                    loadMyFile: _lazyLoad([
                        'css/welcome.css'
                    ])
                }
            })
            //article列表页面
            .state('list.article', {
                url: '/article?page&type&status&startAt&endAt',
                controller: 'artCtrl',
                params: {
                    'startAt': null,
                    'endAt': null,
                    'type': null,
                    'status': null,
                    'page': null
                },
                templateUrl: 'html/article.html',
                resolve: {
                    loadMyFile: _lazyLoad([
                        'component/bootstrap-datepicker/bootstrap-datepicker.css',
                        'css/article.css',
                        'component/bootstrap-datepicker/bootstrap-datepicker.min.js',
                        'controller/article.js',
                        'filter/filter.js'
                    ])
                }
            })
            //新增页面
            .state('list.add', {
                url: '/add?id',
                controller: 'addCtrl',
                templateUrl: 'html/add.html',
                resolve: {
                    loadMyFile: _lazyLoad([
                        'css/add.css',
                        '//unpkg.com/wangeditor/release/wangEditor.min.js',
                        'controller/add.js'
                    ])
                }
            })
    });