// $("#btn").on('click',function(){
//     $.ajax({
//         url:'/carrots-admin-ajax/a/login',
//         type:'POST',
//         async:true,
//         data:{
//             name:$("#username").val(),
//             pwd:$("#password").val()
//         },
//         dataType:"json",
//         success:function(obj){
//             console.log($("#username").val());
//             console.log($("#password").val());
//             console.log(obj);
//             console.log(obj.code);
//             if(obj.code==0){
//                 window.location.href="../task2/setup.html";
//             }
//             else if(obj.code==-5003){
//                 $("#errormessage").text("用户名错误");
//             }
//             else if(obj.code==-5004){
//                 $("#errormessage").text("密码错误");
//             }
//         }     
//     });
// });

$("#btn").on('click',function(){
    $.ajax({
        url:'/carrots-admin-ajax/a/login',
        type:'POST',
        async:true,
        contentTypt:'application/json',
        dataType:"json",
        data:{
            name:$("#username").val(),
            pwd:$("#password").val()
        },
        
        success:function(obj){
            console.log($("#username").val());
            console.log($("#password").val());
            console.log(obj);
            console.log(obj.code);
            if(obj.code==0){
                window.location.href="../task2/setup.html";
            }
            else{
                $("#errormessage").text(obj.message);
            }
        }     
    });
});