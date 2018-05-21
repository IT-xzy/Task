angular.module('app').controller('dashboardCtrl',['isLogin','$httpTools','ajaxAds','$http','$state','$timeout', function (isLogin, $httpTools, ajaxAds, $http, $state, $timeout) {
    var vm = this;
    vm.self = {};
    vm.isLogin = isLogin();
    if (!vm.isLogin.isLogin) {
        $state.go('login');
    } else {
        vm.self = vm.isLogin.self;
    }
    vm.logOut = function () {
        //这个退出请求有什么用呢。。
        localStorage.removeItem('self');
        sessionStorage.removeItem('history');
        let $promise = $httpTools().post(ajaxAds.logOut, '');
        $promise.then(function (Success) {
            //退出跳转;
            alert('您还未登录');
            $timeout(function () {
                $state.go('login');
            }, 1500)
        }, function (Error) {
            alert('请求错误');
            $timeout(function () {
                $state.go('login');
            }, 1500)
        })
    }
}])