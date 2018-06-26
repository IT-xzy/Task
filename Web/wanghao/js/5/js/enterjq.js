$("button").on("click", function () {
    let admin = "name=" + $(".ip").val() + "&pwd=" + $(".id").val();
    console.log(admin);
    // console.log(1);
    $.post( "../carrots-admin-ajax/a/login",admin,function(data,status){
       data=JSON.parse(data);
    //    console.log(4);
       if(data.message=="success"){
// console.log(2)
           window.location.href="http://dev.admin.carrots.ptteng.com/"
       }
       else{
        $(".massge").text(data.message);
       }
    });
//    console.log(3)
});