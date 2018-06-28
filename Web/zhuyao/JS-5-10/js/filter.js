angular.module('myApp')
    .filter('statusFilter', function () {
        return function (status) {
            switch (status) {
                case 1:
                    return '草稿';
                case 2:
                    return '上线';
            }
        }
    })
    .filter('typeFilter', function () {
        return function (type) {
            switch (type) {
                case 0:
                    return '首页banner';
                case 1:
                    return '找职位banner';
                case 2:
                    return '找精英banner';
                case 3:
                    return '行业大图';
            }
        }
    })
    .filter('statusTextFilter', function () {
        return function (status) {
            switch (status) {
                case 1:
                    return '上线';
                case 2:
                    return '下线';
            }
        }
    })
    .filter('sizeFilter', function () {
        return function (size) {
            return (size / 1024 / 1024).toFixed(2) + 'MB'
        }
    });