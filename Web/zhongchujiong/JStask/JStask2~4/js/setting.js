var playerBox = [];            //玩家数组
//跳转到首页
function jumpIndex() {
  sessionStorage.clear();
  window.location.replace("index.html");
}

//跳转到查看身份页面
function lookStatus() {
  if (playerBox.length == inputPlayer.value) {
    $(".deal").fadeOut(500, function () {
      window.location.href = "lookStatus.html";
    });
  }
  else if (playerBox.length > 5) {
    alert("你刚才调整了人数，请重新点击设置身份！")
  }
  else {
    alert("请点击身份设置！");
  }
}

var inputPlayer = document.getElementById("shuRuPlayer");       //输入框的人数
var inputBlock = document.getElementById("nubCenter");          //滑块的人数

/*同步输入框、滑块*/
function inputChange() {
  if (inputPlayer.value < 6) {         //如果输入框人数小于6
    alert("人数为6到18！");
    inputPlayer.value = 6;
    inputBlock.value = 6;
  }
  else if (inputPlayer.value > 18) {      ////如果输入框人数大于18
    alert("人数为6到18！");
    inputPlayer.value = 18;
    inputBlock.value = 18;
  }
  else {
    inputBlock.value = inputPlayer.value;
  }
}

//点击滑块
function lighton() {
  inputPlayer.value = inputBlock.value;
}

//点击加号
function nubAdd() {
  inputPlayer.value++;
  if (inputPlayer.value > 18) {
    alert("坐不下了！");
    inputPlayer.value = 18;
  }
  else {
    inputBlock.value = inputPlayer.value;
  }
}

//点击减号
function nubCut() {
  inputPlayer.value--;
  if (inputPlayer.value < 6) {
    alert("人数太少了！开不了！");
    inputPlayer.value = 6;
  }
  else {
    inputBlock.value = inputPlayer.value;
  }
}


//将显示位置放进一个数组
var Box = ["p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "p17", "p18"];

//点击设置
function clickSet() {
  //清屏和重置数组
  newPlayer = [];
  Box.forEach(function (item) {
    document.getElementById(item).innerHTML = "";
  });

  var playernub = inputPlayer.value;      //玩家人数
  var killerNub;                          //杀手人数
  if (playernub >= 6 && playernub <= 8) {           //6到8
    killerNub = 2;
  }
  else if (playernub <= 11) {                       //9到11
    killerNub = 3;
  }
  else if (playernub <= 15) {                       //12到15
    killerNub = 4;
  }
  else if (playernub <= 18) {                       //16到18
    killerNub = 5;
  }

  (function () {
    //玩家的构造函数
    var Player = function (live,identity,number) {
      this.live = live;           //死活状态
      this.identity = identity;   //身份
      this.number = number;       //序号
    };
    //实例化玩家
    for(var i=0;i<playernub;i++){
      if(i<killerNub)
        playerBox[i]=new Player(1,'杀手',i);
      else
        playerBox[i]=new Player(1,'平民',i);
    }
  })();

  //洗牌算法打乱
  for (var i = playerBox.length - 1; i >= 0; i--) {
    var j = Math.floor(Math.random() * (i + 1));
    var faker = playerBox[j];
    playerBox[j] = playerBox[i];
    playerBox[i] = faker;
  }
  //输出到屏幕
  playerBox.forEach(function (item,index) {
    document.getElementById(Box[index]).innerHTML = item.identity + " 1 人";
  });
  //将玩家数组串行化成为JSON格式
  sessionStorage.playerBox = JSON.stringify(playerBox);
}

//查看身份
var playEr = JSON.parse(sessionStorage.playerBox);  //将玩家反串行化成数组
//正反面状态机
var playerCard = {
  state:'reverse',
  number:1,
  turnOverState:function () {
    switch(playerCard.state){
      case 'reverse':
        playerCard.state = 'front';
        turnFront();
        break;
      case 'front':
        playerCard.state = 'reverse';
        turnReverse();
        break;
    }
  }
};
//点击查看身份
$('.goToNext').click(function () {
  if(playerCard.number>playEr.length){      //展示完毕，跳转到法官日志
    window.location.href = "judgeLog.html";
  }else{                                    //否则继续翻转页面
    playerCard.turnOverState();
  }
});
//翻转页面--转到反面
function turnReverse() {
  $(".card_1").css('display','block');
  $(".card_2").css('display','none');
  $(".statusNumber").text(playerCard.number);
  $(".goToNext").text("查看" + playerCard.number + "号");
}
//翻转页面--转到正面
function turnFront() {
  $(".card_1").css('display', 'none');
  $(".card_2").css('display', 'block');
  $(".statusNumber").text(playerCard.number);
  $(".jiaose").text(playEr[playerCard.number-1].identity);   //改变角色
  playerCard.number++;
  if(playerCard.number>playEr.length){            //展示完毕
    $(".goToNext").text("查看法官日志");
  }
  else{
    $(".goToNext").text("隐藏并传递给" + playerCard.number + "号");
  }
}










