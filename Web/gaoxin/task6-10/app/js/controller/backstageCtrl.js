angular.module("myApp").controller('backstageCtrl', function($scope,$state) {
    //简单的登录状态判断
    let confirm = sessionStorage.getItem('confirm');
    if (confirm !== "1"){
        $state.go('login')
    }
    $scope.logout= function() {
        $state.go ('login');
        sessionStorage.clear();
    };//注销按钮
});
