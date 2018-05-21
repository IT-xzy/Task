angular.module('myApp')
    .factory('lists',function () {
        return [
            {site : '全部',id : null},
            {site : '首页banner',id : 0},
            {site : '找职位banner',id : 1},
            {site : '找精英',id : 2},
            {site : '行业大图',id : 3}
        ];

    })
    .factory('lists2',function () {
        return [
            {site : '全部',id :null},
            {site : '草稿',id : 1},
            {site : '上线',id : 2}
        ]

    })
    .factory('lists3',function () {
        return [
            {site : '请选择',id : 4 },
            {site : '首页banner', id : 0},
            {site : '找职位banner',id : 1},
            {site : '找精英',id : 2},
            {site : '行业大图',id : 3}
        ];

    })
    .factory('lists4',function () {
        return [
            {site : '请选择',id : 7 },
            {site : '移动互联网', id : 0},
            {site : '电子商务',id : 1},
            {site : '企业服务',id : 2},
            {site : 'o2o',id : 3},
            {site : '教育',id : 4},
            {site : '金融',id : 5},
            {site : '游戏',id : 6}
        ];

    })
    .factory('stateLink',function () {
        return {

        }
    })
