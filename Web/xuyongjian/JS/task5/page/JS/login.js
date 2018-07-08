app.controller('loginController',function ($state,$scope,$http) {
    $scope.loginBtn = function () {
        $http({
            method:'POST',
            url:'/carrots-admin-ajax/a/login',
            params:{
                name:$scope.userName,
                pwd:$scope.pwd
            }
        }).then(function (response) {
            console.log(response);
            var messageState = response.data.message;
            console.log(messageState);
            if (messageState === 'success') {
                alert('登陆成功');
                $state.go('backGround.dashBoard');
            }
            // else if(messageState === '用户不存在'){
            //     alert('傻逼，用户名打错啦啦啦啦')
            // }
            // else if(messageState === '密码错误'){
            //     alert('傻逼，密码打错啦啦啦啦')
            // }
        })
    };
// $scope.loginBtn = function () {
//     if ($scope.userName === 'admin'&&$scope.pwd === '123456' ) {
//         alert('登陆成功')
//     }
//     else if($scope.userName !== 'admin'){
//         alert('傻逼，用户名打错啦啦啦啦')
//     }
//     else if($scope.pwd !== '123456'){
//         alert('傻逼，密码打错啦啦啦啦')
//     }
// }
// let loginBtn = $('#loginBtn');
// loginBtn.on('click', function () {
//     userInput = $('#userInput').val();
//     pwInput = $('#pwInput').val();
//     totalValue = 'name=' + userInput + '&pwd=' + pwInput;
//     let xml;
//     xml = new XMLHttpRequest();
//     xml.onreadystatechange = function () {
//         if (xml.readyState==4 && xml.status==200){
//             let loginData = JSON.parse(xml.responseText);
//             console.log(loginData.message);
//             console.log(xml.responseText);
//         }
//     };
//     xml.open('POST','http://localhost:12/carrots-admin-ajax/a/login',true);
//     xml.setRequestHeader("Content-type","application/x-www-form-urlencoded");
//     xml.send(totalValue);
// });
    // pwdFalse = $('<div></div>')
    //     .text('密码错误')
    //     .addClass('login_redWord');
    // loginBtn.on('click',function () {
    //     userInput = $('#userInput').val();
    //     pwInput = $('#pwInput').val();
    //     $.post('http://localhost:12/carrots-admin-ajax/a/login',
    //         {
    //             name:userInput,
    //             pwd:pwInput
    //         },
    //         function(data){
    //             let loginData = JSON.parse(data);
    //             console.log(loginData);
    //             if  (loginData.message == 'success'){
    //                 alert('登陆成功');
    //                 $state.go('backGround');
    //             }
    //             else if  (loginData.message == '密码错误'){
    //                 loginBtn.before(pwdFalse);
    //             }
    //             else if (loginData.message == '用户不存在'){
    //                 pwdFalse.text('用户不存在');
    //                 loginBtn.before(pwdFalse);
    //             }
    //         });
    // });
});




