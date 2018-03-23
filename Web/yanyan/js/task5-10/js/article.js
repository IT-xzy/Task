angular.module('myApp')
    .controller('articleController', ['$scope', '$state', '$http', 'status', 'type',
        function ($scope, $state, $http, status, type) {

            //ng-repeat
            $scope.status = status;
            $scope.type = type;

            //请求状态的参数赋值给作用域下的参数
            $scope.params = $state.params;
            $scope.params.page = $state.params.page || 1;
            $scope.params.size = $state.params.size || 10;


            //时间戳转换
            $scope.startAt = Date.parse($state.params.startAt) + 57600000 || "";
            $scope.endAt = Date.parse($state.params.endAt) + 57600000 || "";
            console.log($state.articleList);

            //总页数
            $scope.pageSkip = $scope.pageSkip || 1;

            //行数
            $scope.params.size = parseInt($state.params.size);


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

            //搜索跳转
            $scope.search = function () {
                $state.go('.',
                    //传递参数`
                    {
                        page: 1,
                        startAt: $scope.params.startAt,
                        endAt: $scope.params.endAt,
                        type: $scope.params.type,
                        status: $scope.params.status
                    },//强制刷新页面
                    {reload: true});

            };

            //请求数据
            $http({
                method: 'GET',
                url: "/carrots-admin-ajax/a/article/search",
                params: {
                    page: $scope.params.page,
                    size: $scope.params.size,
                    startAt: $scope.startAt,
                    endAt: $scope.endAt,
                    type: $scope.params.type,
                    status: $scope.params.status
                },
                headers: {"Content-Type": "application/x-www-form-urlencoded,charset=UTF-8"}
            }).then(function (res) {
                if (res.data.code === 200 || res.data.code === 0) {
                    $scope.articleList = res.data.data.articleList;
                    $scope.pageAll = Math.ceil(res.data.data.total / res.data.data.size);
                    console.log(res);
                } else {
                    alert(res.data.message);
                }
            });


            //上线、下线
            $scope.changeStatus = function (id, status) {
                if (status === 1) {
                    $scope.StatusConfirm = confirm("确认上线？");
                } else {
                    $scope.StatusConfirm = confirm("确认下线？");
                }

                if ($scope.StatusConfirm === true) {
                    console.log(status);
                    if (status === 1) {
                        $state.params.status = 2;
                    } else if (status === 2) {
                        $state.params.status = 1;
                    }
                    $http({
                        method: "PUT",
                        url: "/carrots-admin-ajax/a/u/article/status",
                        params: {
                            id: id,
                            status: $state.params.status
                        },
                        headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
                    }).then(function (res) {
                        if (res.data.code === 0) {
                            $state.go('.', $state.data, {reload: true});
                            // location.reload()
                        } else {
                            console.log(res.data);
                            // alert(res.data.message)
                        }
                    })
                }
            };

            //翻页跳转
            $scope.goPage = function (page, size) {
                $state.go('.',
                    //传递参数
                    {
                        page: page,
                        size: size
                    },
                    //强制刷新页面
                    {reload: true});
            };


            //清空跳转
            $scope.empty = function () {
                $state.go('.', {
                    page: 1,
                    size: 10,
                    type: "",
                    status: "",
                    startAt: "",
                    endAt: ""
                }, {reload: true});
            };
            //删除
            $scope.delete = function (id) {
                $scope.confirmDelete = confirm("确定删除吗？");
                if ($scope.confirmDelete === true) {
                    console.log(id);
                    $http({
                        method: "delete",
                        url: '/carrots-admin-ajax/a/u/article/' + id
                    })
                        .then(function (res) {
                            if (res.data.code === 0) {
                                $state.go('.', $state.params, {reload: true});
                                alert("删除成功");
                            }
                            else {
                                alert(res.data.message);
                            }
                        });
                }
            };


        }]);

// $scope.params.startAt = Date.parse($state.params.startAt);
// $scope.params.endAt = Date.parse($state.params.endAt);

// $scope.pageSkip = $scope.pageSkip ? $scope.pageSkip : 1;
// $scope.params.size = parseInt($state.params.size);

//时间插件bootstrap-datetimepicker
// $(function () {
//     $('#datetimepicker1').datetimepicker({
//         format: 'yyyy-mm-dd hh:ii ',
//         minView: "month",
//         locale: 'zh-CN',
//         autoclose: true,
//         startDate: '2015-01-01'
//     });
//     $('#datetimepicker2').datetimepicker({
//         format: 'yyyy-mm-dd hh:ii ',
//         minView: "month",
//         locale: 'zh-CN',
//         autoclose: true,
//         startDate: '2015-01-01'
//     });
// });
