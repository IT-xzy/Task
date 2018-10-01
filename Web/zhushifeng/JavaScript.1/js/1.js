
// ----------------------------------------------------------

var list = document.getElementsByClassName("let_style");//获取盒子节点
var run = document.getElementById("run");//获取开始闪烁按钮
var stop = document.getElementById("stop");//获取结束按钮节点
var time;


function rgb() {//定义一个取颜色函数
    var r = Math.floor(Math.random() * 265);//在265里随机获取一个数字
    var g = Math.floor(Math.random() * 265);
    var b = Math.floor(Math.random() * 265);
    var rgb = "(" + r + "," + g + "," + b + ")";//三个随机数值组成rgb
    return rgb;//返回函数值
}

function begin() {
    var one = Math.floor(Math.random() * list.length);//one随机获取一个盒子
    var two = Math.floor(Math.random() * list.length);//two随机获取一个盒子
    var three = Math.floor(Math.random() * list.length);//three随机获取一个盒子
    if (one != two && two != three && three != one) {//判断盒子不重复闪
        list[one].style.background = "rgb" + rgb();//给one盒子上色
        list[two].style.background = "rgb" + rgb();//给two盒子上色
        list[three].style.background = "rgb" + rgb();//给three盒子上色
    } else {
        //调用自身
        arguments.callee(); //重新乱序
        // begin();
    }
}



run.onclick = function () {//点击事件
    clearInterval(time);
    time = setInterval(function () {
        for (var i = 0; i < list.length; i++) {
            list[i].style.backgroundColor = '';
        }
        begin();
    }, 1000);
}
stop.onclick = function () {
    clearInterval(time);
    for (var i = 0; i < list.length; i++) {
        list[i].style.backgroundColor = '';
    }
}














