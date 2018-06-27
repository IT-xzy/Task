
//类型过滤器
app.filter('typeFilter', function () {
   return function (types) {
       switch (types){
           case 0: return'首页banner';
           case 1: return'找职位banner';
           case 2: return'找精英banner';
           case 3: return'行业大图';
       }
   };
});


//状态过滤器
app.filter('statusFilter', function () {
   return function (status) {
       switch (status){
           case 1: return'草稿';
           case 2: return'上线';
       }
   };
});


//上下线按钮过滤器
app.filter('statusChange', function () {
    return function (status) {
        switch (status){
            case 1: return'上线';
            case 2: return'下线';
        }
    };
});