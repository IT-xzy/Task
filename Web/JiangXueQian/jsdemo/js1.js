//-------------------------------------------获取DOM------------------------------------------------------
var startBotton = document.getElementById("start");
var endBotton = document.getElementById("end");
var list = document.getElementsByClassName("block");
var time;
//------------------------------------------随机获取颜色------------------------------------------------------
function  color() {
    var r =Math.floor(Math.random()*256);
    var g =Math.floor(Math.random()*256);
    var b =Math.floor(Math.random()*256);
    return  "rgb("   + r +   ","  + g +   " ,"  + b+   ")";
}
//-------------------------------------------随机获取3和数以及赋予颜色----------------------------------------------------------
function begin() {
    for(var i =0;i < list.length;i++){
        list[i].style.backgroundColor = "";
    }
    var one = Math.floor(Math.random()*list.length);
    var two = Math.floor(Math.random()*list.length);
    var three = Math.floor(Math.random()*list.length);
    if( one!=two && two!=three && three!=one){
        list[one].style.backgroundColor = color();
        console.log(list[one]);
        list[two].style.backgroundColor = color();
        console.log(list[one]);
        list[three].style.backgroundColor = color();
        console.log(list[one]);
    }else{
        begin();
    }
}
//------------------------------------------------------点击事件--------------------------------------------------------------
startBotton.onclick=function displayStart (){
    clearInterval(time);
    time = setInterval(function(){begin();},1000);
}
endBotton.onclick=function displayEnd() {
    clearInterval(time);
    for(var i =0;i < list.length;i++){
        list[i].style.backgroundColor = "rgb("   + 255 +   ","  + 160+   " ,"  + 1+   ")";
    }
}