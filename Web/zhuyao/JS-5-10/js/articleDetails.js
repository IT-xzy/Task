app.controller("articleDetails", function ($scope, $http, $state, Upload) {
    var vm = this;
    vm.params = $state.params;
    console.log(vm.params);

    //details一页类型
    $scope.items = [
        {id: 0, name: "首页banner"},
        {id: 1, name: "找职位banner"},
        {id: 2, name: "找精英"},
        {id: 3, name: "行业大图"}
    ];
    $scope.industries = [
        {num: 0, name: "移动互联网"},
        {num: 1, name: "电子商务"},
        {num: 2, name: "企业服务"},
        {num: 3, name: "o2o"},
        {num: 4, name: "教育"},
        {num: 5, name: "金融"},
        {num: 6, name: "游戏"}
    ];

    //编辑操作++
    if (vm.params.id) {
        $http({
            method: 'get',
            url: '/carrots-admin-ajax/a/article/' + vm.params.id,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(function (resp) {
            if (resp.data.code === 0) {
                vm.params = resp.data.data.article;
                vm.params.industry = vm.params.industry === "" ? null : vm.params.industry;
                console.log(vm.params);
            }
        });
        $scope.online = function () {
            vm.params.status = 2;
            $http({
                method: 'put',
                url: '/carrots-admin-ajax/a/u/article/' + vm.params.id,
                params: vm.params,
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            }).then(function (resp) {
                console.log(vm.params);
                if (resp.data.code === 0) {
                    $state.go('backstage.article');
                }
            })
        };
        $scope.saveDraft = function () {
            vm.params.status = 1;
            $http({
                method: 'put',
                url: '/carrots-admin-ajax/a/u/article/' + vm.params.id,
                params: vm.params,
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            }).then(function (resp) {
                console.log(vm.params);
                if (resp.data.code === 0) {
                    $state.go('backstage.article');
                }
            })
        }
    }
    //新增操作++
    else {
        $scope.online = function () {
            vm.params.status = 2;
            $http({
                method: 'post',
                url: '/carrots-admin-ajax/a/u/article/',
                params: vm.params,
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            }).then(function (resp) {
                console.log(vm.params);
                if (resp.data.code === 0) {
                    $state.go('backstage.article');
                }
            })
        };
        $scope.saveDraft = function () {
            vm.params.status = 1;
            $http({
                method: 'post',
                url: '/carrots-admin-ajax/a/u/article/',
                params: vm.params,
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            }).then(function (resp) {
                console.log(vm.params);
                if (resp.data.code === 0) {
                    $state.go('backstage.article');
                }
            })
        }
    }

    //上传图片，修改img信息+++
    $scope.uploadPic = function (file) {
        file.upload = Upload.upload({
            url: '/carrots-admin-ajax/a/u/img/task',
            data: {file: $scope.picFile}
        });
        file.upload.then(function (resp) {
            $scope.picResp = resp;
            vm.params.img = resp.data.data.url;
        }, function (resp) {
            if (resp.status > 0)
                $scope.errorMsg = response.status + ': ' + response.data;
        }, function (evt) {
            file.progress = Math.min(100, parseInt(100.0 * evt.loaded / evt.total));
        });
    };
});






