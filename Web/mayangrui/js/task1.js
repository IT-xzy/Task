var auto;

function start() {
    stop();
    auto = setInterval(select, 1000);
}

//每一秒钟运行一次select();
function stop() {
    color();
    clearInterval(auto);
}

var box = document.getElementsByClassName('box');

function select() {
    color();
    //给其他盒子添加颜色之后选取三个小盒子附上颜色
    for (var i = 0; i < 10000; i++) {
        var num1 = Math.floor(Math.random() * 9);
        var num2 = Math.floor(Math.random() * 9);
        var num3 = Math.floor(Math.random() * 9);
        if (num1 !== num2 && num2 !== num3 && num1 !== num3) {
            break;
        }
    }
    $(".box").eq(num1).css("background-color", getcolor());
    $(".box").eq(num2).css("background-color", getcolor());
    $(".box").eq(num3).css("background-color", getcolor());
}

function getcolor() {
    var r = Math.ceil(Math.random() * 255);
    var g = Math.ceil(Math.random() * 255);
    var b = Math.ceil(Math.random() * 255);
    return "rgb(" + r + "," + g + "," + b + ")";
}

function color() {
    for (var i = 0; i < 9; i++) {
        box[i].style.background = "orange";
    }
}



