angular.module('myApp')
    .factory('deg', function ($http, _path) {
        return {
            // 登录服务
            login: function (params) {
                return $http({
                    method: "POST",
                    url: _path.login,
                    params: params,
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded'
                    }
                })
            },
            // 新增article
            addArticle: function (params) {
                return $http({
                    method: 'post',
                    url: 'carrots-admin-ajax/a/u/article',
                    params: params,
                    headers: {
                        'Content-Type': 'Application/json'
                    }
                })
            },
            // 修改上下线服务
            articleStatus: function (id,status) {
                if (status == 1) {
                    status = 2;
                } else {
                    status = 1;
                }
                let params = {
                    id: id,
                    status: status
                }
                return $http({
                    method: 'PUT',
                    url: _path.articleStatus,
                    params: params,
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded'
                    }
                })
            },
            // 删除arcticle
            deleteArticle: function (id) {
                return $http({
                    method: 'delete',
                    url: _path.deleteArticle(id),
                    params: id,
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded'
                    }
                })
            },
            // 获得单个article
            oneArticle: function (id) {
             return   $http({
                    method: 'get',
                    url: _path.oneArticle(id),
                })
            },
            // 按条件获得article列表
            seachArticle:function(params,page,size){
                return $http({
                    method: 'get',
                    url: _path.seachArticle(page,size),
                    params:params,
                    headers: {
                        'Content-Type': 'Application/json'
                    },
                })
            },
            // 页面跳转
            pageArticle: function ( page, size) {
                return $http({
                    method: 'get',
                    url: _path.pageArticle(page, size),
                    headers: {
                        'Content-Type': 'Application/json'
                    },
                })
            },
            // 图片请求
            img: function (params) {
                return $http({
                    method: 'post',
                    url: "carrots-admin-ajax/a/u/img/task",
                    data: params,
                    headers: {
                        'Content-Type': undefined
                    },
                })
            }
        }
    })