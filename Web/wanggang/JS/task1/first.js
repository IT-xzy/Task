var squares = document.getElementsByClassName("square");
//获取颜色
function color() {
    var red = Math.floor(Math.random() * 255);
    var blue = Math.floor(Math.random() * 255);
    var green = Math.floor(Math.random() * 255);
    return "rgb(" + red +"," + blue + "," + green + ")";
}
//获取随机格子
function getRandom() {
    var list = Array.from(squares); //将集合转化为数组
    var result = [];
    for (var i = 0; i < 3; i++) {
        var x = Math.floor(Math.random() * list.length);
        result.push(list.splice(x, 1)[0]); //将随机选择的对象删除，且返回添加给空数组
    }
    return result;
}
//重置颜色
function reset() {
    for(var i = 0;i<squares.length;i++) {
        squares[i].style.background = "orange";
    }
}
//改变颜色
function changeColor() {
    reset();
    var result = getRandom();
    for (var i = 0; i < result.length; i++) {
        result[i].style.background = color();
    }
}
//声明变量作为定时器开关。
var startButton;
//开始
function start() {
    //重置定时器
    clearInterval(startButton);
    startButton = setInterval("changeColor()",1000);
}
//停止
function stop() {
    for(var i = 0;i<squares.length;i++) {
        squares[i].style.background = "orange";
    }
    clearInterval(startButton);
}