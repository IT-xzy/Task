app.run(function ($uibModal) {
    window.alert = function (content) {
        var instance = $uibModal.open({
            keyboard: true,
            animation: true,
            backdrop: 'static',
            templateUrl: 'views/alertModal.html',
            controller: 'alertModalCtrl',
            size: 'md',
            resolve:
                {
                    params: {
                        content: content,
                    }
                    ,
                }
            ,
        })
        instance.result.then(function (resolved) {
            //$close()
        }, function (rejected) {
            //$dismiss()
        })
    };
    window.confirm = function () {
        var content = [].slice.call(arguments);//传入的参数
        var instance = $uibModal.open({
            keyboard: true,
            animation: true,
            backdrop: 'static',
            templateUrl: 'views/confirmModal.html',
            controller: 'confirmModalCtrl',
            size: 'md',
            resolve:
                {
                    params: {
                        content: content,
                    },
                },
        })
        var promise = instance.result;
        return promise;
    };
});