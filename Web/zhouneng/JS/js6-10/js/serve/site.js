//接口地址方法
angular.module("myApp")
    .factory("site", function () {
        return {
            postLogin:function(){//登录
                return '/carrots-admin-ajax/a/login';
            },
            postLogout:function(){//登出
                return '/carrots-admin-ajax/a/logout';
            },
            getList: function () { //封装获取list列表数据接口为一个方法
                return '/carrots-admin-ajax/a/article/search';
            },
            getListOne: function (id) {//获取单个数据
                return '/carrots-admin-ajax/a/article/'+id
            },
            postAdd: function () {//新增列表
                return '/carrots-admin-ajax/a/u/article';
            },
            putUpdate:function(id){//编辑
                return '/carrots-admin-ajax/a/u/article/'+id;
            },
            putSwops:function(){//修改上架下架
                return '/carrots-admin-ajax/a/u/article/status';
            },
            deleteList:function(id){//删除
                return '/carrots-admin-ajax/a/u/article/'+id
            }
        }
    })