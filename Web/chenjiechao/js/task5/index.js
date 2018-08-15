;(function(){
    'use strict';
    var userName = document.getElementById('username'),
        userPwd  = document.getElementById('userpwd'),
        hint     = document.getElementById('hint'),
        btnLogin = document.getElementById('login'),
        nameOk   = false,
        pwdOk    = false; 

    // 封装ajax
    function ajax (o) {
        // 对参数进行处理
        o.method = o.method.toLowerCase() || 'post';
        o.url = o.url || '';
        o.async = o.async || true;
        o.data = o.data || null;
        o.success = o.success || function () {};
        o.error = o.error || function () {};

        var xhr = new XMLHttpRequest();
        // 将o.data数据改为url的字符串形式
        var arr = [];
        var data = '';
        for (var i in o.data) {
            arr.push(i + '=' + o.data[i]);
        }
        data = arr.join('&');

        // 判断请求方式，并做处理
        if (o.method === 'post') {
            xhr.open(o.method, o.url, o.async);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xhr.send(data);
        } else {
            var url = o.url + '?' + data; 
            xhr.open(o.method, url, o.async);
            xhr.send(null);
        }

        xhr.onreadystatechange = function () {
            // 对状态码进行判断，并将返回值返回给两个方法
            if (xhr.readyState === 4 && xhr.status === 200) {
                // 访问正常返回数据
                o.success(xhr.responseText);
            } else {
                // 返回错误码
                o.error(xhr.status);
            }
        };
    }

    btnLogin.onclick = function () {
        // 当用户名和密码都合法，调用ajax方法;
        if (nameOk && pwdOk) {
            ajax({
                method: 'post',
                url: '/carrots-admin-ajax/a/login',
                async: true,
                data: {
                    name: userName.value,
                    pwd: userPwd.value
                },
                success: function (str) {
                    str = JSON.parse(str);
                    if (str.message === 'success') {
                        hint.innerHTML = '登录成功';
                    } else {
                        hint.innerHTML = str.message;
                    }
                },
                error: function (str) {
                    hint.innerHTML = '请求错误，代码：' + str;
                }
            });
        }      
    };

    userName.onchange = function () {
        var reg = /^[a-zA-Z]\w{4,16}$/; // 匹配字母开头，长度在5-16位之间的字符
        var name = userName.value;
        if (name === '') {
            hint.innerHTML = '用户名不能为空';
        } else if (!reg.test(name)) {
            hint.innerHTML = '用户名不合法'
        } else {
            hint.innerHTML = '';
            nameOk = true;
        }
    };

    userPwd.onchange = function () {
        var reg = /^\S{5,18}$/; // 匹配5-18位之间的非空字符
        var pwd = userPwd.value;
        if (pwd === '') {
            hint.innerHTML = '密码不能为空';
        } else if (!reg.test(pwd)) {
            hint.innerHTML = '密码格式错误';
        } else {
            hint.innerHTML = '';
            pwdOk = true;
        }
    };

})();