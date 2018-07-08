myApp.controller("add", function ($scope, $http, $state, $stateParams, textAngularManager, Upload) {

    // 富文本版本
    $scope.version = textAngularManager.getVersion();
    $scope.versionNumber = $scope.version.substring(1);
    // 类型
    $scope.types = [{
        id: null,
        typename: '请选择'
    }, {
        id: 0,
        typename: '首页banner'
    }, {
        id: 1,
        typename: '找职位banner'
    }, {
        id: 2,
        typename: '找精英banner'
    }, {
        id: 3,
        typename: '行业大图'
    }];

    $scope.type = $scope.types[0].id;

    $scope.industries = [{
            id: null,
            industryname: '请选择'
        }, {
            id: 0,
            industryname: '移动互联网'
        },
        {
            id: 1,
            industryname: '电子商务'
        },
        {
            id: 2,
            industryname: '企业服务'
        },
        {
            id: 3,
            industryname: 'O2O'
        },
        {
            id: 4,
            industryname: '游戏'
        }
    ]
    $scope.industry = $scope.industries[0].id;

    // 编辑
    if ($stateParams.id) {
        $scope.listTitle = "编辑Article";

        // 编辑渲染数据
        $http({
            method: 'get',
            url: '/carrots-admin-ajax/a/article/' + $stateParams.id,
        }).then(function (result) {
            console.log($stateParams.id);
            console.log(result.data.data.article);
            var singleList = result.data.data.article;
            $scope.title = singleList.title;
            $scope.type = singleList.type;
            $scope.htmlVariable = singleList.content;
            $scope.link = singleList.url;
            $scope.img_view = singleList.img;
            $scope.createAt = singleList.createAt;
            $scope.industry = singleList.industry;
            // console.log($scope.img_view)
        })

        // 编辑的上线
        $scope.onLine = function () {
            $http({
                method: 'put',
                url: '/carrots-admin-ajax/a/u/article/' + $stateParams.id,
                params: {
                    title: $scope.title,
                    type: $scope.type,
                    status: 2,
                    img: $scope.img_view,
                    content: $scope.htmlVariable,
                    url: $scope.link,
                    createAt: $scope.createAt,
                    // industry: $scope.industry
                },
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                }
            }).then(function (resp) {
                console.log(resp);
                if (resp.data.code === 0) {
                    $state.go('backstage.list');
                }
            })
        }
        // 编辑的存为草稿
        $scope.save = function () {
            $http({
                method: 'put',
                url: '/carrots-admin-ajax/a/u/article/' + $stateParams.id,
                params: {
                    title: $scope.title,
                    type: $scope.type,
                    status: 1,
                    img: $scope.img_view,
                    content: $scope.htmlVariable,
                    url: $scope.link,
                    createAt: $scope.createAt,
                    // industry: $scope.industry
                },
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                }
            }).then(function (resp) {
                console.log(resp);
                if (resp.data.code === 0) {
                    $state.go('backstage.list');
                }
            })
        }
    }

    // 新增
    else {
        $scope.listTitle = "新增Article";
        // 新增的立即上线
        $scope.onLine = function () {
            $http({
                method: 'post',
                url: '/carrots-admin-ajax/a/u/article/',
                params: {
                    title: $scope.title,
                    type: $scope.type,
                    status: 2,
                    img: $scope.img_view,
                    content: $scope.htmlVariable,
                    url: $scope.link,
                    // industry: $scope.industry
                },
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                }
            }).then(function (resp) {
                console.log(resp);
                if (resp.data.code === 0) {
                    $state.go('backstage.list');
                }
            })
        }
        // 新增的存为草稿
        $scope.save = function () {
            $http({
                method: 'post',
                url: '/carrots-admin-ajax/a/u/article/',
                params: {
                    title: $scope.title,
                    type: $scope.type,
                    status: 1,
                    img: $scope.img_view,
                    content: $scope.htmlVariable,
                    url: $scope.link,
                    // industry: $scope.industry
                },
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                }
            }).then(function (resp) {
                console.log(resp);
                if (resp.data.code === 0) {
                    $state.go('backstage.list');
                }
            })
        }
    }

    // 图片上传.现在已经改为ngfileupload
    $scope.imgUpload = function (file) {
        file.upload = Upload.upload({
            url: '/carrots-admin-ajax/a/u/img/task',
            data: {
                file: $scope.myFiles
            },
        });
        // 请求成功后，获取返回的url，然后缩略图展示
        file.upload.then(function (rsp) {
            console.log(rsp);
            $scope.src = rsp.data.data.url;
            $scope.img_view = $scope.src;
        }, function (rsp) {g
            alert(rsp.data.message);
        }, function (evt) {
            file.progress = Math.min(100, parseInt(100.0 * evt.loaded / evt.total));
            console.log("图片上传成功！");
        });
    };

    // 图片上传后删除
    $scope.imgDelete = function (file) {
        console.log(file);
        $scope.myFiles = "";
        $scope.src = "";
    };
});