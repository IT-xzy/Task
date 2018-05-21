angular.module('app').controller('loginCtrl', ['ajaxAds', '$httpTools', '$http', '$state', 'isLogin', function (ajaxAds, $httpTools, $http, $state, isLogin) {
        var vm = this;
        vm.isLogin = isLogin();
        if (vm.isLogin.isLogin) {
            $state.go('dashboard');
            return;
        }
        vm.ajaxSend = {
            name: '',
            pwd: ''
        };
        vm.errorInfo = '';
        vm.ajaxData = {};
        vm.submit = function () {
            vm.errorInfo = '';
            let $promise = $httpTools.post(ajaxAds.login, vm.ajaxSend);
            $promise.then(function (Success) {
                vm.ajaxData = Success.data;
                if (vm.ajaxData.message == 'success' && vm.ajaxData.code == 0) {
                    localStorage.self = JSON.stringify(vm.ajaxData);
                    sessionStorage.history = JSON.stringify({});//存储一些状态
                    $state.go('dashboard');
                } else {
                    vm.errorInfo = vm.ajaxData.message + '!';
                }
            })
        }
        //测试
        $http.post('/carrots-admin-ajax/a/login', {name: 'admin', pwd: 123456});
    }]
)