//获取每个盒子
var box = document.getElementsByClassName('box');
console.log(box);
//每个都获取到了
var int;
//定义一个变量int

function start(){
    clearInterval(int);
    int = setInterval(select,1000)
}
//延时计时器
//取盒子器
function select(){
    orange();
    //开始之前返回初始化状态
    var x = 3;
    //最多从数组之中取出三个盒子
    var first = [];
    //定义一个空的数组用来存查出来的数据
    for(var a = 0; a < box.length; a++ ){
        first[a] = a;
        //将查处来的盒子放在first数组之中
    }
    //这是一个放入数据的办法.里面存了9个数字
    console.log(first);

    var second = [];
    //声明一个空的数组
    for(var b, j = 0 ; j < x ; j++){
        do{
            b = Math.floor(Math.random()*box.length);
            //随便的从box中
        }while(first[b]==null);
        first[b]=null;
        second[j]=box[b];
        console.log(second[j])
    }
    second[0].style.backgroundColor=color();
    second[1].style.backgroundColor=color();
    second[2].style.backgroundColor=color();
    //不停地调用color来取色 付给second中的盒子元素
}
    //取色器
function color() {
    var r = Math.floor(Math.random() * 256);
    var g = Math.floor(Math.random() * 256);
    var b = Math.floor(Math.random() * 256);
    return "rgb("+r+','+g+','+b+")";
    //返回颜色
}

//回复颜色器
function orange() {
    for(var i = 0; i < box.length; i++) {
        box[i].style.background = "rgb(237,152,14)";
    }
}

//全部停止器
function stop() {
    orange();
    //调用orange方法把所有盒子的颜色染回去.
    clearInterval(int);
}