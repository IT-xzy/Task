var app = angular.module("myApp");

app.controller('addCtrl', function ($scope, $http) {
    $scope.select = model;

    // 上线
    $scope.sendData = function (status) {
        // var file = document.getElementById('file').files[0]
        // var formData = new FormData();
        // formData.append('file', file);
        $http({
            method: 'post',
            url: 'carrots-admin-ajax/a/u/article',
            params: {
                title: $scope.title,
                type: $scope.select.$type.num,
                status: status,
                img: formData,
                content: $scope.content,
                url: $scope.url
            }
        }).then(function successCallback(response) {
            console.log(response);
        }, function errorCallback(response) { // 请求失败执行代码
            console.log('请求失败')
        });
    };


    $scope.click = function (){
        var file = document.getElementById("file").files[0]
        // var formData = new FormData();
        // formData.append('file', file);
        $scope.$apply(

            $scope.imgName = file.name,
            $scope.imgMb = (file.size / 1000000) + 'MB'
        )
        // console.log($scope.imgName);
        // console.log($scope.imgMb);
        // $scope.abc = 123;
    }



})

// function sendImage() {

//     //     $http({
//     //         method: 'post',
//     //         url: '/carrots-admin-ajax/a/u/img/task',
//     //         data: formData,
//     //         headers: {
//     //             'Content-Type': undefined
//     //         }
//     //     }).then(function successCallback(response) {
//     //         console.log(response);

//     //         $scope.imgUrl = response.data.data.url;
//     //         console.log($scope.imgUrl);
//     //     }, function errorCallback(response) {})
// }