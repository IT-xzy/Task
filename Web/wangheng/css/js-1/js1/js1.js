// 获取dom节点

var div1 = document.getElementsByClassName("box");
console.log(div1)

//全局变量
var time;

//随机三个格子
function lattice() {
    //变量提升(变量提升即将变量声明提升到它所在作用域的最开始的部分) 
    // var first; 
    // first = Math.floor(Math.random() * 9); 如下↓↓↓↓↓↓
    //—————————————————————————————————————————————————
    // console.log(first, second, third); // undefined
    // var first = Math.floor(Math.random() * 9);
    // var second = Math.floor(Math.random() * 9);
    // var third = Math.floor(Math.random() * 9);
 
    // console.log(first, second, third);


    //判断盒子是否重复

    while (first == second || second == third || first == third) {      
        var first = Math.floor(Math.random() * 9);       
        var second = Math.floor(Math.random() * 9);
        var third = Math.floor(Math.random() * 9);
    }//输出 var (first, second, third) = ？;
    console.log(first, second, third);


    //随机 first second  third三个数的颜色
    div1[first].style.backgroundColor = "rgb" + color()
    div1[second].style.backgroundColor = "rgb" + color()
    div1[third].style.backgroundColor = "rgb" + color()

    console.log(first, second, third);
}


// 随机颜色
function color() {
    var rgb;
    r = Math.floor(Math.random() * 255);
    g = Math.floor(Math.random() * 255);
    b = Math.floor(Math.random() * 255);
    rgb = "(" + r + " ," + g + "," + b + ")"
    console.log(rgb)
    return rgb;

}


//关联开始按钮

function start() {
    clearInterval(time); //清楚计时

    time = setInterval(function () {
        for (var i = 0; i < 9; i++) {
            div1[i].style.backgroundColor = "orange"; //循环重置所有盒子颜色为橙色
        }
        lattice(); //调用三个有颜色的格子
    }, 1000); //颜色变换时间1000毫秒
}

// 点击关闭按钮结束变换颜色
function halt() {
    clearInterval(time);
    for (var i = 0; i < 9; i++) {
        div1[i].style.backgroundColor = "orange";
    }

}