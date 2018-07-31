//获取事件源
var sudoku = document.getElementsByClassName("box");
//获取颜色
function color() {
    var r = Math.floor(Math.random() * 256);
    var g = Math.floor(Math.random() * 256);
    var b = Math.floor(Math.random() * 256);
    //return "rgb("+r+","+g+","+b+")";
    return `rgb(${r},${g},${b})`; //所有方法的拼接都可以用ES6新特性`其他字符串{$变量名}`替换
}
//获取随机格子
function getRandom() {
    var list = Array.from(sudoku); //将集合转化为数组
    var result = [];
    for (var i = 0; i < 3; i++) {
        var x = Math.floor(Math.random() * list.length);
        result.push(list.splice(x, 1)[0]); //将随机选择的对象删除，且返回添加给空数组
    }
    return result;
}
//改变颜色
function changeColor() {
    //重置颜色
    for (var i = 0; i < sudoku.length; i++) {
        sudoku[i].style.backgroundColor = "orange";
    }
    var result = getRandom();
    for (var i = 0; i < result.length; i++) {
        result[i].style.backgroundColor = color();
    }
}

//声明变量作为定时器开关。
var startButton;
//开始
function start() {
    //重置定时器
    clearInterval(startButton);
    startButton = setInterval("changeColor()", 1000);
    document.getElementsByTagName("button")[0].disabled=true;
}
//停止
function stop() {
    for (var i = 0; i < sudoku.length; i++) {
        sudoku[i].style.background = "orange";
    }
    clearInterval(startButton);
    document.getElementsByTagName("button")[0].disabled=false;
}