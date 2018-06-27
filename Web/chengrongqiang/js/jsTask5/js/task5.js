// 先获取文本框中的值看是否为空,
// 不为空时与上传至服务器并请求服务器返回的数据
//
// 原生
$('#login').on('click', function() {
        var data = {};
        data.name = $('#account').val();
        data.pwd = $('#password').val();
        console.log(data)
        if (data.name === '' && data.pwd === '') {
            $(".tips").text("请输入用户名和密码")
        } else {
            var request = new XMLHttpRequest();
            request.responseType = 'json'
            request.onreadystatechange = function() {
                if (request.status === 200 && request.readyState === 4) {
                    console.log(123)
                    var text = request.response;
                    console.log(text.code);
                    switch (text.code) {
                        case 0:
                            window.location.href = "http://dev.admin.carrots.ptteng.com/#/dashboard";
                            break;
                        case -5003:
                            $(".tips").text("用户不存在")
                            break;
                        case -5004:
                            $(".tips").text("密码错误")
                    }
                }
            }
            request.open('POST', '/carrots-admin-ajax/a/login', true)
            request.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
            var data =
                'name=' +
                encodeURIComponent(data.name) +
                '&pwd=' +
                encodeURIComponent(data.pwd);
            request.send(data)
        }
    })
    // // jQuery
    // $('#login').on('click', function() {
    //     var data = {};
    //     data.name = $('#account').val();
    //     data.pwd = $('#password').val();
    //     console.log(data)
    //     if (data.name === '' && data.pwd === '') {
    //         $(".tips").text("请输入账号和密码")
    //     } else {
    //         var request = $.post('/carrots-admin-ajax/a/login', { name: data.name, pwd: data.pwd }, function() {
    //             if (request.status === 200 && request.readyState === 4) {
    //                 console.log('请求成功');
    //                 console.log(request);
    //                 console.log(request.responseText); //此时是字符串
    //                 var response = JSON.parse(request.responseText);
    //                 console.log(response);
    //                 switch (response.code) {
    //                     case 0:
    //                         window.location.href = "http://dev.admin.carrots.ptteng.com/#/dashboard";
    //                         break;
    //                     case -5003:
    //                         $(".tips").text("用户不存在");
    //                         break;
    //                     case -5004:
    //                         $(".tips").text("密码错误");
    //                         break
    //                 }
    //             }
    //         })
    //     }
    // })