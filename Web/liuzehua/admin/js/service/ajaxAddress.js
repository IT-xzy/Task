angular.module('myApp')
    // 地址url服务封装
    .factory('_path', function () {
        return {
            //登陆接口地址
            login: function () {
                return 'carrots-admin-ajax/a/login'
            },
            //退出接口地址
            logout: function () {
                return 'carrots-admin-ajax/a/logout'
            },
            //article管理部分
            //新增article
            addArticle: function () {
                return 'carrots-admin-ajax/a/u/article'
            },
            //编辑article
            redactArticle: function (id) {
                return 'carrots-admin-ajax/a/u/article/' + id
            },
            //修改上线下线
            articleStatus: function () {
                return 'carrots-admin-ajax/a/u/article/status'
            },
            //删除article
            deleteArticle: function (id) {
                return 'carrots-admin-ajax/a/u/article/' + id
            },
            //获得单个article
            oneArticle: function (id) {
                return 'carrots-admin-ajax/a/article/' + id
            },
            //按条件获得article列表
            searchArticle: function () {
                return 'carrots-admin-ajax/a/article/search'
            },
            //上传图片
            postImg: function () {
                return 'carrots-admin-ajax/a/u/img/task'
            }

        }
    })