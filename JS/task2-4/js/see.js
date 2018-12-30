//获取发牌的数据
var playersArray = JSON.parse(sessionStorage.getItem("playersArray"));
console.log(playersArray);
// console.log(typeof playersArray);
var close = document.getElementsByClassName("right")[0];
close.onclick = function(){
  if(confirm("确定退出么")){
      location.href = ('homepage.html');
}
}
//获取计数节点
var count = document.getElementById("number");
//获取正面照片节点
var positive =document.getElementById("photo");
//获取背面照片节点
var back = document.getElementsByClassName("box_p")[0];
//获取描述玩家杀手的节点
var player = document.getElementById("player");
//获取按钮节点
var button = document.getElementsByTagName("button")[0];
//点击计数
var a = 0;
//按钮计数
var b = 2;
//角色计数
var c = 0; 
//按钮点击事件
button.onclick = function(){
 if(a % 1 == 0){
   //显示正面图
   positive.style.display = "none";
   //隐藏背面图
   back.style.display = "inline-block";
   //修改按钮样式
   button.innerHTML = ("隐藏并传递" + b + "号");
   //获取角色
   if(playersArray[c] == 0){
       player.innerHTML = "平民";
       c = c + 1;
   }else if(playersArray[c] == 1){
       player.innerHTML = "杀手";
       c = c + 1;
   }
   // console.log(player);
   a = a + 0.5;
   b = b + 1;
 }else if(a % 1 != 0){
     //声明查看的号码
     var number = b - 1;
     //隐藏正面图
     positive.style.display = "inline-block";
     //显示背面图
     back.style.display = "none";
     //按钮样式
     button.innerHTML = ("查看" + number + "号身份");
     //修改玩家的数量值
      count.innerText = b - 1;
      a = a + 0.5;
 }
   console.log(playersArray.length);
 //console.log(b);
 if(b > playersArray.length + 1){
     button.innerHTML = "查看法官日志"
 }
  console.log(a);
 if(a > playersArray.length - 0.5){
   location.href = ('journal.html');
   return;
 }
}