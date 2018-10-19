// 获取九宫格DOM节点
var initiate = document.getElementsByTagName("main")[0].children;
// 声明定时器全局变量
var time;

// 获取0-8的3个整数随机数
function random_digit() {
    var one = Math.floor(Math.random() * 9);
    var two = Math.floor(Math.random() * 9);
    var three = Math.floor(Math.random() * 9);

    // while循环判断生成的3个随机数不重复
    while (one == two || one == three || two == three) {
        one = Math.floor(Math.random() * 9);
        two = Math.floor(Math.random() * 9);
        three = Math.floor(Math.random() * 9);
    }

    // 设置三个随机格子的颜色
    initiate[one].style.backgroundColor = "rgb" + color();
    console.log(color())
    initiate[two].style.backgroundColor = "rgb" + color();
    console.log(color())
    initiate[three].style.backgroundColor = "rgb" + color();
    console.log(color())
}

// 生成三个格子的随机颜色
function color() {
    var rgb;
    var r = Math.floor(Math.random() * 255);
    var g = Math.floor(Math.random() * 255);
    var b = Math.floor(Math.random() * 255);
    rgb = "(" + r + "," + g + "," + b + ")"
    return rgb;
}

// 点击开始按钮开始变换颜色
function begin() {
    clearInterval(time);
    time = setInterval(function () {
        for (var i = 0; i < 9; i++) {
            initiate[i].style.backgroundColor = "orange";
        }
        random_digit();
    } , 1000); //颜色变换时间1000毫秒
}

// 点击关闭按钮结束变换颜色
function off() {
    clearInterval(time);
    for (var i = 0; i < 9; i++) {
        initiate[i].style.backgroundColor = "orange";
    }

}

