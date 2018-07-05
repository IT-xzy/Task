var app = angular.module('app',['ui.router','ngMessages','ui.bootstrap','ng.ueditor']);

app.config(function ($stateProvider ) {
    $stateProvider
    .state('login',{
        url:'/login',
        templateUrl:'login.html',
        controller:'loginController'
    })
    .state('backGround',{
        url:'/backGround',
        templateUrl:'backGround.html',
        controller:'backController'
    })
    .state('backGround.dashBoard',{
        url:'/dashBoard',
        templateUrl:'dashBoard.html'
    })
    .state('backGround.artList',{
        url:'/artList?startAt&endAt&type&status&size&page&id',
        templateUrl:'artList.html',
        controller:'artList',
    })
    .state('backGround.articleDetail',{
        url:'/articleDetail?id',
        templateUrl:'articleDetail.html',
        controller:'articleDetail',
    })

});

app.run(function($state){
    $state.go('login')
});

app.controller('mainController',function () {

});


