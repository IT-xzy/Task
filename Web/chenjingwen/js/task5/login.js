
document.getElementById("btn").onclick=function(){ 
    var user=document.getElementById("username").value;
    var password=document.getElementById("password").value;
    var xhr=new XMLHttpRequest();//创建请求对象
    xhr.open('Post','/carrots-admin-ajax/a/login',true);//链接服务器
    xhr.setRequestHeader('content-type','application/x-www-form-urlencoded');
    xhr.send("name="+user+"&pwd="+password);//发送数据
    xhr.onreadystatechange=function(){
        if(xhr.readyState==4){//请求已完成，且响应已就绪
            console.log(xhr);
            if(xhr.status==200){//请求成功
                console.log(xhr.responseText);
                var data=xhr.responseText; 
                data=JSON.parse(data);
                console.log(data);
                if(data.code==0){
                    window.location.href="../task2/setup.html";
                }
                else{
                    document.getElementById("errormessage").innerHTML=data.message;
                }
            }
            else{
                console.log("错误码："+xhr.status);
            }
        }
    };
};
