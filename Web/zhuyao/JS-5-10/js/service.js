angular.module('myApp')
    .factory('urlProject', function () {
        return {
            //Article列表接口
            getArticleList: "/a/article/search",
            // 获取article
            getArticle: function (id) {
                return "/a/article/" + id;
            },
            // 新增article
            addArticle: "/a/u/article",
            // 删除article
            delArticle: function (id) {
                return "/a/u/article/" + id;
            },
            // 编辑article
            editArticle: function (id) {
                return "/a/u/article/" + id;
            },
            //修改article的上架/下架
            changeArticleStatus: function (id, status) {
                return "/a/u/article/status?id=" + id + "&status=" + status;
            }
        }
    })
    .factory('articleService', function ($http, urlProject) {
        return {
            //获取
            getArticleList: function (params) {
                return $http.get(urlProject.getArticleList, {params: params});
            },
            //新增
            addArticle: function (params) {
                return $http.post(urlProject.addArticle, params);
            },
            //删除
            delArticle: function (id) {
                return $http.delete(urlProject.delArticle(id));
            },
            //获取单个
            getArticle: function (id) {
                return $http.get(urlProject.getArticle(id));
            },
            //编辑
            editArticle: function (id, params) {
                return $http.put(urlProject.editArticle(id), params);
            },
            //修改article的上架/下架
            changeArticleStatus: function (id, status) {
                return $http.put(urlProject.changeArticleStatus(id, status));
            }
        }
    });
