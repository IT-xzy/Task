// Article列表类型过滤器
app.filter("typeFilter",function () {
    return function (types) {
        switch(types) {
            case 0:
                return "首页banner";
            case 1:
                return "找职位banner";
            case 2:
                return "找精英banner";
            case 3:
                return "行业大图";
        }
    }
})

// Article列表状态过滤器
app.filter("statusFliter",function () {
    return function (status) {
        switch(status) {
            case 1:
                return "草稿";
            case 2:
                return "上线";
        }
    }
})

// 图片大小过滤器
app.filter("changeUnit",function () {
    return function (size,unit) {
        var sizeUnit = null;
        if (!isNaN(size)) {
            switch (unit) { // 可选择byte、KB、MB三种单位
                case "byte":
                    return sizeUnit = size + "byte";
                case "KB":
                    return sizeUnit = Math.round(size/1024) + "KB";
                case "MB":
                    return sizeUnit = (size/1024/1024).toFixed(2) + "MB";
            }
        }
    }
})