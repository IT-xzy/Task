// function status() {
//     if (status == 1)
//         return "草稿";
//     if (status == 2)
//         return "上线";
// }

// app.controller('siteCtrl', function($scope, $http) {
//     $http({
//         method: 'GET',
//         url: 'http://www.runoob.com/try/angularjs/data/sites.php'
//     }).then(function successCallback(response) {
//         $scope.names = response.data.sites;
//     }, function errorCallback(response) {
//         // 请求失败执行代码
//     });
//
// });

myApp.controller("bbbCtrl", ["$scope", "$http", function ($scope, $http) {

        $http({
            method: "get",
            url: "/carrots-admin-ajax//a/article/search",
            data: $.param({
                name: $scope.name,
                pwd: $scope.pwd
            }),
            headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            /*
            如果是get请求，请使用data来传递参数
            如果是Post请求，请使用params来尝试传递参数
             */
        }).then(
            function success(res) {
                console.log("请求成功", res);
                if (res.data.code === 200 || res.data.code === 0) {
                    console.log("正常", res.data.code);
                    $scope.articele = response.data.list;
                } else {
                    console.log("异常", res.data.code);
                }
            },
            function error(res) {
                console.log("请求失败");
            }
        );

}]);

// myApp.controller("bbbCtrl", function ($scope) {
//     $scope.articele = [{
//         id: 1,
//         title: "xixiix",
//         type: "首页Banner",
//         createAt: 2017,
//         updateAt: 2017,
//         author: "admin",
//         status: 1
//     },
//         {
//             id: 1,
//             title: "xixiix",
//             type: "首页Banner",
//             createAt: 2017,
//             updateAt: 2017,
//             author: "admin",
//             status: 1
//         },
//         {
//             id: 1,
//             title: "xixiix",
//             type: "首页Banner",
//             createAt: 2017,
//             updateAt: 2017,
//             author: "admin",
//             status: 1
//         }];
// });


//
// var app = angular.module("myApp", []);
// app.controller("myCtrl", function($scope) {
//     $scope.records = [
//         {
//             "Name" : "Alfreds Futterkiste",
//             "Country" : "Germany"
//         },
//         {
//             "Name" : "Berglunds snabbk",
//             "Country" : "Sweden"
//         }
//     ]
// });