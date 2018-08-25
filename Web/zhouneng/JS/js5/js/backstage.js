$("button").click(function(){
    if(confirm("是否退出当前账号")){
        location.href="../html/login.html"
    }else{
        return;
    }
})