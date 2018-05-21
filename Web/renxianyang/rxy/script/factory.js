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
}).factory('isHistory', function () {
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
            console.log(date)
            return date;
        } else {
            console.log(date)
            return Date.parse(date);
        }
    }
}).factory('isStatus', function ($http) {
    //上线下线
    return function (status) {
        switch (status) {
            case 1:
                return {
                    status: 2,
                    content: ['上线后该图片将展示站轮播banner中。', '是否执行上线操作？'],
                };
            case 2:
                return {
                    status: 1,
                    content: ['下线后该图片将不展示站轮播banner中。', '是否执行下线操作？'],
                };
            default:
                return 'An error has occurred';
        }
    }
}).factory('$httpTools', function ($http) {
    return function () {
        var put = function (ads, data) {
            let promise = $http({
                method: 'PUT',
                url: ads,
                params: data
            });
            return promise;
        };
        var get = function (ads, data) {
            let promise = $http({
                method: 'GET',
                url: ads,
                params: data
            });
            return promise;
        };
        var Odelete = function (ads, data) {
            let promise = $http({
                method: 'delete',
                url: ads,
                params: data
            });
            return promise;
        };
        var post = function (ads, data) {
            //如果没有data传入，请传入一个空的字符串
            let promise = $http({
                method: 'POST',
                url: ads,
                headers: {
                    'content-type': 'application/x-www-form-urlencoded',
                },
                transformRequest: function (data) {
                    return $.param(data); //参数化
                },
                data: data,
            });
            return promise;
        };
        return {
            put: put,
            get: get,
            post: post,
            delete: Odelete,
        }
    }
})