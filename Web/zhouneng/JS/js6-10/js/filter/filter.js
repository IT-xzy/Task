// 定义过滤器
angular.module("myApp")
    .filter("indexFilter", function () {//过滤列表数据的index序号
        return function (index) {
            return index + 1;
        };
    })
    .filter("typeFilter", function () {//过滤列表数据的type类型
        return function (type) {
            if (type == 0) {
                return "首页banner";
            } else if (type == 1) {
                return "找职位banner";
            } else if (type == 2) {
                return "找精英banner";
            } else if (type == 3) {
                return "行业大图";
            }
        };
    })
    .filter("statusFilter", function () {//过滤列表数据的status状态
        return function (status) {
            if (status == undefined) {
                return "全部";
            } else if (status == 1) {
                return "草稿";
            } else if (status == 2) {
                return "上线";
            }
        };
    })