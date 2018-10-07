// 定义常量
angular.module("myApp")
    .constant("articleConstant", {
        typeItem: [{
            type: "全部",
            num: undefined
        }, {
            type: "首页banner",
            num: 0
        }, {
            type: "找职位banner",
            num: 1
        }, {
            type: "找精英banner",
            num: 2
        }, {
            type: "行业大图",
            num: 3
        }],
        statusItem: [{
            status: "全部",
            num: undefined
        }, {
            status: "草稿",
            num: 1
        }, {
            status: "上线",
            num: 2
        }],
        industryItem: [{
            industry: "移动互联网",
            num: 0
        }, {
            industry: "电子商务",
            num: 1
        }, {
            industry: "企业服务",
            num: 2
        }, {
            industry: "O2O",
            num: 3
        }, {
            industry: "教育",
            num: 4
        }, {
            industry: "金融",
            num: 5
        }, {
            industry: "游戏",
            num: 6
        }],
        addType: [{
            type: "首页banner",
            num: 0
        }, {
            type: "找职位banner",
            num: 1
        }, {
            type: "找精英banner",
            num: 2
        }, {
            type: "行业大图",
            num: 3
        }],
    })
    .value("articleConstant", 123)