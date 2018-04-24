app
    // 类型
    .constant("types",{
        0: "首页Banner",
        1: "找职位Banner",
        2: "找精英Banner",
        3: "行业大图"
    })
    // 状态
    .constant("status",{
        1: "草稿",
        2: "上线"
    })
    // 上下线
    .constant("line",{
        1: "上线",
        2: "下线"
    })
    // 类型为行业大图时要选择的项
    .constant("industry",{
        0: "移动互联网",
        1: "电子商务",
        2: "企业服务",
        3: "O2O",
        4: "教育",
        5: "金融",
        6: "游戏"
    })
    // 侧边栏
    .constant("sidebarList",[
        {
            firstLevel: "信息管理",
            secondLevel:[
                {title: "公司列表", url: ""},
                {title: "职位列表", url: "1"}
            ],
            isShow: false
        },
        {
            firstLevel: "Article管理",
            secondLevel:[
                {title: "Article列表", url: "home.article_list"},
                {title: "文章管理", url: ""}
            ],
            isShow: false
        },
        {
            firstLevel: "用户管理",
            secondLevel:[
                {title: "用户列表", url: ""}
            ],
            isShow: false
        },
        {
            firstLevel: "内容管理",
            secondLevel:[
                {title: "视频管理", url: ""}
            ],
            isShow: false
        }
    ])