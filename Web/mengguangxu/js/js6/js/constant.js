myApp
//类型
.constant('list',{
    0:'首页banner',
    1:'找职位banner',
    2:'找精英banner',
    3:'行业大图'
})
//状态
.constant('listStatus',{
    1:'草稿',
    2:'上线'
})
//上下线
.constant('down',{
    1:'上线',
    2:'下线'
})
//新增，编辑
.constant('industry1',{
    0:'移动互联网',
    1:'电子商务',
    2:'企业服务',
    3:'O2O',
    4:'教育',
    5:'金融',
    6:'游戏'
})
.constant("sidebarList",[
    {
        firstLevel: "信息管理",
        secondLevel:[
            {title: "公司列表", url: ""},
            {title: "职位列表", url: ""}
        ]
    },
    {
        firstLevel: "Article管理",
        secondLevel:[
            {title: "Article列表", url: "backstage.list"},
            {title: "文章管理", url: ""}
        ]
    },
    {
        firstLevel: "用户管理",
        secondLevel:[
            {title: "用户列表", url: ""}
        ]
    },
    {
        firstLevel: "内容管理",
        secondLevel:[
            {title: "视频管理", url: ""}
        ]
    }
]);