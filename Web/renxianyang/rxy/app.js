var app = angular.module('app', ['ui.router', 'ui.bootstrap', 'angularFileUpload', 'oc.lazyLoad']);
app.constant('ajaxAds', {
    login: '/carrots-admin-ajax/a/login',
    logOut: '/carrots-admin-ajax/a/logout',
    editItem: '/carrots-admin-ajax/a/u/article/',//编辑put，新增post，删除delete
    status: '/carrots-admin-ajax/a/u/article/status',
    aItem: '/carrots-admin-ajax/a/article/',
    searchItem: '/carrots-admin-ajax/a/article/search',
    imgUpload: '/carrots-admin-ajax/a/u/img/task'
});
