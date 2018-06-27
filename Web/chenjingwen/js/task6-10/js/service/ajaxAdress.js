var app=angular.module('app');
app.factory('pathProject', function () {
        return {
            //Article管理
            //Article列表接口
            getArticlelist_url:"/carrots-admin-ajax/a/article/search",  
            // 获取article
            getArticle_url: function (id) {
                return "/carrots-admin-ajax/a/article/" + id;
            },
            // 新增article
            addArticle_url: "/carrots-admin-ajax/a/u/article",
            // 删除article
            delArticle_url: function (id) {
                return '/carrots-admin-ajax/a/u/article/' + id;
            },
            // 编辑article
            editArticle_url: function (id) {
                return "/carrots-admin-ajax/a/u/article/" + id;
            },
            //修改article的上架/下架
            changeArticleStatus_url: function (id, status) {
                return "/carrots-admin-ajax/a/u/article/status?id=" + id + "&status=" + status;
            }         
        };
    });