//取出九个格子节点
var box=document.getElementsByClassName("box");
// 还原背景颜色
var i;
function clearColor(){
    for( i=0;i<box.length;i++){
        box[i].style.backgroundColor="#ffa600";
    }
}
//随机获取一个颜色
var r;
var g;
var b;
function arr(){
    r = Math.floor(Math.random()*256);
    g = Math.floor(Math.random()*256);
    b = Math.floor(Math.random()*256);
    //随机获取一种不等于橙色的颜色
    return "rgb(" + r + ',' + g + ',' + b + ')';
}
function color(){
     clearColor();//执行函数前先把颜色重置为背景颜色
    var num=[];
    var temp=[];
    for (var a = 0; a < 3; a++) {
        do {
            num[a] = Math.floor(Math.random() * box.length);
        } while (temp.indexOf(num[a]) >= 0);
        //检查数组中存不存在num[a]如果存在则循环
        temp.push(num[a]);
        //把（num[a]）放到一个空数组中去
    }
    box[num[0]].style.backgroundColor = arr();
    box[num[1]].style.backgroundColor = arr();
    box[num[2]].style.backgroundColor = arr();//分别把3个随机数给盒子数组，组成3个随机盒子，并把3个随机盒子分别改变颜色，并且颜色随机
}
var w;
function start(){
    clearInterval(w);
    w=setInterval("color()",1000);
}
function end(){
    clearInterval(w);
    clearColor();
}