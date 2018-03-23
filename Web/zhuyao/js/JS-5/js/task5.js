var btnLogin = document.getElementById("btn-login");
var message = document.getElementById("message");
btnLogin.onclick = function () {
    var userName = document.getElementById("user-name").value;
    var password = document.getElementById("password").value;
    // 创建XMLHttpRequest 对象
    var xhr = new XMLHttpRequest();

    // open方式用于指定HTTP动词、请求的网址、是否异步
    xhr.open('post', '/carrots-admin-ajax/a/login ', true);

    //发送头部信息
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.responseType = "blob";
    // 指定通信过程中状态改变时的回调函数
    xhr.onreadystatechange = function () {
        // 通信成功时，状态值为4
        if (xhr.readyState === 4) {
            if ((xhr.status === 200 && xhr.status < 300) || xhr.status === 304) {
                console.log(xhr.response);
                // if (JSON.parse(xhr.responseText).code === 0) {
                //
                //     console.log(xhr.getAllResponseHeaders());
                //     console.log(xhr.responseType);
                //     console.log(xhr.responseText);
                //     console.log(xhr.response);
                //     //window.location.href = "http://dev.admin.carrots.ptteng.com/";
                // } else {
                //     message.textContent = JSON.parse(xhr.responseText).message;
                // }
            }
        }
    };

    // 发送HTTP请求
    xhr.send("name=" + userName + "&pwd=" + password);
};





