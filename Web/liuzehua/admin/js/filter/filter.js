angular.module('myApp')

    .filter('type', function () {
        return function (type) {
            switch (type) {
                case 0:
                    return '首页';
                case 1:
                    return '找职位';
                case 2:
                    return '找精英'
                case 3:
                    return '行业大图';
            };
        }
    })
    .filter('status', function () {
        return function (data) {
            switch (data) {
                case 1:
                    return '草稿';
                case 2:
                    return '上线';
            };
        }
    })
    .filter('statusTxt', function () {
        return function (data) {
            switch (data) {
                case 1:
                    return '上线';
                case 2:
                    return '下线';
            };
        }
    })
    .filter('time', function () {
        return function (time) {
            var date = new Date(time); //如果date为10位不需要乘1000  
            var Y = date.getFullYear() + '-';
            var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
            var D = (date.getDate() < 10 ? '0' + (date.getDate()) : date.getDate()) + ' ';
            var h = (date.getHours() < 10 ? '0' + date.getHours() : date.getHours()) + ':';
            var m = (date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes()) + ':';
            var s = (date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds());
            return Y + M + D + h + m + s;
        }
    })
    .filter('timeStamp', function () {
        return function (date) {
            date = JSON.stringify(date);
            console.log(typeof date)
            date = date.replace(/T/g, '/');
            // date = new Date(date);
            // date = date.getTime();
            // return date;
        }
    })