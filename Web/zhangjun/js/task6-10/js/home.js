angular.module("myApp")
    .controller("homeCtrl",function ($scope, $http, $state, sidebarList, session) {
    // 退出
    $scope.loginOut = function () {
        $http({
            method: "POST",
            url: "/carrots-admin-ajax/a/logout",
        }).then(function (res) {
            if(res.data.code == 0) {
                $state.go("login");
            } else {
                alert(res.data.message);
            }
        })
    }
    // 侧边栏
    $scope.sidebarList = sidebarList;  // 从constant中取出侧边栏数据
    // $scope.state = $state;
    // $scope.toggleList = function (ele) {
    //     // 点击只显示当前项，并隐藏其他项
    //     angular.forEach($scope.sidebarList,function (value) {
    //         if (ele.firstLevel === value.firstLevel) { // 再次点击当前项时变为显示或者隐藏
    //             ele.isShow = !ele.isShow;
    //         } else {
    //             value.isShow = false;
    //         }
    //     })
    // }
    // // 找出匹配当前路由状态的子标题，高亮显示该状态的父标题
    // angular.forEach($scope.sidebarList,function (item) {
    //     item.secondLevel.some(function(mitem){
    //         if($state.is(mitem.url)){ // 判断当前项的url值是否为当前激活url
    //             item.isShow = true;
    //             return true;
    //         } else {
    //             item.isShow = false;
    //             return false;
    //         }
    //     })
    // })

    //  刷新后保持高亮
    $scope.first = session.get("first");
    $scope.second = session.get("second");
    // 点击一级菜单
    $scope.toggleList = function (x) {
      $scope.first = ($scope.first == x) ? undefined : x;  // 点击只显示当前项，再次点击隐藏
      console.log(x)
    }
    // 点击二级菜单
    $scope.currentList = function (y, index) {
      $scope.second = y;
      // 把当前点击的菜单信息存入sessionStorage中
      session.set("first", index);
      session.set("second", y);
      console.log(y)
      console.log(index)
    }
})