//利用类名获取盒子的dom节点
var itme = document.getElementsByClassName("itme");
console.log(itme);
//获取rgb的随机颜色
function color(){
     r = Math.floor(Math.random()*255);
     g = Math.floor(Math.random()*255);
     b = Math.floor(Math.random()*255);
    rgb ="rgb("+r+","+g+","+b+")"
    console.log(rgb);
   return rgb;
}
//获取三个随机盒子
function box(){
     //当第一个盒子和第二个盒子相同的时候，或者第……，会重新获取三个盒子
     while(first == second || second == third || first==third){
        var first = Math.floor(Math.random()*9);
        var second =  Math.floor(Math.random()*9);
        var third =  Math.floor(Math.random()*9);
        console.log(first,second,third);
    }
    //判断三个盒子背景颜色是否重复，并给随机的三个盒子赋值上随机背景颜色rgb
    while(one == two || two == three || one==three){
     var one = itme[first].style.backgroundColor = color()
     var two = itme[second].style.backgroundColor = color()
     var three = itme[third].style.backgroundColor = color()
}
}
//开始
var time;
function start(){
    //清除定时器
    clearInterval(time);
    time = setInterval(function(){
        //每次获取随机颜色后恢复默认颜色
        for(var i=0; i<9; i++){
            itme[i].style.backgroundColor = "orange";
        }
        //调用赋值随机背景颜色的随机盒子
        box();
        //间隔1秒
    },1000)
    //禁用开始按钮
    document.getElementsByTagName("button")[0].disabled=true;
}
//结束
function end(){
    for(var i=0; i<9; i++){
            itme[i].style.backgroundColor = "orange";
    }
    clearInterval(time);
    //启用开始按钮
    document.getElementsByTagName("button")[0].disabled=false;
}