 // 获取所有的dom节点
 var login = document.getElementById('login'),
 user  = document.getElementById('user'),
 password = document.getElementById('password'),
 showMsg=document.querySelector('.error-show');
//给按钮天剑点击事件
login.onclick = function () {
 var data;
 //魔板字符串实现x-www-form-urlencoded格式
 var dataStr = `name=${user.value}&pwd=${password.value}`;

var dataStr =JSON.stringify(json);
 //创建xhr对象
 var xhr = new XMLHttpRequest();
 //触发onreadystatechange事件
 xhr.onreadystatechange = function () {
     //判断已经完成接受数据
     if (xhr.readyState === 4) {
         if ((xhr.status >= 200 && xhr.status < 300) || xhr.status == 304) {
             //解析字符串
             data=JSON.parse( xhr.responseText);
             if(data.code ===0){//成功
                location.href="result.html";
             }else if(data.code ===-5004) {//密码错误
                 showMsg.innerHTML=data.message;
             }else{                       //账户错误
                 showMsg.innerHTML=data.message;                            
             }
         } else {
           alert('请求出错');
         }
     }
 };
 //添加一个异步请求以待发送
 xhr.open('post', '/carrots-admin-ajax/a/login', true);
 //使用setRequestHeader设置Content-Type，来改变发送请求格式
 xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
// xhr.setRequestHeader('Content-Type','application/json');
 //发送请求
 xhr.send(dataStr);
};