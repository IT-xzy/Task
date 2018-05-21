app
    .constant('articleStatus', [{
        status: '',
        name: '请选择'
    }, {
        status: 1,
        name: '草稿'
    },
        {
            status: 2,
            name: '上线'
        }

    ])
    .constant('articleType', [{
        type: '',
        name: '请选择'
    }, {
        type: 0,
        name: '首页banner'
    }, {
        type: 1,
        name: '找职位banner'
    },
        {
            type: 2,
            name: '找精英banner'
        },
        {
            type: 3,
            name: '行业大图'
        }

    ])
    .constant('articleIndustry', [{
        type: '',
        name: '请选择'
    },
        {
            type: 0,
            name: '移动互联网'
        },
        {
            type: 1,
            name: '电子商务'
        },
        {
            type: 2,
            name: '企业服务'
        },
        {
            type: 3,
            name: 'O2O'
        },
        {
            type: 4,
            name: '教育'
        },
        {
            type: 5,
            name: '金融'
        },
        {
            type: 6,
            name: '游戏'
        }

    ]).constant('$httpSend', {
    type: '',
    status: '',
    startAt: '',
    endAt: '',
    page: 1,
    size: 10,
    createAt: '',
    updateAt: '',
    url: '',
    industry: '',
    img: '',
    title: '',
    author: ''
})