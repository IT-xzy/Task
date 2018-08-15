var myApp = angular.module("myApp", ['ui.router', 'ngMessages', 'ngAnimate', 'ngSanitize', 'ui.bootstrap', 'textAngular', 'ngFileUpload', 'ui.sortable']);
myApp
    .config(function ($stateProvider, $urlRouterProvider, $locationProvider, $provide) {

        // 消除!
        $locationProvider.hashPrefix('');

        // // 清除#   更改url格式配置为html5，去掉#号,这个没用
        // $locationProvider.html5Mode({
        //     enable: true,
        //     requireBase: false
        // });

        // 设置默认页面
        $urlRouterProvider.otherwise('/login');

        $stateProvider
            // 这个顺序，login不要获取bootstrap的cdn
            .state('login', {
                url: '/login',
                templateUrl: 'login.html',
                controller: "login"
            })
            .state('backstage', {
                url: '/backstage',
                templateUrl: 'html/backstage.html'
            })

            .state('backstage.list', {
                url: '/list?page&status&type&size&startAt&endAt',
                // url传参数
                templateUrl: 'html/articleList.html',
                // controller:"list"
            })

            .state('backstage.add', {
                url: '/add?id',
                templateUrl: 'html/articleAdd.html',
            })

            .state('backstage.admin', {
                url: '/admin',
                templateUrl: 'html/admin.html'
            })

        //富文本配置----------
        // $provide.decorator('taOptions', ['$delegate', function (taOptions) {
        //     taOptions.toolbar = [
        //         ['h1', 'h2', 'h3', 'p', 'pre', 'quote'],
        //         ['bold', 'italics', 'underline', 'ul', 'ol', 'redo', 'undo', 'clear'],
        //         ['justifyLeft', 'justifyCenter', 'justifyRight', 'justifyFull'],
        //         ['html', 'insertLink']
        //     ];
        //     return taOptions;
        // }]);
    })

// .directive('ppPage',function(){
//     return{
//         restrict:'EA'
//     }
// })



// myApp.factory('locals', ['$windows', function ($windows) {
//     return {
//         set: function (key, value) {
//             $windows.localStorage[key] = value;
//         },
//         get: function (key, value) {
//             return $windows.localStorage[key] || defaultValue;
//         },
//         setObject: function (key, value) {
//             $windows.localStorage[key] = JSON.stringify(value);
//         },
//         getObject: function (key, value) {
//             return JSON.parse($windows.localStorage[key] || '{}');
//         },
//     }
// }])