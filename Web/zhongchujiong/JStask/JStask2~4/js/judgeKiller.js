var playerBox=JSON.parse(sessionStorage.getItem('playerBox'));           //玩家数组
var deathPlayer=JSON.parse(sessionStorage.getItem("deathPlayer"));       //死亡玩家数组

//第一次进入时初始化
if(sessionStorage.getItem("pageState")==null){
  sessionStorage.setItem("pageState",0);
  var deathPlayer=[];                     //死亡玩家数组
  sessionStorage.setItem("deathPlayer",JSON.stringify(deathPlayer));
}
//把玩家打印到页面上
for(var i=0;i<=playerBox.length-1;i++){
  document.getElementsByClassName("number")[i].style.display="flex";
  document.getElementsByClassName("numberTop")[i].innerHTML=playerBox[i].identity;
  document.getElementsByClassName("numberBtm")[i].innerHTML=i+1+"号";
}
//将前面死过的人变色
  for(var i=0;i<=playerBox.length-1;i++){
    if(playerBox[i].live==0){
      $(".numberTop").eq(i).css("background","red");
    }
  }

//选中玩家变色
var clickNub;
var lastNub;
$(".gameIco").on("click",function () {
  clickNub = $(this).parents(".number").index();   //取得这个人的下标
  if(playerBox[clickNub].live!==0){
    $(".numberTop").eq(lastNub).css("background","#F5C97B");  //将上个选中的人还原颜色
    $(".numberTop").eq(clickNub).css("background","red"); //将这个人变颜色
    lastNub = clickNub;
  }else{
    alert('这个人已经挂了！');
  }
});
//处死并存进sessionStorage
function toDeath() {
  playerBox[clickNub].live=0;                  //处死
  deathPlayer.push(playerBox[clickNub]);      //增加死亡的数组
  sessionStorage.setItem("playerBox",JSON.stringify(playerBox));
  sessionStorage.setItem("deathPlayer",JSON.stringify(deathPlayer));
  sessionStorage.setItem("nowday",stepfsm.state);
}
//判断胜出者
function judge() {
  var killer = 0,    //活杀手
      people = 0,    //活平民
      result = null;
  playerBox.forEach(function (item) {
    if(item.live===1&&item.identity==='杀手'){
      killer++;
    }
    if(item.live===1&&item.identity==='平民'){
      people++;
    }
  });
  if(killer>=people){           //杀手胜出
    result = '杀手';
  }else if(killer===0){         //平民胜出
    result = '平民';
  }
  return result;
}
//按下确认键
$(".goToNext").on("click",function () {
  if(clickNub!==undefined){              //有选择玩家
    switch(sessionStorage.getItem("nowday")){           //判断是 杀手杀人or玩家投票
      case 'firstStep':                                 //杀手杀人页面
        if(playerBox[clickNub].identity !== '杀手'){
          stepfsm.state='secondStep';
          toDeath();
          window.location.href="gameStep.html";
        }else{
          alert('自己人，别开枪！');
        }
        break;
      case 'fourthlyStep':                               //玩家投票页面
        toDeath();
        var result = judge();
        if(result==='杀手'){                           //游戏结束，杀手胜出
          sessionStorage.setItem("winner","杀手");
          window.location.href="result.html";
        }else if(result==='平民'){                    //游戏结束，平民胜出
          sessionStorage.setItem("winner","平民");
          window.location.href="result.html";
        }
        else{                                         //游戏继续
          stepfsm.state='firstStep';
          sessionStorage.setItem("nowday",stepfsm.state);
          var day=sessionStorage.getItem("today");
          day++;
          sessionStorage.setItem("today",JSON.stringify(day));
          window.location.href="gameStep.html";
        }
        break;
    }
  }
  else{
    alert("请宰个人再走！");
  }
});
//跳转到首页
function goToIndex() {
  sessionStorage.clear();
  window.location.href = "index.html";
}
