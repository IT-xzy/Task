angular.module('myApp').filter('status',function () {
    return function (param) {
        if(param === 1){
            return '草稿';
        }else if(param === 2){
            return '上线';
        }else {
            return '?';
        }
    }
})
.filter('size',function () {
    return function (param) {
        if (param !== null && param !== undefined) {
            return (Number(param) / (1024 * 1024)).toFixed(2)+'MB'
        } else {

        }
    }
})
.filter('online',function () {
    return function (param) {
        if (param === 1) {
            return '上线';
        } else if (param === 2) {
            return '下线';
        } else {
            return '?';
        }
    }

});
app.filter('type',function () {
    return function (param) {
        if (param === 0){
            return "首页banner";
        }else if (param === 1){
            return "找职位banner";
        }else if (param === 2){
            return "找精英";
        }else if (param === 3){
            return "行业大图"
        } else {
            return "?"}
    }
});