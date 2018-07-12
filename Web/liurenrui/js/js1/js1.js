console.log("导入JS文件")

var divarr=document.getElementsByClassName("box");
var int;
function start(){  
    clock();//立即执行 
    clearInterval(int);//防止多次点击开始，闪动加/速
    int =setInterval(clock, 1000);//每1000毫秒执行一次
}//开始按钮

function bg(){
    return '#'+('00000'+(Math.random()*0x1000000<<0).toString(16)).substr(-6);
}//随机取颜色

function clock(){
    for (var i=0;i<divarr.length;i++){
        divarr[i].style.backgroundColor="orange";
    }//恢复颜色
    var x=Math.floor(Math.random()*9);
    var y=Math.floor(Math.random()*9);
    var z=Math.floor(Math.random()*9);
   
    if (x!=y&&x!=z&&y!=z){
        divarr[x].style.backgroundColor=bg();
        divarr[y].style.backgroundColor=bg();
        divarr[z].style.backgroundColor=bg();
    }//避免重复
    
    else{
        clock();
    }
}

function stop(){
    clearInterval(int);
    for (var i=0;i<divarr.length;i++){
        divarr[i].style.backgroundColor="orange";
    }//恢复颜色
}//停止按钮