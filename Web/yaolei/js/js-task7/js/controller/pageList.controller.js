//获取article页面
angular.module('myApp').controller('formList',function ($scope,$http,$state) {
    //编辑
    $scope.edit = function (x) {
        $http({
            method:'get',
            url:'/carrots-admin-ajax/a/article/'+x.id
        }).then(function successCallback(data) {
            $scope.o = data.data.data.article;
            var m = JSON.stringify($scope.o);
            console.log(m);
            $state.go('houtai.js6-2.js6-3',{id:x.id,json:m});
        })
    };
    //删除
    $scope.delete = function (x) {


        $http({
            method:'delete',
            url:'/carrots-admin-ajax/a/u/article/'+x.id,
        }).then(function successCallback(data) {
            console.log(data);
            if(data.data.code===0){
                $state.go('houtai.js6-2',{},{reload:true});
            }
        })
    };
    //上下线
    $scope.operation = function (x) {
        $state.go('houtai.js6-2',{},{reload:true});
        if(x.status === 1){
            var s = 2
        }else {
            s = 1
        }
        $http({
            method:'put',
            url:'/carrots-admin-ajax/a/u/article/status',
            params:{
                id:x.id,
                status:s
            }
        }).then(function successCallback(data) {
            console.log(data);
            if(data.data.code===0){
            }
        })
    }

});





