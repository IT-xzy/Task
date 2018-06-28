
myApp.controller('myCtrl',function($scope,$http,$state){
    $scope.start = function(){
        $http({
            method: 'post',
            url: '/carrots-admin-ajax/a/login',
            params: {
                name: $scope.name,
                pwd: $scope.pwd
            },
            header:{"Content-Type":"application/x-www-form-urlencoded"}
        }).then(function successCallback(xhr){
            console.log(xhr);
            console.log(xhr.data);
            console.log(xhr.data.code);
             if(xhr.data.code===0){
                $scope.prompt='';
                $state.go('backstage');
            }else if(xhr.data.code===-5003){
                $scope.prompt='用户名不存在';
            }else if(xhr.data.code===-5004){
                $scope.prompt='密码错误';
            }
            },function errorCallback(xhr){
            console.log(xhr);
            });
    };
});
// myApp.controller('myCtrl',function($scope,$http,$state){
//     $scope.start = function(){
//         $http({
//             method: 'post',
//             url: '/carrots-admin-ajax/a/login',
//             data: 'name='+$scope.name+'&pwd='+$scope.pwd,
//             headers: {'Content-Type': 'application/x-www-form-urlencoded'}
//         }).then(function successCallback(xhr){
//             console.log(xhr);
//             console.log(xhr.data.code);
//             if(xhr.data.code===0){
//                 $scope.prompt='';
//                 $state.go('backstage');
//             }else if(xhr.data.code===-5003){
//                 console.log(1);
//                 $scope.prompt='用户名不存在';
//             }else if(xhr.data.code===-5004){
//                 console.log(2);
//                 $scope.prompt='密码错误';
//             }
//         },function errorCallback(xhr){
//             console.log(xhr);
//         });
//     };
// });
