angular.module('myApp')
    .constant(
        'articleConstant', {
            type: [{
                    name: '全部',
                    num: null
                },
                {
                    name: '首页',
                    num: 0
                },
                {
                    name: '找职位',
                    num: 1
                },
                {
                    name: '找精英',
                    num: 2
                },
                {
                    name: '行业大图',
                    num: 3
                }
            ],
            status: [{
                    name: '全部',
                    num: null
                },
                {
                    name: '草稿',
                    num: 1
                },
                {
                    name: '上线',
                    num: 2
                }
            ],
            industry: [
                {
                    name: '请选择',
                    num: null
                },
                {
                    name: '移动互联网',
                    num: 0
                },
                {
                    name: '电子商务',
                    num: 1
                },
                {
                    name: '企业服务',
                    num: 2
                },
                {
                    name: '020',
                    num: 3
                },
                {
                    name: '教育',
                    num: 4
                },
                {
                    name: '金融',
                    num: 5
                },
                {
                    name: '游戏',
                    num: 6
                }
            ]

        })