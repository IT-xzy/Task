// function land() {
//     var name = $("#name").val();
//     var pwd = $("#pwd").val();
//     console.log(name);
//     console.log(pwd);
//     if( name === ""){
//         alert("请输入用户名");
//         $("#name").focus();
//         return false;
//     }
//     if(pwd === ""){
//         alert("请输入用户名");
//         $("#pwd").focus();
//         return false;
//     }
//
//     $.ajax({
//         url:"/carrots-admin-ajax/a/login",
//         type:"POST",
//         dataType:"json",
//         data:{
//             name: name,
//             pwd: pwd
//         },
//
//         timeout : 100000,
//         success:function(data){
//             console.log(data);
//             if(data.code === 200 || data.code === 0){
//                 $("#error").empty();
//                 alert("登陆成功");
//             }else{
//                 $("#error").empty();
//                 $("#error").append("账号或密码错误");
//             }
//         },
//         error:function(data){
//             console.log(data);
//             alert("失败");
//         }
//     });
// }


var app = angular.module("myApp", []);
app.controller("login", ["$scope", "$http",
    function ($scope, $http) {
        $scope.loginFn = function () {
            // 实现登录
            $http({
                method: "post",
                url: "/carrots-admin-ajax/a/login",
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
                        console.log("登录成功，跳转到首页", res.data.code);
                    } else {
                        console.log("登录失败", res.data.code);
                    }
                },
                function error(res) {
                    console.log("请求失败");
                }
            );
        }
    }]);

//
// var url = "/carrots-admin-ajax/a/login?name='+name+'&pwd='+pwd+'";
// var request = new XMLHttpRequest(); // 新建XMLHttpRequest对象;
// request.onreadystatechange = function () { // 状态发生变化时，函数被回调;
//     if (request.readyState === 4) { // 成功完成
//         // 判断响应结果:
//         if (request.status === 200) {
//             // 成功，通过responseText拿到响应的文本:
//             return success(request.responseText);
//         } else {
//             // 失败，根据响应码判断失败原因:
//             return fail(request.status);
//         }
//     } else {
//         // HTTP请求还在继续...
//     }
// };
//
// // 发送请求:
// request.open("GET",url,true);
// request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
// request.send();
// alert('请求已发送，请等待响应...');
//
// readyState值说明
// 0,初始化,XHR对象已经创建,还未执行open
// 1,载入,已经调用open方法,但是还没发送请求
// 2,载入完成,请求已经发送完成
// 3,交互,可以接收到部分数据
// 4. 请求已完成，且响应已就绪
//
//
//
// 200：服务器响应正常。
// 304：该资源在上次请求之后没有任何修改（这通常用于浏览器的缓存机制，使用GET请求时尤其需要注意）。
// 400：无法找到请求的资源。
// 401：访问资源的权限不够。
// 403：没有权限访问资源。
// 404：需要访问的资源不存在。
// 405：需要访问的资源被禁止。
// 407：访问的资源需要代理身份验证。
// 414：请求的URL太长。
// 500：服务器内部错误


//
//
//
// var options = $(self).find(".input-option"); //取得 class 为 input-option 的所有对象
// $.each(options, function(k,v){ //遍历取到的对象们
//     var id = $(v).find("input").eq(0).val(); //读取他第一个文本框的值
//     var name = $(v).find("input").eq(1).val(); //读取他第二个文本框的值
//     selectData.push({"id":id, "name":name}); //缓存起来
// });
//
//


//
// /**
//  * 通过JSON的方式请求
//  * @param {[type]} params [description]
//  * @return {[type]}  [description]
//  */
// ajaxJSON(params){
//     params.type = (params.type || 'GET').toUpperCase();
//     params.data = params.data || {};
//     var formatedParams = this.formateParams(params.data, params.cache);
//     var xhr;
//     //创建XMLHttpRequest对象
//     if (window.XMLHttpRequest) {
//         //非IE6
//         xhr = new XMLHttpRequest();
//     } else {
//         xhr = new ActiveXObject('Microsoft.XMLHTTP');
//     }
//     //异步状态发生改变，接收响应数据
//     xhr.onreadystatechange = function() {
//         if (xhr.readyState == 4 && xhr.status == 200) {
//             if (!!params.success) {
//                 if (typeof xhr.responseText == 'string') {
//                     params.success(JSON.parse(xhr.responseText));
//                 } else {
//                     params.success(xhr.responseText);
//                 }
//             }
//         } else {
//             params.error && params.error(status);
//         }
//     }
//     if (params.type == 'GET') {
//         //连接服务器
//         xhr.open('GET', (!!formatedParams ? params.url + '?' + formatedParams : params.url), true);
//         //发送请求
//         xhr.send();
//     } else {
//         //连接服务器
//         xhr.open('POST', params.url, true);
//         xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
//         //发送请求
//         xhr.send(formatedParams);
//     }
// }
// /**
//  * 格式化数据
//  * @param {Obj}  data 需要格式化的数据
//  * @param {Boolean} isCache 是否加入随机参数
//  * @return {String}   返回的字符串
//  */
// formateParams: function(data, isCache) {
//     var arr = [];
//     for (var name in data) {
//         arr.push(encodeURIComponent(name) + '=' + encodeURIComponent(data[name]));
//     }
//     if (isCache) {
//         arr.push('v=' + (new Date()).getTime());
//     }
//     return arr.join('&');
// }
//
//
//


//      console.log(name);
//      console.log(pwd);
// var xmlHttp;
//
// xmlHttp = new XMLHttpRequest();
// request.onreadystatechange = function () {
//
// };
//

// $(document).ready(function(){
//     $("#b01").click(function(){
//         htmlobj=$.ajax({url:"/jquery/test1.txt",async:false});
//         $("#myDiv").html(htmlobj.responseText);
//     });
// });

//























