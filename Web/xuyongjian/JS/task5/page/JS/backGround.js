app.controller('backController', function ($state) {
    // $state.go('backGround.dashBoard');

});//welcome paging


app.controller('artList', function ($http, $scope, $state, $stateParams, $filter) {

    $scope.params = $stateParams;
    $http({
        method: 'get',
        url: '/carrots-admin-ajax/a/article/search',
        params: $scope.params,
        responseType: 'json',
    }).then(function calBack(response) {
        console.log(response.data);
        // console.log($scope.params);
        $scope.lists = response.data.data.articleList;
        $scope.totalItems = response.data.data.total;
        $scope.currentPage = $scope.params.page;
        $scope.selectedType = $scope.selectType[0];
        $scope.selectedStatus = $scope.selectStatus[0];
    });

    $scope.selectType = [
        {num: undefined, changed: '全部'},
        {num: 0, changed: '首页banner'},
        {num: 1, changed: '找职位banner'},
        {num: 2, changed: '找精英banner'},
        {num: 3, changed: '行业大图'},
    ];
    $scope.selectStatus = [
        {num: undefined, changed: '全部'},
        {num: 1, changed: '草稿'},
        {num: 2, changed: '上线'},
    ];
    $scope.artPagination = function () {
        $state.go('backGround.artList',
            {page: $scope.currentPage},
            {reload: true}
        );
    };

    // $scope.format = "yyyy/MM/dd";
    // $scope.altInputFormats = ['yyyy/M!/d!'];
    $scope.popup1 = {
        opened: false
    };
    $scope.open1 = function () {
        $scope.popup1.opened = true;
    };
    $scope.popup2 = {
        opened: false
    };
    $scope.open2 = function () {
        $scope.popup2.opened = true;
    };//日历组件

    $scope.selectedSearch = function () {
        if ($scope.selectedStartTime) {
            $scope.createAt = Date.parse($scope.selectedStartTime);
        }
        if ($scope.selectedEndTime) {
            $scope.endAt = Date.parse($scope.selectedEndTime) + 86399000;
        }
        $state.go('backGround.artList',
            {
                startAt: $scope.createAt,
                endAt: $scope.endAt,
                type: $scope.selectedType.num,
                status: $scope.selectedStatus.num,
            },
            {reload: true}
        );
        console.log($scope.params);
    };

    $scope.selectedClear = function () {
        $state.go('backGround.artList',
            {
                startAt: undefined,
                endAt: undefined,
                type: undefined,
                status: undefined,
                page:1,
            },
            {reload: true}
        );
        console.log($scope.params);
    };

    $scope.addArt = function () {
        $state.go('backGround.articleDetail');
    };

    $scope.editArt = function () {
        $state.go('backGround.articleDetail');
    };

    $scope.draOrPub = function (id, status) {
        bootbox.dialog({
            title: '<h4>操作提示</h4>',
            // if_(status == 1){
            // status = ‘上线’;
            message: '        <div class="text-center">\n' +
            '            <p>' + $filter('draOrpub')(status) + '后该图片将在轮播banner中展示。</p>\n' +
            '            <strong>是否执行' + $filter('draOrpub')(status) + '操作？</strong>\n' +
            '        </div>',
            // }
            buttons: {
                cancel: {
                    label: '取消',
                    className: 'btn-warning',
                },
                ok: {
                    label: '确定',
                    className: 'btn-info',
                    callback: function () {
                        if (status == 1) {
                            status = 2;
                            $http({
                                method: 'put',
                                url: '/carrots-admin-ajax/a/u/article/status',
                                params: {
                                    id: id,
                                    status: status,
                                }
                            }).then(function calback2(response) {
                                console.log(response);
                                $state.go('backGround.artList',
                                    {page: $scope.currentPage},
                                    {reload: true});
                            });
                        }
                        else if (status == 2) {
                            status = 1;
                            $http({
                                method: 'put',
                                url: '/carrots-admin-ajax/a/u/article/status',
                                params: {
                                    id: id,
                                    status: status,
                                }
                            }).then(function calback2(response) {
                                console.log(response);
                                $state.go('backGround.artList',
                                    {page: $scope.currentPage},
                                    {reload: true});
                            });
                        }

                    },
                }
            }
        })
    };


    $scope.editArt = function (id) {
        // $http({
        //     method: 'get',
        //     url: '/carrots-admin-ajax/a/article/' + id,
        // }).then(function callback(response) {
        //     console.log(response)
        // });
        $scope.editId = id;
        $state.go('backGround.articleDetail',
            {id: id},
            // {reload: true}
        );
    };


    $scope.deleteArt = function (id) {
        bootbox.confirm({
            title: "操作",
            message: "是否确认删除",
            buttons: {
                cancel: {
                    label: '取消',
                    className: 'btn-warning',
                },
                confirm: {
                    label: '确认',
                    className: 'btn-info',
                }
            },
            callback: function () {
                $http({
                    method: 'delete',
                    url: "/carrots-admin-ajax/a/u/article/" + id,
                }).then(function calback2(response) {
                    console.log(response);
                });
                $state.go('backGround.artList',
                    {page: $scope.currentPage},
                    {reload: true}
                );
            }
        });
    }
});


