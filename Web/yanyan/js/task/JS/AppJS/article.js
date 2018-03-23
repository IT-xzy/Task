/**
 * Created by MACHENIKE on 2017/8/5.
 */

angular.module('myApp')
    .controller('articleController', ['$filter', '$scope', '$http', '$state', 'types', 'Status',
        function ($filter, $scope, $http, $state, types, Status) {

            // 绑定常量表
            $scope.Status = Status;
            $scope.types = types;


            // 初始化
            $scope.params = $state.params;
            $scope.params.page = $state.params.page || 1;
            $scope.params.size = $state.params.size || 10;

            // 显示列数
            $scope.params.size = parseInt($state.params.size);

            // 跳转到第几页
            $scope.pageSkip = $scope.pageSkip ? $scope.pageSkip : 1;// 判断按钮是否为disable

            $scope.startAt = Number(Date.parse($state.params.startAt)) ? Number(Date.parse($state.params.startAt)) : "";
            $scope.endAt = Number(Date.parse($state.params.endAt)) ? Number(Date.parse($state.params.endAt)) : "";


            //日期插件设置
            $scope.picker = new Pikaday({
                field: $("#datepicker")[0],
                format: "YYYY-MM-DD",
                maxDate: new Date()
            });
            $scope.picker1 = new Pikaday({
                field: $("#datepicker1")[0],
                format: "YYYY-MM-DD",
                maxDate: new Date()
            });

            // $scope.searchParams = ;
            //搜索按钮
            $scope.search = function () {
                $state.go('.',
                    {
                        page: 1,
                        startAt: $scope.params.startAt,
                        endAt: $scope.params.endAt,
                        type: $scope.params.type,
                        status: $scope.params.status
                    }
                    , {reload: true});
                console.log($scope.startAt);
            };

            //清空按钮
            $scope.empty = function () {
                $state.go('.', $state.params = {
                    page: 1,
                    size: 10,
                    type: "",
                    status: "",
                    startAt: "",
                    endAt: ""
                }, {reload: true});
            };
            // 请求数据
            $scope.getData = {
                page: $state.params.page,
                size: $state.params.size,
                startAt: $state.startAt,
                endAt: $state.endAt,
                type: $state.params.type,
                status: $state.params.status
            };


            $http({
                method: 'GET',
                url: "/carrots-admin-ajax/a/article/search",
                params: $scope.getData,
                headers: {"Content-Type": "application/x-www-form-urlencoded"}
            }).then(function (response) {
                if (response.data.code === 0) {
                    $scope.pageAll = Math.ceil(response.data.data.total / response.data.data.size);
                    $scope.articleList = response.data.data.articleList;
                } else {
                    alert(response.data.message);
                }
            });

            //Article上下线
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
                            $state.go('.', $state.params, {reload: true});
                            alert("修改成功");
                        }
                        else {
                            alert(response.data.message);
                        }
                    });
                }
            };

            //删除Article
            $scope.delete = function (id) {
                $scope.deleteConfirm = confirm("确认删除吗？");
                if ($scope.deleteConfirm === true) {
                    $http.delete('/carrots-admin-ajax/a/u/article/' + id)
                        .then(function (response) {
                            if (response.data.code === 0) {
                                $state.go('.', $state.params, {reload: true});
                                alert("删除成功");
                            }
                            else {
                                alert(response.data.message);
                            }
                        });
                }
            };


            $scope.goPage = function (page, size) {
                $state.go('.', {
                    page: page,
                    size: size
                }, {
                    reload: true
                });
            };

        }]);
