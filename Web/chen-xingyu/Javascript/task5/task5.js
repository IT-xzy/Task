//原生JS写法

// function ajax() {
//     var username=document.getElementById('name').value,
//         password=document.getElementById('pwd').value,
//         loginMsg=document.getElementById('loginMsg'),
//         xhr=new XMLHttpRequest();
//     xhr.onreadystatechange=function () {
//         if(xhr.readyState===4) {
//             if((xhr.status>=200&&xhr.status<300)||xhr.status===304){
//                 var theData=JSON.parse(xhr.responseText);
//                 if(theData.message==="success"){
//                     loginMsg.innerText = "登陆成功";
//                     console.log(this);
//                 }
//                 else {
//                     loginMsg.innerText = theData.message;
//                 }
//                 console.log(xhr.statusText);
//                 console.log(theData);
//             }
//         }
//     };
//     var postValue = 'name='+encodeURIComponent(username)+'&pwd='+encodeURIComponent(password);
//     xhr.open("POST","/carrots-admin-ajax/a/login",true);
//     xhr.setRequestHeader('Content-type','application/x-www-form-urlencoded');
//     xhr.send(postValue);
// }
// var btn=document.getElementsByTagName('button')[0];
//     btn.onclick = function () {
//     ajax();
// };



// jQuery写法
$('button').on('click', function (){
        $.ajax({
            type: 'POST',
            url : '/carrots-admin-ajax/a/login',
            dataType : 'json',
            data : {
                name: $('#name').val(),
                pwd: $('#pwd').val()
            },
            success : function (data) {
                if(data.message==='success'){
                    $('#loginMsg').text('登陆成功');
                    // location.href='../task6/task6.html';
                }
                else{
                    $('#loginMsg').text(data.message);
                }
            }
        })
    }
);
$('body').on('keydown',function (e) {
    if(e.keyCode===13){
        $('button').onclick;
    }
});


