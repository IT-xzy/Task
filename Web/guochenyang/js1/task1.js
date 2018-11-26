//获取九宫格中的小格子DOM
//随机取得小格子中的3个格子
var int;
var box = document.getElementsByClassName("box");
function click() {
    for (var b=0;b<box.length;b++){
        box[b].style.backgroundColor = "#ff8c00";
    }
    var i = Math.floor(Math.random()*9);
    var x = Math.floor(Math.random()*9);
    var y = Math.floor(Math.random()*9);
//不许重复
    if (i!=x&i!=y&x!=y) {
        box[i].style.backgroundColor=color();
        box[x].style.backgroundColor=color();
        box[y].style.backgroundColor=color();
    }
    else{
        click();
    }
}
function start() {
    click();
    clearInterval(int);
    int=setInterval(click,1000);
}
function end() {
    clearInterval(int);
    for (var b=0;b<box.length;b++){
        box[b].style.backgroundColor = "#ff8c00";
    }
}

//随机生成RGB颜色
function color() {
    var rgb;
    var r = Math.floor(Math.random()*265); //随机生成256以内r值
    var g = Math.floor(Math.random()*265); //随机生成256以内g值
    var b = Math.floor(Math.random()*265); //随机生成256以内b值
    rgb = 'rgb('+r+','+g+','+b+')';
    return rgb;
}