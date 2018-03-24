var box=document.getElementsByClassName('box');
var int;
function start() {
    clearInterval(int);
    int=setInterval(select,1000);//1000毫秒运行一次select函数
}
function select() {
    orange();
    //运行orange函数填充所有盒子颜色
    var x = 3;
    var first = [];
    for (var a = 0; a < box.length; a++) {
        first[a] = a;
        console.log(first[a]);
    }//first[a] = a；中的a跟a
    var second = [];
    for (var b, j = 0; j < x; j++) {
        do {
            b = Math.floor(Math.random() * box.length);
        }
        while (first[b] == null);
        first[b] = null;
        //first[b]、first[a]的a、b没有直接关系，first[]表示的是一个数组
        second[j] = box[b];
        //first[b]、box[b]、不是一个数组但是b却是一样的；
        console.log(second[j]);
    }
    second[0].style.background=color();
    second[1].style.background=color();
    second[2].style.background=color();
    //三个盒子背景色用函数color（）选出的颜色覆盖
}

function color() {
    var r = Math.floor(Math.random()*256);
    var g = Math.floor(Math.random()*256);
    var b = Math.floor(Math.random()*256);
    return "rgb(" + r + ',' + g + ',' + b + ")";
}//随机选出一个颜色
function stop() {
    orange();//开始orange函数
    clearInterval(int);//清除int
}
function orange() {
    for(var i = 0; i < box.length ; i++) {
        box[i].style.background="orange";
    }
}