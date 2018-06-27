myApp.controller('backCtrl',function($scope, $http, $state, sidebarList){
    $scope.welcome = "Hello,Welcome";
    $scope.quit =function(){
        $http({
            method: "POST",
            url: "/carrots-admin-ajax/a/logout"
        }).then(function (respond) {
            if(respond.data.code == 0) {
                $state.go("login");
            } else {
                alert(respond.data.message);
            }
        })
    };

    // 侧边栏
    $scope.sidebarList = sidebarList;  // 从constant中取出侧边栏数据
    //  刷新后保持高亮
    $scope.first = sessionStorage.getItem("first");
    $scope.second = sessionStorage.getItem("second");
    // 点击一级菜单
    $scope.toggleList = function (x) {
        $scope.first = ($scope.first == x) ? undefined : x;  // 点击只显示当前项，再次点击隐藏
        console.log(x)
    };
    // 点击二级菜单
    $scope.currentList = function (y, index) {
        $scope.second = y;
        // 把当前点击的菜单信息存入sessionStorage中
        sessionStorage.setItem("first", index);
        sessionStorage.setItem("second", y);
        console.log(y);
        console.log(index)
    }


});
