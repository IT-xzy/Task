console.log('任务五');

var btn = document.getElementById('btn');
btn.onclick = function () {
    var user = document.getElementById('user').value; //用户名
    var pass = document.getElementById('pass').value; //密码
    var xmlhttp = new XMLHttpRequest; //XMLHttpRequest 对象
    xmlhttp.open('post', '/carrots-admin-ajax/a/login', true); //使用open方法（post类型，地址，异步请求）
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded"); //添加 HTTP 头
    xmlhttp.send("name=" + user + "&pwd=" + pass); //发送数据到服务器
    xmlhttp.onreadystatechange = function (data) { //监听事件
        if (xmlhttp.readyState == 4 //通信成功时，状态为4
            &&
            xmlhttp.status == 200) { //服务器已成功处理了请求。通常，这表示服务器提供了请求的网页。
            var data = xmlhttp.responseText;
            console.log("data字符串:",data);
            data = JSON.parse(data);
            // if (message == success){
            if (data.code == 0) {
                location.assign("http://dev.admin.carrots.ptteng.com/#/login"); //跳转网页
                // console.log("data:",data);
            } else {
                document.getElementById("hide").innerHTML = data.message;
            }
        }
    }
}