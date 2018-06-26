angular.module('App')
    .factory('pathProject', function () {
        return {
            //登录
            myLogin_url: "/carrots-admin-ajax/a/login",
            //退出
            outLogin_url: "/carrots-admin-ajax/a/logout",
            //article管理
            //article列表接口
            getArticleList_url: "/carrots-admin-ajax/a/article/search",
            //获取article
            getArticle_url: function (id) {
                return "/carrots-admin-ajax/a/article/"+id;
            },
            //新增article
            addArticle_url: "/carrots-admin-ajax/a/u/article",
            //删除article
            delArticle_url: function (id) {
                return "/carrots-admin-ajax/a/u/article/"+id;
            },
            //编辑article
            editArticle_url: function (id) {
                return "/carrots-admin-ajax/a/u/article/"+id;
            },
            //修改article的上架下架
            changeArticleStatus_url: function (id, status) {
                return "/carrots-admin-ajax/a/u/article/status?id="+id+"&status="+status;
            }
        }
    });
