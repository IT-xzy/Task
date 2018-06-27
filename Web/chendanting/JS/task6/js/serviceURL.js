angular.module("myApp").factory("serviceURL", function() {
    return {
        loginURL: "/carrots-admin-ajax/a/login",
        logoutURL: "/carrots-admin-ajax/a/logout",
        searchURL: "/carrots-admin-ajax/a/article/search",
        offlineURL: "/carrots-admin-ajax/a/u/article/status",
        addURL: "/carrots-admin-ajax/a/article/",
        articleURL: "/carrots-admin-ajax/a/u/article/",
        uploadURL: "/carrots-admin-ajax/a/u/img/task"
    };
});
