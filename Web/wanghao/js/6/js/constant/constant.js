angular.module("myApp")
    .constant('articleConstant', { //articleCOnstant列表常量
        headtitle: [ //列表名称数组
            "ID", '名称', '类型', '发布时间', '修改时间', '发布者', '状态', '操作'
        ],
        typeItem: [{ //type列表
            type: '全部',
            num: undefined
        }, {
            type: '首页banner',
            num: 0
        }, {
            type: '找职位banner',
            num: 1
        }, {
            type: '找精英banner',
            num: 2
        }, {
            type: '行业大图',
            num: 3
        }],
        statusItem: [{ //status列表
            status: "全部",
            num: undefined
        }, {
            status: '上线',
            num: 2
        }, {
            status: '草稿',
            num: 1
        }]

    })
    .constant("backstageConstant", { //后台页左边菜单的常量
        reader: [{ //循环填入列表数据
                show: true,
                headlink: "信息管理",
                menu: [{
                        title: '公司信息'
                    },
                    {
                        title: '职位信息'
                    }
                ]
            },
            {
                show: true,
                headlink: "Acrticle管理",
                menu: [{
                        link: 'u.article',
                        title: 'Acrticle列表'
                    },
                    {
                        link: undefined,
                        title: '文章管理'
                    },
                    {
                        link: undefined,
                        title: '文章管理',
                    }
                ]
            }, {
                show: true,
                headlink: "用户管理",
                menu: [{
                    title: '用户列表',
                }]
            }
        ]
    })
    .constant('addtype',{
        industry:[
            {
                title:'请选择',
                num:undefined
            },
            {
                title:'移动互联网',
                num:0,
            },
            {
                title:'电子商务',
                num:1,
            },
            {
                title:'企业服务',
                num:2,
            }, {
                title:'O2O',
                num:3,
            },
            {
                title:'教育',
                num:4,
            },
            {
                title:'金融',
                num:5,
            },
            {
                title:'游戏',
                num:6,
            },
           

        ]
    })
    .value("WW",123)