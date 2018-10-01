angular.module('myApp')

    // 请求服务封装
    .factory('userService', function ($http, _path) {
        return {
            //登陆接口请求
            login: function (params) {
                return $http.post(_path.login(), params)
            },
            //退出接口地址
            logout: function (params) {
                return $http.post(_path.logout(), params)
            },
            //article管理部分
            //新增article
            addArticle: function (params) {
                return $http.post(_path.addArticle(), params)
            },
            //编辑article
            redactArticle: function (id, params) {
                return $http.put(_path.redactArticle(id), params)
            },
            //修改上线下线
            articleStatus: function (params) {
                return $http.put(_path.articleStatus(), params)
            },
            //删除article
            deleteArticle: function (id) {
                return $http.delete(_path.deleteArticle(id))
            },
            //获得单个article
            oneArticle: function (id, params) {
                return $http.get(_path.oneArticle(id), params)
            },
            //按条件获得article列表
            searchArticle: function (params) {
                return $http({
                    method: 'GET',
                    url: _path.searchArticle(),
                    params: params
                })
            },
            //上传图片
            postImg: function (params) {
                return $http({
                    method: 'post',
                    url: _path.postImg(),
                    data: params,
                    headers: {
                        'Content-Type': undefined
                    },
                    transformRequest: function (data) {
                        return data
                    }
                })
            }
        }
    })


    // putMemberActive: function (params) {
    //     return $http({
    //         url: _path.memberActive(),
    //         method: "put",
    //         headers: {'Content-Type': 'application/json;charset=UTF-8'},
    //         data: JSON.stringify(params),
    //         transformRequest: function (data, headersGetter) {
    //             return data;
    //         }
    //     });
    // },