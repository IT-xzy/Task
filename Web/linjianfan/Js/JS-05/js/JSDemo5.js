'use strict';



//原生js方法
var value;
var uservalue;
var passvalue;
var user = document.getElementById('user');
var pass = document.getElementById('pass');
var tips = document.getElementById('tips');
var go = document.getElementById('go');

function result(){
    uservalue = user.value;
    passvalue = pass.value;
    value = "name=" + encodeURIComponent(uservalue) + "&pwd=" + encodeURIComponent(passvalue);
    //使用post需要设置请求体的编码格式，将字符串作为URI组件进行编码
/////////////////////////////////////////////////
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if (xhr.readyState == 4){//表示XMLHttpRequest请求现在的状态是已经成功返回数据的
            if ((xhr.status >= 200 && xhr.status < 300) || xhr.status == 304){
                //表示http的状态，200表示成功，304表示请求的资源并没有被修改
                console.log(xhr.responseText);
                var data = xhr.responseText;
                var thedata = JSON.parse(data);
                if (thedata.code == '0'){
                    location.href = 'JSDemo5-1.html';
                }else if (thedata.code == '-5003'){
                    tips.innerHTML = thedata.message;
                }else if (thedata.code == '-5004'){
                    tips.innerHTML = thedata.message;
                }
            }else {
                alert('Request was unsuccessful:') + xhr.status;
            }
        }
    }
    xhr.open('post', '/carrots-admin-ajax/a/login', true);
    xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    //在这里使用setRequestHeader()是为了像html表单那样post数据
    xhr.send(value);//使用post，括号内必须有值，哪怕是个null
}

go.onclick = result;
//////////////////////////////////////////


//jquery ajax方法
/* $('#go').click(function(){
    $.ajax({
        url: '/carrots-admin-ajax/a/login',
        type: 'post',
        dataType: 'json',
        data: {
            name: $('#user').val(),
            pwd: $('#pass').val()
        },
        success: function(data){
            console.log(data);
            if (data.code == '0'){
                location.href = 'JSDemo5-1.html';
            }else if (data.code == '-5003'){
                tips.innerHTML = '此用户不存在';
            }else if (data.code == '-5004'){
                tips.innerHTML = '密码错误';
            }
        },
        error: function(data){
            alert('找不到网页');
        }
    })
}) */
