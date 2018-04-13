angular.module("app")
    .factory('serviceHTTP', function ($http, httpURL) {    //创建一个自定义服务
        return {
            loginHTTP: function (data) {
                return $http({
                    url: httpURL.loginURL,
                    method: "POST",
                    params: data,
                    headers: {
                        "content-type": "application/x-www-form-urlencoded"
                    }
                })
            },
            // logoutHTTP: function () {
            //     return $http({
            //         url: serviceURL.logoutURL,
            //         method: 'POST'
            //     })
            // },
            searchHTTP: function (params) {
                return $http({
                    url: httpURL.searchURL,
                    method: "GET",
                    params: params,
                    headers: {
                        "content-type": "application/x-www-form-urlencoded"
                    }
                })
            },
            statusHTTP: function (status) {
                return $http({
                    url: httpURL.statusURL,
                    method: "PUT",
                    params: status,
                    headers: {
                        "content-type": "application/x-www-form-urlencoded"
                    }
                })
            },
            deleteHTTP: function (id) {
                return $http({
                    url: httpURL.deleteURL +id ,
                    method: 'DELETE'
                })
            },
            articleHTTP: function (id) {
                return $http({
                    url: httpURL.articleURL + id,
                    method: 'GET',
                })
            },
            editHTTP: function (id, obj) {
                return $http({
                    url: httpURL.deleteURL + id,
                    method: "PUT",
                    data:obj,
                    headers: {
                        "content-type": "application/x-www-form-urlencoded"
                    }
                })
            },
            newHTTP: function (imgParams) {
                return $http({
                    url: httpURL.deleteURL,
                    method: "POST",
                   params:imgParams,
                    headers: {
                        "content-type": "application/x-www-form-urlencoded"
                    }
                })
            },
            imgHTTP: function (formdata) {
                return $http({
                    url: httpURL.imgURL,
                    method: "POST",
                    data: formdata,
                    // uploadEventHandlers: {
                    //     progress: function (d) {
                    //         $scope.bbb = d.loaded;
                    //         $scope.aaa = d.total;
                    //     }
                    // },
                    headers: {
                        "content-type": undefined
                    }
                })
            }
        }
    })