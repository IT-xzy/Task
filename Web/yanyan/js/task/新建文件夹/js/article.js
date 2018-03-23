angular.module("myApp")
    .controller("articleCtrl", function ($scope, $http, $state, Status, types) {
        $scope.params = $state.params;
        $scope.params.page = $state.params.page || '1';
        $scope.params.size = $state.params.size || '10';
        $scope.startAt = parseInt(Date.parse($state.params.startAt)) || '';
        $scope.endAt = parseInt(Date.parse($state.params.endAt)) || '';
        $scope.Status = Status;
        $scope.types = types;

        $scope.getData = {
            page: $state.params.page,
            type: $state.params.type,
            status: $state.params.status,
            size: $state.params.size,
            startAt: $scope.startAt,
            endAt: $scope.endAt
        };

        $http({
            method: "GET",
            url: "/carrots-admin-ajax/a/article/search",
            params: $scope.getData,
            header: {"Content-Type": "application/x-www-form-urlencoded"}
        }).then(function (response) {
            if(response.data.code===0){
                $scope.myList = response.data.data.articleList;
                $scope.total = response.data.data.total;
                $scope.size = response.data.data.size;
                $scope.allPage = Math.ceil($scope.total / $scope.params.size);
            }else {
                alert(response.data.message);
            }
        });


// 日期------------------
        $scope.picker = new Pikaday({
            field: $("#date1")[0],
            format: "YYYY-MM-DD",
            maxDate: new Date()
        });
        $scope.picker1 = new Pikaday({
            field: $("#date2")[0],
            format: "YYYY-MM-DD",
            maxDate: new Date()
        });

// 按属性搜索和清空---------------

        $scope.search = function (type,status,startAt,endAt) {
            $state.go(".", {
                page: 1,
                type: type,
                status: status,
                startAt: startAt,
                endAt: endAt
            }, {reload: true});
        };


// 翻页------------------
        $scope.flip = function (pages) {
            $state.go(".",
                {
                    page: pages,
                    size: $state.params.size
                }, {reload: true}
            );
        };

        $scope.sure = function () {
            if ($scope.params.page > $scope.allPage) {
                $scope.params.page = $scope.allPage
            }
            if ($scope.params.size > 20) {
                $scope.params.size = 20;
            }
            $state.go(".", {
                page: $state.params.page,
                size: $state.params.size
            }, {reload: true});
        };




// 上线&下线----------------------------
        $scope.upDown = function (id, status, message,done) {
            if (confirm(message) === true) {
                $http({
                    method: "PUT",
                    url: "/carrots-admin-ajax/a/u/article/status",
                    params: {id: id, status: status},
                    header: {"Content-Type": "application/x-www-form-urlencoded"}
                }).then(function (res) {
                    if (res.data.code === 0) {
                        alert(done);
                        $state.go(".", {
                            // id: id
                            // status: status
                        }, {reload: true});
                    }else {
                        alert(res.data.message);
                    }
                });
            }
        };
// 删除------------------------------
        $scope.delete = function (id) {
            $scope.confirm = confirm("确定删除吗？");
            if ($scope.confirm === true) {
                $http({
                    method: "DELETE",
                    url: "/carrots-admin-ajax/a/u/article/" + id,
                    header: {"Content-Type": "application/x-www-form-urlencoded"}
                }).then(function (res) {
                    if (res.data.code === 0) {
                        alert("删除成功");
                        $state.go(".", {
                            id: id
                        }, {reload: true});
                    }else {
                        alert(res.data.message);
                    }
                })
            }
        };
    });






