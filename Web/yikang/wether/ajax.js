myApp.factory('interface', function () {
    return {
        // 获取Article列表接口
        articleList_url: '/carrots-admin-ajax/a/article/search',
        articleList_add: '/carrots-admin-ajax/a/u/article',
        articleList_edit: '/carrots-admin-ajax//a/u/article/',
        articleList_one: '/carrots-admin-ajax/a/article/'
    };
})
    .factory('request', function ($http, interface) {
        return {
            articleList:
                function (params) {
                    return $http({
                        method: 'GET',
                        url: interface.articleList_url,
                        params: params
                    })
                },
            articleNewadd:
                function (params) {
                    return $http({
                        method: 'post',
                        url: interface.articleList_add,
                        headers: {
                            'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
                        },
                        params: params
                    })
                },
            articleEdit:
                function (id, params) {
                    return $http({
                        method: 'put',
                        url: interface.articleList_edit + id,
                        headers: {
                            'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
                        },
                        params: params
                    })
                },
            articleSingle:
                function (id) {
                    return $http({
                        method: 'get',
                        url: interface.articleList_one + id
                    })
                },
            articlePut:
                function (id, status) {
                    return $http.put('/carrots-admin-ajax/a/u/article/status?id=' + id + "&status=" + status);
                },
            articleDelete:
                function (id) {
                    return $http.delete('/carrots-admin-ajax/a/u/article/' + id);
                },
            articleOff:
                function () {
                    return $http.post('/carrots-admin-ajax/a/logout');
                }
        };

    })
    .factory('demoservice', function ($state, request) {
        return {
            get: function (id, status) {
                bootbox.setLocale("zh_CN");
                switch (status) {
                    case 1:
                        bootbox.confirm({
                            size: 'medium',
                            title: '操作提示',
                            message: '<div>上线后该图片将在轮播图中显示</div>' +
                            '<p>是否执行上线操作</p>',
                            buttons: {
                                confirm: {
                                    label: '确认',
                                    className: 'btn-success'
                                },
                                cancel: {
                                    label: '取消',
                                    className: 'btn-danger'
                                }

                            },
                            callback: function (result) {
                                if (result) {
                                    request.articlePut(id, 2).then(
                                        function (data) {
                                            if (data.data.code === 0) {
                                                $state.reload();
                                                bootbox.alert('上线成功');
                                            }
                                        }
                                    )

                                }
                            }
                        });
                        break;
                    case 2:
                        bootbox.confirm({
                            size: 'medium',
                            title: '操作提示',
                            message: '<div>下线后该图片将在轮播图中显示</div>' +
                            '<p>是否执行下线操作</p>',
                            buttons: {
                                confirm: {
                                    label: '确认',
                                    className: 'btn-success'
                                },
                                cancel: {
                                    label: '取消',
                                    className: 'btn-danger'
                                }

                            },
                            callback: function (result) {
                                if (result) {
                                    request.articlePut(id, 1).then(
                                        function (data) {
                                            if (data.data.code === 0) {
                                                $state.reload();
                                                bootbox.alert('下线成功');
                                            }
                                        }
                                    )

                                }
                            }
                        })
                }
            },
            del: function (id) {
                bootbox.setLocale("zh_CN");
                bootbox.confirm({
                    size: 'medium',
                    title: '提示',
                    message: '是否确认删除',
                    buttons: {
                        confirm: {
                            label: '确认',
                            className: 'btn-primary'
                        },
                        cancel: {
                            label: '取消',
                            className: 'btn-warning'
                        }

                    },
                    callback: function (result) {
                        if (result) {
                            request.articleDelete(id).then(
                                function (data) {
                                    if (data.data.code === 0) {
                                        $state.reload();
                                        bootbox.alert("删除成功")
                                    }
                                }
                            )
                        }
                    }

                })
            }
        }
    });
