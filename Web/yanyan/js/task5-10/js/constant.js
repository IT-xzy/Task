angular.module('myApp')
    .constant("type", [
          {code: 0, name: '首页banner'},
          {code: 1, name: '找职位banner'},
          {code: 2, name: '找精英banner'},
          {code: 3, name: '行业大图'}
])
    .constant("industry", [
        {code: 0, name: '移动互联网'},
        {code: 1, name: '电子商务'},
        {code: 2, name: '企业服务'},
        {code: 3, name: 'O2O'},
        {code: 4, name: '教育'},
        {code: 5, name: '金融'},
        {code: 6, name: '游戏'}
    ])
    .constant("status", [
        {code: 1, name: '草稿'},
        {code: 2, name: '上线'}
    ])
    .constant("statusONOFF", [
        {code: 1, name: '上线'},
        {code: 2, name: '下线'}
    ])
;


