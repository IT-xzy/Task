var app = angular.module('app', ['ui.router', 'angular-sortable-view', 'ui.bootstrap', 'angularFileUpload', 'oc.lazyLoad']);
app.constant('ajaxAds', {
    login: '/carrots-admin-ajax/a/login',
    logOut: '/carrots-admin-ajax/a/logout',
    article: {
        editItem: '/carrots-admin-ajax/a/u/article/',//编辑put，新增post，删除delete
        status: '/carrots-admin-ajax/a/u/article/status',
        aItem: '/carrots-admin-ajax/a/article/',
        searchItem: '/carrots-admin-ajax/a/article/search',
        imgUpload: '/carrots-admin-ajax/a/u/img/task'
    },
    profession: {
        geiItems: '/carrots-admin-ajax/a/profession/search',
        aItem: '/carrots-admin-ajax/a/profession/',
        editItem: '/carrots-admin-ajax/a/u/profession/',//编辑put，新增post，删除delete
        itemStatus: '/carrots-admin-ajax/a/u/profession/status'
    }
});
