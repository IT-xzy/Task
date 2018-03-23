angular.module('myApp', [])
    .controller('backStageController', ['$rootScope', '$scope', '$state', function ($rootScope, $scope, $state) {
        //全局高亮
        $rootScope.state = $state;
        // 退出登录
        $rootScope.quit = function () {
            $scope.quitConfirm = confirm("确认退出？");
            if ($scope.quitConfirm === true) {
                $state.go("login", {});
            }
        };
        //箭头变换方向
        $('.Accordion').click(function () {
            $(this).children('.glyphicon-chevron-left').toggleClass('hidden-none');
            $(this).children('.glyphicon-chevron-down').toggleClass('hidden-none');

        });

    }]);














// angular.module('myApp', [])
//     .controller("backStageController", function ($rootScope, $scope,$http,$state) {
//         $rootScope.quit = function () {
//             $scope.backout = confirm("确认要退出登录吗？");
//             if ($scope.backout = true) {
//                 $http.post('/carrots-admin-ajax/a/logout/')
//                     .then(function (response) {
//                         console.log(response.data);
//                         if (response.data.code === 0) {
//                             $state.go('login');
//                         } else {
//                             return false;
//                         }
//                     })
//
//             }
//         }
//     });