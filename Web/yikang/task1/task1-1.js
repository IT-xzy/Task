var dodges;
//声明变量以便后面调用
var a=document.getElementsByClassName("a");
//获取a标签的节点
function buuton() {
    yellow();
    //调用定义好的颜色
   var m=[];
   //声明一个数组
    for (var i=0;i<3;i++) {
        var n = Math.floor(Math.random() * a.length);
        var b = Math.floor(Math.random() * a.length);
        var c = Math.floor(Math.random() * a.length);
        // console.log(m[i]);
        if(n!==b&&n!==c&&b!==c){
           break;
        }
    }
    a[n].style.background=getcolor();
    a[b].style.background=getcolor();
    a[c].style.background=getcolor();
    //遍历数组把选出来的盒子赋给M的第i个元素，随机盒子位置。
  // for (var w=0; w<m.length;w++){
  //       a[m[w]].style.background=getcolor();
  // }
  //赋给上面M选出来的盒子，颜色。
    //调用随机选出来的3个颜色。
}
function start() {
    clearInterval(dodges);
    dodges = setInterval(buuton,500);
}
function stop() {
    clearInterval(dodges);
    yellow();
}
function yellow() {
    for (var e=0;e<a.length;e++)
    a[e].style.background="yellow"
}
//重置a元素的颜色。
function getcolor() {
    var r=Math.floor(Math.random()*256);
    var g=Math.floor(Math.random()*256);
    var b=Math.floor(Math.random()*256);
    return "rgb("+ r +','+g +','+b+")";
}
//随机出来3个颜色。