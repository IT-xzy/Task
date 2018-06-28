myApp.controller('signin', function ($scope, $http, $state, check) {
    
    $scope.in = function () {
        $http({
            method: 'post',
            url: '/carrots-admin-ajax/a/login',
            params: {
                name: $scope.uname,
                pwd: $scope.pwd
            },
            header: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
        }).then(function (data) {
            // sessionStorage.setItem('logstatus', true); //存储一个登录好的状态
            if (data.data.code == 0) {
                $state.go("PageTab"); //跳转页面
                
                var logstatus = check('true');//登录后改变logstaus为true
                
            } else {
                $scope.warn = data.data.message; //报错信息
            }
        })
        console.log($scope.signinW);
    }
})







// function checkName() {
//     var reg = /^[a-z_-]{4,16}$/; //匹配小写字母开头，4~10位数。
//     var nameVal = userName.value;
//     if (nameVal === '') { //如果为空
//         error.innerHTML = "用户名不能为空";
//     } else if (!reg.test(nameVal)) { //test方法检测字符串是否符合正则表达式，!表示不符合
//         error.innerHTML = "用户名不合法";
//     } else {
//         nameTrue = true;
//     }
//     return nameTrue; //返还nameTrue的值
// }

// function checkPwd() {
//     var reg = /^[a-z0-9_-]{6,18}$/; //匹配字母或者数字开头，6~10位数。
//     var pwdVal = userPwd.value;
//     if (pwdVal === "") {
//         error.innerHTML = "密码不能为空";
//     } else if (!reg.test(pwdVal)) {
//         error.innerHTML = "密码格式错误";
//     } else {
//         pwdTrue = true;
//     }
//     return pwdTrue;
// }
// checkName.onchange = function(){

// }