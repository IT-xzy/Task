$(document).ready(function () {
//快速学习
    $('#Obtain').click(function () {
        //获取两个值
        var user = $('#account').val();
        var code = $('#passWord').val();
        //打印
        console.log(user);
        console.log(code);
        var xmlhttp;
        var params = {};
        //数据放入数组
        params.name = $('#account').val();
        params.pwd = $('#passWord').val();
        //打印数组
        console.log(params);

        //检测
        if (window.XMLHttpRequest)
        {
            //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
            xmlhttp=new XMLHttpRequest();
        }
        else
        {
            // IE6, IE5 浏览器执行代码
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }

        xmlhttp.onreadystatechange = function() {
            if (xmlhttp.readyState === 4 && xmlhttp.status == 200)
            {
                var jsons = JSON.parse(xmlhttp.responseText);
                //判断input是否为空
                if (user === ""  || code === ""){
                    alert("请输入正确的用户名和密码");
                } else if (jsons.code === 0){
                    window.location.href = "html/home.html";
                } else { //提示
                    $('#return').html(jsons.messaccountage);
                }
            }
        };

        xmlhttp.open("POST","/carrots-admin-ajax/a/login",true); //传值方式  URL 异步
        xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xmlhttp.send($.param(params));  //.param 序列化一个对象  发送到服务器   发送请求
    })

});






