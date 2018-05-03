var time;
function start() {
    clearInterval(time);
    time =  setInterval(blink ,1000)
    //1000毫秒闪一次
}
var square=document.getElementsByClassName("square");
//获取9个正方节点
function orange() {
    for(var i =0; i< square.length;i+=1) {
        square[i].style.background="orange"
    }
}
function blink() {
    orange()
    var box1 = Math.floor(Math.random()*square.length);
    var box2 = Math.floor(Math.random()*square.length);
    var box3 = Math.floor(Math.random()*square.length);
    if (box1!=box2&&box1!=box3&&box2!=box3) {
        square[box1].style.background = getcolor();
        square[box2].style.background = getcolor();
        square[box3].style.background = getcolor()
    }
    else {
        blink();
    }
    // var num=[];
    // var test=[];
    // for (var a=0;a<3;a+=1){
    //     do {num[a]=Math.floor(Math.random()*square.length);}
    //     //产生随机数
    //     while(test.indexOf(num[a])>=0);
    //     //检测是否已经存入test,是则再循环一次
    //     test.push(num[a]);
    //     //将随机数存入test
    // }
    // square[num[0]].style.background = getcolor();
    // square[num[1]].style.background = getcolor();
    // square[num[2]].style.background = getcolor()
}
function stop() {
    orange()
    clearInterval(time)
}
function getcolor() {
    var r = Math.floor(Math.random() * 256);
    var g = Math.floor(Math.random() * 256);
    var b = Math.floor(Math.random() * 256);
    return "rgb(" + r + "," + g + "," + b + ")";
    //生成随机颜色
}


