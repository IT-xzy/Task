var bgone = document.querySelectorAll(".bg-one"); //获取小格子

//Fisher–Yates shuffle 洗牌算法
Array.prototype.shuffle = function () {
    var Sudoku=[] //创建一个新数组。用来推送随机数到第二个数组，推送后就删除，避免从复
    for(i=0;i<bgone.length;i++){
        Sudoku[i]=i
    }
    var arrNew  //创建第二个数组，用来保存生成的随机数
    for(i=0;i<bgone.length;i++){
        var rnd=Math.floor(Math.random()*bgone.length);  //获得随机数
        arrNew=Sudoku[i];
        Sudoku[i]=Sudoku[rnd];
        Sudoku[rnd]=arrNew;
    }
    return Sudoku.slice(0,3)  //删除推送过的随机数
}

var reset = function () {
    for (x = 0; x < bgone.length; x++) {
        bgone[x].style.backgroundColor = "#fea500";  //颜色回复初始状态
    }
}

var interaction = function () {
    // 随机三种颜色
    reset();   // 颜色回复初始状态
    var color = new Array();
    // 获得随机颜色(
    var getRandomColor = function () {
        return '#' + ('00000' + (Math.random() * 0x1000000 << 0).toString(16)).slice(-6);
    }
    for (i = 0; i < 3; i++) {
        color[i] = '#' + ('00000' + (Math.random() * 0x1000000 << 0).toString(16)).slice(-6);
    }
    //随机选取三个小方块
    var smallbox = [i].shuffle()
    for (i = 0; i < 3; i++) {
        bgone[smallbox[i]].style.backgroundColor = color[i];
    }
}

//点击按钮事件
var startbtn = document.getElementById("btn-one"); //获取开始按钮
var stopbtn = document.getElementById("btn-two"); //获取结束按钮
var timer //申明计时器

//开始事件
startbtn.onclick = function startClick() {
    clearInterval(timer);
    timer = setInterval("interaction()", 1000);
}
//停止事件
stopbtn.onclick = function stopClick() {
    clearInterval(timer);
    reset();
}
