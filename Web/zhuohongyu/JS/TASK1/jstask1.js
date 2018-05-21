console.log("JS成功执行进来;")
console.log("JS是否存在逻辑问题、变量问题、参数问题等等")
console.log("JS符号是否存在问题")




var sti;//定义全局变量
var div=document.getElementsByClassName("box");
var i=0;
function Intveral() {
    clearInterval(sti);
    // start();//点击按钮立即变换颜色，如果不设则点击按钮1s后开始变换颜色；
    sti = setInterval("start()", 1000);
}

function stop() {
    clearInterval(sti);

    for(
        var i = 0;
        i < div.length;
        i++
        ) {
        div[i].style.backgroundColor = '#ffa500';
    }
}

function color() {
    var box_color = "#" + (((Math.random()*9)*0xffffff>>0).toString(16)).slice(-6);

    if (box_color=="#ffa500") {
        color();
    }
    else {
        return box_color;
    }
}

function start() {
    var box1 = Math.floor(Math.random()*9);
    var box2 = Math.floor(Math.random()*9);
    var box3 = Math.floor(Math.random()*9);

    for(
        var i = 0;
        i < div.length;
        i++
        ) {
    div[i].style.backgroundColor = '#ffa500';
    }

    if (box1!=box2&&box1!=box3&&box2!=box3) {
        document.getElementById(box1).style.backgroundColor = color();
        document.getElementById(box2).style.backgroundColor = color();
        document.getElementById(box3).style.backgroundColor = color();
    }
    
    else {
        start();
    }
}
  



  
    
    // if (box1 = document.getElementById(0)||document.getElementById(0)||document.getElementById(0) ) {
    //     return start;
    // } 
    // else {
        // var color = "#" + Math.floor(Math.random()*0xffffff).toString(16);
        // document.getElementById(box1).style.backgroundColor = color();
        // box2.style.backgroundColor = color();
        // box3.style.backgroundColor = color();
    // }

    
    // document.getElementById(Math.floor(Math.random()*10)).style.backgroundColor = color;
    

