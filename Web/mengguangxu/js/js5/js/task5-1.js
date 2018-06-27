// 原生js
/* var word = document.getElementById('word');
 var user = document.getElementById("user");
 var pwd = document.getElementById("pwd");
$('#start').on('click',function(){
    var userValue = user.value;
    var pwdValue = pwd.value;
    console.log(userValue,pwdValue);
    var value = 'name=' +  encodeURIComponent(userValue) + '&pwd=' +  encodeURIComponent(pwdValue);
    console.log(encodeURIComponent(user));
    console.log(value);
    var xhr = new XMLHttpRequest();//浏览器的接口，可以进行HTTP的通信
    xhr.open('POST','/carrots-admin-ajax/a/login',true);//建立通信 拦截名后边还有一部分请求地址需要写上
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');//使用post必须
    xhr.send(value);//发送请求
    xhr.onreadystatechange = function(){//事件监听接口
        if(xhr.readyState === 4){//状态机制，进行到第几步
        if(xhr.status >= 200&&xhr.status < 300 || xhr.status === 304){//服务端状态码，服务器当前状态
            console.log(xhr.responseText);//打印返回数据字符串
            var Data = xhr.responseText;
            var theData = JSON.parse(Data);//解析字符串
            console.log(theData);
            if(theData.code ===0 ){
                location.href = 'task5-2.html';
            }else if(theData.code === -5004){
                word.innerHTML ='密码错误';
            }else if(theData.code === -5003){
                word.innerHTML ='用户名不存在';
            }
        }
    }
    }
 });*/
//jquery方法
$('#start').on('click',function(){
   $.ajax({
       url: '/carrots-admin-ajax/a/login',//请求地址
       type: 'post',//请求方式
       dataType: 'json',//返回的数据类型
       data: {
           name: $('#user').val(),
           pwd: $('#pwd').val()
       },//返回的数据
       success: function(data){//事件监听
           console.log(data);
           if(data.code === 0){
               location.href = 'task5-2.html';
           }else if(data.code === -5003){
               $('#word').text('用户不存在');
           }else if(data.code === -5004){
               $('#word').text('密码错误');
           }
       }
   });
});
