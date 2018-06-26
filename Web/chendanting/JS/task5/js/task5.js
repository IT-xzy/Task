// window.onload= function (){
//     // 给登陆按钮添加点击事件，获取2个输入框的值
//     document.getElementById("login").onclick=function (){
//         var name = document.getElementById("name").value;
//         console.log(name);
//         var password = document.getElementById("password").value;
//         console.log(password);

//         var formData= new FormData();
//         formData.append("name",name);
//         formData.append("pwd",password);
        
//         // 创建XHR对象
//         function createXHR(){
//             //对IE7及其更高版本
//             if (window.XMLHttpRequest){
//                 return new XMLHttpRequest();
//             }
//             //以下为对IE7之前版本兼容
//             else{
//                 return new ActiveXObject("Microsoft.XMLHTTP");
//             }
//         }
//         var xhr = createXHR();
//         console.log(xhr);
        
//         //onreadystatechange事件处理程序
//         xhr.onreadystatechange = function() {
//             if (xhr.readyState == 4) {
//                 if (xhr.status == 200){
//                     console.log(xhr.responseText);
//                     var text = JSON.parse(xhr.responseText);
                    
//                     if(text.message=="success"){
//                         console.log("success");
//                         // window.location.href = "http://dev.admin.carrots.ptteng.com/";
//                     } 
//                     else{
//                         document.getElementById("tip").innerHTML = text.message;
//                     }
//                 } 
//                 else{
//                     console.error("error" + xhr.status);
//                 }
//             }
//         }
//         xhr.open("POST", "/carrots-admin-ajax/a/login", true);
//         xhr.send(formData);
//     } 
// }

// jQ
// 获取输入框值
// $("#login").click(function(){
//     var name = $("#name").val();
//     var password = $("#password").val();
//     console.log(name);
//     console.log(password);

//     $.post("/carrots-admin-ajax/a/login",{
//         name:name, 
//         pwd:password
//     },
//     function(data,status,xhr){
//         data =JSON.parse(data);
//         if(data.message == "success"){
//             window.location.href = "http://dev.admin.carrots.ptteng.com/";
//         } 
//         else{
//             alert(data.message);
//             // $("#tip").text(data.message);
//         }
//     })
// });

// jQ
// 还原提示文字
$("#name").mouseenter(function(){
    $("#tip").text(null);
})
$("#password").mouseenter(function() {
  $("#tip").text(null);
});
// 获取输入框值
$("#login").click(function(){
    var name = $("#name").val();
    var password = $("#password").val();
    console.log(name);
    console.log(password);

    // let obj = {};
    // obj.name = name;
    // obj.pwd = password ;
    
    // 登陆表单验证
    if(name==""|password==""){
        $("#tip").text("请输入正确的用户名或者密码！");
    }
    // 有数据之后再向服务器发送请求
    else{
        $.ajax ({
            type: "POST",
            async: "true",
            data:{
                name: name,
                pwd: password
            },
            url: "/carrots-admin-ajax/a/login",
            // data: obj,
            dataType: "json",
            success: function(data){
                console.log(data);
                // data = JSON.parse(data);
                console.log(data.message);
                if(data.message == "success"){
                    window.location.href = "http://dev.admin.carrots.ptteng.com/";
                    console.log(data);
                } 
                else{
                    alert(data.message);
                }
            }   
        })
    }
})
