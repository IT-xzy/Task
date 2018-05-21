// 获取方格标签
var block = document.getElementById("block").getElementsByTagName("div");
//获取开始按钮
var start = document.getElementById("start");
// 获得结束按钮
var ended = document.getElementById("ended");

function clearColor() {
    for (var e = 0; e < block.length; e++) {
        block[e].style.backgroundColor = "#ffa500";
    }
}

function colors() {
    var x = Math.floor((Math.random() * block.length));
    var y = Math.floor((Math.random() * block.length));
    var z = Math.floor((Math.random() * block.length));//三个变量用来装随机得到的三个小盒子的节点；
    if (x !== y && y !== z && z !== x) {
        var sty = "0123456789abcdef";//16进制颜色值，
        var r = "#";
        var g = "#";
        var b = "#";//三个变量用来装随机得到的三个颜色字符串；
        for (var j = 0; j < 6; j++) {
            r = r + sty.charAt(Math.random() * sty.length);
            g = g + sty.charAt(Math.random() * sty.length);
            b = b + sty.charAt(Math.random() * sty.length);
        }
        clearColor();
        if (r !== g && g !== b && b !== r) {
            block[x].style.backgroundColor = r;
            block[y].style.backgroundColor = g;
            block[z].style.backgroundColor = b;
        } else {
            return colors();
        }
    }
    else {
        return colors();
    }
}
var timer;
var value = 0;
start.onclick = function () {
    if(value === 0) {
        timer = setInterval("colors()", 1000);
    }
    else {
        return false;
    }
    value = 1;
};

ended.onclick = function () {
    clearColor();
    clearInterval(timer);
    value = 0;
};


