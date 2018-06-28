// //jq
$('.btn').click(function(){
    var input = $('.in-one')[0].value;
    var input_2 = $('.in-two')[0].value;
    var p = document.getElementsByClassName('p-one')[0];
    var click;
    $.post('/carrots-admin-ajax/a/login',{
        name:input,
        pwd:input_2   
    },function(res){
        var upload = JSON.parse(res);
        // console.log(upload);
        clearTimeout(click);
        if(upload.code === -5003){
            p.innerHTML = upload.message;
            click = setTimeout(function(){
                p.innerHTML = "";
            },2000);
        }   
        if(upload.code === -5004){
            p.innerHTML = "";
            p.innerHTML = upload.message;
            click = setTimeout(function(){
                p.innerHTML = "";
            },2000);
        }
        if(upload.code === 0){
            p.innerHTML = "";
            window.location.href="http://www.jnshu.com" 
        }  
    })
})  

// name=admin&pwd=123456
//js

// function btn(){
//     var input = document.getElementById('in').value;
//     var input_2 = document.getElementById('in-1').value;
//     // console.log(input);
//     // console.log(input_2);
//     var p = document.getElementsByClassName('p-one')[0];
//     var p1 = document.getElementsByClassName('p-one')[1];
//     if(input == 0 || input >=6){
//         p.style.display = 'block';
//         p.innerHTML = '没有此用户';
//     }else{
//         p.style.display = 'none';
//     };
//     if(input_2 == 0 || input_2 >= 7){
//         p1.style.display = 'block';
//         p1.innerHTML = '密码错误';
//     }else{
//         p1.style.display = 'none';
//     };
//     var url = '/carrots-admin-ajax/a/login';
//     var request = new XMLHttpRequest();
//     request.onload = function(){
//         if(request.status == 200){
//             displayContent(request.responseText)
//         }
//     };
//     request.open('POST',url);
//     request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
//     request.send("name=" + input +"&pwd=" + input_2);
//     function displayContent(content){
//         var dd = JSON.parse(content);
//         console.log(dd)
//         if(dd.code === -5003){
//             alert(dd.message);
//         }
//         if(dd.code === -5004){
//             alert(dd.message)
//         }
//         if(dd.code === 0){
//             window.location.href="http://www.jnshu.com" 
//         }
//     }
// }