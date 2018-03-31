var playerBox=JSON.parse(sessionStorage.getItem("playerBox"));     //玩家数组
var deathPlayer=JSON.parse(sessionStorage.getItem("deathPlayer"));       //死亡玩家数组
var winner=sessionStorage.getItem("winner");                             //胜出方
var today=JSON.parse(sessionStorage.getItem("today"));       //天数

//将数据渲染到页面
for(var i=0;i<today;i++){
  var day=i+1;
  var nub=i*2;                   //单数是杀手杀人，双数是玩家投票
  var kill=++deathPlayer[nub].number;
  var vote=++deathPlayer[nub+1].number;
  $(".partEnd").append("<div class=\"part\">\n" +
    "     <div class=\"time\">\n" +
    "       <div class=\"container\">\n" +
    "         <div class=\"row\">\n" +
    "           <h3 class=\"colFour\">第"+day+"天</h3>\n" +
    "           <div class=\"colFou<!---->r time-1\">0小时07分</div>\n" +
    "         </div>\n" +
    "         <div class=\"row time-2\">晚上："+kill+"号被杀手杀死，"+kill+"号是水民</div>\n" +
    "         <div class=\"row time-2\">白天："+vote+"号被全民投票投死，"+vote+"号是"+deathPlayer[nub+1].identity+"</div>\n" +
    "       </div>\n" +
    "     </div>\n" +
    "   </div>");
}
//计算杀手平民人数
var killer=0;
var people;
for(var i=0;i<playerBox.length;i++){
  if(playerBox[i].identity=="杀 手"){
    killer++;
  }
}
people=playerBox.length-killer;
$(".shaShou").text(killer);
$(".pingMing").text(people);
$(".day").text(today-1);
$(".wodicenter").prepend(winner);       //将中间图标写上胜出者

//再来一局
function gotoindex1() {
  sessionStorage.clear();
  window.location.href="index.html";
}
//跳转到首页
function goToIndex() {
  sessionStorage.clear();
  window.location.href = "index.html";
}
