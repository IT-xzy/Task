
// jQuery
// $(document).ready(function () {
//
// $("#btn_login").on('click',function(){
//     console.log("11");
//
//     let x=$("#username").val();
//     let y=$("#password").val();
//     if (x==null || x === "")
//     {
//         alert("用户名不得为空");
//     }
//         else if (y==null || y === "") {
//         alert("密码不得为空");
//     }
//         else {
//         $.ajax({
//             url: '/carrots-admin-ajax/a/login',
//             type: 'POST',
//             contentType: 'application/json',
//             dataType: "json",
//             data: {
//                 name: x,
//                 pwd: y
//             },
//
//             success: function (message) {
//                 console.log(x);
//                 console.log(y);
//                 console.log(message);
//                 console.log(message.code);
//                 if (message.code === 0) {
//                     window.location.href = "//dev.admin.carrots.ptteng.com/#/dashboard";
//                 }
//                 else
//                     $(".tip").text(message.message);
//                 timer = setTimeout(function () {
//                     $(".tip").text(``);
//                 }, 3000)
//             }
//
//         });
//     }
// });
// });

// JavaScript
// document.getElementById("btn_login").onclick = function () {
//     alert("123");
// };







function ajax(event) {

    //先声明一个异步请求对象
    let xmlHttpReg = null;
    if (window.ActiveXObject) {//如果是IE
        xmlHttpReg = new ActiveXObject("Microsoft.XMLHTTP");

    } else if (window.XMLHttpRequest) {

        xmlHttpReg = new XMLHttpRequest(); //实例化一个xmlHttpReg
    }

    //如果实例化成功,就调用open()方法,就开始准备向服务器发送请求
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    // let date=`name=${username}&pwd=${password}`;
    let date = "name=" + username + "&pwd=" + password;
    if (xmlHttpReg != null) {
        // event.preventDefault();
        xmlHttpReg.open("post", "/carrots-admin-ajax/a/login", true);
        //必须在open之后，send之前
        xmlHttpReg.setRequestHeader('content-type', 'application/x-www-form-urlencoded');
        xmlHttpReg.send(date);
        // xmlHttpReg.setRequestHeader('content-type', 'application/json');
        xmlHttpReg.onreadystatechange = doResult; //设置回调函数

    }

    //回调函数
    //一旦readyState的值改变,将会调用这个函数,readyState=4表示完成相应

    //设定函数doResult()
    function doResult() {

        if (xmlHttpReg.readyState === 4 &&xmlHttpReg.status === 200) {//4代表执行完成
            //200代表执行成功
            //将xmlHttpReg.responseText的值赋给ID为resText的元素
            // document.getElementById("tip").innerHTML = "22";
            let message = JSON.parse(xmlHttpReg.responseText);
            console.log("用户名"+name);
            console.log("密码"+password);
            console.log(message);
            if (message.code === 0) {
                window.location.href = "//dev.admin.carrots.ptteng.com/#/dashboard";
            }
            else
                $(".tip").text(message.message);
            timer = setTimeout(function () {
                $(".tip").text(``);
            }, 3000)
        }
    }
}
document.getElementById("btn_login").onclick = function (event) {
    ajax();
};