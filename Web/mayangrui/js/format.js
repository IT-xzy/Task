routerModule.factory('article_style', function () {
    return {
        // status下拉框
        find_status: [{
            id: "",
            name: '全部'
        }, {
            id: 1,
            name: '草稿'
        }, {
            id: 2,
            name: '上线'
        }],

        // 详情、新增页面类型select
        add_select: [{
            id: "",
            name: "请选择"
        }, {
            id: 0,
            name: "首页banner"
        }, {
            id: 1,
            name: "找职位banner"
        }, {
            id: 2,
            name: "找精英banner"
        }, {
            id: 3,
            name: "行业大图"
        }],

        // 当类型为行业大图的时候，显示下面的select
        add_industry: [{
            id: "",
            name: "请选择"
        }, {
            id: 0,
            name: "移动互联网"
        }, {
            id: 1,
            name: "电子商务"
        }, {
            id: 2,
            name: "企业服务"
        }, {
            id: 3,
            name: "O2O"
        }, {
            id: 4,
            name: "教育"
        }, {
            id: 5,
            name: "金融"
        }, {
            id: 6,
            name: "游戏"
        }]
    };
});