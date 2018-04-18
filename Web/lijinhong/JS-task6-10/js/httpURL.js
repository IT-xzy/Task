angular.module("app")
    .factory('httpURL', function () {    //创建一个自定义服务
        return {
            loginURL: "/carrots-admin-ajax/a/login",
            logoutURL: '/carrots-admin-ajax/a/logout',
            searchURL: "/carrots-admin-ajax/a/article/search",
            statusURL: "/carrots-admin-ajax/a/u/article/status",
            articleURL: '/carrots-admin-ajax/a/article/',
            deleteURL: "/carrots-admin-ajax/a/u/article/",
            imgURL: "/carrots-admin-ajax/a/u/img/task"
        }
    })