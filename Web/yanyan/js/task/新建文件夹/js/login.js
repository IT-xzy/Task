angular.module("myApp",['ngMessages'])
    .controller("myCtrl",["$scope","$http","$state",function($scope,$http,$state){
        $scope.login=function(){
            console.log($scope.user);
            $http({
                method:"POST",
                url:"/carrots-admin-ajax/a/login",
                header:{"Content-Type":"application/x-www-form-urlencoded"},
                params:{name:$scope.user,pwd:$scope.pwd}
            })
                .then(function(response){
                    console.log(response.data.message);
                    if(response.data.code!==0){
                        if (response.data.message==="用户不存在"){
                            $scope.message1=response.data.message;
                        }else if(response.data.message==="密码错误"&&response.data.message!=="用户不存在"){
                            $scope.message1="";
                            $scope.message2=response.data.message;
                        }
                    }
                    else if(response.data.code===0){
                        $state.go("main",{});
                    }
                })
        }
    }]);
/*$(document).ready(function () {
    $(".login").click(function () {
        // var n = $("#userName").val();
        // var pwd = $("#passWord").val();
        $.ajax({
            type: 'POST',
            url: "/carrots-admin-ajax/a/login",
            dataType: 'json',
            data:
                {
                    name: $("#userName").val(),
                    pwd: $("#passWord").val()
                }
        })
            .then(function (response) {
                // var num = JSON.parse(response);
                console.log(response.message);
                if (response.code !== 0) {
                    $(".message").text("");
                    if (response.message==="用户不存在"){
                        $(".message").eq(0).html(response.message);
                    }else if(response.message==="密码错误"){
                        $(".message").eq(1).html(response.message);
                    }
                } else {
                    $state.go("main",{});
                    // location.href = "";
                }
            })

    });

});*/


// $(document).ready(function () {
//
//
//     $('.login').click(function () {
//         $.ajax({
//             type: 'POST',//请求方法
//             url: '/carrots-admin-ajax/a/login',//接口
//             dataType: 'json',
//             data: {
//                 name: $('#userName').val(),
//                 pwd: $('#passWord').val()
//             },
//
//             success: function (data) {
//                 //console.log(data);
//                 if (data.code !== 0) {
//                     alert(data.message);
//                 }
//                 else if (data.code === 0) {
//                     console.log(data.message);
//                 }
//             },
//             error: function (data) {
//                 return data.message;
//             }
//         })
//     })
// });