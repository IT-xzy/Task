
var submit= document.getElementById('pd0');

var wid4;
var wid5;

submit.onclick = (function () {
    wid4 = document.getElementById('input-top').value;
    wid5 = document.getElementById('input-bot').value;
var xhr = new XMLHttpRequest();



// 指定通信过程中状态改变时的回调函数
xhr.onreadystatechange = function(){
    // 通信成功时，状态值为4
    if (xhr.readyState === 4){
        if (xhr.status === 200){
            var b=xhr.responseText;
            var c=JSON.parse(b);
            console.log(b);
            if(c.code===0){
    window.location.href='task5.html'
            }else{
                document.getElementById('hide').style.display='inline';
            }
        } else {
            console.error(xhr.statusText);
        }
    }
};


    xhr.onerror = function (e) {
    console.error(xhr.statusText);
  };

// open方式用于指定HTTP动词、请求的网址、是否异步

// 发送HTTP请求

    // console.log(wid5);
    // console.log(wid4);
    // http://localhost//carrots-admin-ajax/a/login
    // http://dev.admin.carrots.ptteng.com/a/login
    xhr.open('POST', 'http://localhost//carrots-admin-ajax/a/login', true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
    xhr.send('name='+wid4+'&pwd='+wid5);
});





// var app = angular.module('myApp', []);
//
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


