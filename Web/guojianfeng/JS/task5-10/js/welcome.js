angular.module('myApp', [])
    .controller("welcome", function ($rootScope, $scope, $http, $state) {
        $rootScope.goBack = function () {
            function delAllCookie() {
                var myDate = new Date();
                myDate.setTime(-1000);//设置时间
                var data = document.cookie;
                var dataArray = data.split("; ");
                for (var i = 0; i < dataArray.length; i++) {
                    var varName = dataArray[i].split("=");
                    document.cookie = varName[0] + "=''; expires=" + myDate.toGMTString();
                }

            }

            $scope.backout = confirm("确认要退出登录吗？");
            if ($scope.backout = true) {
                $http.post('/carrots-admin-ajax/a/logout/')
                    .then(function (response) {
                        console.log(response.data);
                        if (response.data.code === 0) {
                            $state.go('login');
                            delAllCookie();
                        } else {
                            return false;
                        }
                    })
            }
        };

        $rootScope.state=$state;
        $(function(){
            $(".panel-heading").click(function(e){
                /*切换折叠指示图标*/
                $(this).find("span").toggleClass("glyphicon-chevron-down");
                $(this).find("span").toggleClass("glyphicon-chevron-up");
            });
        });



    });