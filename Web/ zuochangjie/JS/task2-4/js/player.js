//声明玩家总数
var players;
//声明杀手变量和平民变量
var killer;
var civilian;
//获取input的value值
function getInput(){
    players= document.getElementById("players").value;
    if (players >= 4 && players <= 18) {
    
}
}
//用oninpu事件设定input的属性
document.getElementById("players").oninput = function(){
    var x = /\D/g; //定义正则，非数字规则
    this.value = this.value.replace(x,""); //为非数字时替换成空
}
//分配杀手和平民的数量
function distribution(){
   getInput();
   if(players > 18 || players <4){
       killer = " ";
       civilian = " ";
       return;
   }
   if(players >= 4 && players <6){
       killer = 1;
       civilian = players - killer;
   }
   else if(players >=6 && players <9){
       killer = 2;
       civilian = players - killer;
   }
   else if(players >= 9 && players <12){
       killer = 3;
       civilian = players - killer;
   }
   else if(players >= 12 && players < 16){
       killer = 4;
       civilian = players - killer;
   }
   else{
       killer = 5;
       civilian = players - killer;
   }
}
//声明玩家数组为空
var playersArray = [];
//生成一个有序数组
function makeArray(){
   for(x = 0 ; x < civilian; x++){
       for(y = 0 ; y < killer; y++){
           playersArray[y] = 1;
       }
       playersArray[killer + x] = 0;
   }
}
//数组乱序
function randomArray(){
   for(var i = playersArray.length; i > 0; i--){
       var number = Math.floor(Math.random()*i);
       var temp = playersArray[i-1];
       playersArray[i - 1] = playersArray[number];
       playersArray[number] = temp;
   }
}
//调用生成
function start(){
    //每次调用初始化变量值
   players = undefined; //玩家数量设置未定义
   playersArray = [];  //玩家数组设置为空
   distribution();
   document.getElementById("killer").innerHTML = killer;
   document.getElementById("civilian").innerHTML = civilian;
   if(players == undefined){
       return;
   }
   makeArray();
   randomArray();
   var temp = JSON.stringify(playersArray);
   console.log(temp);
   sessionStorage.setItem("playersArray",temp);
   //存储玩家数
   sessionStorage.setItem("players",players);
   //存储杀手数
   sessionStorage.setItem("killer",killer);
   //存储平民数
   sessionStorage.setItem("civilian",civilian);
}
//监听
document.addEventListener("input",function(){
   start();
})

//按钮判断效果
function change(){
   start();
   if(players >= 4 && players <= 18){
       location.href = "see.html";
   }else{
       confirm("请输入正确的数字");
   }
}