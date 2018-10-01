var oBbox = document.getElementById("box");
var oUl = document.getElementById("inner-box");
var oLeft = document.getElementById("left");
var oRight = document.getElementById("right");
var cur = 0; //定义变量设置left的值；
var timer = null; /* 定义一个计时器 */
var target = 0; /* 目标值 */
var timer1 = null;
var i = 0
timer = setInterval(autoplay, 2000); //定义计时器执行函数
function autoplay() {
    if (target <= -500) {
        cur = 0;
        target = -100; /* ???? */
    } else {
        target -= 100;
    }
    sport(target);

    btnBottom();
}

oLeft.onclick = function (argument) {
    if (target > -100) {
        cur -= 500;
        target = -400;
    } else {
        target += 100;
    }
    sport(target);
    btnBottom();
}

oRight.onclick = function (argument) {
    if (target <= -500) {
        cur = 0;
        target = -100;
    } else {
        target -= 100;
    }
    sport(target);
    btnBottom();
}
//点击事件
btnBottom(i);
function btnBottom() {
    i = -(target / 100);
    i == 5 ? i = 0 : i;
    var oUl = document.getElementById("ol");
    var oLi = oUl.getElementsByTagName("li");
    for (j = 0; j < oLi.length; j++) {
        oLi[j].style.background = '';
    }
    oLi[i].style.background = '#fff';
}

var oOl = document.getElementById("ol");
var oLi = oOl.getElementsByTagName("li");
for (j = 0; j < oLi.length; j++) {
    oLi[j].index = j;
    oLi[j].onclick = function () {
        target = -(this.index * 100);
        sport(target);
        btnBottom();
    }
}

function sport(tar) {
    clearInterval(timer1);
    timer1 = setInterval(autoplay1, 30);

    function autoplay1() {
        if (tar == cur) {
            clearInterval(timer1);
        } else {
            speed = (tar - cur) / 7;
            speed = (speed > 0) ? Math.ceil(speed) : Math.floor(speed);
            cur = cur + speed;
            oUl.style.left = cur + "%";
        }
    }
}

oBbox.onmousemove = function () {
    clearInterval(timer);
}

oBbox.onmouseout = function () {
    timer = setInterval(autoplay, 2000);
}