/**
 * Created by odd-hoo on 2017/12/16.
 */
//原生JavaScript写法
//JQuery改写
$(document).ready(function () {
    $('#sign-in').click(function () {
        //获取input数据
        var user = $('#loginname').val();
        var code = $('#pwd').val();
        console.log(user);
        console.log(code);
        var xmlhttp;
        var params = {};        //新建一个空的对象
        params.name=$('#loginname').val();
        params.pwd=$('#pwd').val();
        console.log(params);
        //浏览器兼容
        if (window.XMLHttpRequest)
        {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp = new XMLHttpRequest();
        } else {// code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function() {
            if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
            {
                var jsons = JSON.parse(xmlhttp.responseText);
                //判断input是否为空
                if (user === "" || code === "") {
                    alert("请输入正确的用户名和密码！");
                } else if (jsons.code === 0) {      //网页响应成功
                    window.location.href = "html/backEnd.html";
                }
                else {//提示
                    $('#alert1').html(jsons.message);
                }
            }
        };
        xmlhttp.open("POST",'/carrots-admin-ajax/a/login',true);
        xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xmlhttp.send($.param(params));
    });
});

function keyLogin() {
    if (event.keyCode === 13)  //回车键的键值为13
        $('#sign-in').click(); //调用登录按钮的登录事件
}