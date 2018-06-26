angular.module('App')
.filter('changeType', function () {
    var changeType = ['首页Banner', '找精英Banner', '找职位Banner', '行业大图'];
    return function (type) {
        return type = changeType[type];
    }
})
.filter('changeStatus', function () {
    var changeStatus = ['草稿', '上线'];
    return function (status) {
        return status = changeStatus[status - 1];
    }
})
.filter('changeAfk', function () {
    var changeAfk = ['上线', '下线'];
    return function (status) {
        return status = changeAfk[status - 1];
    }
});