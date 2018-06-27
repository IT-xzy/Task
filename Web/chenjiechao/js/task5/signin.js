// $(function () {
//     $(".signin").on("click", function () {
//         txt = $('#text').val(); //获取账号
//         p = $('#password').val(); //获取密码
//         console.log(txt);
//         console.log(p);
//         $.post('/carrots-admin-ajax/a/login', {//提交数据
//                 name: txt,
//                 pwd: p
//             },
//             function (data, status) {//返回数据
//                 console.log(status);
//                 console.log(data);
//                 var jsons = JSON.parse(data);//由JSON字符串转换为JSON对象
//                 console.log(jsons.message);
//                 if (jsons.code === 0) {
//                     window.location.href = "http://www.jnshu.com/home"
//                 } else {
//                     $(".error").html(jsons.message);//报错
//                 }
//         })
//     })
// })




var userName = document.getElementById('text'); //获取用户名
var userPwd = document.getElementById('pwd'); //获取密码
var error = document.getElementById('er');//获取用于报错的p标签
nameTrue = false;//判断输入框是否为空或格式不正确
pwdTrue = false;//判断密码框是否为空或格式不正确

function login() {
var naOK = checkName();
console.log(naOK);
var pwOK = checkPwd();
console.log(pwOK);
    if (nameTrue && pwdTrue) {
        //创建异步对象
        var xhr = new XMLHttpRequest();
        //设置请求的参数。包括：请求的方法，请求的url
        xhr.open('post', '/carrots-admin-ajax/a/login', true);
        //使用post提交数据，必须添加此行
        xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
        //发送请求
        xhr.send("name=" + userName.value + "&pwd=" + userPwd.value);
        console.log(userName.value);
        console.log(userPwd.value);
        //注册事件。onreadystatechange事件，状态改变时就会调用。
        //如果要在数据完整请求回来的时候才调用，我们需要手动写一些判断的逻辑。
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4 && xhr.status == 200) {
                //如果能够进入到这个判断，说明数据完美的回来了。并且请求的页面是存在的
                //在注册的事件中，获取返回的内容，并修改页面的显示
                var jsons = JSON.parse(xhr.responseText);//由JSON字符串转换为JSON对象
                console.log(jsons);
                if (jsons.code === 0) {//判断code是否为0
                    window.location.href = "http://www.jnshu.com/"
                } else {
                    error.innerHTML = jsons.message;//页面提示错误信息
                }
                // console.log('数据返回成功');
                // //数据是保存在异步对象的属性中
                // console.log(xhr.responseText);
                // //修改页面的显示
                // document.querySelector('.error').innerHTML = xhr.responseText;
            }
        }
    }
}

function checkName() {
    var reg = /^[a-z_-]{4,16}$/; //匹配小写字母开头，4~10位数。
    var nameVal = userName.value;
    if (nameVal === '') {//如果为空
        error.innerHTML = "用户名不能为空";
    } else if (!reg.test(nameVal)) {//test方法检测字符串是否符合正则表达式，!表示不符合
        error.innerHTML = "用户名不合法";
    } else {
        nameTrue = true;
    }
    return nameTrue;//返还nameTrue的值
}

function checkPwd() {
    var reg = /^[a-z0-9_-]{6,18}$/; //匹配字母或者数字开头，6~10位数。
    var pwdVal = userPwd.value;
    if (pwdVal === "") {
        error.innerHTML = "密码不能为空";
    } else if (!reg.test(pwdVal)) {
        error.innerHTML = "密码格式错误";
    } else {
        pwdTrue = true;
    }
    return pwdTrue;
}
// checkName.onchange = function(){

// }