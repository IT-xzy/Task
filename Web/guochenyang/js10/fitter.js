//过滤器
//
// myApp
// // 类型
//     .filter('filterType', function () {
//         return function (type) {
//             switch (type) {
//                 case 0:
//                     return '首页';
//                 case 1:
//                     return '找职位';
//                 case 2:
//                     return '找精英'
//                 case 3:
//                     return '行业大图';
//             };
//         }
//     })
//     // 状态
//     .filter('filterStatus',function(){
//         return function(status){
//             switch (status){
//                 case 1:
//                     return '草稿';
//                 case 2:
//                     return '上线';
//             }
//         }
//     })
//     // 上下线按钮，与状态相反
//     .filter('filterUnStates',function(){
//         return function(status){
//             switch (status){
//                 case 1:
//                     return '上线';
//                 case 2:
//                     return '下线';
//             }
//         }
//     })


//类型过滤
myApp.filter('filterType', function () {
    return function (type) {
        var changed = '';
        switch (type) {
            case 0: changed = '首页banner'; break;
            case 1: changed = '找职位banner'; break;
            case 2: changed = '找精英banner'; break;
            case 3: changed = '行业大图'; break;
        }
        return changed;
    }
})
//状态过滤
myApp.filter('filterStatus', function () {
    return function (status) {
        var changed = '';
        switch (status) {
            case 1: changed = '上线'; break;
            case 2: changed = '草稿'; break;
        }
        return changed;
    }
})
//按钮过滤
myApp.filter('filterUnStates', function () {
    return function (status) {
        var changed = '';
        switch (status) {
            case 2: changed = '上线'; break;
            case 1: changed = '下线'; break;
        }
        return changed;
    }
})