// add article area


app.controller('articleDetail', function ($scope, $state, $http, $stateParams,) {


    // if  ($scope.editId){
    //     console.log($scope.editId);
    // }
    // $scope.ue = UE.getEditor('editor');
    $scope.choiceFile = document.getElementById('choice');
    $scope.publishArt = function (btnStatus) {
        $http({
            method: "post",
            url: '/carrots-admin-ajax/a/u/article/',
            params: {
                title: $scope.newTitle,
                type: $scope.newType.num,
                industry: $scope.inIndustry.num,
                status: btnStatus,
                img: $scope.src,
                content: $scope.content,
                url: $scope.newLink,
                // industry:industry,
            }
        }).then(function callback(response) {
            console.log(response);
            console.log($scope.src);
        });
        $state.go('backGround.artList');
    };


    $scope.addOrEdit = '新增';
    console.log($stateParams.id);
    if ($stateParams.id) {
        $scope.addOrEdit = '编辑';
        $http({
            method: "get",
            url: '/carrots-admin-ajax/a/article/' + $stateParams.id,
            responseType: 'json',
        }).then(function callback(response) {
            $scope.artDetail = response.data.data.article;
            console.log($scope.artDetail);
            $scope.newTitle = $scope.artDetail.title;
            // $scope.newType = $scope.selectType[0];
            $scope.newType = $scope.selectType[$scope.artDetail.type + 1];
            $scope.newIndustry = $scope.inIndustry[$scope.artDetail.industry + 1];
            $scope.content = $scope.artDetail.content;
            $scope.newLink = $scope.artDetail.url;
            $scope.src = $scope.artDetail.img;
        });
        $scope.publishArt = function (btnStatus) {
            $http({
                method: "put",
                url: '/carrots-admin-ajax/a/u/article/' + $stateParams.id,
                responseType: 'json',
                params: {
                    title: $scope.newTitle,
                    type: $scope.newType.num,
                    industry: $scope.inIndustry.num,
                    status: btnStatus,
                    img: $scope.src,
                    content: $scope.content,
                    url: $scope.newLink,
                    createAt: Date.parse(new Date()),
                    // industry:industry,
                }
            }).then(function callback(response) {
                $scope.artDetail = response.data.data;
                console.log(response);
            });
            $state.go('backGround.artList');
        };
    }//编辑article内容


    $scope.pubOrDraButton = [
        {btnStatus: 2, label: '立即上线'},
        {btnStatus: 1, label: '存为草稿'}
    ];

    // $scope.selectedType = $scope.selectType[0];
    $scope.selectType = [
        {num: undefined, changed: '请选择'},
        {num: 0, changed: '首页banner'},
        {num: 1, changed: '找职位banner'},
        {num: 2, changed: '找精英banner'},
        {num: 3, changed: '行业大图'},
    ];


    $scope.inIndustry = [
        {num: undefined, changed: '请选择'},
        {num: 0, changed: '移动互联网'},
        {num: 1, changed: '电子商务'},
        {num: 2, changed: '企业服务'},
        {num: 3, changed: 'O2O'},
        {num: 4, changed: '教育'},
        {num: 5, changed: '金融'},
        {num: 6, changed: '游戏'},
    ];

    $scope.newType = $scope.selectType[0];
    $scope.newIndustry = $scope.inIndustry[0];

    if ($scope.selectType.num === 3) {
        $scope.when3 = true;
    }

    $scope.cancelAdd = function () {
        $state.go('backGround.artList',
            {page: $scope.currentPage},
            // {reload: true}
        );
    };


    $scope.fileReader = new FileReader();
    $scope.fileChanged = function (response) {
        $scope.$apply(function () {
            console.log(response.files);
            $scope.filesAll = response.files;
            $scope.files = response.files[0];
            // $scope.fileReader.onload = function () {
            //     // img.src = this.result;
            //      console.log(this.result)
            // };
            $scope.fileName = $scope.files.name;
            $scope.fileSize = $scope.files.size / 1024 / 1024;
            // console.log($scope.fileName);
        })
    };


    $scope.uploadArt = function () {
        var formData = new FormData();

        $scope.fileReader.readAsDataURL($scope.files);

        formData.append('file', $scope.files);
        console.log($scope.files.size);
        if ($scope.files.size <= 5242880) {
            $http({
                method: 'POST',
                url: '/carrots-admin-ajax/a/u/img/task',
                data: formData,
                headers: {'content-Type': undefined},
                uploadEventHandlers: {
                    progress: function (woqunima) {
                        console.log(woqunima);
                        $scope.progress = (woqunima.loaded / woqunima.total) * 100;//当完全加载成功后，loaded与total会相等，结果变成1
                    }
                }
            }).then(function (woqunima) {
                console.log(woqunima);
                $scope.src = woqunima.data.data.url;
                $scope.uploadStatus = woqunima.data.message;
                console.log($scope.uploadStatus);
            });
        }
        else {
            alert('文件大小超过5M');
        }
    };


    $scope.delete = function () {
        $('#img').attr('src', '');
        $scope.src = ''; //src删除;
        $scope.choiceFile.value = '';
        $scope.filesAll = '';
        $scope.files = "";
        $scope.fileName = "";
        $scope.files = "";
        $scope.fileSize = "";
        $scope.progress = 0;
        $scope.uploadStatus = false;
    };

    //
    // scope.delete = function() {
    //     Img.src = ""; //src删除
    //     scope.file2.value = "";
    //     scope.upImg = undefined; //ng-src删除
    //     scope.name = "";
    //     scope.size = '';
    //     scope.file2.files[0] = '';
    //     scope.hasImg = ""; //文件本身
    //     scope.progress = 0; //进度条
    //     scope.show = false; //状态
    //     scope.hidden = false;
    // };



    // console.log($scope.fileSize);
    // xml = new XMLHttpRequest();
    // xml.onreadystatechange = function () {
    //     if (xml.readyState==4 && xml.status==200){
    //         $scope.$apply(function () {
    //             var imgPost = JSON.parse(xml.responseText);
    //             $scope.src = imgPost.data.url;
    //             console.log($scope.src);
    //         })
    //     }
    // };
    // xml.open('POST','/carrots-admin-ajax/a/u/img/task');
    // xml.send(formData);
});


