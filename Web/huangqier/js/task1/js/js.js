/*首先取出这九个格子*/
var box = document.getElementsByClassName("box");

/*遍历9个格子重置颜色*/
function reset() {
    for (var i = 0; i < box.length; i++) {
        box[i].style.background = "#fea500";
    }
}

/*做一个随机颜色函数返回随机颜色*/
function color() {
    var r, g, b;
    r = Math.floor(Math.random() * 256);
    g = Math.floor(Math.random() * 256);
    b = Math.floor(Math.random() * 256);
    return 'rgb(' + r + ',' + g + ',' + b + ')';
}

/*开始闪*/
function change() {//随机抽取三个格子变色
    reset();
    var a = [];//定义一个放格子下标的空数组
    do {
        for (var i = 0; i < 3; i++) {//遍历空数组并在空数组存放格子下标0~8中任意的三个
            a[i] = Math.floor(Math.random() * 9);
        }
    }
    while (a[0] == a[1] || a[0] == a[2] || a[1] == a[2]) ;
    //如果抽出的任意三个下标互不相等则将这三个下标所对应的格子变色
    box[a[0]].style.background = color();
    box[a[1]].style.background = color();
    box[a[2]].style.background = color();
}

var z;//定义一个名叫z的全局变量
function start() {//触发变色
    clearInterval(z);//停止周期调用函数
    z = setInterval("change()", 1000);//将周期调用函数放入z变量并直接触发
}

/*结束闪*/
function stop() {//停止变色并重置
    clearInterval(z);//停止周期调用函数
    reset();
}
