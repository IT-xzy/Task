myApp
//类型
.filter('typeFilter',function(){
    return function(types){
        switch(types){
            case 0:
                return '首页banner';
            case 1:
                return '找职位banner';
            case 2:
                return '找精英banner';
            case 3:
                return '行业大图';
        }
    };
})
//状态
.filter('statusFilter',function(){
    return function(listStatus){
        switch(listStatus){
            case 1:
                return '草稿';
            case 2:
                return '上线';
        }
    }
})
//上下线
.filter('downFilter',function(){
    return function(down){
        switch(down){
            case 1:
                return '上线';
            case 2:
                return '下线';
        }
    }
})
//新增，编辑
.filter('articleFilter',function(){
    return function(industry){
        switch(industry){
            case 0:
                return '移动互联网';
            case 1:
                return '电子商务';
            case 2:
                return '企业服务';
            case 3:
                return 'O2O';
            case 4:
                return '教育';
            case 5:
                return '金融';
            case 6:
                return '游戏';
        }

    }
})
.filter("contentFilter", function ($sce) {
    return function (text) {
        return $sce.trustAsHtml(text);
    }
});


