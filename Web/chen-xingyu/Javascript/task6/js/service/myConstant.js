app.constant('myTypes',[
    {type:undefined,name:'全部'},
    {type:0,name:'首页Banner'},
    {type:1,name:'找职位Banner'},
    {type:2,name:'找精英Banner'},
    {type:3,name:'行业大图'}
])
.constant('myStatus', [
    {status:undefined,name:'全部'},
    {status:1,name:'草稿'},
    {status:2,name:'上线'}
])
.constant('sidebar', [
    {
        firstLevel: '信息管理',
        secondLevel: [
            {title: '公司列表',url: '.companyList'},
            {title: '职位列表',url: '.companyList'}
        ]
    },
    {
        firstLevel: 'Article管理',
        secondLevel: [
            {title: '文章列表',url: '.articleList'},
            {title: 'Article列表',url: '.articleList'},
            {title: 'wenzhang列表',url: '.articleList'}
        ]
    },
    {
        firstLevel: '用户管理',
        secondLevel: [
            {title: '用户列表',url: '.positionList'},
            {title: '列不列随便',url: '.positionList'}
        ]
    }
])
.constant('myIndustry',{
    0:'移动互联网',
    1:'电子商务',
    2:'企业服务',
    3:'O2O',
    4:'教育',
    5:'金融',
    6:'游戏'
});