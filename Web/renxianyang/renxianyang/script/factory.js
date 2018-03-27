app.factory('isLogin', function () {
    //检测登录
    return function () {
        if (localStorage.self) {
            var self = JSON.parse(localStorage.self);
            if (self.message == 'success' && self.code == 0) {
                return {
                    isLogin: true,
                    self: self,
                };
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}).factory('hasHistory', function () {
    return function () {
        var history;
        if (sessionStorage.history) {
            history = JSON.parse(sessionStorage.history);
        } else {
            history = {};
        }
        return history;
    }
}).factory('dateToNum', function () {
    return function (date) {
        var reg = /^\d+$/;
        if (!date) {
            //日历插件清空按钮会是 null
            return '';
        } else if (reg.test(date)) {
            return date;
        } else {
            return Date.parse(date);
        }
    }
}).factory('getStatusInfo', function () {
    //上线下线
    return function (status) {
        switch (status) {
            case true:
                return {
                    status: false,
                    content: ['上线后该将在前台展示!', '是否执行上线操作？'],
                };
            case false:
                return {
                    status: true,
                    content: ['上线后该将不在前台展示!', '是否执行下线操作？'],
                };
            default:
                return 'An error has occurred';
        }
    }
}).factory('$httpTools', function ($http, $q) {
    return {
        put: function (ads, data, async) {
            let promise = $http({
                method: 'PUT',
                url: ads,
                params: async ? '' : data,
                data: async ? data : '',
            });
            return promise;
        },
        get: function (ads, data) {
            let promise = $http({
                method: 'GET',
                url: ads,
                params: data
            });
            return promise;
        },
        post: function (ads, data) {
            //如果没有data传入，请传入一个空的字符串
            let promise = $http({
                method: 'POST',
                url: ads,
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded',
                },
                transformRequest: function (data) {
                    return $.param(data); //参数化
                },
                data: data,
            });
            return promise;
        },
        delete: function (ads, data) {
            let promise = $http({
                method: 'delete',
                url: ads,
                params: data
            });
            return promise;
        },
        uploadImg: function (ads, data, timeout) {
            var sendData = new FormData();
            var defer = $q.defer();
            sendData.append('file', data);
            var promise = $http({
                method: 'post',
                url: ads,
                //@#$%^&*()
                //重要,不然angular会序列化FormData
                transformRequest: angular.identity,
                //设置headers，重要
                headers: {
                    'content-type': undefined
                },
                //@#$%^&*()
                data: sendData,
                timeout: defer.promise,
            });
            promise.abort = function () {
                defer.resolve();
                //这个方法。。。算$http 请求超时，所以$http 返回的promise ，会执行第二个回调函数
                return true;
            }
            return promise;
        }
    }
})