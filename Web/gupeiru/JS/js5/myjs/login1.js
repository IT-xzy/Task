var login = document.getElementById("login"); //获取登录按钮节点
login.onclick = function () { //登录按钮点击事件
    var account = document.getElementById("account"); //声明变量account赋值账号
    var password = document.getElementById("password"); //声明变量password赋值密码
    var word = document.getElementsByClassName("red-word")[0];
    var data = { //创建空对象
        name: account.value, //对象name属性值为账号
        pwd: password.value//对象pwd属性值为密码
    };
    var xhr;
    if (window.XMLHttpRequest) {
        //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
        xhr = new XMLHttpRequest();
    } else {
        // IE6, IE5 浏览器执行代码
        xhr = new ActiveXObject("Microsoft.XMLHTTP");
    };
    //检测
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status >= 200 && xhr.status < 300 || xhr.status == 304) {//判断是否成功
                var jsons = JSON.parse(xhr.responseText); //返回文本字符串转换为json对象
                if (account.value === "" || password.value === "") {//如果用户名或者密码没输，则提示
                    word.innerHTML = "请输入账号和密码";
                } else {
                    if (jsons.code === 0) { //如果返回正常，提示成功
                        word.innerHTML = jsons.message;
                    } else { //如果返回失败，提示信息
                        word.innerHTML = jsons.message;
                    }
                }
            } else {
                alert('error:' + xhr.status);//没成功则返回http状态
            };
        };
    };
    xhr.open("POST", "/carrots-admin-ajax/a/login", true); //传值方式URL异步
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");//设置http头部
    xhr.send($.param(data)); // 发送到服务器,发送请求
};