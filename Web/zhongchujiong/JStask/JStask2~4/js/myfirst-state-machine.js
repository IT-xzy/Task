var deathPlayer=JSON.parse(sessionStorage.getItem("deathPlayer"));       //将已经挂掉的玩家对象数组反串行化成数组
//第一次进入初始化页面
if(sessionStorage.getItem("nowday")==null){
  sessionStorage.setItem("nowday","firstStep");
}
var stepfsm={
  state:sessionStorage.getItem("nowday"),        //游戏步骤
  firstStep:function () {                       //杀手杀人步骤
    switch(stepfsm.state){
      case "firstStep":
        window.location.href="judgeKiller.html";
        break;
    }
  },
  secondStep:function () {                      //亡灵发言步骤
    switch(stepfsm.state){
      case "firstStep":
        alert("呐~刀拿好！请先杀人！");
        break;
      case "secondStep":
        alert("请亡灵发言！");
        stepfsm.state='thirdlyStep';
        sessionStorage.setItem("nowday",stepfsm.state);
        $(".flowBox").eq(0).css("background","#18758D");   //将点击过的步骤变颜色
        $(".flowBox").eq(1).css("background","#18758D");
        console.log(stepfsm.state);
        break;
    }
  },
  thirdlyStep:function () {                   //玩家发言步骤
    switch(stepfsm.state){
      case "firstStep":
        alert("呐~刀拿好！请先杀人！");
        break;
      case "secondStep":
        alert("请先亡灵说两句先！");
        break;
      case "thirdlyStep":
        alert("请玩家轮流发言！");
        stepfsm.state='fourthlyStep';
        sessionStorage.setItem("nowday",stepfsm.state);
        $(".flowBox").eq(0).css("background","#18758D");
        $(".flowBox").eq(1).css("background","#18758D");
        $(".flowBox").eq(2).css("background","#18758D");
        console.log(stepfsm.state);
        break;
    }
  },
  fourthlyStep:function () {             //投票步骤
    switch(stepfsm.state){
      case "firstStep":
        alert("呐~刀拿好！请先杀人！");
        break;
      case "secondStep":
        alert("请亡灵说两句先！");
        break;
      case "thirdlyStep":
        alert("请让玩家发完言先！");
        break;
      case "fourthlyStep":
        window.location.href="judgeKiller.html";
        break;
    }
  }
};

//渲染页面并展示过往数据
function renderState(nuber) {
  for(var i=0;i<=numer;i++){
    $(".flowBox").eq(nuber).css("background","#18758D");              //将点击过的步骤变颜色
  }
  $(".xingxi-1").css("display","block");                              //将杀人记录展示出来
  var deather=++deathPlayer.pop().number;
  $(".haoma").text(deather);
}

//判断前面哪个步骤
switch (sessionStorage.getItem("nowday")){
  case "secondStep":
    renderState(0);
    break;
  case "thirdlyStep":
    renderState(1);
    break;
  case "fourthlyStep":
    renderState(2);
    break;
}

