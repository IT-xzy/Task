myApp.factory('selected',function () {
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
        }]
    };
});
