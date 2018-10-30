// 请求方法
angular.module("myApp")
    .factory("beg", function ($http, site) {
        return {
            postLogin: function (params) { //登录
                return $http.post(site.postLogin(), params)
            },
            postLogout: function () {//登出
                return $http.post(site.postLogout())
            },
            getList: function (params) { //list获取列表请求
                return $http.get(site.getList(), { //调用site地址方法,后面带()为调用，没有()为引用
                    params: params //传参
                });
            },
            getListOne: function (id) { //获取单个数据
                return $http.get(site.getListOne(id))
            },
            postAdd: function (params) { //新增列表
                return $http.post(site.postAdd(), params)
            },
            putUpdate: function (params) { //编辑
                return $http.put(site.putUpdate(params.id), params)
            },
            putSwops: function (params) { //修改上架下架
                return $http.put(site.putSwops(), params)
            },
            deleteList: function (id) { //删除
                return $http.delete(site.deleteList(id))
            }
        }
    })