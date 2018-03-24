app.controller('alertModalCtrl', ['params','$scope',function (params, $scope) {
    $scope.content = params.content;
    $scope.resolved = function () {
        $scope.$close()
    }
    $scope.rejected = function () {
        $scope.$dismiss()
    }
}])