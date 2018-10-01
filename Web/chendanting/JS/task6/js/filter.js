//上下线过滤器
app.filter('statusFilter', function (){
    return function (text){
        switch (text){
            case 1: return '草稿'; break;
            case 2: return '上线'; break;
        }
    }
});
// 操作上下线过滤器
app.filter('unStatusFilter', function () {
    return function (text) {
        switch (text) {
            case 1: return '上线'; break;
            case 2: return '下线'; break;
        }
    }
});
// 类型过滤器
app.filter('type', function () {
    return function (text) {
        switch (text) {
            case 0: return '首页banner'; break;
            case 1: return '找职位banner'; break;
            case 2: return '找精英banner'; break;
            case 3: return '行业大图'; break;
        }
    }
});