angular.module("myApp")
    .constant('type', {
        0: '首页banner',
        1:'找职业banner',
        2:'找精英banner',
        3: '行业大图',
    })
    .constant('status', {
        1: '草稿',
        2: '上线',
    })
    .constant('changeStatus',{
        1:'上线',
        2:'下线'
    })
    .constant('industry',{
        0:'移动互联网',
        1:'电子商务',
        2:'企业服务',
        3:'O2O',
        4:'教育',
        5:'金融',
        6:'游戏'
    })
    .value('manageList',[
        {name:'信息管理', data:[{name:'公司列表',statu:"carrots.company-list"},{name:'职位列表',statu:"carrots.company-post"}],show:false},
        {name:'Article管理',data:[{name:'Article列表',statu:"carrots.Artical-list"}],show:false}
    ]);