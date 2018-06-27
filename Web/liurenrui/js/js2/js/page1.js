console.log("引入JS文件");

var s=document.getElementById("second");
var num=5;
function time(){ 
    document.getElementById("second").innerHTML=num;  
    if( num<=0){
        location.replace("page2.html");
        return num=0;
    }
    num=num-1;
}
setInterval(time,1000);