// custom filter area


app.filter('changeType', function () {
    return function (inputData) {
        var changed;
        switch (inputData) {
            case 0 :
                changed = '首页banner';
                break;
            case 1 :
                changed = '找职位banner';
                break;
            case 2 :
                changed = '找精英banner';
                break;
            case 3 :
                changed = '行业大图';
                break;
        }
        return changed;
    }
});


app.filter('changeIndutry', function () {
    return function (inputData) {
        var changed;
        switch (inputData) {
            case 0 :
                changed = '移动互联网';
                break;
            case 1 :
                changed = '电子商务';
                break;
            case 2 :
                changed = '企业服务';
                break;
            case 3 :
                changed = 'O2O';
                break;
            case 4 :
                changed = '教育';
                break;
            case 5 :
                changed = '金融';
                break;
            case 6 :
                changed = '游戏';
                break;
        }
        return changed;
    }
});


app.filter('changeStatus', function () {
    return function (inputData) {
        var changed;
        switch (inputData) {
            case 1 :
                changed = '草稿';
                break;
            case 2 :
                changed = '上线';
                break;
        }
        return changed;
    }
});
app.filter('draOrpub', function () {
    return function (inputData) {
        var changed;
        switch (inputData) {
            case 1 :
                changed = '上线';
                break;
            case 2 :
                changed = '下线';
                break;
        }
        return changed;
    }
});

