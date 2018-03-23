'use strict';

angular.module('App')
    
    //过滤类型
    .filter("ChangeType", function (myConstant) {
        return function (a) {
            for(var i=0;i<myConstant.length;i++){
                if(a==myConstant[i].type){
                    return myConstant[i].name;
                }
            }
        }
    })
        
    //过滤状态
    .filter("ChangeStatus", function (myStatus) {
        return function (a) {
            for(var i=0;i<myStatus.length;i++){
                if(a==myStatus[i].type){
                    return myStatus[i].name;
                }
            }
        }
    });
