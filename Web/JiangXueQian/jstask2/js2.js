var pg1 = document.getElementById("simpleOne");
var pg2 = document.getElementById("simpleTwo");
if(pg1){
    pg1.onclick = function () { start() };
}else  if (pg2){
    pg2.onclick = function () { start() };
}
function start() {
    window.location.href="matching.html";
}
function peoplenum(){
    var a=document.getElementById("peopleNum").value;
    if( a>=4 && a <= 18) {
        window.location.href = "csstask7.html";
     }else{
    alert("请输入有效数字[4-18之间]");
 }
}

