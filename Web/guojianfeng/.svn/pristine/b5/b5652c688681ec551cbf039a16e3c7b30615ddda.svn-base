/**
 * Created by guojianfeng on 2017/11/02.
 */

angular.module('myApp', ['ngMessages'])
    .controller('login', ['$scope', '$http', '$state', function ($scope, $http, $state) {

        function setCookie(cname, cvalue, exdays) {
            // 获取系统时间
            var xmlHttp = new XMLHttpRequest();
                xmlHttp.open('HEAD', window.location.href.toString(), false);
                xmlHttp.send('');
            var time = xmlHttp.getResponseHeader("Date");
            var d = new Date();
            d.setTime(Date.parse(time) + (exdays * 1000 * 60 * 60 * 24));
            var expires = "expires=" + d.toUTCString();
            document.cookie = cname + "=" + cvalue + ";" + expires;
        }

        var cookie = document.cookie.indexOf("loginAdmin=true");
        if (cookie !== -1) {
            $state.go("welcome", {})
        }



        $scope.signIn = function () {
            $http({
                method: 'POST',
                url: '/carrots-admin-ajax/a/login',
                headers: {'content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
                params: {name: $scope.user, pwd: $scope.pwd}
            })
                .then(function (response) {
                    console.log(response);
                    if (response.data.code !== 0) {
                        $scope.message = response.data.message;
                    }
                    else if (response.data.code === 0) {
                        $state.go('welcome');
                        setCookie("loginAdmin", true, 5);
                    }
                })
        };
        // $scope.myKeyup = function(e){
        //
        //     //IE 编码包含在window.event.keyCode中，Firefox或Safari 包含在event.which中
        //     var keycode = window.event?e.keyCode:e.which;
        //     if(keycode==13){
        //         $scope.signIn();
        //     }
        // };
    }]);

// .directive('ngEnter', function () {
//     return function (scope, element, attrs) {
//         element.bind("keydown keypress", function (event) {
//             if (event.which === 13) {
//                 scope.$apply(function () {
//                     scope.$eval(attrs.ngEnter);
//                 });
//                 event.preventDefault();
//             }
//         });
//     };
// });















