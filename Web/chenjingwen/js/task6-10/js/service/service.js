var app = angular.module('app');
app.factory('articleOper', function ($http, pathProject) {
    return {
        //获取列表
        getList: function ($stateParams) {
            return $http.get(pathProject.getArticlelist_url, {
                params: $stateParams
            });
        },
        //获取Article
        getArticle: function (id) {
            return $http.get(pathProject.getArticle_url(id));
        },
        //删除Article
        deleList: function (id) {
            return $http.delete(pathProject.delArticle_url(id));
        },
        //新增Article
        addList: function (params) {
            return $http.post(pathProject.addArticle_url,params);
        },
        //编辑Article
        editList: function (id, params) {
            return $http.put(pathProject.editArticle_url(id), params);
        },
        //上下线切换
        toggleList: function (id, status) {
            return $http.put(pathProject.changeArticleStatus_url(id, status));
        }
    };
});



