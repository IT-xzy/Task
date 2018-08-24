// // 获取用户名dom节点
// var user = document.getElementById("user");
// var username; //定义一个用户名变量
// console.log(username)

// //当用户名输入框失去焦点时把值传给用户名变量
// user.onchange = function () {
//     username = user.value;
//     console.log(username)
// }

// // 获取登录按钮节点
// var login = document.getElementsByTagName("button")[0];
// // 获取错误提示节点
// var hint = document.getElementById("hint");

// // 获取密码输入框节点
// var psd = document.getElementById("password");
// var password; //定义一个密码变量
// console.log(password)

// // 当密码输入框失去焦点时把值传给密码变量
// psd.onchange = function () {
//     password = psd.value;
//     console.log(password)
// }

// // 当用户输入时清除提示
// user.oninput = function () {
//     hint.innerText = "";
// }
// // 当用户输入时清除提示
// psd.oninput = function () {
//     hint.innerText = "";
// }

// var xhr = new XMLHttpRequest(); //创建ajax的XHR对象

// // 当用户点击登录按钮
// login.onclick = function () {
//     // 创建post请求的数据形式
//     var data = "name=" + username + "&pwd=" + password;
//     console.log(data)

//     // 当用户未输入账号密码点击登录按钮跳出提示
//     if (user == undefined || user == "" || password == undefined || password == "") {
//         hint.innerText="请输入账号密码";
//     } else if (user != undefined && password != undefined) {
//         // ajax状态改变事件
//         // 当输入账号密码点击登录按钮发起post请求,并返回数据
//         xhr.onreadystatechange = function () {
//             if (xhr.readyState === 4) {
//                 console.log(xhr)
//                 if (xhr.status === 200) {
//                     let arr = [];
//                     arr = JSON.parse(xhr.responseText); // 把服务器响应的数据转换到arr数组
//                     // console.log(arr.code)
//                     // console.log(arr.message)
//                     // console.log(xhr.response)

//                     // 根据返回的不同数据提示报错信息
//                     if (arr.code == "-5003" && arr.message == "用户不存在") {
//                         hint.innerText = arr.message;
//                     } else if (arr.code == "-5004" && arr.message == "密码错误") {
//                         hint.innerText = arr.message;
//                     } else if (arr.code == "0" && arr.message == "success") {
//                         hint.innerText = "登录成功";
//                         location.href = "../html/backstage.html"
//                     }
//                 }
//             }
//         }
//         // 发起post请求
//         xhr.open("POST", "/carrots-admin-ajax/a/login", true);
//         // 定义header信息，post请求没有header信息就会报错
//         xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
//         xhr.send(data); //发起获取的用户名和密码的值
//     }
// }









// jquery写法

var user; //定义一个用户名变量
var password; //定义一个密码变量

// 当用户名和密码输入框失去焦点时把对应的数据传到对应的变量中
$('input').blur(function () { 
    user = $("#user").val();
    password = $('#password').val();
    console.log(user)
    console.log(password)
});

// 当用户输入时清除提示
$('input').bind('input propertychange', function () {
    $('#hint').text("");
})

// post请求
$('button').click(function () {
    // 创建一个用户名和密码对象
    let datum = {
        name: user,
        pwd: password
    };
    console.log(datum)

    // 当用户未输入账号密码点击登录按钮跳出提示
    if (user == undefined || user==""|| password == undefined ||password=="") {
        $('#hint').text("请输入账号密码 ");

    }else if (user != undefined && password != undefined) {
        // 当输入账号密码点击登录按钮发起post请求,并返回数据
        $.post('/carrots-admin-ajax/a/login', datum, function (data) {
            let arr = []; //创建一个空数组
            arr = JSON.parse(data) //把返回josn的数据传到数组
            console.log(arr)
            // 根据返回的不同数据提示报错信息
            if (arr.code == "-5003") {
                $('#hint').text(arr.message); //用户名不存在
            } else if (arr.code == "-5004") {
                $('#hint').text(arr.message); //密码错误
            } else if (arr.code == "0") {
                $('#hint').text("登录成功"); //登录成功
                location.href = "../html/backstage.html"
            }
        })
    }
})