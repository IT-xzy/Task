$scope.imgUpload = function (file) {
    file.upload = Upload.upload({
        url: '/carrots-admin-ajax/a/u/img/task',
        data: {
            file: $scope.myFiles
        }
    });
    file.upload.then(function (data) {
        console.log(data);
        $scope.src = data.data.data.url;
        $scope.imgsrc = $scope.src;
        bootbox.alert(data.data.message);
    });
};