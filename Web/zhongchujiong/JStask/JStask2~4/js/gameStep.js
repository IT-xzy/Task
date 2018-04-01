var today = sessionStorage.getItem("today")||1;   //初始化天数
var deathPlayer=JSON.parse(sessionStorage.getItem("deathPlayer"));       //死亡的玩家
//跳转设置页面
function goToLog() {
  window.location.href = "judgeLog.html";
}
//跳转选择页面页面
function goToIndex() {
  sessionStorage.clear();
  window.location.href = "index.html";
}
//点击杀手杀人
$(".flowBox").eq(0).on("click",function () {
  stepfsm.firstStep();
});
//点击亡灵发言
$(".flowBox").eq(1).on("click",function () {
  stepfsm.secondStep();
});
//点击玩家发言
$(".flowBox").eq(2).on("click",function () {
  stepfsm.thirdlyStep();
});
//点击全民投票
$(".flowBox").eq(3).on("click",function () {
  stepfsm.fourthlyStep();
});
//点击结束游戏
$(".overGame").on("click",function () {
  sessionStorage.clear();
  window.location.href="index.html";
});
//查看法官日志
$(".toLog").on("click",function () {
  window.location.href="judgeLog.html";
});

for(var i=0;i<=today-1;i++){        //打印第几天
  var day = i+1;
  $(".tttt").append("<div class=\"kalendar\">\n" +
    "        <div>第"+day+"天</div>\n" +
    "        <div class=\"dayhide\">\n" +
    "            <p class=\"xingxi\"></p>\n" +
    "            <p class=\"xinxi-2\"></p>\n" +
    "        </div>\n" +
    "    </div>");
}
for(var i=0;i<today-1;i++){
  var nub=i*2;                   //单数是杀手杀人，双数是玩家投票
  var kill=deathPlayer[nub].number;
  kill++;
  var vote=deathPlayer[nub+1].number;
  vote++;

  $(".xingxi")[i].append(kill+"号被杀手干掉，其真实身份是平民");
  $(".xinxi-2")[i].append(vote+"号被投票投死了，其真实身份是"+deathPlayer[nub+1].identity);

  $(".kalendar").eq(i).on("click",function () {
    $(this).children(".dayhide").toggle(1000);
  });
}



