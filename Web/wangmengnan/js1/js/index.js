function bg() {
    var r = Math.floor(Math.random() * 256);
    var g = Math.floor(Math.random() * 256);
    var b = Math.floor(Math.random() * 256);
    return "rgb(" + r + ',' + g + ',' + b + ")"; //随机颜色
}

function fanhui() {
    var oBox = document.getElementsByClassName('sbox');
    for (var k = 0; k < 9; k++) {
        oBox[k].style.backgroundColor = "#ffa500"; //颜色重置
    }


}



function change() {
    var oBox = document.getElementsByClassName('sbox'); //获取dom数组

    fanhui(); //调用颜色重置

    var arr = []; //定义一个数组
    for (var i = 0; i < 9; i++) {
        arr[i] = i; //传0~8 9个数
    }
    arr.sort(function () {
        return 0.5 - Math.random() //把数组打乱
    })
    var str = arr.join(); //放入数组
    //  alert(arr)
    var n = arr[0]; //取值
    var p = arr[3];
    var m = arr[6];


    oBox[n].style.backgroundColor = bg(); //随机盒子赋随机yanse
    oBox[p].style.backgroundColor = bg();
    oBox[m].style.backgroundColor = bg();
}



var startRun = null;

function start() {
    clearTimeout(startRun);
    startRun = setInterval(function () {
        change()
    }, 900);
}

function stop() {
    clearTimeout(startRun);
    fanhui();
}