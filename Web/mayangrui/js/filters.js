myApp.filter('typeFilter',function() {
    return function (type) {
        switch (type) {
            case 1:
                return "找职位Banner";
            case 3:
                return "行业大图";
            case 0:
                return "首页Banner";
            case 2:
                return "找精英Banner";
        }
    }
})
    .filter("updatefilter",function () {
        return function (status) {
            switch (status) {
                case 1:
                    return "草稿";
                case 2:
                    return "上线";
            }
        }
    })
.filter("launchfilter",function () {
    return function (status) {
        switch (status) {
            case 1:
                return "上线";
            case 2:
                return "下线";
        }
    }
});

