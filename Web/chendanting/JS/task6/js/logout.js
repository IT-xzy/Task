app.controller("logoutCtrl", function ($state, serviceHTTP) {
    var vm = this;
    vm.logout = function () {
        var logout = confirm("是否退出登录？");
        if (logout){
            sessionStorage.clear();
            serviceHTTP.logoutHTTP().then(function(res){
                if (res.data.code == 0) {
                    alert("退出登录成功！");
                    $state.go("login");
                }
            });
        }
    }
})
