function bga() { //var三个变量，得到三组随机数
    var r = Math.floor(Math.random() * 256);
    var g = Math.floor(Math.random() * 256);
    var b = Math.floor(Math.random() * 256);
    return "rgb(" + r + ',' + g + ',' + b + ")";
}

var x;

function number() { // 这个函数的代码是获得一个0-9的数
    return Math.floor(Math.random() * 9);
}

function stop() {
    _Reset();
    clearInterval(x);
}



function star(){
    clearInterval(x);
    x  = setInterval(function () {star_a()}, 1000);
}

function star_a() {
    _Reset();
    for (var i = 0; i > -1 ; i++) {
        var a = number();
        var b = number();
        var c = number();
        if (a != b && b != c && c != a) {
            var f = document.getElementsByClassName("box");
            console.log(a,b,c);
            f[a].style = "background:" + bga();
            f[b].style = "background:" + bga();
            f[c].style = "background:" + bga();
            return;
        }
    }
}


function _Reset(){
    for (var o = 0; o < 9; o++) {
        var k = document.getElementsByClassName("box");
        k[o].style = "background:" + "#ccc;";
    }
}