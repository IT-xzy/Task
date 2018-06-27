//自定义过滤器
myApp
.filter("types", function () {
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
.filter('statuses', function () {
    return function (status) {
        switch (status) {
            case 1:
                return '草稿';
            case 2:
                return '上线';
        }
    }
})
.filter('btns', function () { //上线下线按钮过滤
    return function (status) {
        switch (status) {
            case 1:
                return '上线';
            case 2:
                return '下线';
        }
    }
})