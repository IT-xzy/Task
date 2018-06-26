var app=angular.module('myApp',['ui.router','ngMessages','ui.bootstrap','ng.ueditor'])
.config(function ($stateProvider) {
    $stateProvider
        .state('loginState',{
            url:'/login',
            templateUrl:'pages/loginPage.html',
            controller:'loginPage'
        })
        .state('frameState',{
            url:'/mainFrame',
            templateUrl:'pages/mainFrame.html',
            controller: 'frameCtrl'
        })
        .state('frameState.companyList',{
            url:'/companyList',
            templateUrl:'pages/companyList.html'
        })
        .state('frameState.positionList',{
            url:'/positionList',
            templateUrl:'pages/positionList.html'
        })
        .state('frameState.articleList',{
            url:'/articleList?startAt&endAt&type&status&size&page&id&createAt&url&updateAt',
            templateUrl:'pages/articlePage.html',
            controller:'articleListCtrl'
        })
        .state('frameState.addArticleList',{
            url:'/addArticleList?id',
            templateUrl:'pages/addArticleList.html',
            controller:'addListCtrl'
        })
        .state('frameState.usersManage',{
            url:'/usersManage',
            templateUrl:'pages/usersManage.html'
        })
});
app.run(function ($state) {
    $state.go('loginState');
});