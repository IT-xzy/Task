angular.module('App')
    .constant('myConstantType', [
        {value: 0, name: '首页Banner'},
        {value: 1, name: '精英Banner'},
        {value: 2, name: '职位Banner'},
        {value: 3, name: '行业大图'}
    ])
    .constant('myConstantStatus', [
        {value: 1, name: '草稿'},
        {value: 2, name: '上线'}
    ])
    .constant('myIndustryData', [
        {name: '移动互联网', value: 0},
        {name: '电子商务', value: 1},
        {name: '企业服务', value: 2},
        {name: 'O2O', value: 3},
        {name: '教育', value: 4},
        {name: '金融', value: 5},
        {name: '游戏', value: 6}
    ]);
