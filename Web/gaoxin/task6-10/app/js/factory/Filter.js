app.filter("typefilter",function () {
    var typeFilter  =  ["首页banner ","找职位banner","找精英banner ","行业大图"];
    return function (type) {
        return type =typeFilter[type] ;
    }
}) ;
app.filter("statusfilter",function () {
    var statusFilter  =  ["草稿","上线"];
    return function (status) {
        return status = statusFilter[status - 1] ;
    }
}) ;
app.filter("afilter",function () {
    var statusFilter  =  ["上线","下线"];
    return function (status) {
        return status = statusFilter[status - 1] ;
    }
}) ;



