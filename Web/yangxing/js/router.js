
app.config(['$stateProvider', '$urlRouterProvider', '$locationProvider',
    function ($stateProvider, $urlRouterProvider, $locationProvider) {

        // var _lazyLoad = function (loaded) {
        //     return function ($ocLazyLoad) {
        //         return $ocLazyLoad.load(loaded, {serie: true});
        //     };
        // };


        $locationProvider.hashPrefix("");
        $urlRouterProvider.when("", "/welcome");
        $stateProvider
            .state('welcome', {
                url: '/welcome',
                templateUrl: 'welcome.html'
            })
            .state('Article', {
                url: '/Article',
                templateUrl: 'ArticleList.html',
                controller: 'articleList'
            })
            .state('company', {
                url: '/company',
                templateUrl: 'companyList.html'
            })
            .state('add', {
                url: '/add',
                templateUrl: 'add.html',
                controller: 'addimg'
            })

    }]);










