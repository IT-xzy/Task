app
    .constant('types', {
        0: '首页banner',
        1: '找职位banner',
        2: '找精英banner',
        3: '行业大图',
    })

    .constant('status', {
        1: '草稿',
        2: '上线',
    })

    .constant('industry', {
        0: '移动互联网',
        1: '电子商务',
        2: '企业服务',
        3: '020',
        4: '教育',
        5: '金融',
        6: '游戏',
    })

    .constant('sideBar', [
        {
            sideBarTitle: '信息管理',
            sideBarContent: [
                {sideBarName: '公司列表', url: ''},
                {sideBarName: '职位列表', url: ''},
            ]
        },
        {
            sideBarTitle: 'Article管理',
            sideBarContent: [
                {sideBarName: 'Article列表', url: '.list'},
                {sideBarName: '文章管理', url: ''},
                {sideBarName: '文章管理', url: ''},
            ]
        },
        {
            sideBarTitle: '用户管理',
            sideBarContent: [
                {sideBarName: '用户列表', url: ''},
            ]
        }
    ]);