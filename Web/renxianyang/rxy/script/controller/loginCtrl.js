angular.module('app').controller('loginCtrl', ['ajaxAds','$httpTools','$http','$state','isLogin',function (ajaxAds, $httpTools, $http, $state, isLogin) {
        var vm = this;
        vm.isLogin = isLogin();
        if (vm.isLogin.isLogin) {
            $state.go('dashboard');
            return;
        }
        vm.send = {
            name: '',
            pwd: ''
        };
        vm.$httpData = {};
        vm.submit = function () {
            vm.errorInfo = '';
            let $promise = $httpTools().post(ajaxAds.login, vm.send);
            $promise.then(function (Success) {
                vm.$httpData = Success.data;
                if (vm.$httpData.message == 'success' && vm.$httpData.code == 0) {
                    localStorage.self = JSON.stringify(vm.$httpData);
                    sessionStorage.history = JSON.stringify({});//存储一些状态
                    $state.go('dashboard');
                } else {
                    vm.errorInfo = vm.$httpData.message + '!';
                }
            })
        }
    }]
)