'use strict';

angular.module('App')
    //类型字段约定
    .constant('myConstant',[
        {type : '0' , name : '首页banner'},
        {type : '1' , name : '找职位banner'},
        {type : '2' , name : '找精英banner'},
        {type : '3' , name: '行业大图'}
    ])
    
    //状态字段约定
    .constant('myStatus',[
        {type : '1' , name : '草稿'},
        {type : '2' , name : '上线'},
        {type : '3' , name : '下线'}
    ]);



