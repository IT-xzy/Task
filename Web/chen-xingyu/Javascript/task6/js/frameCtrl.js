app.controller('frameCtrl',function ($scope,$state,$http,sidebar) {
    //退出登录
    $scope.logOut=function (){
        bootbox.confirm({
            title: '退出登录',
            message: '<p class="text-center">确认退出吗？</p>',
            buttons: {
                confirm: {
                    label: '确认',
                    className: 'btn-success'
                },
                cancel: {
                    label: '取消',
                    className: 'btn-danger'
                }
            },
            callback: function(result){
                if(result===true){
                    $http({
                        method: 'POST',
                        url: '/carrots-admin-ajax/a/logout'
                    }).then(function (res) {
                        if(res.data.code===0){
                            $state.go('loginState');
                        }else{
                            alert(res.data.message);
                        }
                    })
                }
            }
        })
    };
//侧栏高亮
    //取出sidebar
    $scope.sidebar=sidebar;
    $scope.first=sessionStorage.getItem('first');
    $scope.second=sessionStorage.getItem('second');
    $scope.level1=function (index) {
        console.log(index);
        $scope.first=($scope.first===index)?undefined:index;
        console.log($scope.first);
    };
    $scope.level2=function (index,y) {
        $scope.second=y;
        sessionStorage.setItem('first',index);
        sessionStorage.setItem('second',y);
        console.log(y);
    }
    // $scope.
});