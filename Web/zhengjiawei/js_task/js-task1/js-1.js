var cell = document.getElementById("box").getElementsByTagName("span"); /* 获取9个格子 */
var lengthNum = cell.length; /* 获取节点数组长度 */
childNode = []; /* 存放不重复的随机数 */
var stopRepeat = null; /*  */

function play() {
    color();
    clearInterval(stopRepeat);
    stopRepeat = setInterval(function () {
        color();
    }, 1000)
} /* 点击开始，调用随机三个函数，清除间歇调用，开启间歇调用； */

function stop() {
    clearInterval(stopRepeat);
} /* 关闭间歇调用 */

function color() {
    childNode = []; /* 如果不设置这个数组，格子的位置不会被重置！ */

    for (; childNode.length < lengthNum;) {
        getRandomNumer();
    } /* 存放9个随机数 */

    resetColor();

    for (var i = 0; i < 3; i++) {
        cell[childNode[i]].style.background = getRandomColor();
    } /* 给三个随机格子赋予随机颜色 */
}

function resetColor() {
    for (var i = 0; i < childNode.length; i++) {
        cell[i].style.background = "#f3a533";
    }
} /* 重置颜色 */

function getRandomColor() {
    var letter = '0123456789ABCDEF';
    var color = "#";
    for (var i = 0; i < 6; i++) {
        color += letter[Math.floor(Math.random() * 16)]
    }
    return color;
}
/* 十六进制颜色hex的组成由letter中的16个Unicode组成，利用string类型的length特性，
for循环获取六个随机的Unicode字符在和字符串#结合，就得到了一个随机的十六进制颜色 */



function getRandomNumer() {
    var random = parseInt(Math.random() * lengthNum);
    for (var i = 0; i < cell.length; i++) {
        if (random == childNode[i]) {
            return;
        }
    }
    childNode.push(random);
} /* 获取不重复的随机数 */







/* for循环
获取随机数
遍历比较，不重复，随机数放入数组
如果重复，继续循环， */

/* 
几个变量
几个函数
1、创建随机颜色函数
2、执行三个随机并且赋颜色的函数
3、停止执行的函数

1、获取三个随机数
2、修改随机数的颜色
3、添加定时器，清除定时器；
4、停止定时器， */