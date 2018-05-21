
angular.module('App',['ui.router','angularFileUpload','ui.bootstrap','oc.lazyLoad'])
    .config(function ($stateProvider,$urlRouterProvider) {
        var _lazyLoad = function (loaded) {
            return function ($ocLazyLoad) {
                return $ocLazyLoad.load(loaded, {serie: true});
            }
        };

        $urlRouterProvider.otherwise('/login');

        $stateProvider
            //登陆页
            .state('login', {
                url: '/login',
                templateUrl: 'landing-page.html',
                resolve: {
                    loadMyFile: _lazyLoad([
                        "css/landing-page.css",
                        "controller/login.js"
                    ])
                }
            })

            //后台主页
            .state('backstage', {
                url: '/backstage',
                templateUrl: 'backstage.html',
                resolve: {
                    loadMyFile: _lazyLoad([
                        "css/sidebar-menu.css",
                        "css/app.css",
                        "sidebar/sidebar-menu.js",
                        "controller/ArticleList.js"
                    ])
                }
            })

            //欢迎页
            .state('backstage.page1',{
                url:'/page1',
                templateUrl: 'page1.html'
        })

            //公司列表页
            .state('backstage.Article',{
                url:'/Article?type&status&startAt&endAt&page&size',
                templateUrl: 'Article.html'
            })

            //新增页
            .state('backstage.AddArt',{
                url:'/AddArt?id',
                templateUrl: 'AddArt.html',
                resolve: {
                    loadMyFile: _lazyLoad([
                        "controller/upload.js"
                    ])
                }
            });

    });



   



