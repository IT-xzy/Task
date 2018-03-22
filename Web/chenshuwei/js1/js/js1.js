
var square=document.getElementsByClassName("square");//获取9个正方节点
var start=document.getElementsByClassName('start');//获取开始按钮节点
var stop=document.getElementsByClassName('stop');//获取结束按钮节点
var timer;//一个定时器的名字
//洗牌算法，打乱数组并去除前三位数组成新数组
function radomItem() {
    var randomArr=[],
        temp,
        index;
    for(i=0;i<square.length;i++){
        randomArr[i]=i
    }
    for(i=0;i<square.length;i++){
        index=Math.floor(Math.random()*square.length);
        temp=randomArr[i];
        randomArr[i]=randomArr[index];
        randomArr[index]=temp;
    }
    return randomArr.slice(0,3)
}
//随机获取一个颜色
function randomColor() {
    return '#'+('00000'+(Math.random()*0x1000000<<0).toString(16)).slice(-6);
}
//遍历9宫格，把所有颜色重置，并封装成一个函数，等待调用
function resetColor() {
    for(i=0;i<square.length;i++){
        square[i].style.background='orange';
    }
}

start[0].addEventListener('click',function () {
    clickNum=1;
    timer=setInterval(function()
        {   var randomItem=radomItem();
            resetColor();
            for(var i=0;i<3;i++){
                square[randomItem[i]].style.background=randomColor();
            }
        }
        , 1000);
    start[0].disabled=true
},false);
stop[0].addEventListener('click',function () {
    resetColor();
    clearInterval(timer)
    start[0].disabled=false;
});



