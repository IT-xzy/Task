var app=angular.module('app')
.factory('timeConver',function(){
    return {
        startTime:function(date){
            //转换标准时间为时间戳
            date=(isNaN(date))?undefined: Date.parse(new Date(date));
            return date;
        },
        endTime:function(date){
            date=(isNaN(date))?undefined:(Date.parse(new Date(date))+86399999);
            return date;
        }
    };
});