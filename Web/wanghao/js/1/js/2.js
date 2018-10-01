//定义变量box是所有的class名为box的div
var box = document.getElementsByClassName("box");
//console.log(box);

//定义定时器变量
var time;
 //定义随机数的数组
 var num = [];
 //定义随机颜色的数组
 var color = [];

//捕捉开始闪对象，并赋予点击事件
var open = document.getElementById("open");
open.addEventListener("click", $open);
// open函数清楚计时器，再赋予计时器
function $open() {
    //重置close的样式
    close.style.background = "#fff";
    close.style.color = "#fea600"
    //赋予点击样式
    this.style.background = "#fea600";
    this.style.color = "#fff";
    //清楚计时器
    clearInterval(time);
    // 赋予计时器
 time = setInterval(function () {
    numColor()
}, 1000);
}

//捕捉停止闪对象，并赋予点击事件
var close = document.getElementById("close");
close.addEventListener("click", $close);
// close函数清楚点击事件，并重置open对象的样式和box对象所有的背景颜色
function $close() {
    // 重置open的样式
    open.style.background = "#fff";
    open.style.color = "#fea600"
    // 改变close样式，赋予点击效果
    this.style.background = "#fea600";
    this.style.color = "#fff"
    clearInterval(time);
    // 重置背景颜色
    clearBackground();
}
// 重置box的背景颜色
function clearBackground() {
    for (let i = 0; i < 9; i++) {
        box[i].style.background = "#fea600";
    }
}


//编写定时器numcolor函数
function numColor() {
     //重置背景颜色
     clearBackground();
    //随机数生成的函数
     randomNum();
     //随机颜色生成3的函数
     randomColor(3);
    // // 讲随机颜色赋予随机数组的对象
     randomOut();
}

//随机数生成的函数
function randomNum(){
    for(let i=0;i<9;i++){
        num.push(i)
    }
    for (let i=0; i< num.length-1;i++){
        let randomX=Math.floor(Math.random()*(num.length-i-1))
        let randomValue =num[randomX];
        num[randomX]=num[num.length-i-1];
        num[num.length-i-1]=randomValue;
    }
    console.log(num)
}
  //随机颜色生成的函数
function  randomColor(a){
    // 生成a个随机颜色
    for(let i=0;i<a;){
        // 随机一个6位的十六进制颜色
       let change16=(Math.floor(Math.random()*(0xffffff+1))).toString(16);
    //   做一个判断如果6位16进制不满，退回本次循环
       if(change16.length<6){
        continue
      }
    //   如果满就输出push，然后i++ 
      else{
          let changColor="#"+change16
          color.push(changColor)
          i++;
          console.log(color)
      }    
}}
// 将随机颜色赋予随机数组
function  randomOut(){
    for (let i=0;i<3;i++){
        box[num[i]].style.background=color[i];
    }
    // 清空全局变量num和color数组
    num=[];
    color=[];
}

function log(a){
    return console.log(a);
}


