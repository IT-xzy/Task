var app = angular.module('app');
app.constant('styles',
    {
        0: "首页Banner",
        1: "找职业Banner",
        2: "找精英Banner",
        3: "行业大图",
    }
);
app.constant('states',
    [{ value: undefined, text: "全部" },
    { value: 1, text: "上线" },
    { value: 2, text: "草稿" }]);
app.constant('types',
    [
        { value: undefined, text: "请选择" },
        { value: 0, text: "首页Banner" },
        { value: 1, text: "找职业Banner" },
        { value: 2, text: "找精英Banner" },
        { value: 3, text: "行业大图" }
    ]);
app.constant('industrys',
    [
        { value: undefined, text: "请选择" },
        { value: 0, text: "移动互联网" },
        { value: 1, text: "电子商务" },
        { value: 2, text: "企业服务" },
        { value: 3, text: "O2O" },
        { value: 3, text: "教育" },
        { value: 4, text: "金融" },
        { value: 5, text: "游戏" }
    ]);
app.constant('aaa',
    [{
        name: '信息管理',
        children: ['公司信息', '职位信息']
    }, {
            name: 'Article管理',
            children: ['Artice列表', '文章管理', '内容管理']
        }, {
            name: '用户管理',
            children: ['用户管理']
        }
    ]
);