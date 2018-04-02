angular.module('myApp', [])
    .controller('article', function ($scope, $http, $state, type, status) {
        $scope.params = $state.params;
        $scope.params.page = $state.params.page || '1';
        $scope.params.size = $state.params.size || '10';
        $scope.startAt = Date.parse($state.params.startAt) || "";
        $scope.endAt = Date.parse($state.params.endAt)+57599999 || "";
        $scope.status = status;
        $scope.type = type;



        $scope.data = {
            page: $scope.params.page,
            size: $scope.params.size,
            type: $scope.params.type,
            status: $scope.params.status,
            startAt: $scope.startAt,
            endAt: $scope.endAt
        };

        $http({
            method: 'GET',
            params: $scope.data,
            url: '/carrots-admin-ajax/a/article/search',
            headers: {'content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
        })
            .then(function (response) {
                if (response.data.code === 0) {
                    $scope.record = response.data.data.articleList;
                    $scope.total = response.data.data.total;
                    $scope.size = response.data.data.size;
                    $scope.allPage = Math.ceil($scope.total / $scope.params.size);
                } else {
                    alert(response.data.message);
                }
            });
        //翻页
        $scope.goPage = function (page,size) {
            $state.go('.', {
                page : page ,
                size : size
            }, {
                reload:true
            });
        };

        // 搜索
        $scope.searching = function () {
            $state.go(".", {
                page: 1,
                type: $scope.params.type,
                status: $scope.params.status,
                startAt: $scope.params.startAt,
                endAt: $scope.params.endAt
            }, {reload: true});
        };
        $("#loginUp").datetimepicker({
            format: 'yyyy-mm-dd',
            language: 'fr',
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0
        });
        $("#loginDown").datetimepicker({
            format: 'yyyy-mm-dd',
            language: 'fr',
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0
        });

        // 清除
        $scope.clean = function () {
            $state.go('.', {
                page: '',
                size: '',
                startAt: '',
                endAt: '',
                type: '',
                status: ''
            }, {reload: true})
        };

        // 删除
        $scope.delete = function (id) {
            $scope.daleteConfirm = confirm("确认删除吗？");
            if ($scope.daleteConfirm === true) {
                console.log(id);
                $http({
                    method: 'DELETE',
                    url: '/carrots-admin-ajax/a/u/article/' + id
                })
                    .then(function (response) {
                        if (response.data.code === 0) {
                            $state.go(".", {
                                page: $state.params.page,
                                size: $state.params.size
                            }, {reload: true});
                            alert("删除成功");
                        } else {
                            alert(response.data.message);
                        }

                    });
            }
        };

        // 上下线
        $scope.changeStatus = function (id, status) {
            if (status === 1) {
                $scope.condition = 2;
                $scope.confirm1 = confirm("确认上线吗？");
            }
            else if (status === 2) {
                $scope.condition = 1;
                $scope.confirm2 = confirm("确认下线吗？");
            }
            if ($scope.confirm1 === true || $scope.confirm2 === true) {
                $http({
                    method: "PUT",
                    url: "/carrots-admin-ajax/a/u/article/status",
                    params: {id: id, status: $scope.condition},
                    header: {"Content-Type": "application/x-www-form-urlencoded;charset=UTF-8"}
                }).then(function (response) {
                    if (response.data.code === 0) {
                        $state.go(".", {
                            id: id
                        }, {reload: true});
                        alert("修改成功");
                    }
                    else {
                        alert(response.data.message);
                    }
                });
            }
        };


    });










