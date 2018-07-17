angular.module("myApp")
    .filter("indexFilter", function () { //行数过滤器
        return function (index) {
            return index + 1;
        };
    })
    .filter("typeFilter", function () { //type名称过滤器
        return function (type) {
            if (type == 0) return "首页banner";
            if (type == 1) return "找职位banner";
            if (type == 2) return "找精英banner";
            if (type == 3) return "行业大图";
        };
    })
    .filter("statusFilter", function () { //status 状态过滤器
        return function (status) {
            if (status == undefined) return "全部";
            if (status == 1) return "草稿";
            if (status == 2) return "上线";
        };
    })
    .filter("sizeFilter",function(){  //大小过滤
       return function(size){
         if(size){
             return size=size/1000+"KB";
         } 
       }
       
    })
    .filter('statusTypeFilter',function(){
        return function(status){
            if(status==1) return '上线';
            if(status==2) return '下线';
        }
    })
   