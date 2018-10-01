angular.module("myApp")

.controller("backstageController", function ($scope, $state, backstageConstant,WW) {
       $scope.WW=WW;
    $scope.toget = function (index) { //复制列表的状态
            if ($scope.reader[index].show) {
                for (let i = 0; i < 3; i++) {
                    $scope.reader[i].show = true;
                }
                $scope.reader[index].show = !$scope.reader[index].show;
            } else {
                $scope.reader[index].show = !$scope.reader[index].show;
            }
        };
        $scope.WW=WW;
        $scope.reader = backstageConstant.reader; //载入列表数据
        $scope.go = function (link) {
            if (link == 'u.article') {
                $state.go(link, {page: 1, size: 10})
            } else {
                $state.go(link);
            }
        };
    });