angular.module("myApp")
    .constant('sidebar',[
        {
            first:'信息管理',
            second:[
                {title:'公司列表',url:''},
                {title:'职位列表',url:''},
            ]
        },
        {
            first:'Article管理',
            second:[
                {title:'Article列表',url:'backstage.list'},
                {title:'文章管理',url:''},
                {title:'文章',url:''}
            ]
        },
        {
            first:'用户管理',
            second:[
                {title:'用户列表',url:''},
                {title:'后台',url:'backstage'}
            ]
        }
    ])
    .constant('picktype',[
        { value: undefined ,text:"全部"},
        { value:0 ,text:"首页banner"},
        { value:1 ,text:"找职位banner"},
        { value:2 ,text:"找精英banner"},
        { value:3 ,text:"行业大图"}
    ])
    .constant('pickstatus',[
        { value: undefined ,text:"全部"},
        { value:1 ,text:"草稿"},
        { value:2 ,text:"上线"}
    ])
    .constant('picktype_add',[
    { value:0 ,text:"首页banner"},
    { value:1 ,text:"找职位banner"},
    { value:2 ,text:"找精英banner"},
    { value:3 ,text:"行业大图"}
])
    .constant('pick_industry',[
    { value:0 ,text:"移动互联网"},
    { value:1 ,text:"电子商务"},
    { value:2 ,text:"企业服务"},
    { value:3 ,text:"O2O"},
    { value:4 ,text:"教育"},
    { value:5 ,text:"金融"},
    { value:6 ,text:"游戏"}
]);
